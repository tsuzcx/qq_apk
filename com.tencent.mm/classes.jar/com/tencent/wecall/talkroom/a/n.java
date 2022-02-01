package com.tencent.wecall.talkroom.a;

import com.google.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a.am;
import com.tencent.pb.common.b.a.a.a.m;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.b;
import com.tencent.wecall.talkroom.model.c;

public final class n
  extends d
{
  public long AMc;
  public int tOL;
  public String tmu;
  
  public n(String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62547);
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "hello", paramString, Integer.valueOf(paramInt1), Long.valueOf(paramLong) });
    a.m localm = new a.m();
    localm.JME = paramInt3;
    localm.ADE = paramInt1;
    this.tOL = paramInt1;
    localm.ADF = paramLong;
    this.AMc = paramLong;
    localm.groupId = paramString;
    this.tmu = paramString;
    localm.osF = paramInt2;
    this.mNetType = 3;
    try
    {
      this.JLH = c.fIe().aUe(paramString);
      c(147, localm);
      AppMethodBeat.o(62547);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        b.w(this.TAG2, new Object[] { "NetSceneVoiceRoomHello constructor", paramString });
      }
    }
  }
  
  public final Object cB(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62548);
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = (a.am)e.a(new a.am(), paramArrayOfByte, paramArrayOfByte.length);
        AppMethodBeat.o(62548);
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
    return "CsCmd.Cmd_V_CSVoiceRoomHelloReq";
  }
  
  public final int getType()
  {
    return 205;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.n
 * JD-Core Version:    0.7.0.1
 */