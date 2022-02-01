package com.tencent.mm.plugin.wallet_index.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dai;
import com.tencent.mm.protocal.protobuf.daj;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends q
  implements m
{
  private daj Irc;
  private dai Ird;
  private i callback;
  private final d rr;
  
  public b(int paramInt)
  {
    AppMethodBeat.i(214272);
    d.a locala = new d.a();
    locala.iLN = new dai();
    locala.iLO = new daj();
    locala.funcId = 2540;
    locala.uri = "/cgi-bin/mmpay-bin/payibgquickgetoverseawallet";
    this.rr = locala.aXF();
    this.Ird = ((dai)this.rr.iLK.iLR);
    this.Ird.MFC = paramInt;
    AppMethodBeat.o(214272);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(214273);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(214273);
    return i;
  }
  
  public final daj fUq()
  {
    AppMethodBeat.i(214275);
    if (this.Irc == null)
    {
      localdaj = new daj();
      AppMethodBeat.o(214275);
      return localdaj;
    }
    daj localdaj = this.Irc;
    AppMethodBeat.o(214275);
    return localdaj;
  }
  
  public final int getType()
  {
    return 2540;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(214274);
    Log.i("MicroMsg.NetScenePayIBGQuickGetOverseaWallet", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.Irc = ((daj)((d)params).iLL.iLR);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(214274);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.a.b
 * JD-Core Version:    0.7.0.1
 */