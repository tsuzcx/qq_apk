package com.tencent.wecall.talkroom.a;

import com.google.d.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a.aj;
import com.tencent.pb.common.b.a.a.a.k;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.b;
import com.tencent.wecall.talkroom.model.c;

public final class m
  extends d
{
  public String IMR;
  public int JMX;
  public long UGt;
  public int aics;
  public String aict;
  public int zZv;
  
  public m(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2, int paramInt3, String paramString3, String paramString4)
  {
    AppMethodBeat.i(212268);
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "NetSceneSwitchVideoGroup" });
    a.k localk = new a.k();
    try
    {
      localk.groupId = paramString1;
      this.IMR = paramString1;
      localk.roomId = paramInt1;
      this.JMX = paramInt1;
      localk.Hnt = paramLong;
      this.UGt = paramLong;
      localk.action = paramInt2;
      this.zZv = paramInt2;
      localk.ahdL = paramInt3;
      this.aics = paramInt3;
      localk.timestamp = System.currentTimeMillis();
      String str = paramString2;
      if (paramString2 == null) {
        str = "";
      }
      localk.ahdK = str;
      paramString2 = paramString3;
      if (paramString3 == null) {
        paramString2 = "";
      }
      localk.ahdM = paramString2;
      this.aict = paramString2;
      paramString2 = paramString4;
      if (paramString4 == null) {
        paramString2 = "";
      }
      localk.ahdN = paramString2;
      aGP(3);
      aGQ(c.ked().bGH(paramString1));
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        b.w(this.TAG2, new Object[] { "NetSceneSwitchVideoGroup constructor", paramString1 });
      }
    }
    c(243, localk);
    AppMethodBeat.o(212268);
  }
  
  public final Object dp(byte[] paramArrayOfByte)
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
  
  public final String jQW()
  {
    return "CsCmd.Cmd_V_CSSwitchVideoGroupReq";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.m
 * JD-Core Version:    0.7.0.1
 */