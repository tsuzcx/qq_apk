package com.tencent.mm.plugin.setting.ui.setting;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.xl;
import com.tencent.mm.autogen.a.xl.b;
import com.tencent.mm.ay.l;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.findersdk.a.ca;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.b.k;
import com.tencent.mm.plugin.setting.ui.b.a.a;
import com.tencent.mm.pluginsdk.platformtools.d.a;
import com.tencent.mm.protocal.protobuf.cas;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class SettingsManageFindMoreUI
  extends MMPreference
{
  protected HashMap<Integer, Integer> PtG;
  protected HashMap<Integer, Integer> PtH;
  protected int PtI;
  protected boolean PtJ;
  protected boolean PtK;
  private boolean PtL;
  protected boolean PtM;
  protected HashMap<Integer, Integer> pPy;
  protected long xct;
  
  public SettingsManageFindMoreUI()
  {
    AppMethodBeat.i(74209);
    this.pPy = new HashMap();
    this.PtG = new HashMap();
    this.PtH = new HashMap();
    this.PtJ = false;
    this.PtK = false;
    this.PtL = false;
    this.PtM = false;
    AppMethodBeat.o(74209);
  }
  
  private void a(WeChatBrands.Business.Entries paramEntries, String paramString)
  {
    AppMethodBeat.i(299004);
    if (paramEntries.restricted())
    {
      if (paramEntries.banned())
      {
        getPreferenceScreen().eh(paramString, true);
        AppMethodBeat.o(299004);
        return;
      }
      paramString = (CheckBoxPreference)getPreferenceScreen().bAi(paramString);
      paramString.jne();
      paramString.setOnClickListener(new SettingsManageFindMoreUI.5(this, paramEntries));
    }
    AppMethodBeat.o(299004);
  }
  
  private void ah(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(74216);
    Log.i("MicroMsg.SettingsManageFindMoreUI", "switch plugin flag, open %s, flag %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (!paramBoolean)
    {
      this.PtI |= paramInt;
      AppMethodBeat.o(74216);
      return;
    }
    this.PtI &= (paramInt ^ 0xFFFFFFFF);
    AppMethodBeat.o(74216);
  }
  
  private void b(boolean paramBoolean, long paramLong, int paramInt)
  {
    AppMethodBeat.i(164133);
    Log.i("MicroMsg.SettingsManageFindMoreUI", "switch ext change : open = " + paramBoolean + " item value = " + paramLong + " functionId = " + paramInt);
    if (paramBoolean)
    {
      this.xct &= (0xFFFFFFFF ^ paramLong);
      if (!paramBoolean) {
        break label107;
      }
    }
    label107:
    for (int i = 1;; i = 2)
    {
      this.pPy.put(Integer.valueOf(paramInt), Integer.valueOf(i));
      AppMethodBeat.o(164133);
      return;
      this.xct |= paramLong;
      break;
    }
  }
  
  private boolean ju(long paramLong)
  {
    return (this.xct & paramLong) != 0L;
  }
  
  private boolean uk(long paramLong)
  {
    return (this.PtI & paramLong) == 0L;
  }
  
  public final void CM(boolean paramBoolean)
  {
    AppMethodBeat.i(299096);
    b(paramBoolean, 2097152L, 50);
    AppMethodBeat.o(299096);
  }
  
  protected final void CN(boolean paramBoolean)
  {
    AppMethodBeat.i(299100);
    ((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.welab.a.a.a.class)).dP("labs_browse", paramBoolean);
    if (paramBoolean)
    {
      this.xct &= 0xFBFFFFFF;
      AppMethodBeat.o(299100);
      return;
    }
    this.xct |= 0x4000000;
    AppMethodBeat.o(299100);
  }
  
  protected final void CO(boolean paramBoolean)
  {
    AppMethodBeat.i(299102);
    b(paramBoolean, 34359738368L, 57);
    AppMethodBeat.o(299102);
  }
  
  public final void a(final CheckBoxPreference paramCheckBoxPreference, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(299087);
    if (!paramBoolean1)
    {
      if ((((com.tencent.mm.plugin.websearch.api.i)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.websearch.api.i.class)).b(this, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(298791);
          if (paramCheckBoxPreference != null) {
            paramCheckBoxPreference.setChecked(false);
          }
          if (!paramBoolean2) {
            SettingsManageFindMoreUI.this.CM(paramBoolean1);
          }
          AppMethodBeat.o(298791);
        }
      })) && (paramCheckBoxPreference != null)) {
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(298801);
            if (paramCheckBoxPreference != null) {
              paramCheckBoxPreference.setChecked(true);
            }
            AppMethodBeat.o(298801);
          }
        }, 500L);
      }
      AppMethodBeat.o(299087);
      return;
    }
    if (!paramBoolean2) {
      CM(paramBoolean1);
    }
    AppMethodBeat.o(299087);
  }
  
  protected void cIX()
  {
    AppMethodBeat.i(74217);
    Iterator localIterator = this.PtH.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      if ((this.PtG.containsKey(Integer.valueOf(i))) && (this.PtG.get(Integer.valueOf(i)) != this.PtH.get(Integer.valueOf(i))))
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(15185, new Object[] { Integer.valueOf(i), this.PtH.get(Integer.valueOf(i)), Integer.valueOf(1) });
        if (i == 0) {
          if (((Integer)this.PtH.get(Integer.valueOf(i))).intValue() == 0) {
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acYm, Integer.valueOf(-1));
          } else if (((Integer)this.PtH.get(Integer.valueOf(i))).intValue() == 1) {
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acYm, Integer.valueOf(1));
          }
        }
      }
    }
    AppMethodBeat.o(74217);
  }
  
  public com.tencent.mm.ui.base.preference.h createAdapter(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(74211);
    paramSharedPreferences = new com.tencent.mm.ui.base.preference.a(this, getListView(), paramSharedPreferences);
    AppMethodBeat.o(74211);
    return paramSharedPreferences;
  }
  
  public void finish()
  {
    AppMethodBeat.i(74215);
    super.finish();
    if (gVO())
    {
      Log.i("MicroMsg.SettingsManageFindMoreUI", "oplog extstatus:" + this.xct + ",pluginFlag:" + this.PtI);
      com.tencent.mm.kernel.h.baE().ban().B(147457, Long.valueOf(this.xct));
      com.tencent.mm.kernel.h.baE().ban().B(34, Integer.valueOf(this.PtI));
      Iterator localIterator = this.pPy.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        int i = ((Integer)((Map.Entry)localObject).getKey()).intValue();
        int j = ((Integer)((Map.Entry)localObject).getValue()).intValue();
        localObject = new cas();
        ((cas)localObject).aajJ = i;
        ((cas)localObject).NkL = j;
        ((n)com.tencent.mm.kernel.h.ax(n.class)).bzz().d(new k.a(23, (com.tencent.mm.bx.a)localObject));
        Log.d("MicroMsg.SettingsManageFindMoreUI", "switch  " + i + " " + j);
      }
      this.pPy.clear();
      ((n)com.tencent.mm.kernel.h.ax(n.class)).bzz().d(new l("", "", "", "", "", "", "", "", this.PtI, "", ""));
    }
    cIX();
    AppMethodBeat.o(74215);
  }
  
  protected void gVL()
  {
    AppMethodBeat.i(299053);
    CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)getPreferenceScreen().bAi("settings_search_switch");
    localCheckBoxPreference.adZV = false;
    if (ju(2097152L))
    {
      localCheckBoxPreference.setChecked(false);
      this.PtG.put(Integer.valueOf(3), Integer.valueOf(0));
    }
    for (;;)
    {
      a(WeChatBrands.Business.Entries.MeSetDiscoverySearch, "settings_search_switch");
      AppMethodBeat.o(299053);
      return;
      localCheckBoxPreference.setChecked(true);
      this.PtG.put(Integer.valueOf(3), Integer.valueOf(1));
    }
  }
  
  protected void gVM()
  {
    AppMethodBeat.i(299058);
    CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)getPreferenceScreen().bAi("settings_look_switch");
    localCheckBoxPreference.adZV = false;
    boolean bool1;
    if (!ju(67108864L))
    {
      bool1 = true;
      if (!com.tencent.mm.au.b.OE((String)com.tencent.mm.kernel.h.baE().ban().d(274436, null))) {
        break label259;
      }
      getPreferenceScreen().eh("settings_look_switch", true);
      Log.i("MicroMsg.SettingsManageFindMoreUI", "european user");
      bool1 = false;
    }
    label259:
    for (boolean bool2 = false;; bool2 = true)
    {
      boolean bool3 = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu();
      Log.i("MicroMsg.SettingsManageFindMoreUI", "isInExperiment %s ,openLook %s, isTeenMode:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
      if ((bool2) && (bool1) && (!bool3))
      {
        localCheckBoxPreference.setChecked(true);
        this.PtG.put(Integer.valueOf(10), Integer.valueOf(1));
      }
      for (;;)
      {
        a(WeChatBrands.Business.Entries.MeSetDiscoveryLooks, "settings_look_switch");
        AppMethodBeat.o(299058);
        return;
        bool1 = false;
        break;
        if ((!bool2) || (bool3))
        {
          getPreferenceScreen().eh("settings_look_switch", true);
        }
        else
        {
          getPreferenceScreen().eh("settings_look_switch", false);
          localCheckBoxPreference.setChecked(false);
          this.PtG.put(Integer.valueOf(10), Integer.valueOf(0));
        }
      }
    }
  }
  
  protected void gVN()
  {
    AppMethodBeat.i(299063);
    boolean bool = ((cn)com.tencent.mm.kernel.h.az(cn.class)).showFinderEntry();
    Log.i("MicroMsg.SettingsManageFindMoreUI", "showFinder %s", new Object[] { Boolean.valueOf(bool) });
    if ((((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu()) && (((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).eZD() == 2)) {}
    for (int i = 1; (!bool) || (i != 0); i = 0)
    {
      getPreferenceScreen().eh("settings_finder_switch", true);
      AppMethodBeat.o(299063);
      return;
    }
    CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)getPreferenceScreen().bAi("settings_finder_switch");
    localCheckBoxPreference.adZV = false;
    if (ju(34359738368L))
    {
      localCheckBoxPreference.setChecked(false);
      this.PtG.put(Integer.valueOf(11), Integer.valueOf(0));
    }
    for (;;)
    {
      a(WeChatBrands.Business.Entries.MeSetDiscoveryChannels, "settings_finder_switch");
      AppMethodBeat.o(299063);
      return;
      localCheckBoxPreference.setChecked(true);
      this.PtG.put(Integer.valueOf(11), Integer.valueOf(1));
    }
  }
  
  protected boolean gVO()
  {
    return true;
  }
  
  public int getResourceId()
  {
    AppMethodBeat.i(299021);
    boolean bool = ab.bBX();
    this.PtL = bool;
    if (bool)
    {
      i = b.k.settings_pref_manage_findmoreui_wechat_out;
      AppMethodBeat.o(299021);
      return i;
    }
    int i = b.k.settings_pref_manage_findmoreui;
    AppMethodBeat.o(299021);
    return i;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74213);
    setMMTitle(b.i.settings_manage_findmoreui);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(298797);
        SettingsManageFindMoreUI.this.finish();
        AppMethodBeat.o(298797);
        return true;
      }
    });
    Object localObject1 = (CheckBoxPreference)getPreferenceScreen().bAi("settings_sns_switch");
    ((Preference)localObject1).adZV = false;
    boolean bool1 = uk(32768L);
    Log.i("MicroMsg.SettingsManageFindMoreUI", "openSns %s", new Object[] { Boolean.valueOf(bool1) });
    label165:
    boolean bool2;
    label268:
    label351:
    label496:
    Object localObject2;
    if (bool1)
    {
      ((CheckBoxPreference)localObject1).setChecked(true);
      this.PtG.put(Integer.valueOf(0), Integer.valueOf(1));
      gVN();
      bool1 = ((cn)com.tencent.mm.kernel.h.az(cn.class)).getFinderUtilApi().fgE();
      Log.i("MicroMsg.SettingsManageFindMoreUI", "showFinderLiveEntry %s", new Object[] { Boolean.valueOf(bool1) });
      localObject1 = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
      if (!com.tencent.mm.plugin.finder.nearby.abtest.a.eEl()) {
        break label1281;
      }
      getPreferenceScreen().eh("settings_finder_live_switch", true);
      bool2 = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu();
      if ((bool1) && (!bool2)) {
        break label1298;
      }
      getPreferenceScreen().eh("settings_finder_live_switch", true);
      getPreferenceScreen().eh("settings_finder_live_above_look_switch", true);
      localObject1 = (CheckBoxPreference)getPreferenceScreen().bAi("settings_scan_switch");
      ((Preference)localObject1).adZV = false;
      if (!ju(1048576L)) {
        break label1403;
      }
      ((CheckBoxPreference)localObject1).setChecked(false);
      this.PtG.put(Integer.valueOf(1), Integer.valueOf(0));
      a(WeChatBrands.Business.Entries.GlobalScan, "settings_scan_switch");
      localObject1 = (CheckBoxPreference)getPreferenceScreen().bAi("settings_shake_switch");
      ((Preference)localObject1).adZV = false;
      bool1 = uk(256L);
      Log.i("MicroMsg.SettingsManageFindMoreUI", "openShake %s", new Object[] { Boolean.valueOf(bool1) });
      if (!bool1) {
        break label1427;
      }
      ((CheckBoxPreference)localObject1).setChecked(true);
      this.PtG.put(Integer.valueOf(2), Integer.valueOf(1));
      a(WeChatBrands.Business.Entries.MeSetDiscoveryShake, "settings_shake_switch");
      if (!((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu()) {
        break label1451;
      }
      getPreferenceScreen().eh("settings_shake_switch", true);
      label392:
      gVM();
      gVL();
      if (!((cn)com.tencent.mm.kernel.h.az(cn.class)).getFinderUtilApi().fgF()) {
        break label1573;
      }
      getPreferenceScreen().eh("settings_nearby_switch", true);
      localObject1 = (CheckBoxPreference)getPreferenceScreen().bAi("settings_nearby_live_friend_switch");
      ((Preference)localObject1).adZV = false;
      if (!((cn)com.tencent.mm.kernel.h.az(cn.class)).getFinderUtilApi().fgE()) {
        break label1468;
      }
      ((CheckBoxPreference)localObject1).setTitle(getContext().getResources().getString(b.i.find_friends_by_nearby_title));
      localObject2 = (CheckBoxPreference)getPreferenceScreen().bAi("settings_nearby_live_friend_person_switch");
      ((Preference)localObject2).adZV = false;
      if (ju(70368744177664L)) {
        break label1488;
      }
      bool1 = true;
      label531:
      bool2 = uk(512L);
      Log.i("MicroMsg.SettingsManageFindMoreUI", "openNearbyLiveFriends:%s openNearbyLiveFriendsPerson:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (!bool1) {
        break label1493;
      }
      ((CheckBoxPreference)localObject1).setChecked(true);
      this.PtG.put(Integer.valueOf(5), Integer.valueOf(1));
      getPreferenceScreen().eh("settings_nearby_live_friend_person_switch", false);
      label604:
      if (!bool2) {
        break label1531;
      }
      ((CheckBoxPreference)localObject2).setChecked(true);
      this.PtG.put(Integer.valueOf(4), Integer.valueOf(1));
      label630:
      a(WeChatBrands.Business.Entries.MeSetDiscoveryNearbyLiveFriends, "settings_nearby_live_friend_switch");
      a(WeChatBrands.Business.Entries.MeSetDiscoveryNearbyLiveFriendsPerson, "settings_nearby_live_friend_person_switch");
      if (!((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu()) {
        break label1556;
      }
      getPreferenceScreen().eh("settings_nearby_live_friend_switch", true);
      getPreferenceScreen().eh("settings_nearby_live_friend_person_switch", true);
      label695:
      localObject1 = com.tencent.mm.pluginsdk.platformtools.d.XUQ;
      if ((localObject1 == null) || (!((d.a)localObject1).hAQ())) {
        break label1938;
      }
    }
    label1281:
    label1801:
    label1938:
    for (bool1 = true;; bool1 = false)
    {
      Log.i("MicroMsg.SettingsManageFindMoreUI", "showShopping %s", new Object[] { Boolean.valueOf(bool1) });
      bool2 = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu();
      localObject1 = (CheckBoxPreference)getPreferenceScreen().bAi("settings_shopping_switch");
      ((Preference)localObject1).adZV = false;
      if ((bool1) && (!bool2))
      {
        getPreferenceScreen().eh("settings_shopping_switch", false);
        label791:
        if (!ju(4194304L)) {
          break label1776;
        }
        ((CheckBoxPreference)localObject1).setChecked(false);
        this.PtG.put(Integer.valueOf(6), Integer.valueOf(0));
        label823:
        a(WeChatBrands.Business.Entries.MeSetDiscoveryShop, "settings_shopping_switch");
        localObject1 = b.a.fCn();
        localObject2 = (CheckBoxPreference)getPreferenceScreen().bAi("settings_game_switch");
        ((Preference)localObject2).adZV = false;
        bool1 = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu();
        if ((localObject1 == null) || (!((com.tencent.mm.plugin.game.api.b)localObject1).fBZ()) || (bool1)) {
          break label1827;
        }
        if (!ju(8388608L)) {
          break label1801;
        }
        ((CheckBoxPreference)localObject2).setChecked(false);
        this.PtG.put(Integer.valueOf(7), Integer.valueOf(0));
        label925:
        a(WeChatBrands.Business.Entries.MeSetDiscoveryGame, "settings_game_switch");
        localObject1 = new xl();
        ((xl)localObject1).iaO.iaQ = true;
        ((xl)localObject1).publish();
        bool2 = ((xl)localObject1).iaP.iaR;
        if ((!((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu()) || (((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).eZD() != 2)) {
          break label1844;
        }
        bool1 = true;
        label1001:
        Log.i("MicroMsg.SettingsManageFindMoreUI", "shouldShowMiniProgram %s, isTeenModeAndNotAccessRight:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        localObject1 = (CheckBoxPreference)getPreferenceScreen().bAi("settings_miniprogram_switch");
        ((Preference)localObject1).adZV = false;
        if ((!bool2) || (bool1)) {
          break label1874;
        }
        if (!ju(16777216L)) {
          break label1849;
        }
        ((CheckBoxPreference)localObject1).setChecked(false);
        this.PtG.put(Integer.valueOf(8), Integer.valueOf(0));
        label1088:
        a(WeChatBrands.Business.Entries.MeSetDiscoveryAppbrand, "settings_miniprogram_switch");
        localObject1 = (CheckBoxPreference)getPreferenceScreen().bAi("settings_wechatout_switch");
        if (com.tencent.mm.k.i.aRC().getInt("WCOEntranceSwitch", 0) <= 0) {
          break label1891;
        }
        bool1 = true;
        label1129:
        Log.i("MicroMsg.SettingsManageFindMoreUI", "showWeChatOut %s", new Object[] { Boolean.valueOf(bool1) });
        if (!bool1) {
          break label1921;
        }
        ((Preference)localObject1).adZV = false;
        if (!ju(33554432L)) {
          break label1896;
        }
        ((CheckBoxPreference)localObject1).setChecked(false);
        this.PtG.put(Integer.valueOf(9), Integer.valueOf(0));
      }
      for (;;)
      {
        a(WeChatBrands.Business.Entries.MeSetDiscoveryWeChatOut, "settings_wechatout_switch");
        localObject1 = getPreferenceScreen().bAi("settings_switch_bottom_tip");
        if (com.tencent.mm.au.b.OE((String)com.tencent.mm.kernel.h.baE().ban().d(274436, null))) {
          ((Preference)localObject1).setTitle(b.i.settings_manage_plugin_eu_hint);
        }
        getPreferenceScreen().notifyDataSetChanged();
        AppMethodBeat.o(74213);
        return;
        ((CheckBoxPreference)localObject1).setChecked(false);
        this.PtG.put(Integer.valueOf(0), Integer.valueOf(0));
        break;
        getPreferenceScreen().eh("settings_finder_live_above_look_switch", true);
        break label165;
        label1298:
        localObject1 = getPreferenceScreen();
        localObject2 = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
        localObject1 = (CheckBoxPreference)((com.tencent.mm.ui.base.preference.f)localObject1).bAi(com.tencent.mm.plugin.finder.nearby.abtest.a.eEm());
        ((Preference)localObject1).adZV = false;
        if (ju(9007199254740992L))
        {
          ((CheckBoxPreference)localObject1).setChecked(false);
          this.PtG.put(Integer.valueOf(13), Integer.valueOf(0));
        }
        for (;;)
        {
          localObject1 = WeChatBrands.Business.Entries.MeSetDiscoveryFinderLive;
          localObject2 = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
          a((WeChatBrands.Business.Entries)localObject1, com.tencent.mm.plugin.finder.nearby.abtest.a.eEm());
          break;
          ((CheckBoxPreference)localObject1).setChecked(true);
          this.PtG.put(Integer.valueOf(13), Integer.valueOf(1));
        }
        label1403:
        ((CheckBoxPreference)localObject1).setChecked(true);
        this.PtG.put(Integer.valueOf(1), Integer.valueOf(1));
        break label268;
        label1427:
        ((CheckBoxPreference)localObject1).setChecked(false);
        this.PtG.put(Integer.valueOf(2), Integer.valueOf(0));
        break label351;
        label1451:
        getPreferenceScreen().eh("settings_shake_switch", false);
        break label392;
        label1468:
        ((CheckBoxPreference)localObject1).setTitle(getContext().getResources().getString(b.i.nearby_live_friend_title));
        break label496;
        label1488:
        bool1 = false;
        break label531;
        label1493:
        ((CheckBoxPreference)localObject1).setChecked(false);
        this.PtG.put(Integer.valueOf(5), Integer.valueOf(0));
        getPreferenceScreen().eh("settings_nearby_live_friend_person_switch", true);
        break label604;
        label1531:
        ((CheckBoxPreference)localObject2).setChecked(false);
        this.PtG.put(Integer.valueOf(4), Integer.valueOf(0));
        break label630;
        label1556:
        getPreferenceScreen().eh("settings_nearby_live_friend_switch", false);
        break label695;
        label1573:
        getPreferenceScreen().eh("settings_nearby_live_friend_switch", true);
        getPreferenceScreen().eh("settings_nearby_live_friend_person_switch", true);
        localObject1 = (CheckBoxPreference)getPreferenceScreen().bAi("settings_nearby_switch");
        ((Preference)localObject1).adZV = false;
        bool1 = uk(512L);
        Log.i("MicroMsg.SettingsManageFindMoreUI", "openNearby %s", new Object[] { Boolean.valueOf(bool1) });
        if (bool1)
        {
          ((CheckBoxPreference)localObject1).setChecked(true);
          this.PtG.put(Integer.valueOf(4), Integer.valueOf(1));
        }
        for (;;)
        {
          a(WeChatBrands.Business.Entries.MeSetDiscoveryNearby, "settings_nearby_switch");
          if (!((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu()) {
            break label1742;
          }
          getPreferenceScreen().eh("settings_nearby_switch", true);
          break;
          ((CheckBoxPreference)localObject1).setChecked(false);
          this.PtG.put(Integer.valueOf(4), Integer.valueOf(0));
        }
        label1742:
        getPreferenceScreen().eh("settings_nearby_switch", false);
        break label695;
        getPreferenceScreen().eh("settings_shopping_switch", true);
        break label791;
        label1776:
        ((CheckBoxPreference)localObject1).setChecked(true);
        this.PtG.put(Integer.valueOf(6), Integer.valueOf(1));
        break label823;
        ((CheckBoxPreference)localObject2).setChecked(true);
        this.PtG.put(Integer.valueOf(7), Integer.valueOf(1));
        break label925;
        label1827:
        getPreferenceScreen().eh("settings_game_switch", true);
        break label925;
        label1844:
        bool1 = false;
        break label1001;
        label1849:
        ((CheckBoxPreference)localObject1).setChecked(true);
        this.PtG.put(Integer.valueOf(8), Integer.valueOf(1));
        break label1088;
        label1874:
        getPreferenceScreen().eh("settings_miniprogram_switch", true);
        break label1088;
        label1891:
        bool1 = false;
        break label1129;
        label1896:
        ((CheckBoxPreference)localObject1).setChecked(true);
        this.PtG.put(Integer.valueOf(9), Integer.valueOf(1));
        continue;
        getPreferenceScreen().eh("settings_wechatout_switch", true);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74210);
    super.onCreate(paramBundle);
    boolean bool;
    if (com.tencent.mm.k.i.aRC().getInt("ExtFunctionSwitchEntry", 0) == 1)
    {
      bool = true;
      this.PtK = bool;
      this.PtJ = z.bBK().booleanValue();
      Log.i("MicroMsg.SettingsManageFindMoreUI", "onCreate isShowWechatUserDialog = " + this.PtK + "， isOverseaNewUser = " + this.PtJ);
      this.xct = z.bAR();
      this.PtL = ab.bBX();
      paramBundle = LocaleUtil.getCurrentLanguage(this);
      if ((!"zh_CN".equals(paramBundle)) && (!"zh_HK".equals(paramBundle)) && (!"zh_TW".equals(paramBundle))) {
        break label189;
      }
    }
    label189:
    for (this.PtM = true;; this.PtM = false)
    {
      this.PtI = z.bBf();
      Log.i("MicroMsg.SettingsManageFindMoreUI", "onCreate extStatus %d, pluginFlag %d", new Object[] { Long.valueOf(this.xct), Integer.valueOf(this.PtI) });
      initView();
      AppMethodBeat.o(74210);
      return;
      bool = false;
      break;
    }
  }
  
  public boolean onPreferenceTreeClick(final com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74212);
    if (!(paramPreference instanceof CheckBoxPreference))
    {
      AppMethodBeat.o(74212);
      return true;
    }
    paramf = (CheckBoxPreference)paramPreference;
    paramPreference = paramPreference.mKey;
    Log.i("MicroMsg.SettingsManageFindMoreUI", "click pref key %s", new Object[] { paramPreference });
    int i = -1;
    if (paramPreference.equals("settings_sns_switch"))
    {
      i = 0;
      ah(paramf.isChecked(), 32768);
      if (!paramf.isChecked()) {
        break label985;
      }
    }
    label650:
    label985:
    for (int j = 1;; j = 0)
    {
      if (i >= 0) {
        this.PtH.put(Integer.valueOf(i), Integer.valueOf(j));
      }
      AppMethodBeat.o(74212);
      return true;
      if (paramPreference.equals("settings_scan_switch"))
      {
        if (!WeChatBrands.Business.Entries.GlobalScan.checkAvailable(this))
        {
          AppMethodBeat.o(74212);
          return true;
        }
        i = 1;
        b(paramf.isChecked(), 1048576L, 49);
        break;
      }
      if (paramPreference.equals("settings_search_switch"))
      {
        if (!WeChatBrands.Business.Entries.MeSetDiscoverySearch.checkAvailable(this))
        {
          AppMethodBeat.o(74212);
          return true;
        }
        if ((this.PtL) && (this.PtK) && (paramf.isChecked()))
        {
          com.tencent.mm.plugin.setting.ui.b.a.a(this, 2097152L, paramf, new a.a()
          {
            public final void cjC()
            {
              AppMethodBeat.i(298778);
              CheckBoxPreference localCheckBoxPreference = paramf;
              if (!paramf.isChecked()) {}
              for (boolean bool = true;; bool = false)
              {
                localCheckBoxPreference.Hy(bool);
                AppMethodBeat.o(298778);
                return;
              }
            }
            
            public final void onSuccess()
            {
              AppMethodBeat.i(298775);
              Log.d("MicroMsg.SettingsManageFindMoreUI", "switchSosData checkPref.isChecked() = " + paramf.isChecked() + ", extStatus = " + z.bAR());
              SettingsManageFindMoreUI.this.CM(paramf.isChecked());
              HashMap localHashMap = SettingsManageFindMoreUI.this.PtH;
              if (paramf.isChecked()) {}
              for (int i = 1;; i = 0)
              {
                localHashMap.put(Integer.valueOf(3), Integer.valueOf(i));
                AppMethodBeat.o(298775);
                return;
              }
            }
          }, 2);
          break;
        }
        i = 3;
        a(paramf, paramf.isChecked(), false);
        break;
      }
      if (paramPreference.equals("settings_shopping_switch"))
      {
        if (!WeChatBrands.Business.Entries.MeSetDiscoveryShop.checkAvailable(this))
        {
          AppMethodBeat.o(74212);
          return true;
        }
        i = 6;
        b(paramf.isChecked(), 4194304L, 51);
        break;
      }
      if (paramPreference.equals("settings_game_switch"))
      {
        if (!WeChatBrands.Business.Entries.MeSetDiscoveryGame.checkAvailable(this))
        {
          AppMethodBeat.o(74212);
          return true;
        }
        i = 7;
        b(paramf.isChecked(), 8388608L, 52);
        paramPreference = com.tencent.mm.plugin.report.service.h.OAn;
        if (paramf.isChecked()) {}
        for (l = 0L;; l = 1L)
        {
          paramPreference.idkeyStat(848L, l, 1L, false);
          break;
        }
      }
      if (paramPreference.equals("settings_miniprogram_switch"))
      {
        if (!WeChatBrands.Business.Entries.MeSetDiscoveryAppbrand.checkAvailable(this))
        {
          AppMethodBeat.o(74212);
          return true;
        }
        i = 8;
        b(paramf.isChecked(), 16777216L, 53);
        break;
      }
      if (paramPreference.equals("settings_wechatout_switch"))
      {
        if (!WeChatBrands.Business.Entries.MeSetDiscoveryWeChatOut.checkAvailable(this))
        {
          AppMethodBeat.o(74212);
          return true;
        }
        i = 9;
        b(paramf.isChecked(), 33554432L, 54);
        break;
      }
      if (paramPreference.equals("settings_shake_switch"))
      {
        if (!WeChatBrands.Business.Entries.MeSetDiscoveryShake.checkAvailable(this))
        {
          AppMethodBeat.o(74212);
          return true;
        }
        i = 2;
        ah(paramf.isChecked(), 256);
        break;
      }
      if (paramPreference.equals("settings_nearby_switch"))
      {
        if (!WeChatBrands.Business.Entries.MeSetDiscoveryNearby.checkAvailable(this))
        {
          AppMethodBeat.o(74212);
          return true;
        }
        i = 4;
        ah(paramf.isChecked(), 512);
        break;
      }
      if (paramPreference.equals("settings_nearby_live_friend_switch"))
      {
        if (!WeChatBrands.Business.Entries.MeSetDiscoveryNearbyLiveFriends.checkAvailable(this))
        {
          AppMethodBeat.o(74212);
          return true;
        }
        b(paramf.isChecked(), 70368744177664L, 61);
        paramPreference = getPreferenceScreen();
        boolean bool;
        if (!paramf.isChecked())
        {
          bool = true;
          label605:
          paramPreference.eh("settings_nearby_live_friend_person_switch", bool);
          paramPreference = com.tencent.mm.plugin.setting.a.b.Por;
          if (!paramf.isChecked()) {
            break label650;
          }
        }
        for (l = 1L;; l = 0L)
        {
          com.tencent.mm.plugin.setting.a.b.bd(12L, l);
          i = 5;
          break;
          bool = false;
          break label605;
        }
      }
      if (paramPreference.equals("settings_nearby_live_friend_person_switch"))
      {
        if (!WeChatBrands.Business.Entries.MeSetDiscoveryNearbyLiveFriendsPerson.checkAvailable(this))
        {
          AppMethodBeat.o(74212);
          return true;
        }
        ah(paramf.isChecked(), 512);
        paramPreference = com.tencent.mm.plugin.setting.a.b.Por;
        if (paramf.isChecked()) {}
        for (l = 1L;; l = 0L)
        {
          com.tencent.mm.plugin.setting.a.b.bd(13L, l);
          i = 12;
          break;
        }
      }
      if (paramPreference.equals("settings_look_switch"))
      {
        if (!WeChatBrands.Business.Entries.MeSetDiscoveryLooks.checkAvailable(this))
        {
          AppMethodBeat.o(74212);
          return true;
        }
        if ((this.PtL) && (this.PtK) && (paramf.isChecked()))
        {
          com.tencent.mm.plugin.setting.ui.b.a.a(this, 67108864L, paramf, new a.a()
          {
            public final void cjC()
            {
              AppMethodBeat.i(298789);
              CheckBoxPreference localCheckBoxPreference = paramf;
              if (!paramf.isChecked()) {}
              for (boolean bool = true;; bool = false)
              {
                localCheckBoxPreference.Hy(bool);
                AppMethodBeat.o(298789);
                return;
              }
            }
            
            public final void onSuccess()
            {
              AppMethodBeat.i(298786);
              Log.d("MicroMsg.SettingsManageFindMoreUI", "switchDiscoveryLooks checkPref.isChecked() = " + paramf.isChecked() + ", extStatus = " + z.bAR());
              SettingsManageFindMoreUI.this.CN(paramf.isChecked());
              HashMap localHashMap = SettingsManageFindMoreUI.this.PtH;
              if (paramf.isChecked()) {}
              for (int i = 1;; i = 0)
              {
                localHashMap.put(Integer.valueOf(10), Integer.valueOf(i));
                AppMethodBeat.o(298786);
                return;
              }
            }
          }, 2);
          break;
        }
        i = 10;
        CN(paramf.isChecked());
        break;
      }
      if (paramPreference.equals("settings_finder_switch"))
      {
        if (!WeChatBrands.Business.Entries.MeSetDiscoveryChannels.checkAvailable(this))
        {
          AppMethodBeat.o(74212);
          return true;
        }
        if ((this.PtL) && (this.PtK) && (paramf.isChecked()))
        {
          com.tencent.mm.plugin.setting.ui.b.a.a(this, 34359738368L, paramf, new a.a()
          {
            public final void cjC()
            {
              AppMethodBeat.i(298795);
              CheckBoxPreference localCheckBoxPreference = paramf;
              if (!paramf.isChecked()) {}
              for (boolean bool = true;; bool = false)
              {
                localCheckBoxPreference.Hy(bool);
                AppMethodBeat.o(298795);
                return;
              }
            }
            
            public final void onSuccess()
            {
              AppMethodBeat.i(298792);
              Log.d("MicroMsg.SettingsManageFindMoreUI", "switchFinder checkPref.isChecked() = " + paramf.isChecked() + ", extStatus = " + z.bAR());
              SettingsManageFindMoreUI.this.CO(paramf.isChecked());
              HashMap localHashMap = SettingsManageFindMoreUI.this.PtH;
              if (paramf.isChecked()) {}
              for (int i = 1;; i = 0)
              {
                localHashMap.put(Integer.valueOf(11), Integer.valueOf(i));
                AppMethodBeat.o(298792);
                return;
              }
            }
          }, 2);
          break;
        }
        i = 11;
        CO(paramf.isChecked());
        break;
      }
      com.tencent.mm.plugin.finder.nearby.abtest.a locala = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
      if (!paramPreference.equals(com.tencent.mm.plugin.finder.nearby.abtest.a.eEm())) {
        break;
      }
      if (!WeChatBrands.Business.Entries.MeSetDiscoveryFinderLive.checkAvailable(this))
      {
        AppMethodBeat.o(74212);
        return true;
      }
      b(paramf.isChecked(), 9007199254740992L, 65);
      Log.i("MicroMsg.SettingsManageFindMoreUI", "switch finderlive 65");
      paramPreference = com.tencent.mm.plugin.setting.a.b.Por;
      if (paramf.isChecked()) {}
      for (long l = 1L;; l = 0L)
      {
        com.tencent.mm.plugin.setting.a.b.bd(14L, l);
        i = 13;
        break;
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsManageFindMoreUI
 * JD-Core Version:    0.7.0.1
 */