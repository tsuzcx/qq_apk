package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.a.a.a;
import com.tencent.pb.common.b.a.a.a.ab;
import com.tencent.pb.common.b.a.a.a.ap;
import com.tencent.pb.common.b.a.a.a.az;
import com.tencent.pb.common.b.a.a.a.be;
import com.tencent.pb.common.b.a.a.a.bg;
import com.tencent.pb.common.b.a.a.a.d;
import com.tencent.pb.common.c.b;
import com.tencent.pb.common.c.c;
import com.tencent.wecall.talkroom.model.k;

public final class d
  extends com.tencent.pb.common.b.d
{
  public String SuH;
  public boolean SwT;
  public int mType;
  
  public d(String paramString1, String[] paramArrayOfString, byte[] paramArrayOfByte, String paramString2, a.be parambe, int paramInt1, int paramInt2, long paramLong, String paramString3, boolean paramBoolean, String paramString4)
  {
    AppMethodBeat.i(199660);
    this.SwT = true;
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "create" });
    a.d locald = new a.d();
    for (;;)
    {
      try
      {
        locald.RDo = paramString1;
        this.SuH = paramString1;
        locald.RDt = paramInt1;
        this.RCJ = paramInt1;
        if (parambe != null) {
          locald.RDv = parambe;
        }
        paramString1 = new a.az();
        paramString1.name = paramString2;
        paramString1.RFQ = paramString4;
        paramString1.RFP = a.hjq();
        paramString1.dLt = paramInt2;
        this.mType = paramInt2;
        this.SwT = paramBoolean;
        paramString1.RFI = paramLong;
        locald.RDq = paramString1;
        locald.RDx = paramArrayOfString;
        paramString1 = paramString3;
        if (paramString3 == null) {
          paramString1 = "";
        }
        locald.RDw = paramString1;
        paramString1 = new a.ap();
        if (paramArrayOfByte == null) {
          continue;
        }
        paramString1.buffer = paramArrayOfByte;
        paramString1.iLen = paramArrayOfByte.length;
        paramArrayOfString = new a.bg();
        paramArrayOfString.type = 3;
        paramArrayOfString.RGJ = paramString1;
        locald.RDs = paramArrayOfString;
        this.mNetType = 3;
        locald.RDu = 2;
        locald.netType = k.lx(c.Hhs);
      }
      catch (Exception paramString1)
      {
        b.w(this.TAG2, new Object[] { "NetSceneCreateVoiceGroup constructor", paramString1 });
        continue;
      }
      c(139, locald);
      AppMethodBeat.o(199660);
      return;
      paramString1.iLen = 0;
    }
  }
  
  public final Object cO(byte[] paramArrayOfByte)
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
  
  public final String hiV()
  {
    return "CsCmd.Cmd_V_CSCreateVoiceGroupReq";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.d
 * JD-Core Version:    0.7.0.1
 */