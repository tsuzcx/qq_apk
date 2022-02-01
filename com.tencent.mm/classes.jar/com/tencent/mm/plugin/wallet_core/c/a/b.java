package com.tencent.mm.plugin.wallet_core.c.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bzf;
import com.tencent.mm.protocal.protobuf.bzg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.wallet_core.c.w;

public final class b
  extends w
{
  private com.tencent.mm.al.g callback;
  public String jumpUrl;
  private com.tencent.mm.al.b rr;
  public int zXb;
  
  public b()
  {
    AppMethodBeat.i(69970);
    this.zXb = 0;
    b.a locala = new b.a();
    bzf localbzf = new bzf();
    com.tencent.mm.kernel.g.afC();
    Object localObject = com.tencent.mm.kernel.g.afB().afk().get(ae.a.FjV, Boolean.FALSE);
    if (localObject != null) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      if (bool) {}
      for (int i = 1;; i = 0)
      {
        localbzf.DVR = i;
        locala.gUU = localbzf;
        locala.gUV = new bzg();
        locala.uri = "/cgi-bin/mmpay-bin/payibggetjumpurl";
        locala.funcId = 1564;
        locala.reqCmdId = 0;
        locala.respCmdId = 0;
        this.rr = locala.atI();
        AppMethodBeat.o(69970);
        return;
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(69972);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(69972);
    return i;
  }
  
  public final int getType()
  {
    return 1564;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(69971);
    ad.i("MicroMsg.NetSceneIbgPayGetJumpUrl", "hy: get ibg jump url raw net errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (bzg)((com.tencent.mm.al.b)paramq).gUT.gUX;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ad.i("MicroMsg.NetSceneIbgPayGetJumpUrl", "hy: get ibg pay jump url. biz_errcode: %d, biz_errmsg: %s", new Object[] { Integer.valueOf(paramq.oXv), paramq.oXw });
      paramString = paramq.oXw;
      paramInt3 = paramq.oXv;
      this.jumpUrl = paramq.rZo;
      this.zXb = paramq.DVS;
    }
    for (;;)
    {
      paramq = paramString;
      if (bt.isNullOrNil(paramString)) {
        paramq = aj.getContext().getString(2131765224);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramq, this);
      AppMethodBeat.o(69971);
      return;
      ad.e("MicroMsg.NetSceneIbgPayGetJumpUrl", "hy: get ibg pay jump url failed");
      this.jumpUrl = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.a.b
 * JD-Core Version:    0.7.0.1
 */