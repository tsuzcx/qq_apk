package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bgy;
import com.tencent.mm.protocal.protobuf.bgz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.List;

public final class h
  extends com.tencent.mm.ak.n
  implements k
{
  private f callback;
  private b rr;
  public String xbQ;
  public m xbR;
  public List<n> xbS;
  
  public h(m paramm, String paramString)
  {
    AppMethodBeat.i(66894);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bgy();
    ((b.a)localObject).hQG = new bgz();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getproductdetail";
    ((b.a)localObject).funcId = 553;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (bgy)this.rr.hQD.hQJ;
    this.xbQ = paramString;
    ((bgy)localObject).GVf = paramString;
    ae.d("MicroMsg.NetSceneMallGetProductDetail", "pid ".concat(String.valueOf(paramString)));
    ((bgy)localObject).Version = 0;
    this.xbR = paramm;
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
    paramArrayOfByte = (bgz)((b)paramq).hQE.hQJ;
    if (!bu.isNullOrNil(paramArrayOfByte.GVh))
    {
      ae.d("MicroMsg.NetSceneMallGetProductDetail", "resp.ProductInfo " + paramArrayOfByte.GVh);
      this.xbR = m.a(this.xbR, paramArrayOfByte.GVh);
    }
    paramInt1 = paramInt3;
    paramq = paramString;
    if (paramInt3 == 0)
    {
      paramInt1 = paramInt3;
      paramq = paramString;
      if (paramArrayOfByte.FUL != 0)
      {
        paramInt1 = paramArrayOfByte.FUL;
        paramq = paramArrayOfByte.FUM;
      }
    }
    if (!bu.isNullOrNil(paramArrayOfByte.GVi))
    {
      ae.d("MicroMsg.NetSceneMallGetProductDetail", "resp.RecommendInfo " + paramArrayOfByte.GVi);
      this.xbS = n.parse(paramArrayOfByte.GVi);
    }
    ae.d("MicroMsg.NetSceneMallGetProductDetail", "errCode " + paramInt1 + ", errMsg " + paramq);
    this.callback.onSceneEnd(paramInt2, paramInt1, paramq, this);
    AppMethodBeat.o(66895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.h
 * JD-Core Version:    0.7.0.1
 */