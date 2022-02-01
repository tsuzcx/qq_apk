package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bce;
import com.tencent.mm.protocal.protobuf.bcf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.List;

public final class h
  extends com.tencent.mm.ak.n
  implements k
{
  private g callback;
  private b rr;
  public String vEW;
  public m vEX;
  public List<n> vEY;
  
  public h(m paramm, String paramString)
  {
    AppMethodBeat.i(66894);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bce();
    ((b.a)localObject).hvu = new bcf();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getproductdetail";
    ((b.a)localObject).funcId = 553;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (bce)this.rr.hvr.hvw;
    this.vEW = paramString;
    ((bce)localObject).ESn = paramString;
    ac.d("MicroMsg.NetSceneMallGetProductDetail", "pid ".concat(String.valueOf(paramString)));
    ((bce)localObject).Version = 0;
    this.vEX = paramm;
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
    paramArrayOfByte = (bcf)((b)paramq).hvs.hvw;
    if (!bs.isNullOrNil(paramArrayOfByte.ESp))
    {
      ac.d("MicroMsg.NetSceneMallGetProductDetail", "resp.ProductInfo " + paramArrayOfByte.ESp);
      this.vEX = m.a(this.vEX, paramArrayOfByte.ESp);
    }
    paramInt1 = paramInt3;
    paramq = paramString;
    if (paramInt3 == 0)
    {
      paramInt1 = paramInt3;
      paramq = paramString;
      if (paramArrayOfByte.DWU != 0)
      {
        paramInt1 = paramArrayOfByte.DWU;
        paramq = paramArrayOfByte.DWV;
      }
    }
    if (!bs.isNullOrNil(paramArrayOfByte.ESq))
    {
      ac.d("MicroMsg.NetSceneMallGetProductDetail", "resp.RecommendInfo " + paramArrayOfByte.ESq);
      this.vEY = n.parse(paramArrayOfByte.ESq);
    }
    ac.d("MicroMsg.NetSceneMallGetProductDetail", "errCode " + paramInt1 + ", errMsg " + paramq);
    this.callback.onSceneEnd(paramInt2, paramInt1, paramq, this);
    AppMethodBeat.o(66895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.h
 * JD-Core Version:    0.7.0.1
 */