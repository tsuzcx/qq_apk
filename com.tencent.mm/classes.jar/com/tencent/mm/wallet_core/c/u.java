package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dob;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.sdk.platformtools.Log;

public final class u
  extends w
{
  public String Pjo;
  public String Pjp;
  private i callback;
  public final d rr;
  public String uFI;
  
  public u(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4)
  {
    AppMethodBeat.i(72797);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new dob();
    ((d.a)localObject).lBV = new doc();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/preparepurchase";
    ((d.a)localObject).funcId = 422;
    ((d.a)localObject).lBW = 214;
    ((d.a)localObject).respCmdId = 1000000214;
    this.rr = ((d.a)localObject).bgN();
    localObject = (dob)d.b.b(this.rr.lBR);
    this.uFI = paramString1;
    ((dob)localObject).ProductID = paramString1;
    this.Pjp = paramString2;
    ((dob)localObject).TVo = paramString2;
    this.Pjo = paramString3;
    ((dob)localObject).TVp = paramString3;
    ((dob)localObject).GIo = paramInt2;
    ((dob)localObject).TVq = paramInt1;
    ((dob)localObject).CSe = paramString4;
    Log.d("MicroMsg.NetScenePreparePurchase", "productId:" + paramString1 + ",price:" + paramString2 + ",currencyType:" + paramString3 + ",payType:" + paramInt2);
    AppMethodBeat.o(72797);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(72799);
    this.callback = parami;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.u
 * JD-Core Version:    0.7.0.1
 */