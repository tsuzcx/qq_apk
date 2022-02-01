package com.tencent.mm.plugin.shake.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dxa;
import com.tencent.mm.protocal.protobuf.dxb;
import com.tencent.mm.protocal.protobuf.ewf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

public final class b
  extends q
  implements m
{
  private i callback;
  byte[] efs;
  int ret;
  private final com.tencent.mm.ak.d rr;
  
  public b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(28089);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dxa();
    ((d.a)localObject).iLO = new dxb();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/shakereport";
    ((d.a)localObject).funcId = 161;
    ((d.a)localObject).iLP = 56;
    ((d.a)localObject).respCmdId = 1000000056;
    this.rr = ((d.a)localObject).aXF();
    localObject = (dxa)this.rr.iLK.iLR;
    Log.i("MicroMsg.NetSceneShakeReport", "share reprot %f %f", new Object[] { Float.valueOf(paramFloat2), Float.valueOf(paramFloat1) });
    ((dxa)localObject).OpCode = 0;
    ((dxa)localObject).LbC = paramFloat1;
    ((dxa)localObject).LbD = paramFloat2;
    ((dxa)localObject).LuT = paramInt1;
    ((dxa)localObject).LuU = paramString1;
    ((dxa)localObject).LuV = paramString2;
    ((dxa)localObject).LuW = paramInt2;
    bg.aVF();
    ((dxa)localObject).MXg = Util.nullAs((Integer)c.azQ().get(4107, null), 0);
    bg.aVF();
    paramInt2 = Util.nullAsNil((Integer)c.azQ().get(4106, null));
    ((dxa)localObject).MXh = paramInt2;
    bg.aVF();
    c.azQ().set(4106, Integer.valueOf(paramInt2 + 1));
    try
    {
      paramString1 = new ewf();
      paramString1.NtQ = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.AEF.exJ());
      ((dxa)localObject).KLQ = new SKBuiltinBuffer_t().setBuffer(paramString1.toByteArray());
      label291:
      o.a(2002, paramFloat1, paramFloat2, paramInt1);
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
  
  public final int eTO()
  {
    return ((dxa)this.rr.iLK.iLR).LuW;
  }
  
  public final int getType()
  {
    return 161;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28091);
    Log.d("MicroMsg.NetSceneShakeReport", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (dxb)this.rr.iLL.iLR;
    this.ret = params.getRespObj().getRetCode();
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.efs = z.a(paramArrayOfByte.KMS);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(28091);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.b
 * JD-Core Version:    0.7.0.1
 */