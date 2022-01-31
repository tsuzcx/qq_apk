package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.graphics.BitmapFactory;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class w$1
  implements f.a
{
  w$1(w paramw) {}
  
  public final void abi(String paramString)
  {
    AppMethodBeat.i(37265);
    try
    {
      paramString = BitmapFactory.decodeFile(paramString);
      this.rxy.W(paramString);
      AppMethodBeat.o(37265);
      return;
    }
    catch (Exception paramString)
    {
      ab.e("AdLandingPagePureImageComponet", "%s" + bo.l(paramString));
      AppMethodBeat.o(37265);
    }
  }
  
  public final void coe()
  {
    AppMethodBeat.i(37264);
    this.rxy.progressBar.setVisibility(8);
    AppMethodBeat.o(37264);
  }
  
  public final void cqU()
  {
    AppMethodBeat.i(37263);
    this.rxy.startLoading();
    AppMethodBeat.o(37263);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.w.1
 * JD-Core Version:    0.7.0.1
 */