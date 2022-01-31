package com.tencent.mm.pluginsdk.ui.tools;

import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.widget.b.c;

final class AppChooserUI$1
  implements AdapterView.OnItemClickListener
{
  AppChooserUI$1(AppChooserUI paramAppChooserUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(125854);
    if (AppChooserUI.a(this.wdL) != null)
    {
      AppChooserUI.a(this.wdL, AppChooserUI.a(this.wdL).Mu(paramInt));
      AppChooserUI.a(this.wdL).notifyDataSetChanged();
      if ((AppChooserUI.b(this.wdL) != null) && (AppChooserUI.b(this.wdL).gNn.isShowing()))
      {
        if ((AppChooserUI.c(this.wdL) == null) || (!AppChooserUI.c(this.wdL).wdS) || ((AppChooserUI.c(this.wdL).nKJ) && ((AppChooserUI.c(this.wdL).tqS) || (AppChooserUI.d(this.wdL) >= AppChooserUI.e(this.wdL))))) {
          break label262;
        }
        AppChooserUI.b(this.wdL).pv(false);
      }
    }
    for (;;)
    {
      if (((AppChooserUI.f(this.wdL) == 6) || (AppChooserUI.g(this.wdL) == 2)) && (AppChooserUI.c(this.wdL) != null) && (AppChooserUI.c(this.wdL).wdP != null))
      {
        AppChooserUI.a(this.wdL, AppChooserUI.c(this.wdL).wdP.activityInfo.packageName, false);
        h.qsU.e(12809, new Object[] { Integer.valueOf(4), AppChooserUI.c(this.wdL).wdP.activityInfo.packageName });
      }
      AppMethodBeat.o(125854);
      return;
      label262:
      AppChooserUI.b(this.wdL).pv(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.AppChooserUI.1
 * JD-Core Version:    0.7.0.1
 */