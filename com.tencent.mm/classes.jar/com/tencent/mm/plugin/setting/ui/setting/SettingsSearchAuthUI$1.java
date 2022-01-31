package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.ui.widget.a.b;
import com.tencent.mm.sdk.platformtools.ab;

final class SettingsSearchAuthUI$1
  implements a.b
{
  SettingsSearchAuthUI$1(SettingsSearchAuthUI paramSettingsSearchAuthUI) {}
  
  public final void onClickBackBtn(View paramView)
  {
    AppMethodBeat.i(127438);
    ab.i("MicroMsg.SettingsSearchAuthUI", "click search back");
    this.qJW.finish();
    AppMethodBeat.o(127438);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSearchAuthUI.1
 * JD-Core Version:    0.7.0.1
 */