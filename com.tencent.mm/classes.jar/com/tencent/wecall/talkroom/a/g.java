package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.ac;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;

public final class g
  extends d
{
  public String nuW;
  
  public final Object ck(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(128020);
    c.d("MicroMsg.Voip", new Object[] { this.TAG2, "data2Resp" });
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = (a.ac)e.a(new a.ac(), paramArrayOfByte, paramArrayOfByte.length);
        AppMethodBeat.o(128020);
        return paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        c.w(this.TAG2, new Object[] { "data2Resp", paramArrayOfByte.getMessage() });
        paramArrayOfByte = null;
        continue;
      }
      paramArrayOfByte = null;
    }
  }
  
  public final String dTD()
  {
    return "CsCmd.Cmd_V_CSModifyVoiceGroupInfoReq";
  }
  
  public final int getType()
  {
    return 209;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.g
 * JD-Core Version:    0.7.0.1
 */