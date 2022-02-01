package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.ClipboardManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.Preference.c;

final class NewBizInfoMoreInofUI$2
  implements Preference.c
{
  NewBizInfoMoreInofUI$2(NewBizInfoMoreInofUI paramNewBizInfoMoreInofUI, KeyValuePreference paramKeyValuePreference) {}
  
  public final boolean dBu()
  {
    AppMethodBeat.i(27546);
    ClipboardManager localClipboardManager = (ClipboardManager)aj.getContext().getSystemService("clipboard");
    try
    {
      localClipboardManager.setText(this.wWb.getSummary());
      h.cl(this.wWa.getContext(), this.wWa.getContext().getString(2131755702));
      AppMethodBeat.o(27546);
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.NewBizInfoMoreInofUI", "clip.setText error ");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMoreInofUI.2
 * JD-Core Version:    0.7.0.1
 */