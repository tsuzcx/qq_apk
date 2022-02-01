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
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.pluginsdk.i.f.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.util.c;
import com.tencent.mm.vfs.o;

public class FixSearchUI
  extends MMPreference
{
  private com.tencent.mm.ui.base.preference.f screen;
  private com.tencent.mm.ui.widget.a.d yTA;
  private com.tencent.mm.ui.widget.a.d yTB;
  private com.tencent.mm.ui.widget.a.d yTz;
  
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
    SettingsAboutMMHeaderPreference localSettingsAboutMMHeaderPreference = (SettingsAboutMMHeaderPreference)this.screen.aXe("fix_tools_micromsg_header");
    String str = k.aD(getContext(), com.tencent.mm.protocal.d.FFH);
    if (!com.tencent.mm.protocal.d.FFK)
    {
      paramBundle = str;
      if (!j.IS_FLAVOR_BLUE) {}
    }
    else
    {
      paramBundle = str + " " + com.tencent.mm.cc.g.ix(this);
    }
    localSettingsAboutMMHeaderPreference.yVv = paramBundle;
    paramBundle = c.LDf;
    if (c.fSh()) {
      this.screen.cT("fix_tools_fts_info", false);
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
      this.screen.cT("fix_tools_fts_info", true);
    }
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(73810);
    if (paramPreference.mKey.endsWith("fix_tools_fts"))
    {
      if (this.yTz == null) {
        this.yTz = h.a(this, getString(2131759428), "", true, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(73806);
            ae.i("MicroMsg.FixSearchUI", "delete fts db, and kill process");
            com.tencent.mm.plugin.fts.a.e.Hk(24);
            paramAnonymousDialogInterface = new StringBuilder();
            com.tencent.mm.kernel.g.ajS();
            paramAnonymousDialogInterface = com.tencent.mm.kernel.g.ajR().cachePath + "FTS5IndexMicroMsg_encrypt.db";
            paramAnonymousInt = 0;
            while (paramAnonymousInt < 4)
            {
              String str = new String[] { "", "-journal", "-wal", "-shm" }[paramAnonymousInt];
              str = paramAnonymousDialogInterface + str;
              ae.i("MicroMsg.FixSearchUI", "deleteIndexDB %s %s", new Object[] { str, Boolean.valueOf(o.fB(str)) });
              o.deleteFile(str);
              paramAnonymousInt += 1;
            }
            FixSearchUI.this.finish();
            if (com.tencent.mm.pluginsdk.i.f.Fhu != null) {
              com.tencent.mm.pluginsdk.i.f.Fhu.bA(FixSearchUI.this.getContext());
            }
            AppMethodBeat.o(73806);
          }
        }, null);
      }
      this.yTz.show();
      AppMethodBeat.o(73810);
      return true;
    }
    if (paramPreference.mKey.endsWith("fix_tools_websearch"))
    {
      if (this.yTA == null) {
        this.yTA = h.a(this, getString(2131759442), "", true, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(73807);
            ae.i("MicroMsg.FixSearchUI", "delete web search template, and kill process");
            o.dd(ad.WJ(0).eQf(), true);
            am.WT(30);
            FixSearchUI.this.finish();
            if (com.tencent.mm.pluginsdk.i.f.Fhu != null) {
              com.tencent.mm.pluginsdk.i.f.Fhu.bA(FixSearchUI.this.getContext());
            }
            AppMethodBeat.o(73807);
          }
        }, null);
      }
      this.yTA.show();
      AppMethodBeat.o(73810);
      return true;
    }
    if (paramPreference.mKey.endsWith("fix_tools_topstory"))
    {
      if (this.yTB == null) {
        this.yTB = h.a(this, getString(2131759442), "", true, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(73808);
            ae.i("MicroMsg.FixSearchUI", "delete topstory template, and kill process");
            o.dd(ad.WJ(1).eQf(), true);
            am.WT(31);
            FixSearchUI.this.finish();
            if (com.tencent.mm.pluginsdk.i.f.Fhu != null) {
              com.tencent.mm.pluginsdk.i.f.Fhu.bA(FixSearchUI.this.getContext());
            }
            AppMethodBeat.o(73808);
          }
        }, null);
      }
      this.yTB.show();
      AppMethodBeat.o(73810);
      return true;
    }
    if (paramPreference.mKey.endsWith("fix_tools_fts_info"))
    {
      paramf = new Intent();
      paramf.setClassName(getContext(), "com.tencent.mm.plugin.search.ui.FTSInfoUI");
      paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/plugin/setting/ui/fixtools/FixSearchUI", "goToFTSInfoUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.mt(0));
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