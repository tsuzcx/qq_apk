package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.pb.common.b.a.a.aj;
import com.tencent.pb.common.b.a.a.k;
import com.tencent.wecall.talkroom.model.k;

public final class h
  extends com.tencent.pb.common.b.d
{
  public String groupId;
  public int lpD;
  public long lpE;
  
  public h(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    com.tencent.pb.common.c.c.d("MicroMsg.Voip", new Object[] { this.TAG2, "NetSceneRejectVoiceGroup" });
    a.k localk = new a.k();
    try
    {
      localk.groupId = paramString;
      localk.pRI = paramInt1;
      localk.pRJ = paramLong;
      localk.iEo = paramInt2;
      localk.wGl = 2;
      localk.netType = k.ij(com.tencent.pb.common.c.d.pZI);
      this.wFz = 3;
      this.wFA = com.tencent.wecall.talkroom.model.c.cRC().agy(paramString);
      c(211, localk);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        com.tencent.pb.common.c.c.x(this.TAG2, new Object[] { "NetSceneRedirect constructor", paramString });
      }
    }
  }
  
  protected final Object bK(byte[] paramArrayOfByte)
  {
    com.tencent.pb.common.c.c.d("MicroMsg.Voip", new Object[] { this.TAG2, "data2Resp" });
    if (paramArrayOfByte != null) {
      try
      {
        paramArrayOfByte = (a.aj)e.a(new a.aj(), paramArrayOfByte, paramArrayOfByte.length);
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
    return "CsCmd.Cmd_V_CSVoiceRedirectReq";
  }
  
  public final int getType()
  {
    return 211;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.h
 * JD-Core Version:    0.7.0.1
 */