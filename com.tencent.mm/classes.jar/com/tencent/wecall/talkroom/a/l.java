package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.pb.common.b.a.a.af;
import com.tencent.pb.common.b.a.a.i;
import com.tencent.pb.common.b.d;

public final class l
  extends d
{
  public String kWU;
  public int lvU;
  public long xdR;
  
  public l(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    com.tencent.pb.common.c.c.d("MicroMsg.Voip", new Object[] { this.TAG2, "NetSceneSwitchVideoGroup" });
    a.i locali = new a.i();
    try
    {
      locali.groupId = paramString;
      this.kWU = paramString;
      locali.lpD = paramInt1;
      this.lvU = paramInt1;
      locali.lpE = paramLong;
      this.xdR = paramLong;
      locali.action = paramInt2;
      locali.timestamp = System.currentTimeMillis();
      this.wFz = 3;
      this.wFA = com.tencent.wecall.talkroom.model.c.cRC().agy(paramString);
      c(243, locali);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        com.tencent.pb.common.c.c.x(this.TAG2, new Object[] { "NetSceneSwitchVideoGroup constructor", paramString });
      }
    }
  }
  
  protected final Object bK(byte[] paramArrayOfByte)
  {
    com.tencent.pb.common.c.c.d("MicroMsg.Voip", new Object[] { this.TAG2, "data2Resp" });
    if (paramArrayOfByte != null) {
      try
      {
        paramArrayOfByte = (a.af)e.a(new a.af(), paramArrayOfByte, paramArrayOfByte.length);
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
    return "CsCmd.Cmd_V_CSSwitchVideoGroupReq";
  }
  
  public final int getType()
  {
    return 214;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.l
 * JD-Core Version:    0.7.0.1
 */