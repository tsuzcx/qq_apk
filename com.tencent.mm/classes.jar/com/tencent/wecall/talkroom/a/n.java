package com.tencent.wecall.talkroom.a;

import com.google.d.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a.an;
import com.tencent.pb.common.b.a.a.a.n;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.b;
import com.tencent.wecall.talkroom.model.c;

public final class n
  extends d
{
  public String IMR;
  public int JMX;
  public long UGt;
  
  public n(String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62547);
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "hello", paramString, Integer.valueOf(paramInt1), Long.valueOf(paramLong) });
    a.n localn = new a.n();
    localn.ahdQ = paramInt3;
    localn.UAZ = paramInt1;
    this.JMX = paramInt1;
    localn.UBa = paramLong;
    this.UGt = paramLong;
    localn.groupId = paramString;
    this.IMR = paramString;
    localn.wTC = paramInt2;
    aGP(3);
    try
    {
      aGQ(c.ked().bGH(paramString));
      c(147, localn);
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
  
  public final Object dp(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62548);
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = (a.an)e.a(new a.an(), paramArrayOfByte, paramArrayOfByte.length);
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
  
  public final int getType()
  {
    return 205;
  }
  
  public final String jQW()
  {
    return "CsCmd.Cmd_V_CSVoiceRoomHelloReq";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.n
 * JD-Core Version:    0.7.0.1
 */