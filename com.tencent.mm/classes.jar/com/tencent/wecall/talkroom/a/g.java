package com.tencent.wecall.talkroom.a;

import com.google.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a.ad;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.b;

public final class g
  extends d
{
  public String seB;
  
  public final Object cC(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62535);
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "data2Resp" });
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = (a.ad)e.a(new a.ad(), paramArrayOfByte, paramArrayOfByte.length);
        AppMethodBeat.o(62535);
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
    return "CsCmd.Cmd_V_CSModifyVoiceGroupInfoReq";
  }
  
  public final int getType()
  {
    return 209;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.g
 * JD-Core Version:    0.7.0.1
 */