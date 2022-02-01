package com.tencent.mm.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.egs;
import com.tencent.mm.protocal.protobuf.egt;
import com.tencent.mm.sdk.platformtools.Log;

public final class u
  extends w
{
  public String Wag;
  public String Wah;
  private h callback;
  public final c rr;
  public String xOk;
  
  public u(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(242143);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new egs();
    ((c.a)localObject).otF = new egt();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/preparepurchase";
    ((c.a)localObject).funcId = 422;
    ((c.a)localObject).otG = 214;
    ((c.a)localObject).respCmdId = 1000000214;
    this.rr = ((c.a)localObject).bEF();
    localObject = (egs)c.b.b(this.rr.otB);
    this.xOk = paramString1;
    ((egs)localObject).ProductID = paramString1;
    this.Wah = paramString2;
    ((egs)localObject).ablY = paramString2;
    ((egs)localObject).MFe = paramInt;
    Log.d("MicroMsg.NetScenePreparePurchase", "productId:" + paramString1 + ",wecoinPrice:" + paramString2 + ",payType:" + paramInt);
    AppMethodBeat.o(242143);
  }
  
  public u(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4)
  {
    AppMethodBeat.i(72797);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new egs();
    ((c.a)localObject).otF = new egt();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/preparepurchase";
    ((c.a)localObject).funcId = 422;
    ((c.a)localObject).otG = 214;
    ((c.a)localObject).respCmdId = 1000000214;
    this.rr = ((c.a)localObject).bEF();
    localObject = (egs)c.b.b(this.rr.otB);
    this.xOk = paramString1;
    ((egs)localObject).ProductID = paramString1;
    this.Wah = paramString2;
    ((egs)localObject).ablY = paramString2;
    this.Wag = paramString3;
    ((egs)localObject).ablZ = paramString3;
    ((egs)localObject).MFe = paramInt2;
    ((egs)localObject).abma = paramInt1;
    ((egs)localObject).IMu = paramString4;
    Log.d("MicroMsg.NetScenePreparePurchase", "productId:" + paramString1 + ",price:" + paramString2 + ",currencyType:" + paramString3 + ",payType:" + paramInt2);
    AppMethodBeat.o(72797);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(72799);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(72799);
    return i;
  }
  
  public final int getType()
  {
    return 422;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(72798);
    Log.e("MicroMsg.NetScenePreparePurchase", "ErrType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg:" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(72798);
      return;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(72798);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.model.u
 * JD-Core Version:    0.7.0.1
 */