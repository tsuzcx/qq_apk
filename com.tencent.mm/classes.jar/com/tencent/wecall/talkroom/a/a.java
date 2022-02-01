package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a.ak;
import com.tencent.pb.common.b.a.a.a.ap;
import com.tencent.pb.common.b.a.a.a.bg;
import com.tencent.pb.common.b.a.a.a.l;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.b;

public final class a
  extends d
{
  public long HgX;
  public int RCJ;
  public int SwS;
  public String xOr;
  public int yvK;
  
  public a(String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62531);
    this.xOr = null;
    this.yvK = 0;
    this.HgX = 0L;
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "NetSceneAckVoiceGroup" });
    a.l locall = new a.l();
    try
    {
      locall.groupId = paramString;
      this.xOr = paramString;
      locall.GXO = paramInt1;
      this.yvK = paramInt1;
      locall.GXP = paramLong;
      this.HgX = paramLong;
      this.SwS = paramInt3;
      this.RCJ = paramInt2;
      paramString = new a.ap();
      paramString.iLen = 0;
      a.bg localbg = new a.bg();
      localbg.type = 3;
      localbg.RGJ = paramString;
      locall.RDs = localbg;
      this.mNetType = 3;
      this.RCJ = paramInt2;
      c(189, locall);
      AppMethodBeat.o(62531);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        b.w(this.TAG2, new Object[] { "NetSceneAckVoiceGroup constructor", paramString });
      }
    }
  }
  
  public final Object cO(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62532);
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "data2Resp" });
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = (a.ak)e.a(new a.ak(), paramArrayOfByte, paramArrayOfByte.length);
        AppMethodBeat.o(62532);
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
    return 206;
  }
  
  public final String hiV()
  {
    return "CsCmd.Cmd_V_CSVoiceAckReq";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.a
 * JD-Core Version:    0.7.0.1
 */