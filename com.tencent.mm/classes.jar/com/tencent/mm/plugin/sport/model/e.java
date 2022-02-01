package com.tencent.mm.plugin.sport.model;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.protocal.protobuf.edu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.storage.cd;

public final class e
  extends n
  implements k
{
  edu AYw;
  private f callback;
  private b hZD;
  
  public e()
  {
    AppMethodBeat.i(149302);
    Object localObject = new b.a();
    ((b.a)localObject).funcId = 1947;
    ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/hardware/getwxsportconfig";
    ((b.a)localObject).hQF = new edt();
    ((b.a)localObject).hQG = new edu();
    this.hZD = ((b.a)localObject).aDS();
    localObject = (edt)this.hZD.hQD.hQJ;
    ((edt)localObject).nIN = d.DEVICE_NAME;
    ((edt)localObject).FSh = cd.fwK();
    ((edt)localObject).gvp = Build.BRAND;
    ((edt)localObject).gvo = Build.MODEL;
    ((edt)localObject).IiF = d.FFD;
    ((edt)localObject).gvq = d.FFE;
    ((edt)localObject).gvr = d.FFF;
    ((edt)localObject).IiG = j.hju;
    ((edt)localObject).IiH = Build.MANUFACTURER;
    ae.i("MicroMsg.Sport.NetSceneGetWeSportConfig", "request params=[%s, %s, %s, %s, %s, %s, %s, %s, %s]", new Object[] { ((edt)localObject).FSh, ((edt)localObject).gvp, ((edt)localObject).gvo, ((edt)localObject).nIN, ((edt)localObject).gvr, ((edt)localObject).gvq, ((edt)localObject).gvr, ((edt)localObject).IiG, ((edt)localObject).IiH });
    AppMethodBeat.o(149302);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(149303);
    this.callback = paramf;
    int i = dispatch(parame, this.hZD, this);
    AppMethodBeat.o(149303);
    return i;
  }
  
  public final int getType()
  {
    return 1947;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(149304);
    ae.i("MicroMsg.Sport.NetSceneGetWeSportConfig", "onGYNetEnd %d %d %d %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(149304);
      return;
    }
    this.AYw = ((edu)this.hZD.hQE.hQJ);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(149304);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.e
 * JD-Core Version:    0.7.0.1
 */