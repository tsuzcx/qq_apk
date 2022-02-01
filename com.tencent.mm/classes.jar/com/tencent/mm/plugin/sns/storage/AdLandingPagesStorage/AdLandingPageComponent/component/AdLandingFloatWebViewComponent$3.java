package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.yc;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

class AdLandingFloatWebViewComponent$3
  extends IListener<yc>
{
  AdLandingFloatWebViewComponent$3(e parame, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(307052);
    this.__eventId = yc.class.getName().hashCode();
    AppMethodBeat.o(307052);
  }
  
  private boolean a(yc paramyc)
  {
    AppMethodBeat.i(307055);
    try
    {
      e.a(this.QNM, paramyc);
      AppMethodBeat.o(307055);
      return true;
    }
    finally
    {
      for (;;)
      {
        Log.w("AdLandingFloatWebView", "resizing layout has wrong!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.AdLandingFloatWebViewComponent.3
 * JD-Core Version:    0.7.0.1
 */