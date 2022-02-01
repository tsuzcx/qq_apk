package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aec;
import com.tencent.mm.protocal.protobuf.avk;
import com.tencent.mm.protocal.protobuf.avl;
import com.tencent.mm.protocal.protobuf.df;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class g
  extends n
  implements k
{
  private com.tencent.mm.al.g callback;
  private b rr;
  public LinkedList<aec> uvV;
  public String uwd;
  
  public g(String paramString1, String paramString2, df paramdf)
  {
    AppMethodBeat.i(66891);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new avk();
    ((b.a)localObject).gUV = new avl();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getlastestexpressinfo";
    ((b.a)localObject).funcId = 578;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (avk)this.rr.gUS.gUX;
    this.uwd = paramString1;
    ((avk)localObject).CND = paramString1;
    ad.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "pid ".concat(String.valueOf(paramString1)));
    ((avk)localObject).CPg = paramString2;
    ((avk)localObject).DuN = paramdf;
    AppMethodBeat.o(66891);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
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
    paramArrayOfByte = (avl)((b)paramq).gUT.gUX;
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramArrayOfByte.CEu == 0))
    {
      ad.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "resp.ExpressCount " + paramArrayOfByte.DuP);
      this.uvV = paramArrayOfByte.DuO;
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
    ad.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "errCode " + paramInt1 + ", errMsg " + paramq);
    this.callback.onSceneEnd(paramInt2, paramInt1, paramq, this);
    AppMethodBeat.o(66892);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.g
 * JD-Core Version:    0.7.0.1
 */