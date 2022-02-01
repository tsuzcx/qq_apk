package com.tencent.mm.plugin.setting.ui.fixtools;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMMHeaderPreference;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.pluginsdk.i.f.a;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.util.c;

public class FixSearchUI
  extends MMPreference
{
  private com.tencent.mm.ui.base.preference.f screen;
  private com.tencent.mm.ui.widget.a.d yDu;
  private com.tencent.mm.ui.widget.a.d yDv;
  private com.tencent.mm.ui.widget.a.d yDw;
  
  public int getResourceId()
  {
    return 2131951683;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(73809);
    super.onCreate(paramBundle);
    this.screen = getPreferenceScreen();
    setMMTitle(2131759432);
    SettingsAboutMMHeaderPreference localSettingsAboutMMHeaderPreference = (SettingsAboutMMHeaderPreference)this.screen.aVD("fix_tools_micromsg_header");
    String str = j.aD(getContext(), com.tencent.mm.protocal.d.Fnj);
    if (!com.tencent.mm.protocal.d.Fnm)
    {
      paramBundle = str;
      if (!com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_BLUE) {}
    }
    else
    {
      paramBundle = str + " " + com.tencent.mm.cd.g.is(this);
    }
    localSettingsAboutMMHeaderPreference.yFq = paramBundle;
    paramBundle = c.LgD;
    if (c.fNM()) {
      this.screen.cP("fix_tools_fts_info", false);
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
      this.screen.cP("fix_tools_fts_info", true);
    }
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(73810);
    if (paramPreference.mKey.endsWith("fix_tools_fts"))
    {
      if (this.yDu == null) {
        this.yDu = h.a(this, getString(2131759428), "", true, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(73806);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FixSearchUI", "delete fts db, and kill process");
            com.tencent.mm.plugin.fts.a.e.GN(24);
            paramAnonymousDialogInterface = new StringBuilder();
            com.tencent.mm.kernel.g.ajD();
            paramAnonymousDialogInterface = com.tencent.mm.kernel.g.ajC().cachePath + "FTS5IndexMicroMsg_encrypt.db";
            paramAnonymousInt = 0;
            while (paramAnonymousInt < 4)
            {
              String str = new String[] { "", "-journal", "-wal", "-shm" }[paramAnonymousInt];
              str = paramAnonymousDialogInterface + str;
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FixSearchUI", "deleteIndexDB %s %s", new Object[] { str, Boolean.valueOf(com.tencent.mm.vfs.i.fv(str)) });
              com.tencent.mm.vfs.i.deleteFile(str);
              paramAnonymousInt += 1;
            }
            FixSearchUI.this.finish();
            if (com.tencent.mm.pluginsdk.i.f.EOZ != null) {
              com.tencent.mm.pluginsdk.i.f.EOZ.by(FixSearchUI.this.getContext());
            }
            AppMethodBeat.o(73806);
          }
        }, null);
      }
      this.yDu.show();
      AppMethodBeat.o(73810);
      return true;
    }
    if (paramPreference.mKey.endsWith("fix_tools_websearch"))
    {
      if (this.yDv == null) {
        this.yDv = h.a(this, getString(2131759442), "", true, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(73807);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FixSearchUI", "delete web search template, and kill process");
            com.tencent.mm.vfs.i.cZ(com.tencent.mm.plugin.websearch.api.ad.Wc(0).eMw(), true);
            am.Wm(30);
            FixSearchUI.this.finish();
            if (com.tencent.mm.pluginsdk.i.f.EOZ != null) {
              com.tencent.mm.pluginsdk.i.f.EOZ.by(FixSearchUI.this.getContext());
            }
            AppMethodBeat.o(73807);
          }
        }, null);
      }
      this.yDv.show();
      AppMethodBeat.o(73810);
      return true;
    }
    if (paramPreference.mKey.endsWith("fix_tools_topstory"))
    {
      if (this.yDw == null) {
        this.yDw = h.a(this, getString(2131759442), "", true, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(73808);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FixSearchUI", "delete topstory template, and kill process");
            com.tencent.mm.vfs.i.cZ(com.tencent.mm.plugin.websearch.api.ad.Wc(1).eMw(), true);
            am.Wm(31);
            FixSearchUI.this.finish();
            if (com.tencent.mm.pluginsdk.i.f.EOZ != null) {
              com.tencent.mm.pluginsdk.i.f.EOZ.by(FixSearchUI.this.getContext());
            }
            AppMethodBeat.o(73808);
          }
        }, null);
      }
      this.yDw.show();
      AppMethodBeat.o(73810);
      return true;
    }
    if (paramPreference.mKey.endsWith("fix_tools_fts_info"))
    {
      paramf = new Intent();
      paramf.setClassName(getContext(), "com.tencent.mm.plugin.search.ui.FTSInfoUI");
      paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahp(), "com/tencent/mm/plugin/setting/ui/fixtools/FixSearchUI", "goToFTSInfoUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.mq(0));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.fixtools.FixSearchUI
 * JD-Core Version:    0.7.0.1
 */