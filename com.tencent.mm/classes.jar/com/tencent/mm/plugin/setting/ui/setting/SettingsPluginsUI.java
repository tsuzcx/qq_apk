package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.newtips.a;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.protocal.protobuf.bib;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
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
  implements com.tencent.mm.ak.f
{
  private static int yYD;
  private static HashMap<String, Integer> yYE;
  private com.tencent.mm.ui.base.preference.f screen;
  private boolean yYF;
  private boolean yYG;
  
  static
  {
    AppMethodBeat.i(74342);
    yYD = 1;
    yYE = new HashMap() {};
    AppMethodBeat.o(74342);
  }
  
  private void aUl()
  {
    AppMethodBeat.i(190411);
    this.screen.removeAll();
    Object localObject1 = new PreferenceSmallCategory(this);
    this.screen.b((Preference)localObject1);
    Object localObject2 = new ArrayList();
    Object localObject3 = new ArrayList();
    boolean bool2 = v.aBp();
    boolean bool1 = bool2;
    if (!bool2) {
      if (bu.getInt(com.tencent.mm.n.g.acL().getValue("BindQQSwitch"), 1) != 1) {
        break label355;
      }
    }
    String str;
    PluginPreference localPluginPreference;
    label355:
    for (bool1 = true;; bool1 = false)
    {
      if (!bool1) {
        ae.i("MicroMsg.SettingsPluginsUI", "summerqq BindQQSwitch off");
      }
      if ((bool1) && (com.tencent.mm.br.d.aJN("qqmail"))) {
        t((List)localObject2, (List)localObject3);
      }
      if (com.tencent.mm.br.d.aJN("readerapp")) {
        u((List)localObject2, (List)localObject3);
      }
      v((List)localObject2, (List)localObject3);
      if (com.tencent.mm.br.d.aJN("masssend")) {
        w((List)localObject2, (List)localObject3);
      }
      q((List)localObject2, (List)localObject3);
      r((List)localObject2, (List)localObject3);
      s((List)localObject2, (List)localObject3);
      localObject1 = com.tencent.mm.n.g.acL().getValue("LinkedinPluginClose");
      if ((bu.isNullOrNil((String)localObject1)) || (bu.getInt((String)localObject1, 0) == 0)) {
        fI((List)localObject2);
      }
      if (!((List)localObject2).isEmpty())
      {
        localObject1 = new PluginTextPreference(this);
        ((PluginTextPreference)localObject1).JOh = 2131691158;
        ((PluginTextPreference)localObject1).adc(2131763361);
        this.screen.b((Preference)localObject1);
      }
      str = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ITN, "");
      localObject1 = null;
      Iterator localIterator = ((List)localObject2).iterator();
      while (localIterator.hasNext())
      {
        localPluginPreference = (PluginPreference)localIterator.next();
        localPluginPreference.rty = 255;
        localObject2 = localObject1;
        if (str.contains(localPluginPreference.yUs))
        {
          localPluginPreference.yUw = true;
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = localPluginPreference;
          }
        }
        this.screen.b(localPluginPreference);
        localObject1 = localObject2;
      }
    }
    localObject2 = new PreferenceSmallCategory(this);
    this.screen.b((Preference)localObject2);
    localObject2 = new PluginTextPreference(this);
    ((PluginTextPreference)localObject2).JOh = 2131691159;
    ((PluginTextPreference)localObject2).adc(2131763369);
    this.screen.b((Preference)localObject2);
    if (((List)localObject3).isEmpty())
    {
      localObject2 = new PluginEmptyTextPreference(this);
      this.screen.b((Preference)localObject2);
    }
    localObject3 = ((List)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localPluginPreference = (PluginPreference)((Iterator)localObject3).next();
      localPluginPreference.rty = 136;
      localObject2 = localObject1;
      if (str.contains(localPluginPreference.yUs))
      {
        localPluginPreference.yUw = true;
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = localPluginPreference;
        }
      }
      this.screen.b(localPluginPreference);
      localObject1 = localObject2;
    }
    localObject2 = new PreferenceSmallCategory(this);
    this.screen.b((Preference)localObject2);
    if (localObject1 != null) {
      setSelection(this.screen.aXg(((Preference)localObject1).mKey));
    }
    AppMethodBeat.o(190411);
  }
  
  private void fI(List<PluginPreference> paramList)
  {
    int j = 1;
    AppMethodBeat.i(190420);
    PluginPreference localPluginPreference = new PluginPreference(this);
    int i;
    if (localPluginPreference.ays("linkedinplugin"))
    {
      localPluginPreference.setTitle(localPluginPreference.yUt);
      if ((v.aAO() & 0x1000000) != 0) {
        break label92;
      }
      i = 1;
      if (bu.isNullOrNil((String)com.tencent.mm.kernel.g.ajR().ajA().get(286721, null))) {
        break label97;
      }
    }
    for (;;)
    {
      if ((i != 0) && (j != 0)) {
        paramList.add(localPluginPreference);
      }
      AppMethodBeat.o(190420);
      return;
      label92:
      i = 0;
      break;
      label97:
      j = 0;
    }
  }
  
  private void q(List<PluginPreference> paramList1, List<PluginPreference> paramList2)
  {
    AppMethodBeat.i(190412);
    PluginPreference localPluginPreference = new PluginPreference(this);
    localPluginPreference.jh("gh_43f2581f6fd6", getString(2131758621));
    localPluginPreference.setTitle(localPluginPreference.yUt);
    if (((com.tencent.mm.plugin.sport.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.sport.a.b.class)).ejG()) {
      paramList1.add(localPluginPreference);
    }
    for (;;)
    {
      a.dxG();
      this.yYG = com.tencent.mm.plugin.newtips.a.e.Mr(com.tencent.mm.plugin.newtips.a.d.wHR);
      localPluginPreference.yUw = this.yYG;
      AppMethodBeat.o(190412);
      return;
      paramList2.add(localPluginPreference);
    }
  }
  
  private void r(List<PluginPreference> paramList1, List<PluginPreference> paramList2)
  {
    AppMethodBeat.i(190413);
    PluginPreference localPluginPreference = new PluginPreference(this);
    localPluginPreference.jh("gh_3dfda90e39d6", getString(2131761999));
    localPluginPreference.setTitle(localPluginPreference.yUt);
    an localan = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH("gh_3dfda90e39d6");
    boolean bool = false;
    if (localan != null) {
      bool = c.lO(localan.field_type);
    }
    if (bool)
    {
      paramList1.add(localPluginPreference);
      AppMethodBeat.o(190413);
      return;
    }
    paramList2.add(localPluginPreference);
    AppMethodBeat.o(190413);
  }
  
  private void s(List<PluginPreference> paramList1, List<PluginPreference> paramList2)
  {
    AppMethodBeat.i(190414);
    PluginPreference localPluginPreference = new PluginPreference(this);
    localPluginPreference.jh("gh_f0a92aa7146c", getString(2131761998));
    localPluginPreference.setTitle(localPluginPreference.yUt);
    an localan = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH("gh_f0a92aa7146c");
    if (localan != null) {}
    for (boolean bool = c.lO(localan.field_type);; bool = false)
    {
      if (bool)
      {
        paramList1.add(localPluginPreference);
        AppMethodBeat.o(190414);
        return;
      }
      com.tencent.mm.kernel.g.ajS();
      int i = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.JaL, Integer.valueOf(0))).intValue();
      ae.i("MicroMsg.SettingsPluginsUI", "SETTING_PLUGIN_SHOW_PAY_COLLECTION Flag :%s", new Object[] { Integer.valueOf(i) });
      if (i == 1) {
        paramList2.add(localPluginPreference);
      }
      AppMethodBeat.o(190414);
      return;
    }
  }
  
  private void t(List<PluginPreference> paramList1, List<PluginPreference> paramList2)
  {
    AppMethodBeat.i(190416);
    PluginPreference localPluginPreference = new PluginPreference(this);
    if (localPluginPreference.ays("qqmail"))
    {
      localPluginPreference.setTitle(localPluginPreference.yUt);
      if ((v.aAO() & 0x1) == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        paramList1.add(localPluginPreference);
        AppMethodBeat.o(190416);
        return;
      }
      if (com.tencent.mm.aw.b.aJD()) {
        paramList2.add(localPluginPreference);
      }
    }
    AppMethodBeat.o(190416);
  }
  
  private void u(List<PluginPreference> paramList1, List<PluginPreference> paramList2)
  {
    AppMethodBeat.i(190417);
    PluginPreference localPluginPreference = new PluginPreference(this);
    if (localPluginPreference.ays("newsapp"))
    {
      localPluginPreference.setTitle(localPluginPreference.yUt);
      if ((v.aAO() & 0x80000) == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        paramList1.add(localPluginPreference);
        AppMethodBeat.o(190417);
        return;
      }
      if (com.tencent.mm.aw.b.aJD()) {
        paramList2.add(localPluginPreference);
      }
    }
    AppMethodBeat.o(190417);
  }
  
  private void v(List<PluginPreference> paramList1, List<PluginPreference> paramList2)
  {
    AppMethodBeat.i(190418);
    PluginPreference localPluginPreference = new PluginPreference(this);
    if (localPluginPreference.ays("facebookapp"))
    {
      localPluginPreference.setTitle(localPluginPreference.yUt);
      if ((v.aAO() & 0x2000) == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        paramList1.add(localPluginPreference);
        AppMethodBeat.o(190418);
        return;
      }
      if (com.tencent.mm.aw.b.aJC()) {
        paramList2.add(localPluginPreference);
      }
    }
    AppMethodBeat.o(190418);
  }
  
  private void w(List<PluginPreference> paramList1, List<PluginPreference> paramList2)
  {
    AppMethodBeat.i(190419);
    PluginPreference localPluginPreference = new PluginPreference(this);
    if (localPluginPreference.ays("masssendapp"))
    {
      localPluginPreference.setTitle(localPluginPreference.yUt);
      if ((v.aAO() & 0x10000) == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        paramList1.add(localPluginPreference);
        AppMethodBeat.o(190419);
        return;
      }
      paramList2.add(localPluginPreference);
    }
    AppMethodBeat.o(190419);
  }
  
  public int getResourceId()
  {
    return 2131951735;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74338);
    setMMTitle(2131763354);
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
    com.tencent.mm.plugin.report.service.g.yxI.f(14098, new Object[] { Integer.valueOf(5) });
    com.tencent.mm.plugin.report.service.g.yxI.f(12846, new Object[] { Integer.valueOf(yYD) });
    au.a.hIG.aJ("gh_43f2581f6fd6", "");
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
      boolean bool = ((CheckBoxPreference)paramf.aXe(str)).isChecked();
      com.tencent.mm.kernel.g.ajR().ajA().set(35, Boolean.valueOf(bool));
      AppMethodBeat.o(74341);
      return true;
    }
    if ((paramPreference instanceof PluginPreference))
    {
      paramf = ((PluginPreference)paramPreference).yUs;
      if (("feedsapp".equals(paramf)) && (this.yYF)) {
        com.tencent.mm.kernel.g.ajR().ajA().set(-2046825369, Boolean.FALSE);
      }
      if ("gh_f0a92aa7146c".equals(paramf)) {
        com.tencent.mm.plugin.report.service.g.yxI.f(19540, new Object[] { Integer.valueOf(2) });
      }
      paramPreference = new Intent();
      if (("gh_43f2581f6fd6".equals(paramf)) && (this.yYG))
      {
        a.dxD();
        i.Mt(com.tencent.mm.plugin.newtips.a.d.wHR);
        paramPreference.putExtra("key_from_wesport_plugin_newtips", true);
      }
      paramPreference.putExtra("Contact_User", paramf);
      com.tencent.mm.br.d.b(this, "profile", ".ui.ContactInfoUI", paramPreference);
      com.tencent.mm.plugin.report.service.g.yxI.f(12846, new Object[] { yYE.get(paramf) });
      ae.i("MicroMsg.SettingsPluginsUI", "click id:%s, kvID:%d", new Object[] { paramf, yYE.get(paramf) });
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
    Object localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH("gh_f0a92aa7146c");
    if (localObject != null) {}
    for (boolean bool = c.lO(((aw)localObject).field_type);; bool = false)
    {
      ae.i("MicroMsg.SettingsPluginsUI", "needGetReceipAssistPlugin result：%s", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        com.tencent.mm.kernel.g.ajj().a(2745, this);
        localObject = new com.tencent.mm.plugin.setting.model.f();
        com.tencent.mm.kernel.g.ajj().a((n)localObject, 0);
      }
      aUl();
      AppMethodBeat.o(74339);
      return;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(190415);
    ae.i("MicroMsg.SettingsPluginsUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramn.getType());
    if ((paramn instanceof com.tencent.mm.plugin.setting.model.f))
    {
      com.tencent.mm.kernel.g.ajj().b(2745, this);
      if ((paramInt1 == 0) || (paramInt2 == 0))
      {
        paramString = (com.tencent.mm.plugin.setting.model.f)paramn;
        if (paramString.yST == null)
        {
          paramString = new bib();
          if (paramString.GWl != 1) {
            break label160;
          }
          ae.i("MicroMsg.SettingsPluginsUI", "need to show unstall ReceipAssistPlugin");
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.JaL, Integer.valueOf(1));
        }
        for (;;)
        {
          aUl();
          AppMethodBeat.o(190415);
          return;
          paramString = paramString.yST;
          break;
          label160:
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.JaL, Integer.valueOf(0));
        }
      }
      ae.e("MicroMsg.SettingsPluginsUI", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    }
    AppMethodBeat.o(190415);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsPluginsUI
 * JD-Core Version:    0.7.0.1
 */