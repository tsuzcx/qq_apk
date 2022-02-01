package com.tencent.wecall.talkroom.a;

import com.google.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a.ah;
import com.tencent.pb.common.b.a.a.a.j;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.b;
import com.tencent.wecall.talkroom.model.c;

public final class m
  extends d
{
  public long AMc;
  public int tOL;
  public String tmu;
  
  public m(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(62524);
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "NetSceneSwitchVideoGroup" });
    a.j localj = new a.j();
    try
    {
      localj.groupId = paramString;
      this.tmu = paramString;
      localj.roomId = paramInt1;
      this.tOL = paramInt1;
      localj.tIG = paramLong;
      this.AMc = paramLong;
      localj.action = paramInt2;
      localj.timestamp = System.currentTimeMillis();
      this.mNetType = 3;
      this.JLH = c.fIe().aUe(paramString);
      c(243, localj);
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
  
  public final Object cB(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62525);
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "data2Resp" });
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = (a.ah)e.a(new a.ah(), paramArrayOfByte, paramArrayOfByte.length);
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
  
  public final String fBB()
  {
    return "CsCmd.Cmd_V_CSSwitchVideoGroupReq";
  }
  
  public final int getType()
  {
    return 214;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.m
 * JD-Core Version:    0.7.0.1
 */