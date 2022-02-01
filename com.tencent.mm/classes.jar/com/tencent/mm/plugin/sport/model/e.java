package com.tencent.mm.plugin.sport.model;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.dql;
import com.tencent.mm.protocal.protobuf.dqm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.storage.bt;

public final class e
  extends n
  implements k
{
  private g callback;
  private b hdD;
  dqm ybZ;
  
  public e()
  {
    AppMethodBeat.i(149302);
    Object localObject = new b.a();
    ((b.a)localObject).funcId = 1947;
    ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/hardware/getwxsportconfig";
    ((b.a)localObject).gUU = new dql();
    ((b.a)localObject).gUV = new dqm();
    this.hdD = ((b.a)localObject).atI();
    localObject = (dql)this.hdD.gUS.gUX;
    ((dql)localObject).mAU = d.DEVICE_NAME;
    ((dql)localObject).CBS = bt.eMY();
    ((dql)localObject).fVw = Build.BRAND;
    ((dql)localObject).fVv = Build.MODEL;
    ((dql)localObject).EGg = d.CpG;
    ((dql)localObject).fVx = d.CpH;
    ((dql)localObject).fVy = d.CpI;
    ((dql)localObject).EGh = h.glW;
    ((dql)localObject).EGi = Build.MANUFACTURER;
    ad.i("MicroMsg.Sport.NetSceneGetWeSportConfig", "request params=[%s, %s, %s, %s, %s, %s, %s, %s, %s]", new Object[] { ((dql)localObject).CBS, ((dql)localObject).fVw, ((dql)localObject).fVv, ((dql)localObject).mAU, ((dql)localObject).fVy, ((dql)localObject).fVx, ((dql)localObject).fVy, ((dql)localObject).EGh, ((dql)localObject).EGi });
    AppMethodBeat.o(149302);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(149303);
    this.callback = paramg;
    int i = dispatch(parame, this.hdD, this);
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
    ad.i("MicroMsg.Sport.NetSceneGetWeSportConfig", "onGYNetEnd %d %d %d %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(149304);
      return;
    }
    this.ybZ = ((dqm)this.hdD.gUT.gUX);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(149304);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.e
 * JD-Core Version:    0.7.0.1
 */