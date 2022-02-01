package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cqe;
import com.tencent.mm.protocal.protobuf.dug;
import com.tencent.mm.protocal.protobuf.dya;
import com.tencent.mm.protocal.protobuf.dyf;
import com.tencent.mm.protocal.protobuf.ym;
import com.tencent.mm.protocal.protobuf.yn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class a
  extends n
  implements k
{
  public static int BCS = 1;
  public static int BCT = 2;
  public static int BCU = 3;
  private String BCO;
  private int BCP;
  private dya BCQ;
  private long BCR;
  public dyf BCV;
  public dug BCW;
  public cqe BCX;
  int BCY;
  private int Scene;
  private String cUA;
  private String cUB;
  private b hQy;
  private String mFileName;
  public int mState;
  private f wFF;
  
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
    locala.hQF = new ym();
    locala.hQG = new yn();
    locala.uri = "/cgi-bin/micromsg-bin/checkvoicetrans";
    locala.funcId = 546;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.mFileName = paramString2;
    this.hQy = locala.aDS();
    ae.i("MicroMsg.NetSceneCheckVoiceTrans", "voiceId:%s, totalLen:%d, encodeType: %d, svrMsgId: %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
    if (paramInt2 >= 0) {
      this.BCQ = d.ci(paramInt2, paramString2);
    }
    if (paramLong > 0L) {
      this.BCR = paramLong;
    }
    this.BCO = paramString1;
    this.BCP = paramInt1;
    this.Scene = paramInt3;
    this.cUA = paramString3;
    this.cUB = paramString4;
    AppMethodBeat.o(29266);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(29267);
    this.wFF = paramf;
    paramf = (ym)this.hQy.hQD.hQJ;
    paramf.Gdc = this.BCO;
    paramf.xsB = this.BCP;
    paramf.Gqr = this.BCQ;
    paramf.xrk = this.BCR;
    paramf.Scene = this.Scene;
    paramf.uvG = this.cUA;
    paramf.uvF = this.cUB;
    int i = dispatch(parame, this.hQy, this);
    AppMethodBeat.o(29267);
    return i;
  }
  
  public final boolean eqW()
  {
    AppMethodBeat.i(29269);
    if ((this.BCV != null) && (!bu.isNullOrNil(this.BCV.Idg)))
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
      paramq = (yn)this.hQy.hQE.hQJ;
      if (paramq == null)
      {
        AppMethodBeat.o(29268);
        return;
      }
      this.BCV = paramq.Gqs;
      this.mState = paramq.nJb;
      this.BCW = paramq.Gqt;
      this.BCX = paramq.Gqu;
      this.BCY = paramq.Gqv;
    }
    for (;;)
    {
      this.wFF.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29268);
      return;
      ae.i("MicroMsg.NetSceneCheckVoiceTrans", "end checkVoiceTrans, & errType:%d, errCode:%d, voiceId: %s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), this.BCO });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.a
 * JD-Core Version:    0.7.0.1
 */