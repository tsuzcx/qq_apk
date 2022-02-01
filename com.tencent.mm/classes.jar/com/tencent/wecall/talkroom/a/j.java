package com.tencent.wecall.talkroom.a;

import com.google.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a.ak;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.b;

public final class j
  extends d
{
  public String tmu;
  
  public final Object cB(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62530);
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = (a.ak)e.a(new a.ak(), paramArrayOfByte, paramArrayOfByte.length);
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
  
  public final String fBB()
  {
    return "CsCmd.Cmd_V_CSVoiceMemberWhisperReq";
  }
  
  public final int getType()
  {
    return 213;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.j
 * JD-Core Version:    0.7.0.1
 */