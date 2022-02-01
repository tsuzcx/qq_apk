package com.tencent.mm.plugin.shake.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.e;
import com.tencent.mm.model.ba;
import com.tencent.mm.n.g;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class ShakePersonalInfoUI
  extends MMPreference
{
  private f screen;
  
  public int getResourceId()
  {
    return 2131951741;
  }
  
  public void initView()
  {
    AppMethodBeat.i(28440);
    setMMTitle(2131763578);
    this.screen = getPreferenceScreen();
    CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)this.screen.aVD("shake_item_sound");
    ba.aBQ();
    if (com.tencent.mm.model.c.ajl().get(4112, null) == null)
    {
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(4112, Boolean.TRUE);
    }
    ba.aBQ();
    localCheckBoxPreference.oB = bt.n((Boolean)com.tencent.mm.model.c.ajl().get(4112, null));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(28437);
        ShakePersonalInfoUI.this.finish();
        AppMethodBeat.o(28437);
        return true;
      }
    });
    if (!e.aJO()) {
      this.screen.aVE("shake_item_shake_music_list");
    }
    AppMethodBeat.o(28440);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(28444);
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(28444);
      return;
    case 1: 
      if (paramIntent == null)
      {
        AppMethodBeat.o(28444);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("CropImageMode", 4);
      localIntent.putExtra("CropImage_Filter", true);
      localIntent.putExtra("CropImage_DirectlyIntoFilter", true);
      StringBuilder localStringBuilder = new StringBuilder();
      ba.aBQ();
      localIntent.putExtra("CropImage_OutputPath", com.tencent.mm.model.c.azA() + "custom_shake_img_filename.jpg");
      com.tencent.mm.plugin.shake.a.iRG.a(localIntent, 2, this, paramIntent);
      AppMethodBeat.o(28444);
      return;
    }
    if (paramIntent == null)
    {
      AppMethodBeat.o(28444);
      return;
    }
    paramIntent = paramIntent.getStringExtra("CropImage_OutputPath");
    ba.aBQ();
    com.tencent.mm.model.c.ajl().set(4110, Boolean.FALSE);
    ba.aBQ();
    com.tencent.mm.model.c.ajl().set(4111, paramIntent);
    AppMethodBeat.o(28444);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(28438);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(28438);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(28439);
    com.tencent.mm.plugin.shake.a.iRH.MR();
    super.onDestroy();
    AppMethodBeat.o(28439);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(28442);
    if (paramInt == 4)
    {
      finish();
      AppMethodBeat.o(28442);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(28442);
    return bool;
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(28443);
    paramf = paramPreference.mKey;
    if ("shake_item_default_bgimg".equals(paramf))
    {
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(4110, Boolean.TRUE);
      h.cl(this, getResources().getString(2131763615));
    }
    if ("shake_item_change_bgimg".equals(paramf)) {
      q.c(this, 1, null);
    }
    if ("shake_item_sound".equals(paramf))
    {
      ba.aBQ();
      bool = bt.n((Boolean)com.tencent.mm.model.c.ajl().get(4112, null));
      ba.aBQ();
      paramPreference = com.tencent.mm.model.c.ajl();
      if (bool) {
        break label448;
      }
    }
    label448:
    for (boolean bool = true;; bool = false)
    {
      paramPreference.set(4112, Boolean.valueOf(bool));
      if ("say_hi_list_shake_title".equals(paramf))
      {
        paramPreference = new Intent(this, ShakeSayHiListUI.class);
        paramPreference.putExtra("IntentSayHiType", 1);
        paramPreference = new com.tencent.mm.hellhoundlib.b.a().bc(paramPreference);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramPreference.ahp(), "com/tencent/mm/plugin/shake/ui/ShakePersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramPreference.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakePersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      if ("shake_item_histoty_list".equals(paramf))
      {
        paramPreference = new Intent(this, ShakeItemListUI.class);
        paramPreference.putExtra("_key_show_type_", 100);
        paramPreference.putExtra("_key_title_", getString(2131763577));
        paramPreference = new com.tencent.mm.hellhoundlib.b.a().bc(paramPreference);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramPreference.ahp(), "com/tencent/mm/plugin/shake/ui/ShakePersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramPreference.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakePersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      if ("shake_msg_list".equals(paramf))
      {
        paramf = new Intent(this, ShakeMsgListUI.class);
        paramf.putExtra("shake_msg_from", 2);
        paramf.putExtra("shake_msg_list_title", getString(2131763637));
        paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahp(), "com/tencent/mm/plugin/shake/ui/ShakePersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakePersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      AppMethodBeat.o(28443);
      return false;
    }
  }
  
  public void onResume()
  {
    boolean bool = false;
    AppMethodBeat.i(28441);
    super.onResume();
    if (ba.ajx()) {
      com.tencent.mm.plugin.shake.a.iRH.MR();
    }
    if (this.screen.aVD("shake_item_shake_tv_list") == null)
    {
      ad.e("MicroMsg.mmui.MMPreference", "shake_tv_list preference is null");
      AppMethodBeat.o(28441);
      return;
    }
    if (bt.getInt(g.acB().ah("ShowConfig", "showShakeTV"), 0) == 1) {
      bool = true;
    }
    ad.d("MicroMsg.ConfigListDecoder", "isShowShakeTV : ".concat(String.valueOf(bool)));
    if ((!bool) && (!ac.iOE)) {
      this.screen.cP("shake_item_shake_tv_list", true);
    }
    AppMethodBeat.o(28441);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakePersonalInfoUI
 * JD-Core Version:    0.7.0.1
 */