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
  public String MlP;
  public boolean Moc;
  public int mType;
  
  public d(String paramString1, String[] paramArrayOfString, byte[] paramArrayOfByte, String paramString2, a.bb parambb, int paramInt1, int paramInt2, long paramLong, String paramString3, boolean paramBoolean, String paramString4)
  {
    AppMethodBeat.i(213645);
    this.Moc = true;
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "create" });
    a.d locald = new a.d();
    for (;;)
    {
      try
      {
        locald.LFV = paramString1;
        this.MlP = paramString1;
        locald.LGa = paramInt1;
        this.LFq = paramInt1;
        if (parambb != null) {
          locald.LGc = parambb;
        }
        paramString1 = new a.aw();
        paramString1.name = paramString2;
        paramString1.LIu = paramString4;
        paramString1.LIt = a.fTk();
        paramString1.dtc = paramInt2;
        this.mType = paramInt2;
        this.Moc = paramBoolean;
        paramString1.LIm = paramLong;
        locald.LFX = paramString1;
        locald.LGe = paramArrayOfString;
        paramString1 = paramString3;
        if (paramString3 == null) {
          paramString1 = "";
        }
        locald.LGd = paramString1;
        paramString1 = new a.an();
        if (paramArrayOfByte == null) {
          continue;
        }
        paramString1.buffer = paramArrayOfByte;
        paramString1.iLen = paramArrayOfByte.length;
        paramArrayOfString = new a.bd();
        paramArrayOfString.type = 3;
        paramArrayOfString.LJn = paramString1;
        locald.LFZ = paramArrayOfString;
        this.mNetType = 3;
        locald.LGb = 2;
        locald.netType = k.ls(c.ClL);
      }
      catch (Exception paramString1)
      {
        b.w(this.TAG2, new Object[] { "NetSceneCreateVoiceGroup constructor", paramString1 });
        continue;
      }
      c(139, locald);
      AppMethodBeat.o(213645);
      return;
      paramString1.iLen = 0;
    }
  }
  
  public final Object cI(byte[] paramArrayOfByte)
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
  
  public final String fSQ()
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