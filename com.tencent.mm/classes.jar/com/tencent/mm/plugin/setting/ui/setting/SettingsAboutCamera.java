package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ew;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.ball.c.c;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.auo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class SettingsAboutCamera
  extends MMPreference
{
  private long pkQ;
  private com.tencent.mm.ui.base.preference.f screen;
  private final String yVk = "settings_auto_mul_terminal_sync_tip";
  private final String yVl = "settings_auto_mul_terminal_sync";
  private final String yVm = "settings_take_photo_auto_save_tip";
  private final String yVn = "settings_take_photo_auto_save_photo";
  private final String yVo = "settings_take_photo_auto_save_video";
  private final String yVp = "settings_sns_auto_play_switch";
  private final String yVq = "settings_sns_auto_play_tip";
  private final String yVr = "settings_voip_audio_switch_mobile_net";
  private final String yVs = "settings_voip_audio_switch_mobile_net_tip";
  private int yVt = 0;
  
  public int getResourceId()
  {
    return 2131951725;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74014);
    this.screen = getPreferenceScreen();
    Object localObject;
    if (!SettingsAboutSystemUI.dQX())
    {
      setMMTitle(2131763347);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(74011);
          SettingsAboutCamera.this.hideVKB();
          SettingsAboutCamera.this.finish();
          AppMethodBeat.o(74011);
          return true;
        }
      });
      bool = ((Boolean)g.ajR().ajA().get(am.a.IRR, Boolean.TRUE)).booleanValue();
      localObject = (CheckBoxPreference)this.screen.aXe("settings_auto_mul_terminal_sync");
      ((Preference)localObject).JOq = false;
      ((CheckBoxPreference)localObject).setChecked(bool);
      bool = ((Boolean)g.ajR().ajA().get(am.a.IRT, Boolean.TRUE)).booleanValue();
      localObject = (CheckBoxPreference)this.screen.aXe("settings_take_photo_auto_save_photo");
      ((Preference)localObject).JOq = false;
      ((CheckBoxPreference)localObject).setChecked(bool);
      bool = ((Boolean)g.ajR().ajA().get(am.a.IRU, Boolean.TRUE)).booleanValue();
      localObject = (CheckBoxPreference)this.screen.aXe("settings_take_photo_auto_save_video");
      ((CheckBoxPreference)localObject).setChecked(bool);
      ((Preference)localObject).JOq = false;
      bool = ((Boolean)g.ajR().ajA().get(am.a.IRV, Boolean.TRUE)).booleanValue();
      localObject = (CheckBoxPreference)this.screen.aXe("settings_sns_auto_play_switch");
      ((CheckBoxPreference)localObject).setChecked(bool);
      ((Preference)localObject).JOq = false;
      if (SettingsAboutSystemUI.dQX())
      {
        if ((this.pkQ & 0x0) == 0L) {
          break label415;
        }
        i = 1;
        label258:
        if (i != 0) {
          break label420;
        }
      }
    }
    label415:
    label420:
    for (boolean bool = true;; bool = false)
    {
      localObject = (CheckBoxPreference)this.screen.aXe("settings_voip_audio_switch_mobile_net");
      ((CheckBoxPreference)localObject).setChecked(bool);
      ((Preference)localObject).JOq = false;
      this.screen.notifyDataSetChanged();
      if (this.yVt != 1) {
        break label425;
      }
      this.screen.cT("settings_sns_auto_play_switch", true);
      this.screen.cT("settings_sns_auto_play_tip", true);
      this.screen.cT("settings_take_photo_auto_save_photo", true);
      this.screen.cT("settings_take_photo_auto_save_video", true);
      this.screen.cT("settings_auto_mul_terminal_sync", true);
      this.screen.cT("settings_auto_mul_terminal_sync_tip", true);
      this.screen.cT("settings_take_photo_auto_save_tip", true);
      AppMethodBeat.o(74014);
      return;
      setMMTitle(2131766805);
      break;
      i = 0;
      break label258;
    }
    label425:
    if (((b)g.ab(b.class)).a(b.a.qxR, 0) == 1) {}
    for (int i = 1;; i = 0)
    {
      localObject = Build.MODEL.toLowerCase();
      String str = ((b)g.ab(b.class)).a(b.a.qxS, "");
      int j = i;
      if (!bu.isNullOrNil(str))
      {
        j = i;
        if (str.contains((CharSequence)localObject))
        {
          ae.i("ui.settings.SettingsAboutCamera", "model %s is hit, expt:%s", new Object[] { localObject, str });
          j = 0;
        }
      }
      if (j == 0)
      {
        this.screen.cT("settings_sns_auto_play_switch", true);
        this.screen.cT("settings_sns_auto_play_tip", true);
      }
      if (!SettingsAboutSystemUI.dQX())
      {
        this.screen.cT("settings_voip_audio_switch_mobile_net", true);
        this.screen.cT("settings_voip_audio_switch_mobile_net_tip", true);
      }
      AppMethodBeat.o(74014);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74012);
    super.onCreate(paramBundle);
    this.pkQ = v.aAH();
    this.yVt = getIntent().getIntExtra("activity_caller_params", 0);
    initView();
    AppMethodBeat.o(74012);
  }
  
  public void onDestroy()
  {
    int j = 1;
    AppMethodBeat.i(74015);
    super.onDestroy();
    ew localew = new ew();
    localew.ekH = 2;
    if (((Boolean)g.ajR().ajA().get(am.a.IRR, Boolean.TRUE)).booleanValue())
    {
      i = 1;
      localew.ekI = i;
      if (!((Boolean)g.ajR().ajA().get(am.a.IRT, Boolean.TRUE)).booleanValue()) {
        break label166;
      }
      i = 1;
      label82:
      localew.ekJ = i;
      if (!((Boolean)g.ajR().ajA().get(am.a.IRU, Boolean.TRUE)).booleanValue()) {
        break label171;
      }
      i = 1;
      label113:
      localew.ekK = i;
      if (!((Boolean)g.ajR().ajA().get(am.a.IRV, Boolean.TRUE)).booleanValue()) {
        break label176;
      }
    }
    label166:
    label171:
    label176:
    for (int i = j;; i = 2)
    {
      localew.ekL = i;
      localew.aLH();
      AppMethodBeat.o(74015);
      return;
      i = 2;
      break;
      i = 2;
      break label82;
      i = 2;
      break label113;
    }
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    int k = 1;
    int m = 1;
    int n = 1;
    int j = 1;
    AppMethodBeat.i(74013);
    paramf = paramPreference.mKey;
    boolean bool;
    aj localaj;
    am.a locala;
    if (paramf.equals("settings_auto_mul_terminal_sync"))
    {
      bool = ((Boolean)g.ajR().ajA().get(am.a.IRR, Boolean.TRUE)).booleanValue();
      localaj = g.ajR().ajA();
      locala = am.a.IRR;
      if (!bool)
      {
        bool = true;
        localaj.set(locala, Boolean.valueOf(bool));
      }
    }
    else
    {
      if (paramf.equals("settings_take_photo_auto_save_photo"))
      {
        bool = ((Boolean)g.ajR().ajA().get(am.a.IRT, Boolean.TRUE)).booleanValue();
        localaj = g.ajR().ajA();
        locala = am.a.IRT;
        if (bool) {
          break label494;
        }
        bool = true;
        label141:
        localaj.set(locala, Boolean.valueOf(bool));
      }
      if (paramf.equals("settings_take_photo_auto_save_video"))
      {
        bool = ((Boolean)g.ajR().ajA().get(am.a.IRU, Boolean.TRUE)).booleanValue();
        localaj = g.ajR().ajA();
        locala = am.a.IRU;
        if (bool) {
          break label500;
        }
        bool = true;
        label206:
        localaj.set(locala, Boolean.valueOf(bool));
      }
      if (paramf.equals("settings_sns_auto_play_switch"))
      {
        bool = ((Boolean)g.ajR().ajA().get(am.a.IRV, Boolean.TRUE)).booleanValue();
        localaj = g.ajR().ajA();
        locala = am.a.IRV;
        if (bool) {
          break label506;
        }
        bool = true;
        label271:
        localaj.set(locala, Boolean.valueOf(bool));
      }
      if (paramf.equals("settings_voip_audio_switch_mobile_net"))
      {
        bool = ((CheckBoxPreference)paramPreference).isChecked();
        ae.i("ui.settings.SettingsAboutCamera", "switch ext change : open = " + bool + " item value = 137438953472 functionId = 58");
        if (!bool) {
          break label512;
        }
        this.pkQ &= 0xFFFFFFFF;
        label347:
        if (!bool) {
          break label527;
        }
        i = 1;
        label354:
        paramPreference = new auo();
        paramPreference.GLx = 58;
        paramPreference.xsz = i;
        ((l)g.ab(l.class)).azE().d(new k.a(23, paramPreference));
        g.ajR().ajA().set(147457, Long.valueOf(this.pkQ));
      }
      paramPreference = new ew();
      paramPreference.ekH = 3;
      if (!bu.lX(paramf, "settings_auto_mul_terminal_sync")) {
        break label537;
      }
      if (!((Boolean)g.ajR().ajA().get(am.a.IRR, Boolean.TRUE)).booleanValue()) {
        break label532;
      }
      i = j;
      label470:
      paramPreference.ekI = i;
    }
    label494:
    label500:
    label506:
    do
    {
      paramPreference.aLH();
      AppMethodBeat.o(74013);
      return false;
      bool = false;
      break;
      bool = false;
      break label141;
      bool = false;
      break label206;
      bool = false;
      break label271;
      this.pkQ |= 0x0;
      break label347;
      i = 2;
      break label354;
      i = 2;
      break label470;
      if (bu.lX(paramf, "settings_take_photo_auto_save_photo"))
      {
        if (((Boolean)g.ajR().ajA().get(am.a.IRT, Boolean.TRUE)).booleanValue()) {}
        for (i = k;; i = 2)
        {
          paramPreference.ekJ = i;
          break;
        }
      }
      if (bu.lX(paramf, "settings_take_photo_auto_save_video"))
      {
        if (((Boolean)g.ajR().ajA().get(am.a.IRU, Boolean.TRUE)).booleanValue()) {}
        for (i = m;; i = 2)
        {
          paramPreference.ekK = i;
          break;
        }
      }
    } while (!bu.lX(paramf, "settings_sns_auto_play_switch"));
    label512:
    label527:
    label532:
    label537:
    if (((Boolean)g.ajR().ajA().get(am.a.IRV, Boolean.TRUE)).booleanValue()) {}
    for (int i = n;; i = 2)
    {
      paramPreference.ekL = i;
      break;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(190328);
    super.onResume();
    if (this.yVt == 1)
    {
      ((c)g.ab(c.class)).iU(true);
      com.tencent.mm.plugin.ball.f.f.e(true, false, true);
    }
    AppMethodBeat.o(190328);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutCamera
 * JD-Core Version:    0.7.0.1
 */