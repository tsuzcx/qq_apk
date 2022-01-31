package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.aj;
import com.tencent.pb.common.b.a.a.k;
import com.tencent.wecall.talkroom.model.k;

public final class h
  extends com.tencent.pb.common.b.d
{
  public String groupId;
  public int nMZ;
  public long nNa;
  
  public h(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(128021);
    com.tencent.pb.common.c.c.d("MicroMsg.Voip", new Object[] { this.TAG2, "NetSceneRejectVoiceGroup" });
    a.k localk = new a.k();
    try
    {
      localk.groupId = paramString;
      localk.twP = paramInt1;
      localk.twQ = paramLong;
      localk.kJx = paramInt2;
      localk.BdM = 2;
      localk.netType = k.jN(com.tencent.pb.common.c.d.tFk);
      this.mNetType = 3;
      this.Bda = com.tencent.wecall.talkroom.model.c.dXv().axs(paramString);
      c(211, localk);
      AppMethodBeat.o(128021);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        com.tencent.pb.common.c.c.w(this.TAG2, new Object[] { "NetSceneRedirect constructor", paramString });
      }
    }
  }
  
  public final Object ck(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(128022);
    com.tencent.pb.common.c.c.d("MicroMsg.Voip", new Object[] { this.TAG2, "data2Resp" });
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = (a.aj)e.a(new a.aj(), paramArrayOfByte, paramArrayOfByte.length);
        AppMethodBeat.o(128022);
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
    return "CsCmd.Cmd_V_CSVoiceRedirectReq";
  }
  
  public final int getType()
  {
    return 211;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.h
 * JD-Core Version:    0.7.0.1
 */