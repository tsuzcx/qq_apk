package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dns;
import com.tencent.mm.protocal.protobuf.dnt;
import com.tencent.mm.protocal.protobuf.dnu;
import com.tencent.mm.protocal.protobuf.dqp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import junit.framework.Assert;

public final class c
  extends n
  implements k
{
  private int Scene;
  private final String TAG;
  private String dvw;
  private com.tencent.mm.ak.b hvm;
  private String mFileName;
  private com.tencent.mm.ak.g vkE;
  private String zTK;
  private dqp zTM;
  private String zTO;
  public dns zTT;
  
  public c(c paramc)
  {
    AppMethodBeat.i(29274);
    this.TAG = "MicroMsg.NetSceneUploadVoiceForTrans";
    this.zTK = paramc.zTK;
    this.zTM = paramc.zTM;
    this.zTT = paramc.zTT;
    this.mFileName = paramc.mFileName;
    this.Scene = paramc.Scene;
    this.zTO = paramc.zTO;
    this.dvw = paramc.dvw;
    ac.d("MicroMsg.NetSceneUploadVoiceForTrans", "alvinluo voiceTrans constructor scene: %d, fromUser: %s, toUser: %s", new Object[] { Integer.valueOf(paramc.Scene), paramc.zTO, paramc.dvw });
    eaY();
    AppMethodBeat.o(29274);
  }
  
  public c(String paramString1, dns paramdns, int paramInt, String paramString2)
  {
    AppMethodBeat.i(29275);
    this.TAG = "MicroMsg.NetSceneUploadVoiceForTrans";
    if (paramString2 != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.zTK = paramString1;
      this.zTT = paramdns;
      this.zTM = d.cb(paramInt, paramString2);
      this.mFileName = paramString2;
      eaY();
      AppMethodBeat.o(29275);
      return;
    }
  }
  
  public c(String paramString1, dns paramdns, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(29276);
    this.TAG = "MicroMsg.NetSceneUploadVoiceForTrans";
    if (paramString2 != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ac.d("MicroMsg.NetSceneUploadVoiceForTrans", "alvinluo voiceTrans scene: %d, fromUser: %s, toUser: %s", new Object[] { Integer.valueOf(paramInt2), paramString3, paramString4 });
      this.zTK = paramString1;
      this.zTT = paramdns;
      this.zTM = d.cb(paramInt1, paramString2);
      this.mFileName = paramString2;
      this.Scene = paramInt2;
      this.zTO = paramString3;
      this.dvw = paramString4;
      eaY();
      AppMethodBeat.o(29276);
      return;
    }
  }
  
  private void eaY()
  {
    AppMethodBeat.i(29279);
    b.a locala = new b.a();
    locala.hvt = new dnt();
    locala.hvu = new dnu();
    locala.uri = "/cgi-bin/micromsg-bin/uploadvoicefortrans";
    locala.funcId = 547;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.hvm = locala.aAz();
    AppMethodBeat.o(29279);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(29277);
    this.vkE = paramg;
    if ((!bs.isNullOrNil(this.mFileName)) && (!bs.isNullOrNil(this.zTK)) && (this.zTT != null) && (this.zTM != null)) {}
    for (int i = 1; i == 0; i = 0)
    {
      ac.e("MicroMsg.NetSceneUploadVoiceForTrans", "doScene: Value not Valid, so, do nothing.");
      AppMethodBeat.o(29277);
      return -1;
    }
    dnt localdnt = (dnt)this.hvm.hvr.hvw;
    localdnt.Eee = this.zTK;
    localdnt.EqI = this.zTM;
    localdnt.EqK = this.zTT;
    Object localObject = this.mFileName;
    i = this.zTT.vTI;
    int j = this.zTT.vTJ;
    paramg = new SKBuiltinBuffer_t();
    localObject = s.EC((String)localObject);
    if (localObject != null) {
      paramg = z.al(((com.tencent.mm.modelvoice.b)localObject).dp(i, j).buf);
    }
    localdnt.vTK = paramg;
    localdnt.Scene = this.Scene;
    localdnt.tlK = this.zTO;
    localdnt.tlJ = this.dvw;
    i = dispatch(parame, this.hvm, this);
    AppMethodBeat.o(29277);
    return i;
  }
  
  public final boolean eaZ()
  {
    return (this.zTT == null) || (this.zTT.vTJ <= 0);
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
      this.zTT = ((dnu)this.hvm.hvs.hvw).EqK;
      this.vkE.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (!eaZ()) {
        break label128;
      }
      if (this.zTT == null) {
        break label122;
      }
    }
    label122:
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.NetSceneUploadVoiceForTrans", "succeeed finish: %B", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(29278);
      return;
      ac.d("MicroMsg.NetSceneUploadVoiceForTrans", "error upload: errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      break;
    }
    label128:
    AppMethodBeat.o(29278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.c
 * JD-Core Version:    0.7.0.1
 */