package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;

final class d$1
  implements f.a
{
  d$1(d paramd, String paramString) {}
  
  public final void ayY(String paramString)
  {
    AppMethodBeat.i(96420);
    ae.i("AdLandingFloatBarCompWrapper", "refreshView icon onDownloaded, path=".concat(String.valueOf(paramString)));
    try
    {
      paramString = h.decodeFile(paramString, null);
      this.zTO.zTG.setImageBitmap(paramString);
      this.zTO.zTK.setVisibility(0);
      AppMethodBeat.o(96420);
      return;
    }
    catch (Throwable paramString)
    {
      ae.e("AdLandingFloatBarCompWrapper", "refreshView icon download exp=" + paramString.toString());
      AppMethodBeat.o(96420);
    }
  }
  
  public final void dVu() {}
  
  public final void dVv()
  {
    AppMethodBeat.i(96419);
    ae.e("AdLandingFloatBarCompWrapper", "refreshView icon onDownloadError, url=" + this.pKo);
    AppMethodBeat.o(96419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.d.1
 * JD-Core Version:    0.7.0.1
 */