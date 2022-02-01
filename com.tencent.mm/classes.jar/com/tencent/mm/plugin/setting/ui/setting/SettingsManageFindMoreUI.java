package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bd.l;
import com.tencent.mm.f.a.vv;
import com.tencent.mm.f.a.vv.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.findersdk.a.ag;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.b.k;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.pluginsdk.j.d;
import com.tencent.mm.pluginsdk.j.d.a;
import com.tencent.mm.protocal.protobuf.bmy;
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
  private HashMap<Integer, Integer> JhU;
  private HashMap<Integer, Integer> JhV;
  private int JhW;
  private HashMap<Integer, Integer> mSR;
  private long tZb;
  
  public SettingsManageFindMoreUI()
  {
    AppMethodBeat.i(74209);
    this.mSR = new HashMap();
    this.JhU = new HashMap();
    this.JhV = new HashMap();
    AppMethodBeat.o(74209);
  }
  
  private boolean Hh(long paramLong)
  {
    return (this.tZb & paramLong) != 0L;
  }
  
  private boolean Qe(long paramLong)
  {
    return (this.JhW & paramLong) == 0L;
  }
  
  private void a(WeChatBrands.Business.Entries paramEntries, String paramString)
  {
    AppMethodBeat.i(264657);
    if (paramEntries.restricted())
    {
      if (paramEntries.banned())
      {
        getPreferenceScreen().dz(paramString, true);
        AppMethodBeat.o(264657);
        return;
      }
      paramString = (CheckBoxPreference)getPreferenceScreen().byG(paramString);
      paramString.hKB();
      paramString.setOnClickListener(new SettingsManageFindMoreUI.4(this, paramEntries));
    }
    AppMethodBeat.o(264657);
  }
  
  private void af(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(74216);
    Log.i("MicroMsg.SettingsManageFindMoreUI", "switch plugin flag, open %s, flag %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (!paramBoolean)
    {
      this.JhW |= paramInt;
      AppMethodBeat.o(74216);
      return;
    }
    this.JhW &= (paramInt ^ 0xFFFFFFFF);
    AppMethodBeat.o(74216);
  }
  
  private void b(boolean paramBoolean, long paramLong, int paramInt)
  {
    AppMethodBeat.i(164133);
    Log.i("MicroMsg.SettingsManageFindMoreUI", "switch ext change : open = " + paramBoolean + " item value = " + paramLong + " functionId = " + paramInt);
    if (paramBoolean)
    {
      this.tZb &= (0xFFFFFFFF ^ paramLong);
      if (!paramBoolean) {
        break label107;
      }
    }
    label107:
    for (int i = 1;; i = 2)
    {
      this.mSR.put(Integer.valueOf(paramInt), Integer.valueOf(i));
      AppMethodBeat.o(164133);
      return;
      this.tZb |= paramLong;
      break;
    }
  }
  
  private void cig()
  {
    AppMethodBeat.i(74217);
    Iterator localIterator = this.JhV.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      if ((this.JhU.containsKey(Integer.valueOf(i))) && (this.JhU.get(Integer.valueOf(i)) != this.JhV.get(Integer.valueOf(i))))
      {
        com.tencent.mm.plugin.report.service.h.IzE.a(15185, new Object[] { Integer.valueOf(i), this.JhV.get(Integer.valueOf(i)), Integer.valueOf(1) });
        if (i == 0) {
          if (((Integer)this.JhV.get(Integer.valueOf(i))).intValue() == 0) {
            com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VwB, Integer.valueOf(-1));
          } else if (((Integer)this.JhV.get(Integer.valueOf(i))).intValue() == 1) {
            com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VwB, Integer.valueOf(1));
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
    Log.i("MicroMsg.SettingsManageFindMoreUI", "oplog extstatus:" + this.tZb + ",pluginFlag:" + this.JhW);
    com.tencent.mm.kernel.h.aHG().aHp().i(147457, Long.valueOf(this.tZb));
    com.tencent.mm.kernel.h.aHG().aHp().i(34, Integer.valueOf(this.JhW));
    Iterator localIterator = this.mSR.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      int i = ((Integer)((Map.Entry)localObject).getKey()).intValue();
      int j = ((Integer)((Map.Entry)localObject).getValue()).intValue();
      localObject = new bmy();
      ((bmy)localObject).SXP = i;
      ((bmy)localObject).HmX = j;
      ((n)com.tencent.mm.kernel.h.ae(n.class)).bbK().d(new k.a(23, (com.tencent.mm.cd.a)localObject));
      Log.d("MicroMsg.SettingsManageFindMoreUI", "switch  " + i + " " + j);
    }
    this.mSR.clear();
    ((n)com.tencent.mm.kernel.h.ae(n.class)).bbK().d(new l("", "", "", "", "", "", "", "", this.JhW, "", ""));
    cig();
    AppMethodBeat.o(74215);
  }
  
  public int getResourceId()
  {
    return b.k.settings_pref_manage_findmoreui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74213);
    setMMTitle(b.i.settings_manage_findmoreui);
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
    Object localObject1 = (CheckBoxPreference)getPreferenceScreen().byG("settings_sns_switch");
    ((Preference)localObject1).WsF = false;
    boolean bool1 = Qe(32768L);
    Log.i("MicroMsg.SettingsManageFindMoreUI", "openSns %s", new Object[] { Boolean.valueOf(bool1) });
    int i;
    label172:
    boolean bool2;
    if (bool1)
    {
      ((CheckBoxPreference)localObject1).setChecked(true);
      this.JhU.put(Integer.valueOf(0), Integer.valueOf(1));
      bool1 = ((ak)com.tencent.mm.kernel.h.ag(ak.class)).showFinderEntry();
      Log.i("MicroMsg.SettingsManageFindMoreUI", "showFinder %s", new Object[] { Boolean.valueOf(bool1) });
      if ((!((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).ZM()) || (((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).dYS() != 2)) {
        break label1645;
      }
      i = 1;
      if ((bool1) && (i == 0)) {
        break label1650;
      }
      getPreferenceScreen().dz("settings_finder_switch", true);
      bool1 = ((ak)com.tencent.mm.kernel.h.ag(ak.class)).getFinderUtilApi().eeH();
      Log.i("MicroMsg.SettingsManageFindMoreUI", "showFinderLiveEntry %s", new Object[] { Boolean.valueOf(bool1) });
      localObject1 = com.tencent.mm.plugin.finder.nearby.abtest.a.zDp;
      if (!com.tencent.mm.plugin.finder.nearby.abtest.a.cFx()) {
        break label1745;
      }
      getPreferenceScreen().dz("settings_finder_live_switch", true);
      label258:
      bool2 = ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).ZM();
      if ((bool1) && (!bool2)) {
        break label1762;
      }
      getPreferenceScreen().dz("settings_finder_live_switch", true);
      getPreferenceScreen().dz("settings_finder_live_above_look_switch", true);
      localObject1 = (CheckBoxPreference)getPreferenceScreen().byG("settings_scan_switch");
      ((Preference)localObject1).WsF = false;
      if (!Hh(1048576L)) {
        break label1875;
      }
      ((CheckBoxPreference)localObject1).setChecked(false);
      this.JhU.put(Integer.valueOf(1), Integer.valueOf(0));
      label364:
      a(WeChatBrands.Business.Entries.GlobalScan, "settings_scan_switch");
      localObject1 = (CheckBoxPreference)getPreferenceScreen().byG("settings_shake_switch");
      ((Preference)localObject1).WsF = false;
      bool1 = Qe(256L);
      Log.i("MicroMsg.SettingsManageFindMoreUI", "openShake %s", new Object[] { Boolean.valueOf(bool1) });
      if (!bool1) {
        break label1900;
      }
      ((CheckBoxPreference)localObject1).setChecked(true);
      this.JhU.put(Integer.valueOf(2), Integer.valueOf(1));
      label450:
      a(WeChatBrands.Business.Entries.MeSetDiscoveryShake, "settings_shake_switch");
      if (!((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).ZM()) {
        break label1925;
      }
      getPreferenceScreen().dz("settings_shake_switch", true);
      label491:
      localObject1 = (CheckBoxPreference)getPreferenceScreen().byG("settings_look_switch");
      ((Preference)localObject1).WsF = false;
      if (Hh(67108864L)) {
        break label1942;
      }
      bool1 = true;
      label526:
      if (!com.tencent.mm.az.b.WF((String)com.tencent.mm.kernel.h.aHG().aHp().b(274436, null))) {
        break label2522;
      }
      getPreferenceScreen().dz("settings_look_switch", true);
      Log.i("MicroMsg.SettingsManageFindMoreUI", "european user");
      bool2 = false;
      bool1 = false;
    }
    label660:
    label834:
    label969:
    label2378:
    for (;;)
    {
      boolean bool3 = ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).ZM();
      Log.i("MicroMsg.SettingsManageFindMoreUI", "isInExperiment %s ,openLook %s, isTeenMode:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
      label725:
      Object localObject2;
      if ((bool2) && (bool1) && (!bool3))
      {
        ((CheckBoxPreference)localObject1).setChecked(true);
        this.JhU.put(Integer.valueOf(10), Integer.valueOf(1));
        a(WeChatBrands.Business.Entries.MeSetDiscoveryLooks, "settings_look_switch");
        localObject1 = (CheckBoxPreference)getPreferenceScreen().byG("settings_search_switch");
        ((Preference)localObject1).WsF = false;
        if (!Hh(2097152L)) {
          break label2013;
        }
        ((CheckBoxPreference)localObject1).setChecked(false);
        this.JhU.put(Integer.valueOf(3), Integer.valueOf(0));
        a(WeChatBrands.Business.Entries.MeSetDiscoverySearch, "settings_search_switch");
        if (!((ak)com.tencent.mm.kernel.h.ag(ak.class)).getFinderUtilApi().eeI()) {
          break label2145;
        }
        getPreferenceScreen().dz("settings_nearby_switch", true);
        localObject1 = (CheckBoxPreference)getPreferenceScreen().byG("settings_nearby_live_friend_switch");
        ((Preference)localObject1).WsF = false;
        if (!((ak)com.tencent.mm.kernel.h.ag(ak.class)).getFinderUtilApi().eeH()) {
          break label2038;
        }
        ((CheckBoxPreference)localObject1).setTitle(getContext().getResources().getString(b.i.find_friends_by_nearby_title));
        localObject2 = (CheckBoxPreference)getPreferenceScreen().byG("settings_nearby_live_friend_person_switch");
        ((Preference)localObject2).WsF = false;
        if (Hh(70368744177664L)) {
          break label2059;
        }
        bool1 = true;
        label869:
        bool2 = Qe(512L);
        Log.i("MicroMsg.SettingsManageFindMoreUI", "openNearbyLiveFriends:%s openNearbyLiveFriendsPerson:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        if (!bool1) {
          break label2064;
        }
        ((CheckBoxPreference)localObject1).setChecked(true);
        this.JhU.put(Integer.valueOf(5), Integer.valueOf(1));
        getPreferenceScreen().dz("settings_nearby_live_friend_person_switch", false);
        if (!bool2) {
          break label2103;
        }
        ((CheckBoxPreference)localObject2).setChecked(true);
        this.JhU.put(Integer.valueOf(4), Integer.valueOf(1));
        a(WeChatBrands.Business.Entries.MeSetDiscoveryNearbyLiveFriends, "settings_nearby_live_friend_switch");
        a(WeChatBrands.Business.Entries.MeSetDiscoveryNearbyLiveFriendsPerson, "settings_nearby_live_friend_person_switch");
        if (!((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).ZM()) {
          break label2128;
        }
        getPreferenceScreen().dz("settings_nearby_live_friend_switch", true);
        getPreferenceScreen().dz("settings_nearby_live_friend_person_switch", true);
        localObject1 = d.QYQ;
        if ((localObject1 == null) || (!((d.a)localObject1).ghx())) {
          break label2517;
        }
      }
      label1356:
      label1488:
      label1745:
      label1875:
      label2517:
      for (bool1 = true;; bool1 = false)
      {
        Log.i("MicroMsg.SettingsManageFindMoreUI", "showShopping %s", new Object[] { Boolean.valueOf(bool1) });
        bool2 = ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).ZM();
        localObject1 = (CheckBoxPreference)getPreferenceScreen().byG("settings_shopping_switch");
        ((Preference)localObject1).WsF = false;
        if ((bool1) && (!bool2))
        {
          getPreferenceScreen().dz("settings_shopping_switch", false);
          label1135:
          if (!Hh(4194304L)) {
            break label2352;
          }
          ((CheckBoxPreference)localObject1).setChecked(false);
          this.JhU.put(Integer.valueOf(6), Integer.valueOf(0));
          a(WeChatBrands.Business.Entries.MeSetDiscoveryShop, "settings_shopping_switch");
          localObject1 = b.a.evu();
          localObject2 = (CheckBoxPreference)getPreferenceScreen().byG("settings_game_switch");
          ((Preference)localObject2).WsF = false;
          bool1 = ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).ZM();
          if ((localObject1 == null) || (!((com.tencent.mm.plugin.game.api.b)localObject1).evh()) || (bool1)) {
            break label2404;
          }
          if (!Hh(8388608L)) {
            break label2378;
          }
          ((CheckBoxPreference)localObject2).setChecked(false);
          this.JhU.put(Integer.valueOf(7), Integer.valueOf(0));
          label1273:
          a(WeChatBrands.Business.Entries.MeSetDiscoveryGame, "settings_game_switch");
          localObject1 = new vv();
          ((vv)localObject1).fUR.fUT = true;
          EventCenter.instance.publish((IEvent)localObject1);
          bool2 = ((vv)localObject1).fUS.fUU;
          if ((!((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).ZM()) || (((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).dYS() != 2)) {
            break label2421;
          }
          bool1 = true;
          Log.i("MicroMsg.SettingsManageFindMoreUI", "shouldShowMiniProgram %s, isTeenModeAndNotAccessRight:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
          localObject1 = (CheckBoxPreference)getPreferenceScreen().byG("settings_miniprogram_switch");
          ((Preference)localObject1).WsF = false;
          if ((!bool2) || (bool1)) {
            break label2452;
          }
          if (!Hh(16777216L)) {
            break label2426;
          }
          ((CheckBoxPreference)localObject1).setChecked(false);
          this.JhU.put(Integer.valueOf(8), Integer.valueOf(0));
          a(WeChatBrands.Business.Entries.MeSetDiscoveryAppbrand, "settings_miniprogram_switch");
          localObject1 = (CheckBoxPreference)getPreferenceScreen().byG("settings_wechatout_switch");
          if (com.tencent.mm.n.h.axc().getInt("WCOEntranceSwitch", 0) <= 0) {
            break label2469;
          }
          bool1 = true;
          Log.i("MicroMsg.SettingsManageFindMoreUI", "showWeChatOut %s", new Object[] { Boolean.valueOf(bool1) });
          if (!bool1) {
            break label2500;
          }
          ((Preference)localObject1).WsF = false;
          if (!Hh(33554432L)) {
            break label2474;
          }
          ((CheckBoxPreference)localObject1).setChecked(false);
          this.JhU.put(Integer.valueOf(9), Integer.valueOf(0));
        }
        for (;;)
        {
          a(WeChatBrands.Business.Entries.MeSetDiscoveryWeChatOut, "settings_wechatout_switch");
          localObject1 = getPreferenceScreen().byG("settings_switch_bottom_tip");
          if (com.tencent.mm.az.b.WF((String)com.tencent.mm.kernel.h.aHG().aHp().b(274436, null))) {
            ((Preference)localObject1).setTitle(b.i.settings_manage_plugin_eu_hint);
          }
          getPreferenceScreen().notifyDataSetChanged();
          AppMethodBeat.o(74213);
          return;
          ((CheckBoxPreference)localObject1).setChecked(false);
          this.JhU.put(Integer.valueOf(0), Integer.valueOf(0));
          break;
          label1645:
          i = 0;
          break label172;
          label1650:
          localObject1 = (CheckBoxPreference)getPreferenceScreen().byG("settings_finder_switch");
          ((Preference)localObject1).WsF = false;
          if (Hh(34359738368L))
          {
            ((CheckBoxPreference)localObject1).setChecked(false);
            this.JhU.put(Integer.valueOf(11), Integer.valueOf(0));
          }
          for (;;)
          {
            a(WeChatBrands.Business.Entries.MeSetDiscoveryChannels, "settings_finder_switch");
            break;
            ((CheckBoxPreference)localObject1).setChecked(true);
            this.JhU.put(Integer.valueOf(11), Integer.valueOf(1));
          }
          getPreferenceScreen().dz("settings_finder_live_above_look_switch", true);
          break label258;
          label1762:
          localObject1 = getPreferenceScreen();
          localObject2 = com.tencent.mm.plugin.finder.nearby.abtest.a.zDp;
          localObject1 = (CheckBoxPreference)((com.tencent.mm.ui.base.preference.f)localObject1).byG(com.tencent.mm.plugin.finder.nearby.abtest.a.eoO());
          ((Preference)localObject1).WsF = false;
          if (Hh(9007199254740992L))
          {
            ((CheckBoxPreference)localObject1).setChecked(false);
            this.JhU.put(Integer.valueOf(13), Integer.valueOf(0));
          }
          for (;;)
          {
            localObject1 = WeChatBrands.Business.Entries.MeSetDiscoveryFinderLive;
            localObject2 = com.tencent.mm.plugin.finder.nearby.abtest.a.zDp;
            a((WeChatBrands.Business.Entries)localObject1, com.tencent.mm.plugin.finder.nearby.abtest.a.eoO());
            break;
            ((CheckBoxPreference)localObject1).setChecked(true);
            this.JhU.put(Integer.valueOf(13), Integer.valueOf(1));
          }
          ((CheckBoxPreference)localObject1).setChecked(true);
          this.JhU.put(Integer.valueOf(1), Integer.valueOf(1));
          break label364;
          label1900:
          ((CheckBoxPreference)localObject1).setChecked(false);
          this.JhU.put(Integer.valueOf(2), Integer.valueOf(0));
          break label450;
          getPreferenceScreen().dz("settings_shake_switch", false);
          break label491;
          bool1 = false;
          break label526;
          if ((!bool2) || (bool3))
          {
            getPreferenceScreen().dz("settings_look_switch", true);
            break label660;
          }
          getPreferenceScreen().dz("settings_look_switch", false);
          ((CheckBoxPreference)localObject1).setChecked(false);
          this.JhU.put(Integer.valueOf(10), Integer.valueOf(0));
          break label660;
          label2013:
          ((CheckBoxPreference)localObject1).setChecked(true);
          this.JhU.put(Integer.valueOf(3), Integer.valueOf(1));
          break label725;
          label2038:
          ((CheckBoxPreference)localObject1).setTitle(getContext().getResources().getString(b.i.nearby_live_friend_title));
          break label834;
          bool1 = false;
          break label869;
          ((CheckBoxPreference)localObject1).setChecked(false);
          this.JhU.put(Integer.valueOf(5), Integer.valueOf(0));
          getPreferenceScreen().dz("settings_nearby_live_friend_person_switch", true);
          break label943;
          ((CheckBoxPreference)localObject2).setChecked(false);
          this.JhU.put(Integer.valueOf(4), Integer.valueOf(0));
          break label969;
          getPreferenceScreen().dz("settings_nearby_live_friend_switch", false);
          break label1034;
          label2145:
          getPreferenceScreen().dz("settings_nearby_live_friend_switch", true);
          getPreferenceScreen().dz("settings_nearby_live_friend_person_switch", true);
          localObject1 = (CheckBoxPreference)getPreferenceScreen().byG("settings_nearby_switch");
          ((Preference)localObject1).WsF = false;
          bool1 = Qe(512L);
          Log.i("MicroMsg.SettingsManageFindMoreUI", "openNearby %s", new Object[] { Boolean.valueOf(bool1) });
          if (bool1)
          {
            ((CheckBoxPreference)localObject1).setChecked(true);
            this.JhU.put(Integer.valueOf(4), Integer.valueOf(1));
          }
          for (;;)
          {
            a(WeChatBrands.Business.Entries.MeSetDiscoveryNearby, "settings_nearby_switch");
            if (!((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).ZM()) {
              break label2318;
            }
            getPreferenceScreen().dz("settings_nearby_switch", true);
            break;
            ((CheckBoxPreference)localObject1).setChecked(false);
            this.JhU.put(Integer.valueOf(4), Integer.valueOf(0));
          }
          getPreferenceScreen().dz("settings_nearby_switch", false);
          break label1034;
          getPreferenceScreen().dz("settings_shopping_switch", true);
          break label1135;
          ((CheckBoxPreference)localObject1).setChecked(true);
          this.JhU.put(Integer.valueOf(6), Integer.valueOf(1));
          break label1168;
          ((CheckBoxPreference)localObject2).setChecked(true);
          this.JhU.put(Integer.valueOf(7), Integer.valueOf(1));
          break label1273;
          label2404:
          getPreferenceScreen().dz("settings_game_switch", true);
          break label1273;
          label2421:
          bool1 = false;
          break label1356;
          label2426:
          ((CheckBoxPreference)localObject1).setChecked(true);
          this.JhU.put(Integer.valueOf(8), Integer.valueOf(1));
          break label1446;
          getPreferenceScreen().dz("settings_miniprogram_switch", true);
          break label1446;
          bool1 = false;
          break label1488;
          ((CheckBoxPreference)localObject1).setChecked(true);
          this.JhU.put(Integer.valueOf(9), Integer.valueOf(1));
          continue;
          getPreferenceScreen().dz("settings_wechatout_switch", true);
        }
      }
      label2128:
      label2522:
      bool2 = true;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74210);
    super.onCreate(paramBundle);
    this.tZb = z.bde();
    this.JhW = z.bdn();
    Log.i("MicroMsg.SettingsManageFindMoreUI", "onCreate extStatus %d, pluginFlag %d", new Object[] { Long.valueOf(this.tZb), Integer.valueOf(this.JhW) });
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
      af(paramf.isChecked(), 32768);
      i = 0;
    }
    label630:
    do
    {
      for (;;)
      {
        if (paramf.isChecked()) {
          j = 1;
        }
        if (i >= 0) {
          this.JhV.put(Integer.valueOf(i), Integer.valueOf(j));
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
            if (((i)com.tencent.mm.kernel.h.ae(i.class)).b(this, new Runnable()
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
            paramPreference = com.tencent.mm.plugin.report.service.h.IzE;
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
            af(paramf.isChecked(), 256);
          }
          else if (paramPreference.equals("settings_nearby_switch"))
          {
            if (!WeChatBrands.Business.Entries.MeSetDiscoveryNearby.checkAvailable(this))
            {
              AppMethodBeat.o(74212);
              return true;
            }
            i = 4;
            af(paramf.isChecked(), 512);
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
                paramPreference.dz("settings_nearby_live_friend_person_switch", bool);
                paramPreference = com.tencent.mm.plugin.setting.a.a.JdX;
                if (!paramf.isChecked()) {
                  break label672;
                }
              }
              for (;;)
              {
                com.tencent.mm.plugin.setting.a.a.at(12L, l1);
                i = 5;
                break;
                bool = false;
                break label630;
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
              af(paramf.isChecked(), 512);
              paramPreference = com.tencent.mm.plugin.setting.a.a.JdX;
              if (paramf.isChecked()) {}
              for (;;)
              {
                com.tencent.mm.plugin.setting.a.a.at(13L, l1);
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
              ((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.welab.a.a.a.class)).df("labs_browse", paramf.isChecked());
              if (paramf.isChecked())
              {
                this.tZb &= 0xFBFFFFFF;
                i = 10;
              }
              else
              {
                this.tZb |= 0x4000000;
                i = 10;
              }
            }
            else
            {
              if (!paramPreference.equals("settings_finder_switch")) {
                break;
              }
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
      com.tencent.mm.plugin.finder.nearby.abtest.a locala = com.tencent.mm.plugin.finder.nearby.abtest.a.zDp;
    } while (!paramPreference.equals(com.tencent.mm.plugin.finder.nearby.abtest.a.eoO()));
    label672:
    if (!WeChatBrands.Business.Entries.MeSetDiscoveryFinderLive.checkAvailable(this))
    {
      AppMethodBeat.o(74212);
      return true;
    }
    i = 13;
    b(paramf.isChecked(), 9007199254740992L, 65);
    Log.i("MicroMsg.SettingsManageFindMoreUI", "switch finderlive 65");
    paramPreference = com.tencent.mm.plugin.setting.a.a.JdX;
    if (paramf.isChecked()) {}
    for (;;)
    {
      com.tencent.mm.plugin.setting.a.a.at(14L, l1);
      break;
      l1 = 0L;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsManageFindMoreUI
 * JD-Core Version:    0.7.0.1
 */