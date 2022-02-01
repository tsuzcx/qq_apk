package com.tencent.mm.plugin.wallet_index.c.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cjs;
import com.tencent.mm.protocal.protobuf.cjt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.c.w;

public final class a
  extends w
{
  public String DHL;
  public String DHy;
  private f callback;
  public String jumpUrl;
  public String prepayId;
  private b rr;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt)
  {
    AppMethodBeat.i(71846);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cjs();
    ((b.a)localObject).hQG = new cjt();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/payibggenprepay";
    ((b.a)localObject).funcId = 1563;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (cjs)this.rr.hQD.hQJ;
    ((cjs)localObject).ikm = paramString1;
    ((cjs)localObject).GpE = paramString4;
    ((cjs)localObject).GpD = paramString2;
    ((cjs)localObject).GpF = paramString5;
    ((cjs)localObject).GpG = paramString6;
    ((cjs)localObject).FVY = paramString3;
    ((cjs)localObject).Goz = paramString7;
    ((cjs)localObject).GMo = paramString8;
    ((cjs)localObject).FJf = paramInt;
    ae.d("MicroMsg.NetSceneIbgPayGenPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,", new Object[] { paramString1, paramString4, paramString2, paramString5, paramString6, paramString3, paramString7, paramString8 }));
    AppMethodBeat.o(71846);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(71848);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(71848);
    return i;
  }
  
  public final int getType()
  {
    return 1563;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(71847);
    ae.i("MicroMsg.NetSceneIbgPayGenPrepay", "hy: gen ibg prepay raw net errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (cjt)((b)paramq).hQE.hQJ;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ae.i("MicroMsg.NetSceneIbgPayGenPrepay", "hy: gen ibg prepay jump url. biz_errcode: %d, biz_errmsg: %s", new Object[] { Integer.valueOf(paramq.qkQ), paramq.qkR });
      paramString = paramq.qkR;
      paramInt3 = paramq.qkQ;
      this.jumpUrl = paramq.uqf;
      this.prepayId = paramq.GMp;
      this.DHy = paramq.GMq;
      this.DHL = paramq.Hwl;
    }
    for (;;)
    {
      paramq = paramString;
      if (bu.isNullOrNil(paramString)) {
        paramq = ak.getContext().getString(2131765224);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramq, this);
      AppMethodBeat.o(71847);
      return;
      ae.e("MicroMsg.NetSceneIbgPayGenPrepay", "hy: gen ibg prepay jump url failed");
      this.jumpUrl = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.a.a
 * JD-Core Version:    0.7.0.1
 */