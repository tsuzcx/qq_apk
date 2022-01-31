package com.tencent.wecall.talkroom.a;

import com.tencent.pb.common.b.a.a.aa;
import com.tencent.pb.common.b.a.a.al;
import com.tencent.pb.common.b.a.a.at;
import com.tencent.pb.common.b.a.a.ba;
import com.tencent.pb.common.b.a.a.e;
import com.tencent.pb.common.c.c;
import com.tencent.wecall.talkroom.model.k;

public final class e
  extends com.tencent.pb.common.b.d
{
  public String kWU = null;
  public int lvU = 0;
  public String xdP = null;
  public long xdR = 0L;
  public int xfP = 0;
  
  public e(e parame)
  {
    this.kWU = parame.kWU;
    this.lvU = parame.lvU;
    this.xdR = parame.xdR;
    this.xfP = parame.xfP;
    this.xdP = parame.xdP;
    this.wFw = parame.wFw;
    this.wFy = parame.wFy;
    this.wFA = parame.wFA;
    this.wFz = 1;
  }
  
  public e(String paramString1, int paramInt1, long paramLong, byte[] paramArrayOfByte, int paramInt2, int paramInt3, String paramString2)
  {
    c.d("MicroMsg.Voip", new Object[] { this.TAG2, "enter2", paramString1, Integer.valueOf(paramInt1), Long.valueOf(paramLong), paramString2 });
    a.e locale = new a.e();
    for (;;)
    {
      try
      {
        locale.groupId = paramString1;
        this.kWU = paramString1;
        locale.pRI = paramInt1;
        this.lvU = paramInt1;
        locale.pRJ = paramLong;
        this.xdR = paramLong;
        locale.wGr = paramInt3;
        this.xfP = paramInt3;
        paramString1 = new a.at();
        paramString1.wIC = paramString2;
        locale.wGh = paramString1;
        this.xdP = paramString2;
        c.d("MicroMsg.Voip", new Object[] { this.TAG2, "wXgroupId", locale.wGh.wIC });
        paramString1 = new a.al();
        if (paramArrayOfByte == null) {
          continue;
        }
        paramString1.buffer = paramArrayOfByte;
        paramString1.tFK = paramArrayOfByte.length;
        paramArrayOfByte = new a.ba();
        paramArrayOfByte.type = 3;
        paramArrayOfByte.wJw = paramString1;
        locale.wGj = paramArrayOfByte;
        this.wFz = 2;
        this.wFA = paramInt2;
        locale.wGl = 2;
        locale.netType = k.ij(com.tencent.pb.common.c.d.pZI);
      }
      catch (Exception paramString1)
      {
        c.x(this.TAG2, new Object[] { "NetSceneEnterVoiceRoom constructor", paramString1 });
        continue;
      }
      c(141, locale);
      return;
      paramString1.tFK = 0;
    }
  }
  
  protected final Object bK(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      try
      {
        paramArrayOfByte = (a.aa)com.google.a.a.e.a(new a.aa(), paramArrayOfByte, paramArrayOfByte.length);
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
    return "CsCmd.Cmd_V_CSEnterVoiceRoomReq";
  }
  
  public final int getType()
  {
    return 202;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.e
 * JD-Core Version:    0.7.0.1
 */