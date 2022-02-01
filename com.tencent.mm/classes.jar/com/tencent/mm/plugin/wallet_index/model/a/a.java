package com.tencent.mm.plugin.wallet_index.model.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.eby;
import com.tencent.mm.protocal.protobuf.ebz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.model.w;

public final class a
  extends w
{
  public String WaN;
  public String Wan;
  private h callback;
  public String jumpUrl;
  public String prepayId;
  private c rr;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt)
  {
    AppMethodBeat.i(71846);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new eby();
    ((c.a)localObject).otF = new ebz();
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/payibggenprepay";
    ((c.a)localObject).funcId = 1563;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (eby)c.b.b(this.rr.otB);
    ((eby)localObject).oOI = paramString1;
    ((eby)localObject).ZjJ = paramString4;
    ((eby)localObject).ZjI = paramString2;
    ((eby)localObject).ZjK = paramString5;
    ((eby)localObject).ZjL = paramString6;
    ((eby)localObject).YNW = paramString3;
    ((eby)localObject).ZiL = paramString7;
    ((eby)localObject).aalN = paramString8;
    ((eby)localObject).YJZ = paramInt;
    Log.d("MicroMsg.NetSceneIbgPayGenPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,", new Object[] { paramString1, paramString4, paramString2, paramString5, paramString6, paramString3, paramString7, paramString8 }));
    AppMethodBeat.o(71846);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(71848);
    this.callback = paramh;
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
    params = (ebz)c.c.b(((c)params).otC);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      Log.i("MicroMsg.NetSceneIbgPayGenPrepay", "hy: gen ibg prepay jump url. biz_errcode: %d, biz_errmsg: %s", new Object[] { Integer.valueOf(params.ytv), params.ytw });
      paramString = params.ytw;
      paramInt3 = params.ytv;
      this.jumpUrl = params.IGI;
      this.prepayId = params.aalO;
      this.Wan = params.aalP;
      this.WaN = params.abhv;
    }
    for (;;)
    {
      params = paramString;
      if (Util.isNullOrNil(paramString)) {
        params = MMApplicationContext.getContext().getString(a.i.wallet_data_err);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, params, this);
      AppMethodBeat.o(71847);
      return;
      Log.e("MicroMsg.NetSceneIbgPayGenPrepay", "hy: gen ibg prepay jump url failed");
      this.jumpUrl = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.model.a.a
 * JD-Core Version:    0.7.0.1
 */