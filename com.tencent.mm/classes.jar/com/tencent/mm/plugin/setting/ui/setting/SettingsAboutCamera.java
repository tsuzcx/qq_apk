package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ie;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class SettingsAboutCamera
  extends MMPreference
{
  private final String CZZ = "settings_auto_mul_terminal_sync_tip";
  private final String Daa = "settings_auto_mul_terminal_sync";
  private final String Dab = "settings_take_photo_auto_save_tip";
  private final String Dac = "settings_take_photo_auto_save_photo";
  private final String Dad = "settings_take_photo_auto_save_video";
  private final String Dae = "settings_sns_auto_play_switch";
  private final String Daf = "settings_sns_auto_play_tip";
  private final String Dag = "settings_voip_audio_switch_mobile_net";
  private final String Dah = "settings_voip_audio_switch_mobile_net_tip";
  private int Dai = 0;
  private long qAb;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public int getResourceId()
  {
    return 2132017270;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74014);
    this.screen = getPreferenceScreen();
    Object localObject;
    if (!SettingsAboutSystemUI.eSY())
    {
      setMMTitle(2131765528);
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
      bool = ((Boolean)g.aAh().azQ().get(ar.a.NZT, Boolean.TRUE)).booleanValue();
      localObject = (CheckBoxPreference)this.screen.bmg("settings_auto_mul_terminal_sync");
      ((Preference)localObject).OZw = false;
      ((CheckBoxPreference)localObject).setChecked(bool);
      bool = ((Boolean)g.aAh().azQ().get(ar.a.NZV, Boolean.TRUE)).booleanValue();
      localObject = (CheckBoxPreference)this.screen.bmg("settings_take_photo_auto_save_photo");
      ((Preference)localObject).OZw = false;
      ((CheckBoxPreference)localObject).setChecked(bool);
      bool = ((Boolean)g.aAh().azQ().get(ar.a.NZW, Boolean.TRUE)).booleanValue();
      localObject = (CheckBoxPreference)this.screen.bmg("settings_take_photo_auto_save_video");
      ((CheckBoxPreference)localObject).setChecked(bool);
      ((Preference)localObject).OZw = false;
      bool = ((Boolean)g.aAh().azQ().get(ar.a.NZX, Boolean.TRUE)).booleanValue();
      localObject = (CheckBoxPreference)this.screen.bmg("settings_sns_auto_play_switch");
      ((CheckBoxPreference)localObject).setChecked(bool);
      ((Preference)localObject).OZw = false;
      if (SettingsAboutSystemUI.eSY())
      {
        if ((this.qAb & 0x0) == 0L) {
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
      localObject = (CheckBoxPreference)this.screen.bmg("settings_voip_audio_switch_mobile_net");
      ((CheckBoxPreference)localObject).setChecked(bool);
      ((Preference)localObject).OZw = false;
      this.screen.notifyDataSetChanged();
      if (this.Dai != 1) {
        break label425;
      }
      this.screen.jdMethod_do("settings_sns_auto_play_switch", true);
      this.screen.jdMethod_do("settings_sns_auto_play_tip", true);
      this.screen.jdMethod_do("settings_take_photo_auto_save_photo", true);
      this.screen.jdMethod_do("settings_take_photo_auto_save_video", true);
      this.screen.jdMethod_do("settings_auto_mul_terminal_sync", true);
      this.screen.jdMethod_do("settings_auto_mul_terminal_sync_tip", true);
      this.screen.jdMethod_do("settings_take_photo_auto_save_tip", true);
      AppMethodBeat.o(74014);
      return;
      setMMTitle(2131765529);
      break;
      i = 0;
      break label258;
    }
    label425:
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rPM, 0) == 1) {}
    for (int i = 1;; i = 0)
    {
      localObject = Build.MODEL.toLowerCase();
      String str = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rPN, "");
      int j = i;
      if (!Util.isNullOrNil(str))
      {
        j = i;
        if (str.contains((CharSequence)localObject))
        {
          Log.i("ui.settings.SettingsAboutCamera", "model %s is hit, expt:%s", new Object[] { localObject, str });
          j = 0;
        }
      }
      if (j == 0)
      {
        this.screen.jdMethod_do("settings_sns_auto_play_switch", true);
        this.screen.jdMethod_do("settings_sns_auto_play_tip", true);
      }
      if (!SettingsAboutSystemUI.eSY())
      {
        this.screen.jdMethod_do("settings_voip_audio_switch_mobile_net", true);
        this.screen.jdMethod_do("settings_voip_audio_switch_mobile_net_tip", true);
      }
      AppMethodBeat.o(74014);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74012);
    super.onCreate(paramBundle);
    this.qAb = z.aUd();
    this.Dai = getIntent().getIntExtra("activity_caller_params", 0);
    initView();
    AppMethodBeat.o(74012);
  }
  
  public void onDestroy()
  {
    int j = 1;
    AppMethodBeat.i(74015);
    super.onDestroy();
    ie localie = new ie();
    localie.eNt = 2;
    if (((Boolean)g.aAh().azQ().get(ar.a.NZT, Boolean.TRUE)).booleanValue())
    {
      i = 1;
      localie.eNu = i;
      if (!((Boolean)g.aAh().azQ().get(ar.a.NZV, Boolean.TRUE)).booleanValue()) {
        break label166;
      }
      i = 1;
      label82:
      localie.eNv = i;
      if (!((Boolean)g.aAh().azQ().get(ar.a.NZW, Boolean.TRUE)).booleanValue()) {
        break label171;
      }
      i = 1;
      label113:
      localie.eNw = i;
      if (!((Boolean)g.aAh().azQ().get(ar.a.NZX, Boolean.TRUE)).booleanValue()) {
        break label176;
      }
    }
    label166:
    label171:
    label176:
    for (int i = j;; i = 2)
    {
      localie.eNx = i;
      localie.bfK();
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
    ao localao;
    ar.a locala;
    if (paramf.equals("settings_auto_mul_terminal_sync"))
    {
      bool = ((Boolean)g.aAh().azQ().get(ar.a.NZT, Boolean.TRUE)).booleanValue();
      localao = g.aAh().azQ();
      locala = ar.a.NZT;
      if (!bool)
      {
        bool = true;
        localao.set(locala, Boolean.valueOf(bool));
      }
    }
    else
    {
      if (paramf.equals("settings_take_photo_auto_save_photo"))
      {
        bool = ((Boolean)g.aAh().azQ().get(ar.a.NZV, Boolean.TRUE)).booleanValue();
        localao = g.aAh().azQ();
        locala = ar.a.NZV;
        if (bool) {
          break label494;
        }
        bool = true;
        label141:
        localao.set(locala, Boolean.valueOf(bool));
      }
      if (paramf.equals("settings_take_photo_auto_save_video"))
      {
        bool = ((Boolean)g.aAh().azQ().get(ar.a.NZW, Boolean.TRUE)).booleanValue();
        localao = g.aAh().azQ();
        locala = ar.a.NZW;
        if (bool) {
          break label500;
        }
        bool = true;
        label206:
        localao.set(locala, Boolean.valueOf(bool));
      }
      if (paramf.equals("settings_sns_auto_play_switch"))
      {
        bool = ((Boolean)g.aAh().azQ().get(ar.a.NZX, Boolean.TRUE)).booleanValue();
        localao = g.aAh().azQ();
        locala = ar.a.NZX;
        if (bool) {
          break label506;
        }
        bool = true;
        label271:
        localao.set(locala, Boolean.valueOf(bool));
      }
      if (paramf.equals("settings_voip_audio_switch_mobile_net"))
      {
        bool = ((CheckBoxPreference)paramPreference).isChecked();
        Log.i("ui.settings.SettingsAboutCamera", "switch ext change : open = " + bool + " item value = 137438953472 functionId = 58");
        if (!bool) {
          break label512;
        }
        this.qAb &= 0xFFFFFFFF;
        label347:
        if (!bool) {
          break label527;
        }
        i = 1;
        label354:
        paramPreference = new bfx();
        paramPreference.LPB = 58;
        paramPreference.BsD = i;
        ((l)g.af(l.class)).aSM().d(new k.a(23, paramPreference));
        g.aAh().azQ().set(147457, Long.valueOf(this.qAb));
      }
      paramPreference = new ie();
      paramPreference.eNt = 3;
      if (!Util.isEqual(paramf, "settings_auto_mul_terminal_sync")) {
        break label537;
      }
      if (!((Boolean)g.aAh().azQ().get(ar.a.NZT, Boolean.TRUE)).booleanValue()) {
        break label532;
      }
      i = j;
      label470:
      paramPreference.eNu = i;
    }
    label494:
    label500:
    label506:
    do
    {
      paramPreference.bfK();
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
      this.qAb |= 0x0;
      break label347;
      i = 2;
      break label354;
      i = 2;
      break label470;
      if (Util.isEqual(paramf, "settings_take_photo_auto_save_photo"))
      {
        if (((Boolean)g.aAh().azQ().get(ar.a.NZV, Boolean.TRUE)).booleanValue()) {}
        for (i = k;; i = 2)
        {
          paramPreference.eNv = i;
          break;
        }
      }
      if (Util.isEqual(paramf, "settings_take_photo_auto_save_video"))
      {
        if (((Boolean)g.aAh().azQ().get(ar.a.NZW, Boolean.TRUE)).booleanValue()) {}
        for (i = m;; i = 2)
        {
          paramPreference.eNw = i;
          break;
        }
      }
    } while (!Util.isEqual(paramf, "settings_sns_auto_play_switch"));
    label512:
    label527:
    label532:
    label537:
    if (((Boolean)g.aAh().azQ().get(ar.a.NZX, Boolean.TRUE)).booleanValue()) {}
    for (int i = n;; i = 2)
    {
      paramPreference.eNx = i;
      break;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(256496);
    super.onResume();
    if (this.Dai == 1)
    {
      ((com.tencent.mm.plugin.ball.c.b)g.af(com.tencent.mm.plugin.ball.c.b.class)).jS(true);
      com.tencent.mm.plugin.ball.f.f.e(true, false, true);
    }
    AppMethodBeat.o(256496);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutCamera
 * JD-Core Version:    0.7.0.1
 */