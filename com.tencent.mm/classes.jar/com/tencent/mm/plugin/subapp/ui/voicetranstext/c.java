package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.did;
import com.tencent.mm.protocal.protobuf.die;
import com.tencent.mm.protocal.protobuf.dif;
import com.tencent.mm.protocal.protobuf.dky;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import junit.framework.Assert;

public final class c
  extends n
  implements k
{
  private int Scene;
  private final String TAG;
  private String dxK;
  private com.tencent.mm.al.b gUN;
  private String mFileName;
  private com.tencent.mm.al.g ubG;
  private String yGA;
  public did yGF;
  private String yGw;
  private dky yGy;
  
  public c(c paramc)
  {
    AppMethodBeat.i(29274);
    this.TAG = "MicroMsg.NetSceneUploadVoiceForTrans";
    this.yGw = paramc.yGw;
    this.yGy = paramc.yGy;
    this.yGF = paramc.yGF;
    this.mFileName = paramc.mFileName;
    this.Scene = paramc.Scene;
    this.yGA = paramc.yGA;
    this.dxK = paramc.dxK;
    ad.d("MicroMsg.NetSceneUploadVoiceForTrans", "alvinluo voiceTrans constructor scene: %d, fromUser: %s, toUser: %s", new Object[] { Integer.valueOf(paramc.Scene), paramc.yGA, paramc.dxK });
    dMy();
    AppMethodBeat.o(29274);
  }
  
  public c(String paramString1, did paramdid, int paramInt, String paramString2)
  {
    AppMethodBeat.i(29275);
    this.TAG = "MicroMsg.NetSceneUploadVoiceForTrans";
    if (paramString2 != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.yGw = paramString1;
      this.yGF = paramdid;
      this.yGy = d.bX(paramInt, paramString2);
      this.mFileName = paramString2;
      dMy();
      AppMethodBeat.o(29275);
      return;
    }
  }
  
  public c(String paramString1, did paramdid, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(29276);
    this.TAG = "MicroMsg.NetSceneUploadVoiceForTrans";
    if (paramString2 != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ad.d("MicroMsg.NetSceneUploadVoiceForTrans", "alvinluo voiceTrans scene: %d, fromUser: %s, toUser: %s", new Object[] { Integer.valueOf(paramInt2), paramString3, paramString4 });
      this.yGw = paramString1;
      this.yGF = paramdid;
      this.yGy = d.bX(paramInt1, paramString2);
      this.mFileName = paramString2;
      this.Scene = paramInt2;
      this.yGA = paramString3;
      this.dxK = paramString4;
      dMy();
      AppMethodBeat.o(29276);
      return;
    }
  }
  
  private void dMy()
  {
    AppMethodBeat.i(29279);
    b.a locala = new b.a();
    locala.gUU = new die();
    locala.gUV = new dif();
    locala.uri = "/cgi-bin/micromsg-bin/uploadvoicefortrans";
    locala.funcId = 547;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.gUN = locala.atI();
    AppMethodBeat.o(29279);
  }
  
  public final boolean dMz()
  {
    return (this.yGF == null) || (this.yGF.uKS <= 0);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(29277);
    this.ubG = paramg;
    if ((!bt.isNullOrNil(this.mFileName)) && (!bt.isNullOrNil(this.yGw)) && (this.yGF != null) && (this.yGy != null)) {}
    for (int i = 1; i == 0; i = 0)
    {
      ad.e("MicroMsg.NetSceneUploadVoiceForTrans", "doScene: Value not Valid, so, do nothing.");
      AppMethodBeat.o(29277);
      return -1;
    }
    die localdie = (die)this.gUN.gUS.gUX;
    localdie.CLB = this.yGw;
    localdie.CXZ = this.yGy;
    localdie.CYb = this.yGF;
    Object localObject = this.mFileName;
    i = this.yGF.uKR;
    int j = this.yGF.uKS;
    paramg = new SKBuiltinBuffer_t();
    localObject = s.Ax((String)localObject);
    if (localObject != null) {
      paramg = z.am(((com.tencent.mm.modelvoice.b)localObject).dp(i, j).buf);
    }
    localdie.uKT = paramg;
    localdie.Scene = this.Scene;
    localdie.sdQ = this.yGA;
    localdie.sdP = this.dxK;
    i = dispatch(parame, this.gUN, this);
    AppMethodBeat.o(29277);
    return i;
  }
  
  public final int getType()
  {
    return 547;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29278);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.yGF = ((dif)this.gUN.gUT.gUX).CYb;
      this.ubG.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (!dMz()) {
        break label128;
      }
      if (this.yGF == null) {
        break label122;
      }
    }
    label122:
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.NetSceneUploadVoiceForTrans", "succeeed finish: %B", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(29278);
      return;
      ad.d("MicroMsg.NetSceneUploadVoiceForTrans", "error upload: errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      break;
    }
    label128:
    AppMethodBeat.o(29278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.c
 * JD-Core Version:    0.7.0.1
 */