package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a.am;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.b;

public final class j
  extends d
{
  public String xOr;
  
  public final Object cO(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62530);
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = (a.am)e.a(new a.am(), paramArrayOfByte, paramArrayOfByte.length);
        AppMethodBeat.o(62530);
        return paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        b.w(this.TAG2, new Object[] { "data2Resp", paramArrayOfByte });
        paramArrayOfByte = null;
        continue;
      }
      paramArrayOfByte = null;
    }
  }
  
  public final int getType()
  {
    return 213;
  }
  
  public final String hiV()
  {
    return "CsCmd.Cmd_V_CSVoiceMemberWhisperReq";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.j
 * JD-Core Version:    0.7.0.1
 */