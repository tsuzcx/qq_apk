package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.modelvoice.b;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eym;
import com.tencent.mm.protocal.protobuf.eyn;
import com.tencent.mm.protocal.protobuf.eyo;
import com.tencent.mm.protocal.protobuf.fcr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import junit.framework.Assert;

public final class c
  extends q
  implements m
{
  private int CPw;
  private i GtS;
  private String MhB;
  private fcr MhD;
  public eym MhJ;
  private final String TAG;
  private String fcC;
  private String fcD;
  private com.tencent.mm.an.d lBM;
  private String mFileName;
  
  public c(c paramc)
  {
    AppMethodBeat.i(29274);
    this.TAG = "MicroMsg.NetSceneUploadVoiceForTrans";
    this.MhB = paramc.MhB;
    this.MhD = paramc.MhD;
    this.MhJ = paramc.MhJ;
    this.mFileName = paramc.mFileName;
    this.CPw = paramc.CPw;
    this.fcC = paramc.fcC;
    this.fcD = paramc.fcD;
    Log.d("MicroMsg.NetSceneUploadVoiceForTrans", "alvinluo voiceTrans constructor scene: %d, fromUser: %s, toUser: %s", new Object[] { Integer.valueOf(paramc.CPw), paramc.fcC, paramc.fcD });
    ghV();
    AppMethodBeat.o(29274);
  }
  
  public c(String paramString1, eym parameym, int paramInt, String paramString2)
  {
    AppMethodBeat.i(29275);
    this.TAG = "MicroMsg.NetSceneUploadVoiceForTrans";
    if (paramString2 != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.MhB = paramString1;
      this.MhJ = parameym;
      this.MhD = d.cA(paramInt, paramString2);
      this.mFileName = paramString2;
      ghV();
      AppMethodBeat.o(29275);
      return;
    }
  }
  
  public c(String paramString1, eym parameym, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(29276);
    this.TAG = "MicroMsg.NetSceneUploadVoiceForTrans";
    if (paramString2 != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      Log.d("MicroMsg.NetSceneUploadVoiceForTrans", "alvinluo voiceTrans scene: %d, fromUser: %s, toUser: %s", new Object[] { Integer.valueOf(paramInt2), paramString3, paramString4 });
      this.MhB = paramString1;
      this.MhJ = parameym;
      this.MhD = d.cA(paramInt1, paramString2);
      this.mFileName = paramString2;
      this.CPw = paramInt2;
      this.fcC = paramString3;
      this.fcD = paramString4;
      ghV();
      AppMethodBeat.o(29276);
      return;
    }
  }
  
  private void ghV()
  {
    AppMethodBeat.i(29279);
    d.a locala = new d.a();
    locala.lBU = new eyn();
    locala.lBV = new eyo();
    locala.uri = "/cgi-bin/micromsg-bin/uploadvoicefortrans";
    locala.funcId = 547;
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.lBM = locala.bgN();
    AppMethodBeat.o(29279);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(29277);
    this.GtS = parami;
    if ((!Util.isNullOrNil(this.mFileName)) && (!Util.isNullOrNil(this.MhB)) && (this.MhJ != null) && (this.MhD != null)) {}
    for (int i = 1; i == 0; i = 0)
    {
      Log.e("MicroMsg.NetSceneUploadVoiceForTrans", "doScene: Value not Valid, so, do nothing.");
      AppMethodBeat.o(29277);
      return -1;
    }
    eyn localeyn = (eyn)d.b.b(this.lBM.lBR);
    localeyn.RYD = this.MhB;
    localeyn.Sms = this.MhD;
    localeyn.Smu = this.MhJ;
    Object localObject = this.mFileName;
    i = this.MhJ.Hna;
    int j = this.MhJ.Hnb;
    parami = new eae();
    localObject = com.tencent.mm.modelvoice.s.YC((String)localObject);
    if (localObject != null) {
      parami = z.aN(((b)localObject).dY(i, j).buf);
    }
    localeyn.Hnc = parami;
    localeyn.CPw = this.CPw;
    localeyn.CRR = this.fcC;
    localeyn.CRQ = this.fcD;
    i = dispatch(paramg, this.lBM, this);
    AppMethodBeat.o(29277);
    return i;
  }
  
  public final int getType()
  {
    return 547;
  }
  
  public final boolean ghW()
  {
    return (this.MhJ == null) || (this.MhJ.Hnb <= 0);
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29278);
    ghW();
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.MhJ = ((eyo)d.c.b(this.lBM.lBS)).Smu;
      this.GtS.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (!ghW()) {
        break label133;
      }
      if (this.MhJ == null) {
        break label127;
      }
    }
    label127:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.NetSceneUploadVoiceForTrans", "succeeed finish: %B", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(29278);
      return;
      Log.d("MicroMsg.NetSceneUploadVoiceForTrans", "error upload: errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      break;
    }
    label133:
    AppMethodBeat.o(29278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.c
 * JD-Core Version:    0.7.0.1
 */