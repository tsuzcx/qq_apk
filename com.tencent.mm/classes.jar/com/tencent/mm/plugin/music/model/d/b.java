package com.tencent.mm.plugin.music.model.d;

import com.tencent.mm.sdk.platformtools.y;

public final class b
{
  public static int JD(String paramString)
  {
    if ("audio/3gpp".equalsIgnoreCase(paramString)) {
      return 1;
    }
    if ("audio/amr-wb".equalsIgnoreCase(paramString)) {
      return 2;
    }
    if (("audio/mpeg".equalsIgnoreCase(paramString)) || ("audio/mp3".equalsIgnoreCase(paramString))) {
      return 3;
    }
    if (("audio/mp4a-latm".equalsIgnoreCase(paramString)) || (paramString.startsWith("audio/mp4"))) {
      return 4;
    }
    if ("audio/qcelp".equalsIgnoreCase(paramString)) {
      return 5;
    }
    if ("audio/vorbis".equalsIgnoreCase(paramString)) {
      return 6;
    }
    if ("audio/opus".equalsIgnoreCase(paramString)) {
      return 7;
    }
    if ("audio/g711-alaw".equalsIgnoreCase(paramString)) {
      return 8;
    }
    if ("audio/g711-mlaw".equalsIgnoreCase(paramString)) {
      return 9;
    }
    if ("audio/raw".equalsIgnoreCase(paramString)) {
      return 10;
    }
    if ("audio/flac".equalsIgnoreCase(paramString)) {
      return 11;
    }
    if ("audio/gsm".equalsIgnoreCase(paramString)) {
      return 12;
    }
    if ("audio/ac3".equalsIgnoreCase(paramString)) {
      return 13;
    }
    if ("audio/eac3".equalsIgnoreCase(paramString)) {
      return 14;
    }
    if ("audio/x-ms-wma".equalsIgnoreCase(paramString)) {
      return 15;
    }
    if ("audio/x-wav".equalsIgnoreCase(paramString)) {
      return 16;
    }
    if (("audio/x-ape".equalsIgnoreCase(paramString)) || ("application/x-ape".equalsIgnoreCase(paramString))) {
      return 17;
    }
    return 0;
  }
  
  public static int uP(int paramInt)
  {
    y.i("MicroMsg.Music.MusicPlayIdKeyReport", "getQQMusicPlayerErrIdKey, errCode:" + paramInt);
    switch (paramInt)
    {
    default: 
      return 30;
    case 53: 
      return 17;
    case 54: 
      return 18;
    case 55: 
      return 19;
    case 62: 
      return 20;
    case 63: 
      return 21;
    case 64: 
      return 22;
    case 66: 
      return 23;
    case 67: 
      return 24;
    case 69: 
      return 25;
    case 70: 
      return 36;
    case 74: 
      return 26;
    case 80: 
      return 27;
    case 101: 
      return 28;
    case 102: 
      return 29;
    case 500: 
      return 31;
    case 501: 
      return 32;
    case 502: 
      return 33;
    case 503: 
      return 34;
    case 504: 
      return 35;
    case 700: 
      return 37;
    }
    return 38;
  }
  
  public static int uQ(int paramInt)
  {
    y.i("MicroMsg.Music.MusicPlayIdKeyReport", "getMusicPlayerErrIdKey, errCode:" + paramInt);
    switch (paramInt)
    {
    default: 
      return 189;
    case 700: 
      return 45;
    case 701: 
      return 48;
    case 702: 
      return 39;
    case 703: 
      return 40;
    case 704: 
      return 41;
    case 705: 
      return 42;
    case 706: 
      return 43;
    }
    return 44;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.d.b
 * JD-Core Version:    0.7.0.1
 */