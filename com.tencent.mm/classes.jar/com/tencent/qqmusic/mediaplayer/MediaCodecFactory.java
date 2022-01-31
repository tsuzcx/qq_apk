package com.tencent.qqmusic.mediaplayer;

import com.tencent.matrix.trace.core.AppMethodBeat;
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
  private static HashMap<AudioFormat.AudioType, Class<? extends IAudioRecognition>> mDecoderMap;
  private static ArrayList<AudioFormat.AudioType> mSupportAudioType;
  
  static
  {
    AppMethodBeat.i(128466);
    mDecoderMap = new HashMap();
    mSupportAudioType = new ArrayList();
    registerDecoder(AudioFormat.AudioType.M4A, FfmpegRecognition.class);
    registerDecoder(AudioFormat.AudioType.OGG, VorbisRecognition.class);
    registerDecoder(AudioFormat.AudioType.FLAC, FLACRecognition.class);
    registerDecoder(AudioFormat.AudioType.MP3, MP3Recognition.class);
    registerDecoder(AudioFormat.AudioType.APE, ApeRecognition.class);
    registerDecoder(AudioFormat.AudioType.WAV, WavRecognition.class);
    registerDecoder(AudioFormat.AudioType.WMA, WmaRecognition.class);
    registerDecoder(AudioFormat.AudioType.MP4, FfmpegRecognition.class);
    registerDecoder(AudioFormat.AudioType.AAC, FfmpegRecognition.class);
    AppMethodBeat.o(128466);
  }
  
  static IAudioRecognition createDecoderByType(AudioFormat.AudioType paramAudioType)
  {
    AppMethodBeat.i(128464);
    if (!AudioFormat.isAudioType(paramAudioType))
    {
      AppMethodBeat.o(128464);
      return null;
    }
    if (mDecoderMap.containsKey(paramAudioType)) {}
    for (;;)
    {
      try
      {
        paramAudioType = (IAudioRecognition)((Class)mDecoderMap.get(paramAudioType)).newInstance();
        AppMethodBeat.o(128464);
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
    AppMethodBeat.i(128465);
    ArrayList localArrayList = new ArrayList(mSupportAudioType);
    AppMethodBeat.o(128465);
    return localArrayList;
  }
  
  private static void registerDecoder(AudioFormat.AudioType paramAudioType, Class<? extends IAudioRecognition> paramClass)
  {
    AppMethodBeat.i(128462);
    mDecoderMap.put(paramAudioType, paramClass);
    mSupportAudioType.add(paramAudioType);
    AppMethodBeat.o(128462);
  }
  
  public static void unRegisterDecoder(AudioFormat.AudioType paramAudioType)
  {
    AppMethodBeat.i(128463);
    mSupportAudioType.remove(paramAudioType);
    mDecoderMap.remove(paramAudioType);
    AppMethodBeat.o(128463);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.MediaCodecFactory
 * JD-Core Version:    0.7.0.1
 */