package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.modelvoice.g;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cox;
import com.tencent.mm.protocal.protobuf.coy;
import com.tencent.mm.protocal.protobuf.coz;
import com.tencent.mm.protocal.protobuf.crd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import junit.framework.Assert;

public final class c
  extends m
  implements k
{
  private int Scene;
  private final String TAG;
  private String cGY;
  private com.tencent.mm.ai.b fsQ;
  private String mFileName;
  private f peg;
  private String sZY;
  private crd taa;
  private String tac;
  public cox tai;
  
  public c(c paramc)
  {
    AppMethodBeat.i(25584);
    this.TAG = "MicroMsg.NetSceneUploadVoiceForTrans";
    this.sZY = paramc.sZY;
    this.taa = paramc.taa;
    this.tai = paramc.tai;
    this.mFileName = paramc.mFileName;
    this.Scene = paramc.Scene;
    this.tac = paramc.tac;
    this.cGY = paramc.cGY;
    ab.d("MicroMsg.NetSceneUploadVoiceForTrans", "alvinluo voiceTrans constructor scene: %d, fromUser: %s, toUser: %s", new Object[] { Integer.valueOf(paramc.Scene), paramc.tac, paramc.cGY });
    cHe();
    AppMethodBeat.o(25584);
  }
  
  public c(String paramString1, cox paramcox, int paramInt, String paramString2)
  {
    AppMethodBeat.i(25585);
    this.TAG = "MicroMsg.NetSceneUploadVoiceForTrans";
    if (paramString2 != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.sZY = paramString1;
      this.tai = paramcox;
      this.taa = d.bm(paramInt, paramString2);
      this.mFileName = paramString2;
      cHe();
      AppMethodBeat.o(25585);
      return;
    }
  }
  
  public c(String paramString1, cox paramcox, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(25586);
    this.TAG = "MicroMsg.NetSceneUploadVoiceForTrans";
    if (paramString2 != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ab.d("MicroMsg.NetSceneUploadVoiceForTrans", "alvinluo voiceTrans scene: %d, fromUser: %s, toUser: %s", new Object[] { Integer.valueOf(paramInt2), paramString3, paramString4 });
      this.sZY = paramString1;
      this.tai = paramcox;
      this.taa = d.bm(paramInt1, paramString2);
      this.mFileName = paramString2;
      this.Scene = paramInt2;
      this.tac = paramString3;
      this.cGY = paramString4;
      cHe();
      AppMethodBeat.o(25586);
      return;
    }
  }
  
  private void cHe()
  {
    AppMethodBeat.i(25589);
    b.a locala = new b.a();
    locala.fsX = new coy();
    locala.fsY = new coz();
    locala.uri = "/cgi-bin/micromsg-bin/uploadvoicefortrans";
    locala.funcId = 547;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.fsQ = locala.ado();
    AppMethodBeat.o(25589);
  }
  
  public final boolean cHf()
  {
    return (this.tai == null) || (this.tai.pIz <= 0);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(25587);
    this.peg = paramf;
    if ((!bo.isNullOrNil(this.mFileName)) && (!bo.isNullOrNil(this.sZY)) && (this.tai != null) && (this.taa != null)) {}
    for (int i = 1; i == 0; i = 0)
    {
      ab.e("MicroMsg.NetSceneUploadVoiceForTrans", "doScene: Value not Valid, so, do nothing.");
      AppMethodBeat.o(25587);
      return -1;
    }
    coy localcoy = (coy)this.fsQ.fsV.fta;
    localcoy.wAs = this.sZY;
    localcoy.wLH = this.taa;
    localcoy.wLJ = this.tai;
    Object localObject = this.mFileName;
    i = this.tai.pIy;
    int j = this.tai.pIz;
    paramf = new SKBuiltinBuffer_t();
    localObject = s.vK((String)localObject);
    if (localObject != null) {
      paramf = aa.ac(((com.tencent.mm.modelvoice.b)localObject).cJ(i, j).buf);
    }
    localcoy.pIA = paramf;
    localcoy.Scene = this.Scene;
    localcoy.num = this.tac;
    localcoy.nul = this.cGY;
    i = dispatch(parame, this.fsQ, this);
    AppMethodBeat.o(25587);
    return i;
  }
  
  public final int getType()
  {
    return 547;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(25588);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.tai = ((coz)this.fsQ.fsW.fta).wLJ;
      this.peg.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (!cHf()) {
        break label128;
      }
      if (this.tai == null) {
        break label122;
      }
    }
    label122:
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.NetSceneUploadVoiceForTrans", "succeeed finish: %B", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(25588);
      return;
      ab.d("MicroMsg.NetSceneUploadVoiceForTrans", "error upload: errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      break;
    }
    label128:
    AppMethodBeat.o(25588);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.c
 * JD-Core Version:    0.7.0.1
 */