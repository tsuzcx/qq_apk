package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
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
    if (NewBizInfoMoreInofUI.a(this.BjS) == null)
    {
      Log.w("MicroMsg.NewBizInfoMoreInofUI", "LazyGetAvatar screen is null");
      AppMethodBeat.o(27547);
      return;
    }
    IconWidgetPreference localIconWidgetPreference = (IconWidgetPreference)NewBizInfoMoreInofUI.a(this.BjS).bmg("contact_info_kf_worker");
    if ((localIconWidgetPreference != null) && (NewBizInfoMoreInofUI.a(this.BjS) != null))
    {
      Bitmap localBitmap = c.a(this.Bfl, false, -1, null);
      if (localBitmap != null)
      {
        Log.d("MicroMsg.NewBizInfoMoreInofUI", "LazyGetAvatar success %s, update screen", new Object[] { this.Bfl });
        localIconWidgetPreference.al(localBitmap);
        NewBizInfoMoreInofUI.a(this.BjS).notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(27547);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMoreInofUI.3
 * JD-Core Version:    0.7.0.1
 */