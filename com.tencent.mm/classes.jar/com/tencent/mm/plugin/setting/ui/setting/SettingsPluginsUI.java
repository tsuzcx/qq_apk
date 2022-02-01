package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.newtips.a.e;
import com.tencent.mm.plugin.newtips.a.g;
import com.tencent.mm.plugin.preference.PluginPreference;
import com.tencent.mm.plugin.setting.b.h;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.b.k;
import com.tencent.mm.protocal.protobuf.cqy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.PluginTextPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class SettingsPluginsUI
  extends MMPreference
  implements com.tencent.mm.am.h
{
  private static int Pvs;
  private static HashMap<String, Integer> Pvt;
  private boolean Pvu;
  private com.tencent.mm.ui.base.preference.f screen;
  
  static
  {
    AppMethodBeat.i(74342);
    Pvs = 1;
    Pvt = new HashMap() {};
    AppMethodBeat.o(74342);
  }
  
  private void bYg()
  {
    int j = 0;
    AppMethodBeat.i(298697);
    this.screen.removeAll();
    Object localObject1 = new PreferenceSmallCategory(this);
    this.screen.c((Preference)localObject1);
    localObject1 = new ArrayList();
    Object localObject4 = new ArrayList();
    boolean bool2 = z.bBG();
    boolean bool1 = bool2;
    Object localObject2;
    int i;
    label158:
    label172:
    label246:
    Object localObject3;
    if (!bool2)
    {
      if (Util.getInt(com.tencent.mm.k.i.aRC().getValue("BindQQSwitch"), 1) == 1) {
        bool1 = true;
      }
    }
    else
    {
      if (!bool1) {
        Log.i("MicroMsg.SettingsPluginsUI", "summerqq BindQQSwitch off");
      }
      if ((!WeChatBrands.Business.Entries.HomePluginQQMail.banned()) && (bool1) && (com.tencent.mm.br.c.blq("qqmail")))
      {
        localObject2 = new PluginPreference(this);
        if (((PluginPreference)localObject2).aRF("qqmail"))
        {
          ((PluginPreference)localObject2).setTitle(((PluginPreference)localObject2).MPj);
          if ((z.bBf() & 0x1) != 0) {
            break label1132;
          }
          i = 1;
          if (i == 0) {
            break label1137;
          }
          ((List)localObject1).add(localObject2);
        }
      }
      if ((!WeChatBrands.Business.Entries.HomePluginQQMail.banned()) && (com.tencent.mm.br.c.blq("readerapp")) && (!((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu()))
      {
        localObject2 = new PluginPreference(this);
        if (((PluginPreference)localObject2).aRF("newsapp"))
        {
          ((PluginPreference)localObject2).setTitle(((PluginPreference)localObject2).MPj);
          if ((z.bBf() & 0x80000) != 0) {
            break label1156;
          }
          i = 1;
          if (i == 0) {
            break label1161;
          }
          ((List)localObject1).add(localObject2);
        }
      }
      label260:
      if (!WeChatBrands.Business.Entries.MeSetSecurityFacebook.banned())
      {
        localObject2 = new PluginPreference(this);
        if (((PluginPreference)localObject2).aRF("facebookapp"))
        {
          ((PluginPreference)localObject2).setTitle(((PluginPreference)localObject2).MPj);
          if ((z.bBf() & 0x2000) != 0) {
            break label1180;
          }
          i = 1;
          label311:
          if (i == 0) {
            break label1185;
          }
          ((List)localObject1).add(localObject2);
        }
      }
      label325:
      if (com.tencent.mm.br.c.blq("masssend"))
      {
        localObject2 = new PluginPreference(this);
        if (((PluginPreference)localObject2).aRF("masssendapp"))
        {
          ((PluginPreference)localObject2).setTitle(((PluginPreference)localObject2).MPj);
          if ((z.bBf() & 0x10000) != 0) {
            break label1204;
          }
          i = 1;
          label374:
          if (i == 0) {
            break label1209;
          }
          ((List)localObject1).add(localObject2);
        }
      }
      label388:
      localObject2 = new PluginPreference(this);
      if (((PluginPreference)localObject2).kU("gh_43f2581f6fd6", getString(b.i.exdevice_wechat_sport)))
      {
        ((PluginPreference)localObject2).setTitle(((PluginPreference)localObject2).MPj);
        if (!((com.tencent.mm.plugin.sport.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.sport.a.b.class)).htT()) {
          break label1222;
        }
        ((List)localObject1).add(localObject2);
        label451:
        com.tencent.mm.plugin.newtips.a.gti();
        this.Pvu = e.aeE(com.tencent.mm.plugin.newtips.a.d.Mse);
        ((PluginPreference)localObject2).MPn = this.Pvu;
      }
      localObject2 = new PluginPreference(this);
      if (((PluginPreference)localObject2).kU("gh_3dfda90e39d6", getString(b.i.plugin_wxpay_notify_name)))
      {
        ((PluginPreference)localObject2).setTitle(((PluginPreference)localObject2).MPj);
        localObject3 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE("gh_3dfda90e39d6");
        if (localObject3 == null) {
          break label1774;
        }
      }
    }
    label561:
    label735:
    label1132:
    label1774:
    for (bool1 = com.tencent.mm.contact.d.rs(((az)localObject3).field_type);; bool1 = false)
    {
      if (bool1)
      {
        ((List)localObject1).add(localObject2);
        localObject2 = new PluginPreference(this);
        if (((PluginPreference)localObject2).kU("gh_b4af18eac3d5", getString(b.i.plugin_wxpay_hk_notify_name)))
        {
          ((PluginPreference)localObject2).setTitle(((PluginPreference)localObject2).MPj);
          localObject3 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE("gh_b4af18eac3d5");
          if (localObject3 == null) {
            break label1769;
          }
        }
      }
      for (bool1 = com.tencent.mm.contact.d.rs(((az)localObject3).field_type);; bool1 = false)
      {
        if (bool1) {
          ((List)localObject1).add(localObject2);
        }
        localObject2 = new PluginPreference(this);
        if (((PluginPreference)localObject2).kU("gh_f0a92aa7146c", getString(b.i.plugin_wxpay_collection_name)))
        {
          ((PluginPreference)localObject2).setTitle(((PluginPreference)localObject2).MPj);
          localObject3 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE("gh_f0a92aa7146c");
          if (localObject3 == null) {
            break label1764;
          }
        }
        for (bool1 = com.tencent.mm.contact.d.rs(((az)localObject3).field_type);; bool1 = false)
        {
          if (bool1)
          {
            ((List)localObject1).add(localObject2);
            localObject2 = new PluginPreference(this);
            if (((PluginPreference)localObject2).kU("gh_e087bb5b95e6", getString(b.i.plugin_wxpay_business_collection_name)))
            {
              ((PluginPreference)localObject2).setTitle(((PluginPreference)localObject2).MPj);
              localObject3 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE("gh_e087bb5b95e6");
              if (localObject3 == null) {
                break label1759;
              }
            }
          }
          for (bool1 = com.tencent.mm.contact.d.rs(((az)localObject3).field_type);; bool1 = false)
          {
            if (bool1)
            {
              ((List)localObject1).add(localObject2);
              if (1 == ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.ztC, 1)) {
                break label1366;
              }
              Log.i("MicroMsg.SettingsPluginsUI", "addMiniShopHelperIfNeed, not need");
            }
            String str;
            label1137:
            do
            {
              localObject2 = com.tencent.mm.k.i.aRC().getValue("LinkedinPluginClose");
              if ((Util.isNullOrNil((String)localObject2)) || (Util.getInt((String)localObject2, 0) == 0))
              {
                localObject2 = new PluginPreference(this);
                if (((PluginPreference)localObject2).aRF("linkedinplugin"))
                {
                  ((PluginPreference)localObject2).setTitle(((PluginPreference)localObject2).MPj);
                  if ((z.bBf() & 0x1000000) != 0) {
                    break label1514;
                  }
                  i = 1;
                  if (!Util.isNullOrNil((String)com.tencent.mm.kernel.h.baE().ban().d(286721, null))) {
                    j = 1;
                  }
                  if ((i != 0) && (j != 0)) {
                    ((List)localObject1).add(localObject2);
                  }
                }
              }
              if (!((List)localObject1).isEmpty())
              {
                localObject2 = new PluginTextPreference(this);
                ((PluginTextPreference)localObject2).adZM = b.h.setting_plugin_install;
                ((PluginTextPreference)localObject2).aBo(b.i.settings_plugins_installed_plugins);
                this.screen.c((Preference)localObject2);
              }
              str = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acRG, "");
              Iterator localIterator = ((List)localObject1).iterator();
              for (localObject1 = null; localIterator.hasNext(); localObject1 = localObject2)
              {
                localObject3 = (PluginPreference)localIterator.next();
                ((PluginPreference)localObject3).zWi = 255;
                localObject2 = localObject1;
                if (str.contains(((PluginPreference)localObject3).MPi))
                {
                  ((PluginPreference)localObject3).MPn = true;
                  localObject2 = localObject1;
                  if (localObject1 == null) {
                    localObject2 = localObject3;
                  }
                }
                this.screen.c((Preference)localObject3);
              }
              bool1 = false;
              break;
              i = 0;
              break label158;
              if (!com.tencent.mm.au.b.bKK()) {
                break label172;
              }
              ((List)localObject4).add(localObject2);
              break label172;
              i = 0;
              break label246;
              if (!com.tencent.mm.au.b.bKK()) {
                break label260;
              }
              ((List)localObject4).add(localObject2);
              break label260;
              i = 0;
              break label311;
              if (!com.tencent.mm.au.b.bKJ()) {
                break label325;
              }
              ((List)localObject4).add(localObject2);
              break label325;
              i = 0;
              break label374;
              ((List)localObject4).add(localObject2);
              break label388;
              ((List)localObject4).add(localObject2);
              break label451;
              ((List)localObject4).add(localObject2);
              break label561;
              com.tencent.mm.kernel.h.baF();
              i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acZu, Integer.valueOf(0))).intValue();
              Log.i("MicroMsg.SettingsPluginsUI", "SETTING_PLUGIN_SHOW_PAY_COLLECTION Flag :%s", new Object[] { Integer.valueOf(i) });
              if (i != 1) {
                break label735;
              }
              ((List)localObject4).add(localObject2);
              break label735;
              bool1 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yXj, false);
              Log.i("MicroMsg.SettingsPluginsUI", "addPayBusinessCollection openConfig ：%s ", new Object[] { Boolean.valueOf(bool1) });
              if (!bool1) {
                break label822;
              }
              ((List)localObject4).add(localObject2);
              break label822;
              localObject2 = new PluginPreference(this);
            } while (!((PluginPreference)localObject2).kU("gh_579db1f2cf89", getString(b.i.hardcode_plugin_mini_shop_helper_nick)));
            ((PluginPreference)localObject2).setTitle(((PluginPreference)localObject2).MPj);
            localObject3 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE("gh_579db1f2cf89");
            if (localObject3 != null) {}
            for (bool1 = com.tencent.mm.contact.d.rs(((az)localObject3).field_type);; bool1 = false)
            {
              if (bool1)
              {
                ((List)localObject1).add(localObject2);
                break;
              }
              i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acZw, Integer.valueOf(0))).intValue();
              Log.i("MicroMsg.SettingsPluginsUI", "addMiniShopHelperIfNeed, USERINFO_SETTING_PLUGIN_SHOW_MINI_SHOP_HELPER_FLAG_INT_SYNC: ".concat(String.valueOf(i)));
              if (1 != i) {
                break;
              }
              ((List)localObject4).add(localObject2);
              break;
              i = 0;
              break label922;
              localObject2 = new PreferenceSmallCategory(this);
              this.screen.c((Preference)localObject2);
              localObject2 = new PluginTextPreference(this);
              ((PluginTextPreference)localObject2).adZM = b.h.setting_plugin_uninstall;
              ((PluginTextPreference)localObject2).aBo(b.i.settings_plugins_uninstalled_plugins);
              this.screen.c((Preference)localObject2);
              if (((List)localObject4).isEmpty())
              {
                localObject2 = new PluginEmptyTextPreference(this, b.i.settings_plugins_can_uninstalled);
                this.screen.c((Preference)localObject2);
              }
              localObject4 = ((List)localObject4).iterator();
              while (((Iterator)localObject4).hasNext())
              {
                localObject3 = (PluginPreference)((Iterator)localObject4).next();
                ((PluginPreference)localObject3).zWi = 136;
                localObject2 = localObject1;
                if (str.contains(((PluginPreference)localObject3).MPi))
                {
                  ((PluginPreference)localObject3).MPn = true;
                  localObject2 = localObject1;
                  if (localObject1 == null) {
                    localObject2 = localObject3;
                  }
                }
                this.screen.c((Preference)localObject3);
                localObject1 = localObject2;
              }
              localObject2 = new PreferenceSmallCategory(this);
              this.screen.c((Preference)localObject2);
              if (localObject1 != null) {
                setSelection(this.screen.bAl(((Preference)localObject1).mKey));
              }
              AppMethodBeat.o(298697);
              return;
            }
          }
        }
      }
    }
  }
  
  public int getResourceId()
  {
    return b.k.settings_pref_plugins;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74338);
    setMMTitle(b.i.settings_plugins);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(74335);
        SettingsPluginsUI.this.hideVKB();
        SettingsPluginsUI.this.finish();
        AppMethodBeat.o(74335);
        return true;
      }
    });
    AppMethodBeat.o(74338);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74336);
    super.onCreate(paramBundle);
    this.screen = getPreferenceScreen();
    initView();
    com.tencent.mm.plugin.report.service.h.OAn.b(14098, new Object[] { Integer.valueOf(5) });
    com.tencent.mm.plugin.report.service.h.OAn.b(12846, new Object[] { Integer.valueOf(Pvs) });
    az.a.okP.aZ("gh_43f2581f6fd6", "");
    AppMethodBeat.o(74336);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74337);
    super.onDestroy();
    AppMethodBeat.o(74337);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(74340);
    super.onPause();
    AppMethodBeat.o(74340);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74341);
    Object localObject = paramPreference.mKey;
    if ((localObject != null) && (((String)localObject).equals("display_in_addr_book")))
    {
      boolean bool = ((CheckBoxPreference)paramf.bAi((String)localObject)).isChecked();
      com.tencent.mm.kernel.h.baE().ban().B(35, Boolean.valueOf(bool));
      AppMethodBeat.o(74341);
      return true;
    }
    if ((paramPreference instanceof PluginPreference))
    {
      paramf = ((PluginPreference)paramPreference).MPi;
      int i = -1;
      switch (paramf.hashCode())
      {
      default: 
        switch (i)
        {
        default: 
          label164:
          localObject = new Intent();
          if ("gh_f0a92aa7146c".equals(paramf)) {
            com.tencent.mm.plugin.report.service.h.OAn.b(19540, new Object[] { Integer.valueOf(2) });
          }
          if ("wximeplugin".equals(paramf))
          {
            if ((!(paramPreference instanceof com.tencent.mm.plugin.newtips.a.a)) || (!g.d((com.tencent.mm.plugin.newtips.a.a)paramPreference))) {
              break label472;
            }
            ((Intent)localObject).putExtra("ime_enter_scene", 1);
          }
          break;
        }
        break;
      }
      for (;;)
      {
        com.tencent.mm.plugin.newtips.a.gtf().aeI(33);
        if (("gh_43f2581f6fd6".equals(paramf)) && (this.Pvu))
        {
          com.tencent.mm.plugin.newtips.a.gtf();
          com.tencent.mm.plugin.newtips.a.i.aeG(com.tencent.mm.plugin.newtips.a.d.Mse);
          ((Intent)localObject).putExtra("key_from_wesport_plugin_newtips", true);
        }
        ((Intent)localObject).putExtra("Contact_User", paramf);
        com.tencent.mm.br.c.b(this, "profile", ".ui.ContactInfoUI", (Intent)localObject);
        com.tencent.mm.plugin.report.service.h.OAn.b(12846, new Object[] { Pvt.get(paramf) });
        Log.i("MicroMsg.SettingsPluginsUI", "click id:%s, kvID:%d", new Object[] { paramf, Pvt.get(paramf) });
        AppMethodBeat.o(74341);
        return true;
        if (!paramf.equals("qqmail")) {
          break;
        }
        i = 0;
        break;
        if (!paramf.equals("newsapp")) {
          break;
        }
        i = 1;
        break;
        if (!paramf.equals("gh_43f2581f6fd6")) {
          break;
        }
        i = 2;
        break;
        if (!paramf.equals("gh_3dfda90e39d6")) {
          break;
        }
        i = 3;
        break;
        if (!WeChatBrands.Business.Entries.HomePluginQQMail.checkAvailable(this))
        {
          AppMethodBeat.o(74341);
          return true;
        }
        if (!WeChatBrands.Business.Entries.HomePluginSports.checkAvailable(this))
        {
          AppMethodBeat.o(74341);
          return true;
        }
        if (WeChatBrands.Business.Entries.HomePluginWePay.checkAvailable(this)) {
          break label164;
        }
        AppMethodBeat.o(74341);
        return true;
        label472:
        ((Intent)localObject).putExtra("ime_enter_scene", 6);
      }
    }
    AppMethodBeat.o(74341);
    return false;
  }
  
  public boolean onPreferenceTreeLongClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference, View paramView)
  {
    AppMethodBeat.i(298740);
    boolean bool = super.onPreferenceTreeLongClick(paramf, paramPreference, paramView);
    AppMethodBeat.o(298740);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74339);
    super.onResume();
    Object localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE("gh_f0a92aa7146c");
    if (localObject != null) {}
    for (boolean bool = com.tencent.mm.contact.d.rs(((az)localObject).field_type);; bool = false)
    {
      Log.i("MicroMsg.SettingsPluginsUI", "needGetReceipAssistPlugin result：%s", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        com.tencent.mm.kernel.h.aZW().a(2745, this);
        localObject = new com.tencent.mm.plugin.setting.model.i();
        com.tencent.mm.kernel.h.aZW().a((p)localObject, 0);
      }
      if (1 != ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.ztC, 1))
      {
        Log.i("MicroMsg.SettingsPluginsUI", "fetchMiniShopHelperPluginShowStatusIfNeed, not need");
        bYg();
        AppMethodBeat.o(74339);
        return;
      }
      localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE("gh_579db1f2cf89");
      if (localObject != null) {
        if (!com.tencent.mm.contact.d.rs(((az)localObject).field_type)) {
          bool = true;
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.SettingsPluginsUI", "fetchMiniShopHelperPluginShowStatusIfNeed, needFetch: ".concat(String.valueOf(bool)));
        if (!bool) {
          break;
        }
        com.tencent.mm.kernel.h.aZW().a(4158, this);
        localObject = new com.tencent.mm.plugin.setting.model.h();
        com.tencent.mm.kernel.h.aZW().a((p)localObject, 0);
        break;
        bool = false;
        continue;
        bool = true;
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(298749);
    Log.i("MicroMsg.SettingsPluginsUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramp.getType());
    if ((paramp instanceof com.tencent.mm.plugin.setting.model.i))
    {
      com.tencent.mm.kernel.h.aZW().b(2745, this);
      if ((paramInt1 == 0) || (paramInt2 == 0))
      {
        paramString = (com.tencent.mm.plugin.setting.model.i)paramp;
        if (paramString.PnG == null)
        {
          paramString = new cqy();
          if (paramString.aaxB != 1) {
            break label160;
          }
          Log.i("MicroMsg.SettingsPluginsUI", "need to show unstall ReceipAssistPlugin");
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acZu, Integer.valueOf(1));
        }
        for (;;)
        {
          bYg();
          AppMethodBeat.o(298749);
          return;
          paramString = paramString.PnG;
          break;
          label160:
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acZu, Integer.valueOf(0));
        }
      }
      Log.e("MicroMsg.SettingsPluginsUI", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      AppMethodBeat.o(298749);
      return;
    }
    if ((paramp instanceof com.tencent.mm.plugin.setting.model.h))
    {
      com.tencent.mm.kernel.h.aZW().b(4158, this);
      if ((paramInt1 == 0) || (paramInt2 == 0))
      {
        if (((com.tencent.mm.plugin.setting.model.h)paramp).PnF)
        {
          Log.i("MicroMsg.SettingsPluginsUI", "need to show unstall MiniShopHelperPlugin");
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acZw, Integer.valueOf(1));
        }
        for (;;)
        {
          bYg();
          AppMethodBeat.o(298749);
          return;
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acZw, Integer.valueOf(0));
        }
      }
      Log.e("MicroMsg.SettingsPluginsUI", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    }
    AppMethodBeat.o(298749);
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