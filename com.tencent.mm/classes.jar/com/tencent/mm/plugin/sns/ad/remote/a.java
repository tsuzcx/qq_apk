package com.tencent.mm.plugin.sns.ad.remote;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.remote.a.b;
import com.tencent.mm.plugin.sns.ad.remote.ipc.impl.IPCRemoteProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  public com.tencent.mm.plugin.sns.ad.remote.a.a PXT;
  public b PXU;
  d PXV;
  
  public final com.tencent.mm.plugin.sns.ad.remote.ipc.a hbq()
  {
    AppMethodBeat.i(309654);
    try
    {
      if (this.PXV == null)
      {
        this.PXV = AdLandingPagesProxy.getInstance().getRemoteServiceProxy();
        if (this.PXV == null) {
          return null;
        }
      }
      if ((this.PXT != null) && (this.PXU == null)) {
        if ((this.PXT instanceof b)) {
          this.PXU = ((b)this.PXT);
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.sns.ad.remote.ipc.impl.a locala = new com.tencent.mm.plugin.sns.ad.remote.ipc.impl.a();
        locala.PXY = this.PXT;
        locala.PXX = this.PXU;
        locala.PXZ = new IPCRemoteProxy(this.PXV, locala);
        AppMethodBeat.o(309654);
        return locala;
        if ((this.PXT == null) && (this.PXU != null) && ((this.PXU instanceof com.tencent.mm.plugin.sns.ad.remote.a.a))) {
          this.PXT = ((com.tencent.mm.plugin.sns.ad.remote.a.a)this.PXU);
        }
      }
      return null;
    }
    finally
    {
      Log.e("SnsAd.IPCRequestBuilder", "there is something invalid in build!");
      AppMethodBeat.o(309654);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.remote.a
 * JD-Core Version:    0.7.0.1
 */