package com.tencent.mm.plugin.sport.model;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eyb;
import com.tencent.mm.protocal.protobuf.eyc;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ck;

public final class d
  extends q
  implements m
{
  eyc Fjq;
  private i callback;
  private com.tencent.mm.ak.d iUB;
  
  public d()
  {
    AppMethodBeat.i(149302);
    Object localObject = new d.a();
    ((d.a)localObject).funcId = 1947;
    ((d.a)localObject).uri = "/cgi-bin/mmoc-bin/hardware/getwxsportconfig";
    ((d.a)localObject).iLN = new eyb();
    ((d.a)localObject).iLO = new eyc();
    this.iUB = ((d.a)localObject).aXF();
    localObject = (eyb)this.iUB.iLK.iLR;
    ((eyb)localObject).oTI = com.tencent.mm.protocal.d.DEVICE_NAME;
    ((eyb)localObject).KLO = ck.getFingerprint();
    ((eyb)localObject).hie = Build.BRAND;
    ((eyb)localObject).hid = Build.MODEL;
    ((eyb)localObject).Nvj = com.tencent.mm.protocal.d.KyK;
    ((eyb)localObject).hif = com.tencent.mm.protocal.d.KyL;
    ((eyb)localObject).hig = com.tencent.mm.protocal.d.KyM;
    ((eyb)localObject).Nvk = BuildInfo.CLIENT_VERSION;
    ((eyb)localObject).Nvl = Build.MANUFACTURER;
    Log.i("MicroMsg.Sport.NetSceneGetWeSportConfig", "request params=[%s, %s, %s, %s, %s, %s, %s, %s, %s]", new Object[] { ((eyb)localObject).KLO, ((eyb)localObject).hie, ((eyb)localObject).hid, ((eyb)localObject).oTI, ((eyb)localObject).hig, ((eyb)localObject).hif, ((eyb)localObject).hig, ((eyb)localObject).Nvk, ((eyb)localObject).Nvl });
    AppMethodBeat.o(149302);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(149303);
    this.callback = parami;
    int i = dispatch(paramg, this.iUB, this);
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
    this.Fjq = ((eyc)this.iUB.iLL.iLR);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(149304);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.d
 * JD-Core Version:    0.7.0.1
 */