package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.pb.common.b.a.a.ad;
import com.tencent.pb.common.b.a.a.g;
import com.tencent.pb.common.b.d;

public final class i
  extends d
{
  public i(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    com.tencent.pb.common.c.c.d("MicroMsg.Voip", new Object[] { this.TAG2, "NetSceneRejectVoiceGroup" });
    a.g localg = new a.g();
    try
    {
      localg.groupId = paramString;
      localg.pRI = paramInt1;
      localg.pRJ = paramLong;
      localg.aQw = paramInt2;
      this.wFz = 3;
      this.wFA = com.tencent.wecall.talkroom.model.c.cRC().agy(paramString);
      c(181, localg);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        com.tencent.pb.common.c.c.x(this.TAG2, new Object[] { "NetSceneRejectVoiceGroup constructor", paramString });
      }
    }
  }
  
  protected final Object bK(byte[] paramArrayOfByte)
  {
    com.tencent.pb.common.c.c.d("MicroMsg.Voip", new Object[] { this.TAG2, "data2Resp" });
    if (paramArrayOfByte != null) {
      try
      {
        paramArrayOfByte = (a.ad)e.a(new a.ad(), paramArrayOfByte, paramArrayOfByte.length);
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
    return "CsCmd.Cmd_V_CSRejectEnterVoiceRoomReq";
  }
  
  public final int getType()
  {
    return 207;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.i
 * JD-Core Version:    0.7.0.1
 */