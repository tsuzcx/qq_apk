package com.tencent.mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bzm;
import com.tencent.mm.protocal.protobuf.bzn;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends p
  implements m
{
  private h callback;
  public String hRk;
  public com.tencent.mm.am.c rr;
  public String xVh;
  
  public c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(67101);
    this.hRk = paramString2;
    this.xVh = paramString3;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new bzm();
    ((c.a)localObject).otF = new bzn();
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/flowdatarechargepreinquery";
    ((c.a)localObject).funcId = 1555;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (bzm)c.b.b(this.rr.otB);
    ((bzm)localObject).aaiH = paramString1;
    ((bzm)localObject).YOc = paramString2;
    ((bzm)localObject).MFB = paramString3;
    ((bzm)localObject).aaiI = paramString4;
    ((bzm)localObject).aaiJ = paramString5;
    ((bzm)localObject).Njp = com.tencent.mm.plugin.wallet_core.model.mall.c.ikd().bgN(paramString1);
    AppMethodBeat.o(67101);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(67103);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(67103);
    return i;
  }
  
  public final int getType()
  {
    return 1555;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67102);
    Log.d("MicroMsg.NetSceneFlowDataRechargePreinQuery", "errCode " + paramInt3 + ", errMsg " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(67102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.c
 * JD-Core Version:    0.7.0.1
 */