package com.tencent.qqmusic.mediaplayer;

import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;
import com.tencent.qqmusic.mediaplayer.codec.ape.ApeRecognition;
import com.tencent.qqmusic.mediaplayer.codec.ffmpeg.FfmpegRecognition;
import com.tencent.qqmusic.mediaplayer.codec.flac.FLACRecognition;
import com.tencent.qqmusic.mediaplayer.codec.mp3.MP3Recognition;
import com.tencent.qqmusic.mediaplayer.codec.ogg.VorbisRecognition;
import com.tencent.qqmusic.mediaplayer.codec.wav.WavRecognition;
import com.tencent.qqmusic.mediaplayer.codec.wma.WmaRecognition;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class MediaCodecFactory
{
  private static final String TAG = "MediaCodecFactory";
  private static HashMap<AudioFormat.AudioType, Class<? extends IAudioRecognition>> mDecoderMap = new HashMap();
  private static ArrayList<AudioFormat.AudioType> mSupportAudioType = new ArrayList();
  
  static
  {
    registerDecoder(AudioFormat.AudioType.M4A, FfmpegRecognition.class);
    registerDecoder(AudioFormat.AudioType.OGG, VorbisRecognition.class);
    registerDecoder(AudioFormat.AudioType.FLAC, FLACRecognition.class);
    registerDecoder(AudioFormat.AudioType.MP3, MP3Recognition.class);
    registerDecoder(AudioFormat.AudioType.APE, ApeRecognition.class);
    registerDecoder(AudioFormat.AudioType.WAV, WavRecognition.class);
    registerDecoder(AudioFormat.AudioType.WMA, WmaRecognition.class);
    registerDecoder(AudioFormat.AudioType.MP4, FfmpegRecognition.class);
    registerDecoder(AudioFormat.AudioType.AAC, FfmpegRecognition.class);
  }
  
  static IAudioRecognition createDecoderByType(AudioFormat.AudioType paramAudioType)
  {
    if (!AudioFormat.isAudioType(paramAudioType)) {
      return null;
    }
    if (mDecoderMap.containsKey(paramAudioType)) {}
    for (;;)
    {
      try
      {
        paramAudioType = (IAudioRecognition)((Class)mDecoderMap.get(paramAudioType)).newInstance();
        return paramAudioType;
      }
      catch (Throwable paramAudioType)
      {
        Logger.e("MediaCodecFactory", "createDecoderByType error", paramAudioType);
      }
      paramAudioType = null;
    }
  }
  
  public static ArrayList<AudioFormat.AudioType> getSupportAudioType()
  {
    return new ArrayList(mSupportAudioType);
  }
  
  private static void registerDecoder(AudioFormat.AudioType paramAudioType, Class<? extends IAudioRecognition> paramClass)
  {
    mDecoderMap.put(paramAudioType, paramClass);
    mSupportAudioType.add(paramAudioType);
  }
  
  public static void unRegisterDecoder(AudioFormat.AudioType paramAudioType)
  {
    mSupportAudioType.remove(paramAudioType);
    mDecoderMap.remove(paramAudioType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.MediaCodecFactory
 * JD-Core Version:    0.7.0.1
 */