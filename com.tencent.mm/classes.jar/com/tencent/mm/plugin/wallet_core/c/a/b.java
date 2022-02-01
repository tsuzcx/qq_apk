package com.tencent.mm.plugin.wallet_core.c.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ceb;
import com.tencent.mm.protocal.protobuf.cec;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.wallet_core.c.w;

public final class b
  extends w
{
  public int Bpv;
  private com.tencent.mm.ak.g callback;
  public String jumpUrl;
  private com.tencent.mm.ak.b rr;
  
  public b()
  {
    AppMethodBeat.i(69970);
    this.Bpv = 0;
    b.a locala = new b.a();
    ceb localceb = new ceb();
    com.tencent.mm.kernel.g.agS();
    Object localObject = com.tencent.mm.kernel.g.agR().agA().get(ah.a.GHK, Boolean.FALSE);
    if (localObject != null) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      if (bool) {}
      for (int i = 1;; i = 0)
      {
        localceb.FsF = i;
        locala.hvt = localceb;
        locala.hvu = new cec();
        locala.uri = "/cgi-bin/mmpay-bin/payibggetjumpurl";
        locala.funcId = 1564;
        locala.reqCmdId = 0;
        locala.respCmdId = 0;
        this.rr = locala.aAz();
        AppMethodBeat.o(69970);
        return;
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
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
    ac.i("MicroMsg.NetSceneIbgPayGetJumpUrl", "hy: get ibg jump url raw net errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (cec)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ac.i("MicroMsg.NetSceneIbgPayGetJumpUrl", "hy: get ibg pay jump url. biz_errcode: %d, biz_errmsg: %s", new Object[] { Integer.valueOf(paramq.pAG), paramq.pAH });
      paramString = paramq.pAH;
      paramInt3 = paramq.pAG;
      this.jumpUrl = paramq.thh;
      this.Bpv = paramq.FsG;
    }
    for (;;)
    {
      paramq = paramString;
      if (bs.isNullOrNil(paramString)) {
        paramq = ai.getContext().getString(2131765224);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramq, this);
      AppMethodBeat.o(69971);
      return;
      ac.e("MicroMsg.NetSceneIbgPayGetJumpUrl", "hy: get ibg pay jump url failed");
      this.jumpUrl = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.a.b
 * JD-Core Version:    0.7.0.1
 */