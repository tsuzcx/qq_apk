package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.pb.a.a.a;
import com.tencent.pb.common.b.a.a.al;
import com.tencent.pb.common.b.a.a.at;
import com.tencent.pb.common.b.a.a.ay;
import com.tencent.pb.common.b.a.a.ba;
import com.tencent.pb.common.b.a.a.d;
import com.tencent.pb.common.b.a.a.z;
import com.tencent.pb.common.c.c;
import com.tencent.wecall.talkroom.model.k;

public final class d
  extends com.tencent.pb.common.b.d
{
  public int mType;
  public String xdQ;
  public boolean xfO = true;
  
  public d(String paramString1, String[] paramArrayOfString, byte[] paramArrayOfByte, String paramString2, a.ay paramay, int paramInt1, int paramInt2, long paramLong, String paramString3, boolean paramBoolean, String paramString4)
  {
    c.d("MicroMsg.Voip", new Object[] { this.TAG2, "create" });
    a.d locald = new a.d();
    for (;;)
    {
      try
      {
        locald.wGf = paramString1;
        this.xdQ = paramString1;
        locald.wGk = paramInt1;
        this.wFA = paramInt1;
        if (paramay != null) {
          locald.wGm = paramay;
        }
        paramString1 = new a.at();
        paramString1.name = paramString2;
        paramString1.wIC = paramString4;
        paramString1.wIB = a.cOl();
        paramString1.bNM = paramInt2;
        this.mType = paramInt2;
        this.xfO = paramBoolean;
        paramString1.wIu = paramLong;
        locald.wGh = paramString1;
        locald.wGo = paramArrayOfString;
        paramString1 = paramString3;
        if (paramString3 == null) {
          paramString1 = "";
        }
        locald.wGn = paramString1;
        paramString1 = new a.al();
        if (paramArrayOfByte == null) {
          continue;
        }
        paramString1.buffer = paramArrayOfByte;
        paramString1.tFK = paramArrayOfByte.length;
        paramArrayOfString = new a.ba();
        paramArrayOfString.type = 3;
        paramArrayOfString.wJw = paramString1;
        locald.wGj = paramArrayOfString;
        this.wFz = 3;
        locald.wGl = 2;
        locald.netType = k.ij(com.tencent.pb.common.c.d.pZI);
      }
      catch (Exception paramString1)
      {
        c.x(this.TAG2, new Object[] { "NetSceneCreateVoiceGroup constructor", paramString1 });
        continue;
      }
      c(139, locald);
      return;
      paramString1.tFK = 0;
    }
  }
  
  protected final Object bK(byte[] paramArrayOfByte)
  {
    c.d("MicroMsg.Voip", new Object[] { this.TAG2, "data2Resp" });
    if (paramArrayOfByte != null) {
      try
      {
        paramArrayOfByte = (a.z)e.a(new a.z(), paramArrayOfByte, paramArrayOfByte.length);
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
    return "CsCmd.Cmd_V_CSCreateVoiceGroupReq";
  }
  
  public final int getType()
  {
    return 201;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.d
 * JD-Core Version:    0.7.0.1
 */