package com.tencent.mm.plugin.wallet_index.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dbf;
import com.tencent.mm.protocal.protobuf.dbg;
import com.tencent.mm.protocal.protobuf.fvw;
import com.tencent.mm.protocal.protobuf.fvx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.w;

public final class n
  extends w
{
  private h callback;
  public int errCode;
  public String productId;
  private c rr;
  
  public n(int paramInt1, int paramInt2, String paramString, dbg paramdbg, dbf paramdbf)
  {
    AppMethodBeat.i(71827);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fvw();
    ((c.a)localObject).otF = new fvx();
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/boss/verifyandroidiappackage";
    ((c.a)localObject).funcId = 1306;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (fvw)c.b.b(this.rr.otB);
    ((fvw)localObject).aaog = paramInt1;
    ((fvw)localObject).hUo = paramInt2;
    this.productId = paramString;
    ((fvw)localObject).aaon = paramdbg;
    ((fvw)localObject).aaom = paramdbf;
    AppMethodBeat.o(71827);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(71829);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(71829);
    return i;
  }
  
  public final int getType()
  {
    return 1306;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(71828);
    Log.e("MicroMsg.NetSceneVerifyAndroidIapPackage", "ErrType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg:" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(71828);
      return;
    }
    params = (fvx)c.c.b(this.rr.otC);
    Log.e("MicroMsg.NetSceneVerifyAndroidIapPackage", "business: errCode:" + params.hNv + ",errMsg:" + params.hNw);
    paramInt1 = params.hNv;
    this.callback.onSceneEnd(paramInt2, paramInt1, paramString, this);
    AppMethodBeat.o(71828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.model.n
 * JD-Core Version:    0.7.0.1
 */