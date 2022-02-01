package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a.aj;
import com.tencent.pb.common.b.a.a.a.k;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.b;
import com.tencent.wecall.talkroom.model.c;

public final class n
  extends d
{
  public long HgX;
  public String xOr;
  public int yvK;
  
  public n(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(62524);
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "NetSceneSwitchVideoGroup" });
    a.k localk = new a.k();
    try
    {
      localk.groupId = paramString;
      this.xOr = paramString;
      localk.roomId = paramInt1;
      this.yvK = paramInt1;
      localk.ypH = paramLong;
      this.HgX = paramLong;
      localk.action = paramInt2;
      localk.timestamp = System.currentTimeMillis();
      this.mNetType = 3;
      this.RCJ = c.hqY().brj(paramString);
      c(243, localk);
      AppMethodBeat.o(62524);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        b.w(this.TAG2, new Object[] { "NetSceneSwitchVideoGroup constructor", paramString });
      }
    }
  }
  
  public final Object cO(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62525);
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "data2Resp" });
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = (a.aj)e.a(new a.aj(), paramArrayOfByte, paramArrayOfByte.length);
        AppMethodBeat.o(62525);
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
    return 214;
  }
  
  public final String hiV()
  {
    return "CsCmd.Cmd_V_CSSwitchVideoGroupReq";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.n
 * JD-Core Version:    0.7.0.1
 */