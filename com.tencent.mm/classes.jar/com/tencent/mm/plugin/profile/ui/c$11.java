package com.tencent.mm.plugin.profile.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.f;

final class c$11
  implements Runnable
{
  c$11(c paramc, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(27081);
    if (c.l(this.GZh) == null)
    {
      Log.w("MicroMsg.ContactWidgetBizInfo", "LazyGetAvatar screen is null");
      AppMethodBeat.o(27081);
      return;
    }
    IconWidgetPreference localIconWidgetPreference = (IconWidgetPreference)c.l(this.GZh).byG("contact_info_kf_worker");
    if ((localIconWidgetPreference != null) && (c.l(this.GZh) != null))
    {
      Bitmap localBitmap = d.a(this.GZj, false, -1, null);
      if (localBitmap != null)
      {
        Log.d("MicroMsg.ContactWidgetBizInfo", "LazyGetAvatar success %s, update screen", new Object[] { this.GZj });
        localIconWidgetPreference.ai(localBitmap);
        c.l(this.GZh).notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(27081);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.c.11
 * JD-Core Version:    0.7.0.1
 */