package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.af;
import com.tencent.pb.common.b.a.a.i;
import com.tencent.pb.common.b.d;

public final class l
  extends d
{
  public int nTj;
  public String nuW;
  public long tFh;
  
  public l(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(128028);
    com.tencent.pb.common.c.c.d("MicroMsg.Voip", new Object[] { this.TAG2, "NetSceneSwitchVideoGroup" });
    a.i locali = new a.i();
    try
    {
      locali.groupId = paramString;
      this.nuW = paramString;
      locali.nMZ = paramInt1;
      this.nTj = paramInt1;
      locali.nNa = paramLong;
      this.tFh = paramLong;
      locali.action = paramInt2;
      locali.timestamp = System.currentTimeMillis();
      this.mNetType = 3;
      this.Bda = com.tencent.wecall.talkroom.model.c.dXv().axs(paramString);
      c(243, locali);
      AppMethodBeat.o(128028);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        com.tencent.pb.common.c.c.w(this.TAG2, new Object[] { "NetSceneSwitchVideoGroup constructor", paramString });
      }
    }
  }
  
  public final Object ck(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(128029);
    com.tencent.pb.common.c.c.d("MicroMsg.Voip", new Object[] { this.TAG2, "data2Resp" });
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = (a.af)e.a(new a.af(), paramArrayOfByte, paramArrayOfByte.length);
        AppMethodBeat.o(128029);
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
    return "CsCmd.Cmd_V_CSSwitchVideoGroupReq";
  }
  
  public final int getType()
  {
    return 214;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.l
 * JD-Core Version:    0.7.0.1
 */