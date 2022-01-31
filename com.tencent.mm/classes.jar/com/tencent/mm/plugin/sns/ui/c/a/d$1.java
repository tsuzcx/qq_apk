package com.tencent.mm.plugin.sns.ui.c.a;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

final class d$1
  implements a.d
{
  d$1(d paramd, String paramString1, String paramString2) {}
  
  public final void a(boolean paramBoolean, String paramString1, Bitmap paramBitmap, String paramString2)
  {
    AppMethodBeat.i(145717);
    if ((paramString2 == null) || (!paramString2.equals(this.hZk)))
    {
      AppMethodBeat.o(145717);
      return;
    }
    if (paramBitmap != null)
    {
      this.sgt.rxK.setImageBitmap(paramBitmap);
      AppMethodBeat.o(145717);
      return;
    }
    ab.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "show progressView");
    this.sgt.sgp.setVisibility(0);
    this.sgt.sgp.dOF();
    if (!TextUtils.isEmpty(this.fEW))
    {
      ab.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "have no shot and thumb cache, start download thumb image");
      h.a(this.fEW, 133, new d.1.1(this));
      AppMethodBeat.o(145717);
      return;
    }
    ab.e("MicroMsg.SphereImageView.SphereCardAdDetailItem", "thumbUrl is empty");
    AppMethodBeat.o(145717);
  }
  
  public final void onStart(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.d.1
 * JD-Core Version:    0.7.0.1
 */