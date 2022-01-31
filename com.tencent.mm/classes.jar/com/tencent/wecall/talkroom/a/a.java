package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.pb.common.b.a.a.ag;
import com.tencent.pb.common.b.a.a.al;
import com.tencent.pb.common.b.a.a.ba;
import com.tencent.pb.common.b.a.a.j;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;

public final class a
  extends d
{
  public String kWU = null;
  public int lvU = 0;
  public int wFA;
  public long xdR = 0L;
  public int xfN;
  
  public a(String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    c.d("MicroMsg.Voip", new Object[] { this.TAG2, "NetSceneAckVoiceGroup" });
    a.j localj = new a.j();
    try
    {
      localj.groupId = paramString;
      this.kWU = paramString;
      localj.pRI = paramInt1;
      this.lvU = paramInt1;
      localj.pRJ = paramLong;
      this.xdR = paramLong;
      this.xfN = paramInt3;
      this.wFA = paramInt2;
      paramString = new a.al();
      paramString.tFK = 0;
      a.ba localba = new a.ba();
      localba.type = 3;
      localba.wJw = paramString;
      localj.wGj = localba;
      this.wFz = 3;
      this.wFA = paramInt2;
      c(189, localj);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        c.x(this.TAG2, new Object[] { "NetSceneAckVoiceGroup constructor", paramString });
      }
    }
  }
  
  protected final Object bK(byte[] paramArrayOfByte)
  {
    c.d("MicroMsg.Voip", new Object[] { this.TAG2, "data2Resp" });
    if (paramArrayOfByte != null) {
      try
      {
        paramArrayOfByte = (a.ag)e.a(new a.ag(), paramArrayOfByte, paramArrayOfByte.length);
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
    return "CsCmd.Cmd_V_CSVoiceAckReq";
  }
  
  public final int getType()
  {
    return 206;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.a
 * JD-Core Version:    0.7.0.1
 */