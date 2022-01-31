package com.tencent.qqmusic.mediaplayer.utils;

import android.media.AudioTrack;
import android.text.TextUtils;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.AudioRecognition;
import com.tencent.qqmusic.mediaplayer.audioplaylist.AudioPlayListItemInfo;
import com.tencent.qqmusic.mediaplayer.audioplaylist.TrackInfo;
import com.tencent.qqmusic.mediaplayer.codec.NativeDecoder;
import com.tencent.qqmusic.mediaplayer.seektable.NativeSeekTable;
import com.tencent.qqmusic.mediaplayer.upstream.TrackDataSource;
import com.tencent.qqmusic.mediaplayer.util.Logger;

public class AudioUtil
{
  private static final int DEFAULT_DECODE_BUFFER_SIZE = 8192;
  private static final String TAG = "AudioUtil";
  
  public static int getDecodeBufferSize(NativeDecoder paramNativeDecoder)
  {
    AudioInformation localAudioInformation = paramNativeDecoder.getAudioInformation();
    int j = 0;
    int i = j;
    if (localAudioInformation != null)
    {
      i = j;
      if (localAudioInformation.getAudioType() == AudioFormat.AudioType.FLAC) {
        i = (int)paramNativeDecoder.getMinBufferSize();
      }
    }
    j = i;
    if (i <= 0) {
      j = 8192;
    }
    return j;
  }
  
  public static int getDecodeBufferSizeForPlay(NativeDecoder paramNativeDecoder)
  {
    int k = 12;
    int j = 2;
    int m = getDecodeBufferSize(paramNativeDecoder);
    paramNativeDecoder = paramNativeDecoder.getAudioInformation();
    if ((paramNativeDecoder == null) || (paramNativeDecoder.getAudioType() == AudioFormat.AudioType.FLAC)) {
      return m;
    }
    int n = paramNativeDecoder.getChannels();
    int i;
    if (n == 1) {
      i = 4;
    }
    for (;;)
    {
      if (paramNativeDecoder.getBitDept() == 1) {
        j = 3;
      }
      return Math.max(AudioTrack.getMinBufferSize((int)paramNativeDecoder.getSampleRate(), i, j), m);
      i = k;
      if (n != 2) {
        if (n == 6)
        {
          i = 252;
        }
        else
        {
          i = k;
          if (n == 8) {
            i = 1020;
          }
        }
      }
    }
  }
  
  public static NativeDecoder getDecoder(String paramString, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    if (paramBoolean) {
      return AudioRecognition.getDecoderFormFile(paramString);
    }
    return getDecoderFromTrack(paramString, paramLong1, paramLong2);
  }
  
  public static NativeDecoder getDecoderFromTrack(String paramString, long paramLong1, long paramLong2)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (paramLong1 >= paramLong2) {
      return null;
    }
    NativeDecoder localNativeDecoder = new NativeDecoder();
    TrackInfo localTrackInfo = new TrackInfo(AudioPlayListItemInfo.TYPE_CUE);
    localTrackInfo.setFilePath(paramString);
    localTrackInfo.setStartPosition(paramLong1);
    localTrackInfo.setEndPostion(paramLong2);
    try
    {
      paramString = new TrackDataSource(localTrackInfo);
      if (localNativeDecoder.init(paramString) != 0)
      {
        Logger.e("AudioUtil", "init decoder from track failed!");
        return null;
      }
    }
    catch (Exception paramString)
    {
      Logger.e("AudioUtil", paramString);
      return null;
    }
    paramLong2 = new NativeSeekTable(localNativeDecoder).seek(paramLong2);
    if (paramLong2 <= 0L)
    {
      Logger.e("AudioUtil", "endPos from track <= 0");
      return null;
    }
    paramString.setEndBytePosition(paramLong2);
    localNativeDecoder.seekTo((int)paramLong1);
    return localNativeDecoder;
  }
  
  public static int getPlaybackHeadPositionSafely(AudioTrack paramAudioTrack)
  {
    int i = 0;
    if (paramAudioTrack != null) {}
    try
    {
      i = paramAudioTrack.getPlaybackHeadPosition();
      return i;
    }
    catch (Exception paramAudioTrack)
    {
      Logger.e("AudioUtil", "getPlaybackHeadPositionSafely", paramAudioTrack);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.utils.AudioUtil
 * JD-Core Version:    0.7.0.1
 */