package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.d;
import com.tencent.mm.plugin.profile.ui.IconWidgetPreference;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.f;

final class NewBizInfoMoreInofUI$3
  implements Runnable
{
  NewBizInfoMoreInofUI$3(NewBizInfoMoreInofUI paramNewBizInfoMoreInofUI, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(27547);
    if (NewBizInfoMoreInofUI.a(this.Hel) == null)
    {
      Log.w("MicroMsg.NewBizInfoMoreInofUI", "LazyGetAvatar screen is null");
      AppMethodBeat.o(27547);
      return;
    }
    IconWidgetPreference localIconWidgetPreference = (IconWidgetPreference)NewBizInfoMoreInofUI.a(this.Hel).byG("contact_info_kf_worker");
    if ((localIconWidgetPreference != null) && (NewBizInfoMoreInofUI.a(this.Hel) != null))
    {
      Bitmap localBitmap = d.a(this.GZj, false, -1, null);
      if (localBitmap != null)
      {
        Log.d("MicroMsg.NewBizInfoMoreInofUI", "LazyGetAvatar success %s, update screen", new Object[] { this.GZj });
        localIconWidgetPreference.ai(localBitmap);
        NewBizInfoMoreInofUI.a(this.Hel).notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(27547);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMoreInofUI.3
 * JD-Core Version:    0.7.0.1
 */