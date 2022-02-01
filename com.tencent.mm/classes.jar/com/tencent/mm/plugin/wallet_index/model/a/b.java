package com.tencent.mm.plugin.wallet_index.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ecg;
import com.tencent.mm.protocal.protobuf.ech;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.w;

public final class b
  extends w
{
  private ech WaO;
  private ecg WaP;
  private h callback;
  private final c rr;
  
  public b(int paramInt)
  {
    AppMethodBeat.i(263688);
    c.a locala = new c.a();
    locala.otE = new ecg();
    locala.otF = new ech();
    locala.funcId = 2540;
    locala.uri = "/cgi-bin/mmpay-bin/payibgquickgetoverseawallet";
    this.rr = locala.bEF();
    this.WaP = ((ecg)c.b.b(this.rr.otB));
    this.WaP.abhN = paramInt;
    AppMethodBeat.o(263688);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(263694);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(263694);
    return i;
  }
  
  public final int getType()
  {
    return 2540;
  }
  
  public final ech iml()
  {
    AppMethodBeat.i(263703);
    if (this.WaO == null)
    {
      localech = new ech();
      AppMethodBeat.o(263703);
      return localech;
    }
    ech localech = this.WaO;
    AppMethodBeat.o(263703);
    return localech;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(263700);
    Log.i("MicroMsg.NetScenePayIBGQuickGetOverseaWallet", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.WaO = ((ech)c.c.b(((c)params).otC));
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(263700);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.model.a.b
 * JD-Core Version:    0.7.0.1
 */