package com.tencent.mm.plugin.setting.ui.setting;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mm.h.a.ps;
import com.tencent.mm.h.a.ps.b;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.game.a.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.a.k;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.api.m;
import com.tencent.mm.pluginsdk.f.f.b;
import com.tencent.mm.protocal.c.zr;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class SettingsManageFindMoreUI
  extends MMPreference
{
  private HashMap<Integer, Integer> fcv = new HashMap();
  private long iKA;
  private HashMap<Integer, Integer> nUH = new HashMap();
  private HashMap<Integer, Integer> nUI = new HashMap();
  private int nUJ;
  
  private void bcI()
  {
    Iterator localIterator = this.nUI.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      if ((this.nUH.containsKey(Integer.valueOf(i))) && (this.nUH.get(Integer.valueOf(i)) != this.nUI.get(Integer.valueOf(i)))) {
        com.tencent.mm.plugin.report.service.h.nFQ.f(15185, new Object[] { Integer.valueOf(i), this.nUI.get(Integer.valueOf(i)) });
      }
    }
  }
  
  private void c(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.SettingsManageFindMoreUI", "switch ext change : open = " + paramBoolean + " item value = " + paramInt1 + " functionId = " + paramInt2);
    if (paramBoolean)
    {
      this.iKA &= (paramInt1 ^ 0xFFFFFFFF);
      if (!paramBoolean) {
        break label93;
      }
    }
    label93:
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      this.fcv.put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
      return;
      this.iKA |= paramInt1;
      break;
    }
  }
  
  private void u(boolean paramBoolean, int paramInt)
  {
    y.i("MicroMsg.SettingsManageFindMoreUI", "switch plugin flag, open %s, flag %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (!paramBoolean)
    {
      this.nUJ |= paramInt;
      return;
    }
    this.nUJ &= (paramInt ^ 0xFFFFFFFF);
  }
  
  private boolean xe(int paramInt)
  {
    return (this.iKA & paramInt) != 0L;
  }
  
  private boolean xf(int paramInt)
  {
    return (this.nUJ & paramInt) == 0;
  }
  
  public final com.tencent.mm.ui.base.preference.h a(SharedPreferences paramSharedPreferences)
  {
    return new com.tencent.mm.ui.base.preference.a(this, paramSharedPreferences);
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    int j = 0;
    if (!(paramPreference instanceof CheckBoxPreference)) {
      return true;
    }
    CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)paramPreference;
    paramf = paramPreference.mKey;
    y.i("MicroMsg.SettingsManageFindMoreUI", "click pref key %s", new Object[] { paramf });
    int i = -1;
    if (paramf.equals("settings_sns_switch"))
    {
      u(localCheckBoxPreference.isChecked(), 32768);
      SharedPreferences localSharedPreferences = getSharedPreferences(ae.cqR(), 0);
      paramPreference = localSharedPreferences.getString(q.Gj() + "_sns_entrance_disappear", "");
      if ((!bk.bl(paramPreference)) && (paramPreference.startsWith("on")))
      {
        paramf = paramPreference;
        if (localCheckBoxPreference.isChecked())
        {
          paramf = paramPreference;
          if (paramPreference.equals("on_close")) {
            paramf = "on";
          }
        }
        paramPreference = paramf;
        if (!localCheckBoxPreference.isChecked())
        {
          paramPreference = paramf;
          if (paramf.equals("on")) {
            paramPreference = "on_close";
          }
        }
        localSharedPreferences.edit().putString(q.Gj() + "_sns_entrance_disappear", paramPreference).commit();
      }
      i = 0;
    }
    for (;;)
    {
      if (localCheckBoxPreference.isChecked()) {
        j = 1;
      }
      if (i < 0) {
        break;
      }
      this.nUI.put(Integer.valueOf(i), Integer.valueOf(j));
      return true;
      if (paramf.equals("settings_scan_switch"))
      {
        c(localCheckBoxPreference.isChecked(), 1048576, 49);
        i = 1;
      }
      else if (paramf.equals("settings_search_switch"))
      {
        if (!localCheckBoxPreference.isChecked())
        {
          if (((m)com.tencent.mm.kernel.g.r(m.class)).b(this, new SettingsManageFindMoreUI.1(this, localCheckBoxPreference))) {
            ai.l(new SettingsManageFindMoreUI.2(this, localCheckBoxPreference), 500L);
          }
          i = 3;
        }
        else
        {
          c(localCheckBoxPreference.isChecked(), 2097152, 50);
          i = 3;
        }
      }
      else if (paramf.equals("settings_shopping_switch"))
      {
        i = 6;
        c(localCheckBoxPreference.isChecked(), 4194304, 51);
      }
      else
      {
        if (paramf.equals("settings_game_switch"))
        {
          c(localCheckBoxPreference.isChecked(), 8388608, 52);
          paramf = com.tencent.mm.plugin.report.service.h.nFQ;
          if (localCheckBoxPreference.isChecked()) {}
          for (long l = 0L;; l = 1L)
          {
            paramf.a(848L, l, 1L, false);
            i = 7;
            break;
          }
        }
        if (paramf.equals("settings_miniprogram_switch"))
        {
          i = 8;
          c(localCheckBoxPreference.isChecked(), 16777216, 53);
        }
        else if (paramf.equals("settings_wechatout_switch"))
        {
          i = 9;
          c(localCheckBoxPreference.isChecked(), 33554432, 54);
        }
        else if (paramf.equals("settings_shake_switch"))
        {
          i = 2;
          u(localCheckBoxPreference.isChecked(), 256);
        }
        else if (paramf.equals("settings_nearby_switch"))
        {
          i = 4;
          u(localCheckBoxPreference.isChecked(), 512);
        }
        else if (paramf.equals("settings_bottle_switch"))
        {
          i = 5;
          u(localCheckBoxPreference.isChecked(), 64);
        }
        else if (paramf.equals("settings_look_switch"))
        {
          ((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.welab.a.a.a.class)).br("labs_browse", localCheckBoxPreference.isChecked());
          if ((!localCheckBoxPreference.isChecked()) && (com.tencent.mm.at.b.mC((String)com.tencent.mm.kernel.g.DP().Dz().get(274436, null)))) {
            this.vdd.bJ("settings_look_switch", true);
          }
          i = 10;
        }
      }
    }
  }
  
  public void finish()
  {
    super.finish();
    y.i("MicroMsg.SettingsManageFindMoreUI", "oplog extstatus:" + this.iKA + ",pluginFlag:" + this.nUJ);
    com.tencent.mm.kernel.g.DP().Dz().o(147457, Long.valueOf(this.iKA));
    com.tencent.mm.kernel.g.DP().Dz().o(34, Integer.valueOf(this.nUJ));
    Iterator localIterator = this.fcv.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      int i = ((Integer)((Map.Entry)localObject).getKey()).intValue();
      int j = ((Integer)((Map.Entry)localObject).getValue()).intValue();
      localObject = new zr();
      ((zr)localObject).sYS = i;
      ((zr)localObject).nfn = j;
      ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fv().b(new i.a(23, (com.tencent.mm.bv.a)localObject));
      y.d("MicroMsg.SettingsManageFindMoreUI", "switch  " + i + " " + j);
    }
    this.fcv.clear();
    ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fv().b(new com.tencent.mm.ay.j("", "", "", "", "", "", "", "", this.nUJ, "", ""));
    bcI();
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.settings_manage_findmoreui);
    setBackBtn(new SettingsManageFindMoreUI.3(this));
    Object localObject1 = (CheckBoxPreference)this.vdd.add("settings_sns_switch");
    ((Preference)localObject1).vdK = false;
    boolean bool1 = xf(32768);
    y.i("MicroMsg.SettingsManageFindMoreUI", "openSns %s", new Object[] { Boolean.valueOf(bool1) });
    label140:
    label213:
    Object localObject2;
    boolean bool2;
    if (bool1)
    {
      ((CheckBoxPreference)localObject1).rHo = true;
      this.nUH.put(Integer.valueOf(0), Integer.valueOf(1));
      localObject1 = (CheckBoxPreference)this.vdd.add("settings_scan_switch");
      ((Preference)localObject1).vdK = false;
      if (!xe(1048576)) {
        break label1085;
      }
      ((CheckBoxPreference)localObject1).rHo = false;
      this.nUH.put(Integer.valueOf(1), Integer.valueOf(0));
      localObject1 = (CheckBoxPreference)this.vdd.add("settings_shake_switch");
      ((Preference)localObject1).vdK = false;
      bool1 = xf(256);
      y.i("MicroMsg.SettingsManageFindMoreUI", "openShake %s", new Object[] { Boolean.valueOf(bool1) });
      if (!bool1) {
        break label1109;
      }
      ((CheckBoxPreference)localObject1).rHo = true;
      this.nUH.put(Integer.valueOf(2), Integer.valueOf(1));
      localObject1 = (CheckBoxPreference)this.vdd.add("settings_look_switch");
      ((Preference)localObject1).vdK = false;
      localObject2 = ac.Ru("discoverRecommendEntry");
      bool2 = ((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.welab.a.a.a.class)).Ul("labs_browse");
      if (!bool2) {
        break label1133;
      }
      if (!((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.welab.a.a.a.class)).Uj("labs_browse")) {
        break label1501;
      }
      bool1 = true;
    }
    for (;;)
    {
      label286:
      if (com.tencent.mm.at.b.mC((String)com.tencent.mm.kernel.g.DP().Dz().get(274436, null)))
      {
        this.vdd.bJ("settings_look_switch", true);
        bool2 = false;
        bool1 = false;
      }
      label431:
      label949:
      label1085:
      for (;;)
      {
        y.i("MicroMsg.SettingsManageFindMoreUI", "isInExperiment %s ,openLook %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        label381:
        String str;
        if ((bool2) && (bool1))
        {
          ((CheckBoxPreference)localObject1).rHo = true;
          this.nUH.put(Integer.valueOf(10), Integer.valueOf(1));
          localObject1 = (CheckBoxPreference)this.vdd.add("settings_search_switch");
          ((Preference)localObject1).vdK = false;
          if (!xe(2097152)) {
            break label1208;
          }
          ((CheckBoxPreference)localObject1).rHo = false;
          this.nUH.put(Integer.valueOf(3), Integer.valueOf(0));
          localObject1 = (CheckBoxPreference)this.vdd.add("settings_nearby_switch");
          ((Preference)localObject1).vdK = false;
          bool1 = xf(512);
          y.i("MicroMsg.SettingsManageFindMoreUI", "openNearby %s", new Object[] { Boolean.valueOf(bool1) });
          if (!bool1) {
            break label1232;
          }
          ((CheckBoxPreference)localObject1).rHo = true;
          this.nUH.put(Integer.valueOf(4), Integer.valueOf(1));
          label504:
          localObject1 = (CheckBoxPreference)this.vdd.add("settings_bottle_switch");
          ((Preference)localObject1).vdK = false;
          bool1 = xf(64);
          y.i("MicroMsg.SettingsManageFindMoreUI", "openFloatBottle %s", new Object[] { Boolean.valueOf(bool1) });
          if (!bool1) {
            break label1256;
          }
          ((CheckBoxPreference)localObject1).rHo = true;
          this.nUH.put(Integer.valueOf(5), Integer.valueOf(1));
          label576:
          if (!x.cqG()) {
            break label1280;
          }
          localObject1 = com.tencent.mm.m.g.AA().getValue("JDEntranceConfigName");
          label592:
          str = com.tencent.mm.m.g.AA().getValue("JDEntranceConfigIconUrl");
          localObject2 = com.tencent.mm.pluginsdk.f.f.rVL;
          if (localObject2 == null) {
            break label1487;
          }
        }
        label705:
        label1353:
        label1487:
        for (localObject2 = ((f.b)localObject2).bLT();; localObject2 = null)
        {
          if (!bk.H(new String[] { localObject1, str, localObject2 })) {}
          for (bool1 = true;; bool1 = false)
          {
            y.i("MicroMsg.SettingsManageFindMoreUI", "showShopping %s", new Object[] { Boolean.valueOf(bool1) });
            localObject1 = (CheckBoxPreference)this.vdd.add("settings_shopping_switch");
            ((Preference)localObject1).vdK = false;
            if (bool1)
            {
              this.vdd.bJ("settings_shopping_switch", false);
              if (!xe(4194304)) {
                break label1328;
              }
              ((CheckBoxPreference)localObject1).rHo = false;
              this.nUH.put(Integer.valueOf(6), Integer.valueOf(0));
              label737:
              localObject1 = a.a.aYi();
              localObject2 = (CheckBoxPreference)this.vdd.add("settings_game_switch");
              ((Preference)localObject2).vdK = false;
              if ((localObject1 == null) || (!((com.tencent.mm.plugin.game.a.a)localObject1).aXZ())) {
                break label1379;
              }
              if (!xe(8388608)) {
                break label1353;
              }
              ((CheckBoxPreference)localObject2).rHo = false;
              this.nUH.put(Integer.valueOf(7), Integer.valueOf(0));
              localObject1 = new ps();
              ((ps)localObject1).bZh.bZj = true;
              com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
              bool1 = ((ps)localObject1).bZi.bZk;
              y.i("MicroMsg.SettingsManageFindMoreUI", "shouldShowMiniProgram %s", new Object[] { Boolean.valueOf(bool1) });
              localObject1 = (CheckBoxPreference)this.vdd.add("settings_miniprogram_switch");
              ((Preference)localObject1).vdK = false;
              if (!bool1) {
                break label1420;
              }
              if (!xe(16777216)) {
                break label1395;
              }
              ((CheckBoxPreference)localObject1).rHo = false;
              this.nUH.put(Integer.valueOf(8), Integer.valueOf(0));
              localObject1 = (CheckBoxPreference)this.vdd.add("settings_wechatout_switch");
              if (com.tencent.mm.m.g.AA().getInt("WCOEntranceSwitch", 0) <= 0) {
                break label1436;
              }
              bool1 = true;
              y.i("MicroMsg.SettingsManageFindMoreUI", "showWeChatOut %s", new Object[] { Boolean.valueOf(bool1) });
              if (!bool1) {
                break label1466;
              }
              ((Preference)localObject1).vdK = false;
              if (!xe(33554432)) {
                break label1441;
              }
              ((CheckBoxPreference)localObject1).rHo = false;
              this.nUH.put(Integer.valueOf(9), Integer.valueOf(0));
            }
            for (;;)
            {
              localObject1 = this.vdd.add("settings_switch_bottom_tip");
              if (com.tencent.mm.at.b.mC((String)com.tencent.mm.kernel.g.DP().Dz().get(274436, null))) {
                ((Preference)localObject1).setTitle(a.i.settings_manage_plugin_eu_hint);
              }
              this.vdd.notifyDataSetChanged();
              return;
              ((CheckBoxPreference)localObject1).rHo = false;
              this.nUH.put(Integer.valueOf(0), Integer.valueOf(0));
              break;
              ((CheckBoxPreference)localObject1).rHo = true;
              this.nUH.put(Integer.valueOf(1), Integer.valueOf(1));
              break label140;
              label1109:
              ((CheckBoxPreference)localObject1).rHo = false;
              this.nUH.put(Integer.valueOf(2), Integer.valueOf(0));
              break label213;
              label1133:
              if (((JSONObject)localObject2).optInt("entrySwitch") != 1) {
                break label1496;
              }
              bool1 = true;
              break label286;
              if (!bool2)
              {
                this.vdd.bJ("settings_look_switch", true);
                break label381;
              }
              this.vdd.bJ("settings_look_switch", false);
              ((CheckBoxPreference)localObject1).rHo = false;
              this.nUH.put(Integer.valueOf(10), Integer.valueOf(0));
              break label381;
              ((CheckBoxPreference)localObject1).rHo = true;
              this.nUH.put(Integer.valueOf(3), Integer.valueOf(1));
              break label431;
              label1232:
              ((CheckBoxPreference)localObject1).rHo = false;
              this.nUH.put(Integer.valueOf(4), Integer.valueOf(0));
              break label504;
              label1256:
              ((CheckBoxPreference)localObject1).rHo = false;
              this.nUH.put(Integer.valueOf(5), Integer.valueOf(0));
              break label576;
              if (x.cqH())
              {
                localObject1 = com.tencent.mm.m.g.AA().getValue("JDEntranceConfigNameHKTW");
                break label592;
              }
              localObject1 = com.tencent.mm.m.g.AA().getValue("JDEntranceConfigNameEN");
              break label592;
              this.vdd.bJ("settings_shopping_switch", true);
              break label705;
              ((CheckBoxPreference)localObject1).rHo = true;
              this.nUH.put(Integer.valueOf(6), Integer.valueOf(1));
              break label737;
              ((CheckBoxPreference)localObject2).rHo = true;
              this.nUH.put(Integer.valueOf(7), Integer.valueOf(1));
              break label810;
              label1379:
              this.vdd.bJ("settings_game_switch", true);
              break label810;
              label1395:
              ((CheckBoxPreference)localObject1).rHo = true;
              this.nUH.put(Integer.valueOf(8), Integer.valueOf(1));
              break label918;
              this.vdd.bJ("settings_miniprogram_switch", true);
              break label918;
              bool1 = false;
              break label949;
              ((CheckBoxPreference)localObject1).rHo = true;
              this.nUH.put(Integer.valueOf(9), Integer.valueOf(1));
              continue;
              this.vdd.bJ("settings_wechatout_switch", true);
            }
          }
        }
      }
      label810:
      label1208:
      label1466:
      label1496:
      bool1 = false;
      label918:
      label1328:
      continue;
      label1280:
      label1420:
      label1436:
      label1441:
      label1501:
      bool1 = false;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.iKA = q.Go();
    this.nUJ = q.Gu();
    y.i("MicroMsg.SettingsManageFindMoreUI", "onCreate extStatus %d, pluginFlag %d", new Object[] { Long.valueOf(this.iKA), Integer.valueOf(this.nUJ) });
    initView();
  }
  
  public final int xj()
  {
    return a.k.settings_pref_manage_findmoreui;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsManageFindMoreUI
 * JD-Core Version:    0.7.0.1
 */