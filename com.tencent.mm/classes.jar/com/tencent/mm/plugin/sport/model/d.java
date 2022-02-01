package com.tencent.mm.plugin.sport.model;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.gfe;
import com.tencent.mm.protocal.protobuf.gff;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.co;

public final class d
  extends p
  implements m
{
  gff SbC;
  private h callback;
  private c oDw;
  
  public d()
  {
    AppMethodBeat.i(149302);
    Object localObject = new c.a();
    ((c.a)localObject).funcId = 1947;
    ((c.a)localObject).uri = "/cgi-bin/mmoc-bin/hardware/getwxsportconfig";
    ((c.a)localObject).otE = new gfe();
    ((c.a)localObject).otF = new gff();
    this.oDw = ((c.a)localObject).bEF();
    localObject = (gfe)c.b.b(this.oDw.otB);
    ((gfe)localObject).vgW = com.tencent.mm.protocal.d.Yxf;
    ((gfe)localObject).YJY = co.jcP();
    ((gfe)localObject).muu = Build.BRAND;
    ((gfe)localObject).mut = q.aPo();
    ((gfe)localObject).accB = com.tencent.mm.protocal.d.Yxc;
    ((gfe)localObject).muv = com.tencent.mm.protocal.d.Yxd;
    ((gfe)localObject).muw = com.tencent.mm.protocal.d.Yxe;
    ((gfe)localObject).accC = BuildInfo.CLIENT_VERSION;
    ((gfe)localObject).accD = Build.MANUFACTURER;
    Log.i("MicroMsg.Sport.NetSceneGetWeSportConfig", "request params=[%s, %s, %s, %s, %s, %s, %s, %s, %s]", new Object[] { ((gfe)localObject).YJY, ((gfe)localObject).muu, ((gfe)localObject).mut, ((gfe)localObject).vgW, ((gfe)localObject).muw, ((gfe)localObject).muv, ((gfe)localObject).muw, ((gfe)localObject).accC, ((gfe)localObject).accD });
    AppMethodBeat.o(149302);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(149303);
    this.callback = paramh;
    int i = dispatch(paramg, this.oDw, this);
    AppMethodBeat.o(149303);
    return i;
  }
  
  public final int getType()
  {
    return 1947;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(149304);
    Log.i("MicroMsg.Sport.NetSceneGetWeSportConfig", "onGYNetEnd %d %d %d %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(149304);
      return;
    }
    this.SbC = ((gff)c.c.b(this.oDw.otC));
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(149304);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.d
 * JD-Core Version:    0.7.0.1
 */