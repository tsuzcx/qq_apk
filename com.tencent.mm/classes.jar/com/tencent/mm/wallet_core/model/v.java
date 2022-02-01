package com.tencent.mm.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.fwj;
import com.tencent.mm.protocal.protobuf.fwk;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class v
  extends w
{
  public int Wbe;
  private h callback;
  private int errCode;
  private final c rr;
  public String xOk;
  public String xOm;
  
  public v(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(72800);
    this.xOk = null;
    this.Wbe = 0;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fwj();
    ((c.a)localObject).otF = new fwk();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/verifypurchase";
    ((c.a)localObject).funcId = 414;
    ((c.a)localObject).otG = 215;
    ((c.a)localObject).respCmdId = 1000000215;
    this.rr = ((c.a)localObject).bEF();
    localObject = (fwj)c.b.b(this.rr.otB);
    this.xOk = paramString1;
    ((fwj)localObject).ProductID = paramString1;
    ((fwj)localObject).abUi = paramInt1;
    ((fwj)localObject).abma = paramInt3;
    ((fwj)localObject).MFe = paramInt2;
    if (!Util.isNullOrNil(paramString6))
    {
      ((fwj)localObject).ablY = paramString6;
      ((fwj)localObject).ablZ = paramString5;
    }
    ((fwj)localObject).abmb = paramString2;
    ((fwj)localObject).abUk = paramString4;
    if (paramString3 != null) {
      paramString1 = paramString3.getBytes();
    }
    for (((fwj)localObject).abUh = new gol().df(paramString1);; ((fwj)localObject).abUh = new gol())
    {
      ((fwj)localObject).abUj = ((int)Util.nowSecond());
      Log.i("MicroMsg.NetSceneVerifyPurchase", "productId:" + this.xOk + ",verifyType:" + paramInt1 + ",palyType:" + paramInt2 + ",payload:" + paramString2 + ",purchaseData:" + paramString3 + ",dataSignature:" + paramString4);
      AppMethodBeat.o(72800);
      return;
    }
  }
  
  public v(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(242149);
    this.xOk = null;
    this.Wbe = 0;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fwj();
    ((c.a)localObject).otF = new fwk();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/verifypurchase";
    ((c.a)localObject).funcId = 414;
    ((c.a)localObject).otG = 215;
    ((c.a)localObject).respCmdId = 1000000215;
    this.rr = ((c.a)localObject).bEF();
    localObject = (fwj)c.b.b(this.rr.otB);
    this.xOk = paramString1;
    ((fwj)localObject).ProductID = paramString1;
    ((fwj)localObject).MFe = paramInt;
    if (!Util.isNullOrNil(paramString3)) {
      ((fwj)localObject).ablY = paramString3;
    }
    ((fwj)localObject).abmb = paramString2;
    ((fwj)localObject).abUi = 1;
    ((fwj)localObject).abUh = new gol();
    ((fwj)localObject).abUj = ((int)Util.nowSecond());
    Log.i("MicroMsg.NetSceneVerifyPurchase", "ProductID:%s, Price:%s, PayType:%s, BillNo:%s", new Object[] { this.xOk, paramString3, Integer.valueOf(paramInt), paramString2 });
    AppMethodBeat.o(242149);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(72802);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(72802);
    return i;
  }
  
  public final int getType()
  {
    return 414;
  }
  
  public final boolean jOM()
  {
    return this.errCode == 0;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(72801);
    Log.e("MicroMsg.NetSceneVerifyPurchase", "ErrType:" + paramInt2 + "   errCode:" + paramInt3);
    this.errCode = 0;
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.errCode = -1;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(72801);
      return;
    }
    params = (fwk)c.c.b(((c)params).otC);
    if (params.BaseResponse != null)
    {
      this.Wbe = params.abUm;
      Log.d("MicroMsg.NetSceneVerifyPurchase", " Get Series ID is " + params.ZvK);
      Log.d("MicroMsg.NetSceneVerifyPurchase", " Get Biz Type is " + params.abUl);
      this.xOm = params.ZvK;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(72801);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.model.v
 * JD-Core Version:    0.7.0.1
 */