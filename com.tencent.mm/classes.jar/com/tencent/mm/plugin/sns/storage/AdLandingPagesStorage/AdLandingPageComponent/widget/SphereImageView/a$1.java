package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class a$1
  implements f.a
{
  a$1(a parama, String paramString1, int paramInt1, int paramInt2, String paramString2) {}
  
  public final void abi(String paramString)
  {
    AppMethodBeat.i(145388);
    ab.i("SphereImageView.SphereImageLoader", "loadImage onDownloaded, path=".concat(String.valueOf(paramString)));
    new a.a(this.rAS, this.hZk, this.val$w, this.val$h, this.rAR).execute(new String[] { paramString });
    AppMethodBeat.o(145388);
  }
  
  public final void coe()
  {
    AppMethodBeat.i(145387);
    ab.e("SphereImageView.SphereImageLoader", "onDownloadError");
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(145385);
        if (a.1.this.rAS.rAQ != null) {
          a.1.this.rAS.rAQ.a(false, "onDownloadError", null, a.1.this.hZk);
        }
        AppMethodBeat.o(145385);
      }
    });
    AppMethodBeat.o(145387);
  }
  
  public final void cqU()
  {
    AppMethodBeat.i(145386);
    ab.i("SphereImageView.SphereImageLoader", "onStartDownload");
    AppMethodBeat.o(145386);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.1
 * JD-Core Version:    0.7.0.1
 */