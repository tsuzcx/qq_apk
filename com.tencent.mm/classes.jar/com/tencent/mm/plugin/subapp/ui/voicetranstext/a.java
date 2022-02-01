package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cfh;
import com.tencent.mm.protocal.protobuf.did;
import com.tencent.mm.protocal.protobuf.dky;
import com.tencent.mm.protocal.protobuf.dld;
import com.tencent.mm.protocal.protobuf.wa;
import com.tencent.mm.protocal.protobuf.wb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
  extends n
  implements k
{
  public static int yGB = 1;
  public static int yGC = 2;
  public static int yGD = 3;
  private int Scene;
  private String dxK;
  private b gUN;
  private String mFileName;
  public int mState;
  private g ubG;
  private String yGA;
  public dld yGE;
  public did yGF;
  public cfh yGG;
  int yGH;
  private String yGw;
  private int yGx;
  private dky yGy;
  private long yGz;
  
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
    locala.gUU = new wa();
    locala.gUV = new wb();
    locala.uri = "/cgi-bin/micromsg-bin/checkvoicetrans";
    locala.funcId = 546;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.mFileName = paramString2;
    this.gUN = locala.atI();
    ad.i("MicroMsg.NetSceneCheckVoiceTrans", "voiceId:%s, totalLen:%d, encodeType: %d, svrMsgId: %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
    if (paramInt2 >= 0) {
      this.yGy = d.bX(paramInt2, paramString2);
    }
    if (paramLong > 0L) {
      this.yGz = paramLong;
    }
    this.yGw = paramString1;
    this.yGx = paramInt1;
    this.Scene = paramInt3;
    this.yGA = paramString3;
    this.dxK = paramString4;
    AppMethodBeat.o(29266);
  }
  
  public final boolean dMx()
  {
    AppMethodBeat.i(29269);
    if ((this.yGE != null) && (!bt.isNullOrNil(this.yGE.EAP)))
    {
      AppMethodBeat.o(29269);
      return true;
    }
    AppMethodBeat.o(29269);
    return false;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(29267);
    this.ubG = paramg;
    paramg = (wa)this.gUN.gUS.gUX;
    paramg.CLB = this.yGw;
    paramg.uKQ = this.yGx;
    paramg.CXZ = this.yGy;
    paramg.uKZ = this.yGz;
    paramg.Scene = this.Scene;
    paramg.sdQ = this.yGA;
    paramg.sdP = this.dxK;
    int i = dispatch(parame, this.gUN, this);
    AppMethodBeat.o(29267);
    return i;
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
      paramq = (wb)this.gUN.gUT.gUX;
      if (paramq == null)
      {
        AppMethodBeat.o(29268);
        return;
      }
      this.yGE = paramq.CYa;
      this.mState = paramq.mBi;
      this.yGF = paramq.CYb;
      this.yGG = paramq.CYc;
      this.yGH = paramq.CYd;
    }
    for (;;)
    {
      this.ubG.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29268);
      return;
      ad.i("MicroMsg.NetSceneCheckVoiceTrans", "end checkVoiceTrans, & errType:%d, errCode:%d, voiceId: %s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), this.yGw });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.a
 * JD-Core Version:    0.7.0.1
 */