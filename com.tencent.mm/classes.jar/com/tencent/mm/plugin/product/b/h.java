package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bgi;
import com.tencent.mm.protocal.protobuf.bgj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.List;

public final class h
  extends com.tencent.mm.al.n
  implements k
{
  private f callback;
  private b rr;
  public String wMc;
  public m wMd;
  public List<n> wMe;
  
  public h(m paramm, String paramString)
  {
    AppMethodBeat.i(66894);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new bgi();
    ((b.a)localObject).hNN = new bgj();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getproductdetail";
    ((b.a)localObject).funcId = 553;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (bgi)this.rr.hNK.hNQ;
    this.wMc = paramString;
    ((bgi)localObject).GBF = paramString;
    ad.d("MicroMsg.NetSceneMallGetProductDetail", "pid ".concat(String.valueOf(paramString)));
    ((bgi)localObject).Version = 0;
    this.wMd = paramm;
    AppMethodBeat.o(66894);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(66896);
    this.callback = paramf;
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
    paramArrayOfByte = (bgj)((b)paramq).hNL.hNQ;
    if (!bt.isNullOrNil(paramArrayOfByte.GBH))
    {
      ad.d("MicroMsg.NetSceneMallGetProductDetail", "resp.ProductInfo " + paramArrayOfByte.GBH);
      this.wMd = m.a(this.wMd, paramArrayOfByte.GBH);
    }
    paramInt1 = paramInt3;
    paramq = paramString;
    if (paramInt3 == 0)
    {
      paramInt1 = paramInt3;
      paramq = paramString;
      if (paramArrayOfByte.FCq != 0)
      {
        paramInt1 = paramArrayOfByte.FCq;
        paramq = paramArrayOfByte.FCr;
      }
    }
    if (!bt.isNullOrNil(paramArrayOfByte.GBI))
    {
      ad.d("MicroMsg.NetSceneMallGetProductDetail", "resp.RecommendInfo " + paramArrayOfByte.GBI);
      this.wMe = n.parse(paramArrayOfByte.GBI);
    }
    ad.d("MicroMsg.NetSceneMallGetProductDetail", "errCode " + paramInt1 + ", errMsg " + paramq);
    this.callback.onSceneEnd(paramInt2, paramInt1, paramq, this);
    AppMethodBeat.o(66895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.h
 * JD-Core Version:    0.7.0.1
 */