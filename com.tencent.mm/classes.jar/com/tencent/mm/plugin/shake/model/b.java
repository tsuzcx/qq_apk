package com.tencent.mm.plugin.shake.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.fbb;
import com.tencent.mm.protocal.protobuf.fbc;
import com.tencent.mm.protocal.protobuf.gdd;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;

public final class b
  extends p
  implements m
{
  private h callback;
  byte[] ifP;
  int ret;
  private final com.tencent.mm.am.c rr;
  
  public b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(28089);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fbb();
    ((c.a)localObject).otF = new fbc();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/shakereport";
    ((c.a)localObject).funcId = 161;
    ((c.a)localObject).otG = 56;
    ((c.a)localObject).respCmdId = 1000000056;
    this.rr = ((c.a)localObject).bEF();
    localObject = (fbb)c.b.b(this.rr.otB);
    Log.i("MicroMsg.NetSceneShakeReport", "share reprot %f %f", new Object[] { Float.valueOf(paramFloat2), Float.valueOf(paramFloat1) });
    ((fbb)localObject).YIq = 0;
    ((fbb)localObject).ZaG = paramFloat1;
    ((fbb)localObject).ZaH = paramFloat2;
    ((fbb)localObject).Zyl = paramInt1;
    ((fbb)localObject).Zym = paramString1;
    ((fbb)localObject).Zyn = paramString2;
    ((fbb)localObject).Zyo = paramInt2;
    bh.bCz();
    ((fbb)localObject).abBg = Util.nullAs((Integer)com.tencent.mm.model.c.ban().d(4107, null), 0);
    bh.bCz();
    paramInt2 = Util.nullAsNil((Integer)com.tencent.mm.model.c.ban().d(4106, null));
    ((fbb)localObject).abBh = paramInt2;
    bh.bCz();
    com.tencent.mm.model.c.ban().B(4106, Integer.valueOf(paramInt2 + 1));
    try
    {
      paramString1 = new gdd();
      paramString1.acaX = new gol().df(d.MtP.gtE());
      ((fbb)localObject).YKb = new gol().df(paramString1.toByteArray());
      label291:
      n.a(2002, paramFloat1, paramFloat2, paramInt1);
      AppMethodBeat.o(28089);
      return;
    }
    finally
    {
      break label291;
    }
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(28090);
    Log.d("MicroMsg.NetSceneShakeReport", "doScene");
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(28090);
    return i;
  }
  
  public final int gWG()
  {
    AppMethodBeat.i(273542);
    int i = ((fbb)c.b.b(this.rr.otB)).Zyo;
    AppMethodBeat.o(273542);
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
    paramArrayOfByte = (fbc)c.c.b(this.rr.otC);
    c.b.b(this.rr.otB);
    this.ret = params.getRespObj().getRetCode();
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.ifP = w.a(paramArrayOfByte.YLa);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(28091);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.model.b
 * JD-Core Version:    0.7.0.1
 */