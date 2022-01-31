package com.tencent.mm.plugin.music.f.a;

import com.tencent.mm.sdk.platformtools.y;

public final class e
{
  public static int uV(int paramInt)
  {
    int i = 10001;
    y.i("MicroMsg.PlayerErrorHandler", "getErrCodeType, errorCode: %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      i = -1;
    case 62: 
    case 66: 
    case 67: 
    case 69: 
    case 70: 
    case 74: 
    case 102: 
    case 500: 
    case 501: 
    case 502: 
    case 503: 
    case 504: 
    case 600: 
    case 601: 
    case 602: 
    case 603: 
    case 604: 
    case 605: 
    case 702: 
    case 704: 
    case 706: 
    case 707: 
      return i;
    case 80: 
      return 10002;
    case 53: 
    case 54: 
      return 10003;
    }
    return 10004;
  }
  
  public static String uW(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("errCode:" + paramInt + ", err:");
    switch (paramInt)
    {
    default: 
      localStringBuilder.append("unknow exception");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("file not found");
      continue;
      localStringBuilder.append("file can not read");
      continue;
      localStringBuilder.append("unknow format");
      continue;
      localStringBuilder.append("load or init native decode so fail");
      continue;
      localStringBuilder.append("get audio info fail");
      continue;
      localStringBuilder.append("invalid audio info");
      continue;
      localStringBuilder.append("create AudioTrack fail");
      continue;
      localStringBuilder.append("decode audio fail");
      continue;
      localStringBuilder.append("so file not found");
      continue;
      localStringBuilder.append("create temp file fail");
      continue;
      localStringBuilder.append("invalid seek or seek fail");
      continue;
      localStringBuilder.append("connect network fail");
      continue;
      localStringBuilder.append("recognition audio format error");
      continue;
      localStringBuilder.append("write AudioTrack data fail");
      continue;
      localStringBuilder.append("error URL format");
      continue;
      localStringBuilder.append("error player to prepare");
      continue;
      localStringBuilder.append("error player to start");
      continue;
      localStringBuilder.append("error player to pause");
      continue;
      localStringBuilder.append("error player to stop");
      continue;
      localStringBuilder.append("error create player fail, exceed max count audio players");
      continue;
      localStringBuilder.append("error, not found audioId");
      continue;
      localStringBuilder.append("error, not found param");
      continue;
      localStringBuilder.append("error, ready exist audioId");
      continue;
      localStringBuilder.append("error, invalid audioID");
      continue;
      localStringBuilder.append("error, invalid param");
      continue;
      localStringBuilder.append("error, invalid param");
      continue;
      localStringBuilder.append("error, mmplayer set source occur error");
      continue;
      localStringBuilder.append("error, mmplayer media format error");
      continue;
      localStringBuilder.append("error, mmplayer create MediaCode error");
      continue;
      localStringBuilder.append("error, mmplayer get audio info error");
      continue;
      localStringBuilder.append("error, mmplayer decode error");
      continue;
      localStringBuilder.append("error, mmplayer create audio track orror");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.a.e
 * JD-Core Version:    0.7.0.1
 */