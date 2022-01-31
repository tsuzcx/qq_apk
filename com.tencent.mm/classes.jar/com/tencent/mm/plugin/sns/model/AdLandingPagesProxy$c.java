package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a;
import com.tencent.mm.sdk.platformtools.y;

final class AdLandingPagesProxy$c
  implements a.a
{
  public long id;
  
  private AdLandingPagesProxy$c(AdLandingPagesProxy paramAdLandingPagesProxy) {}
  
  public final void bCA()
  {
    this.oow.CLIENT_CALL("paused", new Object[] { Long.valueOf(this.id) });
  }
  
  public final void bCB()
  {
    this.oow.CLIENT_CALL("stopped", new Object[] { Long.valueOf(this.id) });
  }
  
  public final void bCC()
  {
    this.oow.CLIENT_CALL("succeed", new Object[] { Long.valueOf(this.id) });
  }
  
  public final void bCD()
  {
    this.oow.CLIENT_CALL("failed", new Object[] { Long.valueOf(this.id) });
  }
  
  public final void bCE()
  {
    this.oow.CLIENT_CALL("resumed", new Object[] { Long.valueOf(this.id) });
  }
  
  public final void start()
  {
    this.oow.CLIENT_CALL("start", new Object[] { Long.valueOf(this.id) });
  }
  
  public final void xE(int paramInt)
  {
    y.v("AdLandingPagesProxy", "progress %d", new Object[] { Integer.valueOf(paramInt) });
    this.oow.CLIENT_CALL("progress", new Object[] { Long.valueOf(this.id), Integer.valueOf(paramInt) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.c
 * JD-Core Version:    0.7.0.1
 */