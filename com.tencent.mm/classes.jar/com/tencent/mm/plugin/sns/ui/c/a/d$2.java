package com.tencent.mm.plugin.sns.ui.c.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.d;
import com.tencent.mm.sdk.platformtools.ab;

final class d$2
  implements a.d
{
  d$2(d paramd) {}
  
  public final void a(boolean paramBoolean, String paramString1, Bitmap paramBitmap, String paramString2)
  {
    AppMethodBeat.i(145719);
    ab.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "ImageLoader onFinish, isSucc=" + paramBoolean + ", errInfo=" + paramString1);
    this.sgt.rxI.f(paramBitmap, paramString2);
    AppMethodBeat.o(145719);
  }
  
  public final void onStart(String paramString)
  {
    AppMethodBeat.i(145718);
    ab.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "ImageLoader onStart");
    AppMethodBeat.o(145718);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.d.2
 * JD-Core Version:    0.7.0.1
 */