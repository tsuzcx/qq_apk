package com.tencent.mm.plugin.wallet_index.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cjw;
import com.tencent.mm.protocal.protobuf.cjx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.w;

public final class a
  extends w
{
  public String DpR;
  public String DpS;
  private f callback;
  private b rr;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt)
  {
    AppMethodBeat.i(71849);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cjw();
    ((b.a)localObject).hNN = new cjx();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/payugenprepay";
    ((b.a)localObject).funcId = 1521;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (cjw)this.rr.hNK.hNQ;
    ((cjw)localObject).iht = paramString1;
    ((cjw)localObject).FXf = paramString4;
    ((cjw)localObject).FXe = paramString3;
    ((cjw)localObject).FXg = paramString5;
    ((cjw)localObject).FXh = paramString2;
    ((cjw)localObject).FDD = paramString6;
    ((cjw)localObject).FWa = paramString7;
    ((cjw)localObject).GsQ = paramString8;
    ((cjw)localObject).FqH = paramInt;
    ad.d("MicroMsg.NetScenePayUGenPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,", new Object[] { paramString1, paramString4, paramString3, paramString5, paramString2, paramString6, paramString7, paramString8 }));
    AppMethodBeat.o(71849);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(71851);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(71851);
    return i;
  }
  
  public final int getType()
  {
    return 1521;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(71850);
    ad.d("MicroMsg.NetScenePayUGenPrepay", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    paramString = (cjx)((b)paramq).hNL.hNQ;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ad.d("MicroMsg.NetScenePayUGenPrepay", "rr " + paramString.GsR);
      this.DpR = paramString.GsR;
      this.DpS = paramString.GsS;
    }
    paramString = paramString.qem;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(71850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.b.a
 * JD-Core Version:    0.7.0.1
 */