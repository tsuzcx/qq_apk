package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.ae;
import com.tencent.pb.common.b.a.a.h;
import com.tencent.pb.common.b.d;

public final class k
  extends d
{
  public int nTj;
  public String nuW;
  public long tFh;
  
  public k(String paramString1, int paramInt, long paramLong, String paramString2)
  {
    AppMethodBeat.i(128026);
    com.tencent.pb.common.c.c.d("MicroMsg.Voip", new Object[] { this.TAG2, "NetSceneSubscribeLargeVideo" });
    a.h localh = new a.h();
    try
    {
      localh.groupId = paramString1;
      this.nuW = paramString1;
      localh.nMZ = paramInt;
      this.nTj = paramInt;
      localh.nNa = paramLong;
      this.tFh = paramLong;
      localh.ejf = paramString2;
      localh.timestamp = System.currentTimeMillis();
      com.tencent.pb.common.c.c.i("MicroMsg.Voip", new Object[] { "roomId: %d, roomKey: %d, groupId: %s, ownerUserName: %s, timestamp: %d", Integer.valueOf(localh.nMZ), Long.valueOf(localh.nNa), localh.groupId, localh.ejf, Long.valueOf(localh.timestamp) });
      this.mNetType = 3;
      this.Bda = com.tencent.wecall.talkroom.model.c.dXv().axs(paramString1);
      c(245, localh);
      AppMethodBeat.o(128026);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        com.tencent.pb.common.c.c.w(this.TAG2, new Object[] { "NetSceneSwitchVideoGroup constructor", paramString1 });
      }
    }
  }
  
  public final Object ck(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(128027);
    com.tencent.pb.common.c.c.d("MicroMsg.Voip", new Object[] { this.TAG2, "data2Resp" });
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = (a.ae)e.a(new a.ae(), paramArrayOfByte, paramArrayOfByte.length);
        AppMethodBeat.o(128027);
        return paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        com.tencent.pb.common.c.c.w(this.TAG2, new Object[] { "data2Resp", paramArrayOfByte.getMessage() });
        paramArrayOfByte = null;
        continue;
      }
      paramArrayOfByte = null;
    }
  }
  
  public final String dTD()
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