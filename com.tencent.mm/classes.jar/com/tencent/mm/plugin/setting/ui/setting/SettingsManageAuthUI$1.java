package com.tencent.mm.plugin.setting.ui.setting;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class SettingsManageAuthUI$1
  implements AbsListView.OnScrollListener
{
  SettingsManageAuthUI$1(SettingsManageAuthUI paramSettingsManageAuthUI) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(127246);
    if (paramInt1 + paramInt2 == paramInt3)
    {
      ab.i("MicroMsg.SettingsManageAuthUI", "scroll to the end");
      if (SettingsManageAuthUI.a(this.qIF) != null)
      {
        SettingsManageAuthUI.bi(SettingsManageAuthUI.a(this.qIF));
        SettingsManageAuthUI.b(this.qIF);
      }
    }
    AppMethodBeat.o(127246);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsManageAuthUI.1
 * JD-Core Version:    0.7.0.1
 */