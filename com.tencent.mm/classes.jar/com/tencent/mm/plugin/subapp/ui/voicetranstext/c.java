package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.modelvoice.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.cbr;
import com.tencent.mm.protocal.c.cbs;
import com.tencent.mm.protocal.c.cbt;
import com.tencent.mm.protocal.c.cds;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import junit.framework.Assert;

public final class c
  extends m
  implements k
{
  private final String TAG = "MicroMsg.NetSceneUploadVoiceForTrans";
  private String bYR;
  private com.tencent.mm.ah.b ecz;
  private f mEe;
  private String mFileName;
  private String pyk;
  private cds pym;
  private int pyo;
  private String pyp;
  public cbr pyu;
  
  public c(c paramc)
  {
    this.pyk = paramc.pyk;
    this.pym = paramc.pym;
    this.pyu = paramc.pyu;
    this.mFileName = paramc.mFileName;
    this.pyo = paramc.pyo;
    this.pyp = paramc.pyp;
    this.bYR = paramc.bYR;
    y.d("MicroMsg.NetSceneUploadVoiceForTrans", "alvinluo voiceTrans constructor scene: %d, fromUser: %s, toUser: %s", new Object[] { Integer.valueOf(paramc.pyo), paramc.pyp, paramc.bYR });
    bMg();
  }
  
  public c(String paramString1, cbr paramcbr, int paramInt, String paramString2)
  {
    if (paramString2 != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.pyk = paramString1;
      this.pyu = paramcbr;
      this.pym = d.aK(paramInt, paramString2);
      this.mFileName = paramString2;
      bMg();
      return;
    }
  }
  
  public c(String paramString1, cbr paramcbr, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    if (paramString2 != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      y.d("MicroMsg.NetSceneUploadVoiceForTrans", "alvinluo voiceTrans scene: %d, fromUser: %s, toUser: %s", new Object[] { Integer.valueOf(paramInt2), paramString3, paramString4 });
      this.pyk = paramString1;
      this.pyu = paramcbr;
      this.pym = d.aK(paramInt1, paramString2);
      this.mFileName = paramString2;
      this.pyo = paramInt2;
      this.pyp = paramString3;
      this.bYR = paramString4;
      bMg();
      return;
    }
  }
  
  private void bMg()
  {
    b.a locala = new b.a();
    locala.ecH = new cbs();
    locala.ecI = new cbt();
    locala.uri = "/cgi-bin/micromsg-bin/uploadvoicefortrans";
    locala.ecG = 547;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.ecz = locala.Kt();
  }
  
  public final int a(e parame, f paramf)
  {
    this.mEe = paramf;
    if ((!bk.bl(this.mFileName)) && (!bk.bl(this.pyk)) && (this.pyu != null) && (this.pym != null)) {}
    for (int i = 1; i == 0; i = 0)
    {
      y.e("MicroMsg.NetSceneUploadVoiceForTrans", "doScene: Value not Valid, so, do nothing.");
      return -1;
    }
    cbs localcbs = (cbs)this.ecz.ecE.ecN;
    localcbs.sNM = this.pyk;
    localcbs.sNN = this.pym;
    localcbs.sNP = this.pyu;
    Object localObject = this.mFileName;
    i = this.pyu.ndg;
    int j = this.pyu.ndh;
    paramf = new bmk();
    localObject = com.tencent.mm.modelvoice.q.ox((String)localObject);
    if (localObject != null) {
      paramf = aa.I(((com.tencent.mm.modelvoice.b)localObject).bz(i, j).buf);
    }
    localcbs.ndi = paramf;
    localcbs.pyo = this.pyo;
    localcbs.kWn = this.pyp;
    localcbs.kWm = this.bYR;
    return a(parame, this.ecz, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    bMh();
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.pyu = ((cbt)this.ecz.ecF.ecN).sNP;
      this.mEe.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (bMh()) {
        if (this.pyu == null) {
          break label115;
        }
      }
    }
    label115:
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.NetSceneUploadVoiceForTrans", "succeeed finish: %B", new Object[] { Boolean.valueOf(bool) });
      return;
      y.d("MicroMsg.NetSceneUploadVoiceForTrans", "error upload: errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      break;
    }
  }
  
  public final boolean bMh()
  {
    return (this.pyu == null) || (this.pyu.ndh <= 0);
  }
  
  public final int getType()
  {
    return 547;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.c
 * JD-Core Version:    0.7.0.1
 */