package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.del;
import com.tencent.mm.protocal.protobuf.dem;
import com.tencent.mm.sdk.platformtools.Log;

public final class u
  extends w
{
  public String IqF;
  public String IqG;
  private i callback;
  public String rcD;
  public final d rr;
  
  public u(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4)
  {
    AppMethodBeat.i(72797);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new del();
    ((d.a)localObject).iLO = new dem();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/preparepurchase";
    ((d.a)localObject).funcId = 422;
    ((d.a)localObject).iLP = 214;
    ((d.a)localObject).respCmdId = 1000000214;
    this.rr = ((d.a)localObject).aXF();
    localObject = (del)this.rr.iLK.iLR;
    this.rcD = paramString1;
    ((del)localObject).ProductID = paramString1;
    this.IqG = paramString2;
    ((del)localObject).MJz = paramString2;
    this.IqF = paramString3;
    ((del)localObject).MJA = paramString3;
    ((del)localObject).APa = paramInt2;
    ((del)localObject).MJB = paramInt1;
    ((del)localObject).xNU = paramString4;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.u
 * JD-Core Version:    0.7.0.1
 */