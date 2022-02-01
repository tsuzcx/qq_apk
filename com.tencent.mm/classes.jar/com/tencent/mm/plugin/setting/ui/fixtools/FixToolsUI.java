package com.tencent.mm.plugin.setting.ui.fixtools;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.matrix.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMMHeaderPreference;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

@com.tencent.mm.ui.base.a(3)
public class FixToolsUI
  extends MMPreference
{
  private f screen;
  
  public int getResourceId()
  {
    return 2131951682;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(73813);
    super.onCreate(paramBundle);
    this.screen = getPreferenceScreen();
    setMMTitle(2131759422);
    SettingsAboutMMHeaderPreference localSettingsAboutMMHeaderPreference = (SettingsAboutMMHeaderPreference)this.screen.aKk("fix_tools_micromsg_header");
    String str = i.au(getContext(), d.CpK);
    paramBundle = str;
    if (d.CpN) {
      paramBundle = str + " " + getString(2131755263);
    }
    localSettingsAboutMMHeaderPreference.wfu = paramBundle;
    int i = getIntent().getIntExtra("entry_fix_tools", 2);
    h.vKh.idkeyStat(873L, i, 1L, false);
    h.vKh.idkeyStat(873L, 0L, 1L, false);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(73812);
        FixToolsUI.this.finish();
        AppMethodBeat.o(73812);
        return true;
      }
    });
    AppMethodBeat.o(73813);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(73814);
    if (paramPreference.mKey.equals("fix_tools_uplog"))
    {
      if (com.tencent.mm.plugin.setting.model.a.dny().hsM) {
        MMWizardActivity.V(this, new Intent(getContext(), FixToolsUpLogUploadingUI.class));
      }
      for (;;)
      {
        AppMethodBeat.o(73814);
        return true;
        paramf = new Intent(getContext(), FixToolsUplogUI.class);
        paramf.putExtra("entry_fix_tools_uplog", 9);
        MMWizardActivity.V(this, paramf);
      }
    }
    if (paramPreference.mKey.equals("fix_tools_db_recover"))
    {
      paramPreference = new Intent().setClassName(getContext(), "com.tencent.mm.plugin.dbbackup.DBRecoveryUI");
      paramPreference.putExtra("scene", 2);
      paramf = getContext();
      paramPreference = new com.tencent.mm.hellhoundlib.b.a().bd(paramPreference);
      com.tencent.mm.hellhoundlib.a.a.a(paramf, paramPreference.adn(), "com/tencent/mm/plugin/setting/ui/fixtools/FixToolsUI", "goToRecovery", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramf.startActivity((Intent)paramPreference.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramf, "com/tencent/mm/plugin/setting/ui/fixtools/FixToolsUI", "goToRecovery", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(73814);
      return true;
    }
    if (paramPreference.mKey.endsWith("fix_tools_matrix"))
    {
      if (!b.GE()) {
        Toast.makeText(this, "Matrix is never installed", 0).show();
      }
      for (;;)
      {
        AppMethodBeat.o(73814);
        return true;
        paramf = new Intent();
        paramf.setClassName(aj.getContext(), "com.tencent.mm.ui.matrix.MatrixSettingUI");
        paramf.addFlags(67108864);
        paramf = new com.tencent.mm.hellhoundlib.b.a().bd(paramf);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramf.adn(), "com/tencent/mm/plugin/setting/ui/fixtools/FixToolsUI", "goToMatrixUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/fixtools/FixToolsUI", "goToMatrixUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    if (paramPreference.mKey.endsWith("fix_tools_search"))
    {
      paramf = new Intent(aj.getContext(), FixSearchUI.class);
      paramf.addFlags(67108864);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bd(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.adn(), "com/tencent/mm/plugin/setting/ui/fixtools/FixToolsUI", "goToSearchUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/fixtools/FixToolsUI", "goToSearchUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(73814);
      return true;
    }
    AppMethodBeat.o(73814);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUI
 * JD-Core Version:    0.7.0.1
 */