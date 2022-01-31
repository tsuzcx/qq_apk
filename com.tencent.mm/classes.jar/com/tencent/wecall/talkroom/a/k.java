package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.pb.common.b.a.a.ae;
import com.tencent.pb.common.b.a.a.h;
import com.tencent.pb.common.b.d;

public final class k
  extends d
{
  public String kWU;
  public int lvU;
  public long xdR;
  
  public k(String paramString1, int paramInt, long paramLong, String paramString2)
  {
    com.tencent.pb.common.c.c.d("MicroMsg.Voip", new Object[] { this.TAG2, "NetSceneSubscribeLargeVideo" });
    a.h localh = new a.h();
    try
    {
      localh.groupId = paramString1;
      this.kWU = paramString1;
      localh.lpD = paramInt;
      this.lvU = paramInt;
      localh.lpE = paramLong;
      this.xdR = paramLong;
      localh.drx = paramString2;
      localh.timestamp = System.currentTimeMillis();
      com.tencent.pb.common.c.c.w("MicroMsg.Voip", new Object[] { "roomId: %d, roomKey: %d, groupId: %s, ownerUserName: %s, timestamp: %d", Integer.valueOf(localh.lpD), Long.valueOf(localh.lpE), localh.groupId, localh.drx, Long.valueOf(localh.timestamp) });
      this.wFz = 3;
      this.wFA = com.tencent.wecall.talkroom.model.c.cRC().agy(paramString1);
      c(245, localh);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        com.tencent.pb.common.c.c.x(this.TAG2, new Object[] { "NetSceneSwitchVideoGroup constructor", paramString1 });
      }
    }
  }
  
  protected final Object bK(byte[] paramArrayOfByte)
  {
    com.tencent.pb.common.c.c.d("MicroMsg.Voip", new Object[] { this.TAG2, "data2Resp" });
    if (paramArrayOfByte != null) {
      try
      {
        paramArrayOfByte = (a.ae)e.a(new a.ae(), paramArrayOfByte, paramArrayOfByte.length);
        return paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        com.tencent.pb.common.c.c.x(this.TAG2, new Object[] { "data2Resp", paramArrayOfByte.getMessage() });
        return null;
      }
    }
    return null;
  }
  
  protected final String cNR()
  {
    return "CsCmd.Cmd_V_CSSubscribeLargeVideoReq";
  }
  
  public final int getType()
  {
    return 800;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.k
 * JD-Core Version:    0.7.0.1
 */