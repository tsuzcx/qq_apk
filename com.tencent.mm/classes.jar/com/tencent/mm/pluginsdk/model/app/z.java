package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.r;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.rk;
import com.tencent.mm.protocal.protobuf.rl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;

public final class z
  extends m
  implements k
{
  private com.tencent.mm.ai.f callback;
  private b rr;
  private final z.a vLy;
  
  public z(j.b paramb, String paramString1, String paramString2, z.a parama)
  {
    AppMethodBeat.i(27355);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new rk();
    ((b.a)localObject).fsY = new rl();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/checkbigfileupload";
    ((b.a)localObject).funcId = 727;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    rk localrk = (rk)this.rr.fsV.fta;
    if ((paramb != null) && (!bo.isNullOrNil(paramb.ewj)) && (!bo.isNullOrNil(paramb.filemd5)))
    {
      localrk.wDo = paramb.ewj;
      localrk.wJA = paramb.filemd5;
      localrk.fMs = paramb.title;
      localrk.wJB = paramb.fgx;
      localrk.wJz = paramb.fgw;
      localrk.wrs = com.tencent.mm.i.a.ecH;
      localrk.nul = paramString2;
      localrk.num = r.Zn();
      this.vLy = parama;
      ab.i("MicroMsg.NetSceneCheckBigFileUpload", "summerbig NetSceneCheckBigFileUpload content[%s], aesKey[%s] md5[%s] FileName[%s] FileSize[%d] FileExt[%s] talker[%s], fromUserName[%s], stack[%s]", new Object[] { paramb, localrk.wDo, localrk.wJA, localrk.fMs, Long.valueOf(localrk.wJz), localrk.wJB, localrk.nul, localrk.num, bo.dtY() });
      AppMethodBeat.o(27355);
      return;
    }
    com.tencent.mm.al.f.afP();
    localrk.wDo = com.tencent.mm.al.a.afG();
    com.tencent.mm.al.f.afP();
    localrk.wJA = com.tencent.mm.al.a.sC(paramString1);
    if ((paramString1 == null) || (paramString1.length() <= 0)) {
      localObject = "";
    }
    for (;;)
    {
      localrk.fMs = ((String)localObject);
      localrk.wJB = com.tencent.mm.a.e.cP(paramString1);
      localrk.wJz = com.tencent.mm.a.e.cM(paramString1);
      break;
      localObject = new File(paramString1).getName();
      int i = ((String)localObject).lastIndexOf('.');
      if (i < 0) {
        localObject = paramString1;
      } else if (i == 0) {
        localObject = "";
      } else {
        localObject = ((String)localObject).substring(0, i);
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(27356);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(27356);
    return i;
  }
  
  public final int getType()
  {
    return 727;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(27357);
    ab.d("MicroMsg.NetSceneCheckBigFileUpload", "summerbig onGYNetEnd [%d, %d, %s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ab.e("MicroMsg.NetSceneCheckBigFileUpload", "summerbig onGYNetEnd errType = " + paramInt2 + ", errCode = " + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (this.vLy != null) {
        this.vLy.a("", "", "", "", "", 0L);
      }
      AppMethodBeat.o(27357);
      return;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    paramString = (rk)((b)paramq).fsV.fta;
    paramq = (rl)((b)paramq).fsW.fta;
    ab.d("MicroMsg.NetSceneCheckBigFileUpload", "summersafecdn onGYNetEnd Signature[%s], fuin[%d], faeskey[%s], fSignature[%s]", new Object[] { paramq.gwS, Integer.valueOf(paramq.wJC), paramq.wJD, paramq.wJE });
    if (this.vLy != null) {
      this.vLy.a(paramString.wJA, paramString.wDo, paramq.gwS, paramq.wJD, paramq.wJE, paramString.wJz);
    }
    AppMethodBeat.o(27357);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.z
 * JD-Core Version:    0.7.0.1
 */