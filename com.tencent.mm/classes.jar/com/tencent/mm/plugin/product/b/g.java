package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ahu;
import com.tencent.mm.protocal.protobuf.bdk;
import com.tencent.mm.protocal.protobuf.bdl;
import com.tencent.mm.protocal.protobuf.di;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class g
  extends n
  implements k
{
  private f callback;
  private b rr;
  public LinkedList<ahu> xbI;
  public String xbQ;
  
  public g(String paramString1, String paramString2, di paramdi)
  {
    AppMethodBeat.i(66891);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bdk();
    ((b.a)localObject).hQG = new bdl();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getlastestexpressinfo";
    ((b.a)localObject).funcId = 578;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (bdk)this.rr.hQD.hQJ;
    this.xbQ = paramString1;
    ((bdk)localObject).Gfd = paramString1;
    ae.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "pid ".concat(String.valueOf(paramString1)));
    ((bdk)localObject).Ghx = paramString2;
    ((bdk)localObject).GSN = paramdi;
    AppMethodBeat.o(66891);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(66893);
    this.callback = paramf;
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
    paramArrayOfByte = (bdl)((b)paramq).hQE.hQJ;
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramArrayOfByte.FUL == 0))
    {
      ae.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "resp.ExpressCount " + paramArrayOfByte.GSP);
      this.xbI = paramArrayOfByte.GSO;
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
    ae.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "errCode " + paramInt1 + ", errMsg " + paramq);
    this.callback.onSceneEnd(paramInt2, paramInt1, paramq, this);
    AppMethodBeat.o(66892);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.g
 * JD-Core Version:    0.7.0.1
 */