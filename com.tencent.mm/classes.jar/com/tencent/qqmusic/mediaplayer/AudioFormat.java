package com.tencent.qqmusic.mediaplayer;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class AudioFormat
{
  private static final String EXTENSION_AAC = "aac";
  private static final String EXTENSION_AMR = "amr";
  private static final String EXTENSION_APE = "ape";
  private static final String EXTENSION_FLAC = "flac";
  private static final String EXTENSION_M4A = "m4a";
  private static final String EXTENSION_MP3 = "mp3";
  private static final String EXTENSION_MP4 = "mp4";
  private static final String EXTENSION_OGG = "ogg";
  private static final String EXTENSION_WAV = "wav";
  private static final String EXTENSION_WMA = "wma";
  private static final int VALUE_AAC = 11;
  private static final int VALUE_AMR = 6;
  private static final int VALUE_APE = 5;
  private static final int VALUE_FLAC = 2;
  private static final int VALUE_M4A = 3;
  private static final int VALUE_MP3 = 9;
  private static final int VALUE_MP4 = 10;
  private static final int VALUE_OGG = 4;
  private static final int VALUE_UNSUPPORT = 1;
  private static final int VALUE_WAV = 8;
  private static final int VALUE_WMA = 7;
  
  public static AudioType getAudioType(int paramInt)
  {
    AppMethodBeat.i(87749);
    Object localObject = AudioType.values();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      AudioType localAudioType = localObject[i];
      if (localAudioType.value == paramInt)
      {
        AppMethodBeat.o(87749);
        return localAudioType;
      }
      i += 1;
    }
    localObject = AudioType.UNSUPPORT;
    AppMethodBeat.o(87749);
    return localObject;
  }
  
  public static boolean isAudioType(AudioType paramAudioType)
  {
    AppMethodBeat.i(87748);
    if ((paramAudioType != null) && (!AudioType.UNSUPPORT.equals(paramAudioType)))
    {
      AppMethodBeat.o(87748);
      return true;
    }
    AppMethodBeat.o(87748);
    return false;
  }
  
  public static enum AudioType
  {
    private String extension;
    private int value = 0;
    
    static
    {
      AppMethodBeat.i(87757);
      UNSUPPORT = new AudioType("UNSUPPORT", 0, 1, "Unknown");
      MP3 = new AudioType("MP3", 1, 9, "mp3");
      OGG = new AudioType("OGG", 2, 4, "ogg");
      M4A = new AudioType("M4A", 3, 3, "m4a");
      FLAC = new AudioType("FLAC", 4, 2, "flac");
      APE = new AudioType("APE", 5, 5, "ape");
      WAV = new AudioType("WAV", 6, 8, "wav");
      WMA = new AudioType("WMA", 7, 7, "wma");
      AMR = new AudioType("AMR", 8, 6, "amr");
      MP4 = new AudioType("MP4", 9, 10, "mp4");
      AAC = new AudioType("AAC", 10, 11, "aac");
      $VALUES = new AudioType[] { UNSUPPORT, MP3, OGG, M4A, FLAC, APE, WAV, WMA, AMR, MP4, AAC };
      AppMethodBeat.o(87757);
    }
    
    private AudioType(int paramInt, String paramString)
    {
      this.value = paramInt;
      this.extension = paramString;
    }
    
    public final String getExtension()
    {
      return this.extension;
    }
    
    public final int getValue()
    {
      return this.value;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.AudioFormat
 * JD-Core Version:    0.7.0.1
 */