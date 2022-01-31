package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class m$a$h
  extends com.tencent.mm.sdk.d.b
{
  private boolean rwc;
  
  m$a$h(m.a parama) {}
  
  public final void enter()
  {
    AppMethodBeat.i(37136);
    super.enter();
    if (!AdLandingPagesProxy.getInstance().isApkExist(m.b(this.rvU.rvI).cwc))
    {
      this.rvU.b(this.rvU.rvM);
      AppMethodBeat.o(37136);
      return;
    }
    al.d(new m.a.h.1(this));
    this.rwc = true;
    AppMethodBeat.o(37136);
  }
  
  public final boolean k(Message paramMessage)
  {
    AppMethodBeat.i(37137);
    ab.i("LogStateTransitionState", hashCode() + "[ToInstallState] recv msg.what " + paramMessage.what);
    switch (paramMessage.what)
    {
    case 1: 
    default: 
      AppMethodBeat.o(37137);
      return false;
    case 0: 
      if (AdLandingPagesProxy.getInstance().installApp(this.rvU.rvI.context, m.b(this.rvU.rvI).cwc, m.b(this.rvU.rvI).Ca, m.b(this.rvU.rvI).cqq, m.b(this.rvU.rvI).downloadUrl))
      {
        this.rwc = true;
        AppMethodBeat.o(37137);
        return true;
      }
      m.a.a(this.rvU, this.rvU.rvI.context.getString(2131303751));
      this.rvU.b(this.rvU.rvQ);
      AppMethodBeat.o(37137);
      return true;
    case 2: 
      if (!AdLandingPagesProxy.getInstance().isApkExist(m.b(this.rvU.rvI).cwc)) {
        this.rvU.b(this.rvU.rvM);
      }
      AppMethodBeat.o(37137);
      return true;
    }
    if (this.rwc) {
      this.rwc = false;
    }
    this.rvU.b(this.rvU.rvP);
    AppMethodBeat.o(37137);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m.a.h
 * JD-Core Version:    0.7.0.1
 */