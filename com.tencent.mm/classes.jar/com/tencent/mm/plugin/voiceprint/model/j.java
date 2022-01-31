package com.tencent.mm.plugin.voiceprint.model;

import android.os.Handler;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.modelvoice.g;
import com.tencent.mm.modelvoice.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.cdg;
import com.tencent.mm.protocal.c.cdh;
import com.tencent.mm.protocal.c.cdt;
import com.tencent.mm.sdk.platformtools.y;

public final class j
  extends com.tencent.mm.ah.m
  implements k
{
  int Do = 0;
  private int El = 0;
  private final b dmK;
  private f dmL;
  private String filename;
  private String fmR = "";
  public boolean pLi = false;
  private boolean pLj = false;
  private Handler pLk = null;
  private int pLl = 0;
  
  public j(String paramString, int paramInt)
  {
    y.d("MicroMsg.NetSceneVerifyVoicePrint", "resid %d", new Object[] { Integer.valueOf(paramInt) });
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new cdg();
    ((b.a)localObject).ecI = new cdh();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/verifyvoiceprint";
    ((b.a)localObject).ecG = 613;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (cdg)this.dmK.ecE.ecN;
    this.filename = paramString;
    this.El = 0;
    ((cdg)localObject).tDZ = paramInt;
    this.pLl = 0;
    ((cdg)localObject).tDX = 0;
    y.i("MicroMsg.NetSceneVerifyVoicePrint", "voiceRegist %d %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(0) });
    this.pLi = true;
    bOZ();
  }
  
  private int bOZ()
  {
    cdg localcdg = (cdg)this.dmK.ecE.ecN;
    cdt localcdt = new cdt();
    new g();
    localcdg.tSf = localcdt;
    Object localObject = new l(m.bh(this.filename, false));
    int i = (int)com.tencent.mm.vfs.e.aeQ(m.bh(this.filename, false));
    if (i - this.El >= 6000) {}
    for (localObject = ((l)localObject).bz(this.El, 6000);; localObject = ((l)localObject).bz(this.El, i - this.El))
    {
      y.d("MicroMsg.NetSceneVerifyVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", new Object[] { Integer.valueOf(this.El), Integer.valueOf(((g)localObject).ret), Integer.valueOf(((g)localObject).bDu), Integer.valueOf(i), Boolean.valueOf(this.pLi) });
      if (((g)localObject).bDu != 0) {
        break;
      }
      return -2;
    }
    if (((g)localObject).ret < 0)
    {
      y.w("MicroMsg.NetSceneVerifyVoicePrint", "readerror %d", new Object[] { Integer.valueOf(((g)localObject).ret) });
      return -1;
    }
    if (this.El >= 469000)
    {
      y.i("MicroMsg.NetSceneVerifyVoicePrint", "moffset > maxfile %d", new Object[] { Integer.valueOf(this.El) });
      return -1;
    }
    localcdt.tSv = new bmk().bs(((g)localObject).buf);
    localcdt.ndg = this.El;
    localcdt.tSt = ((g)localObject).bDu;
    localcdt.tSu = 0;
    localcdg.tDX = this.pLl;
    if (this.pLi)
    {
      int j = (int)com.tencent.mm.vfs.e.aeQ(m.bh(this.filename, false));
      if (((g)localObject).eIh >= j)
      {
        localcdt.tSu = 1;
        this.pLj = true;
        y.i("MicroMsg.NetSceneVerifyVoicePrint", "the last one pack for uploading totallen %d", new Object[] { Integer.valueOf(i) });
      }
    }
    this.El = ((g)localObject).eIh;
    localcdg.tSf = localcdt;
    return 0;
  }
  
  protected final int Ka()
  {
    return 240;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneVerifyVoicePrint", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = (cdh)((b)paramq).ecF.ecN;
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    this.pLl = paramq.tDX;
    this.Do = paramq.sML;
    y.i("MicroMsg.NetSceneVerifyVoicePrint", "voice VoiceTicket %d mResult %d", new Object[] { Integer.valueOf(paramq.tDX), Integer.valueOf(this.Do) });
    if (this.pLj)
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    y.i("MicroMsg.NetSceneVerifyVoicePrint", "tryDoScene ret %d", new Object[] { Integer.valueOf(bOZ()) });
    a(this.edc, this.dmL);
    y.i("MicroMsg.NetSceneVerifyVoicePrint", "loop doscene");
  }
  
  protected final m.b b(q paramq)
  {
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 613;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.j
 * JD-Core Version:    0.7.0.1
 */