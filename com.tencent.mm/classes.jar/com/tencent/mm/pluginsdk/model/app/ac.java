package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.an.f;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.uj;
import com.tencent.mm.protocal.protobuf.uk;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;

public final class ac
  extends n
  implements k
{
  private final a Diw;
  private g callback;
  private b rr;
  
  public ac(k.b paramb, String paramString1, String paramString2, a parama)
  {
    AppMethodBeat.i(31048);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new uj();
    ((b.a)localObject).hvu = new uk();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/checkbigfileupload";
    ((b.a)localObject).funcId = 727;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (uj)this.rr.hvr.hvw;
    if ((paramb != null) && (!bs.isNullOrNil(paramb.fQi)) && (!bs.isNullOrNil(paramb.filemd5)))
    {
      ((uj)localObject).EhA = paramb.fQi;
      ((uj)localObject).Eot = paramb.filemd5;
      ((uj)localObject).Eou = paramb.title;
      ((uj)localObject).DUF = paramb.hhG;
    }
    for (((uj)localObject).DUE = paramb.hhF;; ((uj)localObject).DUE = ((int)i.aSp(paramString1)))
    {
      ((uj)localObject).DTc = com.tencent.mm.i.a.fqr;
      ((uj)localObject).tlJ = paramString2;
      ((uj)localObject).tlK = u.axw();
      this.Diw = parama;
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneCheckBigFileUpload", "summerbig NetSceneCheckBigFileUpload content[%s], aesKey[%s] md5[%s] FileName[%s] FileSize[%d] FileExt[%s] talker[%s], fromUserName[%s], stack[%s]", new Object[] { paramb, ((uj)localObject).EhA, ((uj)localObject).Eot, ((uj)localObject).Eou, Long.valueOf(((uj)localObject).DUE), ((uj)localObject).DUF, ((uj)localObject).tlJ, ((uj)localObject).tlK, bs.eWi() });
      AppMethodBeat.o(31048);
      return;
      f.aDE();
      ((uj)localObject).EhA = com.tencent.mm.an.a.aDw();
      f.aDE();
      ((uj)localObject).Eot = com.tencent.mm.an.a.BK(paramString1);
      ((uj)localObject).Eou = i.aSu(paramString1);
      ((uj)localObject).DUF = i.VW(paramString1);
    }
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(31049);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(31049);
    return i;
  }
  
  public final int getType()
  {
    return 727;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(31050);
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneCheckBigFileUpload", "summerbig onGYNetEnd [%d, %d, %s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneCheckBigFileUpload", "summerbig onGYNetEnd errType = " + paramInt2 + ", errCode = " + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (this.Diw != null) {
        this.Diw.a("", "", "", "", "", 0L);
      }
      AppMethodBeat.o(31050);
      return;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    paramString = (uj)((b)paramq).hvr.hvw;
    paramq = (uk)((b)paramq).hvs.hvw;
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneCheckBigFileUpload", "summersafecdn onGYNetEnd Signature[%s], fuin[%d], faeskey[%s], fSignature[%s]", new Object[] { paramq.iJW, Integer.valueOf(paramq.Eov), paramq.Eow, paramq.Eox });
    if (this.Diw != null) {
      this.Diw.a(paramString.Eot, paramString.EhA, paramq.iJW, paramq.Eow, paramq.Eox, paramString.DUE);
    }
    AppMethodBeat.o(31050);
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ac
 * JD-Core Version:    0.7.0.1
 */