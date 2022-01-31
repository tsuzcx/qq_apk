package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.os.Message;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.ui.widget.SnsTextProgressBar;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class m$a$i
  extends com.tencent.mm.sdk.d.b
{
  m$a$i(m.a parama) {}
  
  public final void enter()
  {
    AppMethodBeat.i(37139);
    super.enter();
    if (AdLandingPagesProxy.getInstance().isPkgInstalled(m.b(this.rvU.rvI).Ca))
    {
      al.d(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(37138);
          m.c(m.a.i.this.rvU.rvI).setVisibility(8);
          m.d(m.a.i.this.rvU.rvI).setVisibility(0);
          m.d(m.a.i.this.rvU.rvI).setText(2131303752);
          AppMethodBeat.o(37138);
        }
      });
      AppMethodBeat.o(37139);
      return;
    }
    this.rvU.b(this.rvU.rvO);
    AppMethodBeat.o(37139);
  }
  
  public final boolean k(Message paramMessage)
  {
    AppMethodBeat.i(37140);
    ab.i("LogStateTransitionState", hashCode() + "[ToOpenState] recv msg.what " + paramMessage.what);
    switch (paramMessage.what)
    {
    default: 
      AppMethodBeat.o(37140);
      return false;
    case 0: 
      if (this.rvU.rvI.crk())
      {
        AppMethodBeat.o(37140);
        return true;
      }
      m.a.a(this.rvU, this.rvU.rvI.context.getString(2131303753));
      this.rvU.b(this.rvU.rvP);
      AppMethodBeat.o(37140);
      return true;
    }
    this.rvU.b(this.rvU.rvM);
    AppMethodBeat.o(37140);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m.a.i
 * JD-Core Version:    0.7.0.1
 */