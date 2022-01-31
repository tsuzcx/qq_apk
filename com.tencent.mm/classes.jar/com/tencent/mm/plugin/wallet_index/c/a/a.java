package com.tencent.mm.plugin.wallet_index.c.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bld;
import com.tencent.mm.protocal.protobuf.ble;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.u;

public final class a
  extends u
{
  private f callback;
  public String jumpUrl;
  public String prepayId;
  private b rr;
  public String uAe;
  public String uAq;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt)
  {
    AppMethodBeat.i(48212);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bld();
    ((b.a)localObject).fsY = new ble();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/payibggenprepay";
    ((b.a)localObject).funcId = 1563;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (bld)this.rr.fsV.fta;
    ((bld)localObject).fKw = paramString1;
    ((bld)localObject).wKW = paramString4;
    ((bld)localObject).wKV = paramString2;
    ((bld)localObject).wKX = paramString5;
    ((bld)localObject).wKY = paramString6;
    ((bld)localObject).wvC = paramString3;
    ((bld)localObject).wJT = paramString7;
    ((bld)localObject).wXP = paramString8;
    ((bld)localObject).wkX = paramInt;
    ab.d("MicroMsg.NetSceneIbgPayGenPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,", new Object[] { paramString1, paramString4, paramString2, paramString5, paramString6, paramString3, paramString7, paramString8 }));
    AppMethodBeat.o(48212);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(48214);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(48214);
    return i;
  }
  
  public final int getType()
  {
    return 1563;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(142585);
    ab.i("MicroMsg.NetSceneIbgPayGenPrepay", "hy: gen ibg prepay raw net errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (ble)((b)paramq).fsW.fta;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ab.i("MicroMsg.NetSceneIbgPayGenPrepay", "hy: gen ibg prepay jump url. biz_errcode: %d, biz_errmsg: %s", new Object[] { Integer.valueOf(paramq.lGK), paramq.lGL });
      paramString = paramq.lGL;
      paramInt3 = paramq.lGK;
      this.jumpUrl = paramq.npR;
      this.prepayId = paramq.wXQ;
      this.uAe = paramq.wXR;
      this.uAq = paramq.xzJ;
    }
    for (;;)
    {
      paramq = paramString;
      if (bo.isNullOrNil(paramString)) {
        paramq = ah.getContext().getString(2131305032);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramq, this);
      AppMethodBeat.o(142585);
      return;
      ab.e("MicroMsg.NetSceneIbgPayGenPrepay", "hy: gen ibg prepay jump url failed");
      this.jumpUrl = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.a.a
 * JD-Core Version:    0.7.0.1
 */