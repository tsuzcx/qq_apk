package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.d.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class m$a$f
  extends b
{
  m$a$f(m.a parama) {}
  
  public final void enter()
  {
    AppMethodBeat.i(37127);
    super.enter();
    al.d(new m.a.f.1(this));
    AppMethodBeat.o(37127);
  }
  
  public final boolean k(Message paramMessage)
  {
    AppMethodBeat.i(37128);
    ab.i("LogStateTransitionState", hashCode() + "[ReDownloadState] recv msg.what " + paramMessage.what);
    switch (paramMessage.what)
    {
    default: 
      AppMethodBeat.o(37128);
      return false;
    }
    this.rvU.b(this.rvU.rvR);
    AppMethodBeat.o(37128);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m.a.f
 * JD-Core Version:    0.7.0.1
 */