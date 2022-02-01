package com.tencent.mm.plugin.music.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class e
{
  public static int LA(int paramInt)
  {
    AppMethodBeat.i(137405);
    ad.i("MicroMsg.PlayerErrorHandler", "getErrCodeType, errorCode: %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(137405);
      return -1;
    case 62: 
    case 66: 
    case 67: 
    case 69: 
    case 70: 
    case 74: 
    case 102: 
    case 702: 
    case 704: 
    case 706: 
    case 707: 
      AppMethodBeat.o(137405);
      return 10001;
    case 80: 
      AppMethodBeat.o(137405);
      return 10002;
    case 53: 
    case 54: 
      AppMethodBeat.o(137405);
      return 10003;
    case 55: 
    case 63: 
    case 64: 
    case 101: 
    case 701: 
    case 703: 
    case 705: 
      AppMethodBeat.o(137405);
      return 10004;
    }
    AppMethodBeat.o(137405);
    return 10001;
  }
  
  public static String uz(int paramInt)
  {
    AppMethodBeat.i(137406);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("errCode:" + paramInt + ", err:");
    switch (paramInt)
    {
    default: 
      ((StringBuilder)localObject).append("unknow exception");
    }
    for (;;)
    {
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(137406);
      return localObject;
      ((StringBuilder)localObject).append("file not found");
      continue;
      ((StringBuilder)localObject).append("file can not read");
      continue;
      ((StringBuilder)localObject).append("unknow format");
      continue;
      ((StringBuilder)localObject).append("load or init native decode so fail");
      continue;
      ((StringBuilder)localObject).append("get audio info fail");
      continue;
      ((StringBuilder)localObject).append("invalid audio info");
      continue;
      ((StringBuilder)localObject).append("create AudioTrack fail");
      continue;
      ((StringBuilder)localObject).append("decode audio fail");
      continue;
      ((StringBuilder)localObject).append("so file not found");
      continue;
      ((StringBuilder)localObject).append("create temp file fail");
      continue;
      ((StringBuilder)localObject).append("invalid seek or seek fail");
      continue;
      ((StringBuilder)localObject).append("connect network fail");
      continue;
      ((StringBuilder)localObject).append("recognition audio format error");
      continue;
      ((StringBuilder)localObject).append("write AudioTrack data fail");
      continue;
      ((StringBuilder)localObject).append("error URL format");
      continue;
      ((StringBuilder)localObject).append("error player to prepare");
      continue;
      ((StringBuilder)localObject).append("error player to start");
      continue;
      ((StringBuilder)localObject).append("error player to pause");
      continue;
      ((StringBuilder)localObject).append("error player to stop");
      continue;
      ((StringBuilder)localObject).append("error create player fail, exceed max count audio players");
      continue;
      ((StringBuilder)localObject).append("error, not found audioId");
      continue;
      ((StringBuilder)localObject).append("error, not found param");
      continue;
      ((StringBuilder)localObject).append("error, ready exist audioId");
      continue;
      ((StringBuilder)localObject).append("error, invalid audioID");
      continue;
      ((StringBuilder)localObject).append("error, invalid param");
      continue;
      ((StringBuilder)localObject).append("error, invalid param");
      continue;
      ((StringBuilder)localObject).append("error, mmplayer set source occur error");
      continue;
      ((StringBuilder)localObject).append("error, mmplayer media format error");
      continue;
      ((StringBuilder)localObject).append("error, mmplayer create MediaCode error");
      continue;
      ((StringBuilder)localObject).append("error, mmplayer get audio info error");
      continue;
      ((StringBuilder)localObject).append("error, mmplayer decode error");
      continue;
      ((StringBuilder)localObject).append("error, mmplayer create audio track orror");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.a.e
 * JD-Core Version:    0.7.0.1
 */