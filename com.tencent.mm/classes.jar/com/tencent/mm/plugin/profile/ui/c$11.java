package com.tencent.mm.plugin.profile.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.preference.f;

final class c$11
  implements Runnable
{
  c$11(c paramc, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(27081);
    if (this.wRE.screen == null)
    {
      ad.w("MicroMsg.ContactWidgetBizInfo", "LazyGetAvatar screen is null");
      AppMethodBeat.o(27081);
      return;
    }
    IconWidgetPreference localIconWidgetPreference = (IconWidgetPreference)this.wRE.screen.aVD("contact_info_kf_worker");
    if ((localIconWidgetPreference != null) && (this.wRE.screen != null))
    {
      Bitmap localBitmap = com.tencent.mm.ak.c.a(this.wRG, false, -1, null);
      if (localBitmap != null)
      {
        ad.d("MicroMsg.ContactWidgetBizInfo", "LazyGetAvatar success %s, update screen", new Object[] { this.wRG });
        localIconWidgetPreference.Z(localBitmap);
        this.wRE.screen.notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(27081);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.c.11
 * JD-Core Version:    0.7.0.1
 */