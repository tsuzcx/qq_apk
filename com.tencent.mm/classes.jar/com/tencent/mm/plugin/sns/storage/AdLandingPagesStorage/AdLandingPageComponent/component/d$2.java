package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.e.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.ac;

final class d$2
  implements f.a
{
  d$2(d paramd) {}
  
  public final void asD(String paramString)
  {
    AppMethodBeat.i(96422);
    ac.i("AdLandingFloatBarCompWrapper", "refreshView bkg onDownloaded, path=".concat(String.valueOf(paramString)));
    try
    {
      paramString = a.a(this.ylX.mContext.getResources(), paramString);
      if (paramString != null) {
        this.ylX.mContentView.setBackgroundDrawable(paramString);
      }
      AppMethodBeat.o(96422);
      return;
    }
    catch (Throwable paramString)
    {
      ac.e("AdLandingFloatBarCompWrapper", "refreshView bkg download exp=" + paramString.toString());
      AppMethodBeat.o(96422);
    }
  }
  
  public final void dFC() {}
  
  public final void dFD()
  {
    AppMethodBeat.i(96421);
    ac.e("AdLandingFloatBarCompWrapper", "refreshView bkg onDownloadError");
    AppMethodBeat.o(96421);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.d.2
 * JD-Core Version:    0.7.0.1
 */