package com.tencent.mm.plugin.setting.ui.fixtools;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.b.k;
import com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMMHeaderPreference;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.websearch.api.at;
import com.tencent.mm.pluginsdk.j.c;
import com.tencent.mm.pluginsdk.j.c.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.vfs.u;

public class FixSearchUI
  extends MMPreference
{
  private com.tencent.mm.ui.widget.a.d JdY;
  private com.tencent.mm.ui.widget.a.d JdZ;
  private com.tencent.mm.ui.widget.a.d Jea;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public int getResourceId()
  {
    return b.k.fix_tools_search;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(73809);
    super.onCreate(paramBundle);
    this.screen = getPreferenceScreen();
    setMMTitle(b.i.fix_tools_search);
    SettingsAboutMMHeaderPreference localSettingsAboutMMHeaderPreference = (SettingsAboutMMHeaderPreference)this.screen.byG("fix_tools_micromsg_header");
    String str = ChannelUtil.formatVersion(getContext(), com.tencent.mm.protocal.d.RAD);
    if (!com.tencent.mm.protocal.d.RAG)
    {
      paramBundle = str;
      if (!BuildInfo.IS_FLAVOR_BLUE) {}
    }
    else
    {
      paramBundle = str + " " + com.tencent.mm.cj.h.kv(this);
    }
    localSettingsAboutMMHeaderPreference.JfL = paramBundle;
    paramBundle = com.tencent.mm.util.d.YyA;
    if (com.tencent.mm.util.d.ien()) {
      this.screen.dz("fix_tools_fts_info", false);
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
      this.screen.dz("fix_tools_fts_info", true);
    }
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(73810);
    if (paramPreference.mKey.endsWith("fix_tools_fts"))
    {
      if (this.JdY == null) {
        this.JdY = com.tencent.mm.ui.base.h.a(this, getString(b.i.fix_tools_fts_rebuild_tips), "", true, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(73806);
            Log.i("MicroMsg.FixSearchUI", "delete fts db, and kill process");
            e.Sy(24);
            paramAnonymousDialogInterface = new StringBuilder();
            com.tencent.mm.kernel.h.aHH();
            paramAnonymousDialogInterface = com.tencent.mm.kernel.h.aHG().cachePath + "FTS5IndexMicroMsg_encrypt.db";
            paramAnonymousInt = 0;
            while (paramAnonymousInt < 4)
            {
              String str = new String[] { "", "-journal", "-wal", "-shm" }[paramAnonymousInt];
              str = paramAnonymousDialogInterface + str;
              Log.i("MicroMsg.FixSearchUI", "deleteIndexDB %s %s", new Object[] { str, Boolean.valueOf(u.agG(str)) });
              u.deleteFile(str);
              paramAnonymousInt += 1;
            }
            FixSearchUI.this.finish();
            if (c.QYP != null) {
              c.QYP.bT(FixSearchUI.this.getContext());
            }
            AppMethodBeat.o(73806);
          }
        }, null);
      }
      this.JdY.show();
      AppMethodBeat.o(73810);
      return true;
    }
    if (paramPreference.mKey.endsWith("fix_tools_websearch"))
    {
      if (this.JdZ == null) {
        this.JdZ = com.tencent.mm.ui.base.h.a(this, getString(b.i.fix_tools_web_search_tips), "", true, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(73807);
            Log.i("MicroMsg.FixSearchUI", "delete web search template, and kill process");
            u.deleteDir(ai.anf(0).gRd());
            ar.anp(30);
            FixSearchUI.this.finish();
            if (c.QYP != null) {
              c.QYP.bT(FixSearchUI.this.getContext());
            }
            AppMethodBeat.o(73807);
          }
        }, null);
      }
      this.JdZ.show();
      AppMethodBeat.o(73810);
      return true;
    }
    if (paramPreference.mKey.endsWith("fix_tools_topstory"))
    {
      if (this.Jea == null) {
        this.Jea = com.tencent.mm.ui.base.h.a(this, getString(b.i.fix_tools_web_search_tips), "", true, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(73808);
            Log.i("MicroMsg.FixSearchUI", "delete topstory template, and kill process");
            u.deleteDir(ai.anf(1).gRd());
            ar.anp(31);
            FixSearchUI.this.finish();
            if (c.QYP != null) {
              c.QYP.bT(FixSearchUI.this.getContext());
            }
            AppMethodBeat.o(73808);
          }
        }, null);
      }
      this.Jea.show();
      AppMethodBeat.o(73810);
      return true;
    }
    if (paramPreference.mKey.endsWith("fix_tools_fts_info"))
    {
      paramf = new Intent();
      paramf.setClassName(getContext(), "com.tencent.mm.plugin.search.ui.FTSInfoUI");
      paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/plugin/setting/ui/fixtools/FixSearchUI", "goToFTSInfoUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/fixtools/FixSearchUI", "goToFTSInfoUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.fixtools.FixSearchUI
 * JD-Core Version:    0.7.0.1
 */