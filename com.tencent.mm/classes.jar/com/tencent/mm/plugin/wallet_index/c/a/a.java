package com.tencent.mm.plugin.wallet_index.c.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.daa;
import com.tencent.mm.protocal.protobuf.dab;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.w;

public final class a
  extends w
{
  public String IqM;
  public String Irb;
  private i callback;
  public String jumpUrl;
  public String prepayId;
  private d rr;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt)
  {
    AppMethodBeat.i(71846);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new daa();
    ((d.a)localObject).iLO = new dab();
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/payibggenprepay";
    ((d.a)localObject).funcId = 1563;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (daa)this.rr.iLK.iLR;
    ((daa)localObject).jfi = paramString1;
    ((daa)localObject).Lkq = paramString4;
    ((daa)localObject).Lkp = paramString2;
    ((daa)localObject).Lkr = paramString5;
    ((daa)localObject).Lks = paramString6;
    ((daa)localObject).KPJ = paramString3;
    ((daa)localObject).Ljk = paramString7;
    ((daa)localObject).LQu = paramString8;
    ((daa)localObject).KCx = paramInt;
    Log.d("MicroMsg.NetSceneIbgPayGenPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,", new Object[] { paramString1, paramString4, paramString2, paramString5, paramString6, paramString3, paramString7, paramString8 }));
    AppMethodBeat.o(71846);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(71848);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(71848);
    return i;
  }
  
  public final int getType()
  {
    return 1563;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(71847);
    Log.i("MicroMsg.NetSceneIbgPayGenPrepay", "hy: gen ibg prepay raw net errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = (dab)((d)params).iLL.iLR;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      Log.i("MicroMsg.NetSceneIbgPayGenPrepay", "hy: gen ibg prepay jump url. biz_errcode: %d, biz_errmsg: %s", new Object[] { Integer.valueOf(params.rBL), params.rBM });
      paramString = params.rBM;
      paramInt3 = params.rBL;
      this.jumpUrl = params.xIy;
      this.prepayId = params.LQv;
      this.IqM = params.LQw;
      this.Irb = params.MFk;
    }
    for (;;)
    {
      params = paramString;
      if (Util.isNullOrNil(paramString)) {
        params = MMApplicationContext.getContext().getString(2131767667);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, params, this);
      AppMethodBeat.o(71847);
      return;
      Log.e("MicroMsg.NetSceneIbgPayGenPrepay", "hy: gen ibg prepay jump url failed");
      this.jumpUrl = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.a.a
 * JD-Core Version:    0.7.0.1
 */