package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.graphics.Bitmap;
import com.tencent.mm.ag.b;
import com.tencent.mm.plugin.profile.ui.IconWidgetPreference;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.preference.f;

final class NewBizInfoMoreInofUI$3
  implements Runnable
{
  NewBizInfoMoreInofUI$3(NewBizInfoMoreInofUI paramNewBizInfoMoreInofUI, String paramString) {}
  
  public final void run()
  {
    if (NewBizInfoMoreInofUI.a(this.nab) == null) {
      y.w("MicroMsg.NewBizInfoMoreInofUI", "LazyGetAvatar screen is null");
    }
    IconWidgetPreference localIconWidgetPreference;
    Bitmap localBitmap;
    do
    {
      do
      {
        return;
        localIconWidgetPreference = (IconWidgetPreference)NewBizInfoMoreInofUI.a(this.nab).add("contact_info_kf_worker");
      } while ((localIconWidgetPreference == null) || (NewBizInfoMoreInofUI.a(this.nab) == null));
      localBitmap = b.a(this.mXa, false, -1);
    } while (localBitmap == null);
    y.d("MicroMsg.NewBizInfoMoreInofUI", "LazyGetAvatar success %s, update screen", new Object[] { this.mXa });
    localIconWidgetPreference.C(localBitmap);
    NewBizInfoMoreInofUI.a(this.nab).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMoreInofUI.3
 * JD-Core Version:    0.7.0.1
 */