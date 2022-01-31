package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ae.g.a;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.c.oi;
import com.tencent.mm.protocal.c.oj;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;

public final class aa
  extends m
  implements k
{
  private b dmK;
  private com.tencent.mm.ah.f dmL;
  private final aa.a rUB;
  
  public aa(g.a parama, String paramString1, String paramString2, aa.a parama1)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new oi();
    ((b.a)localObject).ecI = new oj();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/checkbigfileupload";
    ((b.a)localObject).ecG = 727;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    oi localoi = (oi)this.dmK.ecE.ecN;
    if (parama != null)
    {
      localoi.sGQ = parama.dQR;
      localoi.sLN = parama.filemd5;
      localoi.ewD = parama.title;
      localoi.sLO = parama.dQw;
      localoi.sLM = parama.dQv;
      localoi.sxP = com.tencent.mm.j.a.dlm;
      localoi.kWm = paramString2;
      localoi.kWn = com.tencent.mm.model.q.Gj();
      this.rUB = parama1;
      y.i("MicroMsg.NetSceneCheckBigFileUpload", "summerbig NetSceneCheckBigFileUpload content[%s], aesKey[%s] md5[%s] FileName[%s] FileSize[%d] FileExt[%s] talker[%s], fromUserName[%s], stack[%s]", new Object[] { parama, localoi.sGQ, localoi.sLN, localoi.ewD, Long.valueOf(localoi.sLM), localoi.sLO, localoi.kWm, localoi.kWn, bk.csb() });
      return;
    }
    com.tencent.mm.ak.f.Ne();
    localoi.sGQ = com.tencent.mm.ak.a.MW();
    com.tencent.mm.ak.f.Ne();
    localoi.sLN = com.tencent.mm.ak.a.lF(paramString1);
    if ((paramString1 == null) || (paramString1.length() <= 0)) {
      localObject = "";
    }
    for (;;)
    {
      localoi.ewD = ((String)localObject);
      localoi.sLO = com.tencent.mm.a.e.bM(paramString1);
      localoi.sLM = com.tencent.mm.a.e.bJ(paramString1);
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
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneCheckBigFileUpload", "summerbig onGYNetEnd [%d, %d, %s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      y.e("MicroMsg.NetSceneCheckBigFileUpload", "summerbig onGYNetEnd errType = " + paramInt2 + ", errCode = " + paramInt3);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (this.rUB != null) {
        this.rUB.a("", "", "", "", "", 0L);
      }
    }
    do
    {
      return;
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      paramString = (oi)((b)paramq).ecE.ecN;
      paramq = (oj)((b)paramq).ecF.ecN;
      y.d("MicroMsg.NetSceneCheckBigFileUpload", "summersafecdn onGYNetEnd Signature[%s], fuin[%d], faeskey[%s], fSignature[%s]", new Object[] { paramq.ffk, Integer.valueOf(paramq.sLP), paramq.sLQ, paramq.sLR });
    } while (this.rUB == null);
    this.rUB.a(paramString.sLN, paramString.sGQ, paramq.ffk, paramq.sLQ, paramq.sLR, paramString.sLM);
  }
  
  public final int getType()
  {
    return 727;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.aa
 * JD-Core Version:    0.7.0.1
 */