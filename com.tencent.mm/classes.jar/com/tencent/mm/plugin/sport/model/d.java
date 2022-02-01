package com.tencent.mm.plugin.sport.model;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.fir;
import com.tencent.mm.protocal.protobuf.fis;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cl;

public final class d
  extends q
  implements m
{
  fis LxP;
  private i callback;
  private com.tencent.mm.an.d lKU;
  
  public d()
  {
    AppMethodBeat.i(149302);
    Object localObject = new d.a();
    ((d.a)localObject).funcId = 1947;
    ((d.a)localObject).uri = "/cgi-bin/mmoc-bin/hardware/getwxsportconfig";
    ((d.a)localObject).lBU = new fir();
    ((d.a)localObject).lBV = new fis();
    this.lKU = ((d.a)localObject).bgN();
    localObject = (fir)d.b.b(this.lKU.lBR);
    ((fir)localObject).rVG = com.tencent.mm.protocal.d.RAB;
    ((fir)localObject).RMK = cl.hAM();
    ((fir)localObject).jUc = Build.BRAND;
    ((fir)localObject).jUb = Build.MODEL;
    ((fir)localObject).UIs = com.tencent.mm.protocal.d.RAy;
    ((fir)localObject).jUd = com.tencent.mm.protocal.d.RAz;
    ((fir)localObject).jUe = com.tencent.mm.protocal.d.RAA;
    ((fir)localObject).UIt = BuildInfo.CLIENT_VERSION;
    ((fir)localObject).UIu = Build.MANUFACTURER;
    Log.i("MicroMsg.Sport.NetSceneGetWeSportConfig", "request params=[%s, %s, %s, %s, %s, %s, %s, %s, %s]", new Object[] { ((fir)localObject).RMK, ((fir)localObject).jUc, ((fir)localObject).jUb, ((fir)localObject).rVG, ((fir)localObject).jUe, ((fir)localObject).jUd, ((fir)localObject).jUe, ((fir)localObject).UIt, ((fir)localObject).UIu });
    AppMethodBeat.o(149302);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(149303);
    this.callback = parami;
    int i = dispatch(paramg, this.lKU, this);
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
    this.LxP = ((fis)d.c.b(this.lKU.lBS));
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(149304);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.d
 * JD-Core Version:    0.7.0.1
 */