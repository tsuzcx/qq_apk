package com.tencent.mm.plugin.sns.ad.remote;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.remote.a.b;
import com.tencent.mm.plugin.sns.ad.remote.ipc.impl.IPCRemoteProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  public com.tencent.mm.plugin.sns.ad.remote.a.a Dxm;
  public b Dxn;
  d Dxo;
  
  public final com.tencent.mm.plugin.sns.ad.remote.ipc.a eXy()
  {
    AppMethodBeat.i(202062);
    try
    {
      if (this.Dxo == null)
      {
        this.Dxo = AdLandingPagesProxy.getInstance().getRemoteServiceProxy();
        if (this.Dxo == null)
        {
          Log.w("SnsAd.IPCRequestBuilder", "the remote service proxy is null");
          AppMethodBeat.o(202062);
          return null;
        }
      }
      if ((this.Dxm != null) && (this.Dxn == null)) {
        if ((this.Dxm instanceof b)) {
          this.Dxn = ((b)this.Dxm);
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.sns.ad.remote.ipc.impl.a locala = new com.tencent.mm.plugin.sns.ad.remote.ipc.impl.a();
        locala.Dxr = this.Dxm;
        locala.Dxq = this.Dxn;
        locala.Dxs = new IPCRemoteProxy(this.Dxo, locala);
        AppMethodBeat.o(202062);
        return locala;
        if ((this.Dxm == null) && (this.Dxn != null) && ((this.Dxn instanceof com.tencent.mm.plugin.sns.ad.remote.a.a))) {
          this.Dxm = ((com.tencent.mm.plugin.sns.ad.remote.a.a)this.Dxn);
        }
      }
      return null;
    }
    catch (Throwable localThrowable)
    {
      Log.e("SnsAd.IPCRequestBuilder", "there is something invalid in build!");
      AppMethodBeat.o(202062);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.remote.a
 * JD-Core Version:    0.7.0.1
 */