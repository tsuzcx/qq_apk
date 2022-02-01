package com.tencent.mm.plugin.product.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aou;
import com.tencent.mm.protocal.protobuf.clw;
import com.tencent.mm.protocal.protobuf.clx;
import com.tencent.mm.protocal.protobuf.ee;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class f
  extends p
  implements m
{
  public LinkedList<aou> MQM;
  public String MQU;
  private h callback;
  private c rr;
  
  public f(String paramString1, String paramString2, ee paramee)
  {
    AppMethodBeat.i(66891);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new clw();
    ((c.a)localObject).otF = new clx();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/getlastestexpressinfo";
    ((c.a)localObject).funcId = 578;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (clw)c.b.b(this.rr.otB);
    this.MQU = paramString1;
    ((clw)localObject).YYC = paramString1;
    Log.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "pid ".concat(String.valueOf(paramString1)));
    ((clw)localObject).Zbg = paramString2;
    ((clw)localObject).aatN = paramee;
    AppMethodBeat.o(66891);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(66893);
    this.callback = paramh;
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
    paramArrayOfByte = (clx)c.c.b(((c)params).otC);
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramArrayOfByte.YME == 0))
    {
      Log.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "resp.ExpressCount " + paramArrayOfByte.aatP);
      this.MQM = paramArrayOfByte.aatO;
    }
    paramInt1 = paramInt3;
    params = paramString;
    if (paramInt3 == 0)
    {
      paramInt1 = paramInt3;
      params = paramString;
      if (paramArrayOfByte.YME != 0)
      {
        paramInt1 = paramArrayOfByte.YME;
        params = paramArrayOfByte.YMF;
      }
    }
    Log.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "errCode " + paramInt1 + ", errMsg " + params);
    this.callback.onSceneEnd(paramInt2, paramInt1, params, this);
    AppMethodBeat.o(66892);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.model.f
 * JD-Core Version:    0.7.0.1
 */