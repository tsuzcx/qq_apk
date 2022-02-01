package com.tencent.mm.plugin.product.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cpx;
import com.tencent.mm.protocal.protobuf.cpy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class g
  extends p
  implements com.tencent.mm.network.m
{
  public String MQU;
  public l MQV;
  public List<m> MQW;
  private h callback;
  private c rr;
  
  public g(l paraml, String paramString)
  {
    AppMethodBeat.i(66894);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cpx();
    ((c.a)localObject).otF = new cpy();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/getproductdetail";
    ((c.a)localObject).funcId = 553;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (cpx)c.b.b(this.rr.otB);
    this.MQU = paramString;
    ((cpx)localObject).aawr = paramString;
    Log.d("MicroMsg.NetSceneMallGetProductDetail", "pid ".concat(String.valueOf(paramString)));
    ((cpx)localObject).crz = 0;
    this.MQV = paraml;
    AppMethodBeat.o(66894);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, h paramh)
  {
    AppMethodBeat.i(66896);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(66896);
    return i;
  }
  
  public final int getType()
  {
    return 553;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(66895);
    paramArrayOfByte = (cpy)c.c.b(((c)params).otC);
    if (!Util.isNullOrNil(paramArrayOfByte.aawt))
    {
      Log.d("MicroMsg.NetSceneMallGetProductDetail", "resp.ProductInfo " + paramArrayOfByte.aawt);
      this.MQV = l.a(this.MQV, paramArrayOfByte.aawt);
    }
    paramInt1 = paramInt3;
    params = paramString;
    if (paramInt3 == 0)
    {
      paramInt1 = paramInt3;
      params = paramString;
      if (paramArrayOfByte.YME != 0)
      {
        paramInt1 = paramArrayOfByte.YME;
        params = paramArrayOfByte.YMF;
      }
    }
    if (!Util.isNullOrNil(paramArrayOfByte.aawu))
    {
      Log.d("MicroMsg.NetSceneMallGetProductDetail", "resp.RecommendInfo " + paramArrayOfByte.aawu);
      this.MQW = m.asJ(paramArrayOfByte.aawu);
    }
    Log.d("MicroMsg.NetSceneMallGetProductDetail", "errCode " + paramInt1 + ", errMsg " + params);
    this.callback.onSceneEnd(paramInt2, paramInt1, params, this);
    AppMethodBeat.o(66895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.model.g
 * JD-Core Version:    0.7.0.1
 */