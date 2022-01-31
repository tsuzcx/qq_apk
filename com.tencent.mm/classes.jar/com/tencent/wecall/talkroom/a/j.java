package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.pb.common.b.a.a.ai;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;

public final class j
  extends d
{
  public String kWU;
  
  protected final Object bK(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      try
      {
        paramArrayOfByte = (a.ai)e.a(new a.ai(), paramArrayOfByte, paramArrayOfByte.length);
        return paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        c.x(this.TAG2, new Object[] { "data2Resp", paramArrayOfByte });
        return null;
      }
    }
    return null;
  }
  
  protected final String cNR()
  {
    return "CsCmd.Cmd_V_CSVoiceMemberWhisperReq";
  }
  
  public final int getType()
  {
    return 213;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.j
 * JD-Core Version:    0.7.0.1
 */