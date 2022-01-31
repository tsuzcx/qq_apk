package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class e$1
  implements f.a
{
  e$1(e parame) {}
  
  public final void abi(String paramString)
  {
    AppMethodBeat.i(37051);
    e locale;
    try
    {
      this.ruY.stopLoading();
      paramString = BitmapFactory.decodeFile(paramString);
      locale = this.ruY;
      if (paramString == null)
      {
        ab.e("AdLandingImageComp", "when set image the bmp is null!");
        AppMethodBeat.o(37051);
        return;
      }
      if (locale.cuM == null)
      {
        ab.e("AdLandingImageComp", "when set image the imageView is null!");
        AppMethodBeat.o(37051);
        return;
      }
    }
    catch (Exception paramString)
    {
      ab.e("AdLandingImageComp", "%s" + bo.l(paramString));
      AppMethodBeat.o(37051);
      return;
    }
    if (paramString.getWidth() == 0)
    {
      ab.e("AdLandingImageComp", "when set image the bmp.getWidth is 0!");
      AppMethodBeat.o(37051);
      return;
    }
    locale.cuM.setImageBitmap(paramString);
    locale.progressBar.setVisibility(8);
    AppMethodBeat.o(37051);
  }
  
  public final void coe()
  {
    AppMethodBeat.i(37050);
    this.ruY.stopLoading();
    AppMethodBeat.o(37050);
  }
  
  public final void cqU()
  {
    AppMethodBeat.i(37049);
    this.ruY.startLoading();
    AppMethodBeat.o(37049);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.e.1
 * JD-Core Version:    0.7.0.1
 */