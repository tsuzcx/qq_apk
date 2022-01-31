package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.ClipboardManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.Preference.c;

final class NewBizInfoMoreInofUI$2
  implements Preference.c
{
  NewBizInfoMoreInofUI$2(NewBizInfoMoreInofUI paramNewBizInfoMoreInofUI, KeyValuePreference paramKeyValuePreference) {}
  
  public final boolean ccS()
  {
    AppMethodBeat.i(23897);
    ClipboardManager localClipboardManager = (ClipboardManager)ah.getContext().getSystemService("clipboard");
    try
    {
      localClipboardManager.setText(this.pDX.getSummary());
      h.bO(this.pDW.getContext(), this.pDW.getContext().getString(2131296896));
      AppMethodBeat.o(23897);
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.NewBizInfoMoreInofUI", "clip.setText error ");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMoreInofUI.2
 * JD-Core Version:    0.7.0.1
 */