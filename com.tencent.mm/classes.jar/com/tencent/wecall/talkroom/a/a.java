package com.tencent.wecall.talkroom.a;

import com.google.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a.ai;
import com.tencent.pb.common.b.a.a.a.an;
import com.tencent.pb.common.b.a.a.a.bd;
import com.tencent.pb.common.b.a.a.a.k;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.b;

public final class a
  extends d
{
  public long CCU;
  public int MKX;
  public int Mcu;
  public String uwq;
  public int vdk;
  
  public a(String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62531);
    this.uwq = null;
    this.vdk = 0;
    this.CCU = 0L;
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "NetSceneAckVoiceGroup" });
    a.k localk = new a.k();
    try
    {
      localk.groupId = paramString;
      this.uwq = paramString;
      localk.Cuf = paramInt1;
      this.vdk = paramInt1;
      localk.Cug = paramLong;
      this.CCU = paramLong;
      this.MKX = paramInt3;
      this.Mcu = paramInt2;
      paramString = new a.an();
      paramString.iLen = 0;
      a.bd localbd = new a.bd();
      localbd.type = 3;
      localbd.Mgr = paramString;
      localk.Mdd = localbd;
      this.mNetType = 3;
      this.Mcu = paramInt2;
      c(189, localk);
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
  
  public final Object cL(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62532);
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "data2Resp" });
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = (a.ai)e.a(new a.ai(), paramArrayOfByte, paramArrayOfByte.length);
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
  
  public final String fXq()
  {
    return "CsCmd.Cmd_V_CSVoiceAckReq";
  }
  
  public final int getType()
  {
    return 206;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.a
 * JD-Core Version:    0.7.0.1
 */