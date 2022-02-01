package com.tencent.mm.plugin.setting.ui.fixtools;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ce.j;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.b.k;
import com.tencent.mm.plugin.setting.model.b;
import com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMMHeaderPreference;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import org.xwalk.core.Log;

@com.tencent.mm.ui.base.a(3)
public class FixToolsUI
  extends MMPreference
{
  private f screen;
  
  public int getResourceId()
  {
    return b.k.fix_tools;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool2 = true;
    AppMethodBeat.i(73813);
    super.onCreate(paramBundle);
    this.screen = getPreferenceScreen();
    setMMTitle(b.i.fix_tools);
    SettingsAboutMMHeaderPreference localSettingsAboutMMHeaderPreference = (SettingsAboutMMHeaderPreference)this.screen.bAi("fix_tools_micromsg_header");
    String str = ChannelUtil.formatVersion(getContext(), d.Yxh);
    if (!d.Yxk)
    {
      paramBundle = str;
      if (!BuildInfo.IS_FLAVOR_BLUE) {}
    }
    else
    {
      paramBundle = str + " " + j.mx(this);
    }
    localSettingsAboutMMHeaderPreference.Pqy = paramBundle;
    int i = getIntent().getIntExtra("entry_fix_tools", 2);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(873L, i, 1L, false);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(873L, 0L, 1L, false);
    paramBundle = this.screen;
    boolean bool1;
    if (WeChatEnvironment.hasDebugger())
    {
      bool1 = true;
      if (bool1) {
        break label291;
      }
      bool1 = true;
      label163:
      paramBundle.eh("fix_tools_aggressive_clean", bool1);
      paramBundle = (CheckBoxPreference)this.screen.bAi("fix_tools_aggressive_clean");
      i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zwT, 0);
      if (i == -1) {
        break label335;
      }
      if (i != 2) {
        break label297;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      paramBundle.setChecked(bool1);
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
      return;
      if (getSharedPreferences("CleanUI", 0).getInt("aggressive_clean", 0) != 0)
      {
        bool1 = true;
        break;
      }
      bool1 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zwU, false);
      break;
      label291:
      bool1 = false;
      break label163;
      label297:
      int j = getSharedPreferences("CleanUI", 0).getInt("aggressive_clean", 0);
      bool1 = bool2;
      if (j != 1) {
        if (j != -1)
        {
          bool1 = bool2;
          if (i != 0) {}
        }
        else
        {
          label335:
          bool1 = false;
        }
      }
    }
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(73814);
    if (paramPreference.mKey.equals("fix_tools_uplog"))
    {
      if (b.gUU().oTC) {
        MMWizardActivity.aQ(this, new Intent(getContext(), FixToolsUpLogUploadingUI.class));
      }
      for (;;)
      {
        AppMethodBeat.o(73814);
        return true;
        paramf = new Intent(getContext(), FixToolsUplogUI.class);
        paramf.putExtra("entry_fix_tools_uplog", 9);
        MMWizardActivity.aQ(this, paramf);
      }
    }
    if (paramPreference.mKey.equals("fix_tools_db_recover"))
    {
      paramPreference = new Intent().setClassName(getContext(), "com.tencent.mm.plugin.dbbackup.DBRecoveryUI");
      paramPreference.putExtra("scene", 2);
      paramf = getContext();
      paramPreference = new com.tencent.mm.hellhoundlib.b.a().cG(paramPreference);
      com.tencent.mm.hellhoundlib.a.a.b(paramf, paramPreference.aYi(), "com/tencent/mm/plugin/setting/ui/fixtools/FixToolsUI", "goToRecovery", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramf.startActivity((Intent)paramPreference.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramf, "com/tencent/mm/plugin/setting/ui/fixtools/FixToolsUI", "goToRecovery", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(73814);
      return true;
    }
    if (paramPreference.mKey.endsWith("fix_tools_matrix"))
    {
      if (!com.tencent.matrix.c.isInstalled()) {
        Toast.makeText(this, "Matrix is never installed", 0).show();
      }
      for (;;)
      {
        AppMethodBeat.o(73814);
        return true;
        paramf = new Intent();
        paramf.setClassName(MMApplicationContext.getContext(), "com.tencent.mm.ui.matrix.MatrixSettingUI");
        paramf.addFlags(67108864);
        paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/setting/ui/fixtools/FixToolsUI", "goToMatrixUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/fixtools/FixToolsUI", "goToMatrixUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    if (paramPreference.mKey.endsWith("fix_tools_search"))
    {
      paramf = new Intent(MMApplicationContext.getContext(), FixSearchUI.class);
      paramf.addFlags(67108864);
      paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/setting/ui/fixtools/FixToolsUI", "goToSearchUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/fixtools/FixToolsUI", "goToSearchUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(73814);
      return true;
    }
    if (paramPreference.mKey.equals("fix_force_update"))
    {
      ((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.updater.a.a.class)).manualCheckUpdate(1, getContext());
      AppMethodBeat.o(73814);
      return true;
    }
    if (paramPreference.mKey.equals("fix_tools_aggressive_clean"))
    {
      paramf = getSharedPreferences("CleanUI", 0).edit();
      if (((CheckBoxPreference)paramPreference).isChecked()) {}
      for (int i = 1;; i = -1)
      {
        paramf.putInt("aggressive_clean", i).apply();
        Log.e("MicroMsg.FixToolsUI", "aggressive_clean: " + ((CheckBoxPreference)paramPreference).isChecked());
        AppMethodBeat.o(73814);
        return true;
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUI
 * JD-Core Version:    0.7.0.1
 */