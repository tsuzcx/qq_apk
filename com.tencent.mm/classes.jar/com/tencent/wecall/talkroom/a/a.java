package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.ag;
import com.tencent.pb.common.b.a.a.al;
import com.tencent.pb.common.b.a.a.ba;
import com.tencent.pb.common.b.a.a.j;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;

public final class a
  extends d
{
  public int BCu;
  public int Bda;
  public int nTj;
  public String nuW;
  public long tFh;
  
  public a(String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(128007);
    this.nuW = null;
    this.nTj = 0;
    this.tFh = 0L;
    c.d("MicroMsg.Voip", new Object[] { this.TAG2, "NetSceneAckVoiceGroup" });
    a.j localj = new a.j();
    try
    {
      localj.groupId = paramString;
      this.nuW = paramString;
      localj.twP = paramInt1;
      this.nTj = paramInt1;
      localj.twQ = paramLong;
      this.tFh = paramLong;
      this.BCu = paramInt3;
      this.Bda = paramInt2;
      paramString = new a.al();
      paramString.iLen = 0;
      a.ba localba = new a.ba();
      localba.type = 3;
      localba.BgW = paramString;
      localj.BdK = localba;
      this.mNetType = 3;
      this.Bda = paramInt2;
      c(189, localj);
      AppMethodBeat.o(128007);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        c.w(this.TAG2, new Object[] { "NetSceneAckVoiceGroup constructor", paramString });
      }
    }
  }
  
  public final Object ck(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(128008);
    c.d("MicroMsg.Voip", new Object[] { this.TAG2, "data2Resp" });
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = (a.ag)e.a(new a.ag(), paramArrayOfByte, paramArrayOfByte.length);
        AppMethodBeat.o(128008);
        return paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        c.w(this.TAG2, new Object[] { "data2Resp", paramArrayOfByte.getMessage() });
        paramArrayOfByte = null;
        continue;
      }
      paramArrayOfByte = null;
    }
  }
  
  public final String dTD()
  {
    return "CsCmd.Cmd_V_CSVoiceAckReq";
  }
  
  public final int getType()
  {
    return 206;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.a
 * JD-Core Version:    0.7.0.1
 */