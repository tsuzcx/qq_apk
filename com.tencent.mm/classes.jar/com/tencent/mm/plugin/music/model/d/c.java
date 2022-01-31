package com.tencent.mm.plugin.music.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class c
{
  public static int An(int paramInt)
  {
    AppMethodBeat.i(105007);
    ab.i("MicroMsg.Music.MusicPlayIdKeyReport", "getQQMusicPlayerErrIdKey, errCode:".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(105007);
      return 30;
    case 53: 
      AppMethodBeat.o(105007);
      return 17;
    case 54: 
      AppMethodBeat.o(105007);
      return 18;
    case 55: 
      AppMethodBeat.o(105007);
      return 19;
    case 62: 
      AppMethodBeat.o(105007);
      return 20;
    case 63: 
      AppMethodBeat.o(105007);
      return 21;
    case 64: 
      AppMethodBeat.o(105007);
      return 22;
    case 66: 
      AppMethodBeat.o(105007);
      return 23;
    case 67: 
      AppMethodBeat.o(105007);
      return 24;
    case 69: 
      AppMethodBeat.o(105007);
      return 25;
    case 70: 
      AppMethodBeat.o(105007);
      return 36;
    case 74: 
      AppMethodBeat.o(105007);
      return 26;
    case 80: 
      AppMethodBeat.o(105007);
      return 27;
    case 101: 
      AppMethodBeat.o(105007);
      return 28;
    case 102: 
      AppMethodBeat.o(105007);
      return 29;
    case 500: 
      AppMethodBeat.o(105007);
      return 31;
    case 501: 
      AppMethodBeat.o(105007);
      return 32;
    case 502: 
      AppMethodBeat.o(105007);
      return 33;
    case 503: 
      AppMethodBeat.o(105007);
      return 34;
    case 504: 
      AppMethodBeat.o(105007);
      return 35;
    case 700: 
      AppMethodBeat.o(105007);
      return 37;
    }
    AppMethodBeat.o(105007);
    return 38;
  }
  
  public static int Ao(int paramInt)
  {
    AppMethodBeat.i(105008);
    ab.i("MicroMsg.Music.MusicPlayIdKeyReport", "getMusicPlayerErrIdKey, errCode:".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(105008);
      return 189;
    case 700: 
      AppMethodBeat.o(105008);
      return 45;
    case 701: 
      AppMethodBeat.o(105008);
      return 48;
    case 702: 
      AppMethodBeat.o(105008);
      return 39;
    case 703: 
      AppMethodBeat.o(105008);
      return 40;
    case 704: 
      AppMethodBeat.o(105008);
      return 41;
    case 705: 
      AppMethodBeat.o(105008);
      return 42;
    case 706: 
      AppMethodBeat.o(105008);
      return 43;
    }
    AppMethodBeat.o(105008);
    return 44;
  }
  
  public static int Ap(int paramInt)
  {
    AppMethodBeat.i(151915);
    ab.i("MicroMsg.Music.MusicPlayIdKeyReport", "getMusicPlayerSumidKeyByMusicType, musicType:".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    case 2: 
    case 3: 
    default: 
      AppMethodBeat.o(151915);
      return 113;
    case 0: 
      AppMethodBeat.o(151915);
      return 105;
    case 1: 
      AppMethodBeat.o(151915);
      return 106;
    case 4: 
      AppMethodBeat.o(151915);
      return 107;
    case 5: 
      AppMethodBeat.o(151915);
      return 108;
    case 6: 
      AppMethodBeat.o(151915);
      return 109;
    case 7: 
      AppMethodBeat.o(151915);
      return 110;
    case 8: 
      AppMethodBeat.o(151915);
      return 111;
    }
    AppMethodBeat.o(151915);
    return 112;
  }
  
  public static int Aq(int paramInt)
  {
    AppMethodBeat.i(151916);
    ab.i("MicroMsg.Music.MusicPlayIdKeyReport", "getQQMusicPlayerSumidKeyByMusicType, musicType:".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    case 2: 
    case 3: 
    default: 
      AppMethodBeat.o(151916);
      return 127;
    case 0: 
      AppMethodBeat.o(151916);
      return 117;
    case 1: 
      AppMethodBeat.o(151916);
      return 118;
    case 4: 
      AppMethodBeat.o(151916);
      return 119;
    case 5: 
      AppMethodBeat.o(151916);
      return 120;
    case 6: 
      AppMethodBeat.o(151916);
      return 121;
    case 7: 
      AppMethodBeat.o(151916);
      return 122;
    case 8: 
      AppMethodBeat.o(151916);
      return 123;
    case 9: 
      AppMethodBeat.o(151916);
      return 124;
    case 10: 
      AppMethodBeat.o(151916);
      return 125;
    }
    AppMethodBeat.o(151916);
    return 126;
  }
  
  public static int VB(String paramString)
  {
    AppMethodBeat.i(105009);
    if ("audio/3gpp".equalsIgnoreCase(paramString))
    {
      AppMethodBeat.o(105009);
      return 1;
    }
    if ("audio/amr-wb".equalsIgnoreCase(paramString))
    {
      AppMethodBeat.o(105009);
      return 2;
    }
    if (("audio/mpeg".equalsIgnoreCase(paramString)) || ("audio/mp3".equalsIgnoreCase(paramString)))
    {
      AppMethodBeat.o(105009);
      return 3;
    }
    if (("audio/mp4a-latm".equalsIgnoreCase(paramString)) || (paramString.startsWith("audio/mp4")))
    {
      AppMethodBeat.o(105009);
      return 4;
    }
    if ("audio/qcelp".equalsIgnoreCase(paramString))
    {
      AppMethodBeat.o(105009);
      return 5;
    }
    if ("audio/vorbis".equalsIgnoreCase(paramString))
    {
      AppMethodBeat.o(105009);
      return 6;
    }
    if ("audio/opus".equalsIgnoreCase(paramString))
    {
      AppMethodBeat.o(105009);
      return 7;
    }
    if ("audio/g711-alaw".equalsIgnoreCase(paramString))
    {
      AppMethodBeat.o(105009);
      return 8;
    }
    if ("audio/g711-mlaw".equalsIgnoreCase(paramString))
    {
      AppMethodBeat.o(105009);
      return 9;
    }
    if ("audio/raw".equalsIgnoreCase(paramString))
    {
      AppMethodBeat.o(105009);
      return 10;
    }
    if ("audio/flac".equalsIgnoreCase(paramString))
    {
      AppMethodBeat.o(105009);
      return 11;
    }
    if ("audio/gsm".equalsIgnoreCase(paramString))
    {
      AppMethodBeat.o(105009);
      return 12;
    }
    if ("audio/ac3".equalsIgnoreCase(paramString))
    {
      AppMethodBeat.o(105009);
      return 13;
    }
    if ("audio/eac3".equalsIgnoreCase(paramString))
    {
      AppMethodBeat.o(105009);
      return 14;
    }
    if ("audio/x-ms-wma".equalsIgnoreCase(paramString))
    {
      AppMethodBeat.o(105009);
      return 15;
    }
    if ("audio/x-wav".equalsIgnoreCase(paramString))
    {
      AppMethodBeat.o(105009);
      return 16;
    }
    if (("audio/x-ape".equalsIgnoreCase(paramString)) || ("application/x-ape".equalsIgnoreCase(paramString)))
    {
      AppMethodBeat.o(105009);
      return 17;
    }
    AppMethodBeat.o(105009);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.d.c
 * JD-Core Version:    0.7.0.1
 */