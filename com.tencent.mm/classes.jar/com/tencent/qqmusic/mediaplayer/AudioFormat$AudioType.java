package com.tencent.qqmusic.mediaplayer;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum AudioFormat$AudioType
{
  private String extension;
  private int value = 0;
  
  static
  {
    AppMethodBeat.i(105512);
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
    AppMethodBeat.o(105512);
  }
  
  private AudioFormat$AudioType(int paramInt, String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType
 * JD-Core Version:    0.7.0.1
 */