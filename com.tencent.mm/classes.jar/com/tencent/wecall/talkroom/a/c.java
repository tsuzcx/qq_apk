package com.tencent.wecall.talkroom.a;

import com.google.d.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a.aa;
import com.tencent.pb.common.b.a.a.a.b;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.b;

public final class c
  extends d
{
  public c(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62528);
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "NetSceneCancelCreateVoiceGroup" });
    a.b localb = new a.b();
    try
    {
      localb.ahdt = paramString;
      localb.reason = paramInt1;
      aGP(3);
      aGQ(paramInt2);
      c(183, localb);
      AppMethodBeat.o(62528);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        b.w(this.TAG2, new Object[] { "NetSceneCancelCreateVoiceGroup constructor", paramString });
      }
    }
  }
  
  public final Object dp(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62529);
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "data2Resp" });
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = (a.aa)e.a(new a.aa(), paramArrayOfByte, paramArrayOfByte.length);
        AppMethodBeat.o(62529);
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
    return 208;
  }
  
  public final String jQW()
  {
    return "CsCmd.Cmd_V_CSCancelCreateVoiceGroupReq";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.c
 * JD-Core Version:    0.7.0.1
 */