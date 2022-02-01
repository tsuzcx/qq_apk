package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.protocal.protobuf.dds;
import com.tencent.mm.protocal.protobuf.ddt;
import com.tencent.mm.sdk.platformtools.Log;

public final class k
  extends c<ddt>
{
  public int scene;
  
  public k(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(68447);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dds();
    ((d.a)localObject).iLO = new ddt();
    ((d.a)localObject).funcId = 1770;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/preaddplan";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    localObject = ((d.a)localObject).aXF();
    dds localdds = (dds)((d)localObject).iLK.iLR;
    localdds.scene = paramInt1;
    localdds.Htr = paramInt2;
    c((d)localObject);
    this.scene = paramInt1;
    Log.i("MicroMsg.CgiLqtPreAddPlan", "scene: %s, planId: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(68447);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.k
 * JD-Core Version:    0.7.0.1
 */