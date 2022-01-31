package com.tencent.mm.plugin.sns.ui.c.a;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.ab;

final class d$1$1
  implements f.a
{
  d$1$1(d.1 param1) {}
  
  public final void abi(String paramString)
  {
    AppMethodBeat.i(145716);
    ab.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "onDownloaded thumb, path=".concat(String.valueOf(paramString)));
    if (this.sgu.sgt.rxK.getVisibility() == 0) {
      try
      {
        paramString = MMBitmapFactory.decodeFile(paramString);
        this.sgu.sgt.rxK.setImageBitmap(paramString);
        AppMethodBeat.o(145716);
        return;
      }
      catch (Throwable paramString)
      {
        ab.e("MicroMsg.SphereImageView.SphereCardAdDetailItem", "onDownloaded thumb exp:" + paramString.toString());
      }
    }
    AppMethodBeat.o(145716);
  }
  
  public final void coe()
  {
    AppMethodBeat.i(145715);
    ab.e("MicroMsg.SphereImageView.SphereCardAdDetailItem", "onDownloadError thumb");
    AppMethodBeat.o(145715);
  }
  
  public final void cqU() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.d.1.1
 * JD-Core Version:    0.7.0.1
 */