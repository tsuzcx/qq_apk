package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ccu;
import com.tencent.mm.protocal.protobuf.ccv;
import com.tencent.mm.protocal.protobuf.eph;
import com.tencent.mm.protocal.protobuf.epi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.w;

public final class n
  extends w
{
  private i callback;
  public int errCode;
  public String productId;
  private d rr;
  
  public n(int paramInt1, int paramInt2, String paramString, ccv paramccv, ccu paramccu)
  {
    AppMethodBeat.i(71827);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new eph();
    ((d.a)localObject).iLO = new epi();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/boss/verifyandroidiappackage";
    ((d.a)localObject).funcId = 1306;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (eph)this.rr.iLK.iLR;
    ((eph)localObject).LSk = paramInt1;
    ((eph)localObject).dUT = paramInt2;
    this.productId = paramString;
    ((eph)localObject).LSp = paramccv;
    ((eph)localObject).LSo = paramccu;
    AppMethodBeat.o(71827);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(71829);
    this.callback = parami;
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
    params = (epi)this.rr.iLL.iLR;
    Log.e("MicroMsg.NetSceneVerifyAndroidIapPackage", "business: errCode:" + params.dOK + ",errMsg:" + params.dOL);
    paramInt1 = params.dOK;
    this.callback.onSceneEnd(paramInt2, paramInt1, paramString, this);
    AppMethodBeat.o(71828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.n
 * JD-Core Version:    0.7.0.1
 */