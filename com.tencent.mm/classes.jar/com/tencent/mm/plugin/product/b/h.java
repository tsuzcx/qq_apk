package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cao;
import com.tencent.mm.protocal.protobuf.cap;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class h
  extends q
  implements com.tencent.mm.network.m
{
  public String GTq;
  public m GTr;
  public List<n> GTs;
  private i callback;
  private d rr;
  
  public h(m paramm, String paramString)
  {
    AppMethodBeat.i(66894);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new cao();
    ((d.a)localObject).lBV = new cap();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getproductdetail";
    ((d.a)localObject).funcId = 553;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (cao)d.b.b(this.rr.lBR);
    this.GTq = paramString;
    ((cao)localObject).TiR = paramString;
    Log.d("MicroMsg.NetSceneMallGetProductDetail", "pid ".concat(String.valueOf(paramString)));
    ((cao)localObject).rWt = 0;
    this.GTr = paramm;
    AppMethodBeat.o(66894);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(66896);
    this.callback = parami;
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
    paramArrayOfByte = (cap)d.c.b(((d)params).lBS);
    if (!Util.isNullOrNil(paramArrayOfByte.TiT))
    {
      Log.d("MicroMsg.NetSceneMallGetProductDetail", "resp.ProductInfo " + paramArrayOfByte.TiT);
      this.GTr = m.a(this.GTr, paramArrayOfByte.TiT);
    }
    paramInt1 = paramInt3;
    params = paramString;
    if (paramInt3 == 0)
    {
      paramInt1 = paramInt3;
      params = paramString;
      if (paramArrayOfByte.RPr != 0)
      {
        paramInt1 = paramArrayOfByte.RPr;
        params = paramArrayOfByte.RPs;
      }
    }
    if (!Util.isNullOrNil(paramArrayOfByte.TiU))
    {
      Log.d("MicroMsg.NetSceneMallGetProductDetail", "resp.RecommendInfo " + paramArrayOfByte.TiU);
      this.GTs = n.ayE(paramArrayOfByte.TiU);
    }
    Log.d("MicroMsg.NetSceneMallGetProductDetail", "errCode " + paramInt1 + ", errMsg " + params);
    this.callback.onSceneEnd(paramInt2, paramInt1, params, this);
    AppMethodBeat.o(66895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.h
 * JD-Core Version:    0.7.0.1
 */