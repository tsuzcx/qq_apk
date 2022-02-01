package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.by.c;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.newtips.a.e;
import com.tencent.mm.plugin.preference.PluginPreference;
import com.tencent.mm.plugin.setting.b.h;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.b.k;
import com.tencent.mm.protocal.protobuf.cbr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bv;
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
  implements com.tencent.mm.an.i
{
  private static int JiZ;
  private static HashMap<String, Integer> Jja;
  private boolean Jjb;
  private boolean Jjc;
  private com.tencent.mm.ui.base.preference.f screen;
  
  static
  {
    AppMethodBeat.i(74342);
    JiZ = 1;
    Jja = new SettingsPluginsUI.1();
    AppMethodBeat.o(74342);
  }
  
  private void bzk()
  {
    int j = 0;
    AppMethodBeat.i(264787);
    this.screen.removeAll();
    Object localObject1 = new PreferenceSmallCategory(this);
    this.screen.b((Preference)localObject1);
    localObject1 = new ArrayList();
    Object localObject4 = new ArrayList();
    boolean bool2 = z.bdO();
    boolean bool1 = bool2;
    Object localObject2;
    int i;
    label158:
    label172:
    label230:
    label244:
    Object localObject3;
    if (!bool2)
    {
      if (Util.getInt(com.tencent.mm.n.h.axc().getValue("BindQQSwitch"), 1) == 1) {
        bool1 = true;
      }
    }
    else
    {
      if (!bool1) {
        Log.i("MicroMsg.SettingsPluginsUI", "summerqq BindQQSwitch off");
      }
      if ((!WeChatBrands.Business.Entries.HomePluginQQMail.banned()) && (bool1) && (c.blP("qqmail")))
      {
        localObject2 = new PluginPreference(this);
        if (((PluginPreference)localObject2).aUx("qqmail"))
        {
          ((PluginPreference)localObject2).setTitle(((PluginPreference)localObject2).GRF);
          if ((z.bdn() & 0x1) != 0) {
            break label1019;
          }
          i = 1;
          if (i == 0) {
            break label1024;
          }
          ((List)localObject1).add(localObject2);
        }
      }
      if ((!WeChatBrands.Business.Entries.HomePluginQQMail.banned()) && (c.blP("readerapp")))
      {
        localObject2 = new PluginPreference(this);
        if (((PluginPreference)localObject2).aUx("newsapp"))
        {
          ((PluginPreference)localObject2).setTitle(((PluginPreference)localObject2).GRF);
          if ((z.bdn() & 0x80000) != 0) {
            break label1043;
          }
          i = 1;
          if (i == 0) {
            break label1048;
          }
          ((List)localObject1).add(localObject2);
        }
      }
      if (!WeChatBrands.Business.Entries.MeSetSecurityFacebook.banned())
      {
        localObject2 = new PluginPreference(this);
        if (((PluginPreference)localObject2).aUx("facebookapp"))
        {
          ((PluginPreference)localObject2).setTitle(((PluginPreference)localObject2).GRF);
          if ((z.bdn() & 0x2000) != 0) {
            break label1067;
          }
          i = 1;
          label295:
          if (i == 0) {
            break label1072;
          }
          ((List)localObject1).add(localObject2);
        }
      }
      label309:
      if (c.blP("masssend"))
      {
        localObject2 = new PluginPreference(this);
        if (((PluginPreference)localObject2).aUx("masssendapp"))
        {
          ((PluginPreference)localObject2).setTitle(((PluginPreference)localObject2).GRF);
          if ((z.bdn() & 0x10000) != 0) {
            break label1091;
          }
          i = 1;
          label358:
          if (i == 0) {
            break label1096;
          }
          ((List)localObject1).add(localObject2);
        }
      }
      label372:
      localObject2 = new PluginPreference(this);
      ((PluginPreference)localObject2).jA("gh_43f2581f6fd6", getString(b.i.exdevice_wechat_sport));
      ((PluginPreference)localObject2).setTitle(((PluginPreference)localObject2).GRF);
      if (!((com.tencent.mm.plugin.sport.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.sport.a.b.class)).gaC()) {
        break label1109;
      }
      ((List)localObject1).add(localObject2);
      label433:
      com.tencent.mm.plugin.newtips.a.fiR();
      this.Jjc = e.aal(com.tencent.mm.plugin.newtips.a.d.Gwf);
      ((PluginPreference)localObject2).GRJ = this.Jjc;
      localObject2 = new PluginPreference(this);
      ((PluginPreference)localObject2).jA("gh_3dfda90e39d6", getString(b.i.plugin_wxpay_notify_name));
      ((PluginPreference)localObject2).setTitle(((PluginPreference)localObject2).GRF);
      localObject3 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG("gh_3dfda90e39d6");
      if (localObject3 == null) {
        break label1600;
      }
    }
    label541:
    label809:
    label1067:
    label1072:
    label1595:
    label1600:
    for (bool1 = com.tencent.mm.contact.d.rk(((ax)localObject3).field_type);; bool1 = false)
    {
      if (bool1)
      {
        ((List)localObject1).add(localObject2);
        localObject2 = new PluginPreference(this);
        ((PluginPreference)localObject2).jA("gh_b4af18eac3d5", getString(b.i.plugin_wxpay_hk_notify_name));
        ((PluginPreference)localObject2).setTitle(((PluginPreference)localObject2).GRF);
        localObject3 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG("gh_b4af18eac3d5");
        if (localObject3 == null) {
          break label1595;
        }
      }
      for (bool1 = com.tencent.mm.contact.d.rk(((ax)localObject3).field_type);; bool1 = false)
      {
        if (bool1) {
          ((List)localObject1).add(localObject2);
        }
        localObject2 = new PluginPreference(this);
        ((PluginPreference)localObject2).jA("gh_f0a92aa7146c", getString(b.i.plugin_wxpay_collection_name));
        ((PluginPreference)localObject2).setTitle(((PluginPreference)localObject2).GRF);
        localObject3 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG("gh_f0a92aa7146c");
        if (localObject3 != null) {}
        for (bool1 = com.tencent.mm.contact.d.rk(((ax)localObject3).field_type);; bool1 = false)
        {
          if (bool1) {
            ((List)localObject1).add(localObject2);
          }
          String str;
          for (;;)
          {
            if (1 == ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.waa, 0)) {
              break label1199;
            }
            Log.i("MicroMsg.SettingsPluginsUI", "addMiniShopHelperIfNeed, not need");
            localObject2 = com.tencent.mm.n.h.axc().getValue("LinkedinPluginClose");
            if ((Util.isNullOrNil((String)localObject2)) || (Util.getInt((String)localObject2, 0) == 0))
            {
              localObject2 = new PluginPreference(this);
              if (((PluginPreference)localObject2).aUx("linkedinplugin"))
              {
                ((PluginPreference)localObject2).setTitle(((PluginPreference)localObject2).GRF);
                if ((z.bdn() & 0x1000000) != 0) {
                  break label1345;
                }
                i = 1;
                if (!Util.isNullOrNil((String)com.tencent.mm.kernel.h.aHG().aHp().b(286721, null))) {
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
              ((PluginTextPreference)localObject2).Wsw = b.h.setting_plugin_install;
              ((PluginTextPreference)localObject2).auM(b.i.settings_plugins_installed_plugins);
              this.screen.b((Preference)localObject2);
            }
            str = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vqe, "");
            Iterator localIterator = ((List)localObject1).iterator();
            for (localObject1 = null; localIterator.hasNext(); localObject1 = localObject2)
            {
              localObject3 = (PluginPreference)localIterator.next();
              ((PluginPreference)localObject3).wzX = 255;
              localObject2 = localObject1;
              if (str.contains(((PluginPreference)localObject3).GRE))
              {
                ((PluginPreference)localObject3).GRJ = true;
                localObject2 = localObject1;
                if (localObject1 == null) {
                  localObject2 = localObject3;
                }
              }
              this.screen.b((Preference)localObject3);
            }
            bool1 = false;
            break;
            label1019:
            i = 0;
            break label158;
            if (!com.tencent.mm.az.b.bmY()) {
              break label172;
            }
            ((List)localObject4).add(localObject2);
            break label172;
            i = 0;
            break label230;
            if (!com.tencent.mm.az.b.bmY()) {
              break label244;
            }
            ((List)localObject4).add(localObject2);
            break label244;
            i = 0;
            break label295;
            if (!com.tencent.mm.az.b.bmX()) {
              break label309;
            }
            ((List)localObject4).add(localObject2);
            break label309;
            label1091:
            i = 0;
            break label358;
            label1096:
            ((List)localObject4).add(localObject2);
            break label372;
            label1109:
            ((List)localObject4).add(localObject2);
            break label433;
            ((List)localObject4).add(localObject2);
            break label541;
            com.tencent.mm.kernel.h.aHH();
            i = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VxH, Integer.valueOf(0))).intValue();
            Log.i("MicroMsg.SettingsPluginsUI", "SETTING_PLUGIN_SHOW_PAY_COLLECTION Flag :%s", new Object[] { Integer.valueOf(i) });
            if (i == 1) {
              ((List)localObject4).add(localObject2);
            }
          }
          localObject2 = new PluginPreference(this);
          ((PluginPreference)localObject2).jA("gh_579db1f2cf89", getString(b.i.hardcode_plugin_mini_shop_helper_nick));
          ((PluginPreference)localObject2).setTitle(((PluginPreference)localObject2).GRF);
          localObject3 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG("gh_579db1f2cf89");
          if (localObject3 != null) {}
          for (bool1 = com.tencent.mm.contact.d.rk(((ax)localObject3).field_type);; bool1 = false)
          {
            if (bool1)
            {
              ((List)localObject1).add(localObject2);
              break;
            }
            i = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VxJ, Integer.valueOf(0))).intValue();
            Log.i("MicroMsg.SettingsPluginsUI", "addMiniShopHelperIfNeed, USERINFO_SETTING_PLUGIN_SHOW_MINI_SHOP_HELPER_FLAG_INT_SYNC: ".concat(String.valueOf(i)));
            if (1 != i) {
              break;
            }
            ((List)localObject4).add(localObject2);
            break;
            label1345:
            i = 0;
            break label809;
            localObject2 = new PreferenceSmallCategory(this);
            this.screen.b((Preference)localObject2);
            localObject2 = new PluginTextPreference(this);
            ((PluginTextPreference)localObject2).Wsw = b.h.setting_plugin_uninstall;
            ((PluginTextPreference)localObject2).auM(b.i.settings_plugins_uninstalled_plugins);
            this.screen.b((Preference)localObject2);
            if (((List)localObject4).isEmpty())
            {
              localObject2 = new PluginEmptyTextPreference(this, b.i.settings_plugins_can_uninstalled);
              this.screen.b((Preference)localObject2);
            }
            localObject4 = ((List)localObject4).iterator();
            while (((Iterator)localObject4).hasNext())
            {
              localObject3 = (PluginPreference)((Iterator)localObject4).next();
              ((PluginPreference)localObject3).wzX = 136;
              localObject2 = localObject1;
              if (str.contains(((PluginPreference)localObject3).GRE))
              {
                ((PluginPreference)localObject3).GRJ = true;
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
              setSelection(this.screen.byJ(((Preference)localObject1).mKey));
            }
            AppMethodBeat.o(264787);
            return;
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
    setBackBtn(new SettingsPluginsUI.2(this));
    AppMethodBeat.o(74338);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74336);
    super.onCreate(paramBundle);
    this.screen = getPreferenceScreen();
    initView();
    com.tencent.mm.plugin.report.service.h.IzE.a(14098, new Object[] { Integer.valueOf(5) });
    com.tencent.mm.plugin.report.service.h.IzE.a(12846, new Object[] { Integer.valueOf(JiZ) });
    az.a.ltq.aP("gh_43f2581f6fd6", "");
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
      boolean bool = ((CheckBoxPreference)paramf.byG((String)localObject)).isChecked();
      com.tencent.mm.kernel.h.aHG().aHp().i(35, Boolean.valueOf(bool));
      AppMethodBeat.o(74341);
      return true;
    }
    if ((paramPreference instanceof PluginPreference))
    {
      paramf = ((PluginPreference)paramPreference).GRE;
      int i = -1;
      switch (paramf.hashCode())
      {
      default: 
        switch (i)
        {
        default: 
          label164:
          localObject = new Intent();
          if (("feedsapp".equals(paramf)) && (this.Jjb)) {
            com.tencent.mm.kernel.h.aHG().aHp().i(-2046825369, Boolean.FALSE);
          }
          if ("gh_f0a92aa7146c".equals(paramf)) {
            com.tencent.mm.plugin.report.service.h.IzE.a(19540, new Object[] { Integer.valueOf(2) });
          }
          if ("wximeplugin".equals(paramf))
          {
            if ((!(paramPreference instanceof com.tencent.mm.plugin.newtips.a.a)) || (!com.tencent.mm.plugin.newtips.a.g.d((com.tencent.mm.plugin.newtips.a.a)paramPreference))) {
              break label504;
            }
            ((Intent)localObject).putExtra("ime_enter_scene", 1);
          }
          break;
        }
        break;
      }
      for (;;)
      {
        com.tencent.mm.plugin.newtips.a.fiO().aap(33);
        if (("gh_43f2581f6fd6".equals(paramf)) && (this.Jjc))
        {
          com.tencent.mm.plugin.newtips.a.fiO();
          com.tencent.mm.plugin.newtips.a.i.aan(com.tencent.mm.plugin.newtips.a.d.Gwf);
          ((Intent)localObject).putExtra("key_from_wesport_plugin_newtips", true);
        }
        ((Intent)localObject).putExtra("Contact_User", paramf);
        c.b(this, "profile", ".ui.ContactInfoUI", (Intent)localObject);
        com.tencent.mm.plugin.report.service.h.IzE.a(12846, new Object[] { Jja.get(paramf) });
        Log.i("MicroMsg.SettingsPluginsUI", "click id:%s, kvID:%d", new Object[] { paramf, Jja.get(paramf) });
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
        label504:
        ((Intent)localObject).putExtra("ime_enter_scene", 6);
      }
    }
    AppMethodBeat.o(74341);
    return false;
  }
  
  public boolean onPreferenceTreeLongClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference, View paramView)
  {
    AppMethodBeat.i(264786);
    boolean bool = super.onPreferenceTreeLongClick(paramf, paramPreference, paramView);
    AppMethodBeat.o(264786);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74339);
    super.onResume();
    Object localObject = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG("gh_f0a92aa7146c");
    if (localObject != null) {}
    for (boolean bool = com.tencent.mm.contact.d.rk(((ax)localObject).field_type);; bool = false)
    {
      Log.i("MicroMsg.SettingsPluginsUI", "needGetReceipAssistPlugin result：%s", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        com.tencent.mm.kernel.h.aGY().a(2745, this);
        localObject = new com.tencent.mm.plugin.setting.model.g();
        com.tencent.mm.kernel.h.aGY().a((q)localObject, 0);
      }
      if (1 != ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.waa, 0))
      {
        Log.i("MicroMsg.SettingsPluginsUI", "fetchMiniShopHelperPluginShowStatusIfNeed, not need");
        bzk();
        AppMethodBeat.o(74339);
        return;
      }
      localObject = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG("gh_579db1f2cf89");
      if (localObject != null) {
        if (!com.tencent.mm.contact.d.rk(((ax)localObject).field_type)) {
          bool = true;
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.SettingsPluginsUI", "fetchMiniShopHelperPluginShowStatusIfNeed, needFetch: ".concat(String.valueOf(bool)));
        if (!bool) {
          break;
        }
        com.tencent.mm.kernel.h.aGY().a(4158, this);
        localObject = new com.tencent.mm.plugin.setting.model.f();
        com.tencent.mm.kernel.h.aGY().a((q)localObject, 0);
        break;
        bool = false;
        continue;
        bool = true;
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(264788);
    Log.i("MicroMsg.SettingsPluginsUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramq.getType());
    if ((paramq instanceof com.tencent.mm.plugin.setting.model.g))
    {
      com.tencent.mm.kernel.h.aGY().b(2745, this);
      if ((paramInt1 == 0) || (paramInt2 == 0))
      {
        paramString = (com.tencent.mm.plugin.setting.model.g)paramq;
        if (paramString.Jdr == null)
        {
          paramString = new cbr();
          if (paramString.TjZ != 1) {
            break label160;
          }
          Log.i("MicroMsg.SettingsPluginsUI", "need to show unstall ReceipAssistPlugin");
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VxH, Integer.valueOf(1));
        }
        for (;;)
        {
          bzk();
          AppMethodBeat.o(264788);
          return;
          paramString = paramString.Jdr;
          break;
          label160:
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VxH, Integer.valueOf(0));
        }
      }
      Log.e("MicroMsg.SettingsPluginsUI", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      AppMethodBeat.o(264788);
      return;
    }
    if ((paramq instanceof com.tencent.mm.plugin.setting.model.f))
    {
      com.tencent.mm.kernel.h.aGY().b(4158, this);
      if ((paramInt1 == 0) || (paramInt2 == 0))
      {
        if (((com.tencent.mm.plugin.setting.model.f)paramq).Jdq)
        {
          Log.i("MicroMsg.SettingsPluginsUI", "need to show unstall MiniShopHelperPlugin");
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VxJ, Integer.valueOf(1));
        }
        for (;;)
        {
          bzk();
          AppMethodBeat.o(264788);
          return;
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VxJ, Integer.valueOf(0));
        }
      }
      Log.e("MicroMsg.SettingsPluginsUI", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    }
    AppMethodBeat.o(264788);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsPluginsUI
 * JD-Core Version:    0.7.0.1
 */