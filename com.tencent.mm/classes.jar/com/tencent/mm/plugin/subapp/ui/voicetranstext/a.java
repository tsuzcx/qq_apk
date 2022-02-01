package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cpk;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.protocal.protobuf.dwj;
import com.tencent.mm.protocal.protobuf.dwo;
import com.tencent.mm.protocal.protobuf.yj;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
  extends n
  implements k
{
  public static int Blt = 1;
  public static int Blu = 2;
  public static int Blv = 3;
  private String Blp;
  private int Blq;
  private dwj Blr;
  private long Bls;
  public dwo Blw;
  public dtj Blx;
  public cpk Bly;
  int Blz;
  private int Scene;
  private String dHm;
  private String dHz;
  private b hNF;
  private String mFileName;
  public int mState;
  private f wpW;
  
  public a(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2)
  {
    AppMethodBeat.i(29263);
    this.mState = -1;
    a(paramString1, paramInt1, paramInt2, paramLong, paramString2, 0, "", "");
    AppMethodBeat.o(29263);
  }
  
  public a(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2, int paramInt3, String paramString3, String paramString4)
  {
    AppMethodBeat.i(29265);
    this.mState = -1;
    a(paramString1, paramInt1, paramInt2, paramLong, paramString2, paramInt3, paramString3, paramString4);
    AppMethodBeat.o(29265);
  }
  
  public a(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(29262);
    this.mState = -1;
    a(paramString1, paramInt, -1, -1L, paramString2, 0, "", "");
    AppMethodBeat.o(29262);
  }
  
  public a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(29264);
    this.mState = -1;
    a(paramString1, paramInt1, -1, -1L, paramString2, paramInt2, paramString3, paramString4);
    AppMethodBeat.o(29264);
  }
  
  private void a(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2, int paramInt3, String paramString3, String paramString4)
  {
    AppMethodBeat.i(29266);
    b.a locala = new b.a();
    locala.hNM = new yj();
    locala.hNN = new yk();
    locala.uri = "/cgi-bin/micromsg-bin/checkvoicetrans";
    locala.funcId = 546;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.mFileName = paramString2;
    this.hNF = locala.aDC();
    ad.i("MicroMsg.NetSceneCheckVoiceTrans", "voiceId:%s, totalLen:%d, encodeType: %d, svrMsgId: %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
    if (paramInt2 >= 0) {
      this.Blr = d.ci(paramInt2, paramString2);
    }
    if (paramLong > 0L) {
      this.Bls = paramLong;
    }
    this.Blp = paramString1;
    this.Blq = paramInt1;
    this.Scene = paramInt3;
    this.dHm = paramString3;
    this.dHz = paramString4;
    AppMethodBeat.o(29266);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(29267);
    this.wpW = paramf;
    paramf = (yj)this.hNF.hNK.hNQ;
    paramf.FKD = this.Blp;
    paramf.xcK = this.Blq;
    paramf.FXS = this.Blr;
    paramf.xbt = this.Bls;
    paramf.Scene = this.Scene;
    paramf.ukj = this.dHm;
    paramf.uki = this.dHz;
    int i = dispatch(parame, this.hNF, this);
    AppMethodBeat.o(29267);
    return i;
  }
  
  public final boolean eno()
  {
    AppMethodBeat.i(29269);
    if ((this.Blw != null) && (!bt.isNullOrNil(this.Blw.HIY)))
    {
      AppMethodBeat.o(29269);
      return true;
    }
    AppMethodBeat.o(29269);
    return false;
  }
  
  public final int getType()
  {
    return 546;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29268);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (yk)this.hNF.hNL.hNQ;
      if (paramq == null)
      {
        AppMethodBeat.o(29268);
        return;
      }
      this.Blw = paramq.FXT;
      this.mState = paramq.nDG;
      this.Blx = paramq.FXU;
      this.Bly = paramq.FXV;
      this.Blz = paramq.FXW;
    }
    for (;;)
    {
      this.wpW.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29268);
      return;
      ad.i("MicroMsg.NetSceneCheckVoiceTrans", "end checkVoiceTrans, & errType:%d, errCode:%d, voiceId: %s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), this.Blp });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.a
 * JD-Core Version:    0.7.0.1
 */