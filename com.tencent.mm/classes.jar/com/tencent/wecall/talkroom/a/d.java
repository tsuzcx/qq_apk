package com.tencent.wecall.talkroom.a;

import com.google.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.a.a.a;
import com.tencent.pb.common.b.a.a.a.ab;
import com.tencent.pb.common.b.a.a.a.ao;
import com.tencent.pb.common.b.a.a.a.ay;
import com.tencent.pb.common.b.a.a.a.bd;
import com.tencent.pb.common.b.a.a.a.bf;
import com.tencent.pb.common.b.a.a.a.d;
import com.tencent.pb.common.c.b;
import com.tencent.pb.common.c.c;
import com.tencent.wecall.talkroom.model.j;

public final class d
  extends com.tencent.pb.common.b.d
{
  public String ZVD;
  public boolean ZXR;
  public int mType;
  
  public d(String paramString1, String[] paramArrayOfString, byte[] paramArrayOfByte, String paramString2, a.bd parambd, int paramInt1, int paramInt2, long paramLong, String paramString3, boolean paramBoolean, String paramString4)
  {
    AppMethodBeat.i(209736);
    this.ZXR = true;
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "create" });
    a.d locald = new a.d();
    for (;;)
    {
      try
      {
        locald.ZeQ = paramString1;
        this.ZVD = paramString1;
        locald.ZeV = paramInt1;
        aAd(paramInt1);
        if (parambd != null) {
          locald.ZeX = parambd;
        }
        paramString1 = new a.ay();
        paramString1.name = paramString2;
        paramString1.Zhv = paramString4;
        paramString1.Zhu = a.ila();
        paramString1.fEi = paramInt2;
        this.mType = paramInt2;
        this.ZXR = paramBoolean;
        paramString1.Zhn = paramLong;
        locald.ZeS = paramString1;
        locald.ZeZ = paramArrayOfString;
        paramString1 = paramString3;
        if (paramString3 == null) {
          paramString1 = "";
        }
        locald.ZeY = paramString1;
        paramString1 = new a.ao();
        if (paramArrayOfByte == null) {
          continue;
        }
        paramString1.buffer = paramArrayOfByte;
        paramString1.Ufv = paramArrayOfByte.length;
        paramArrayOfString = new a.bf();
        paramArrayOfString.type = 3;
        paramArrayOfString.Zip = paramString1;
        locald.ZeU = paramArrayOfString;
        aAc(3);
        locald.ZeW = 2;
        locald.netType = j.mv(c.NYh);
      }
      catch (Exception paramString1)
      {
        b.w(this.TAG2, new Object[] { "NetSceneCreateVoiceGroup constructor", paramString1 });
        continue;
      }
      c(139, locald);
      AppMethodBeat.o(209736);
      return;
      paramString1.Ufv = 0;
    }
  }
  
  public final Object dn(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62539);
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "data2Resp" });
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = (a.ab)e.a(new a.ab(), paramArrayOfByte, paramArrayOfByte.length);
        AppMethodBeat.o(62539);
        return paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        b.w(this.TAG2, new Object[] { "data2Resp", paramArrayOfByte.getMessage() });
        paramArrayOfByte = null;
        continue;
      }
      paramArrayOfByte = null;
    }
  }
  
  public final int getType()
  {
    return 201;
  }
  
  public final String ikF()
  {
    return "CsCmd.Cmd_V_CSCreateVoiceGroupReq";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.d
 * JD-Core Version:    0.7.0.1
 */