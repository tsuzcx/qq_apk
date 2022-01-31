package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.b;
import com.tencent.pb.common.b.a.a.y;
import com.tencent.pb.common.b.d;

public final class c
  extends d
{
  public c(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(128011);
    com.tencent.pb.common.c.c.d("MicroMsg.Voip", new Object[] { this.TAG2, "NetSceneCancelCreateVoiceGroup" });
    a.b localb = new a.b();
    try
    {
      localb.BdG = paramString;
      localb.aXG = paramInt1;
      this.mNetType = 3;
      this.Bda = paramInt2;
      c(183, localb);
      AppMethodBeat.o(128011);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        com.tencent.pb.common.c.c.w(this.TAG2, new Object[] { "NetSceneCancelCreateVoiceGroup constructor", paramString });
      }
    }
  }
  
  public final Object ck(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(128012);
    com.tencent.pb.common.c.c.d("MicroMsg.Voip", new Object[] { this.TAG2, "data2Resp" });
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = (a.y)e.a(new a.y(), paramArrayOfByte, paramArrayOfByte.length);
        AppMethodBeat.o(128012);
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
    return "CsCmd.Cmd_V_CSCancelCreateVoiceGroupReq";
  }
  
  public final int getType()
  {
    return 208;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.c
 * JD-Core Version:    0.7.0.1
 */