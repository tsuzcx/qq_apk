package com.tencent.wecall.talkroom.a;

import com.google.d.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a.ag;
import com.tencent.pb.common.b.a.a.a.h;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.b;
import com.tencent.wecall.talkroom.model.c;

public final class k
  extends d
{
  public String IMR;
  public int JMX;
  public long UGt;
  
  public k(String paramString1, int paramInt, long paramLong, String paramString2)
  {
    AppMethodBeat.i(62540);
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "NetSceneSubscribeLargeVideo" });
    a.h localh = new a.h();
    try
    {
      localh.groupId = paramString1;
      this.IMR = paramString1;
      localh.roomId = paramInt;
      this.JMX = paramInt;
      localh.Hnt = paramLong;
      this.UGt = paramLong;
      localh.lMI = paramString2;
      localh.timestamp = System.currentTimeMillis();
      b.i("MicroMsg.Voip", new Object[] { "roomId: %d, roomKey: %d, groupId: %s, ownerUserName: %s, timestamp: %d", Integer.valueOf(localh.roomId), Long.valueOf(localh.Hnt), localh.groupId, localh.lMI, Long.valueOf(localh.timestamp) });
      aGP(3);
      aGQ(c.ked().bGH(paramString1));
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
  
  public final Object dp(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62541);
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "data2Resp" });
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = (a.ag)e.a(new a.ag(), paramArrayOfByte, paramArrayOfByte.length);
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
  
  public final int getType()
  {
    return 800;
  }
  
  public final String jQW()
  {
    return "CsCmd.Cmd_V_CSSubscribeLargeVideoReq";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.k
 * JD-Core Version:    0.7.0.1
 */