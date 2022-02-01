package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.eu;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.ball.c.c;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.aty;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class SettingsAboutCamera
  extends MMPreference
{
  private long pek;
  private com.tencent.mm.ui.base.preference.f screen;
  private final String yFf = "settings_auto_mul_terminal_sync_tip";
  private final String yFg = "settings_auto_mul_terminal_sync";
  private final String yFh = "settings_take_photo_auto_save_tip";
  private final String yFi = "settings_take_photo_auto_save_photo";
  private final String yFj = "settings_take_photo_auto_save_video";
  private final String yFk = "settings_sns_auto_play_switch";
  private final String yFl = "settings_sns_auto_play_tip";
  private final String yFm = "settings_voip_audio_switch_mobile_net";
  private final String yFn = "settings_voip_audio_switch_mobile_net_tip";
  private int yFo = 0;
  
  public int getResourceId()
  {
    return 2131951725;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74014);
    this.screen = getPreferenceScreen();
    Object localObject;
    if (!SettingsAboutSystemUI.dNA())
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
      bool = ((Boolean)g.ajC().ajl().get(al.a.Ixt, Boolean.TRUE)).booleanValue();
      localObject = (CheckBoxPreference)this.screen.aVD("settings_auto_mul_terminal_sync");
      ((Preference)localObject).JtB = false;
      ((CheckBoxPreference)localObject).oB = bool;
      bool = ((Boolean)g.ajC().ajl().get(al.a.Ixv, Boolean.TRUE)).booleanValue();
      localObject = (CheckBoxPreference)this.screen.aVD("settings_take_photo_auto_save_photo");
      ((Preference)localObject).JtB = false;
      ((CheckBoxPreference)localObject).oB = bool;
      bool = ((Boolean)g.ajC().ajl().get(al.a.Ixw, Boolean.TRUE)).booleanValue();
      localObject = (CheckBoxPreference)this.screen.aVD("settings_take_photo_auto_save_video");
      ((CheckBoxPreference)localObject).oB = bool;
      ((Preference)localObject).JtB = false;
      bool = ((Boolean)g.ajC().ajl().get(al.a.Ixx, Boolean.TRUE)).booleanValue();
      localObject = (CheckBoxPreference)this.screen.aVD("settings_sns_auto_play_switch");
      ((CheckBoxPreference)localObject).oB = bool;
      ((Preference)localObject).JtB = false;
      if (SettingsAboutSystemUI.dNA())
      {
        if ((this.pek & 0x0) == 0L) {
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
      localObject = (CheckBoxPreference)this.screen.aVD("settings_voip_audio_switch_mobile_net");
      ((CheckBoxPreference)localObject).oB = bool;
      ((Preference)localObject).JtB = false;
      this.screen.notifyDataSetChanged();
      if (this.yFo != 1) {
        break label425;
      }
      this.screen.cP("settings_sns_auto_play_switch", true);
      this.screen.cP("settings_sns_auto_play_tip", true);
      this.screen.cP("settings_take_photo_auto_save_photo", true);
      this.screen.cP("settings_take_photo_auto_save_video", true);
      this.screen.cP("settings_auto_mul_terminal_sync", true);
      this.screen.cP("settings_auto_mul_terminal_sync_tip", true);
      this.screen.cP("settings_take_photo_auto_save_tip", true);
      AppMethodBeat.o(74014);
      return;
      setMMTitle(2131766805);
      break;
      i = 0;
      break label258;
    }
    label425:
    if (((b)g.ab(b.class)).a(b.a.qrc, 0) == 1) {}
    for (int i = 1;; i = 0)
    {
      localObject = Build.MODEL.toLowerCase();
      String str = ((b)g.ab(b.class)).a(b.a.qrd, "");
      int j = i;
      if (!bt.isNullOrNil(str))
      {
        j = i;
        if (str.contains((CharSequence)localObject))
        {
          ad.i("ui.settings.SettingsAboutCamera", "model %s is hit, expt:%s", new Object[] { localObject, str });
          j = 0;
        }
      }
      if (j == 0)
      {
        this.screen.cP("settings_sns_auto_play_switch", true);
        this.screen.cP("settings_sns_auto_play_tip", true);
      }
      if (!SettingsAboutSystemUI.dNA())
      {
        this.screen.cP("settings_voip_audio_switch_mobile_net", true);
        this.screen.cP("settings_voip_audio_switch_mobile_net_tip", true);
      }
      AppMethodBeat.o(74014);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74012);
    super.onCreate(paramBundle);
    this.pek = u.aAr();
    this.yFo = getIntent().getIntExtra("activity_caller_params", 0);
    initView();
    AppMethodBeat.o(74012);
  }
  
  public void onDestroy()
  {
    int j = 1;
    AppMethodBeat.i(74015);
    super.onDestroy();
    eu localeu = new eu();
    localeu.eiZ = 2;
    if (((Boolean)g.ajC().ajl().get(al.a.Ixt, Boolean.TRUE)).booleanValue())
    {
      i = 1;
      localeu.eja = i;
      if (!((Boolean)g.ajC().ajl().get(al.a.Ixv, Boolean.TRUE)).booleanValue()) {
        break label166;
      }
      i = 1;
      label82:
      localeu.ejb = i;
      if (!((Boolean)g.ajC().ajl().get(al.a.Ixw, Boolean.TRUE)).booleanValue()) {
        break label171;
      }
      i = 1;
      label113:
      localeu.ejc = i;
      if (!((Boolean)g.ajC().ajl().get(al.a.Ixx, Boolean.TRUE)).booleanValue()) {
        break label176;
      }
    }
    label166:
    label171:
    label176:
    for (int i = j;; i = 2)
    {
      localeu.ejd = i;
      localeu.aLk();
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
    ai localai;
    al.a locala;
    if (paramf.equals("settings_auto_mul_terminal_sync"))
    {
      bool = ((Boolean)g.ajC().ajl().get(al.a.Ixt, Boolean.TRUE)).booleanValue();
      localai = g.ajC().ajl();
      locala = al.a.Ixt;
      if (!bool)
      {
        bool = true;
        localai.set(locala, Boolean.valueOf(bool));
      }
    }
    else
    {
      if (paramf.equals("settings_take_photo_auto_save_photo"))
      {
        bool = ((Boolean)g.ajC().ajl().get(al.a.Ixv, Boolean.TRUE)).booleanValue();
        localai = g.ajC().ajl();
        locala = al.a.Ixv;
        if (bool) {
          break label494;
        }
        bool = true;
        label141:
        localai.set(locala, Boolean.valueOf(bool));
      }
      if (paramf.equals("settings_take_photo_auto_save_video"))
      {
        bool = ((Boolean)g.ajC().ajl().get(al.a.Ixw, Boolean.TRUE)).booleanValue();
        localai = g.ajC().ajl();
        locala = al.a.Ixw;
        if (bool) {
          break label500;
        }
        bool = true;
        label206:
        localai.set(locala, Boolean.valueOf(bool));
      }
      if (paramf.equals("settings_sns_auto_play_switch"))
      {
        bool = ((Boolean)g.ajC().ajl().get(al.a.Ixx, Boolean.TRUE)).booleanValue();
        localai = g.ajC().ajl();
        locala = al.a.Ixx;
        if (bool) {
          break label506;
        }
        bool = true;
        label271:
        localai.set(locala, Boolean.valueOf(bool));
      }
      if (paramf.equals("settings_voip_audio_switch_mobile_net"))
      {
        bool = ((CheckBoxPreference)paramPreference).isChecked();
        ad.i("ui.settings.SettingsAboutCamera", "switch ext change : open = " + bool + " item value = 137438953472 functionId = 58");
        if (!bool) {
          break label512;
        }
        this.pek &= 0xFFFFFFFF;
        label347:
        if (!bool) {
          break label527;
        }
        i = 1;
        label354:
        paramPreference = new aty();
        paramPreference.GrZ = 58;
        paramPreference.xcI = i;
        ((l)g.ab(l.class)).azo().c(new k.a(23, paramPreference));
        g.ajC().ajl().set(147457, Long.valueOf(this.pek));
      }
      paramPreference = new eu();
      paramPreference.eiZ = 3;
      if (!bt.lQ(paramf, "settings_auto_mul_terminal_sync")) {
        break label537;
      }
      if (!((Boolean)g.ajC().ajl().get(al.a.Ixt, Boolean.TRUE)).booleanValue()) {
        break label532;
      }
      i = j;
      label470:
      paramPreference.eja = i;
    }
    label494:
    label500:
    label506:
    do
    {
      paramPreference.aLk();
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
      this.pek |= 0x0;
      break label347;
      i = 2;
      break label354;
      i = 2;
      break label470;
      if (bt.lQ(paramf, "settings_take_photo_auto_save_photo"))
      {
        if (((Boolean)g.ajC().ajl().get(al.a.Ixv, Boolean.TRUE)).booleanValue()) {}
        for (i = k;; i = 2)
        {
          paramPreference.ejb = i;
          break;
        }
      }
      if (bt.lQ(paramf, "settings_take_photo_auto_save_video"))
      {
        if (((Boolean)g.ajC().ajl().get(al.a.Ixw, Boolean.TRUE)).booleanValue()) {}
        for (i = m;; i = 2)
        {
          paramPreference.ejc = i;
          break;
        }
      }
    } while (!bt.lQ(paramf, "settings_sns_auto_play_switch"));
    label512:
    label527:
    label532:
    label537:
    if (((Boolean)g.ajC().ajl().get(al.a.Ixx, Boolean.TRUE)).booleanValue()) {}
    for (int i = n;; i = 2)
    {
      paramPreference.ejd = i;
      break;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(220966);
    super.onResume();
    if (this.yFo == 1)
    {
      ((c)g.ab(c.class)).iV(true);
      com.tencent.mm.plugin.ball.f.f.e(true, false, true);
    }
    AppMethodBeat.o(220966);
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