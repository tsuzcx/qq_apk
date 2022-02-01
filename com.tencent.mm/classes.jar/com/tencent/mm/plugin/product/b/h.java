package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bsw;
import com.tencent.mm.protocal.protobuf.bsx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class h
  extends q
  implements com.tencent.mm.network.m
{
  public String AZs;
  public m AZt;
  public List<n> AZu;
  private i callback;
  private d rr;
  
  public h(m paramm, String paramString)
  {
    AppMethodBeat.i(66894);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bsw();
    ((d.a)localObject).iLO = new bsx();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getproductdetail";
    ((d.a)localObject).funcId = 553;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (bsw)this.rr.iLK.iLR;
    this.AZs = paramString;
    ((bsw)localObject).LZy = paramString;
    Log.d("MicroMsg.NetSceneMallGetProductDetail", "pid ".concat(String.valueOf(paramString)));
    ((bsw)localObject).Version = 0;
    this.AZt = paramm;
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
    paramArrayOfByte = (bsx)((d)params).iLL.iLR;
    if (!Util.isNullOrNil(paramArrayOfByte.LZA))
    {
      Log.d("MicroMsg.NetSceneMallGetProductDetail", "resp.ProductInfo " + paramArrayOfByte.LZA);
      this.AZt = m.a(this.AZt, paramArrayOfByte.LZA);
    }
    paramInt1 = paramInt3;
    params = paramString;
    if (paramInt3 == 0)
    {
      paramInt1 = paramInt3;
      params = paramString;
      if (paramArrayOfByte.KOt != 0)
      {
        paramInt1 = paramArrayOfByte.KOt;
        params = paramArrayOfByte.KOu;
      }
    }
    if (!Util.isNullOrNil(paramArrayOfByte.LZB))
    {
      Log.d("MicroMsg.NetSceneMallGetProductDetail", "resp.RecommendInfo " + paramArrayOfByte.LZB);
      this.AZu = n.parse(paramArrayOfByte.LZB);
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