package com.tencent.mm.sandbox.updater;

import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.protocal.c.alm;
import com.tencent.mm.protocal.c.gc;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sdk.platformtools.y;

public final class b
  extends c
{
  private String[] bHW;
  private byte[] cbM;
  private byte[] eNt;
  private byte[] eNv;
  private int tdG = 0;
  private int uck = 0;
  private final int ucl = 5;
  private com.tencent.mm.sandbox.b.a ucm;
  private b.a ucn = null;
  private com.tencent.mm.sandbox.b.a uco = new b.1(this);
  private int uin;
  
  public b(int paramInt1, String paramString, int paramInt2, int paramInt3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String[] paramArrayOfString, boolean paramBoolean)
  {
    super(paramInt1, paramString, paramInt2, paramBoolean);
    this.bHW = paramArrayOfString;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      this.bHW = new String[] { "short.weixin.qq.com" };
    }
    this.uin = paramInt3;
    this.eNt = paramArrayOfByte1;
    this.cbM = paramArrayOfByte2;
  }
  
  public final void a(com.tencent.mm.sandbox.b.a parama)
  {
    this.ucm = parama;
    int i = this.uck + 1;
    this.uck = i;
    if (i > 1000)
    {
      y.d("MicroMsg.NetSceneGetUpdatePack", "doSceneCnt > DOSCENE_LIMIT, return");
      this.ucm.b(-1, -1, null);
      return;
    }
    if (!f.bs(this.ubS))
    {
      y.e("MicroMsg.NetSceneGetUpdatePack", "SDCard full, packSize=[%s]", new Object[] { Integer.valueOf(this.ubS) });
      parama.b(-1, -1, null);
      return;
    }
    parama = new alm();
    Object localObject = new gc();
    ((gc)localObject).sAl = d.spa;
    ((gc)localObject).pyo = 0;
    ((gc)localObject).jwX = this.uin;
    ((gc)localObject).sAk = com.tencent.mm.bv.b.bk(q.zg().getBytes());
    if (((gc)localObject).sAk.oY.length >= 16) {
      ((gc)localObject).sAk = ((gc)localObject).sAk.EB(16);
    }
    ((gc)localObject).sAm = com.tencent.mm.bv.b.bk(d.dOM.getBytes());
    if (((gc)localObject).sAm.oY.length >= 132) {
      ((gc)localObject).sAm = ((gc)localObject).sAm.EB(132);
    }
    ((gc)localObject).sAj = com.tencent.mm.bv.b.bk(this.eNt);
    if (((gc)localObject).sAj.oY.length >= 36) {
      ((gc)localObject).sAj = ((gc)localObject).sAj.EB(36);
    }
    parama.tEX = ((gc)localObject);
    parama.thp = this.ubR;
    parama.ndg = this.ubT;
    parama.ndf = this.ubS;
    localObject = new b.a(this, this.bHW[(this.tdG / 5)], this.uco);
    this.ucn = ((b.a)localObject);
    ((b.a)localObject).execute(new alm[] { parama });
  }
  
  public final void cancel()
  {
    y.i("MicroMsg.NetSceneGetUpdatePack", "do cancel, updateType = " + this.ubR);
    if ((this.ucn != null) && (!this.ucn.isCancelled())) {
      this.ucn.cancel(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.b
 * JD-Core Version:    0.7.0.1
 */