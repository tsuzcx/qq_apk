package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tu;
import com.tencent.mm.g.a.tu.b;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.pluginsdk.i.g.a;
import com.tencent.mm.protocal.protobuf.auo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.preference.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class SettingsManageFindMoreUI
  extends MMPreference
{
  private HashMap<Integer, Integer> jdq;
  private long pkQ;
  private HashMap<Integer, Integer> yXC;
  private HashMap<Integer, Integer> yXD;
  private int yXE;
  
  public SettingsManageFindMoreUI()
  {
    AppMethodBeat.i(74209);
    this.jdq = new HashMap();
    this.yXC = new HashMap();
    this.yXD = new HashMap();
    AppMethodBeat.o(74209);
  }
  
  private void S(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(74216);
    ae.i("MicroMsg.SettingsManageFindMoreUI", "switch plugin flag, open %s, flag %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (!paramBoolean)
    {
      this.yXE |= paramInt;
      AppMethodBeat.o(74216);
      return;
    }
    this.yXE &= (paramInt ^ 0xFFFFFFFF);
    AppMethodBeat.o(74216);
  }
  
  private void b(boolean paramBoolean, long paramLong, int paramInt)
  {
    AppMethodBeat.i(164133);
    ae.i("MicroMsg.SettingsManageFindMoreUI", "switch ext change : open = " + paramBoolean + " item value = " + paramLong + " functionId = " + paramInt);
    if (paramBoolean)
    {
      this.pkQ &= (0xFFFFFFFF ^ paramLong);
      if (!paramBoolean) {
        break label107;
      }
    }
    label107:
    for (int i = 1;; i = 2)
    {
      this.jdq.put(Integer.valueOf(paramInt), Integer.valueOf(i));
      AppMethodBeat.o(164133);
      return;
      this.pkQ |= paramLong;
      break;
    }
  }
  
  private void byD()
  {
    AppMethodBeat.i(74217);
    Iterator localIterator = this.yXD.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      if ((this.yXC.containsKey(Integer.valueOf(i))) && (this.yXC.get(Integer.valueOf(i)) != this.yXD.get(Integer.valueOf(i))))
      {
        com.tencent.mm.plugin.report.service.g.yxI.f(15185, new Object[] { Integer.valueOf(i), this.yXD.get(Integer.valueOf(i)) });
        if (i == 0) {
          if (((Integer)this.yXD.get(Integer.valueOf(i))).intValue() == 0) {
            com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IZG, Integer.valueOf(-1));
          } else if (((Integer)this.yXD.get(Integer.valueOf(i))).intValue() == 1) {
            com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IZG, Integer.valueOf(1));
          }
        }
      }
    }
    AppMethodBeat.o(74217);
  }
  
  private boolean zG(long paramLong)
  {
    return (this.pkQ & paramLong) != 0L;
  }
  
  private boolean zH(long paramLong)
  {
    return (this.yXE & paramLong) == 0L;
  }
  
  public h createAdapter(SharedPreferences paramSharedPreferences)
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
    ae.i("MicroMsg.SettingsManageFindMoreUI", "oplog extstatus:" + this.pkQ + ",pluginFlag:" + this.yXE);
    com.tencent.mm.kernel.g.ajR().ajA().set(147457, Long.valueOf(this.pkQ));
    com.tencent.mm.kernel.g.ajR().ajA().set(34, Integer.valueOf(this.yXE));
    Iterator localIterator = this.jdq.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      int i = ((Integer)((Map.Entry)localObject).getKey()).intValue();
      int j = ((Integer)((Map.Entry)localObject).getValue()).intValue();
      localObject = new auo();
      ((auo)localObject).GLx = i;
      ((auo)localObject).xsz = j;
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azE().d(new k.a(23, (com.tencent.mm.bw.a)localObject));
      ae.d("MicroMsg.SettingsManageFindMoreUI", "switch  " + i + " " + j);
    }
    this.jdq.clear();
    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azE().d(new com.tencent.mm.ba.l("", "", "", "", "", "", "", "", this.yXE, "", ""));
    byD();
    AppMethodBeat.o(74215);
  }
  
  public int getResourceId()
  {
    return 2131951727;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74213);
    setMMTitle(2131763267);
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
    Object localObject = (CheckBoxPreference)getPreferenceScreen().aXe("settings_sns_switch");
    ((Preference)localObject).JOq = false;
    boolean bool1 = zH(32768L);
    ae.i("MicroMsg.SettingsManageFindMoreUI", "openSns %s", new Object[] { Boolean.valueOf(bool1) });
    label150:
    label202:
    boolean bool2;
    if (bool1)
    {
      ((CheckBoxPreference)localObject).setChecked(true);
      this.yXC.put(Integer.valueOf(0), Integer.valueOf(1));
      bool1 = ((t)com.tencent.mm.kernel.g.ad(t.class)).showFinderEntry();
      ae.i("MicroMsg.SettingsManageFindMoreUI", "showFinder %s", new Object[] { Boolean.valueOf(bool1) });
      if (bool1) {
        break label1000;
      }
      getPreferenceScreen().cT("settings_finder_switch", true);
      localObject = (CheckBoxPreference)getPreferenceScreen().aXe("settings_scan_switch");
      ((Preference)localObject).JOq = false;
      if (!zG(1048576L)) {
        break label1081;
      }
      ((CheckBoxPreference)localObject).setChecked(false);
      this.yXC.put(Integer.valueOf(1), Integer.valueOf(0));
      localObject = (CheckBoxPreference)getPreferenceScreen().aXe("settings_shake_switch");
      ((Preference)localObject).JOq = false;
      bool1 = zH(256L);
      ae.i("MicroMsg.SettingsManageFindMoreUI", "openShake %s", new Object[] { Boolean.valueOf(bool1) });
      if (!bool1) {
        break label1105;
      }
      ((CheckBoxPreference)localObject).setChecked(true);
      this.yXC.put(Integer.valueOf(2), Integer.valueOf(1));
      label275:
      localObject = (CheckBoxPreference)getPreferenceScreen().aXe("settings_look_switch");
      ((Preference)localObject).JOq = false;
      if (zG(67108864L)) {
        break label1129;
      }
      bool1 = true;
      label308:
      if (!com.tencent.mm.aw.b.Gw((String)com.tencent.mm.kernel.g.ajR().ajA().get(274436, null))) {
        break label1421;
      }
      getPreferenceScreen().cT("settings_look_switch", true);
      ae.i("MicroMsg.SettingsManageFindMoreUI", "european user");
      bool2 = false;
      bool1 = false;
    }
    for (;;)
    {
      ae.i("MicroMsg.SettingsManageFindMoreUI", "isInExperiment %s ,openLook %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((bool2) && (bool1))
      {
        ((CheckBoxPreference)localObject).setChecked(true);
        this.yXC.put(Integer.valueOf(10), Integer.valueOf(1));
        label412:
        localObject = (CheckBoxPreference)getPreferenceScreen().aXe("settings_search_switch");
        ((Preference)localObject).JOq = false;
        if (!zG(2097152L)) {
          break label1194;
        }
        ((CheckBoxPreference)localObject).setChecked(false);
        this.yXC.put(Integer.valueOf(3), Integer.valueOf(0));
        label464:
        localObject = (CheckBoxPreference)getPreferenceScreen().aXe("settings_nearby_switch");
        ((Preference)localObject).JOq = false;
        bool1 = zH(512L);
        ae.i("MicroMsg.SettingsManageFindMoreUI", "openNearby %s", new Object[] { Boolean.valueOf(bool1) });
        if (!bool1) {
          break label1218;
        }
        ((CheckBoxPreference)localObject).setChecked(true);
        this.yXC.put(Integer.valueOf(4), Integer.valueOf(1));
        label537:
        localObject = com.tencent.mm.pluginsdk.i.g.Fhv;
        if ((localObject == null) || (!((g.a)localObject).eqz())) {
          break label1416;
        }
      }
      label646:
      label1416:
      for (bool1 = true;; bool1 = false)
      {
        ae.i("MicroMsg.SettingsManageFindMoreUI", "showShopping %s", new Object[] { Boolean.valueOf(bool1) });
        localObject = (CheckBoxPreference)getPreferenceScreen().aXe("settings_shopping_switch");
        ((Preference)localObject).JOq = false;
        label614:
        CheckBoxPreference localCheckBoxPreference;
        if (bool1)
        {
          getPreferenceScreen().cT("settings_shopping_switch", false);
          if (!zG(4194304L)) {
            break label1259;
          }
          ((CheckBoxPreference)localObject).setChecked(false);
          this.yXC.put(Integer.valueOf(6), Integer.valueOf(0));
          localObject = b.a.cZq();
          localCheckBoxPreference = (CheckBoxPreference)getPreferenceScreen().aXe("settings_game_switch");
          localCheckBoxPreference.JOq = false;
          if ((localObject == null) || (!((com.tencent.mm.plugin.game.api.b)localObject).cZf())) {
            break label1310;
          }
          if (!zG(8388608L)) {
            break label1284;
          }
          localCheckBoxPreference.setChecked(false);
          this.yXC.put(Integer.valueOf(7), Integer.valueOf(0));
          label719:
          localObject = new tu();
          ((tu)localObject).dJh.dJj = true;
          com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
          bool1 = ((tu)localObject).dJi.dJk;
          ae.i("MicroMsg.SettingsManageFindMoreUI", "shouldShowMiniProgram %s", new Object[] { Boolean.valueOf(bool1) });
          localObject = (CheckBoxPreference)getPreferenceScreen().aXe("settings_miniprogram_switch");
          ((Preference)localObject).JOq = false;
          if (!bool1) {
            break label1352;
          }
          if (!zG(16777216L)) {
            break label1327;
          }
          ((CheckBoxPreference)localObject).setChecked(false);
          this.yXC.put(Integer.valueOf(8), Integer.valueOf(0));
          label827:
          localObject = (CheckBoxPreference)getPreferenceScreen().aXe("settings_wechatout_switch");
          if (com.tencent.mm.n.g.acL().getInt("WCOEntranceSwitch", 0) <= 0) {
            break label1369;
          }
          bool1 = true;
          label858:
          ae.i("MicroMsg.SettingsManageFindMoreUI", "showWeChatOut %s", new Object[] { Boolean.valueOf(bool1) });
          if (!bool1) {
            break label1399;
          }
          ((Preference)localObject).JOq = false;
          if (!zG(33554432L)) {
            break label1374;
          }
          ((CheckBoxPreference)localObject).setChecked(false);
          this.yXC.put(Integer.valueOf(9), Integer.valueOf(0));
        }
        for (;;)
        {
          localObject = getPreferenceScreen().aXe("settings_switch_bottom_tip");
          if (com.tencent.mm.aw.b.Gw((String)com.tencent.mm.kernel.g.ajR().ajA().get(274436, null))) {
            ((Preference)localObject).setTitle(2131763271);
          }
          getPreferenceScreen().notifyDataSetChanged();
          AppMethodBeat.o(74213);
          return;
          ((CheckBoxPreference)localObject).setChecked(false);
          this.yXC.put(Integer.valueOf(0), Integer.valueOf(0));
          break;
          label1000:
          localObject = (CheckBoxPreference)getPreferenceScreen().aXe("settings_finder_switch");
          ((Preference)localObject).JOq = false;
          if (zG(34359738368L))
          {
            ((CheckBoxPreference)localObject).setChecked(false);
            this.yXC.put(Integer.valueOf(11), Integer.valueOf(0));
            break label150;
          }
          ((CheckBoxPreference)localObject).setChecked(true);
          this.yXC.put(Integer.valueOf(11), Integer.valueOf(1));
          break label150;
          label1081:
          ((CheckBoxPreference)localObject).setChecked(true);
          this.yXC.put(Integer.valueOf(1), Integer.valueOf(1));
          break label202;
          label1105:
          ((CheckBoxPreference)localObject).setChecked(false);
          this.yXC.put(Integer.valueOf(2), Integer.valueOf(0));
          break label275;
          label1129:
          bool1 = false;
          break label308;
          if (!bool2)
          {
            getPreferenceScreen().cT("settings_look_switch", true);
            break label412;
          }
          getPreferenceScreen().cT("settings_look_switch", false);
          ((CheckBoxPreference)localObject).setChecked(false);
          this.yXC.put(Integer.valueOf(10), Integer.valueOf(0));
          break label412;
          label1194:
          ((CheckBoxPreference)localObject).setChecked(true);
          this.yXC.put(Integer.valueOf(3), Integer.valueOf(1));
          break label464;
          label1218:
          ((CheckBoxPreference)localObject).setChecked(false);
          this.yXC.put(Integer.valueOf(4), Integer.valueOf(0));
          break label537;
          getPreferenceScreen().cT("settings_shopping_switch", true);
          break label614;
          label1259:
          ((CheckBoxPreference)localObject).setChecked(true);
          this.yXC.put(Integer.valueOf(6), Integer.valueOf(1));
          break label646;
          localCheckBoxPreference.setChecked(true);
          this.yXC.put(Integer.valueOf(7), Integer.valueOf(1));
          break label719;
          label1310:
          getPreferenceScreen().cT("settings_game_switch", true);
          break label719;
          label1327:
          ((CheckBoxPreference)localObject).setChecked(true);
          this.yXC.put(Integer.valueOf(8), Integer.valueOf(1));
          break label827;
          label1352:
          getPreferenceScreen().cT("settings_miniprogram_switch", true);
          break label827;
          label1369:
          bool1 = false;
          break label858;
          label1374:
          ((CheckBoxPreference)localObject).setChecked(true);
          this.yXC.put(Integer.valueOf(9), Integer.valueOf(1));
          continue;
          label1399:
          getPreferenceScreen().cT("settings_wechatout_switch", true);
        }
      }
      label1284:
      label1421:
      bool2 = true;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74210);
    super.onCreate(paramBundle);
    this.pkQ = v.aAH();
    this.yXE = v.aAO();
    ae.i("MicroMsg.SettingsManageFindMoreUI", "onCreate extStatus %d, pluginFlag %d", new Object[] { Long.valueOf(this.pkQ), Integer.valueOf(this.yXE) });
    initView();
    AppMethodBeat.o(74210);
  }
  
  public boolean onPreferenceTreeClick(final f paramf, Preference paramPreference)
  {
    int j = 0;
    AppMethodBeat.i(74212);
    if (!(paramPreference instanceof CheckBoxPreference))
    {
      AppMethodBeat.o(74212);
      return true;
    }
    paramf = (CheckBoxPreference)paramPreference;
    paramPreference = paramPreference.mKey;
    ae.i("MicroMsg.SettingsManageFindMoreUI", "click pref key %s", new Object[] { paramPreference });
    int i = -1;
    if (paramPreference.equals("settings_sns_switch"))
    {
      S(paramf.isChecked(), 32768);
      i = 0;
    }
    for (;;)
    {
      if (paramf.isChecked()) {
        j = 1;
      }
      if (i >= 0) {
        this.yXD.put(Integer.valueOf(i), Integer.valueOf(j));
      }
      AppMethodBeat.o(74212);
      return true;
      if (paramPreference.equals("settings_scan_switch"))
      {
        b(paramf.isChecked(), 1048576L, 49);
        i = 1;
      }
      else if (paramPreference.equals("settings_search_switch"))
      {
        if (!paramf.isChecked())
        {
          if (((i)com.tencent.mm.kernel.g.ab(i.class)).b(this, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(74206);
              paramf.setChecked(false);
              SettingsManageFindMoreUI.a(SettingsManageFindMoreUI.this, paramf.isChecked());
              AppMethodBeat.o(74206);
            }
          })) {
            ar.o(new Runnable()
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
        i = 6;
        b(paramf.isChecked(), 4194304L, 51);
      }
      else
      {
        if (paramPreference.equals("settings_game_switch"))
        {
          b(paramf.isChecked(), 8388608L, 52);
          paramPreference = com.tencent.mm.plugin.report.service.g.yxI;
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
          b(paramf.isChecked(), 16777216L, 53);
        }
        else if (paramPreference.equals("settings_wechatout_switch"))
        {
          i = 9;
          b(paramf.isChecked(), 33554432L, 54);
        }
        else if (paramPreference.equals("settings_shake_switch"))
        {
          i = 2;
          S(paramf.isChecked(), 256);
        }
        else if (paramPreference.equals("settings_nearby_switch"))
        {
          i = 4;
          S(paramf.isChecked(), 512);
        }
        else if (paramPreference.equals("settings_look_switch"))
        {
          ((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.welab.a.a.a.class)).cw("labs_browse", paramf.isChecked());
          if (paramf.isChecked())
          {
            this.pkQ &= 0xFBFFFFFF;
            i = 10;
          }
          else
          {
            this.pkQ |= 0x4000000;
            i = 10;
          }
        }
        else if (paramPreference.equals("settings_finder_switch"))
        {
          i = 11;
          b(paramf.isChecked(), 34359738368L, 57);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsManageFindMoreUI
 * JD-Core Version:    0.7.0.1
 */