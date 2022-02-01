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
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.pluginsdk.g.e.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.util.c;

public class FixSearchUI
  extends MMPreference
{
  private f screen;
  private long xoP = 0L;
  private com.tencent.mm.ui.widget.a.d xoQ;
  private com.tencent.mm.ui.widget.a.d xoR;
  private com.tencent.mm.ui.widget.a.d xoS;
  
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
    SettingsAboutMMHeaderPreference localSettingsAboutMMHeaderPreference = (SettingsAboutMMHeaderPreference)this.screen.aPN("fix_tools_micromsg_header");
    String str = com.tencent.mm.sdk.platformtools.i.aA(getContext(), com.tencent.mm.protocal.d.DIc);
    paramBundle = str;
    if (com.tencent.mm.protocal.d.DIf) {
      paramBundle = str + " " + getString(2131755263);
    }
    localSettingsAboutMMHeaderPreference.xqK = paramBundle;
    if (c.fwZ()) {
      this.screen.cK("fix_tools_fts_info", false);
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
      this.screen.cK("fix_tools_fts_info", true);
    }
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(73810);
    if (paramPreference.mKey.endsWith("fix_tools_fts"))
    {
      if (this.xoQ == null) {
        this.xoQ = h.a(this, getString(2131759428), "", true, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(73806);
            ac.i("MicroMsg.FixSearchUI", "delete fts db, and kill process");
            com.tencent.mm.plugin.fts.a.e.Fy(24);
            paramAnonymousDialogInterface = new StringBuilder();
            g.agS();
            paramAnonymousDialogInterface = g.agR().cachePath + "FTS5IndexMicroMsg_encrypt.db";
            paramAnonymousInt = 0;
            while (paramAnonymousInt < 4)
            {
              String str = new String[] { "", "-journal", "-wal", "-shm" }[paramAnonymousInt];
              str = paramAnonymousDialogInterface + str;
              ac.i("MicroMsg.FixSearchUI", "deleteIndexDB %s %s", new Object[] { str, Boolean.valueOf(com.tencent.mm.vfs.i.eA(str)) });
              com.tencent.mm.vfs.i.deleteFile(str);
              paramAnonymousInt += 1;
            }
            FixSearchUI.this.finish();
            if (com.tencent.mm.pluginsdk.g.e.DjW != null) {
              com.tencent.mm.pluginsdk.g.e.DjW.bz(FixSearchUI.this.getContext());
            }
            AppMethodBeat.o(73806);
          }
        }, null);
      }
      this.xoQ.show();
      AppMethodBeat.o(73810);
      return true;
    }
    if (paramPreference.mKey.endsWith("fix_tools_websearch"))
    {
      if (this.xoR == null) {
        this.xoR = h.a(this, getString(2131759442), "", true, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(73807);
            ac.i("MicroMsg.FixSearchUI", "delete web search template, and kill process");
            com.tencent.mm.vfs.i.cU(z.Uj(0).exF(), true);
            ai.Ut(30);
            FixSearchUI.this.finish();
            if (com.tencent.mm.pluginsdk.g.e.DjW != null) {
              com.tencent.mm.pluginsdk.g.e.DjW.bz(FixSearchUI.this.getContext());
            }
            AppMethodBeat.o(73807);
          }
        }, null);
      }
      this.xoR.show();
      AppMethodBeat.o(73810);
      return true;
    }
    if (paramPreference.mKey.endsWith("fix_tools_topstory"))
    {
      if (this.xoS == null) {
        this.xoS = h.a(this, getString(2131759442), "", true, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(73808);
            ac.i("MicroMsg.FixSearchUI", "delete topstory template, and kill process");
            com.tencent.mm.vfs.i.cU(z.Uj(1).exF(), true);
            ai.Ut(31);
            FixSearchUI.this.finish();
            if (com.tencent.mm.pluginsdk.g.e.DjW != null) {
              com.tencent.mm.pluginsdk.g.e.DjW.bz(FixSearchUI.this.getContext());
            }
            AppMethodBeat.o(73808);
          }
        }, null);
      }
      this.xoS.show();
      AppMethodBeat.o(73810);
      return true;
    }
    if (paramPreference.mKey.endsWith("fix_tools_micromsg_header"))
    {
      long l = bs.eWj();
      if ((this.xoP > l) || (l - this.xoP > 300L)) {
        this.xoP = l;
      }
      for (;;)
      {
        AppMethodBeat.o(73810);
        return true;
        this.xoP = l;
        if (c.fwZ())
        {
          paramf = new Intent();
          paramf.setClassName(getContext(), "com.tencent.mm.plugin.websearch.ui.WebSearchExptSettingUI");
          paramf = new com.tencent.mm.hellhoundlib.b.a().ba(paramf);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramf.aeD(), "com/tencent/mm/plugin/setting/ui/fixtools/FixSearchUI", "onClickHeader", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramf.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/fixtools/FixSearchUI", "onClickHeader", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
    }
    if (paramPreference.mKey.endsWith("fix_tools_fts_info"))
    {
      paramf = new Intent();
      paramf.setClassName(getContext(), "com.tencent.mm.plugin.search.ui.FTSInfoUI");
      paramf = new com.tencent.mm.hellhoundlib.b.a().ba(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.aeD(), "com/tencent/mm/plugin/setting/ui/fixtools/FixSearchUI", "goToFTSInfoUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.lR(0));
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