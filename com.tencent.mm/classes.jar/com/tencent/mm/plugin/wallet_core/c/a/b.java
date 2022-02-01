package com.tencent.mm.plugin.wallet_core.c.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cju;
import com.tencent.mm.protocal.protobuf.cjv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.wallet_core.c.w;

public final class b
  extends w
{
  public int Dho;
  private f callback;
  public String jumpUrl;
  private com.tencent.mm.ak.b rr;
  
  public b()
  {
    AppMethodBeat.i(69970);
    this.Dho = 0;
    b.a locala = new b.a();
    cju localcju = new cju();
    g.ajS();
    Object localObject = g.ajR().ajA().get(am.a.IOz, Boolean.FALSE);
    if (localObject != null) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      if (bool) {}
      for (int i = 1;; i = 0)
      {
        localcju.Hwm = i;
        locala.hQF = localcju;
        locala.hQG = new cjv();
        locala.uri = "/cgi-bin/mmpay-bin/payibggetjumpurl";
        locala.funcId = 1564;
        locala.hQH = 0;
        locala.respCmdId = 0;
        this.rr = locala.aDS();
        AppMethodBeat.o(69970);
        return;
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(69972);
    this.callback = paramf;
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
    ae.i("MicroMsg.NetSceneIbgPayGetJumpUrl", "hy: get ibg jump url raw net errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (cjv)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ae.i("MicroMsg.NetSceneIbgPayGetJumpUrl", "hy: get ibg pay jump url. biz_errcode: %d, biz_errmsg: %s", new Object[] { Integer.valueOf(paramq.qkQ), paramq.qkR });
      paramString = paramq.qkR;
      paramInt3 = paramq.qkQ;
      this.jumpUrl = paramq.uqf;
      this.Dho = paramq.Hwn;
    }
    for (;;)
    {
      paramq = paramString;
      if (bu.isNullOrNil(paramString)) {
        paramq = ak.getContext().getString(2131765224);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramq, this);
      AppMethodBeat.o(69971);
      return;
      ae.e("MicroMsg.NetSceneIbgPayGetJumpUrl", "hy: get ibg pay jump url failed");
      this.jumpUrl = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.a.b
 * JD-Core Version:    0.7.0.1
 */