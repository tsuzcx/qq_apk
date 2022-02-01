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
  public String MIM;
  public boolean MKY;
  public int mType;
  
  public d(String paramString1, String[] paramArrayOfString, byte[] paramArrayOfByte, String paramString2, a.bb parambb, int paramInt1, int paramInt2, long paramLong, String paramString3, boolean paramBoolean, String paramString4)
  {
    AppMethodBeat.i(208320);
    this.MKY = true;
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "create" });
    a.d locald = new a.d();
    for (;;)
    {
      try
      {
        locald.McZ = paramString1;
        this.MIM = paramString1;
        locald.Mde = paramInt1;
        this.Mcu = paramInt1;
        if (parambb != null) {
          locald.Mdg = parambb;
        }
        paramString1 = new a.aw();
        paramString1.name = paramString2;
        paramString1.Mfy = paramString4;
        paramString1.Mfx = a.fXK();
        paramString1.dui = paramInt2;
        this.mType = paramInt2;
        this.MKY = paramBoolean;
        paramString1.Mfq = paramLong;
        locald.Mdb = paramString1;
        locald.Mdi = paramArrayOfString;
        paramString1 = paramString3;
        if (paramString3 == null) {
          paramString1 = "";
        }
        locald.Mdh = paramString1;
        paramString1 = new a.an();
        if (paramArrayOfByte == null) {
          continue;
        }
        paramString1.buffer = paramArrayOfByte;
        paramString1.iLen = paramArrayOfByte.length;
        paramArrayOfString = new a.bd();
        paramArrayOfString.type = 3;
        paramArrayOfString.Mgr = paramString1;
        locald.Mdd = paramArrayOfString;
        this.mNetType = 3;
        locald.Mdf = 2;
        locald.netType = k.ly(c.CDp);
      }
      catch (Exception paramString1)
      {
        b.w(this.TAG2, new Object[] { "NetSceneCreateVoiceGroup constructor", paramString1 });
        continue;
      }
      c(139, locald);
      AppMethodBeat.o(208320);
      return;
      paramString1.iLen = 0;
    }
  }
  
  public final Object cL(byte[] paramArrayOfByte)
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
  
  public final String fXq()
  {
    return "CsCmd.Cmd_V_CSCreateVoiceGroupReq";
  }
  
  public final int getType()
  {
    return 201;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.d
 * JD-Core Version:    0.7.0.1
 */