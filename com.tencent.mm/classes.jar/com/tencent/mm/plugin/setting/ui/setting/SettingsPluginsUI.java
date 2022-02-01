package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.newtips.a;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.protocal.protobuf.bhl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
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
  implements com.tencent.mm.al.f
{
  private static int yIt;
  private static HashMap<String, Integer> yIu;
  private com.tencent.mm.ui.base.preference.f screen;
  private boolean yIv;
  private boolean yIw;
  
  static
  {
    AppMethodBeat.i(74342);
    yIt = 1;
    yIu = new HashMap() {};
    AppMethodBeat.o(74342);
  }
  
  private void aTM()
  {
    AppMethodBeat.i(221039);
    this.screen.removeAll();
    Object localObject1 = new PreferenceSmallCategory(this);
    this.screen.b((Preference)localObject1);
    Object localObject2 = new ArrayList();
    Object localObject3 = new ArrayList();
    boolean bool2 = u.aAZ();
    boolean bool1 = bool2;
    if (!bool2) {
      if (bt.getInt(com.tencent.mm.n.g.acA().getValue("BindQQSwitch"), 1) != 1) {
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
      if ((bool1) && (com.tencent.mm.bs.d.aIu("qqmail"))) {
        t((List)localObject2, (List)localObject3);
      }
      if (com.tencent.mm.bs.d.aIu("readerapp")) {
        u((List)localObject2, (List)localObject3);
      }
      v((List)localObject2, (List)localObject3);
      if (com.tencent.mm.bs.d.aIu("masssend")) {
        w((List)localObject2, (List)localObject3);
      }
      q((List)localObject2, (List)localObject3);
      r((List)localObject2, (List)localObject3);
      s((List)localObject2, (List)localObject3);
      localObject1 = com.tencent.mm.n.g.acA().getValue("LinkedinPluginClose");
      if ((bt.isNullOrNil((String)localObject1)) || (bt.getInt((String)localObject1, 0) == 0)) {
        fA((List)localObject2);
      }
      if (!((List)localObject2).isEmpty())
      {
        localObject1 = new PluginTextPreference(this);
        ((PluginTextPreference)localObject1).Jts = 2131691158;
        ((PluginTextPreference)localObject1).acv(2131763361);
        this.screen.b((Preference)localObject1);
      }
      str = (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Izo, "");
      localObject1 = null;
      Iterator localIterator = ((List)localObject2).iterator();
      while (localIterator.hasNext())
      {
        localPluginPreference = (PluginPreference)localIterator.next();
        localPluginPreference.rlt = 255;
        localObject2 = localObject1;
        if (str.contains(localPluginPreference.yEn))
        {
          localPluginPreference.yEr = true;
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
    ((PluginTextPreference)localObject2).Jts = 2131691159;
    ((PluginTextPreference)localObject2).acv(2131763369);
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
      localPluginPreference.rlt = 136;
      localObject2 = localObject1;
      if (str.contains(localPluginPreference.yEn))
      {
        localPluginPreference.yEr = true;
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
      setSelection(this.screen.aVF(((Preference)localObject1).mKey));
    }
    AppMethodBeat.o(221039);
  }
  
  private void fA(List<PluginPreference> paramList)
  {
    int j = 1;
    AppMethodBeat.i(221048);
    PluginPreference localPluginPreference = new PluginPreference(this);
    int i;
    if (localPluginPreference.axc("linkedinplugin"))
    {
      localPluginPreference.setTitle(localPluginPreference.yEo);
      if ((u.aAy() & 0x1000000) != 0) {
        break label92;
      }
      i = 1;
      if (bt.isNullOrNil((String)com.tencent.mm.kernel.g.ajC().ajl().get(286721, null))) {
        break label97;
      }
    }
    for (;;)
    {
      if ((i != 0) && (j != 0)) {
        paramList.add(localPluginPreference);
      }
      AppMethodBeat.o(221048);
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
    AppMethodBeat.i(221040);
    PluginPreference localPluginPreference = new PluginPreference(this);
    localPluginPreference.jb("gh_43f2581f6fd6", getString(2131758621));
    localPluginPreference.setTitle(localPluginPreference.yEo);
    if (((com.tencent.mm.plugin.sport.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.sport.a.b.class)).efY()) {
      paramList1.add(localPluginPreference);
    }
    for (;;)
    {
      a.duq();
      this.yIw = com.tencent.mm.plugin.newtips.a.e.LM(com.tencent.mm.plugin.newtips.a.d.wsi);
      localPluginPreference.yEr = this.yIw;
      AppMethodBeat.o(221040);
      return;
      paramList2.add(localPluginPreference);
    }
  }
  
  private void r(List<PluginPreference> paramList1, List<PluginPreference> paramList2)
  {
    AppMethodBeat.i(221041);
    PluginPreference localPluginPreference = new PluginPreference(this);
    localPluginPreference.jb("gh_3dfda90e39d6", getString(2131761999));
    localPluginPreference.setTitle(localPluginPreference.yEo);
    am localam = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf("gh_3dfda90e39d6");
    boolean bool = false;
    if (localam != null) {
      bool = com.tencent.mm.o.b.lM(localam.field_type);
    }
    if (bool)
    {
      paramList1.add(localPluginPreference);
      AppMethodBeat.o(221041);
      return;
    }
    paramList2.add(localPluginPreference);
    AppMethodBeat.o(221041);
  }
  
  private void s(List<PluginPreference> paramList1, List<PluginPreference> paramList2)
  {
    AppMethodBeat.i(221042);
    PluginPreference localPluginPreference = new PluginPreference(this);
    localPluginPreference.jb("gh_f0a92aa7146c", getString(2131761998));
    localPluginPreference.setTitle(localPluginPreference.yEo);
    am localam = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf("gh_f0a92aa7146c");
    if (localam != null) {}
    for (boolean bool = com.tencent.mm.o.b.lM(localam.field_type);; bool = false)
    {
      if (bool)
      {
        paramList1.add(localPluginPreference);
        AppMethodBeat.o(221042);
        return;
      }
      com.tencent.mm.kernel.g.ajD();
      int i = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IGl, Integer.valueOf(0))).intValue();
      ad.i("MicroMsg.SettingsPluginsUI", "SETTING_PLUGIN_SHOW_PAY_COLLECTION Flag :%s", new Object[] { Integer.valueOf(i) });
      if (i == 1) {
        paramList2.add(localPluginPreference);
      }
      AppMethodBeat.o(221042);
      return;
    }
  }
  
  private void t(List<PluginPreference> paramList1, List<PluginPreference> paramList2)
  {
    AppMethodBeat.i(221044);
    PluginPreference localPluginPreference = new PluginPreference(this);
    if (localPluginPreference.axc("qqmail"))
    {
      localPluginPreference.setTitle(localPluginPreference.yEo);
      if ((u.aAy() & 0x1) == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        paramList1.add(localPluginPreference);
        AppMethodBeat.o(221044);
        return;
      }
      if (com.tencent.mm.ax.b.aJl()) {
        paramList2.add(localPluginPreference);
      }
    }
    AppMethodBeat.o(221044);
  }
  
  private void u(List<PluginPreference> paramList1, List<PluginPreference> paramList2)
  {
    AppMethodBeat.i(221045);
    PluginPreference localPluginPreference = new PluginPreference(this);
    if (localPluginPreference.axc("newsapp"))
    {
      localPluginPreference.setTitle(localPluginPreference.yEo);
      if ((u.aAy() & 0x80000) == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        paramList1.add(localPluginPreference);
        AppMethodBeat.o(221045);
        return;
      }
      if (com.tencent.mm.ax.b.aJl()) {
        paramList2.add(localPluginPreference);
      }
    }
    AppMethodBeat.o(221045);
  }
  
  private void v(List<PluginPreference> paramList1, List<PluginPreference> paramList2)
  {
    AppMethodBeat.i(221046);
    PluginPreference localPluginPreference = new PluginPreference(this);
    if (localPluginPreference.axc("facebookapp"))
    {
      localPluginPreference.setTitle(localPluginPreference.yEo);
      if ((u.aAy() & 0x2000) == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        paramList1.add(localPluginPreference);
        AppMethodBeat.o(221046);
        return;
      }
      if (com.tencent.mm.ax.b.aJk()) {
        paramList2.add(localPluginPreference);
      }
    }
    AppMethodBeat.o(221046);
  }
  
  private void w(List<PluginPreference> paramList1, List<PluginPreference> paramList2)
  {
    AppMethodBeat.i(221047);
    PluginPreference localPluginPreference = new PluginPreference(this);
    if (localPluginPreference.axc("masssendapp"))
    {
      localPluginPreference.setTitle(localPluginPreference.yEo);
      if ((u.aAy() & 0x10000) == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        paramList1.add(localPluginPreference);
        AppMethodBeat.o(221047);
        return;
      }
      paramList2.add(localPluginPreference);
    }
    AppMethodBeat.o(221047);
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
    com.tencent.mm.plugin.report.service.g.yhR.f(14098, new Object[] { Integer.valueOf(5) });
    com.tencent.mm.plugin.report.service.g.yhR.f(12846, new Object[] { Integer.valueOf(yIt) });
    as.a.hFO.aI("gh_43f2581f6fd6", "");
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
      boolean bool = ((CheckBoxPreference)paramf.aVD(str)).isChecked();
      com.tencent.mm.kernel.g.ajC().ajl().set(35, Boolean.valueOf(bool));
      AppMethodBeat.o(74341);
      return true;
    }
    if ((paramPreference instanceof PluginPreference))
    {
      paramf = ((PluginPreference)paramPreference).yEn;
      if (("feedsapp".equals(paramf)) && (this.yIv)) {
        com.tencent.mm.kernel.g.ajC().ajl().set(-2046825369, Boolean.FALSE);
      }
      if ("gh_f0a92aa7146c".equals(paramf)) {
        com.tencent.mm.plugin.report.service.g.yhR.f(19540, new Object[] { Integer.valueOf(2) });
      }
      paramPreference = new Intent();
      if (("gh_43f2581f6fd6".equals(paramf)) && (this.yIw))
      {
        a.dun();
        i.LO(com.tencent.mm.plugin.newtips.a.d.wsi);
        paramPreference.putExtra("key_from_wesport_plugin_newtips", true);
      }
      paramPreference.putExtra("Contact_User", paramf);
      com.tencent.mm.bs.d.b(this, "profile", ".ui.ContactInfoUI", paramPreference);
      com.tencent.mm.plugin.report.service.g.yhR.f(12846, new Object[] { yIu.get(paramf) });
      ad.i("MicroMsg.SettingsPluginsUI", "click id:%s, kvID:%d", new Object[] { paramf, yIu.get(paramf) });
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
    Object localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf("gh_f0a92aa7146c");
    if (localObject != null) {}
    for (boolean bool = com.tencent.mm.o.b.lM(((aw)localObject).field_type);; bool = false)
    {
      ad.i("MicroMsg.SettingsPluginsUI", "needGetReceipAssistPlugin result：%s", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        com.tencent.mm.kernel.g.aiU().a(2745, this);
        localObject = new com.tencent.mm.plugin.setting.model.e();
        com.tencent.mm.kernel.g.aiU().a((n)localObject, 0);
      }
      aTM();
      AppMethodBeat.o(74339);
      return;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(221043);
    ad.i("MicroMsg.SettingsPluginsUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramn.getType());
    if ((paramn instanceof com.tencent.mm.plugin.setting.model.e))
    {
      com.tencent.mm.kernel.g.aiU().b(2745, this);
      if ((paramInt1 == 0) || (paramInt2 == 0))
      {
        paramString = (com.tencent.mm.plugin.setting.model.e)paramn;
        if (paramString.yCO == null)
        {
          paramString = new bhl();
          if (paramString.GCK != 1) {
            break label160;
          }
          ad.i("MicroMsg.SettingsPluginsUI", "need to show unstall ReceipAssistPlugin");
          com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IGl, Integer.valueOf(1));
        }
        for (;;)
        {
          aTM();
          AppMethodBeat.o(221043);
          return;
          paramString = paramString.yCO;
          break;
          label160:
          com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IGl, Integer.valueOf(0));
        }
      }
      ad.e("MicroMsg.SettingsPluginsUI", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    }
    AppMethodBeat.o(221043);
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