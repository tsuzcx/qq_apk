package com.tencent.mm.plugin.wallet_core.c.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dac;
import com.tencent.mm.protocal.protobuf.dad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.c.w;

public final class b
  extends w
{
  public int HQH;
  private i callback;
  public String jumpUrl;
  private d rr;
  
  public b()
  {
    AppMethodBeat.i(69970);
    this.HQH = 0;
    d.a locala = new d.a();
    dac localdac = new dac();
    com.tencent.mm.kernel.g.aAi();
    Object localObject = com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NWB, Boolean.FALSE);
    if (localObject != null) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      if (bool) {}
      for (int i = 1;; i = 0)
      {
        localdac.MFl = i;
        locala.iLN = localdac;
        locala.iLO = new dad();
        locala.uri = "/cgi-bin/mmpay-bin/payibggetjumpurl";
        locala.funcId = 1564;
        locala.iLP = 0;
        locala.respCmdId = 0;
        this.rr = locala.aXF();
        AppMethodBeat.o(69970);
        return;
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(69972);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(69972);
    return i;
  }
  
  public final int getType()
  {
    return 1564;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(69971);
    Log.i("MicroMsg.NetSceneIbgPayGetJumpUrl", "hy: get ibg jump url raw net errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = (dad)((d)params).iLL.iLR;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      Log.i("MicroMsg.NetSceneIbgPayGetJumpUrl", "hy: get ibg pay jump url. biz_errcode: %d, biz_errmsg: %s", new Object[] { Integer.valueOf(params.rBL), params.rBM });
      paramString = params.rBM;
      paramInt3 = params.rBL;
      this.jumpUrl = params.xIy;
      this.HQH = params.MFm;
    }
    for (;;)
    {
      params = paramString;
      if (Util.isNullOrNil(paramString)) {
        params = MMApplicationContext.getContext().getString(2131767667);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, params, this);
      AppMethodBeat.o(69971);
      return;
      Log.e("MicroMsg.NetSceneIbgPayGetJumpUrl", "hy: get ibg pay jump url failed");
      this.jumpUrl = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.a.b
 * JD-Core Version:    0.7.0.1
 */