package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;

final class d$1
  implements f.a
{
  d$1(d paramd, String paramString) {}
  
  public final void asD(String paramString)
  {
    AppMethodBeat.i(96420);
    ac.i("AdLandingFloatBarCompWrapper", "refreshView icon onDownloaded, path=".concat(String.valueOf(paramString)));
    try
    {
      paramString = f.decodeFile(paramString, null);
      this.ylX.ylP.setImageBitmap(paramString);
      this.ylX.ylT.setVisibility(0);
      AppMethodBeat.o(96420);
      return;
    }
    catch (Throwable paramString)
    {
      ac.e("AdLandingFloatBarCompWrapper", "refreshView icon download exp=" + paramString.toString());
      AppMethodBeat.o(96420);
    }
  }
  
  public final void dFC() {}
  
  public final void dFD()
  {
    AppMethodBeat.i(96419);
    ac.e("AdLandingFloatBarCompWrapper", "refreshView icon onDownloadError, url=" + this.paa);
    AppMethodBeat.o(96419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.d.1
 * JD-Core Version:    0.7.0.1
 */