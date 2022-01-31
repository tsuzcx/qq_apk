package com.tencent.mm.plugin.sns.ui.item;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.d;
import com.tencent.mm.plugin.sns.storage.b.e;
import com.tencent.mm.sdk.platformtools.ab;

final class h$2
  implements a.d
{
  h$2(h paramh) {}
  
  public final void a(boolean paramBoolean, String paramString1, Bitmap paramBitmap, String paramString2)
  {
    AppMethodBeat.i(145728);
    ab.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "ImageLoader onFinish, isSucc=" + paramBoolean + ", errInfo=" + paramString1);
    if (this.siv.sin == null)
    {
      ab.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onFinish, mViewHolder==null");
      AppMethodBeat.o(145728);
      return;
    }
    if (this.siv.sgq != null) {}
    for (paramString1 = this.siv.sgq.rrf; (paramString2 != null) && (paramString2.equals(paramString1)); paramString1 = "")
    {
      this.siv.sin.siz.f(paramBitmap, paramString2);
      AppMethodBeat.o(145728);
      return;
    }
    ab.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onFinish, url != nowUrl");
    AppMethodBeat.o(145728);
  }
  
  public final void onStart(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.h.2
 * JD-Core Version:    0.7.0.1
 */