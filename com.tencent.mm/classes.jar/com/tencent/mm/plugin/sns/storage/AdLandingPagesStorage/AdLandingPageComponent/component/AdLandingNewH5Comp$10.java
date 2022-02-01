package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.xz;
import com.tencent.mm.autogen.a.xz.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.ui.widget.MMWebView;

class AdLandingNewH5Comp$10
  extends IListener<xz>
{
  AdLandingNewH5Comp$10(j paramj, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(306903);
    this.__eventId = xz.class.getName().hashCode();
    AppMethodBeat.o(306903);
  }
  
  private boolean a(xz paramxz)
  {
    AppMethodBeat.i(306904);
    try
    {
      j localj = this.QOs;
      int i = paramxz.ibt.ibu;
      if (localj.QOo != null)
      {
        localj.QOo.dead();
        localj.QOo = null;
      }
      if (5 == i)
      {
        paramxz = localj.ooz;
        if (paramxz != null) {
          paramxz.setCleanOnDetached(true);
        }
      }
    }
    finally
    {
      label56:
      break label56;
    }
    AppMethodBeat.o(306904);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.AdLandingNewH5Comp.10
 * JD-Core Version:    0.7.0.1
 */