package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.aw.c;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.a.h;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.a.k;
import com.tencent.mm.plugin.y.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  private static int nVo = 1;
  private static HashMap<String, Integer> nVp = new SettingsPluginsUI.1();
  private f dnn;
  private boolean nVq;
  private boolean nVr;
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    boolean bool = false;
    String str = paramPreference.mKey;
    if ((str != null) && (str.equals("display_in_addr_book")))
    {
      bool = ((CheckBoxPreference)paramf.add(str)).isChecked();
      com.tencent.mm.kernel.g.DP().Dz().o(35, Boolean.valueOf(bool));
      bool = true;
    }
    while (!(paramPreference instanceof PluginPreference)) {
      return bool;
    }
    paramf = ((PluginPreference)paramPreference).nSe;
    if (("feedsapp".equals(paramf)) && (this.nVq)) {
      com.tencent.mm.kernel.g.DP().Dz().o(-2046825369, Boolean.valueOf(false));
    }
    paramPreference = new Intent();
    if (("gh_43f2581f6fd6".equals(paramf)) && (this.nVr))
    {
      a.bot();
      com.tencent.mm.aw.d.iX(com.tencent.mm.aw.b.evf);
      paramPreference.putExtra("key_from_wesport_plugin_newtips", true);
    }
    paramPreference.putExtra("Contact_User", paramf);
    com.tencent.mm.br.d.b(this, "profile", ".ui.ContactInfoUI", paramPreference);
    h.nFQ.f(12846, new Object[] { nVp.get(paramf) });
    y.i("MicroMsg.SettingsPluginsUI", "click id:%s, kvID:%d", new Object[] { paramf, nVp.get(paramf) });
    return true;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.settings_plugins);
    setBackBtn(new SettingsPluginsUI.2(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.dnn = this.vdd;
    initView();
    h.nFQ.f(14098, new Object[] { Integer.valueOf(5) });
    h.nFQ.f(12846, new Object[] { Integer.valueOf(nVo) });
    am.a.dVy.V("gh_43f2581f6fd6", "");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    int j = 0;
    super.onResume();
    this.dnn.removeAll();
    Object localObject1 = new PreferenceSmallCategory(this);
    this.dnn.a((Preference)localObject1);
    localObject1 = new ArrayList();
    Object localObject4 = new ArrayList();
    boolean bool2 = q.GR();
    boolean bool1 = bool2;
    label151:
    label165:
    label217:
    label231:
    Object localObject3;
    if (!bool2)
    {
      if (bk.getInt(com.tencent.mm.m.g.AA().getValue("BindQQSwitch"), 1) == 1) {
        bool1 = true;
      }
    }
    else
    {
      if (!bool1) {
        y.i("MicroMsg.SettingsPluginsUI", "summerqq BindQQSwitch off");
      }
      if ((bool1) && (com.tencent.mm.br.d.SP("qqmail")))
      {
        localObject2 = new PluginPreference(this);
        if (((PluginPreference)localObject2).Mp("qqmail"))
        {
          ((PluginPreference)localObject2).setTitle(((PluginPreference)localObject2).nSf);
          if ((q.Gu() & 0x1) != 0) {
            break label827;
          }
          i = 1;
          if (i == 0) {
            break label832;
          }
          ((List)localObject1).add(localObject2);
        }
      }
      if (com.tencent.mm.br.d.SP("readerapp"))
      {
        localObject2 = new PluginPreference(this);
        if (((PluginPreference)localObject2).Mp("newsapp"))
        {
          ((PluginPreference)localObject2).setTitle(((PluginPreference)localObject2).nSf);
          if ((q.Gu() & 0x80000) != 0) {
            break label851;
          }
          i = 1;
          if (i == 0) {
            break label856;
          }
          ((List)localObject1).add(localObject2);
        }
      }
      localObject2 = new PluginPreference(this);
      if (((PluginPreference)localObject2).Mp("facebookapp"))
      {
        ((PluginPreference)localObject2).setTitle(((PluginPreference)localObject2).nSf);
        if ((q.Gu() & 0x2000) != 0) {
          break label875;
        }
        i = 1;
        label274:
        if (i == 0) {
          break label880;
        }
        ((List)localObject1).add(localObject2);
      }
      label288:
      if (com.tencent.mm.br.d.SP("masssend"))
      {
        localObject2 = new PluginPreference(this);
        if (((PluginPreference)localObject2).Mp("masssendapp"))
        {
          ((PluginPreference)localObject2).setTitle(((PluginPreference)localObject2).nSf);
          if ((q.Gu() & 0x10000) != 0) {
            break label899;
          }
          i = 1;
          label340:
          if (i == 0) {
            break label904;
          }
          ((List)localObject1).add(localObject2);
        }
      }
      label354:
      localObject2 = new PluginPreference(this);
      localObject3 = getString(a.i.exdevice_wechat_sport);
      ((PluginPreference)localObject2).nSe = "gh_43f2581f6fd6";
      ((PluginPreference)localObject2).nSf = ((String)localObject3);
      ((PluginPreference)localObject2).setKey("settings_plugins_list_#" + ((PluginPreference)localObject2).nSe);
      ((PluginPreference)localObject2).setTitle(((PluginPreference)localObject2).nSf);
      if (!((com.tencent.mm.plugin.sport.b.b)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.sport.b.b.class)).bKY()) {
        break label917;
      }
      ((List)localObject1).add(localObject2);
      label450:
      a.bov();
      this.nVr = c.iW(com.tencent.mm.aw.b.evf);
      ((PluginPreference)localObject2).nSj = this.nVr;
      if (!((Boolean)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uzR, Boolean.valueOf(true))).booleanValue())
      {
        localObject2 = new PluginPreference(this);
        if (((PluginPreference)localObject2).Mp("downloaderapp"))
        {
          ((PluginPreference)localObject2).setTitle(((PluginPreference)localObject2).nSf);
          if (!q.GK()) {
            break label930;
          }
          ((List)localObject1).add(localObject2);
        }
      }
      label545:
      localObject2 = com.tencent.mm.m.g.AA().getValue("LinkedinPluginClose");
      if ((bk.bl((String)localObject2)) || (Integer.valueOf((String)localObject2).intValue() == 0))
      {
        localObject2 = new PluginPreference(this);
        if (((PluginPreference)localObject2).Mp("linkedinplugin"))
        {
          ((PluginPreference)localObject2).setTitle(((PluginPreference)localObject2).nSf);
          if ((q.Gu() & 0x1000000) != 0) {
            break label943;
          }
        }
      }
    }
    String str;
    label899:
    label904:
    label917:
    label930:
    label943:
    for (int i = 1;; i = 0)
    {
      if (!bk.bl((String)com.tencent.mm.kernel.g.DP().Dz().get(286721, null))) {
        j = 1;
      }
      if ((i != 0) && (j != 0)) {
        ((List)localObject1).add(localObject2);
      }
      if (!((List)localObject1).isEmpty())
      {
        localObject2 = new PluginTextPreference(this);
        ((PluginTextPreference)localObject2).vdA = a.h.setting_plugin_install;
        ((PluginTextPreference)localObject2).GC(a.i.settings_plugins_installed_plugins);
        this.dnn.a((Preference)localObject2);
      }
      str = (String)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uwq, "");
      Iterator localIterator = ((List)localObject1).iterator();
      for (localObject1 = null; localIterator.hasNext(); localObject1 = localObject2)
      {
        localObject3 = (PluginPreference)localIterator.next();
        ((PluginPreference)localObject3).jRP = 255;
        localObject2 = localObject1;
        if (str.contains(((PluginPreference)localObject3).nSe))
        {
          ((PluginPreference)localObject3).nSj = true;
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = localObject3;
          }
        }
        this.dnn.a((Preference)localObject3);
      }
      bool1 = false;
      break;
      label827:
      i = 0;
      break label151;
      label832:
      if (!com.tencent.mm.at.b.Pd()) {
        break label165;
      }
      ((List)localObject4).add(localObject2);
      break label165;
      label851:
      i = 0;
      break label217;
      label856:
      if (!com.tencent.mm.at.b.Pd()) {
        break label231;
      }
      ((List)localObject4).add(localObject2);
      break label231;
      label875:
      i = 0;
      break label274;
      label880:
      if (!com.tencent.mm.at.b.Pc()) {
        break label288;
      }
      ((List)localObject4).add(localObject2);
      break label288;
      i = 0;
      break label340;
      ((List)localObject4).add(localObject2);
      break label354;
      ((List)localObject4).add(localObject2);
      break label450;
      ((List)localObject4).add(localObject2);
      break label545;
    }
    Object localObject2 = new PreferenceSmallCategory(this);
    this.dnn.a((Preference)localObject2);
    localObject2 = new PluginTextPreference(this);
    ((PluginTextPreference)localObject2).vdA = a.h.setting_plugin_uninstall;
    ((PluginTextPreference)localObject2).GC(a.i.settings_plugins_uninstalled_plugins);
    this.dnn.a((Preference)localObject2);
    if (((List)localObject4).isEmpty())
    {
      localObject2 = new PluginEmptyTextPreference(this, a.i.settings_plugins_can_uninstalled);
      this.dnn.a((Preference)localObject2);
    }
    localObject4 = ((List)localObject4).iterator();
    while (((Iterator)localObject4).hasNext())
    {
      localObject3 = (PluginPreference)((Iterator)localObject4).next();
      ((PluginPreference)localObject3).jRP = 136;
      localObject2 = localObject1;
      if (str.contains(((PluginPreference)localObject3).nSe))
      {
        ((PluginPreference)localObject3).nSj = true;
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = localObject3;
        }
      }
      this.dnn.a((Preference)localObject3);
      localObject1 = localObject2;
    }
    localObject2 = new PreferenceSmallCategory(this);
    this.dnn.a((Preference)localObject2);
    if (localObject1 != null) {
      setSelection(this.dnn.adf(((Preference)localObject1).mKey));
    }
  }
  
  public final int xj()
  {
    return a.k.settings_pref_plugins;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsPluginsUI
 * JD-Core Version:    0.7.0.1
 */