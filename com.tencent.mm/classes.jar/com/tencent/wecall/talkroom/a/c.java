package com.tencent.wecall.talkroom.a;

import com.google.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a.b;
import com.tencent.pb.common.b.a.a.a.z;
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
      localb.IkB = paramString;
      localb.bvJ = paramInt1;
      this.mNetType = 3;
      this.IjW = paramInt2;
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
  
  public final Object cC(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62529);
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "data2Resp" });
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = (a.z)e.a(new a.z(), paramArrayOfByte, paramArrayOfByte.length);
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
  
  public final String flk()
  {
    return "CsCmd.Cmd_V_CSCancelCreateVoiceGroupReq";
  }
  
  public final int getType()
  {
    return 208;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.c
 * JD-Core Version:    0.7.0.1
 */