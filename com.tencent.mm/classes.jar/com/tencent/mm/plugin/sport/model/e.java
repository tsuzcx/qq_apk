package com.tencent.mm.plugin.sport.model;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.cwi;
import com.tencent.mm.protocal.protobuf.cwj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bs;

public final class e
  extends m
  implements k
{
  private com.tencent.mm.ai.f callback;
  private b fBd;
  cwj spF;
  
  public e()
  {
    AppMethodBeat.i(93660);
    Object localObject = new b.a();
    ((b.a)localObject).funcId = 1947;
    ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/hardware/getwxsportconfig";
    ((b.a)localObject).fsX = new cwi();
    ((b.a)localObject).fsY = new cwj();
    this.fBd = ((b.a)localObject).ado();
    localObject = (cwi)this.fBd.fsV.fta;
    ((cwi)localObject).jJE = d.DEVICE_NAME;
    ((cwi)localObject).wsq = bs.dyO();
    ((cwi)localObject).wAc = Build.BRAND;
    ((cwi)localObject).wAb = Build.MODEL;
    ((cwi)localObject).yex = d.whD;
    ((cwi)localObject).wAd = d.whE;
    ((cwi)localObject).wAe = d.whF;
    ((cwi)localObject).yey = com.tencent.mm.sdk.platformtools.f.CLIENT_VERSION;
    ((cwi)localObject).yez = Build.MANUFACTURER;
    ab.i("MicroMsg.Sport.NetSceneGetWeSportConfig", "request params=[%s, %s, %s, %s, %s, %s, %s, %s, %s]", new Object[] { ((cwi)localObject).wsq, ((cwi)localObject).wAc, ((cwi)localObject).wAb, ((cwi)localObject).jJE, ((cwi)localObject).wAe, ((cwi)localObject).wAd, ((cwi)localObject).wAe, ((cwi)localObject).yey, ((cwi)localObject).yez });
    AppMethodBeat.o(93660);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(93661);
    this.callback = paramf;
    int i = dispatch(parame, this.fBd, this);
    AppMethodBeat.o(93661);
    return i;
  }
  
  public final int getType()
  {
    return 1947;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(93662);
    ab.i("MicroMsg.Sport.NetSceneGetWeSportConfig", "onGYNetEnd %d %d %d %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(93662);
      return;
    }
    this.spF = ((cwj)this.fBd.fsW.fta);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(93662);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.e
 * JD-Core Version:    0.7.0.1
 */