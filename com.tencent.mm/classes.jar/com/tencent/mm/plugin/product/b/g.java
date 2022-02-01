package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.akg;
import com.tencent.mm.protocal.protobuf.boy;
import com.tencent.mm.protocal.protobuf.boz;
import com.tencent.mm.protocal.protobuf.dr;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class g
  extends q
  implements m
{
  public LinkedList<akg> AZk;
  public String AZs;
  private i callback;
  private d rr;
  
  public g(String paramString1, String paramString2, dr paramdr)
  {
    AppMethodBeat.i(66891);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new boy();
    ((d.a)localObject).iLO = new boz();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getlastestexpressinfo";
    ((d.a)localObject).funcId = 578;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (boy)this.rr.iLK.iLR;
    this.AZs = paramString1;
    ((boy)localObject).KZu = paramString1;
    Log.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "pid ".concat(String.valueOf(paramString1)));
    ((boy)localObject).Lca = paramString2;
    ((boy)localObject).LWZ = paramdr;
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
    paramArrayOfByte = (boz)((d)params).iLL.iLR;
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramArrayOfByte.KOt == 0))
    {
      Log.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "resp.ExpressCount " + paramArrayOfByte.LXb);
      this.AZk = paramArrayOfByte.LXa;
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
    Log.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "errCode " + paramInt1 + ", errMsg " + params);
    this.callback.onSceneEnd(paramInt2, paramInt1, params, this);
    AppMethodBeat.o(66892);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.g
 * JD-Core Version:    0.7.0.1
 */