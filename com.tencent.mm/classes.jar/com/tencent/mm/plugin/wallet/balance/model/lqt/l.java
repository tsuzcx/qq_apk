package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.protocal.protobuf.efx;
import com.tencent.mm.protocal.protobuf.efy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.z;

public final class l
  extends z<efy>
{
  public int scene;
  
  public l(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(68447);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new efx();
    ((c.a)localObject).otF = new efy();
    ((c.a)localObject).funcId = 1770;
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/preaddplan";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    localObject = ((c.a)localObject).bEF();
    efx localefx = (efx)c.b.b(((c)localObject).otB);
    localefx.scene = paramInt1;
    localefx.UZF = paramInt2;
    c((c)localObject);
    this.scene = paramInt1;
    Log.i("MicroMsg.CgiLqtPreAddPlan", "scene: %s, planId: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(68447);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.l
 * JD-Core Version:    0.7.0.1
 */