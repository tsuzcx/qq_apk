package com.tencent.mm.plugin.shake.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.d;
import com.tencent.mm.m.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.shake.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
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
    return 2131165297;
  }
  
  public void initView()
  {
    AppMethodBeat.i(24769);
    setMMTitle(2131303596);
    this.screen = getPreferenceScreen();
    CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)this.screen.atx("shake_item_sound");
    aw.aaz();
    if (com.tencent.mm.model.c.Ru().get(4112, null) == null)
    {
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(4112, Boolean.TRUE);
    }
    aw.aaz();
    localCheckBoxPreference.vxW = bo.d((Boolean)com.tencent.mm.model.c.Ru().get(4112, null));
    setBackBtn(new ShakePersonalInfoUI.1(this));
    if (!d.aiE()) {
      this.screen.aty("shake_item_shake_music_list");
    }
    AppMethodBeat.o(24769);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(24773);
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(24773);
      return;
    case 1: 
      if (paramIntent == null)
      {
        AppMethodBeat.o(24773);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("CropImageMode", 4);
      localIntent.putExtra("CropImage_Filter", true);
      localIntent.putExtra("CropImage_DirectlyIntoFilter", true);
      StringBuilder localStringBuilder = new StringBuilder();
      aw.aaz();
      localIntent.putExtra("CropImage_OutputPath", com.tencent.mm.model.c.YK() + "custom_shake_img_filename.jpg");
      a.gmO.a(localIntent, 2, this, paramIntent);
      AppMethodBeat.o(24773);
      return;
    }
    if (paramIntent == null)
    {
      AppMethodBeat.o(24773);
      return;
    }
    paramIntent = paramIntent.getStringExtra("CropImage_OutputPath");
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(4110, Boolean.FALSE);
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(4111, paramIntent);
    AppMethodBeat.o(24773);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24767);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(24767);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(24768);
    a.gmP.BO();
    super.onDestroy();
    AppMethodBeat.o(24768);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(24771);
    if (paramInt == 4)
    {
      finish();
      AppMethodBeat.o(24771);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(24771);
    return bool;
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(24772);
    paramf = paramPreference.mKey;
    if ("shake_item_default_bgimg".equals(paramf))
    {
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(4110, Boolean.TRUE);
      h.bO(this, getResources().getString(2131303633));
    }
    if ("shake_item_change_bgimg".equals(paramf)) {
      com.tencent.mm.pluginsdk.ui.tools.n.a(this, 1, null);
    }
    if ("shake_item_sound".equals(paramf))
    {
      aw.aaz();
      bool = bo.d((Boolean)com.tencent.mm.model.c.Ru().get(4112, null));
      aw.aaz();
      paramPreference = com.tencent.mm.model.c.Ru();
      if (bool) {
        break label259;
      }
    }
    label259:
    for (boolean bool = true;; bool = false)
    {
      paramPreference.set(4112, Boolean.valueOf(bool));
      if ("say_hi_list_shake_title".equals(paramf))
      {
        paramPreference = new Intent(this, ShakeSayHiListUI.class);
        paramPreference.putExtra("IntentSayHiType", 1);
        startActivity(paramPreference);
      }
      if ("shake_item_histoty_list".equals(paramf))
      {
        paramPreference = new Intent(this, ShakeItemListUI.class);
        paramPreference.putExtra("_key_show_type_", 100);
        paramPreference.putExtra("_key_title_", getString(2131303595));
        startActivity(paramPreference);
      }
      if ("shake_msg_list".equals(paramf))
      {
        paramf = new Intent(this, ShakeMsgListUI.class);
        paramf.putExtra("shake_msg_from", 2);
        paramf.putExtra("shake_msg_list_title", getString(2131303655));
        startActivity(paramf);
      }
      AppMethodBeat.o(24772);
      return false;
    }
  }
  
  public void onResume()
  {
    boolean bool = false;
    AppMethodBeat.i(24770);
    super.onResume();
    if (aw.RG()) {
      a.gmP.BO();
    }
    if (this.screen.atx("shake_item_shake_tv_list") == null)
    {
      ab.e("MicroMsg.mmui.MMPreference", "shake_tv_list preference is null");
      AppMethodBeat.o(24770);
      return;
    }
    if (bo.getInt(g.Nr().R("ShowConfig", "showShakeTV"), 0) == 1) {
      bool = true;
    }
    ab.d("MicroMsg.ConfigListDecoder", "isShowShakeTV : ".concat(String.valueOf(bool)));
    if ((!bool) && (!ae.gkB)) {
      this.screen.cl("shake_item_shake_tv_list", true);
    }
    AppMethodBeat.o(24770);
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