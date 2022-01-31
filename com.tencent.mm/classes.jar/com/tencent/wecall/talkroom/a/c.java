package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.pb.common.b.a.a.b;
import com.tencent.pb.common.b.a.a.y;
import com.tencent.pb.common.b.d;

public final class c
  extends d
{
  public c(String paramString, int paramInt1, int paramInt2)
  {
    com.tencent.pb.common.c.c.d("MicroMsg.Voip", new Object[] { this.TAG2, "NetSceneCancelCreateVoiceGroup" });
    a.b localb = new a.b();
    try
    {
      localb.wGf = paramString;
      localb.aQw = paramInt1;
      this.wFz = 3;
      this.wFA = paramInt2;
      c(183, localb);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        com.tencent.pb.common.c.c.x(this.TAG2, new Object[] { "NetSceneCancelCreateVoiceGroup constructor", paramString });
      }
    }
  }
  
  protected final Object bK(byte[] paramArrayOfByte)
  {
    com.tencent.pb.common.c.c.d("MicroMsg.Voip", new Object[] { this.TAG2, "data2Resp" });
    if (paramArrayOfByte != null) {
      try
      {
        paramArrayOfByte = (a.y)e.a(new a.y(), paramArrayOfByte, paramArrayOfByte.length);
        return paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        com.tencent.pb.common.c.c.x(this.TAG2, new Object[] { "data2Resp", paramArrayOfByte.getMessage() });
        return null;
      }
    }
    return null;
  }
  
  protected final String cNR()
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