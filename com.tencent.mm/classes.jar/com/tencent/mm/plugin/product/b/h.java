package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aof;
import com.tencent.mm.protocal.protobuf.aog;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

public final class h
  extends com.tencent.mm.ai.m
  implements k
{
  private f callback;
  public String pur;
  public m pus;
  public List<n> put;
  private b rr;
  
  public h(m paramm, String paramString)
  {
    AppMethodBeat.i(43988);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new aof();
    ((b.a)localObject).fsY = new aog();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getproductdetail";
    ((b.a)localObject).funcId = 553;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (aof)this.rr.fsV.fta;
    this.pur = paramString;
    ((aof)localObject).xec = paramString;
    ab.d("MicroMsg.NetSceneMallGetProductDetail", "pid ".concat(String.valueOf(paramString)));
    ((aof)localObject).Version = 0;
    this.pus = paramm;
    AppMethodBeat.o(43988);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(43990);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(43990);
    return i;
  }
  
  public final int getType()
  {
    return 553;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(43989);
    paramArrayOfByte = (aog)((b)paramq).fsW.fta;
    if (!bo.isNullOrNil(paramArrayOfByte.xee))
    {
      ab.d("MicroMsg.NetSceneMallGetProductDetail", "resp.ProductInfo " + paramArrayOfByte.xee);
      this.pus = m.a(this.pus, paramArrayOfByte.xee);
    }
    paramInt1 = paramInt3;
    paramq = paramString;
    if (paramInt3 == 0)
    {
      paramInt1 = paramInt3;
      paramq = paramString;
      if (paramArrayOfByte.wuD != 0)
      {
        paramInt1 = paramArrayOfByte.wuD;
        paramq = paramArrayOfByte.wuE;
      }
    }
    if (!bo.isNullOrNil(paramArrayOfByte.xef))
    {
      ab.d("MicroMsg.NetSceneMallGetProductDetail", "resp.RecommendInfo " + paramArrayOfByte.xef);
      this.put = n.parse(paramArrayOfByte.xef);
    }
    ab.d("MicroMsg.NetSceneMallGetProductDetail", "errCode " + paramInt1 + ", errMsg " + paramq);
    this.callback.onSceneEnd(paramInt2, paramInt1, paramq, this);
    AppMethodBeat.o(43989);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.h
 * JD-Core Version:    0.7.0.1
 */