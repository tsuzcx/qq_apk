package com.tencent.mm.plugin.wallet_index.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.djw;
import com.tencent.mm.protocal.protobuf.djx;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends q
  implements m
{
  private djx PjL;
  private djw PjM;
  private i callback;
  private final d rr;
  
  public b(int paramInt)
  {
    AppMethodBeat.i(275031);
    d.a locala = new d.a();
    locala.lBU = new djw();
    locala.lBV = new djx();
    locala.funcId = 2540;
    locala.uri = "/cgi-bin/mmpay-bin/payibgquickgetoverseawallet";
    this.rr = locala.bgN();
    this.PjM = ((djw)d.b.b(this.rr.lBR));
    this.PjM.TRo = paramInt;
    AppMethodBeat.o(275031);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(275033);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(275033);
    return i;
  }
  
  public final djx gMW()
  {
    AppMethodBeat.i(275035);
    if (this.PjL == null)
    {
      localdjx = new djx();
      AppMethodBeat.o(275035);
      return localdjx;
    }
    djx localdjx = this.PjL;
    AppMethodBeat.o(275035);
    return localdjx;
  }
  
  public final int getType()
  {
    return 2540;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(275034);
    Log.i("MicroMsg.NetScenePayIBGQuickGetOverseaWallet", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.PjL = ((djx)d.c.b(((d)params).lBS));
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(275034);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.a.b
 * JD-Core Version:    0.7.0.1
 */