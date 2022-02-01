package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.newtips.a;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.azn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
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
  implements com.tencent.mm.al.g
{
  private static int wip;
  private static HashMap<String, Integer> wiq;
  private f screen;
  private boolean wir;
  private boolean wis;
  private boolean wit = false;
  
  static
  {
    AppMethodBeat.i(74342);
    wip = 1;
    wiq = new HashMap() {};
    AppMethodBeat.o(74342);
  }
  
  private void aJJ()
  {
    AppMethodBeat.i(186588);
    this.screen.removeAll();
    Object localObject1 = new PreferenceSmallCategory(this);
    this.screen.b((Preference)localObject1);
    Object localObject2 = new ArrayList();
    Object localObject3 = new ArrayList();
    boolean bool2 = u.arn();
    boolean bool1 = bool2;
    if (!bool2) {
      if (bt.getInt(com.tencent.mm.m.g.Zd().getValue("BindQQSwitch"), 1) != 1) {
        break label355;
      }
    }
    String str;
    PluginPreference localPluginPreference;
    label355:
    for (bool1 = true;; bool1 = false)
    {
      if (!bool1) {
        ad.i("MicroMsg.SettingsPluginsUI", "summerqq BindQQSwitch off");
      }
      if ((bool1) && (com.tencent.mm.bs.d.axB("qqmail"))) {
        t((List)localObject2, (List)localObject3);
      }
      if (com.tencent.mm.bs.d.axB("readerapp")) {
        u((List)localObject2, (List)localObject3);
      }
      v((List)localObject2, (List)localObject3);
      if (com.tencent.mm.bs.d.axB("masssend")) {
        w((List)localObject2, (List)localObject3);
      }
      q((List)localObject2, (List)localObject3);
      r((List)localObject2, (List)localObject3);
      s((List)localObject2, (List)localObject3);
      localObject1 = com.tencent.mm.m.g.Zd().getValue("LinkedinPluginClose");
      if ((bt.isNullOrNil((String)localObject1)) || (bt.getInt((String)localObject1, 0) == 0)) {
        ff((List)localObject2);
      }
      if (!((List)localObject2).isEmpty())
      {
        localObject1 = new PluginTextPreference(this);
        ((PluginTextPreference)localObject1).GfM = 2131691158;
        ((PluginTextPreference)localObject1).Ya(2131763361);
        this.screen.b((Preference)localObject1);
      }
      str = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fph, "");
      localObject1 = null;
      Iterator localIterator = ((List)localObject2).iterator();
      while (localIterator.hasNext())
      {
        localPluginPreference = (PluginPreference)localIterator.next();
        localPluginPreference.pSW = 255;
        localObject2 = localObject1;
        if (str.contains(localPluginPreference.wew))
        {
          localPluginPreference.weA = true;
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
    ((PluginTextPreference)localObject2).GfM = 2131691159;
    ((PluginTextPreference)localObject2).Ya(2131763369);
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
      localPluginPreference.pSW = 136;
      localObject2 = localObject1;
      if (str.contains(localPluginPreference.wew))
      {
        localPluginPreference.weA = true;
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
      setSelection(this.screen.aKm(((Preference)localObject1).mKey));
    }
    AppMethodBeat.o(186588);
  }
  
  private void doi()
  {
    AppMethodBeat.i(186592);
    com.tencent.mm.kernel.g.aeS().a(2745, this);
    com.tencent.mm.plugin.setting.model.e locale = new com.tencent.mm.plugin.setting.model.e();
    com.tencent.mm.kernel.g.aeS().a(locale, 0);
    AppMethodBeat.o(186592);
  }
  
  private void ff(List<PluginPreference> paramList)
  {
    int j = 1;
    AppMethodBeat.i(186598);
    PluginPreference localPluginPreference = new PluginPreference(this);
    int i;
    if (localPluginPreference.amT("linkedinplugin"))
    {
      localPluginPreference.setTitle(localPluginPreference.wex);
      if ((u.aqS() & 0x1000000) != 0) {
        break label94;
      }
      i = 1;
      if (bt.isNullOrNil((String)com.tencent.mm.kernel.g.afB().afk().get(286721, null))) {
        break label99;
      }
    }
    for (;;)
    {
      if ((i != 0) && (j != 0)) {
        paramList.add(localPluginPreference);
      }
      AppMethodBeat.o(186598);
      return;
      label94:
      i = 0;
      break;
      label99:
      j = 0;
    }
  }
  
  private void q(List<PluginPreference> paramList1, List<PluginPreference> paramList2)
  {
    AppMethodBeat.i(186589);
    PluginPreference localPluginPreference = new PluginPreference(this);
    localPluginPreference.iu("gh_43f2581f6fd6", getString(2131758621));
    localPluginPreference.setTitle(localPluginPreference.wex);
    if (((com.tencent.mm.plugin.sport.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.sport.a.b.class)).dFj()) {
      paramList1.add(localPluginPreference);
    }
    for (;;)
    {
      a.cWv();
      this.wis = com.tencent.mm.plugin.newtips.a.e.Il(com.tencent.mm.plugin.newtips.a.d.udR);
      localPluginPreference.weA = this.wis;
      AppMethodBeat.o(186589);
      return;
      paramList2.add(localPluginPreference);
    }
  }
  
  private void r(List<PluginPreference> paramList1, List<PluginPreference> paramList2)
  {
    AppMethodBeat.i(186590);
    PluginPreference localPluginPreference = new PluginPreference(this);
    localPluginPreference.iu("gh_3dfda90e39d6", getString(2131761999));
    localPluginPreference.setTitle(localPluginPreference.wex);
    af localaf = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().aHY("gh_3dfda90e39d6");
    boolean bool = false;
    if (localaf != null) {
      bool = com.tencent.mm.n.b.ls(localaf.field_type);
    }
    if (bool)
    {
      paramList1.add(localPluginPreference);
      AppMethodBeat.o(186590);
      return;
    }
    paramList2.add(localPluginPreference);
    AppMethodBeat.o(186590);
  }
  
  private void s(List<PluginPreference> paramList1, List<PluginPreference> paramList2)
  {
    AppMethodBeat.i(186591);
    PluginPreference localPluginPreference = new PluginPreference(this);
    localPluginPreference.iu("gh_f0a92aa7146c", getString(2131761998));
    localPluginPreference.setTitle(localPluginPreference.wex);
    af localaf = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().aHY("gh_f0a92aa7146c");
    boolean bool = false;
    if (localaf != null) {
      bool = com.tencent.mm.n.b.ls(localaf.field_type);
    }
    if (bool)
    {
      paramList1.add(localPluginPreference);
      AppMethodBeat.o(186591);
      return;
    }
    if (this.wit)
    {
      paramList2.add(localPluginPreference);
      AppMethodBeat.o(186591);
      return;
    }
    doi();
    AppMethodBeat.o(186591);
  }
  
  private void t(List<PluginPreference> paramList1, List<PluginPreference> paramList2)
  {
    AppMethodBeat.i(186594);
    PluginPreference localPluginPreference = new PluginPreference(this);
    if (localPluginPreference.amT("qqmail"))
    {
      localPluginPreference.setTitle(localPluginPreference.wex);
      if ((u.aqS() & 0x1) == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        paramList1.add(localPluginPreference);
        AppMethodBeat.o(186594);
        return;
      }
      if (com.tencent.mm.ax.b.azl()) {
        paramList2.add(localPluginPreference);
      }
    }
    AppMethodBeat.o(186594);
  }
  
  private void u(List<PluginPreference> paramList1, List<PluginPreference> paramList2)
  {
    AppMethodBeat.i(186595);
    PluginPreference localPluginPreference = new PluginPreference(this);
    if (localPluginPreference.amT("newsapp"))
    {
      localPluginPreference.setTitle(localPluginPreference.wex);
      if ((u.aqS() & 0x80000) == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        paramList1.add(localPluginPreference);
        AppMethodBeat.o(186595);
        return;
      }
      if (com.tencent.mm.ax.b.azl()) {
        paramList2.add(localPluginPreference);
      }
    }
    AppMethodBeat.o(186595);
  }
  
  private void v(List<PluginPreference> paramList1, List<PluginPreference> paramList2)
  {
    AppMethodBeat.i(186596);
    PluginPreference localPluginPreference = new PluginPreference(this);
    if (localPluginPreference.amT("facebookapp"))
    {
      localPluginPreference.setTitle(localPluginPreference.wex);
      if ((u.aqS() & 0x2000) == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        paramList1.add(localPluginPreference);
        AppMethodBeat.o(186596);
        return;
      }
      if (com.tencent.mm.ax.b.azk()) {
        paramList2.add(localPluginPreference);
      }
    }
    AppMethodBeat.o(186596);
  }
  
  private void w(List<PluginPreference> paramList1, List<PluginPreference> paramList2)
  {
    AppMethodBeat.i(186597);
    PluginPreference localPluginPreference = new PluginPreference(this);
    if (localPluginPreference.amT("masssendapp"))
    {
      localPluginPreference.setTitle(localPluginPreference.wex);
      if ((u.aqS() & 0x10000) == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        paramList1.add(localPluginPreference);
        AppMethodBeat.o(186597);
        return;
      }
      paramList2.add(localPluginPreference);
    }
    AppMethodBeat.o(186597);
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
    h.vKh.f(14098, new Object[] { Integer.valueOf(5) });
    h.vKh.f(12846, new Object[] { Integer.valueOf(wip) });
    ar.a.gMW.aB("gh_43f2581f6fd6", "");
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
      boolean bool = ((CheckBoxPreference)paramf.aKk(str)).isChecked();
      com.tencent.mm.kernel.g.afB().afk().set(35, Boolean.valueOf(bool));
      AppMethodBeat.o(74341);
      return true;
    }
    if ((paramPreference instanceof PluginPreference))
    {
      paramf = ((PluginPreference)paramPreference).wew;
      if (("feedsapp".equals(paramf)) && (this.wir)) {
        com.tencent.mm.kernel.g.afB().afk().set(-2046825369, Boolean.FALSE);
      }
      if ("gh_f0a92aa7146c".equals(paramf)) {
        h.vKh.f(19540, new Object[] { Integer.valueOf(2) });
      }
      paramPreference = new Intent();
      if (("gh_43f2581f6fd6".equals(paramf)) && (this.wis))
      {
        a.cWs();
        i.In(com.tencent.mm.plugin.newtips.a.d.udR);
        paramPreference.putExtra("key_from_wesport_plugin_newtips", true);
      }
      paramPreference.putExtra("Contact_User", paramf);
      com.tencent.mm.bs.d.b(this, "profile", ".ui.ContactInfoUI", paramPreference);
      h.vKh.f(12846, new Object[] { wiq.get(paramf) });
      ad.i("MicroMsg.SettingsPluginsUI", "click id:%s, kvID:%d", new Object[] { paramf, wiq.get(paramf) });
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
    aJJ();
    AppMethodBeat.o(74339);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(186593);
    ad.i("MicroMsg.SettingsPluginsUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramn.getType());
    if ((paramn instanceof com.tencent.mm.plugin.setting.model.e))
    {
      this.wit = true;
      com.tencent.mm.kernel.g.aeS().b(2745, this);
      if ((paramInt1 == 0) || (paramInt2 == 0))
      {
        paramString = (com.tencent.mm.plugin.setting.model.e)paramn;
        if (paramString.wcV == null) {}
        for (paramString = new azn();; paramString = paramString.wcV)
        {
          if (paramString.DxV == 1)
          {
            ad.i("MicroMsg.SettingsPluginsUI", "need to show unstall tReceipAssistPlugin");
            aJJ();
          }
          AppMethodBeat.o(186593);
          return;
        }
      }
      ad.e("MicroMsg.SettingsPluginsUI", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    }
    AppMethodBeat.o(186593);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsPluginsUI
 * JD-Core Version:    0.7.0.1
 */