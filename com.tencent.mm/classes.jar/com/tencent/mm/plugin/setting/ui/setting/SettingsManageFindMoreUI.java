package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.us;
import com.tencent.mm.g.a.us.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.plugin.i.a.af;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.pluginsdk.i.d;
import com.tencent.mm.pluginsdk.i.d.a;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
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
  private HashMap<Integer, Integer> Dct;
  private HashMap<Integer, Integer> Dcu;
  private int Dcv;
  private HashMap<Integer, Integer> kbt;
  private long qAb;
  
  public SettingsManageFindMoreUI()
  {
    AppMethodBeat.i(74209);
    this.kbt = new HashMap();
    this.Dct = new HashMap();
    this.Dcu = new HashMap();
    AppMethodBeat.o(74209);
  }
  
  private boolean IK(long paramLong)
  {
    return (this.qAb & paramLong) != 0L;
  }
  
  private boolean IL(long paramLong)
  {
    return (this.Dcv & paramLong) == 0L;
  }
  
  private void U(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(74216);
    Log.i("MicroMsg.SettingsManageFindMoreUI", "switch plugin flag, open %s, flag %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (!paramBoolean)
    {
      this.Dcv |= paramInt;
      AppMethodBeat.o(74216);
      return;
    }
    this.Dcv &= (paramInt ^ 0xFFFFFFFF);
    AppMethodBeat.o(74216);
  }
  
  private void a(WeChatBrands.Business.Entries paramEntries, String paramString)
  {
    AppMethodBeat.i(256547);
    if (paramEntries.restricted())
    {
      if (paramEntries.banned())
      {
        getPreferenceScreen().jdMethod_do(paramString, true);
        AppMethodBeat.o(256547);
        return;
      }
      paramString = (CheckBoxPreference)getPreferenceScreen().bmg(paramString);
      paramString.gLz();
      paramString.setOnClickListener(new SettingsManageFindMoreUI.4(this, paramEntries));
    }
    AppMethodBeat.o(256547);
  }
  
  private void b(boolean paramBoolean, long paramLong, int paramInt)
  {
    AppMethodBeat.i(164133);
    Log.i("MicroMsg.SettingsManageFindMoreUI", "switch ext change : open = " + paramBoolean + " item value = " + paramLong + " functionId = " + paramInt);
    if (paramBoolean)
    {
      this.qAb &= (0xFFFFFFFF ^ paramLong);
      if (!paramBoolean) {
        break label107;
      }
    }
    label107:
    for (int i = 1;; i = 2)
    {
      this.kbt.put(Integer.valueOf(paramInt), Integer.valueOf(i));
      AppMethodBeat.o(164133);
      return;
      this.qAb |= paramLong;
      break;
    }
  }
  
  private void bUV()
  {
    AppMethodBeat.i(74217);
    Iterator localIterator = this.Dcu.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      if ((this.Dct.containsKey(Integer.valueOf(i))) && (this.Dct.get(Integer.valueOf(i)) != this.Dcu.get(Integer.valueOf(i))))
      {
        com.tencent.mm.plugin.report.service.h.CyF.a(15185, new Object[] { Integer.valueOf(i), this.Dcu.get(Integer.valueOf(i)), Integer.valueOf(1) });
        if (i == 0) {
          if (((Integer)this.Dcu.get(Integer.valueOf(i))).intValue() == 0) {
            g.aAh().azQ().set(ar.a.Oil, Integer.valueOf(-1));
          } else if (((Integer)this.Dcu.get(Integer.valueOf(i))).intValue() == 1) {
            g.aAh().azQ().set(ar.a.Oil, Integer.valueOf(1));
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
    Log.i("MicroMsg.SettingsManageFindMoreUI", "oplog extstatus:" + this.qAb + ",pluginFlag:" + this.Dcv);
    g.aAh().azQ().set(147457, Long.valueOf(this.qAb));
    g.aAh().azQ().set(34, Integer.valueOf(this.Dcv));
    Iterator localIterator = this.kbt.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      int i = ((Integer)((Map.Entry)localObject).getKey()).intValue();
      int j = ((Integer)((Map.Entry)localObject).getValue()).intValue();
      localObject = new bfx();
      ((bfx)localObject).LPB = i;
      ((bfx)localObject).BsD = j;
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(new k.a(23, (com.tencent.mm.bw.a)localObject));
      Log.d("MicroMsg.SettingsManageFindMoreUI", "switch  " + i + " " + j);
    }
    this.kbt.clear();
    ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(new com.tencent.mm.ba.l("", "", "", "", "", "", "", "", this.Dcv, "", ""));
    bUV();
    AppMethodBeat.o(74215);
  }
  
  public int getResourceId()
  {
    return 2132017272;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74213);
    setMMTitle(2131765441);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(74208);
        SettingsManageFindMoreUI.this.finish();
        AppMethodBeat.o(74208);
        return true;
      }
    });
    Object localObject = (CheckBoxPreference)getPreferenceScreen().bmg("settings_sns_switch");
    ((Preference)localObject).OZw = false;
    boolean bool1 = IL(32768L);
    Log.i("MicroMsg.SettingsManageFindMoreUI", "openSns %s", new Object[] { Boolean.valueOf(bool1) });
    int i;
    label172:
    label249:
    boolean bool2;
    if (bool1)
    {
      ((CheckBoxPreference)localObject).setChecked(true);
      this.Dct.put(Integer.valueOf(0), Integer.valueOf(1));
      bool1 = ((aj)g.ah(aj.class)).showFinderEntry();
      Log.i("MicroMsg.SettingsManageFindMoreUI", "showFinder %s", new Object[] { Boolean.valueOf(bool1) });
      if ((!((com.tencent.mm.plugin.teenmode.a.b)g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt()) || (((com.tencent.mm.plugin.teenmode.a.b)g.af(com.tencent.mm.plugin.teenmode.a.b.class)).dxW() != 2)) {
        break label1490;
      }
      i = 1;
      if ((bool1) && (i == 0)) {
        break label1495;
      }
      getPreferenceScreen().jdMethod_do("settings_finder_switch", true);
      localObject = (CheckBoxPreference)getPreferenceScreen().bmg("settings_scan_switch");
      ((Preference)localObject).OZw = false;
      if (!IK(1048576L)) {
        break label1590;
      }
      ((CheckBoxPreference)localObject).setChecked(false);
      this.Dct.put(Integer.valueOf(1), Integer.valueOf(0));
      a(WeChatBrands.Business.Entries.GlobalScan, "settings_scan_switch");
      localObject = (CheckBoxPreference)getPreferenceScreen().bmg("settings_shake_switch");
      ((Preference)localObject).OZw = false;
      bool1 = IL(256L);
      Log.i("MicroMsg.SettingsManageFindMoreUI", "openShake %s", new Object[] { Boolean.valueOf(bool1) });
      if (!bool1) {
        break label1615;
      }
      ((CheckBoxPreference)localObject).setChecked(true);
      this.Dct.put(Integer.valueOf(2), Integer.valueOf(1));
      label335:
      a(WeChatBrands.Business.Entries.MeSetDiscoveryShake, "settings_shake_switch");
      if (!((com.tencent.mm.plugin.teenmode.a.b)g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt()) {
        break label1640;
      }
      getPreferenceScreen().jdMethod_do("settings_shake_switch", true);
      label376:
      localObject = (CheckBoxPreference)getPreferenceScreen().bmg("settings_look_switch");
      ((Preference)localObject).OZw = false;
      if (IK(67108864L)) {
        break label1657;
      }
      bool1 = true;
      label411:
      if (!com.tencent.mm.aw.b.Pi((String)g.aAh().azQ().get(274436, null))) {
        break label2216;
      }
      getPreferenceScreen().jdMethod_do("settings_look_switch", true);
      Log.i("MicroMsg.SettingsManageFindMoreUI", "european user");
      bool2 = false;
      bool1 = false;
    }
    label1291:
    label2194:
    for (;;)
    {
      boolean bool3 = ((com.tencent.mm.plugin.teenmode.a.b)g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt();
      Log.i("MicroMsg.SettingsManageFindMoreUI", "isInExperiment %s ,openLook %s, isTeenMode:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
      label545:
      label610:
      CheckBoxPreference localCheckBoxPreference;
      if ((bool2) && (bool1) && (!bool3))
      {
        ((CheckBoxPreference)localObject).setChecked(true);
        this.Dct.put(Integer.valueOf(10), Integer.valueOf(1));
        a(WeChatBrands.Business.Entries.MeSetDiscoveryLooks, "settings_look_switch");
        localObject = (CheckBoxPreference)getPreferenceScreen().bmg("settings_search_switch");
        ((Preference)localObject).OZw = false;
        if (!IK(2097152L)) {
          break label1728;
        }
        ((CheckBoxPreference)localObject).setChecked(false);
        this.Dct.put(Integer.valueOf(3), Integer.valueOf(0));
        a(WeChatBrands.Business.Entries.MeSetDiscoverySearch, "settings_search_switch");
        if (!((aj)g.ah(aj.class)).getFinderUtilApi().dDf()) {
          break label1839;
        }
        getPreferenceScreen().jdMethod_do("settings_nearby_switch", true);
        localObject = (CheckBoxPreference)getPreferenceScreen().bmg("settings_nearby_live_friend_switch");
        ((Preference)localObject).OZw = false;
        localCheckBoxPreference = (CheckBoxPreference)getPreferenceScreen().bmg("settings_nearby_live_friend_person_switch");
        localCheckBoxPreference.OZw = false;
        if (IK(70368744177664L)) {
          break label1753;
        }
        bool1 = true;
        label714:
        bool2 = IL(512L);
        Log.i("MicroMsg.SettingsManageFindMoreUI", "openNearbyLiveFriends:%s openNearbyLiveFriendsPerson:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        if (!bool1) {
          break label1758;
        }
        ((CheckBoxPreference)localObject).setChecked(true);
        this.Dct.put(Integer.valueOf(5), Integer.valueOf(1));
        getPreferenceScreen().jdMethod_do("settings_nearby_live_friend_person_switch", false);
        label788:
        if (!bool2) {
          break label1797;
        }
        localCheckBoxPreference.setChecked(true);
        this.Dct.put(Integer.valueOf(4), Integer.valueOf(1));
        label814:
        a(WeChatBrands.Business.Entries.MeSetDiscoveryNearbyLiveFriends, "settings_nearby_live_friend_switch");
        a(WeChatBrands.Business.Entries.MeSetDiscoveryNearbyLiveFriendsPerson, "settings_nearby_live_friend_person_switch");
        if (!((com.tencent.mm.plugin.teenmode.a.b)g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt()) {
          break label1822;
        }
        getPreferenceScreen().jdMethod_do("settings_nearby_live_friend_switch", true);
        getPreferenceScreen().jdMethod_do("settings_nearby_live_friend_person_switch", true);
        label879:
        localObject = d.JYo;
        if ((localObject == null) || (!((d.a)localObject).fsY())) {
          break label2211;
        }
      }
      label1822:
      label2211:
      for (bool1 = true;; bool1 = false)
      {
        Log.i("MicroMsg.SettingsManageFindMoreUI", "showShopping %s", new Object[] { Boolean.valueOf(bool1) });
        bool2 = ((com.tencent.mm.plugin.teenmode.a.b)g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt();
        localObject = (CheckBoxPreference)getPreferenceScreen().bmg("settings_shopping_switch");
        ((Preference)localObject).OZw = false;
        if ((bool1) && (!bool2))
        {
          getPreferenceScreen().jdMethod_do("settings_shopping_switch", false);
          label980:
          if (!IK(4194304L)) {
            break label2046;
          }
          ((CheckBoxPreference)localObject).setChecked(false);
          this.Dct.put(Integer.valueOf(6), Integer.valueOf(0));
          label1013:
          a(WeChatBrands.Business.Entries.MeSetDiscoveryShop, "settings_shopping_switch");
          localObject = b.a.dSQ();
          localCheckBoxPreference = (CheckBoxPreference)getPreferenceScreen().bmg("settings_game_switch");
          localCheckBoxPreference.OZw = false;
          bool1 = ((com.tencent.mm.plugin.teenmode.a.b)g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt();
          if ((localObject == null) || (!((com.tencent.mm.plugin.game.api.b)localObject).dSE()) || (bool1)) {
            break label2098;
          }
          if (!IK(8388608L)) {
            break label2072;
          }
          localCheckBoxPreference.setChecked(false);
          this.Dct.put(Integer.valueOf(7), Integer.valueOf(0));
          label1118:
          a(WeChatBrands.Business.Entries.MeSetDiscoveryGame, "settings_game_switch");
          localObject = new us();
          ((us)localObject).eaU.eaW = true;
          EventCenter.instance.publish((IEvent)localObject);
          bool2 = ((us)localObject).eaV.eaX;
          if ((!((com.tencent.mm.plugin.teenmode.a.b)g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt()) || (((com.tencent.mm.plugin.teenmode.a.b)g.af(com.tencent.mm.plugin.teenmode.a.b.class)).dxW() != 2)) {
            break label2115;
          }
          bool1 = true;
          label1201:
          Log.i("MicroMsg.SettingsManageFindMoreUI", "shouldShowMiniProgram %s, isTeenModeAndNotAccessRight:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
          localObject = (CheckBoxPreference)getPreferenceScreen().bmg("settings_miniprogram_switch");
          ((Preference)localObject).OZw = false;
          if ((!bool2) || (bool1)) {
            break label2146;
          }
          if (!IK(16777216L)) {
            break label2120;
          }
          ((CheckBoxPreference)localObject).setChecked(false);
          this.Dct.put(Integer.valueOf(8), Integer.valueOf(0));
          a(WeChatBrands.Business.Entries.MeSetDiscoveryAppbrand, "settings_miniprogram_switch");
          localObject = (CheckBoxPreference)getPreferenceScreen().bmg("settings_wechatout_switch");
          if (com.tencent.mm.n.h.aqJ().getInt("WCOEntranceSwitch", 0) <= 0) {
            break label2163;
          }
          bool1 = true;
          label1333:
          Log.i("MicroMsg.SettingsManageFindMoreUI", "showWeChatOut %s", new Object[] { Boolean.valueOf(bool1) });
          if (!bool1) {
            break label2194;
          }
          ((Preference)localObject).OZw = false;
          if (!IK(33554432L)) {
            break label2168;
          }
          ((CheckBoxPreference)localObject).setChecked(false);
          this.Dct.put(Integer.valueOf(9), Integer.valueOf(0));
        }
        for (;;)
        {
          a(WeChatBrands.Business.Entries.MeSetDiscoveryWeChatOut, "settings_wechatout_switch");
          localObject = getPreferenceScreen().bmg("settings_switch_bottom_tip");
          if (com.tencent.mm.aw.b.Pi((String)g.aAh().azQ().get(274436, null))) {
            ((Preference)localObject).setTitle(2131765445);
          }
          getPreferenceScreen().notifyDataSetChanged();
          AppMethodBeat.o(74213);
          return;
          ((CheckBoxPreference)localObject).setChecked(false);
          this.Dct.put(Integer.valueOf(0), Integer.valueOf(0));
          break;
          label1490:
          i = 0;
          break label172;
          label1495:
          localObject = (CheckBoxPreference)getPreferenceScreen().bmg("settings_finder_switch");
          ((Preference)localObject).OZw = false;
          if (IK(34359738368L))
          {
            ((CheckBoxPreference)localObject).setChecked(false);
            this.Dct.put(Integer.valueOf(11), Integer.valueOf(0));
          }
          for (;;)
          {
            a(WeChatBrands.Business.Entries.MeSetDiscoveryChannels, "settings_finder_switch");
            break;
            ((CheckBoxPreference)localObject).setChecked(true);
            this.Dct.put(Integer.valueOf(11), Integer.valueOf(1));
          }
          label1590:
          ((CheckBoxPreference)localObject).setChecked(true);
          this.Dct.put(Integer.valueOf(1), Integer.valueOf(1));
          break label249;
          label1615:
          ((CheckBoxPreference)localObject).setChecked(false);
          this.Dct.put(Integer.valueOf(2), Integer.valueOf(0));
          break label335;
          label1640:
          getPreferenceScreen().jdMethod_do("settings_shake_switch", false);
          break label376;
          label1657:
          bool1 = false;
          break label411;
          if ((!bool2) || (bool3))
          {
            getPreferenceScreen().jdMethod_do("settings_look_switch", true);
            break label545;
          }
          getPreferenceScreen().jdMethod_do("settings_look_switch", false);
          ((CheckBoxPreference)localObject).setChecked(false);
          this.Dct.put(Integer.valueOf(10), Integer.valueOf(0));
          break label545;
          label1728:
          ((CheckBoxPreference)localObject).setChecked(true);
          this.Dct.put(Integer.valueOf(3), Integer.valueOf(1));
          break label610;
          label1753:
          bool1 = false;
          break label714;
          label1758:
          ((CheckBoxPreference)localObject).setChecked(false);
          this.Dct.put(Integer.valueOf(5), Integer.valueOf(0));
          getPreferenceScreen().jdMethod_do("settings_nearby_live_friend_person_switch", true);
          break label788;
          localCheckBoxPreference.setChecked(false);
          this.Dct.put(Integer.valueOf(4), Integer.valueOf(0));
          break label814;
          getPreferenceScreen().jdMethod_do("settings_nearby_live_friend_switch", false);
          break label879;
          label1839:
          getPreferenceScreen().jdMethod_do("settings_nearby_live_friend_switch", true);
          getPreferenceScreen().jdMethod_do("settings_nearby_live_friend_person_switch", true);
          localObject = (CheckBoxPreference)getPreferenceScreen().bmg("settings_nearby_switch");
          ((Preference)localObject).OZw = false;
          bool1 = IL(512L);
          Log.i("MicroMsg.SettingsManageFindMoreUI", "openNearby %s", new Object[] { Boolean.valueOf(bool1) });
          if (bool1)
          {
            ((CheckBoxPreference)localObject).setChecked(true);
            this.Dct.put(Integer.valueOf(4), Integer.valueOf(1));
          }
          for (;;)
          {
            a(WeChatBrands.Business.Entries.MeSetDiscoveryNearby, "settings_nearby_switch");
            if (!((com.tencent.mm.plugin.teenmode.a.b)g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt()) {
              break label2012;
            }
            getPreferenceScreen().jdMethod_do("settings_nearby_switch", true);
            break;
            ((CheckBoxPreference)localObject).setChecked(false);
            this.Dct.put(Integer.valueOf(4), Integer.valueOf(0));
          }
          label2012:
          getPreferenceScreen().jdMethod_do("settings_nearby_switch", false);
          break label879;
          getPreferenceScreen().jdMethod_do("settings_shopping_switch", true);
          break label980;
          label2046:
          ((CheckBoxPreference)localObject).setChecked(true);
          this.Dct.put(Integer.valueOf(6), Integer.valueOf(1));
          break label1013;
          localCheckBoxPreference.setChecked(true);
          this.Dct.put(Integer.valueOf(7), Integer.valueOf(1));
          break label1118;
          label2098:
          getPreferenceScreen().jdMethod_do("settings_game_switch", true);
          break label1118;
          label2115:
          bool1 = false;
          break label1201;
          label2120:
          ((CheckBoxPreference)localObject).setChecked(true);
          this.Dct.put(Integer.valueOf(8), Integer.valueOf(1));
          break label1291;
          label2146:
          getPreferenceScreen().jdMethod_do("settings_miniprogram_switch", true);
          break label1291;
          label2163:
          bool1 = false;
          break label1333;
          label2168:
          ((CheckBoxPreference)localObject).setChecked(true);
          this.Dct.put(Integer.valueOf(9), Integer.valueOf(1));
          continue;
          getPreferenceScreen().jdMethod_do("settings_wechatout_switch", true);
        }
      }
      label2072:
      label2216:
      bool2 = true;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74210);
    super.onCreate(paramBundle);
    this.qAb = z.aUd();
    this.Dcv = z.aUl();
    Log.i("MicroMsg.SettingsManageFindMoreUI", "onCreate extStatus %d, pluginFlag %d", new Object[] { Long.valueOf(this.qAb), Integer.valueOf(this.Dcv) });
    initView();
    AppMethodBeat.o(74210);
  }
  
  public boolean onPreferenceTreeClick(final com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    long l2 = 0L;
    long l1 = 1L;
    int j = 0;
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
      U(paramf.isChecked(), 32768);
      i = 0;
    }
    for (;;)
    {
      if (paramf.isChecked()) {
        j = 1;
      }
      if (i >= 0) {
        this.Dcu.put(Integer.valueOf(i), Integer.valueOf(j));
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
        b(paramf.isChecked(), 1048576L, 49);
        i = 1;
      }
      else if (paramPreference.equals("settings_search_switch"))
      {
        if (!WeChatBrands.Business.Entries.MeSetDiscoverySearch.checkAvailable(this))
        {
          AppMethodBeat.o(74212);
          return true;
        }
        if (!paramf.isChecked())
        {
          if (((i)g.af(i.class)).b(this, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(74206);
              paramf.setChecked(false);
              SettingsManageFindMoreUI.a(SettingsManageFindMoreUI.this, paramf.isChecked());
              AppMethodBeat.o(74206);
            }
          })) {
            MMHandlerThread.postToMainThreadDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(74207);
                paramf.setChecked(true);
                AppMethodBeat.o(74207);
              }
            }, 500L);
          }
          i = 3;
        }
        else
        {
          b(paramf.isChecked(), 2097152L, 50);
          i = 3;
        }
      }
      else if (paramPreference.equals("settings_shopping_switch"))
      {
        if (!WeChatBrands.Business.Entries.MeSetDiscoveryShop.checkAvailable(this))
        {
          AppMethodBeat.o(74212);
          return true;
        }
        i = 6;
        b(paramf.isChecked(), 4194304L, 51);
      }
      else
      {
        if (paramPreference.equals("settings_game_switch"))
        {
          if (!WeChatBrands.Business.Entries.MeSetDiscoveryGame.checkAvailable(this))
          {
            AppMethodBeat.o(74212);
            return true;
          }
          b(paramf.isChecked(), 8388608L, 52);
          paramPreference = com.tencent.mm.plugin.report.service.h.CyF;
          if (paramf.isChecked()) {}
          for (l1 = l2;; l1 = 1L)
          {
            paramPreference.idkeyStat(848L, l1, 1L, false);
            i = 7;
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
        }
        else if (paramPreference.equals("settings_wechatout_switch"))
        {
          if (!WeChatBrands.Business.Entries.MeSetDiscoveryWeChatOut.checkAvailable(this))
          {
            AppMethodBeat.o(74212);
            return true;
          }
          i = 9;
          b(paramf.isChecked(), 33554432L, 54);
        }
        else if (paramPreference.equals("settings_shake_switch"))
        {
          if (!WeChatBrands.Business.Entries.MeSetDiscoveryShake.checkAvailable(this))
          {
            AppMethodBeat.o(74212);
            return true;
          }
          i = 2;
          U(paramf.isChecked(), 256);
        }
        else if (paramPreference.equals("settings_nearby_switch"))
        {
          if (!WeChatBrands.Business.Entries.MeSetDiscoveryNearby.checkAvailable(this))
          {
            AppMethodBeat.o(74212);
            return true;
          }
          i = 4;
          U(paramf.isChecked(), 512);
        }
        else
        {
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
              label630:
              paramPreference.jdMethod_do("settings_nearby_live_friend_person_switch", bool);
              paramPreference = com.tencent.mm.plugin.setting.a.a.CYr;
              if (!paramf.isChecked()) {
                break label672;
              }
            }
            for (;;)
            {
              com.tencent.mm.plugin.setting.a.a.ak(12L, l1);
              i = 5;
              break;
              bool = false;
              break label630;
              label672:
              l1 = 0L;
            }
          }
          if (paramPreference.equals("settings_nearby_live_friend_person_switch"))
          {
            if (!WeChatBrands.Business.Entries.MeSetDiscoveryNearbyLiveFriendsPerson.checkAvailable(this))
            {
              AppMethodBeat.o(74212);
              return true;
            }
            i = 12;
            U(paramf.isChecked(), 512);
            paramPreference = com.tencent.mm.plugin.setting.a.a.CYr;
            if (paramf.isChecked()) {}
            for (;;)
            {
              com.tencent.mm.plugin.setting.a.a.ak(13L, l1);
              break;
              l1 = 0L;
            }
          }
          if (paramPreference.equals("settings_look_switch"))
          {
            if (!WeChatBrands.Business.Entries.MeSetDiscoveryLooks.checkAvailable(this))
            {
              AppMethodBeat.o(74212);
              return true;
            }
            ((com.tencent.mm.plugin.welab.a.a.a)g.af(com.tencent.mm.plugin.welab.a.a.a.class)).cR("labs_browse", paramf.isChecked());
            if (paramf.isChecked())
            {
              this.qAb &= 0xFBFFFFFF;
              i = 10;
            }
            else
            {
              this.qAb |= 0x4000000;
              i = 10;
            }
          }
          else if (paramPreference.equals("settings_finder_switch"))
          {
            if (!WeChatBrands.Business.Entries.MeSetDiscoveryChannels.checkAvailable(this))
            {
              AppMethodBeat.o(74212);
              return true;
            }
            i = 11;
            b(paramf.isChecked(), 34359738368L, 57);
          }
        }
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