package com.tencent.mm.plugin.music.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
{
  public static int ST(int paramInt)
  {
    AppMethodBeat.i(63138);
    Log.i("MicroMsg.Music.MusicPlayIdKeyReport", "getQQMusicPlayerErrIdKey, errCode:".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(63138);
      return 30;
    case 53: 
      AppMethodBeat.o(63138);
      return 17;
    case 54: 
      AppMethodBeat.o(63138);
      return 18;
    case 55: 
      AppMethodBeat.o(63138);
      return 19;
    case 62: 
      AppMethodBeat.o(63138);
      return 20;
    case 63: 
      AppMethodBeat.o(63138);
      return 21;
    case 64: 
      AppMethodBeat.o(63138);
      return 22;
    case 66: 
      AppMethodBeat.o(63138);
      return 23;
    case 67: 
      AppMethodBeat.o(63138);
      return 24;
    case 69: 
      AppMethodBeat.o(63138);
      return 25;
    case 70: 
      AppMethodBeat.o(63138);
      return 36;
    case 74: 
      AppMethodBeat.o(63138);
      return 26;
    case 80: 
      AppMethodBeat.o(63138);
      return 27;
    case 101: 
      AppMethodBeat.o(63138);
      return 28;
    case 102: 
      AppMethodBeat.o(63138);
      return 29;
    case 500: 
      AppMethodBeat.o(63138);
      return 31;
    case 501: 
      AppMethodBeat.o(63138);
      return 32;
    case 502: 
      AppMethodBeat.o(63138);
      return 33;
    case 503: 
      AppMethodBeat.o(63138);
      return 34;
    case 504: 
      AppMethodBeat.o(63138);
      return 35;
    case 700: 
      AppMethodBeat.o(63138);
      return 37;
    }
    AppMethodBeat.o(63138);
    return 38;
  }
  
  public static int SU(int paramInt)
  {
    AppMethodBeat.i(63139);
    Log.i("MicroMsg.Music.MusicPlayIdKeyReport", "getMusicPlayerErrIdKey, errCode:".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(63139);
      return 189;
    case 700: 
      AppMethodBeat.o(63139);
      return 45;
    case 701: 
      AppMethodBeat.o(63139);
      return 48;
    case 702: 
      AppMethodBeat.o(63139);
      return 39;
    case 703: 
      AppMethodBeat.o(63139);
      return 40;
    case 704: 
      AppMethodBeat.o(63139);
      return 41;
    case 705: 
      AppMethodBeat.o(63139);
      return 42;
    case 706: 
      AppMethodBeat.o(63139);
      return 43;
    }
    AppMethodBeat.o(63139);
    return 44;
  }
  
  public static int SV(int paramInt)
  {
    AppMethodBeat.i(63140);
    Log.i("MicroMsg.Music.MusicPlayIdKeyReport", "getMusicPlayerSumidKeyByMusicType, musicType:".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    case 2: 
    case 3: 
    default: 
      AppMethodBeat.o(63140);
      return 113;
    case 0: 
      AppMethodBeat.o(63140);
      return 105;
    case 1: 
      AppMethodBeat.o(63140);
      return 106;
    case 4: 
      AppMethodBeat.o(63140);
      return 107;
    case 5: 
      AppMethodBeat.o(63140);
      return 108;
    case 6: 
      AppMethodBeat.o(63140);
      return 109;
    case 7: 
      AppMethodBeat.o(63140);
      return 110;
    case 8: 
      AppMethodBeat.o(63140);
      return 111;
    }
    AppMethodBeat.o(63140);
    return 112;
  }
  
  public static int SW(int paramInt)
  {
    AppMethodBeat.i(63141);
    Log.i("MicroMsg.Music.MusicPlayIdKeyReport", "getQQMusicPlayerSumidKeyByMusicType, musicType:".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    case 2: 
    case 3: 
    default: 
      AppMethodBeat.o(63141);
      return 127;
    case 0: 
      AppMethodBeat.o(63141);
      return 117;
    case 1: 
      AppMethodBeat.o(63141);
      return 118;
    case 4: 
      AppMethodBeat.o(63141);
      return 119;
    case 5: 
      AppMethodBeat.o(63141);
      return 120;
    case 6: 
      AppMethodBeat.o(63141);
      return 121;
    case 7: 
      AppMethodBeat.o(63141);
      return 122;
    case 8: 
      AppMethodBeat.o(63141);
      return 123;
    case 9: 
      AppMethodBeat.o(63141);
      return 124;
    case 10: 
      AppMethodBeat.o(63141);
      return 125;
    }
    AppMethodBeat.o(63141);
    return 126;
  }
  
  public static int aHV(String paramString)
  {
    AppMethodBeat.i(63142);
    if ("audio/3gpp".equalsIgnoreCase(paramString))
    {
      AppMethodBeat.o(63142);
      return 1;
    }
    if ("audio/amr-wb".equalsIgnoreCase(paramString))
    {
      AppMethodBeat.o(63142);
      return 2;
    }
    if (("audio/mpeg".equalsIgnoreCase(paramString)) || ("audio/mp3".equalsIgnoreCase(paramString)))
    {
      AppMethodBeat.o(63142);
      return 3;
    }
    if (("audio/mp4a-latm".equalsIgnoreCase(paramString)) || (paramString.startsWith("audio/mp4")))
    {
      AppMethodBeat.o(63142);
      return 4;
    }
    if ("audio/qcelp".equalsIgnoreCase(paramString))
    {
      AppMethodBeat.o(63142);
      return 5;
    }
    if ("audio/vorbis".equalsIgnoreCase(paramString))
    {
      AppMethodBeat.o(63142);
      return 6;
    }
    if ("audio/opus".equalsIgnoreCase(paramString))
    {
      AppMethodBeat.o(63142);
      return 7;
    }
    if ("audio/g711-alaw".equalsIgnoreCase(paramString))
    {
      AppMethodBeat.o(63142);
      return 8;
    }
    if ("audio/g711-mlaw".equalsIgnoreCase(paramString))
    {
      AppMethodBeat.o(63142);
      return 9;
    }
    if ("audio/raw".equalsIgnoreCase(paramString))
    {
      AppMethodBeat.o(63142);
      return 10;
    }
    if ("audio/flac".equalsIgnoreCase(paramString))
    {
      AppMethodBeat.o(63142);
      return 11;
    }
    if ("audio/gsm".equalsIgnoreCase(paramString))
    {
      AppMethodBeat.o(63142);
      return 12;
    }
    if ("audio/ac3".equalsIgnoreCase(paramString))
    {
      AppMethodBeat.o(63142);
      return 13;
    }
    if ("audio/eac3".equalsIgnoreCase(paramString))
    {
      AppMethodBeat.o(63142);
      return 14;
    }
    if ("audio/x-ms-wma".equalsIgnoreCase(paramString))
    {
      AppMethodBeat.o(63142);
      return 15;
    }
    if ("audio/x-wav".equalsIgnoreCase(paramString))
    {
      AppMethodBeat.o(63142);
      return 16;
    }
    if (("audio/x-ape".equalsIgnoreCase(paramString)) || ("application/x-ape".equalsIgnoreCase(paramString)))
    {
      AppMethodBeat.o(63142);
      return 17;
    }
    AppMethodBeat.o(63142);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.d.c
 * JD-Core Version:    0.7.0.1
 */