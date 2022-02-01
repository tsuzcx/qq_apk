package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aym;
import com.tencent.mm.protocal.protobuf.ayn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.List;

public final class h
  extends com.tencent.mm.al.n
  implements k
{
  private g callback;
  private b rr;
  public String uwd;
  public m uwe;
  public List<n> uwf;
  
  public h(m paramm, String paramString)
  {
    AppMethodBeat.i(66894);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new aym();
    ((b.a)localObject).gUV = new ayn();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getproductdetail";
    ((b.a)localObject).funcId = 553;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (aym)this.rr.gUS.gUX;
    this.uwd = paramString;
    ((aym)localObject).DwS = paramString;
    ad.d("MicroMsg.NetSceneMallGetProductDetail", "pid ".concat(String.valueOf(paramString)));
    ((aym)localObject).Version = 0;
    this.uwe = paramm;
    AppMethodBeat.o(66894);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(66896);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(66896);
    return i;
  }
  
  public final int getType()
  {
    return 553;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(66895);
    paramArrayOfByte = (ayn)((b)paramq).gUT.gUX;
    if (!bt.isNullOrNil(paramArrayOfByte.DwU))
    {
      ad.d("MicroMsg.NetSceneMallGetProductDetail", "resp.ProductInfo " + paramArrayOfByte.DwU);
      this.uwe = m.a(this.uwe, paramArrayOfByte.DwU);
    }
    paramInt1 = paramInt3;
    paramq = paramString;
    if (paramInt3 == 0)
    {
      paramInt1 = paramInt3;
      paramq = paramString;
      if (paramArrayOfByte.CEu != 0)
      {
        paramInt1 = paramArrayOfByte.CEu;
        paramq = paramArrayOfByte.CEv;
      }
    }
    if (!bt.isNullOrNil(paramArrayOfByte.DwV))
    {
      ad.d("MicroMsg.NetSceneMallGetProductDetail", "resp.RecommendInfo " + paramArrayOfByte.DwV);
      this.uwf = n.parse(paramArrayOfByte.DwV);
    }
    ad.d("MicroMsg.NetSceneMallGetProductDetail", "errCode " + paramInt1 + ", errMsg " + paramq);
    this.callback.onSceneEnd(paramInt2, paramInt1, paramq, this);
    AppMethodBeat.o(66895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.h
 * JD-Core Version:    0.7.0.1
 */