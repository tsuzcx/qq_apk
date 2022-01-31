package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.graphics.BitmapFactory;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class u$1
  implements f.a
{
  u$1(u paramu) {}
  
  public final void abi(String paramString)
  {
    AppMethodBeat.i(37246);
    try
    {
      paramString = BitmapFactory.decodeFile(paramString);
      this.rxu.setImage(paramString);
      AppMethodBeat.o(37246);
      return;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "%s" + bo.l(paramString));
      AppMethodBeat.o(37246);
    }
  }
  
  public final void coe()
  {
    AppMethodBeat.i(37245);
    this.rxu.progressBar.setVisibility(8);
    AppMethodBeat.o(37245);
  }
  
  public final void cqU()
  {
    AppMethodBeat.i(37244);
    this.rxu.startLoading();
    AppMethodBeat.o(37244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.u.1
 * JD-Core Version:    0.7.0.1
 */