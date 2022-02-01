package com.tencent.mm.plugin.setting.ui.fixtools;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMMHeaderPreference;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.websearch.api.at;
import com.tencent.mm.pluginsdk.i.c.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.vfs.s;

public class FixSearchUI
  extends MMPreference
{
  private com.tencent.mm.ui.widget.a.d CYs;
  private com.tencent.mm.ui.widget.a.d CYt;
  private com.tencent.mm.ui.widget.a.d CYu;
  private f screen;
  
  public int getResourceId()
  {
    return 2132017225;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(73809);
    super.onCreate(paramBundle);
    this.screen = getPreferenceScreen();
    setMMTitle(2131760721);
    SettingsAboutMMHeaderPreference localSettingsAboutMMHeaderPreference = (SettingsAboutMMHeaderPreference)this.screen.bmg("fix_tools_micromsg_header");
    String str = ChannelUtil.formatVersion(getContext(), com.tencent.mm.protocal.d.KyO);
    if (!com.tencent.mm.protocal.d.KyR)
    {
      paramBundle = str;
      if (!BuildInfo.IS_FLAVOR_BLUE) {}
    }
    else
    {
      paramBundle = str + " " + com.tencent.mm.cc.h.jr(this);
    }
    localSettingsAboutMMHeaderPreference.Dak = paramBundle;
    paramBundle = com.tencent.mm.util.c.QYz;
    if (com.tencent.mm.util.c.hdg()) {
      this.screen.jdMethod_do("fix_tools_fts_info", false);
    }
    for (;;)
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(73805);
          FixSearchUI.this.finish();
          AppMethodBeat.o(73805);
          return true;
        }
      });
      AppMethodBeat.o(73809);
      return;
      this.screen.jdMethod_do("fix_tools_fts_info", true);
    }
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(73810);
    if (paramPreference.mKey.endsWith("fix_tools_fts"))
    {
      if (this.CYs == null) {
        this.CYs = com.tencent.mm.ui.base.h.a(this, getString(2131760717), "", true, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(73806);
            Log.i("MicroMsg.FixSearchUI", "delete fts db, and kill process");
            com.tencent.mm.plugin.fts.a.e.Nk(24);
            paramAnonymousDialogInterface = new StringBuilder();
            g.aAi();
            paramAnonymousDialogInterface = g.aAh().cachePath + "FTS5IndexMicroMsg_encrypt.db";
            paramAnonymousInt = 0;
            while (paramAnonymousInt < 4)
            {
              String str = new String[] { "", "-journal", "-wal", "-shm" }[paramAnonymousInt];
              str = paramAnonymousDialogInterface + str;
              Log.i("MicroMsg.FixSearchUI", "deleteIndexDB %s %s", new Object[] { str, Boolean.valueOf(s.YS(str)) });
              s.deleteFile(str);
              paramAnonymousInt += 1;
            }
            FixSearchUI.this.finish();
            if (com.tencent.mm.pluginsdk.i.c.JYn != null) {
              com.tencent.mm.pluginsdk.i.c.JYn.bV(FixSearchUI.this.getContext());
            }
            AppMethodBeat.o(73806);
          }
        }, null);
      }
      this.CYs.show();
      AppMethodBeat.o(73810);
      return true;
    }
    if (paramPreference.mKey.endsWith("fix_tools_websearch"))
    {
      if (this.CYt == null) {
        this.CYt = com.tencent.mm.ui.base.h.a(this, getString(2131760731), "", true, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(73807);
            Log.i("MicroMsg.FixSearchUI", "delete web search template, and kill process");
            s.dy(ai.afr(0).fYs(), true);
            ar.afB(30);
            FixSearchUI.this.finish();
            if (com.tencent.mm.pluginsdk.i.c.JYn != null) {
              com.tencent.mm.pluginsdk.i.c.JYn.bV(FixSearchUI.this.getContext());
            }
            AppMethodBeat.o(73807);
          }
        }, null);
      }
      this.CYt.show();
      AppMethodBeat.o(73810);
      return true;
    }
    if (paramPreference.mKey.endsWith("fix_tools_topstory"))
    {
      if (this.CYu == null) {
        this.CYu = com.tencent.mm.ui.base.h.a(this, getString(2131760731), "", true, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(73808);
            Log.i("MicroMsg.FixSearchUI", "delete topstory template, and kill process");
            s.dy(ai.afr(1).fYs(), true);
            ar.afB(31);
            FixSearchUI.this.finish();
            if (com.tencent.mm.pluginsdk.i.c.JYn != null) {
              com.tencent.mm.pluginsdk.i.c.JYn.bV(FixSearchUI.this.getContext());
            }
            AppMethodBeat.o(73808);
          }
        }, null);
      }
      this.CYu.show();
      AppMethodBeat.o(73810);
      return true;
    }
    if (paramPreference.mKey.endsWith("fix_tools_fts_info"))
    {
      paramf = new Intent();
      paramf.setClassName(getContext(), "com.tencent.mm.plugin.search.ui.FTSInfoUI");
      paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/plugin/setting/ui/fixtools/FixSearchUI", "goToFTSInfoUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/fixtools/FixSearchUI", "goToFTSInfoUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(73810);
      return true;
    }
    AppMethodBeat.o(73810);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.fixtools.FixSearchUI
 * JD-Core Version:    0.7.0.1
 */