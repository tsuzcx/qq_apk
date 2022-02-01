package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.newtips.a;
import com.tencent.mm.plugin.newtips.a.d;
import com.tencent.mm.protocal.protobuf.btz;
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
  implements com.tencent.mm.ak.i
{
  private static int Ddt;
  private static HashMap<String, Integer> Ddu;
  private boolean Ddv;
  private boolean Ddw;
  private com.tencent.mm.ui.base.preference.f screen;
  
  static
  {
    AppMethodBeat.i(74342);
    Ddt = 1;
    Ddu = new HashMap() {};
    AppMethodBeat.o(74342);
  }
  
  private void boY()
  {
    int j = 0;
    AppMethodBeat.i(256591);
    this.screen.removeAll();
    Object localObject1 = new PreferenceSmallCategory(this);
    this.screen.c((Preference)localObject1);
    localObject1 = new ArrayList();
    Object localObject4 = new ArrayList();
    boolean bool2 = z.aUM();
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
      if (Util.getInt(com.tencent.mm.n.h.aqJ().getValue("BindQQSwitch"), 1) == 1) {
        bool1 = true;
      }
    }
    else
    {
      if (!bool1) {
        Log.i("MicroMsg.SettingsPluginsUI", "summerqq BindQQSwitch off");
      }
      if ((!WeChatBrands.Business.Entries.HomePluginQQMail.banned()) && (bool1) && (com.tencent.mm.br.c.aZU("qqmail")))
      {
        localObject2 = new PluginPreference(this);
        if (((PluginPreference)localObject2).aNc("qqmail"))
        {
          ((PluginPreference)localObject2).setTitle(((PluginPreference)localObject2).CZj);
          if ((z.aUl() & 0x1) != 0) {
            break label929;
          }
          i = 1;
          if (i == 0) {
            break label934;
          }
          ((List)localObject1).add(localObject2);
        }
      }
      if ((!WeChatBrands.Business.Entries.HomePluginQQMail.banned()) && (com.tencent.mm.br.c.aZU("readerapp")))
      {
        localObject2 = new PluginPreference(this);
        if (((PluginPreference)localObject2).aNc("newsapp"))
        {
          ((PluginPreference)localObject2).setTitle(((PluginPreference)localObject2).CZj);
          if ((z.aUl() & 0x80000) != 0) {
            break label953;
          }
          i = 1;
          if (i == 0) {
            break label958;
          }
          ((List)localObject1).add(localObject2);
        }
      }
      if (!WeChatBrands.Business.Entries.MeSetSecurityFacebook.banned())
      {
        localObject2 = new PluginPreference(this);
        if (((PluginPreference)localObject2).aNc("facebookapp"))
        {
          ((PluginPreference)localObject2).setTitle(((PluginPreference)localObject2).CZj);
          if ((z.aUl() & 0x2000) != 0) {
            break label977;
          }
          i = 1;
          label295:
          if (i == 0) {
            break label982;
          }
          ((List)localObject1).add(localObject2);
        }
      }
      label309:
      if (com.tencent.mm.br.c.aZU("masssend"))
      {
        localObject2 = new PluginPreference(this);
        if (((PluginPreference)localObject2).aNc("masssendapp"))
        {
          ((PluginPreference)localObject2).setTitle(((PluginPreference)localObject2).CZj);
          if ((z.aUl() & 0x10000) != 0) {
            break label1001;
          }
          i = 1;
          label358:
          if (i == 0) {
            break label1006;
          }
          ((List)localObject1).add(localObject2);
        }
      }
      label372:
      localObject2 = new PluginPreference(this);
      ((PluginPreference)localObject2).jT("gh_43f2581f6fd6", getString(2131758927));
      ((PluginPreference)localObject2).setTitle(((PluginPreference)localObject2).CZj);
      if (!((com.tencent.mm.plugin.sport.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.sport.a.b.class)).fmg()) {
        break label1019;
      }
      ((List)localObject1).add(localObject2);
      label432:
      a.exo();
      this.Ddw = com.tencent.mm.plugin.newtips.a.e.Ty(d.ADb);
      ((PluginPreference)localObject2).CZm = this.Ddw;
      localObject2 = new PluginPreference(this);
      ((PluginPreference)localObject2).jT("gh_3dfda90e39d6", getString(2131764008));
      ((PluginPreference)localObject2).setTitle(((PluginPreference)localObject2).CZj);
      localObject3 = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn("gh_3dfda90e39d6");
      if (localObject3 == null) {
        break label1502;
      }
    }
    label539:
    label719:
    label977:
    label982:
    label1497:
    label1502:
    for (bool1 = com.tencent.mm.contact.c.oR(((ax)localObject3).field_type);; bool1 = false)
    {
      if (bool1)
      {
        ((List)localObject1).add(localObject2);
        localObject2 = new PluginPreference(this);
        ((PluginPreference)localObject2).jT("gh_f0a92aa7146c", getString(2131764007));
        ((PluginPreference)localObject2).setTitle(((PluginPreference)localObject2).CZj);
        localObject3 = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn("gh_f0a92aa7146c");
        if (localObject3 == null) {
          break label1497;
        }
      }
      for (bool1 = com.tencent.mm.contact.c.oR(((ax)localObject3).field_type);; bool1 = false)
      {
        if (bool1) {
          ((List)localObject1).add(localObject2);
        }
        String str;
        for (;;)
        {
          if (1 == ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.soA, 0)) {
            break label1109;
          }
          Log.i("MicroMsg.SettingsPluginsUI", "addMiniShopHelperIfNeed, not need");
          localObject2 = com.tencent.mm.n.h.aqJ().getValue("LinkedinPluginClose");
          if ((Util.isNullOrNil((String)localObject2)) || (Util.getInt((String)localObject2, 0) == 0))
          {
            localObject2 = new PluginPreference(this);
            if (((PluginPreference)localObject2).aNc("linkedinplugin"))
            {
              ((PluginPreference)localObject2).setTitle(((PluginPreference)localObject2).CZj);
              if ((z.aUl() & 0x1000000) != 0) {
                break label1255;
              }
              i = 1;
              if (!Util.isNullOrNil((String)com.tencent.mm.kernel.g.aAh().azQ().get(286721, null))) {
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
            ((PluginTextPreference)localObject2).OZn = 2131691467;
            ((PluginTextPreference)localObject2).alN(2131765543);
            this.screen.c((Preference)localObject2);
          }
          str = (String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Ocb, "");
          Iterator localIterator = ((List)localObject1).iterator();
          for (localObject1 = null; localIterator.hasNext(); localObject1 = localObject2)
          {
            localObject3 = (PluginPreference)localIterator.next();
            ((PluginPreference)localObject3).sUb = 255;
            localObject2 = localObject1;
            if (str.contains(((PluginPreference)localObject3).CZi))
            {
              ((PluginPreference)localObject3).CZm = true;
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
          if (!com.tencent.mm.aw.b.bdE()) {
            break label172;
          }
          ((List)localObject4).add(localObject2);
          break label172;
          i = 0;
          break label230;
          if (!com.tencent.mm.aw.b.bdE()) {
            break label244;
          }
          ((List)localObject4).add(localObject2);
          break label244;
          i = 0;
          break label295;
          if (!com.tencent.mm.aw.b.bdD()) {
            break label309;
          }
          ((List)localObject4).add(localObject2);
          break label309;
          label1001:
          i = 0;
          break label358;
          label1006:
          ((List)localObject4).add(localObject2);
          break label372;
          label1019:
          ((List)localObject4).add(localObject2);
          break label432;
          ((List)localObject4).add(localObject2);
          break label539;
          com.tencent.mm.kernel.g.aAi();
          i = ((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Ojr, Integer.valueOf(0))).intValue();
          Log.i("MicroMsg.SettingsPluginsUI", "SETTING_PLUGIN_SHOW_PAY_COLLECTION Flag :%s", new Object[] { Integer.valueOf(i) });
          if (i == 1) {
            ((List)localObject4).add(localObject2);
          }
        }
        localObject2 = new PluginPreference(this);
        ((PluginPreference)localObject2).jT("gh_579db1f2cf89", getString(2131761572));
        ((PluginPreference)localObject2).setTitle(((PluginPreference)localObject2).CZj);
        localObject3 = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn("gh_579db1f2cf89");
        if (localObject3 != null) {}
        for (bool1 = com.tencent.mm.contact.c.oR(((ax)localObject3).field_type);; bool1 = false)
        {
          if (bool1)
          {
            ((List)localObject1).add(localObject2);
            break;
          }
          i = ((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Ojt, Integer.valueOf(0))).intValue();
          Log.i("MicroMsg.SettingsPluginsUI", "addMiniShopHelperIfNeed, USERINFO_SETTING_PLUGIN_SHOW_MINI_SHOP_HELPER_FLAG_INT_SYNC: ".concat(String.valueOf(i)));
          if (1 != i) {
            break;
          }
          ((List)localObject4).add(localObject2);
          break;
          label1255:
          i = 0;
          break label719;
          localObject2 = new PreferenceSmallCategory(this);
          this.screen.c((Preference)localObject2);
          localObject2 = new PluginTextPreference(this);
          ((PluginTextPreference)localObject2).OZn = 2131691468;
          ((PluginTextPreference)localObject2).alN(2131765551);
          this.screen.c((Preference)localObject2);
          if (((List)localObject4).isEmpty())
          {
            localObject2 = new PluginEmptyTextPreference(this);
            this.screen.c((Preference)localObject2);
          }
          localObject4 = ((List)localObject4).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject3 = (PluginPreference)((Iterator)localObject4).next();
            ((PluginPreference)localObject3).sUb = 136;
            localObject2 = localObject1;
            if (str.contains(((PluginPreference)localObject3).CZi))
            {
              ((PluginPreference)localObject3).CZm = true;
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
            setSelection(this.screen.bmj(((Preference)localObject1).mKey));
          }
          AppMethodBeat.o(256591);
          return;
        }
      }
    }
  }
  
  public int getResourceId()
  {
    return 2132017280;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74338);
    setMMTitle(2131765536);
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
    com.tencent.mm.plugin.report.service.h.CyF.a(14098, new Object[] { Integer.valueOf(5) });
    com.tencent.mm.plugin.report.service.h.CyF.a(12846, new Object[] { Integer.valueOf(Ddt) });
    ay.a.iDq.aL("gh_43f2581f6fd6", "");
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
    String str = paramPreference.mKey;
    if ((str != null) && (str.equals("display_in_addr_book")))
    {
      boolean bool = ((CheckBoxPreference)paramf.bmg(str)).isChecked();
      com.tencent.mm.kernel.g.aAh().azQ().set(35, Boolean.valueOf(bool));
      AppMethodBeat.o(74341);
      return true;
    }
    if ((paramPreference instanceof PluginPreference))
    {
      paramf = ((PluginPreference)paramPreference).CZi;
      int i = -1;
      switch (paramf.hashCode())
      {
      default: 
        switch (i)
        {
        }
        break;
      }
      do
      {
        if (("feedsapp".equals(paramf)) && (this.Ddv)) {
          com.tencent.mm.kernel.g.aAh().azQ().set(-2046825369, Boolean.FALSE);
        }
        if ("gh_f0a92aa7146c".equals(paramf)) {
          com.tencent.mm.plugin.report.service.h.CyF.a(19540, new Object[] { Integer.valueOf(2) });
        }
        paramPreference = new Intent();
        if (("gh_43f2581f6fd6".equals(paramf)) && (this.Ddw))
        {
          a.exl();
          com.tencent.mm.plugin.newtips.a.i.TA(d.ADb);
          paramPreference.putExtra("key_from_wesport_plugin_newtips", true);
        }
        paramPreference.putExtra("Contact_User", paramf);
        com.tencent.mm.br.c.b(this, "profile", ".ui.ContactInfoUI", paramPreference);
        com.tencent.mm.plugin.report.service.h.CyF.a(12846, new Object[] { Ddu.get(paramf) });
        Log.i("MicroMsg.SettingsPluginsUI", "click id:%s, kvID:%d", new Object[] { paramf, Ddu.get(paramf) });
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
      } while (WeChatBrands.Business.Entries.HomePluginWePay.checkAvailable(this));
      AppMethodBeat.o(74341);
      return true;
    }
    AppMethodBeat.o(74341);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74339);
    super.onResume();
    Object localObject = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn("gh_f0a92aa7146c");
    if (localObject != null) {}
    for (boolean bool = com.tencent.mm.contact.c.oR(((ax)localObject).field_type);; bool = false)
    {
      Log.i("MicroMsg.SettingsPluginsUI", "needGetReceipAssistPlugin result：%s", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        com.tencent.mm.kernel.g.azz().a(2745, this);
        localObject = new com.tencent.mm.plugin.setting.model.g();
        com.tencent.mm.kernel.g.azz().a((q)localObject, 0);
      }
      if (1 != ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.soA, 0))
      {
        Log.i("MicroMsg.SettingsPluginsUI", "fetchMiniShopHelperPluginShowStatusIfNeed, not need");
        boY();
        AppMethodBeat.o(74339);
        return;
      }
      localObject = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn("gh_579db1f2cf89");
      if (localObject != null) {
        if (!com.tencent.mm.contact.c.oR(((ax)localObject).field_type)) {
          bool = true;
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.SettingsPluginsUI", "fetchMiniShopHelperPluginShowStatusIfNeed, needFetch: ".concat(String.valueOf(bool)));
        if (!bool) {
          break;
        }
        com.tencent.mm.kernel.g.azz().a(4158, this);
        localObject = new com.tencent.mm.plugin.setting.model.f();
        com.tencent.mm.kernel.g.azz().a((q)localObject, 0);
        break;
        bool = false;
        continue;
        bool = true;
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(256592);
    Log.i("MicroMsg.SettingsPluginsUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramq.getType());
    if ((paramq instanceof com.tencent.mm.plugin.setting.model.g))
    {
      com.tencent.mm.kernel.g.azz().b(2745, this);
      if ((paramInt1 == 0) || (paramInt2 == 0))
      {
        paramString = (com.tencent.mm.plugin.setting.model.g)paramq;
        if (paramString.CXL == null)
        {
          paramString = new btz();
          if (paramString.MaG != 1) {
            break label160;
          }
          Log.i("MicroMsg.SettingsPluginsUI", "need to show unstall ReceipAssistPlugin");
          com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ojr, Integer.valueOf(1));
        }
        for (;;)
        {
          boY();
          AppMethodBeat.o(256592);
          return;
          paramString = paramString.CXL;
          break;
          label160:
          com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ojr, Integer.valueOf(0));
        }
      }
      Log.e("MicroMsg.SettingsPluginsUI", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      AppMethodBeat.o(256592);
      return;
    }
    if ((paramq instanceof com.tencent.mm.plugin.setting.model.f))
    {
      com.tencent.mm.kernel.g.azz().b(4158, this);
      if ((paramInt1 == 0) || (paramInt2 == 0))
      {
        if (((com.tencent.mm.plugin.setting.model.f)paramq).CXK)
        {
          Log.i("MicroMsg.SettingsPluginsUI", "need to show unstall MiniShopHelperPlugin");
          com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ojt, Integer.valueOf(1));
        }
        for (;;)
        {
          boY();
          AppMethodBeat.o(256592);
          return;
          com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ojt, Integer.valueOf(0));
        }
      }
      Log.e("MicroMsg.SettingsPluginsUI", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    }
    AppMethodBeat.o(256592);
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