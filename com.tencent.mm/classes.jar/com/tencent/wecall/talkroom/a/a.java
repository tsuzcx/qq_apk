package com.tencent.wecall.talkroom.a;

import com.google.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a.ak;
import com.tencent.pb.common.b.a.a.a.ao;
import com.tencent.pb.common.b.a.a.a.bf;
import com.tencent.pb.common.b.a.a.a.l;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.b;

public final class a
  extends d
{
  public String CSB;
  public int DVO;
  public long NXM;
  public int ZXQ;
  public int Zel;
  
  public a(String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62531);
    this.CSB = null;
    this.DVO = 0;
    this.NXM = 0L;
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "NetSceneAckVoiceGroup" });
    a.l locall = new a.l();
    try
    {
      locall.groupId = paramString;
      this.CSB = paramString;
      locall.NOc = paramInt1;
      this.DVO = paramInt1;
      locall.NOd = paramLong;
      this.NXM = paramLong;
      this.ZXQ = paramInt3;
      this.Zel = paramInt2;
      paramString = new a.ao();
      paramString.Ufv = 0;
      a.bf localbf = new a.bf();
      localbf.type = 3;
      localbf.Zip = paramString;
      locall.ZeU = localbf;
      aAc(3);
      aAd(paramInt2);
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
  
  public final Object dn(byte[] paramArrayOfByte)
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
  
  public final String ikF()
  {
    return "CsCmd.Cmd_V_CSVoiceAckReq";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.a
 * JD-Core Version:    0.7.0.1
 */