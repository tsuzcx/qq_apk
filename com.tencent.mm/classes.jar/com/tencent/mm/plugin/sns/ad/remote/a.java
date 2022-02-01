package com.tencent.mm.plugin.sns.ad.remote;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.remote.a.b;
import com.tencent.mm.plugin.sns.ad.remote.ipc.impl.IPCRemoteProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  public com.tencent.mm.plugin.sns.ad.remote.a.a JGT;
  public b JGU;
  d JGV;
  
  public final com.tencent.mm.plugin.sns.ad.remote.ipc.a fKZ()
  {
    AppMethodBeat.i(253242);
    try
    {
      if (this.JGV == null)
      {
        this.JGV = AdLandingPagesProxy.getInstance().getRemoteServiceProxy();
        if (this.JGV == null)
        {
          Log.w("SnsAd.IPCRequestBuilder", "the remote service proxy is null");
          AppMethodBeat.o(253242);
          return null;
        }
      }
      if ((this.JGT != null) && (this.JGU == null)) {
        if ((this.JGT instanceof b)) {
          this.JGU = ((b)this.JGT);
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.sns.ad.remote.ipc.impl.a locala = new com.tencent.mm.plugin.sns.ad.remote.ipc.impl.a();
        locala.JGY = this.JGT;
        locala.JGX = this.JGU;
        locala.JGZ = new IPCRemoteProxy(this.JGV, locala);
        AppMethodBeat.o(253242);
        return locala;
        if ((this.JGT == null) && (this.JGU != null) && ((this.JGU instanceof com.tencent.mm.plugin.sns.ad.remote.a.a))) {
          this.JGT = ((com.tencent.mm.plugin.sns.ad.remote.a.a)this.JGU);
        }
      }
      return null;
    }
    catch (Throwable localThrowable)
    {
      Log.e("SnsAd.IPCRequestBuilder", "there is something invalid in build!");
      AppMethodBeat.o(253242);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.remote.a
 * JD-Core Version:    0.7.0.1
 */