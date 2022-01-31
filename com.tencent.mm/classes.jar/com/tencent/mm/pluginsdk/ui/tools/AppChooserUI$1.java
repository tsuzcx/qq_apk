package com.tencent.mm.pluginsdk.ui.tools;

import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.widget.a.c;

final class AppChooserUI$1
  implements AdapterView.OnItemClickListener
{
  AppChooserUI$1(AppChooserUI paramAppChooserUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (AppChooserUI.a(this.slj) != null)
    {
      AppChooserUI.a(this.slj, AppChooserUI.a(this.slj).Ew(paramInt));
      AppChooserUI.a(this.slj).notifyDataSetChanged();
      if ((AppChooserUI.b(this.slj) != null) && (AppChooserUI.b(this.slj).fvH.isShowing()))
      {
        if ((AppChooserUI.c(this.slj) == null) || (!AppChooserUI.c(this.slj).slq) || ((AppChooserUI.c(this.slj).lnq) && ((AppChooserUI.c(this.slj).pKW) || (AppChooserUI.d(this.slj) >= AppChooserUI.e(this.slj))))) {
          break label252;
        }
        AppChooserUI.b(this.slj).mg(false);
      }
    }
    for (;;)
    {
      if (((AppChooserUI.f(this.slj) == 6) || (AppChooserUI.g(this.slj) == 2)) && (AppChooserUI.c(this.slj) != null) && (AppChooserUI.c(this.slj).sln != null))
      {
        AppChooserUI.a(this.slj, AppChooserUI.c(this.slj).sln.activityInfo.packageName, false);
        h.nFQ.f(12809, new Object[] { Integer.valueOf(4), AppChooserUI.c(this.slj).sln.activityInfo.packageName });
      }
      return;
      label252:
      AppChooserUI.b(this.slj).mg(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.AppChooserUI.1
 * JD-Core Version:    0.7.0.1
 */