package com.tencent.wecall.talkroom.a;

import com.google.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.a.a.a;
import com.tencent.pb.common.b.a.a.a.aa;
import com.tencent.pb.common.b.a.a.a.an;
import com.tencent.pb.common.b.a.a.a.aw;
import com.tencent.pb.common.b.a.a.a.bb;
import com.tencent.pb.common.b.a.a.a.bd;
import com.tencent.pb.common.b.a.a.a.d;
import com.tencent.pb.common.c.b;
import com.tencent.pb.common.c.c;
import com.tencent.wecall.talkroom.model.k;

public final class d
  extends com.tencent.pb.common.b.d
{
  public String IJy;
  public boolean ILJ;
  public int mType;
  
  public d(String paramString1, String[] paramArrayOfString, byte[] paramArrayOfByte, String paramString2, a.bb parambb, int paramInt1, int paramInt2, long paramLong, String paramString3, boolean paramBoolean, String paramString4)
  {
    AppMethodBeat.i(189087);
    this.ILJ = true;
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "create" });
    a.d locald = new a.d();
    for (;;)
    {
      try
      {
        locald.IkB = paramString1;
        this.IJy = paramString1;
        locald.IkG = paramInt1;
        this.IjW = paramInt1;
        if (parambb != null) {
          locald.IkI = parambb;
        }
        paramString1 = new a.aw();
        paramString1.name = paramString2;
        paramString1.ImY = paramString4;
        paramString1.ImX = a.flE();
        paramString1.dkj = paramInt2;
        this.mType = paramInt2;
        this.ILJ = paramBoolean;
        paramString1.ImQ = paramLong;
        locald.IkD = paramString1;
        locald.IkK = paramArrayOfString;
        paramString1 = paramString3;
        if (paramString3 == null) {
          paramString1 = "";
        }
        locald.IkJ = paramString1;
        paramString1 = new a.an();
        if (paramArrayOfByte == null) {
          continue;
        }
        paramString1.buffer = paramArrayOfByte;
        paramString1.iLen = paramArrayOfByte.length;
        paramArrayOfString = new a.bd();
        paramArrayOfString.type = 3;
        paramArrayOfString.InR = paramString1;
        locald.IkF = paramArrayOfString;
        this.mNetType = 3;
        locald.IkH = 2;
        locald.netType = k.kR(c.ztG);
      }
      catch (Exception paramString1)
      {
        b.w(this.TAG2, new Object[] { "NetSceneCreateVoiceGroup constructor", paramString1 });
        continue;
      }
      c(139, locald);
      AppMethodBeat.o(189087);
      return;
      paramString1.iLen = 0;
    }
  }
  
  public final Object cC(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62539);
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "data2Resp" });
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = (a.aa)e.a(new a.aa(), paramArrayOfByte, paramArrayOfByte.length);
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
  
  public final String flk()
  {
    return "CsCmd.Cmd_V_CSCreateVoiceGroupReq";
  }
  
  public final int getType()
  {
    return 201;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.d
 * JD-Core Version:    0.7.0.1
 */