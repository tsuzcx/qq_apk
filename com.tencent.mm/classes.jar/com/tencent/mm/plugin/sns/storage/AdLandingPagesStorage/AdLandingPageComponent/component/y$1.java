package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.d;
import com.tencent.mm.sdk.platformtools.ab;

final class y$1
  implements a.d
{
  y$1(y paramy) {}
  
  public final void a(boolean paramBoolean, String paramString1, Bitmap paramBitmap, String paramString2)
  {
    AppMethodBeat.i(145304);
    ab.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "ImageLoader onFinish, isSucc=" + paramBoolean + ", errInfo=" + paramString1);
    this.rxQ.rxI.f(paramBitmap, paramString2);
    if (!paramBoolean) {
      this.rxQ.stopLoading();
    }
    AppMethodBeat.o(145304);
  }
  
  public final void onStart(String paramString)
  {
    AppMethodBeat.i(145303);
    ab.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "ImageLoader onStart");
    paramString = a.gv(paramString, "scene_ad_landing");
    if (paramString != null)
    {
      this.rxQ.rxK.setImageBitmap(paramString);
      this.rxQ.rxK.setVisibility(0);
      AppMethodBeat.o(145303);
      return;
    }
    this.rxQ.startLoading();
    AppMethodBeat.o(145303);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.y.1
 * JD-Core Version:    0.7.0.1
 */