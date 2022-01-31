package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.k;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.g.a.qz.b;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.websearch.api.m;
import com.tencent.mm.pluginsdk.f.f.a;
import com.tencent.mm.protocal.protobuf.aek;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
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
  private HashMap<Integer, Integer> guf;
  private long kRf;
  private HashMap<Integer, Integer> qIM;
  private HashMap<Integer, Integer> qIN;
  private int qIO;
  
  public SettingsManageFindMoreUI()
  {
    AppMethodBeat.i(127271);
    this.guf = new HashMap();
    this.qIM = new HashMap();
    this.qIN = new HashMap();
    AppMethodBeat.o(127271);
  }
  
  private void C(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(127278);
    ab.i("MicroMsg.SettingsManageFindMoreUI", "switch plugin flag, open %s, flag %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (!paramBoolean)
    {
      this.qIO |= paramInt;
      AppMethodBeat.o(127278);
      return;
    }
    this.qIO &= (paramInt ^ 0xFFFFFFFF);
    AppMethodBeat.o(127278);
  }
  
  private boolean Dc(int paramInt)
  {
    return (this.kRf & paramInt) != 0L;
  }
  
  private boolean Dd(int paramInt)
  {
    return (this.qIO & paramInt) == 0;
  }
  
  private void bJP()
  {
    AppMethodBeat.i(127279);
    Iterator localIterator = this.qIN.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      if ((this.qIM.containsKey(Integer.valueOf(i))) && (this.qIM.get(Integer.valueOf(i)) != this.qIN.get(Integer.valueOf(i))))
      {
        com.tencent.mm.plugin.report.service.h.qsU.e(15185, new Object[] { Integer.valueOf(i), this.qIN.get(Integer.valueOf(i)) });
        if (i == 0) {
          if (((Integer)this.qIN.get(Integer.valueOf(i))).intValue() == 0) {
            com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yLm, Integer.valueOf(-1));
          } else if (((Integer)this.qIN.get(Integer.valueOf(i))).intValue() == 1) {
            com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yLm, Integer.valueOf(1));
          }
        }
      }
    }
    AppMethodBeat.o(127279);
  }
  
  private void g(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(127276);
    ab.i("MicroMsg.SettingsManageFindMoreUI", "switch ext change : open = " + paramBoolean + " item value = " + paramInt1 + " functionId = " + paramInt2);
    if (paramBoolean)
    {
      this.kRf &= (paramInt1 ^ 0xFFFFFFFF);
      if (!paramBoolean) {
        break label103;
      }
    }
    label103:
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      this.guf.put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
      AppMethodBeat.o(127276);
      return;
      this.kRf |= paramInt1;
      break;
    }
  }
  
  public com.tencent.mm.ui.base.preference.h createAdapter(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(127273);
    paramSharedPreferences = new com.tencent.mm.ui.base.preference.a(this, getListView(), paramSharedPreferences);
    AppMethodBeat.o(127273);
    return paramSharedPreferences;
  }
  
  public void finish()
  {
    AppMethodBeat.i(127277);
    super.finish();
    ab.i("MicroMsg.SettingsManageFindMoreUI", "oplog extstatus:" + this.kRf + ",pluginFlag:" + this.qIO);
    com.tencent.mm.kernel.g.RL().Ru().set(147457, Long.valueOf(this.kRf));
    com.tencent.mm.kernel.g.RL().Ru().set(34, Integer.valueOf(this.qIO));
    Iterator localIterator = this.guf.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      int i = ((Integer)((Map.Entry)localObject).getKey()).intValue();
      int j = ((Integer)((Map.Entry)localObject).getValue()).intValue();
      localObject = new aek();
      ((aek)localObject).wXn = i;
      ((aek)localObject).pKC = j;
      ((j)com.tencent.mm.kernel.g.E(j.class)).Yz().c(new j.a(23, (com.tencent.mm.bv.a)localObject));
      ab.d("MicroMsg.SettingsManageFindMoreUI", "switch  " + i + " " + j);
    }
    this.guf.clear();
    ((j)com.tencent.mm.kernel.g.E(j.class)).Yz().c(new k("", "", "", "", "", "", "", "", this.qIO, "", ""));
    bJP();
    AppMethodBeat.o(127277);
  }
  
  public int getResourceId()
  {
    return 2131165283;
  }
  
  public void initView()
  {
    AppMethodBeat.i(127275);
    setMMTitle(2131303298);
    setBackBtn(new SettingsManageFindMoreUI.3(this));
    Object localObject = (CheckBoxPreference)getPreferenceScreen().atx("settings_sns_switch");
    ((Preference)localObject).zsk = false;
    boolean bool1 = Dd(32768);
    ab.i("MicroMsg.SettingsManageFindMoreUI", "openSns %s", new Object[] { Boolean.valueOf(bool1) });
    label150:
    label223:
    boolean bool2;
    if (bool1)
    {
      ((CheckBoxPreference)localObject).vxW = true;
      this.qIM.put(Integer.valueOf(0), Integer.valueOf(1));
      localObject = (CheckBoxPreference)getPreferenceScreen().atx("settings_scan_switch");
      ((Preference)localObject).zsk = false;
      if (!Dc(1048576)) {
        break label945;
      }
      ((CheckBoxPreference)localObject).vxW = false;
      this.qIM.put(Integer.valueOf(1), Integer.valueOf(0));
      localObject = (CheckBoxPreference)getPreferenceScreen().atx("settings_shake_switch");
      ((Preference)localObject).zsk = false;
      bool1 = Dd(256);
      ab.i("MicroMsg.SettingsManageFindMoreUI", "openShake %s", new Object[] { Boolean.valueOf(bool1) });
      if (!bool1) {
        break label969;
      }
      ((CheckBoxPreference)localObject).vxW = true;
      this.qIM.put(Integer.valueOf(2), Integer.valueOf(1));
      localObject = (CheckBoxPreference)getPreferenceScreen().atx("settings_look_switch");
      ((Preference)localObject).zsk = false;
      if (Dc(67108864)) {
        break label993;
      }
      bool1 = true;
      label256:
      if (!com.tencent.mm.au.b.tM((String)com.tencent.mm.kernel.g.RL().Ru().get(274436, null))) {
        break label1279;
      }
      getPreferenceScreen().cl("settings_look_switch", true);
      ab.i("MicroMsg.SettingsManageFindMoreUI", "european user");
      bool2 = false;
      bool1 = false;
    }
    label410:
    label559:
    label591:
    label1233:
    for (;;)
    {
      ab.i("MicroMsg.SettingsManageFindMoreUI", "isInExperiment %s ,openLook %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((bool2) && (bool1))
      {
        ((CheckBoxPreference)localObject).vxW = true;
        this.qIM.put(Integer.valueOf(10), Integer.valueOf(1));
        label359:
        localObject = (CheckBoxPreference)getPreferenceScreen().atx("settings_search_switch");
        ((Preference)localObject).zsk = false;
        if (!Dc(2097152)) {
          break label1056;
        }
        ((CheckBoxPreference)localObject).vxW = false;
        this.qIM.put(Integer.valueOf(3), Integer.valueOf(0));
        localObject = (CheckBoxPreference)getPreferenceScreen().atx("settings_nearby_switch");
        ((Preference)localObject).zsk = false;
        bool1 = Dd(512);
        ab.i("MicroMsg.SettingsManageFindMoreUI", "openNearby %s", new Object[] { Boolean.valueOf(bool1) });
        if (!bool1) {
          break label1080;
        }
        ((CheckBoxPreference)localObject).vxW = true;
        this.qIM.put(Integer.valueOf(4), Integer.valueOf(1));
        label483:
        localObject = com.tencent.mm.pluginsdk.f.f.vMG;
        if ((localObject == null) || (!((f.a)localObject).cGM())) {
          break label1274;
        }
      }
      label993:
      label1145:
      label1274:
      for (bool1 = true;; bool1 = false)
      {
        ab.i("MicroMsg.SettingsManageFindMoreUI", "showShopping %s", new Object[] { Boolean.valueOf(bool1) });
        localObject = (CheckBoxPreference)getPreferenceScreen().atx("settings_shopping_switch");
        ((Preference)localObject).zsk = false;
        CheckBoxPreference localCheckBoxPreference;
        if (bool1)
        {
          getPreferenceScreen().cl("settings_shopping_switch", false);
          if (!Dc(4194304)) {
            break label1120;
          }
          ((CheckBoxPreference)localObject).vxW = false;
          this.qIM.put(Integer.valueOf(6), Integer.valueOf(0));
          localObject = b.a.bEX();
          localCheckBoxPreference = (CheckBoxPreference)getPreferenceScreen().atx("settings_game_switch");
          localCheckBoxPreference.zsk = false;
          if ((localObject == null) || (!((com.tencent.mm.plugin.game.api.b)localObject).bEM())) {
            break label1171;
          }
          if (!Dc(8388608)) {
            break label1145;
          }
          localCheckBoxPreference.vxW = false;
          this.qIM.put(Integer.valueOf(7), Integer.valueOf(0));
          localObject = new qz();
          ((qz)localObject).cHs.cHu = true;
          com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
          bool1 = ((qz)localObject).cHt.cHv;
          ab.i("MicroMsg.SettingsManageFindMoreUI", "shouldShowMiniProgram %s", new Object[] { Boolean.valueOf(bool1) });
          localObject = (CheckBoxPreference)getPreferenceScreen().atx("settings_miniprogram_switch");
          ((Preference)localObject).zsk = false;
          if (!bool1) {
            break label1212;
          }
          if (!Dc(16777216)) {
            break label1187;
          }
          ((CheckBoxPreference)localObject).vxW = false;
          this.qIM.put(Integer.valueOf(8), Integer.valueOf(0));
          localObject = (CheckBoxPreference)getPreferenceScreen().atx("settings_wechatout_switch");
          if (com.tencent.mm.m.g.Nq().getInt("WCOEntranceSwitch", 0) <= 0) {
            break label1228;
          }
          bool1 = true;
          ab.i("MicroMsg.SettingsManageFindMoreUI", "showWeChatOut %s", new Object[] { Boolean.valueOf(bool1) });
          if (!bool1) {
            break label1258;
          }
          ((Preference)localObject).zsk = false;
          if (!Dc(33554432)) {
            break label1233;
          }
          ((CheckBoxPreference)localObject).vxW = false;
          this.qIM.put(Integer.valueOf(9), Integer.valueOf(0));
        }
        for (;;)
        {
          localObject = getPreferenceScreen().atx("settings_switch_bottom_tip");
          if (com.tencent.mm.au.b.tM((String)com.tencent.mm.kernel.g.RL().Ru().get(274436, null))) {
            ((Preference)localObject).setTitle(2131303302);
          }
          getPreferenceScreen().notifyDataSetChanged();
          AppMethodBeat.o(127275);
          return;
          ((CheckBoxPreference)localObject).vxW = false;
          this.qIM.put(Integer.valueOf(0), Integer.valueOf(0));
          break;
          ((CheckBoxPreference)localObject).vxW = true;
          this.qIM.put(Integer.valueOf(1), Integer.valueOf(1));
          break label150;
          ((CheckBoxPreference)localObject).vxW = false;
          this.qIM.put(Integer.valueOf(2), Integer.valueOf(0));
          break label223;
          bool1 = false;
          break label256;
          if (!bool2)
          {
            getPreferenceScreen().cl("settings_look_switch", true);
            break label359;
          }
          getPreferenceScreen().cl("settings_look_switch", false);
          ((CheckBoxPreference)localObject).vxW = false;
          this.qIM.put(Integer.valueOf(10), Integer.valueOf(0));
          break label359;
          ((CheckBoxPreference)localObject).vxW = true;
          this.qIM.put(Integer.valueOf(3), Integer.valueOf(1));
          break label410;
          ((CheckBoxPreference)localObject).vxW = false;
          this.qIM.put(Integer.valueOf(4), Integer.valueOf(0));
          break label483;
          getPreferenceScreen().cl("settings_shopping_switch", true);
          break label559;
          ((CheckBoxPreference)localObject).vxW = true;
          this.qIM.put(Integer.valueOf(6), Integer.valueOf(1));
          break label591;
          localCheckBoxPreference.vxW = true;
          this.qIM.put(Integer.valueOf(7), Integer.valueOf(1));
          break label664;
          getPreferenceScreen().cl("settings_game_switch", true);
          break label664;
          ((CheckBoxPreference)localObject).vxW = true;
          this.qIM.put(Integer.valueOf(8), Integer.valueOf(1));
          break label772;
          getPreferenceScreen().cl("settings_miniprogram_switch", true);
          break label772;
          bool1 = false;
          break label803;
          ((CheckBoxPreference)localObject).vxW = true;
          this.qIM.put(Integer.valueOf(9), Integer.valueOf(1));
          continue;
          getPreferenceScreen().cl("settings_wechatout_switch", true);
        }
      }
      label1120:
      label1258:
      label1279:
      bool2 = true;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127272);
    super.onCreate(paramBundle);
    this.kRf = r.Zs();
    this.qIO = r.Zy();
    ab.i("MicroMsg.SettingsManageFindMoreUI", "onCreate extStatus %d, pluginFlag %d", new Object[] { Long.valueOf(this.kRf), Integer.valueOf(this.qIO) });
    initView();
    AppMethodBeat.o(127272);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    int j = 0;
    AppMethodBeat.i(127274);
    if (!(paramPreference instanceof CheckBoxPreference))
    {
      AppMethodBeat.o(127274);
      return true;
    }
    paramf = (CheckBoxPreference)paramPreference;
    paramPreference = paramPreference.mKey;
    ab.i("MicroMsg.SettingsManageFindMoreUI", "click pref key %s", new Object[] { paramPreference });
    int i = -1;
    if (paramPreference.equals("settings_sns_switch"))
    {
      C(paramf.isChecked(), 32768);
      i = 0;
    }
    for (;;)
    {
      if (paramf.isChecked()) {
        j = 1;
      }
      if (i >= 0) {
        this.qIN.put(Integer.valueOf(i), Integer.valueOf(j));
      }
      AppMethodBeat.o(127274);
      return true;
      if (paramPreference.equals("settings_scan_switch"))
      {
        g(paramf.isChecked(), 1048576, 49);
        i = 1;
      }
      else if (paramPreference.equals("settings_search_switch"))
      {
        if (!paramf.isChecked())
        {
          if (((m)com.tencent.mm.kernel.g.E(m.class)).b(this, new SettingsManageFindMoreUI.1(this, paramf))) {
            al.p(new SettingsManageFindMoreUI.2(this, paramf), 500L);
          }
          i = 3;
        }
        else
        {
          g(paramf.isChecked(), 2097152, 50);
          i = 3;
        }
      }
      else if (paramPreference.equals("settings_shopping_switch"))
      {
        i = 6;
        g(paramf.isChecked(), 4194304, 51);
      }
      else
      {
        if (paramPreference.equals("settings_game_switch"))
        {
          g(paramf.isChecked(), 8388608, 52);
          paramPreference = com.tencent.mm.plugin.report.service.h.qsU;
          if (paramf.isChecked()) {}
          for (long l = 0L;; l = 1L)
          {
            paramPreference.idkeyStat(848L, l, 1L, false);
            i = 7;
            break;
          }
        }
        if (paramPreference.equals("settings_miniprogram_switch"))
        {
          i = 8;
          g(paramf.isChecked(), 16777216, 53);
        }
        else if (paramPreference.equals("settings_wechatout_switch"))
        {
          i = 9;
          g(paramf.isChecked(), 33554432, 54);
        }
        else if (paramPreference.equals("settings_shake_switch"))
        {
          i = 2;
          C(paramf.isChecked(), 256);
        }
        else if (paramPreference.equals("settings_nearby_switch"))
        {
          i = 4;
          C(paramf.isChecked(), 512);
        }
        else if (paramPreference.equals("settings_look_switch"))
        {
          ((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.welab.a.a.a.class)).bR("labs_browse", paramf.isChecked());
          if (paramf.isChecked())
          {
            this.kRf &= 0xFBFFFFFF;
            i = 10;
          }
          else
          {
            this.kRf |= 0x4000000;
            i = 10;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsManageFindMoreUI
 * JD-Core Version:    0.7.0.1
 */