package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.ak;
import com.tencent.pb.common.b.a.a.l;
import com.tencent.pb.common.b.d;

public final class m
  extends d
{
  public int nTj;
  public String nuW;
  public long tFh;
  
  public m(String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(128030);
    com.tencent.pb.common.c.c.d("MicroMsg.Voip", new Object[] { this.TAG2, "hello", paramString, Integer.valueOf(paramInt1), Long.valueOf(paramLong) });
    a.l locall = new a.l();
    locall.BdX = paramInt3;
    locall.twP = paramInt1;
    this.nTj = paramInt1;
    locall.twQ = paramLong;
    this.tFh = paramLong;
    locall.groupId = paramString;
    this.nuW = paramString;
    locall.kJx = paramInt2;
    this.mNetType = 3;
    try
    {
      this.Bda = com.tencent.wecall.talkroom.model.c.dXv().axs(paramString);
      c(147, locall);
      AppMethodBeat.o(128030);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        com.tencent.pb.common.c.c.w(this.TAG2, new Object[] { "NetSceneVoiceRoomHello constructor", paramString });
      }
    }
  }
  
  public final Object ck(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(128031);
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = (a.ak)e.a(new a.ak(), paramArrayOfByte, paramArrayOfByte.length);
        AppMethodBeat.o(128031);
        return paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        com.tencent.pb.common.c.c.w(this.TAG2, new Object[] { "data2Resp", paramArrayOfByte.getMessage() });
        paramArrayOfByte = null;
        continue;
      }
      paramArrayOfByte = null;
    }
  }
  
  public final String dTD()
  {
    return "CsCmd.Cmd_V_CSVoiceRoomHelloReq";
  }
  
  public final int getType()
  {
    return 205;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.m
 * JD-Core Version:    0.7.0.1
 */