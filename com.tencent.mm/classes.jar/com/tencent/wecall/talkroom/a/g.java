package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.pb.common.b.a.a.ac;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;

public final class g
  extends d
{
  public String kWU;
  
  protected final Object bK(byte[] paramArrayOfByte)
  {
    c.d("MicroMsg.Voip", new Object[] { this.TAG2, "data2Resp" });
    if (paramArrayOfByte != null) {
      try
      {
        paramArrayOfByte = (a.ac)e.a(new a.ac(), paramArrayOfByte, paramArrayOfByte.length);
        return paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        c.x(this.TAG2, new Object[] { "data2Resp", paramArrayOfByte.getMessage() });
        return null;
      }
    }
    return null;
  }
  
  protected final String cNR()
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