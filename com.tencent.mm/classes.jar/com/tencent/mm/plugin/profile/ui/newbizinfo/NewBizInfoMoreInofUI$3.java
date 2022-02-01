package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.plugin.profile.ui.IconWidgetPreference;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.preference.f;

final class NewBizInfoMoreInofUI$3
  implements Runnable
{
  NewBizInfoMoreInofUI$3(NewBizInfoMoreInofUI paramNewBizInfoMoreInofUI, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(27547);
    if (NewBizInfoMoreInofUI.a(this.vOR) == null)
    {
      ac.w("MicroMsg.NewBizInfoMoreInofUI", "LazyGetAvatar screen is null");
      AppMethodBeat.o(27547);
      return;
    }
    IconWidgetPreference localIconWidgetPreference = (IconWidgetPreference)NewBizInfoMoreInofUI.a(this.vOR).aPN("contact_info_kf_worker");
    if ((localIconWidgetPreference != null) && (NewBizInfoMoreInofUI.a(this.vOR) != null))
    {
      Bitmap localBitmap = c.a(this.vKx, false, -1, null);
      if (localBitmap != null)
      {
        ac.d("MicroMsg.NewBizInfoMoreInofUI", "LazyGetAvatar success %s, update screen", new Object[] { this.vKx });
        localIconWidgetPreference.Z(localBitmap);
        NewBizInfoMoreInofUI.a(this.vOR).notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(27547);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMoreInofUI.3
 * JD-Core Version:    0.7.0.1
 */