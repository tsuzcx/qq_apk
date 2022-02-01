package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.ao.f;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.tz;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;

public final class ac
  extends n
  implements k
{
  private final a BQi;
  private g callback;
  private b rr;
  
  public ac(k.b paramb, String paramString1, String paramString2, a parama)
  {
    AppMethodBeat.i(31048);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new tz();
    ((b.a)localObject).gUV = new ua();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/checkbigfileupload";
    ((b.a)localObject).funcId = 727;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (tz)this.rr.gUS.gUX;
    if ((paramb != null) && (!bt.isNullOrNil(paramb.fMw)) && (!bt.isNullOrNil(paramb.filemd5)))
    {
      ((tz)localObject).COP = paramb.fMw;
      ((tz)localObject).CVJ = paramb.filemd5;
      ((tz)localObject).CVK = paramb.title;
      ((tz)localObject).CCi = paramb.gHf;
    }
    for (((tz)localObject).CCh = paramb.gHe;; ((tz)localObject).CCh = ((int)i.aMN(paramString1)))
    {
      ((tz)localObject).CAG = com.tencent.mm.i.a.fmX;
      ((tz)localObject).sdP = paramString2;
      ((tz)localObject).sdQ = u.aqG();
      this.BQi = parama;
      ad.i("MicroMsg.NetSceneCheckBigFileUpload", "summerbig NetSceneCheckBigFileUpload content[%s], aesKey[%s] md5[%s] FileName[%s] FileSize[%d] FileExt[%s] talker[%s], fromUserName[%s], stack[%s]", new Object[] { paramb, ((tz)localObject).COP, ((tz)localObject).CVJ, ((tz)localObject).CVK, Long.valueOf(((tz)localObject).CCh), ((tz)localObject).CCi, ((tz)localObject).sdP, ((tz)localObject).sdQ, bt.eGN() });
      AppMethodBeat.o(31048);
      return;
      f.awM();
      ((tz)localObject).COP = com.tencent.mm.ao.a.awE();
      f.awM();
      ((tz)localObject).CVJ = com.tencent.mm.ao.a.xE(paramString1);
      ((tz)localObject).CVK = i.aMS(paramString1);
      ((tz)localObject).CCi = i.RK(paramString1);
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
    ad.d("MicroMsg.NetSceneCheckBigFileUpload", "summerbig onGYNetEnd [%d, %d, %s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ad.e("MicroMsg.NetSceneCheckBigFileUpload", "summerbig onGYNetEnd errType = " + paramInt2 + ", errCode = " + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (this.BQi != null) {
        this.BQi.a("", "", "", "", "", 0L);
      }
      AppMethodBeat.o(31050);
      return;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    paramString = (tz)((b)paramq).gUS.gUX;
    paramq = (ua)((b)paramq).gUT.gUX;
    ad.d("MicroMsg.NetSceneCheckBigFileUpload", "summersafecdn onGYNetEnd Signature[%s], fuin[%d], faeskey[%s], fSignature[%s]", new Object[] { paramq.ijP, Integer.valueOf(paramq.CVL), paramq.CVM, paramq.CVN });
    if (this.BQi != null) {
      this.BQi.a(paramString.CVJ, paramString.COP, paramq.ijP, paramq.CVM, paramq.CVN, paramString.CCh);
    }
    AppMethodBeat.o(31050);
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ac
 * JD-Core Version:    0.7.0.1
 */