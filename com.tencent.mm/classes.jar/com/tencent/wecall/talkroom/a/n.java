package com.tencent.wecall.talkroom.a;

import com.google.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a.an;
import com.tencent.pb.common.b.a.a.a.n;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.b;
import com.tencent.wecall.talkroom.model.c;

public final class n
  extends d
{
  public String CSB;
  public int DVO;
  public long NXM;
  
  public n(String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62547);
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "hello", paramString, Integer.valueOf(paramInt1), Long.valueOf(paramLong) });
    a.n localn = new a.n();
    localn.Zfn = paramInt3;
    localn.NOc = paramInt1;
    this.DVO = paramInt1;
    localn.NOd = paramLong;
    this.NXM = paramLong;
    localn.groupId = paramString;
    this.CSB = paramString;
    localn.tQm = paramInt2;
    aAc(3);
    try
    {
      aAd(c.iuI().bEi(paramString));
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
  
  public final Object dn(byte[] paramArrayOfByte)
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
  
  public final String ikF()
  {
    return "CsCmd.Cmd_V_CSVoiceRoomHelloReq";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.n
 * JD-Core Version:    0.7.0.1
 */