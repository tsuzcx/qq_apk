package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a.ao;
import com.tencent.pb.common.b.a.a.a.n;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.b;
import com.tencent.wecall.talkroom.model.c;

public final class o
  extends d
{
  public long HgX;
  public String xOr;
  public int yvK;
  
  public o(String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62547);
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "hello", paramString, Integer.valueOf(paramInt1), Long.valueOf(paramLong) });
    a.n localn = new a.n();
    localn.RDH = paramInt3;
    localn.GXO = paramInt1;
    this.yvK = paramInt1;
    localn.GXP = paramLong;
    this.HgX = paramLong;
    localn.groupId = paramString;
    this.xOr = paramString;
    localn.qrD = paramInt2;
    this.mNetType = 3;
    try
    {
      this.RCJ = c.hqY().brj(paramString);
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
  
  public final Object cO(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62548);
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = (a.ao)e.a(new a.ao(), paramArrayOfByte, paramArrayOfByte.length);
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
  
  public final String hiV()
  {
    return "CsCmd.Cmd_V_CSVoiceRoomHelloReq";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.o
 * JD-Core Version:    0.7.0.1
 */