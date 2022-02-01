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
  public long CCU;
  public String uwq;
  public int vdk;
  
  public n(String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62547);
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "hello", paramString, Integer.valueOf(paramInt1), Long.valueOf(paramLong) });
    a.m localm = new a.m();
    localm.Mdr = paramInt3;
    localm.Cuf = paramInt1;
    this.vdk = paramInt1;
    localm.Cug = paramLong;
    this.CCU = paramLong;
    localm.groupId = paramString;
    this.uwq = paramString;
    localm.pcE = paramInt2;
    this.mNetType = 3;
    try
    {
      this.Mcu = c.gdW().bbF(paramString);
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
  
  public final Object cL(byte[] paramArrayOfByte)
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
  
  public final String fXq()
  {
    return "CsCmd.Cmd_V_CSVoiceRoomHelloReq";
  }
  
  public final int getType()
  {
    return 205;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.n
 * JD-Core Version:    0.7.0.1
 */