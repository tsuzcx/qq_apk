package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class m$a$g
  extends com.tencent.mm.sdk.d.b
{
  m$a$g(m.a parama) {}
  
  public final void enter()
  {
    AppMethodBeat.i(37133);
    super.enter();
    al.d(new m.a.g.1(this));
    if (AdLandingPagesProxy.getInstance().isPkgInstalled(m.b(this.rvU.rvI).Ca))
    {
      this.rvU.b(this.rvU.rvP);
      AppMethodBeat.o(37133);
      return;
    }
    if (AdLandingPagesProxy.getInstance().isApkExist(m.b(this.rvU.rvI).cwc))
    {
      this.rvU.b(this.rvU.rvO);
      AppMethodBeat.o(37133);
      return;
    }
    if (AdLandingPagesProxy.getInstance().isDownloading(m.b(this.rvU.rvI).cwc))
    {
      this.rvU.b(this.rvU.rvL);
      AppMethodBeat.o(37133);
      return;
    }
    if (AdLandingPagesProxy.getInstance().isPaused(m.b(this.rvU.rvI).cwc))
    {
      this.rvU.b(this.rvU.rvN);
      AppMethodBeat.o(37133);
      return;
    }
    al.d(new m.a.g.2(this));
    AppMethodBeat.o(37133);
  }
  
  public final boolean k(Message paramMessage)
  {
    AppMethodBeat.i(37134);
    ab.i("LogStateTransitionState", hashCode() + "[ToDownloadState]recv msg.what " + paramMessage.what);
    switch (paramMessage.what)
    {
    default: 
      AppMethodBeat.o(37134);
      return false;
    case 0: 
      if (AdLandingPagesProxy.getInstance().isDownloading(m.b(this.rvU.rvI).cwc)) {
        m.a.a(this.rvU, this.rvU.rvI.context.getString(2131303747));
      }
      for (;;)
      {
        AppMethodBeat.o(37134);
        return true;
        al.d(new m.a.g.3(this));
      }
    case 3: 
      this.rvU.b(this.rvU.rvP);
      AppMethodBeat.o(37134);
      return true;
    case 11: 
      this.rvU.b(this.rvU.rvM);
      AppMethodBeat.o(37134);
      return true;
    }
    this.rvU.b(this.rvU.rvL);
    AppMethodBeat.o(37134);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m.a.g
 * JD-Core Version:    0.7.0.1
 */