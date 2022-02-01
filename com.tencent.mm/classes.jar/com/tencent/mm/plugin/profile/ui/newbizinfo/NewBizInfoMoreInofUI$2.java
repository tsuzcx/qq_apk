package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.Preference.c;

final class NewBizInfoMoreInofUI$2
  implements Preference.c
{
  NewBizInfoMoreInofUI$2(NewBizInfoMoreInofUI paramNewBizInfoMoreInofUI, KeyValuePreference paramKeyValuePreference) {}
  
  public final boolean eFh()
  {
    AppMethodBeat.i(27546);
    ClipboardHelper.setText(this.BjT.getSummary());
    h.cD(this.BjS.getContext(), this.BjS.getContext().getString(2131755773));
    AppMethodBeat.o(27546);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMoreInofUI.2
 * JD-Core Version:    0.7.0.1
 */