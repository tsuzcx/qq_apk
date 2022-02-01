package com.tencent.mm.plugin.shake.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.ehb;
import com.tencent.mm.protocal.protobuf.ehc;
import com.tencent.mm.protocal.protobuf.fgr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

public final class b
  extends q
  implements m
{
  private i callback;
  byte[] fZH;
  int ret;
  private final com.tencent.mm.an.d rr;
  
  public b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(28089);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new ehb();
    ((d.a)localObject).lBV = new ehc();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/shakereport";
    ((d.a)localObject).funcId = 161;
    ((d.a)localObject).lBW = 56;
    ((d.a)localObject).respCmdId = 1000000056;
    this.rr = ((d.a)localObject).bgN();
    localObject = (ehb)d.b.b(this.rr.lBR);
    Log.i("MicroMsg.NetSceneShakeReport", "share reprot %f %f", new Object[] { Float.valueOf(paramFloat2), Float.valueOf(paramFloat1) });
    ((ehb)localObject).RLe = 0;
    ((ehb)localObject).ScO = paramFloat1;
    ((ehb)localObject).ScP = paramFloat2;
    ((ehb)localObject).Sxt = paramInt1;
    ((ehb)localObject).Sxu = paramString1;
    ((ehb)localObject).Sxv = paramString2;
    ((ehb)localObject).Sxw = paramInt2;
    bh.beI();
    ((ehb)localObject).UjB = Util.nullAs((Integer)c.aHp().b(4107, null), 0);
    bh.beI();
    paramInt2 = Util.nullAsNil((Integer)c.aHp().b(4106, null));
    ((ehb)localObject).UjC = paramInt2;
    bh.beI();
    c.aHp().i(4106, Integer.valueOf(paramInt2 + 1));
    try
    {
      paramString1 = new fgr();
      paramString1.UGO = new eae().dc(com.tencent.mm.plugin.normsg.a.d.GxJ.fjn());
      ((ehb)localObject).RMN = new eae().dc(paramString1.toByteArray());
      label291:
      n.a(2002, paramFloat1, paramFloat2, paramInt1);
      AppMethodBeat.o(28089);
      return;
    }
    catch (Throwable paramString1)
    {
      break label291;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(28090);
    Log.d("MicroMsg.NetSceneShakeReport", "doScene");
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(28090);
    return i;
  }
  
  public final int fGR()
  {
    AppMethodBeat.i(286211);
    int i = ((ehb)d.b.b(this.rr.lBR)).Sxw;
    AppMethodBeat.o(286211);
    return i;
  }
  
  public final int getType()
  {
    return 161;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28091);
    Log.d("MicroMsg.NetSceneShakeReport", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (ehc)d.c.b(this.rr.lBS);
    d.b.b(this.rr.lBR);
    this.ret = params.getRespObj().getRetCode();
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.fZH = z.a(paramArrayOfByte.RNM);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(28091);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.b
 * JD-Core Version:    0.7.0.1
 */