package com.tencent.wecall.talkroom.a;

import com.google.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a.ag;
import com.tencent.pb.common.b.a.a.a.h;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.b;
import com.tencent.wecall.talkroom.model.c;

public final class k
  extends d
{
  public String CSB;
  public int DVO;
  public long NXM;
  
  public k(String paramString1, int paramInt, long paramLong, String paramString2)
  {
    AppMethodBeat.i(62540);
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "NetSceneSubscribeLargeVideo" });
    a.h localh = new a.h();
    try
    {
      localh.groupId = paramString1;
      this.CSB = paramString1;
      localh.roomId = paramInt;
      this.DVO = paramInt;
      localh.DPJ = paramLong;
      this.NXM = paramLong;
      localh.jke = paramString2;
      localh.timestamp = System.currentTimeMillis();
      b.i("MicroMsg.Voip", new Object[] { "roomId: %d, roomKey: %d, groupId: %s, ownerUserName: %s, timestamp: %d", Integer.valueOf(localh.roomId), Long.valueOf(localh.DPJ), localh.groupId, localh.jke, Long.valueOf(localh.timestamp) });
      aAc(3);
      aAd(c.iuI().bEi(paramString1));
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
  
  public final Object dn(byte[] paramArrayOfByte)
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
  
  public final String ikF()
  {
    return "CsCmd.Cmd_V_CSSubscribeLargeVideoReq";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.k
 * JD-Core Version:    0.7.0.1
 */