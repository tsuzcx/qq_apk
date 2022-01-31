package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.os.Message;
import com.tencent.mars.comm.NetStatusUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.base.h;

final class m$a$e
  extends com.tencent.mm.sdk.d.b
{
  m$a$e(m.a parama) {}
  
  public final void enter()
  {
    AppMethodBeat.i(37124);
    super.enter();
    al.d(new m.a.e.1(this));
    AppMethodBeat.o(37124);
  }
  
  public final boolean k(Message paramMessage)
  {
    AppMethodBeat.i(37125);
    ab.i("LogStateTransitionState", hashCode() + "[PauseState] recv msg.what " + paramMessage.what);
    switch (paramMessage.what)
    {
    default: 
      AppMethodBeat.o(37125);
      return false;
    case 0: 
      if (AdLandingPagesProxy.getInstance().isDownloading(m.b(this.rvU.rvI).cwc)) {
        m.a.a(this.rvU, this.rvU.rvI.context.getString(2131303747));
      }
      for (;;)
      {
        AppMethodBeat.o(37125);
        return true;
        if (!NetStatusUtil.isWifi(this.rvU.rvI.context))
        {
          ab.i("LogStateTransitionState", "download not in wifi!");
          h.a(this.rvU.rvI.context, 2131305852, 2131305853, new m.a.e.2(this), null);
        }
        else
        {
          this.rvU.sendMessage(12);
        }
      }
    case 3: 
      this.rvU.b(this.rvU.rvP);
      AppMethodBeat.o(37125);
      return true;
    case 8: 
      m.a.a(this.rvU, this.rvU.rvI.context.getString(2131303749));
      this.rvU.b(this.rvU.rvQ);
      AppMethodBeat.o(37125);
      return true;
    }
    this.rvU.b(this.rvU.rvL);
    AppMethodBeat.o(37125);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m.a.e
 * JD-Core Version:    0.7.0.1
 */