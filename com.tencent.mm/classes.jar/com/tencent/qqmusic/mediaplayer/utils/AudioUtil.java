package com.tencent.qqmusic.mediaplayer.utils;

import android.media.AudioTrack;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(76599);
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
    AppMethodBeat.o(76599);
    return j;
  }
  
  public static int getDecodeBufferSizeForPlay(NativeDecoder paramNativeDecoder)
  {
    int m = 12;
    int j = 2;
    AppMethodBeat.i(76600);
    int k = getDecodeBufferSize(paramNativeDecoder);
    paramNativeDecoder = paramNativeDecoder.getAudioInformation();
    int i;
    if ((paramNativeDecoder == null) || (paramNativeDecoder.getAudioType() == AudioFormat.AudioType.FLAC))
    {
      i = k;
      AppMethodBeat.o(76600);
      return i;
    }
    int n = paramNativeDecoder.getChannels();
    if (n == 1) {
      i = 4;
    }
    for (;;)
    {
      if (paramNativeDecoder.getBitDepth() == 1) {
        j = 3;
      }
      i = Math.max(AudioTrack.getMinBufferSize((int)paramNativeDecoder.getSampleRate(), i, j), k);
      break;
      i = m;
      if (n != 2) {
        if (n == 6)
        {
          i = 252;
        }
        else
        {
          i = m;
          if (n == 8) {
            i = 1020;
          }
        }
      }
    }
  }
  
  public static NativeDecoder getDecoder(String paramString, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(76602);
    if (paramBoolean)
    {
      paramString = getDecoderFromTrack(paramString, paramLong1, paramLong2);
      AppMethodBeat.o(76602);
      return paramString;
    }
    paramString = AudioRecognition.getDecoderFormFile(paramString);
    AppMethodBeat.o(76602);
    return paramString;
  }
  
  public static NativeDecoder getDecoderFromTrack(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(76601);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(76601);
      return null;
    }
    if (paramLong1 >= paramLong2)
    {
      AppMethodBeat.o(76601);
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
        AppMethodBeat.o(76601);
        return null;
      }
      paramLong2 = new NativeSeekTable(localNativeDecoder).seek(paramLong2);
      if (paramLong2 <= 0L)
      {
        Logger.e("AudioUtil", "endPos from track <= 0");
        AppMethodBeat.o(76601);
        return null;
      }
      paramString.setEndBytePosition(paramLong2);
      localNativeDecoder.seekTo((int)paramLong1);
      AppMethodBeat.o(76601);
      return localNativeDecoder;
    }
    catch (Exception paramString)
    {
      Logger.e("AudioUtil", paramString);
      AppMethodBeat.o(76601);
    }
    return null;
  }
  
  public static int getPlaybackHeadPositionSafely(AudioTrack paramAudioTrack)
  {
    AppMethodBeat.i(76603);
    int j = 0;
    int i = j;
    if (paramAudioTrack != null) {}
    try
    {
      i = paramAudioTrack.getPlaybackHeadPosition();
      AppMethodBeat.o(76603);
      return i;
    }
    catch (Exception paramAudioTrack)
    {
      for (;;)
      {
        Logger.e("AudioUtil", "getPlaybackHeadPositionSafely", paramAudioTrack);
        i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.utils.AudioUtil
 * JD-Core Version:    0.7.0.1
 */