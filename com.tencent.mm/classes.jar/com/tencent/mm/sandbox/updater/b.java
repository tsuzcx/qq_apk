package com.tencent.mm.sandbox.updater;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.aqz;
import com.tencent.mm.protocal.protobuf.hq;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class b
  extends c
{
  private String[] bDK;
  private byte[] cKp;
  private byte[] gcZ;
  private byte[] gdd;
  private int uin;
  private int xbE;
  private final int ykA;
  private com.tencent.mm.sandbox.b.a ykB;
  private b.a ykC;
  private com.tencent.mm.sandbox.b.a ykD;
  private int ykz;
  
  public b(int paramInt1, String paramString, int paramInt2, int paramInt3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String[] paramArrayOfString, boolean paramBoolean)
  {
    super(paramInt1, paramString, paramInt2, paramBoolean);
    AppMethodBeat.i(28851);
    this.ykz = 0;
    this.ykA = 5;
    this.xbE = 0;
    this.ykC = null;
    this.ykD = new b.1(this);
    this.bDK = paramArrayOfString;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      this.bDK = new String[] { "short.weixin.qq.com" };
    }
    this.uin = paramInt3;
    this.gcZ = paramArrayOfByte1;
    this.cKp = paramArrayOfByte2;
    AppMethodBeat.o(28851);
  }
  
  public final void a(com.tencent.mm.sandbox.b.a parama)
  {
    AppMethodBeat.i(28852);
    this.ykB = parama;
    int i = this.ykz + 1;
    this.ykz = i;
    if (i > 1000)
    {
      ab.d("MicroMsg.NetSceneGetUpdatePack", "doSceneCnt > DOSCENE_LIMIT, return");
      this.ykB.b(-1, -1, null);
      AppMethodBeat.o(28852);
      return;
    }
    if (!f.gc(this.ykh))
    {
      ab.e("MicroMsg.NetSceneGetUpdatePack", "SDCard full, packSize=[%s]", new Object[] { Integer.valueOf(this.ykh) });
      parama.b(-1, -1, null);
      AppMethodBeat.o(28852);
      return;
    }
    parama = new aqz();
    Object localObject = new hq();
    ((hq)localObject).wur = d.whH;
    ((hq)localObject).Scene = 0;
    ((hq)localObject).lGw = this.uin;
    ((hq)localObject).wuq = com.tencent.mm.bv.b.bL(q.LK().getBytes());
    if (((hq)localObject).wuq.pW.length >= 16) {
      ((hq)localObject).wuq = ((hq)localObject).wuq.Mz(16);
    }
    ((hq)localObject).wus = com.tencent.mm.bv.b.bL(d.eQs.getBytes());
    if (((hq)localObject).wus.pW.length >= 132) {
      ((hq)localObject).wus = ((hq)localObject).wus.Mz(132);
    }
    ((hq)localObject).wup = com.tencent.mm.bv.b.bL(this.gcZ);
    if (((hq)localObject).wup.pW.length >= 36) {
      ((hq)localObject).wup = ((hq)localObject).wup.Mz(36);
    }
    parama.setBaseRequest((hq)localObject);
    parama.xgd = this.ykg;
    parama.pIy = this.yki;
    parama.pIx = this.ykh;
    localObject = new b.a(this, this.bDK[(this.xbE / 5)], this.ykD);
    this.ykC = ((b.a)localObject);
    ((b.a)localObject).execute(new aqz[] { parama });
    AppMethodBeat.o(28852);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(28853);
    ab.i("MicroMsg.NetSceneGetUpdatePack", "do cancel, updateType = " + this.ykg);
    if ((this.ykC != null) && (!this.ykC.isCancelled())) {
      this.ykC.cancel(true);
    }
    AppMethodBeat.o(28853);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.b
 * JD-Core Version:    0.7.0.1
 */