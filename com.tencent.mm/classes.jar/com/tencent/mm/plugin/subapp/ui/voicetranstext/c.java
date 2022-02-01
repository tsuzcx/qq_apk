package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.modelvoice.g;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dug;
import com.tencent.mm.protocal.protobuf.duh;
import com.tencent.mm.protocal.protobuf.dui;
import com.tencent.mm.protocal.protobuf.dya;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import junit.framework.Assert;

public final class c
  extends n
  implements k
{
  private String BCO;
  private dya BCQ;
  public dug BCW;
  private int Scene;
  private final String TAG;
  private String cUA;
  private String cUB;
  private com.tencent.mm.ak.b hQy;
  private String mFileName;
  private f wFF;
  
  public c(c paramc)
  {
    AppMethodBeat.i(29274);
    this.TAG = "MicroMsg.NetSceneUploadVoiceForTrans";
    this.BCO = paramc.BCO;
    this.BCQ = paramc.BCQ;
    this.BCW = paramc.BCW;
    this.mFileName = paramc.mFileName;
    this.Scene = paramc.Scene;
    this.cUA = paramc.cUA;
    this.cUB = paramc.cUB;
    ae.d("MicroMsg.NetSceneUploadVoiceForTrans", "alvinluo voiceTrans constructor scene: %d, fromUser: %s, toUser: %s", new Object[] { Integer.valueOf(paramc.Scene), paramc.cUA, paramc.cUB });
    eqX();
    AppMethodBeat.o(29274);
  }
  
  public c(String paramString1, dug paramdug, int paramInt, String paramString2)
  {
    AppMethodBeat.i(29275);
    this.TAG = "MicroMsg.NetSceneUploadVoiceForTrans";
    if (paramString2 != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.BCO = paramString1;
      this.BCW = paramdug;
      this.BCQ = d.ci(paramInt, paramString2);
      this.mFileName = paramString2;
      eqX();
      AppMethodBeat.o(29275);
      return;
    }
  }
  
  public c(String paramString1, dug paramdug, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(29276);
    this.TAG = "MicroMsg.NetSceneUploadVoiceForTrans";
    if (paramString2 != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ae.d("MicroMsg.NetSceneUploadVoiceForTrans", "alvinluo voiceTrans scene: %d, fromUser: %s, toUser: %s", new Object[] { Integer.valueOf(paramInt2), paramString3, paramString4 });
      this.BCO = paramString1;
      this.BCW = paramdug;
      this.BCQ = d.ci(paramInt1, paramString2);
      this.mFileName = paramString2;
      this.Scene = paramInt2;
      this.cUA = paramString3;
      this.cUB = paramString4;
      eqX();
      AppMethodBeat.o(29276);
      return;
    }
  }
  
  private void eqX()
  {
    AppMethodBeat.i(29279);
    b.a locala = new b.a();
    locala.hQF = new duh();
    locala.hQG = new dui();
    locala.uri = "/cgi-bin/micromsg-bin/uploadvoicefortrans";
    locala.funcId = 547;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.hQy = locala.aDS();
    AppMethodBeat.o(29279);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(29277);
    this.wFF = paramf;
    if ((!bu.isNullOrNil(this.mFileName)) && (!bu.isNullOrNil(this.BCO)) && (this.BCW != null) && (this.BCQ != null)) {}
    for (int i = 1; i == 0; i = 0)
    {
      ae.e("MicroMsg.NetSceneUploadVoiceForTrans", "doScene: Value not Valid, so, do nothing.");
      AppMethodBeat.o(29277);
      return -1;
    }
    duh localduh = (duh)this.hQy.hQD.hQJ;
    localduh.Gdc = this.BCO;
    localduh.Gqr = this.BCQ;
    localduh.Gqt = this.BCW;
    Object localObject = this.mFileName;
    i = this.BCW.xsC;
    int j = this.BCW.xsD;
    paramf = new SKBuiltinBuffer_t();
    localObject = s.It((String)localObject);
    if (localObject != null) {
      paramf = z.al(((com.tencent.mm.modelvoice.b)localObject).dr(i, j).buf);
    }
    localduh.xsE = paramf;
    localduh.Scene = this.Scene;
    localduh.uvG = this.cUA;
    localduh.uvF = this.cUB;
    i = dispatch(parame, this.hQy, this);
    AppMethodBeat.o(29277);
    return i;
  }
  
  public final boolean eqY()
  {
    return (this.BCW == null) || (this.BCW.xsD <= 0);
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
      this.BCW = ((dui)this.hQy.hQE.hQJ).Gqt;
      this.wFF.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (!eqY()) {
        break label128;
      }
      if (this.BCW == null) {
        break label122;
      }
    }
    label122:
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.NetSceneUploadVoiceForTrans", "succeeed finish: %B", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(29278);
      return;
      ae.d("MicroMsg.NetSceneUploadVoiceForTrans", "error upload: errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      break;
    }
    label128:
    AppMethodBeat.o(29278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.c
 * JD-Core Version:    0.7.0.1
 */