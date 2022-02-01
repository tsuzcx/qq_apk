package com.tencent.mm.plugin.wallet_index.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.day;
import com.tencent.mm.protocal.protobuf.daz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.w;

public final class a
  extends w
{
  public String IqL;
  public String IqM;
  private i callback;
  private d rr;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt)
  {
    AppMethodBeat.i(71849);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new day();
    ((d.a)localObject).iLO = new daz();
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/payugenprepay";
    ((d.a)localObject).funcId = 1521;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (day)this.rr.iLK.iLR;
    ((day)localObject).jfi = paramString1;
    ((day)localObject).Lkq = paramString4;
    ((day)localObject).Lkp = paramString3;
    ((day)localObject).Lkr = paramString5;
    ((day)localObject).Lks = paramString2;
    ((day)localObject).KPJ = paramString6;
    ((day)localObject).Ljk = paramString7;
    ((day)localObject).LQu = paramString8;
    ((day)localObject).KCx = paramInt;
    Log.d("MicroMsg.NetScenePayUGenPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,", new Object[] { paramString1, paramString4, paramString3, paramString5, paramString2, paramString6, paramString7, paramString8 }));
    AppMethodBeat.o(71849);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(71851);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(71851);
    return i;
  }
  
  public final int getType()
  {
    return 1521;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(71850);
    Log.d("MicroMsg.NetScenePayUGenPrepay", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    paramString = (daz)((d)params).iLL.iLR;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      Log.d("MicroMsg.NetScenePayUGenPrepay", "rr " + paramString.LQv);
      this.IqL = paramString.LQv;
      this.IqM = paramString.LQw;
    }
    paramString = paramString.rBM;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(71850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.b.a
 * JD-Core Version:    0.7.0.1
 */