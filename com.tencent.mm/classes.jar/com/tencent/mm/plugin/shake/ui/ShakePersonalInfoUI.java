package com.tencent.mm.plugin.shake.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.e;
import com.tencent.mm.m.g;
import com.tencent.mm.model.az;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
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
    CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)this.screen.aPN("shake_item_sound");
    az.ayM();
    if (com.tencent.mm.model.c.agA().get(4112, null) == null)
    {
      az.ayM();
      com.tencent.mm.model.c.agA().set(4112, Boolean.TRUE);
    }
    az.ayM();
    localCheckBoxPreference.mF = bs.k((Boolean)com.tencent.mm.model.c.agA().get(4112, null));
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
    if (!e.aGD()) {
      this.screen.aPO("shake_item_shake_music_list");
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
      az.ayM();
      localIntent.putExtra("CropImage_OutputPath", com.tencent.mm.model.c.awL() + "custom_shake_img_filename.jpg");
      com.tencent.mm.plugin.shake.a.iyx.a(localIntent, 2, this, paramIntent);
      AppMethodBeat.o(28444);
      return;
    }
    if (paramIntent == null)
    {
      AppMethodBeat.o(28444);
      return;
    }
    paramIntent = paramIntent.getStringExtra("CropImage_OutputPath");
    az.ayM();
    com.tencent.mm.model.c.agA().set(4110, Boolean.FALSE);
    az.ayM();
    com.tencent.mm.model.c.agA().set(4111, paramIntent);
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
    com.tencent.mm.plugin.shake.a.iyy.Lj();
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
      az.ayM();
      com.tencent.mm.model.c.agA().set(4110, Boolean.TRUE);
      h.cg(this, getResources().getString(2131763615));
    }
    if ("shake_item_change_bgimg".equals(paramf)) {
      q.c(this, 1, null);
    }
    if ("shake_item_sound".equals(paramf))
    {
      az.ayM();
      bool = bs.k((Boolean)com.tencent.mm.model.c.agA().get(4112, null));
      az.ayM();
      paramPreference = com.tencent.mm.model.c.agA();
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
        paramPreference = new com.tencent.mm.hellhoundlib.b.a().ba(paramPreference);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramPreference.aeD(), "com/tencent/mm/plugin/shake/ui/ShakePersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramPreference.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakePersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      if ("shake_item_histoty_list".equals(paramf))
      {
        paramPreference = new Intent(this, ShakeItemListUI.class);
        paramPreference.putExtra("_key_show_type_", 100);
        paramPreference.putExtra("_key_title_", getString(2131763577));
        paramPreference = new com.tencent.mm.hellhoundlib.b.a().ba(paramPreference);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramPreference.aeD(), "com/tencent/mm/plugin/shake/ui/ShakePersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramPreference.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakePersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      if ("shake_msg_list".equals(paramf))
      {
        paramf = new Intent(this, ShakeMsgListUI.class);
        paramf.putExtra("shake_msg_from", 2);
        paramf.putExtra("shake_msg_list_title", getString(2131763637));
        paramf = new com.tencent.mm.hellhoundlib.b.a().ba(paramf);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramf.aeD(), "com/tencent/mm/plugin/shake/ui/ShakePersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.lR(0));
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
    if (az.agM()) {
      com.tencent.mm.plugin.shake.a.iyy.Lj();
    }
    if (this.screen.aPN("shake_item_shake_tv_list") == null)
    {
      ac.e("MicroMsg.mmui.MMPreference", "shake_tv_list preference is null");
      AppMethodBeat.o(28441);
      return;
    }
    if (bs.getInt(g.ZZ().ag("ShowConfig", "showShakeTV"), 0) == 1) {
      bool = true;
    }
    ac.d("MicroMsg.ConfigListDecoder", "isShowShakeTV : ".concat(String.valueOf(bool)));
    if ((!bool) && (!ab.ivx)) {
      this.screen.cK("shake_item_shake_tv_list", true);
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