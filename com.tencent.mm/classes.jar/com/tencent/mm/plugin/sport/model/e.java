package com.tencent.mm.plugin.sport.model;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.ecc;
import com.tencent.mm.protocal.protobuf.ecd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.storage.cc;

public final class e
  extends n
  implements k
{
  ecd AGT;
  private f callback;
  private b hWL;
  
  public e()
  {
    AppMethodBeat.i(149302);
    Object localObject = new b.a();
    ((b.a)localObject).funcId = 1947;
    ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/hardware/getwxsportconfig";
    ((b.a)localObject).hNM = new ecc();
    ((b.a)localObject).hNN = new ecd();
    this.hWL = ((b.a)localObject).aDC();
    localObject = (ecc)this.hWL.hNK.hNQ;
    ((ecc)localObject).nDs = d.DEVICE_NAME;
    ((ecc)localObject).FzJ = cc.fsJ();
    ((ecc)localObject).gsN = Build.BRAND;
    ((ecc)localObject).gsM = Build.MODEL;
    ((ecc)localObject).HOy = d.Fnf;
    ((ecc)localObject).gsO = d.Fng;
    ((ecc)localObject).gsP = d.Fnh;
    ((ecc)localObject).HOz = i.hgG;
    ((ecc)localObject).HOA = Build.MANUFACTURER;
    ad.i("MicroMsg.Sport.NetSceneGetWeSportConfig", "request params=[%s, %s, %s, %s, %s, %s, %s, %s, %s]", new Object[] { ((ecc)localObject).FzJ, ((ecc)localObject).gsN, ((ecc)localObject).gsM, ((ecc)localObject).nDs, ((ecc)localObject).gsP, ((ecc)localObject).gsO, ((ecc)localObject).gsP, ((ecc)localObject).HOz, ((ecc)localObject).HOA });
    AppMethodBeat.o(149302);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(149303);
    this.callback = paramf;
    int i = dispatch(parame, this.hWL, this);
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
    this.AGT = ((ecd)this.hWL.hNL.hNQ);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(149304);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.e
 * JD-Core Version:    0.7.0.1
 */