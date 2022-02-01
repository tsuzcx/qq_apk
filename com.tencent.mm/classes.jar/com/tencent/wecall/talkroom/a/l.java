package com.tencent.wecall.talkroom.a;

import com.google.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a.af;
import com.tencent.pb.common.b.a.a.a.h;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.b;
import com.tencent.wecall.talkroom.model.c;

public final class l
  extends d
{
  public long CCU;
  public String uwq;
  public int vdk;
  
  public l(String paramString1, int paramInt, long paramLong, String paramString2)
  {
    AppMethodBeat.i(62540);
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "NetSceneSubscribeLargeVideo" });
    a.h localh = new a.h();
    try
    {
      localh.groupId = paramString1;
      this.uwq = paramString1;
      localh.roomId = paramInt;
      this.vdk = paramInt;
      localh.uXg = paramLong;
      this.CCU = paramLong;
      localh.fUU = paramString2;
      localh.timestamp = System.currentTimeMillis();
      b.i("MicroMsg.Voip", new Object[] { "roomId: %d, roomKey: %d, groupId: %s, ownerUserName: %s, timestamp: %d", Integer.valueOf(localh.roomId), Long.valueOf(localh.uXg), localh.groupId, localh.fUU, Long.valueOf(localh.timestamp) });
      this.mNetType = 3;
      this.Mcu = c.gdW().bbF(paramString1);
      c(245, localh);
      AppMethodBeat.o(62540);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        b.w(this.TAG2, new Object[] { "NetSceneSwitchVideoGroup constructor", paramString1 });
      }
    }
  }
  
  public final Object cL(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62541);
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "data2Resp" });
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = (a.af)e.a(new a.af(), paramArrayOfByte, paramArrayOfByte.length);
        AppMethodBeat.o(62541);
        return paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        b.w(this.TAG2, new Object[] { "data2Resp", paramArrayOfByte.getMessage() });
        paramArrayOfByte = null;
        continue;
      }
      paramArrayOfByte = null;
    }
  }
  
  public final String fXq()
  {
    return "CsCmd.Cmd_V_CSSubscribeLargeVideoReq";
  }
  
  public final int getType()
  {
    return 800;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.l
 * JD-Core Version:    0.7.0.1
 */