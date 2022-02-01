package com.tencent.mm.plugin.setting.ui.fixtools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ce.j;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.b.k;
import com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMMHeaderPreference;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.as;
import com.tencent.mm.plugin.websearch.api.au;
import com.tencent.mm.pluginsdk.platformtools.c;
import com.tencent.mm.pluginsdk.platformtools.c.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.vfs.y;

public class FixSearchUI
  extends MMPreference
{
  private com.tencent.mm.ui.widget.a.e PoA;
  private com.tencent.mm.ui.widget.a.e Poy;
  private com.tencent.mm.ui.widget.a.e Poz;
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
    SettingsAboutMMHeaderPreference localSettingsAboutMMHeaderPreference = (SettingsAboutMMHeaderPreference)this.screen.bAi("fix_tools_micromsg_header");
    String str = ChannelUtil.formatVersion(getContext(), com.tencent.mm.protocal.d.Yxh);
    if (!com.tencent.mm.protocal.d.Yxk)
    {
      paramBundle = str;
      if (!BuildInfo.IS_FLAVOR_BLUE) {}
    }
    else
    {
      paramBundle = str + " " + j.mx(this);
    }
    localSettingsAboutMMHeaderPreference.Pqy = paramBundle;
    paramBundle = com.tencent.mm.util.d.agsY;
    if (com.tencent.mm.util.d.jJv()) {
      this.screen.eh("fix_tools_fts_info", false);
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
      this.screen.eh("fix_tools_fts_info", true);
    }
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(73810);
    if (paramPreference.mKey.endsWith("fix_tools_fts"))
    {
      paramPreference = this.Poy;
      paramf = paramPreference;
      if (paramPreference == null)
      {
        paramf = k.a(this, getString(b.i.fix_tools_fts_rebuild_tips), "", true, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(73806);
            Log.i("MicroMsg.FixSearchUI", "delete fts db, and kill process");
            com.tencent.mm.plugin.fts.a.e.Wf(24);
            paramAnonymousDialogInterface = new StringBuilder();
            h.baF();
            paramAnonymousDialogInterface = h.baE().cachePath + "FTS5IndexMicroMsg_encrypt.db";
            paramAnonymousInt = 0;
            while (paramAnonymousInt < 4)
            {
              String str = new String[] { "", "-journal", "-wal", "-shm" }[paramAnonymousInt];
              str = paramAnonymousDialogInterface + str;
              Log.i("MicroMsg.FixSearchUI", "deleteIndexDB %s %s", new Object[] { str, Boolean.valueOf(y.ZC(str)) });
              y.deleteFile(str);
              paramAnonymousInt += 1;
            }
            FixSearchUI.this.finish();
            if (c.XUP != null) {
              c.XUP.cF(FixSearchUI.this.getContext());
            }
            AppMethodBeat.o(73806);
          }
        }, null);
        this.Poy = paramf;
      }
      paramf.show();
      AppMethodBeat.o(73810);
      return true;
    }
    if (paramPreference.mKey.endsWith("fix_tools_websearch"))
    {
      if (this.Poz == null) {
        this.Poz = k.a(this, getString(b.i.fix_tools_web_search_tips), "", true, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(73807);
            Log.i("MicroMsg.FixSearchUI", "delete web search template, and kill process");
            y.ew(aj.asW(0).iqp(), true);
            as.atf(30);
            FixSearchUI.this.finish();
            if (c.XUP != null) {
              c.XUP.cF(FixSearchUI.this.getContext());
            }
            AppMethodBeat.o(73807);
          }
        }, null);
      }
      this.Poz.show();
      AppMethodBeat.o(73810);
      return true;
    }
    if (paramPreference.mKey.endsWith("fix_tools_topstory"))
    {
      if (this.PoA == null) {
        this.PoA = k.a(this, getString(b.i.fix_tools_web_search_tips), "", true, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(73808);
            Log.i("MicroMsg.FixSearchUI", "delete topstory template, and kill process");
            y.ew(aj.asW(1).iqp(), true);
            as.atf(31);
            FixSearchUI.this.finish();
            if (c.XUP != null) {
              c.XUP.cF(FixSearchUI.this.getContext());
            }
            AppMethodBeat.o(73808);
          }
        }, null);
      }
      this.PoA.show();
      AppMethodBeat.o(73810);
      return true;
    }
    if (paramPreference.mKey.endsWith("fix_tools_fts_info"))
    {
      paramf = new Intent();
      paramf.setClassName(getContext(), "com.tencent.mm.plugin.search.ui.FTSInfoUI");
      paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/setting/ui/fixtools/FixSearchUI", "goToFTSInfoUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sb(0));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.fixtools.FixSearchUI
 * JD-Core Version:    0.7.0.1
 */