package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.landingpage.helper.b.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Map;

final class j$a
  implements a.a
{
  private String Kqn;
  private Reference<j> Kqo;
  
  j$a(String paramString, j paramj)
  {
    AppMethodBeat.i(193959);
    this.Kqn = paramString;
    this.Kqo = new WeakReference(paramj);
    AppMethodBeat.o(193959);
  }
  
  public final void aB(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(193961);
    try
    {
      Log.i("AdLandingNewH5Comp", "onGeoCallback is called!");
      String str = this.Kqn;
      j localj = (j)this.Kqo.get();
      if ((str != null) && (localj != null)) {
        localj.g(str, "GEO", paramMap);
      }
      AppMethodBeat.o(193961);
      return;
    }
    catch (Throwable paramMap)
    {
      Log.e("AdLandingNewH5Comp", "there is a exception in onGeoCallback");
      AppMethodBeat.o(193961);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.j.a
 * JD-Core Version:    0.7.0.1
 */