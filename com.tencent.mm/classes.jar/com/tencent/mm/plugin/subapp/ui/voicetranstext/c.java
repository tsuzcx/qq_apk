package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.modelvoice.b;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.eoe;
import com.tencent.mm.protocal.protobuf.eof;
import com.tencent.mm.protocal.protobuf.eog;
import com.tencent.mm.protocal.protobuf.esg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import junit.framework.Assert;

public final class c
  extends q
  implements m
{
  private i AAQ;
  private String FNA;
  private esg FNC;
  public eoe FNI;
  private int Scene;
  private final String TAG;
  private String dkU;
  private String dkV;
  private com.tencent.mm.ak.d iLF;
  private String mFileName;
  
  public c(c paramc)
  {
    AppMethodBeat.i(29274);
    this.TAG = "MicroMsg.NetSceneUploadVoiceForTrans";
    this.FNA = paramc.FNA;
    this.FNC = paramc.FNC;
    this.FNI = paramc.FNI;
    this.mFileName = paramc.mFileName;
    this.Scene = paramc.Scene;
    this.dkU = paramc.dkU;
    this.dkV = paramc.dkV;
    Log.d("MicroMsg.NetSceneUploadVoiceForTrans", "alvinluo voiceTrans constructor scene: %d, fromUser: %s, toUser: %s", new Object[] { Integer.valueOf(paramc.Scene), paramc.dkU, paramc.dkV });
    ftv();
    AppMethodBeat.o(29274);
  }
  
  public c(String paramString1, eoe parameoe, int paramInt, String paramString2)
  {
    AppMethodBeat.i(29275);
    this.TAG = "MicroMsg.NetSceneUploadVoiceForTrans";
    if (paramString2 != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.FNA = paramString1;
      this.FNI = parameoe;
      this.FNC = d.cz(paramInt, paramString2);
      this.mFileName = paramString2;
      ftv();
      AppMethodBeat.o(29275);
      return;
    }
  }
  
  public c(String paramString1, eoe parameoe, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(29276);
    this.TAG = "MicroMsg.NetSceneUploadVoiceForTrans";
    if (paramString2 != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      Log.d("MicroMsg.NetSceneUploadVoiceForTrans", "alvinluo voiceTrans scene: %d, fromUser: %s, toUser: %s", new Object[] { Integer.valueOf(paramInt2), paramString3, paramString4 });
      this.FNA = paramString1;
      this.FNI = parameoe;
      this.FNC = d.cz(paramInt1, paramString2);
      this.mFileName = paramString2;
      this.Scene = paramInt2;
      this.dkU = paramString3;
      this.dkV = paramString4;
      ftv();
      AppMethodBeat.o(29276);
      return;
    }
  }
  
  private void ftv()
  {
    AppMethodBeat.i(29279);
    d.a locala = new d.a();
    locala.iLN = new eof();
    locala.iLO = new eog();
    locala.uri = "/cgi-bin/micromsg-bin/uploadvoicefortrans";
    locala.funcId = 547;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.iLF = locala.aXF();
    AppMethodBeat.o(29279);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(29277);
    this.AAQ = parami;
    if ((!Util.isNullOrNil(this.mFileName)) && (!Util.isNullOrNil(this.FNA)) && (this.FNI != null) && (this.FNC != null)) {}
    for (int i = 1; i == 0; i = 0)
    {
      Log.e("MicroMsg.NetSceneUploadVoiceForTrans", "doScene: Value not Valid, so, do nothing.");
      AppMethodBeat.o(29277);
      return -1;
    }
    eof localeof = (eof)this.iLF.iLK.iLR;
    localeof.KXr = this.FNA;
    localeof.Llj = this.FNC;
    localeof.Lll = this.FNI;
    Object localObject = this.mFileName;
    i = this.FNI.BsG;
    int j = this.FNI.BsH;
    parami = new SKBuiltinBuffer_t();
    localObject = com.tencent.mm.modelvoice.s.Rf((String)localObject);
    if (localObject != null) {
      parami = z.aC(((b)localObject).dB(i, j).buf);
    }
    localeof.BsI = parami;
    localeof.Scene = this.Scene;
    localeof.xNH = this.dkU;
    localeof.xNG = this.dkV;
    i = dispatch(paramg, this.iLF, this);
    AppMethodBeat.o(29277);
    return i;
  }
  
  public final boolean ftw()
  {
    return (this.FNI == null) || (this.FNI.BsH <= 0);
  }
  
  public final int getType()
  {
    return 547;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29278);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.FNI = ((eog)this.iLF.iLL.iLR).Lll;
      this.AAQ.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (!ftw()) {
        break label128;
      }
      if (this.FNI == null) {
        break label122;
      }
    }
    label122:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.NetSceneUploadVoiceForTrans", "succeeed finish: %B", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(29278);
      return;
      Log.d("MicroMsg.NetSceneUploadVoiceForTrans", "error upload: errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      break;
    }
    label128:
    AppMethodBeat.o(29278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.c
 * JD-Core Version:    0.7.0.1
 */