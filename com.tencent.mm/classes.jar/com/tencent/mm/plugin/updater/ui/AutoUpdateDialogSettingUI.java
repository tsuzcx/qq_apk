package com.tencent.mm.plugin.updater.ui;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.secdata.ui.MMSecDataActivity;
import com.tencent.mm.plugin.updater.a.a;
import com.tencent.mm.plugin.updater.a.b;
import com.tencent.mm.plugin.updater.a.c;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/updater/ui/AutoUpdateDialogSettingUI;", "Lcom/tencent/mm/plugin/secdata/ui/MMSecDataActivity;", "()V", "getApkMd5", "", "file", "getCurrentApkMD5", "context", "Landroid/content/Context;", "getCurrentApkPath", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "saveDialogData", "clientVersionStr", "plugin-updater_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AutoUpdateDialogSettingUI
  extends MMSecDataActivity
{
  private static final void a(AutoUpdateDialogSettingUI paramAutoUpdateDialogSettingUI, final View paramView)
  {
    AppMethodBeat.i(265973);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramAutoUpdateDialogSettingUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/updater/ui/AutoUpdateDialogSettingUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramAutoUpdateDialogSettingUI, "this$0");
    paramView = ((EditText)paramAutoUpdateDialogSettingUI.findViewById(a.a.client_version_et)).getText().toString();
    localObject = (CharSequence)paramView;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        d.B((kotlin.g.a.a)new a(paramAutoUpdateDialogSettingUI, paramView));
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/updater/ui/AutoUpdateDialogSettingUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(265973);
      return;
    }
  }
  
  private static final boolean a(AutoUpdateDialogSettingUI paramAutoUpdateDialogSettingUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(265967);
    s.u(paramAutoUpdateDialogSettingUI, "this$0");
    paramAutoUpdateDialogSettingUI.finish();
    AppMethodBeat.o(265967);
    return false;
  }
  
  private static String iH(Context paramContext)
  {
    AppMethodBeat.i(265958);
    s.u(paramContext, "context");
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).applicationInfo.sourceDir;
      AppMethodBeat.o(265958);
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
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return a.b.auto_update_dialog_setting_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(266000);
    super.onCreate(paramBundle);
    setMMTitle(a.c.auto_update_dialog_title);
    setBackBtn(new AutoUpdateDialogSettingUI..ExternalSyntheticLambda0(this));
    findViewById(a.a.ok_btn).setOnClickListener(new AutoUpdateDialogSettingUI..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(266000);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(AutoUpdateDialogSettingUI paramAutoUpdateDialogSettingUI, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.updater.ui.AutoUpdateDialogSettingUI
 * JD-Core Version:    0.7.0.1
 */