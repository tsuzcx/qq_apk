package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ahk;
import com.tencent.mm.protocal.protobuf.bcu;
import com.tencent.mm.protocal.protobuf.bcv;
import com.tencent.mm.protocal.protobuf.di;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class g
  extends n
  implements k
{
  private f callback;
  private b rr;
  public LinkedList<ahk> wLU;
  public String wMc;
  
  public g(String paramString1, String paramString2, di paramdi)
  {
    AppMethodBeat.i(66891);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new bcu();
    ((b.a)localObject).hNN = new bcv();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getlastestexpressinfo";
    ((b.a)localObject).funcId = 578;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (bcu)this.rr.hNK.hNQ;
    this.wMc = paramString1;
    ((bcu)localObject).FME = paramString1;
    ad.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "pid ".concat(String.valueOf(paramString1)));
    ((bcu)localObject).FOY = paramString2;
    ((bcu)localObject).Gzn = paramdi;
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
    paramArrayOfByte = (bcv)((b)paramq).hNL.hNQ;
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramArrayOfByte.FCq == 0))
    {
      ad.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "resp.ExpressCount " + paramArrayOfByte.Gzp);
      this.wLU = paramArrayOfByte.Gzo;
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
    ad.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "errCode " + paramInt1 + ", errMsg " + paramq);
    this.callback.onSceneEnd(paramInt2, paramInt1, paramq, this);
    AppMethodBeat.o(66892);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.g
 * JD-Core Version:    0.7.0.1
 */