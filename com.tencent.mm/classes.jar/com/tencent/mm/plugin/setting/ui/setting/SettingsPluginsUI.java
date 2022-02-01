package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.newtips.a;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bdf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
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
  implements com.tencent.mm.ak.g
{
  private static int xtH;
  private static HashMap<String, Integer> xtI;
  private f screen;
  private boolean xtJ;
  private boolean xtK;
  private boolean xtL = false;
  
  static
  {
    AppMethodBeat.i(74342);
    xtH = 1;
    xtI = new HashMap() {};
    AppMethodBeat.o(74342);
  }
  
  private void aQA()
  {
    AppMethodBeat.i(191056);
    this.screen.removeAll();
    Object localObject1 = new PreferenceSmallCategory(this);
    this.screen.b((Preference)localObject1);
    Object localObject2 = new ArrayList();
    Object localObject3 = new ArrayList();
    boolean bool2 = u.ayd();
    boolean bool1 = bool2;
    if (!bool2) {
      if (bs.getInt(com.tencent.mm.m.g.ZY().getValue("BindQQSwitch"), 1) != 1) {
        break label355;
      }
    }
    String str;
    PluginPreference localPluginPreference;
    label355:
    for (bool1 = true;; bool1 = false)
    {
      if (!bool1) {
        ac.i("MicroMsg.SettingsPluginsUI", "summerqq BindQQSwitch off");
      }
      if ((bool1) && (com.tencent.mm.br.d.aCT("qqmail"))) {
        s((List)localObject2, (List)localObject3);
      }
      if (com.tencent.mm.br.d.aCT("readerapp")) {
        t((List)localObject2, (List)localObject3);
      }
      u((List)localObject2, (List)localObject3);
      if (com.tencent.mm.br.d.aCT("masssend")) {
        v((List)localObject2, (List)localObject3);
      }
      p((List)localObject2, (List)localObject3);
      q((List)localObject2, (List)localObject3);
      r((List)localObject2, (List)localObject3);
      localObject1 = com.tencent.mm.m.g.ZY().getValue("LinkedinPluginClose");
      if ((bs.isNullOrNil((String)localObject1)) || (bs.getInt((String)localObject1, 0) == 0)) {
        fn((List)localObject2);
      }
      if (!((List)localObject2).isEmpty())
      {
        localObject1 = new PluginTextPreference(this);
        ((PluginTextPreference)localObject1).HFB = 2131691158;
        ((PluginTextPreference)localObject1).aal(2131763361);
        this.screen.b((Preference)localObject1);
      }
      str = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GMX, "");
      localObject1 = null;
      Iterator localIterator = ((List)localObject2).iterator();
      while (localIterator.hasNext())
      {
        localPluginPreference = (PluginPreference)localIterator.next();
        localPluginPreference.qBD = 255;
        localObject2 = localObject1;
        if (str.contains(localPluginPreference.xpK))
        {
          localPluginPreference.xpO = true;
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
    ((PluginTextPreference)localObject2).HFB = 2131691159;
    ((PluginTextPreference)localObject2).aal(2131763369);
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
      localPluginPreference.qBD = 136;
      localObject2 = localObject1;
      if (str.contains(localPluginPreference.xpK))
      {
        localPluginPreference.xpO = true;
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
      setSelection(this.screen.aPP(((Preference)localObject1).mKey));
    }
    AppMethodBeat.o(191056);
  }
  
  private void dCs()
  {
    AppMethodBeat.i(191060);
    com.tencent.mm.kernel.g.agi().a(2745, this);
    com.tencent.mm.plugin.setting.model.e locale = new com.tencent.mm.plugin.setting.model.e();
    com.tencent.mm.kernel.g.agi().a(locale, 0);
    AppMethodBeat.o(191060);
  }
  
  private void fn(List<PluginPreference> paramList)
  {
    int j = 1;
    AppMethodBeat.i(191066);
    PluginPreference localPluginPreference = new PluginPreference(this);
    int i;
    if (localPluginPreference.asc("linkedinplugin"))
    {
      localPluginPreference.setTitle(localPluginPreference.xpL);
      if ((u.axI() & 0x1000000) != 0) {
        break label94;
      }
      i = 1;
      if (bs.isNullOrNil((String)com.tencent.mm.kernel.g.agR().agA().get(286721, null))) {
        break label99;
      }
    }
    for (;;)
    {
      if ((i != 0) && (j != 0)) {
        paramList.add(localPluginPreference);
      }
      AppMethodBeat.o(191066);
      return;
      label94:
      i = 0;
      break;
      label99:
      j = 0;
    }
  }
  
  private void p(List<PluginPreference> paramList1, List<PluginPreference> paramList2)
  {
    AppMethodBeat.i(191057);
    PluginPreference localPluginPreference = new PluginPreference(this);
    localPluginPreference.iQ("gh_43f2581f6fd6", getString(2131758621));
    localPluginPreference.setTitle(localPluginPreference.xpL);
    if (((com.tencent.mm.plugin.sport.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.sport.a.b.class)).dTK()) {
      paramList1.add(localPluginPreference);
    }
    for (;;)
    {
      a.dke();
      this.xtK = com.tencent.mm.plugin.newtips.a.e.Kk(com.tencent.mm.plugin.newtips.a.d.vmQ);
      localPluginPreference.xpO = this.xtK;
      AppMethodBeat.o(191057);
      return;
      paramList2.add(localPluginPreference);
    }
  }
  
  private void q(List<PluginPreference> paramList1, List<PluginPreference> paramList2)
  {
    AppMethodBeat.i(191058);
    PluginPreference localPluginPreference = new PluginPreference(this);
    localPluginPreference.iQ("gh_3dfda90e39d6", getString(2131761999));
    localPluginPreference.setTitle(localPluginPreference.xpL);
    ai localai = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNt("gh_3dfda90e39d6");
    boolean bool = false;
    if (localai != null) {
      bool = com.tencent.mm.n.b.ln(localai.field_type);
    }
    if (bool)
    {
      paramList1.add(localPluginPreference);
      AppMethodBeat.o(191058);
      return;
    }
    paramList2.add(localPluginPreference);
    AppMethodBeat.o(191058);
  }
  
  private void r(List<PluginPreference> paramList1, List<PluginPreference> paramList2)
  {
    AppMethodBeat.i(191059);
    PluginPreference localPluginPreference = new PluginPreference(this);
    localPluginPreference.iQ("gh_f0a92aa7146c", getString(2131761998));
    localPluginPreference.setTitle(localPluginPreference.xpL);
    ai localai = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNt("gh_f0a92aa7146c");
    boolean bool = false;
    if (localai != null) {
      bool = com.tencent.mm.n.b.ln(localai.field_type);
    }
    if (bool)
    {
      paramList1.add(localPluginPreference);
      AppMethodBeat.o(191059);
      return;
    }
    if (this.xtL)
    {
      paramList2.add(localPluginPreference);
      AppMethodBeat.o(191059);
      return;
    }
    dCs();
    AppMethodBeat.o(191059);
  }
  
  private void s(List<PluginPreference> paramList1, List<PluginPreference> paramList2)
  {
    AppMethodBeat.i(191062);
    PluginPreference localPluginPreference = new PluginPreference(this);
    if (localPluginPreference.asc("qqmail"))
    {
      localPluginPreference.setTitle(localPluginPreference.xpL);
      if ((u.axI() & 0x1) == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        paramList1.add(localPluginPreference);
        AppMethodBeat.o(191062);
        return;
      }
      if (com.tencent.mm.aw.b.aGc()) {
        paramList2.add(localPluginPreference);
      }
    }
    AppMethodBeat.o(191062);
  }
  
  private void t(List<PluginPreference> paramList1, List<PluginPreference> paramList2)
  {
    AppMethodBeat.i(191063);
    PluginPreference localPluginPreference = new PluginPreference(this);
    if (localPluginPreference.asc("newsapp"))
    {
      localPluginPreference.setTitle(localPluginPreference.xpL);
      if ((u.axI() & 0x80000) == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        paramList1.add(localPluginPreference);
        AppMethodBeat.o(191063);
        return;
      }
      if (com.tencent.mm.aw.b.aGc()) {
        paramList2.add(localPluginPreference);
      }
    }
    AppMethodBeat.o(191063);
  }
  
  private void u(List<PluginPreference> paramList1, List<PluginPreference> paramList2)
  {
    AppMethodBeat.i(191064);
    PluginPreference localPluginPreference = new PluginPreference(this);
    if (localPluginPreference.asc("facebookapp"))
    {
      localPluginPreference.setTitle(localPluginPreference.xpL);
      if ((u.axI() & 0x2000) == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        paramList1.add(localPluginPreference);
        AppMethodBeat.o(191064);
        return;
      }
      if (com.tencent.mm.aw.b.aGb()) {
        paramList2.add(localPluginPreference);
      }
    }
    AppMethodBeat.o(191064);
  }
  
  private void v(List<PluginPreference> paramList1, List<PluginPreference> paramList2)
  {
    AppMethodBeat.i(191065);
    PluginPreference localPluginPreference = new PluginPreference(this);
    if (localPluginPreference.asc("masssendapp"))
    {
      localPluginPreference.setTitle(localPluginPreference.xpL);
      if ((u.axI() & 0x10000) == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        paramList1.add(localPluginPreference);
        AppMethodBeat.o(191065);
        return;
      }
      paramList2.add(localPluginPreference);
    }
    AppMethodBeat.o(191065);
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
    h.wUl.f(14098, new Object[] { Integer.valueOf(5) });
    h.wUl.f(12846, new Object[] { Integer.valueOf(xtH) });
    ar.a.hnw.aJ("gh_43f2581f6fd6", "");
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
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74341);
    String str = paramPreference.mKey;
    if ((str != null) && (str.equals("display_in_addr_book")))
    {
      boolean bool = ((CheckBoxPreference)paramf.aPN(str)).isChecked();
      com.tencent.mm.kernel.g.agR().agA().set(35, Boolean.valueOf(bool));
      AppMethodBeat.o(74341);
      return true;
    }
    if ((paramPreference instanceof PluginPreference))
    {
      paramf = ((PluginPreference)paramPreference).xpK;
      if (("feedsapp".equals(paramf)) && (this.xtJ)) {
        com.tencent.mm.kernel.g.agR().agA().set(-2046825369, Boolean.FALSE);
      }
      if ("gh_f0a92aa7146c".equals(paramf)) {
        h.wUl.f(19540, new Object[] { Integer.valueOf(2) });
      }
      paramPreference = new Intent();
      if (("gh_43f2581f6fd6".equals(paramf)) && (this.xtK))
      {
        a.dkb();
        i.Km(com.tencent.mm.plugin.newtips.a.d.vmQ);
        paramPreference.putExtra("key_from_wesport_plugin_newtips", true);
      }
      paramPreference.putExtra("Contact_User", paramf);
      com.tencent.mm.br.d.b(this, "profile", ".ui.ContactInfoUI", paramPreference);
      h.wUl.f(12846, new Object[] { xtI.get(paramf) });
      ac.i("MicroMsg.SettingsPluginsUI", "click id:%s, kvID:%d", new Object[] { paramf, xtI.get(paramf) });
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
    aQA();
    AppMethodBeat.o(74339);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(191061);
    ac.i("MicroMsg.SettingsPluginsUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramn.getType());
    if ((paramn instanceof com.tencent.mm.plugin.setting.model.e))
    {
      this.xtL = true;
      com.tencent.mm.kernel.g.agi().b(2745, this);
      if ((paramInt1 == 0) || (paramInt2 == 0))
      {
        paramString = (com.tencent.mm.plugin.setting.model.e)paramn;
        if (paramString.xoj == null) {}
        for (paramString = new bdf();; paramString = paramString.xoj)
        {
          if (paramString.ETr == 1)
          {
            ac.i("MicroMsg.SettingsPluginsUI", "need to show unstall tReceipAssistPlugin");
            aQA();
          }
          AppMethodBeat.o(191061);
          return;
        }
      }
      ac.e("MicroMsg.SettingsPluginsUI", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    }
    AppMethodBeat.o(191061);
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