package com.tencent.mm.plugin.updater.ui;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.updater.a.a;
import com.tencent.mm.plugin.updater.a.b;
import com.tencent.mm.plugin.updater.a.c;
import com.tencent.mm.ui.report.MMSecDataActivity;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/updater/ui/AutoUpdateDialogSettingUI;", "Lcom/tencent/mm/ui/report/MMSecDataActivity;", "()V", "getApkMd5", "", "file", "getCurrentApkMD5", "context", "Landroid/content/Context;", "getCurrentApkPath", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "saveDialogData", "clientVersionStr", "plugin-updater_release"})
public final class AutoUpdateDialogSettingUI
  extends MMSecDataActivity
{
  private static String hm(Context paramContext)
  {
    AppMethodBeat.i(196027);
    p.k(paramContext, "context");
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).applicationInfo.sourceDir;
      AppMethodBeat.o(196027);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = null;
      }
    }
  }
  
  public final int getLayoutId()
  {
    return a.b.auto_update_dialog_setting_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(196025);
    super.onCreate(paramBundle);
    setMMTitle(a.c.auto_update_dialog_title);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    findViewById(a.a.ok_btn).setOnClickListener((View.OnClickListener)new b(this));
    AppMethodBeat.o(196025);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(AutoUpdateDialogSettingUI paramAutoUpdateDialogSettingUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(196019);
      this.Nkf.finish();
      AppMethodBeat.o(196019);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(AutoUpdateDialogSettingUI paramAutoUpdateDialogSettingUI) {}
    
    public final void onClick(final View paramView)
    {
      AppMethodBeat.i(196084);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/updater/ui/AutoUpdateDialogSettingUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      paramView = this.Nkf.findViewById(a.a.client_version_et);
      p.j(paramView, "findViewById<EditText>(R.id.client_version_et)");
      paramView = ((EditText)paramView).getText().toString();
      localObject = (CharSequence)paramView;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          d.h((kotlin.g.a.a)new q(paramView) {});
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/updater/ui/AutoUpdateDialogSettingUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(196084);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.updater.ui.AutoUpdateDialogSettingUI
 * JD-Core Version:    0.7.0.1
 */