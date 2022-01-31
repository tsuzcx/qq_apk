package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aan;
import com.tencent.mm.protocal.protobuf.als;
import com.tencent.mm.protocal.protobuf.alt;
import com.tencent.mm.protocal.protobuf.cx;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class g
  extends m
  implements k
{
  private f callback;
  public LinkedList<aan> puj;
  public String pur;
  private b rr;
  
  public g(String paramString1, String paramString2, cx paramcx)
  {
    AppMethodBeat.i(43985);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new als();
    ((b.a)localObject).fsY = new alt();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getlastestexpressinfo";
    ((b.a)localObject).funcId = 578;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (als)this.rr.fsV.fta;
    this.pur = paramString1;
    ((als)localObject).wCj = paramString1;
    ab.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "pid ".concat(String.valueOf(paramString1)));
    ((als)localObject).wDF = paramString2;
    ((als)localObject).xcr = paramcx;
    AppMethodBeat.o(43985);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(43987);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(43987);
    return i;
  }
  
  public final int getType()
  {
    return 578;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(43986);
    paramArrayOfByte = (alt)((b)paramq).fsW.fta;
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramArrayOfByte.wuD == 0))
    {
      ab.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "resp.ExpressCount " + paramArrayOfByte.xct);
      this.puj = paramArrayOfByte.xcs;
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
    ab.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "errCode " + paramInt1 + ", errMsg " + paramq);
    this.callback.onSceneEnd(paramInt2, paramInt1, paramq, this);
    AppMethodBeat.o(43986);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.g
 * JD-Core Version:    0.7.0.1
 */