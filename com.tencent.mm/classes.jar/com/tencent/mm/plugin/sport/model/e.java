package com.tencent.mm.plugin.sport.model;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.dwc;
import com.tencent.mm.protocal.protobuf.dwd;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.storage.bw;

public final class e
  extends n
  implements k
{
  private g callback;
  private b hEg;
  dwd zoZ;
  
  public e()
  {
    AppMethodBeat.i(149302);
    Object localObject = new b.a();
    ((b.a)localObject).funcId = 1947;
    ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/hardware/getwxsportconfig";
    ((b.a)localObject).hvt = new dwc();
    ((b.a)localObject).hvu = new dwd();
    this.hEg = ((b.a)localObject).aAz();
    localObject = (dwc)this.hEg.hvr.hvw;
    ((dwc)localObject).ncV = d.DEVICE_NAME;
    ((dwc)localObject).DUp = bw.fcC();
    ((dwc)localObject).fZr = Build.BRAND;
    ((dwc)localObject).fZq = Build.MODEL;
    ((dwc)localObject).Gds = d.DHY;
    ((dwc)localObject).fZs = d.DHZ;
    ((dwc)localObject).fZt = d.DIa;
    ((dwc)localObject).Gdt = h.gMJ;
    ((dwc)localObject).Gdu = Build.MANUFACTURER;
    ac.i("MicroMsg.Sport.NetSceneGetWeSportConfig", "request params=[%s, %s, %s, %s, %s, %s, %s, %s, %s]", new Object[] { ((dwc)localObject).DUp, ((dwc)localObject).fZr, ((dwc)localObject).fZq, ((dwc)localObject).ncV, ((dwc)localObject).fZt, ((dwc)localObject).fZs, ((dwc)localObject).fZt, ((dwc)localObject).Gdt, ((dwc)localObject).Gdu });
    AppMethodBeat.o(149302);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(149303);
    this.callback = paramg;
    int i = dispatch(parame, this.hEg, this);
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
    ac.i("MicroMsg.Sport.NetSceneGetWeSportConfig", "onGYNetEnd %d %d %d %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(149304);
      return;
    }
    this.zoZ = ((dwd)this.hEg.hvs.hvw);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(149304);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.e
 * JD-Core Version:    0.7.0.1
 */