package com.tencent.mm.plugin.shake.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.av.d;
import com.tencent.mm.m.g;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.shake.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class ShakePersonalInfoUI
  extends MMPreference
{
  private f dnn;
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    paramf = paramPreference.mKey;
    if ("shake_item_default_bgimg".equals(paramf))
    {
      au.Hx();
      com.tencent.mm.model.c.Dz().o(4110, Boolean.valueOf(true));
      h.bC(this, getResources().getString(R.l.shake_settings_laert_reset_bg_ok));
    }
    if ("shake_item_change_bgimg".equals(paramf)) {
      com.tencent.mm.pluginsdk.ui.tools.l.a(this, 1, null);
    }
    if ("shake_item_sound".equals(paramf))
    {
      au.Hx();
      bool = bk.c((Boolean)com.tencent.mm.model.c.Dz().get(4112, null));
      au.Hx();
      paramPreference = com.tencent.mm.model.c.Dz();
      if (bool) {
        break label247;
      }
    }
    label247:
    for (boolean bool = true;; bool = false)
    {
      paramPreference.o(4112, Boolean.valueOf(bool));
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
        paramPreference.putExtra("_key_title_", getString(R.l.shake_item_history_list));
        startActivity(paramPreference);
      }
      if ("shake_msg_list".equals(paramf))
      {
        paramf = new Intent(this, ShakeMsgListUI.class);
        paramf.putExtra("shake_msg_from", 2);
        paramf.putExtra("shake_msg_list_title", getString(R.l.shake_tv_msg_center_title));
        startActivity(paramf);
      }
      return false;
    }
  }
  
  protected final void initView()
  {
    setMMTitle(R.l.shake_item_setting);
    this.dnn = this.vdd;
    CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)this.dnn.add("shake_item_sound");
    au.Hx();
    if (com.tencent.mm.model.c.Dz().get(4112, null) == null)
    {
      au.Hx();
      com.tencent.mm.model.c.Dz().o(4112, Boolean.valueOf(true));
    }
    au.Hx();
    localCheckBoxPreference.rHo = bk.c((Boolean)com.tencent.mm.model.c.Dz().get(4112, null));
    setBackBtn(new ShakePersonalInfoUI.1(this));
    if (!d.PB()) {
      this.dnn.ade("shake_item_shake_music_list");
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        return;
      } while (paramIntent == null);
      Intent localIntent = new Intent();
      localIntent.putExtra("CropImageMode", 4);
      localIntent.putExtra("CropImage_Filter", true);
      localIntent.putExtra("CropImage_DirectlyIntoFilter", true);
      StringBuilder localStringBuilder = new StringBuilder();
      au.Hx();
      localIntent.putExtra("CropImage_OutputPath", com.tencent.mm.model.c.FG() + "custom_shake_img_filename.jpg");
      a.eUR.a(localIntent, 2, this, paramIntent);
      return;
    } while (paramIntent == null);
    paramIntent = paramIntent.getStringExtra("CropImage_OutputPath");
    au.Hx();
    com.tencent.mm.model.c.Dz().o(4110, Boolean.valueOf(false));
    au.Hx();
    com.tencent.mm.model.c.Dz().o(4111, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
  
  public void onDestroy()
  {
    a.eUS.tk();
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      finish();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    boolean bool = false;
    super.onResume();
    if (au.DK()) {
      a.eUS.tk();
    }
    if (this.dnn.add("shake_item_shake_tv_list") == null) {
      y.e("MicroMsg.mmui.MMPreference", "shake_tv_list preference is null");
    }
    do
    {
      return;
      if (bk.getInt(g.AB().H("ShowConfig", "showShakeTV"), 0) == 1) {
        bool = true;
      }
      y.d("MicroMsg.ConfigListDecoder", "isShowShakeTV : " + bool);
    } while ((bool) || (ae.eSG));
    this.dnn.bJ("shake_item_shake_tv_list", true);
  }
  
  public final int xj()
  {
    return R.o.shake_settings_pref_personal_info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakePersonalInfoUI
 * JD-Core Version:    0.7.0.1
 */