package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.afb;
import com.tencent.mm.protocal.protobuf.ayq;
import com.tencent.mm.protocal.protobuf.ayr;
import com.tencent.mm.protocal.protobuf.dh;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class g
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  private b rr;
  public LinkedList<afb> vEO;
  public String vEW;
  
  public g(String paramString1, String paramString2, dh paramdh)
  {
    AppMethodBeat.i(66891);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new ayq();
    ((b.a)localObject).hvu = new ayr();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getlastestexpressinfo";
    ((b.a)localObject).funcId = 578;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (ayq)this.rr.hvr.hvw;
    this.vEW = paramString1;
    ((ayq)localObject).Egf = paramString1;
    ac.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "pid ".concat(String.valueOf(paramString1)));
    ((ayq)localObject).EhR = paramString2;
    ((ayq)localObject).EPW = paramdh;
    AppMethodBeat.o(66891);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(66893);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(66893);
    return i;
  }
  
  public final int getType()
  {
    return 578;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(66892);
    paramArrayOfByte = (ayr)((b)paramq).hvs.hvw;
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramArrayOfByte.DWU == 0))
    {
      ac.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "resp.ExpressCount " + paramArrayOfByte.EPY);
      this.vEO = paramArrayOfByte.EPX;
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
    ac.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "errCode " + paramInt1 + ", errMsg " + paramq);
    this.callback.onSceneEnd(paramInt2, paramInt1, paramq, this);
    AppMethodBeat.o(66892);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.g
 * JD-Core Version:    0.7.0.1
 */