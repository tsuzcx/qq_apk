package com.tencent.mm.plugin.voiceprint.model;

import android.os.Handler;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.model.au;
import com.tencent.mm.model.ba.a;
import com.tencent.mm.model.ba.b;
import com.tencent.mm.modelvoice.g;
import com.tencent.mm.modelvoice.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.cdj;
import com.tencent.mm.protocal.c.cdt;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;

public final class h
  extends com.tencent.mm.ah.m
  implements k
{
  int Do = 0;
  private int El = 0;
  f dmL;
  private final q edR;
  private String filename;
  String fmR = "";
  public boolean pLi = false;
  private boolean pLj = false;
  private Handler pLk = null;
  private int pLl = 0;
  
  public h(String paramString1, int paramInt, String paramString2)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "resid %d vertifyTicket %s", new Object[] { Integer.valueOf(paramInt), bk.aM(paramString2, "") });
    this.edR = new c();
    ba.a locala = (ba.a)this.edR.Kv();
    this.filename = paramString1;
    this.El = 0;
    locala.dWe.tDZ = paramInt;
    locala.dWe.til = paramString2;
    this.pLl = 0;
    locala.dWe.tDX = 0;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "voiceRegist %d %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(0) });
    this.pLi = true;
    bOZ();
  }
  
  private int bOZ()
  {
    ba.a locala = (ba.a)this.edR.Kv();
    cdt localcdt = new cdt();
    new g();
    locala.dWe.tSf = localcdt;
    Object localObject = new l(m.bh(this.filename, false));
    int i = (int)com.tencent.mm.vfs.e.aeQ(m.bh(this.filename, false));
    if (i - this.El >= 6000) {}
    for (localObject = ((l)localObject).bz(this.El, 6000);; localObject = ((l)localObject).bz(this.El, i - this.El))
    {
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", new Object[] { Integer.valueOf(this.El), Integer.valueOf(((g)localObject).ret), Integer.valueOf(((g)localObject).bDu), Integer.valueOf(i), Boolean.valueOf(this.pLi) });
      if (((g)localObject).bDu != 0) {
        break;
      }
      return -2;
    }
    if (((g)localObject).ret < 0)
    {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.NetSceneRsaVertifyVoicePrint", "readerror %d", new Object[] { Integer.valueOf(((g)localObject).ret) });
      return -1;
    }
    if (this.El >= 469000)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "moffset > maxfile %d", new Object[] { Integer.valueOf(this.El) });
      return -1;
    }
    localcdt.tSv = new bmk().bs(((g)localObject).buf);
    localcdt.ndg = this.El;
    localcdt.tSt = ((g)localObject).bDu;
    localcdt.tSu = 0;
    locala.dWe.tDX = this.pLl;
    if (this.pLi)
    {
      int j = (int)com.tencent.mm.vfs.e.aeQ(m.bh(this.filename, false));
      if (((g)localObject).eIh >= j)
      {
        localcdt.tSu = 1;
        this.pLj = true;
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "the last one pack for uploading totallen %d", new Object[] { Integer.valueOf(i) });
      }
    }
    this.El = ((g)localObject).eIh;
    locala.dWe.tSf = localcdt;
    return 0;
  }
  
  protected final int Ka()
  {
    return 240;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.edR, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (ba.b)paramq.HF();
    if ((paramInt2 == 4) && (paramInt3 == -102))
    {
      paramInt1 = paramq.Kv().spM.ver;
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      au.DS().O(new h.1(this, paramInt1));
      return;
    }
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    this.pLl = paramArrayOfByte.dWf.tDX;
    this.Do = paramArrayOfByte.dWf.sML;
    this.fmR = paramArrayOfByte.dWf.tSg;
    int i = paramArrayOfByte.dWf.tDX;
    int j = this.Do;
    boolean bool = bk.bl(this.fmR);
    if (bk.bl(this.fmR)) {}
    for (paramInt1 = 0;; paramInt1 = this.fmR.length())
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "voice VoiceTicket %d mResult %d mAuthPwd is null: %b, mAuthPwd.len: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool), Integer.valueOf(paramInt1) });
      if (!this.pLj) {
        break;
      }
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "tryDoScene ret %d", new Object[] { Integer.valueOf(bOZ()) });
    a(this.edc, this.dmL);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "loop doscene");
  }
  
  protected final m.b b(q paramq)
  {
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 617;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.h
 * JD-Core Version:    0.7.0.1
 */