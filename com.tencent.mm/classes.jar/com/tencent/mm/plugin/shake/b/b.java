package com.tencent.mm.plugin.shake.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cbo;
import com.tencent.mm.protocal.protobuf.cbp;
import com.tencent.mm.protocal.protobuf.cuv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;

public final class b
  extends m
  implements k
{
  byte[] cLl;
  private f callback;
  int ret;
  private final com.tencent.mm.ai.b rr;
  
  public b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(24414);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cbo();
    ((b.a)localObject).fsY = new cbp();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/shakereport";
    ((b.a)localObject).funcId = 161;
    ((b.a)localObject).reqCmdId = 56;
    ((b.a)localObject).respCmdId = 1000000056;
    this.rr = ((b.a)localObject).ado();
    localObject = (cbo)this.rr.fsV.fta;
    ab.i("MicroMsg.NetSceneShakeReport", "share reprot %f %f", new Object[] { Float.valueOf(paramFloat2), Float.valueOf(paramFloat1) });
    ((cbo)localObject).OpCode = 0;
    ((cbo)localObject).wDh = paramFloat1;
    ((cbo)localObject).wDi = paramFloat2;
    ((cbo)localObject).wSk = paramInt1;
    ((cbo)localObject).wSl = paramString1;
    ((cbo)localObject).wSm = paramString2;
    ((cbo)localObject).wSn = paramInt2;
    aw.aaz();
    ((cbo)localObject).xMr = bo.a((Integer)c.Ru().get(4107, null), 0);
    aw.aaz();
    paramInt2 = bo.g((Integer)c.Ru().get(4106, null));
    ((cbo)localObject).xMs = paramInt2;
    aw.aaz();
    c.Ru().set(4106, Integer.valueOf(paramInt2 + 1));
    try
    {
      paramString1 = new cuv();
      paramString1.ydy = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.pgQ.bXq());
      ((cbo)localObject).wss = new SKBuiltinBuffer_t().setBuffer(paramString1.toByteArray());
      label291:
      o.a(2002, paramFloat1, paramFloat2, paramInt1);
      AppMethodBeat.o(24414);
      return;
    }
    catch (Throwable paramString1)
    {
      break label291;
    }
  }
  
  public final int ckP()
  {
    return ((cbo)this.rr.fsV.fta).wSn;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(24415);
    ab.d("MicroMsg.NetSceneShakeReport", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(24415);
    return i;
  }
  
  public final int getType()
  {
    return 161;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(24416);
    ab.d("MicroMsg.NetSceneShakeReport", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (cbp)this.rr.fsW.fta;
    this.ret = paramq.getRespObj().getRetCode();
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.cLl = aa.a(paramArrayOfByte.wtq);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(24416);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.b
 * JD-Core Version:    0.7.0.1
 */