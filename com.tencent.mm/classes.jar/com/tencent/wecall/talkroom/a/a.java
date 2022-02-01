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
  public long Clq;
  public int LFq;
  public int Mob;
  public int uRy;
  public String ukT;
  
  public a(String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62531);
    this.ukT = null;
    this.uRy = 0;
    this.Clq = 0L;
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "NetSceneAckVoiceGroup" });
    a.k localk = new a.k();
    try
    {
      localk.groupId = paramString;
      this.ukT = paramString;
      localk.CcE = paramInt1;
      this.uRy = paramInt1;
      localk.CcF = paramLong;
      this.Clq = paramLong;
      this.Mob = paramInt3;
      this.LFq = paramInt2;
      paramString = new a.an();
      paramString.iLen = 0;
      a.bd localbd = new a.bd();
      localbd.type = 3;
      localbd.LJn = paramString;
      localk.LFZ = localbd;
      this.mNetType = 3;
      this.LFq = paramInt2;
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
  
  public final Object cI(byte[] paramArrayOfByte)
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
  
  public final String fSQ()
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