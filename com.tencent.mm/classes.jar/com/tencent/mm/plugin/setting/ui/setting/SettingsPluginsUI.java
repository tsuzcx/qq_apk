package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ax.c;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.r.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.PluginTextPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class SettingsPluginsUI
  extends MMPreference
{
  private static int qJu;
  private static HashMap<String, Integer> qJv;
  private boolean qJw;
  private boolean qJx;
  private f screen;
  
  static
  {
    AppMethodBeat.i(127406);
    qJu = 1;
    qJv = new SettingsPluginsUI.1();
    AppMethodBeat.o(127406);
  }
  
  public int getResourceId()
  {
    return 2131165291;
  }
  
  public void initView()
  {
    AppMethodBeat.i(127402);
    setMMTitle(2131303372);
    setBackBtn(new SettingsPluginsUI.2(this));
    AppMethodBeat.o(127402);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127400);
    super.onCreate(paramBundle);
    this.screen = getPreferenceScreen();
    initView();
    h.qsU.e(14098, new Object[] { Integer.valueOf(5) });
    h.qsU.e(12846, new Object[] { Integer.valueOf(qJu) });
    ao.a.flI.am("gh_43f2581f6fd6", "");
    AppMethodBeat.o(127400);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(127401);
    super.onDestroy();
    AppMethodBeat.o(127401);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(127404);
    super.onPause();
    AppMethodBeat.o(127404);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(127405);
    String str = paramPreference.mKey;
    if ((str != null) && (str.equals("display_in_addr_book")))
    {
      boolean bool = ((CheckBoxPreference)paramf.atx(str)).isChecked();
      com.tencent.mm.kernel.g.RL().Ru().set(35, Boolean.valueOf(bool));
      AppMethodBeat.o(127405);
      return true;
    }
    if ((paramPreference instanceof PluginPreference))
    {
      paramf = ((PluginPreference)paramPreference).qGc;
      if (("feedsapp".equals(paramf)) && (this.qJw)) {
        com.tencent.mm.kernel.g.RL().Ru().set(-2046825369, Boolean.FALSE);
      }
      paramPreference = new Intent();
      if (("gh_43f2581f6fd6".equals(paramf)) && (this.qJx))
      {
        a.bWS();
        com.tencent.mm.ax.d.lP(com.tencent.mm.ax.b.fKS);
        paramPreference.putExtra("key_from_wesport_plugin_newtips", true);
      }
      paramPreference.putExtra("Contact_User", paramf);
      com.tencent.mm.bq.d.b(this, "profile", ".ui.ContactInfoUI", paramPreference);
      h.qsU.e(12846, new Object[] { qJv.get(paramf) });
      ab.i("MicroMsg.SettingsPluginsUI", "click id:%s, kvID:%d", new Object[] { paramf, qJv.get(paramf) });
      AppMethodBeat.o(127405);
      return true;
    }
    AppMethodBeat.o(127405);
    return false;
  }
  
  public void onResume()
  {
    int j = 0;
    AppMethodBeat.i(127403);
    super.onResume();
    this.screen.removeAll();
    Object localObject1 = new PreferenceSmallCategory(this);
    this.screen.b((Preference)localObject1);
    localObject1 = new ArrayList();
    Object localObject4 = new ArrayList();
    boolean bool2 = r.ZT();
    boolean bool1 = bool2;
    label157:
    label171:
    label223:
    label237:
    Object localObject3;
    if (!bool2)
    {
      if (bo.getInt(com.tencent.mm.m.g.Nq().getValue("BindQQSwitch"), 1) == 1) {
        bool1 = true;
      }
    }
    else
    {
      if (!bool1) {
        ab.i("MicroMsg.SettingsPluginsUI", "summerqq BindQQSwitch off");
      }
      if ((bool1) && (com.tencent.mm.bq.d.ahR("qqmail")))
      {
        localObject2 = new PluginPreference(this);
        if (((PluginPreference)localObject2).YT("qqmail"))
        {
          ((PluginPreference)localObject2).setTitle(((PluginPreference)localObject2).qGd);
          if ((r.Zy() & 0x1) != 0) {
            break label761;
          }
          i = 1;
          if (i == 0) {
            break label766;
          }
          ((List)localObject1).add(localObject2);
        }
      }
      if (com.tencent.mm.bq.d.ahR("readerapp"))
      {
        localObject2 = new PluginPreference(this);
        if (((PluginPreference)localObject2).YT("newsapp"))
        {
          ((PluginPreference)localObject2).setTitle(((PluginPreference)localObject2).qGd);
          if ((r.Zy() & 0x80000) != 0) {
            break label785;
          }
          i = 1;
          if (i == 0) {
            break label790;
          }
          ((List)localObject1).add(localObject2);
        }
      }
      localObject2 = new PluginPreference(this);
      if (((PluginPreference)localObject2).YT("facebookapp"))
      {
        ((PluginPreference)localObject2).setTitle(((PluginPreference)localObject2).qGd);
        if ((r.Zy() & 0x2000) != 0) {
          break label809;
        }
        i = 1;
        label280:
        if (i == 0) {
          break label814;
        }
        ((List)localObject1).add(localObject2);
      }
      label294:
      if (com.tencent.mm.bq.d.ahR("masssend"))
      {
        localObject2 = new PluginPreference(this);
        if (((PluginPreference)localObject2).YT("masssendapp"))
        {
          ((PluginPreference)localObject2).setTitle(((PluginPreference)localObject2).qGd);
          if ((r.Zy() & 0x10000) != 0) {
            break label833;
          }
          i = 1;
          label346:
          if (i == 0) {
            break label838;
          }
          ((List)localObject1).add(localObject2);
        }
      }
      label360:
      localObject2 = new PluginPreference(this);
      localObject3 = getString(2131299490);
      ((PluginPreference)localObject2).qGc = "gh_43f2581f6fd6";
      ((PluginPreference)localObject2).qGd = ((String)localObject3);
      ((PluginPreference)localObject2).setKey("settings_plugins_list_#" + ((PluginPreference)localObject2).qGc);
      ((PluginPreference)localObject2).setTitle(((PluginPreference)localObject2).qGd);
      if (!((com.tencent.mm.plugin.sport.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.sport.a.b.class)).cyu()) {
        break label851;
      }
      ((List)localObject1).add(localObject2);
      label456:
      a.bWU();
      this.qJx = c.lO(com.tencent.mm.ax.b.fKS);
      ((PluginPreference)localObject2).qGg = this.qJx;
      localObject2 = com.tencent.mm.m.g.Nq().getValue("LinkedinPluginClose");
      if ((bo.isNullOrNil((String)localObject2)) || (Integer.valueOf((String)localObject2).intValue() == 0))
      {
        localObject2 = new PluginPreference(this);
        if (((PluginPreference)localObject2).YT("linkedinplugin"))
        {
          ((PluginPreference)localObject2).setTitle(((PluginPreference)localObject2).qGd);
          if ((r.Zy() & 0x1000000) != 0) {
            break label864;
          }
        }
      }
    }
    String str;
    label785:
    label790:
    label809:
    label814:
    label833:
    label838:
    label851:
    label864:
    for (int i = 1;; i = 0)
    {
      if (!bo.isNullOrNil((String)com.tencent.mm.kernel.g.RL().Ru().get(286721, null))) {
        j = 1;
      }
      if ((i != 0) && (j != 0)) {
        ((List)localObject1).add(localObject2);
      }
      if (!((List)localObject1).isEmpty())
      {
        localObject2 = new PluginTextPreference(this);
        ((PluginTextPreference)localObject2).zsa = 2131231972;
        ((PluginTextPreference)localObject2).OV(2131303379);
        this.screen.b((Preference)localObject2);
      }
      str = (String)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yGy, "");
      Iterator localIterator = ((List)localObject1).iterator();
      for (localObject1 = null; localIterator.hasNext(); localObject1 = localObject2)
      {
        localObject3 = (PluginPreference)localIterator.next();
        ((PluginPreference)localObject3).mml = 255;
        localObject2 = localObject1;
        if (str.contains(((PluginPreference)localObject3).qGc))
        {
          ((PluginPreference)localObject3).qGg = true;
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = localObject3;
          }
        }
        this.screen.b((Preference)localObject3);
      }
      bool1 = false;
      break;
      label761:
      i = 0;
      break label157;
      label766:
      if (!com.tencent.mm.au.b.aie()) {
        break label171;
      }
      ((List)localObject4).add(localObject2);
      break label171;
      i = 0;
      break label223;
      if (!com.tencent.mm.au.b.aie()) {
        break label237;
      }
      ((List)localObject4).add(localObject2);
      break label237;
      i = 0;
      break label280;
      if (!com.tencent.mm.au.b.aid()) {
        break label294;
      }
      ((List)localObject4).add(localObject2);
      break label294;
      i = 0;
      break label346;
      ((List)localObject4).add(localObject2);
      break label360;
      ((List)localObject4).add(localObject2);
      break label456;
    }
    Object localObject2 = new PreferenceSmallCategory(this);
    this.screen.b((Preference)localObject2);
    localObject2 = new PluginTextPreference(this);
    ((PluginTextPreference)localObject2).zsa = 2131231973;
    ((PluginTextPreference)localObject2).OV(2131303387);
    this.screen.b((Preference)localObject2);
    if (((List)localObject4).isEmpty())
    {
      localObject2 = new PluginEmptyTextPreference(this);
      this.screen.b((Preference)localObject2);
    }
    localObject4 = ((List)localObject4).iterator();
    while (((Iterator)localObject4).hasNext())
    {
      localObject3 = (PluginPreference)((Iterator)localObject4).next();
      ((PluginPreference)localObject3).mml = 136;
      localObject2 = localObject1;
      if (str.contains(((PluginPreference)localObject3).qGc))
      {
        ((PluginPreference)localObject3).qGg = true;
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = localObject3;
        }
      }
      this.screen.b((Preference)localObject3);
      localObject1 = localObject2;
    }
    localObject2 = new PreferenceSmallCategory(this);
    this.screen.b((Preference)localObject2);
    if (localObject1 != null) {
      setSelection(this.screen.atz(((Preference)localObject1).mKey));
    }
    AppMethodBeat.o(127403);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsPluginsUI
 * JD-Core Version:    0.7.0.1
 */