package com.tencent.mm.plugin.profile.ui;

import android.graphics.Bitmap;
import com.tencent.mm.ag.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.preference.f;

final class c$11
  implements Runnable
{
  c$11(c paramc, String paramString) {}
  
  public final void run()
  {
    if (this.mWY.dnn == null) {
      y.w("MicroMsg.ContactWidgetBizInfo", "LazyGetAvatar screen is null");
    }
    IconWidgetPreference localIconWidgetPreference;
    Bitmap localBitmap;
    do
    {
      do
      {
        return;
        localIconWidgetPreference = (IconWidgetPreference)this.mWY.dnn.add("contact_info_kf_worker");
      } while ((localIconWidgetPreference == null) || (this.mWY.dnn == null));
      localBitmap = b.a(this.mXa, false, -1);
    } while (localBitmap == null);
    y.d("MicroMsg.ContactWidgetBizInfo", "LazyGetAvatar success %s, update screen", new Object[] { this.mXa });
    localIconWidgetPreference.C(localBitmap);
    this.mWY.dnn.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.c.11
 * JD-Core Version:    0.7.0.1
 */