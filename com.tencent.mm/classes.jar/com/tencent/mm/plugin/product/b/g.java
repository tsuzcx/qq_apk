package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.alj;
import com.tencent.mm.protocal.protobuf.bwt;
import com.tencent.mm.protocal.protobuf.bwu;
import com.tencent.mm.protocal.protobuf.dp;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class g
  extends q
  implements m
{
  public LinkedList<alj> GTi;
  public String GTq;
  private i callback;
  private d rr;
  
  public g(String paramString1, String paramString2, dp paramdp)
  {
    AppMethodBeat.i(66891);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new bwt();
    ((d.a)localObject).lBV = new bwu();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getlastestexpressinfo";
    ((d.a)localObject).funcId = 578;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (bwt)d.b.b(this.rr.lBR);
    this.GTq = paramString1;
    ((bwt)localObject).SaD = paramString1;
    Log.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "pid ".concat(String.valueOf(paramString1)));
    ((bwt)localObject).Sdn = paramString2;
    ((bwt)localObject).Tgx = paramdp;
    AppMethodBeat.o(66891);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(66893);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(66893);
    return i;
  }
  
  public final int getType()
  {
    return 578;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(66892);
    paramArrayOfByte = (bwu)d.c.b(((d)params).lBS);
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramArrayOfByte.RPr == 0))
    {
      Log.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "resp.ExpressCount " + paramArrayOfByte.Tgz);
      this.GTi = paramArrayOfByte.Tgy;
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
    Log.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "errCode " + paramInt1 + ", errMsg " + params);
    this.callback.onSceneEnd(paramInt2, paramInt1, params, this);
    AppMethodBeat.o(66892);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.g
 * JD-Core Version:    0.7.0.1
 */