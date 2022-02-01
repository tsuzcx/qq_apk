package com.tencent.mm.plugin.shake.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.aw.e;
import com.tencent.mm.k.d;
import com.tencent.mm.k.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.shake.b;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.a.j;
import java.util.Objects;

public class ShakePersonalInfoUI
  extends MMPreference
{
  private com.tencent.mm.ui.base.preference.f screen;
  
  public int getResourceId()
  {
    return R.o.hbr;
  }
  
  public void initView()
  {
    AppMethodBeat.i(28440);
    setMMTitle(R.l.gVz);
    this.screen = getPreferenceScreen();
    CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)this.screen.bAi("shake_item_sound");
    bh.bCz();
    if (c.ban().d(4112, null) == null)
    {
      bh.bCz();
      c.ban().B(4112, Boolean.TRUE);
    }
    bh.bCz();
    localCheckBoxPreference.setChecked(Util.nullAsTrue((Boolean)c.ban().d(4112, null)));
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
    if (!e.bLs()) {
      this.screen.bAk("shake_item_shake_music_list");
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
      bh.bCz();
      localIntent.putExtra("CropImage_OutputPath", c.bzL() + "custom_shake_img_filename.jpg");
      b.pFn.a(localIntent, 2, this, paramIntent);
      AppMethodBeat.o(28444);
      return;
    }
    if (paramIntent == null)
    {
      AppMethodBeat.o(28444);
      return;
    }
    paramIntent = paramIntent.getStringExtra("CropImage_OutputPath");
    bh.bCz();
    c.ban().B(4110, Boolean.FALSE);
    bh.bCz();
    c.ban().B(4111, paramIntent);
    aa.y(this, com.tencent.mm.cd.a.bt(getContext(), R.l.gVO), R.k.icons_filled_done);
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
    b.pFo.aDx();
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
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(28443);
    paramf = paramPreference.mKey;
    boolean bool1;
    if ("shake_item_change_bgimg".equals(paramf))
    {
      if (!h.baE().ban().getBoolean(at.a.adhT, false))
      {
        paramPreference = af.mU(getContext()).inflate(R.i.gnX, null);
        j localj = new j(getContext(), 2, 0);
        localj.au(com.tencent.mm.cd.a.bt(getContext(), R.l.gXp));
        localj.aFe(1);
        Objects.requireNonNull(localj);
        localj.agfR = new ShakePersonalInfoUI..ExternalSyntheticLambda4(localj);
        localj.setCustomView(paramPreference);
        localj.dDn();
        bh.bCz();
        c.ban().set(at.a.adhT, Boolean.TRUE);
      }
    }
    else if ("shake_item_sound".equals(paramf))
    {
      bh.bCz();
      boolean bool2 = Util.nullAsTrue((Boolean)c.ban().d(4112, null));
      bh.bCz();
      paramPreference = c.ban();
      if (bool2) {
        break label711;
      }
      bool1 = true;
      label182:
      paramPreference.B(4112, Boolean.valueOf(bool1));
      paramPreference = com.tencent.mm.plugin.shake.a.PyM;
      if (!bool2) {
        break label717;
      }
    }
    label711:
    label717:
    for (int i = 55;; i = 54)
    {
      com.tencent.mm.plugin.shake.a.a(i, null);
      if ("say_hi_list_shake_title".equals(paramf))
      {
        paramPreference = new Intent(this, ShakeSayHiListUI.class);
        paramPreference.putExtra("IntentSayHiType", 1);
        paramPreference = new com.tencent.mm.hellhoundlib.b.a().cG(paramPreference);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramPreference.aYi(), "com/tencent/mm/plugin/shake/ui/ShakePersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramPreference.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/shake/ui/ShakePersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramPreference = com.tencent.mm.plugin.shake.a.PyM;
        com.tencent.mm.plugin.shake.a.a(56, null);
      }
      if ("shake_item_histoty_list".equals(paramf))
      {
        paramPreference = new Intent(this, ShakeItemListUI.class);
        paramPreference.putExtra("_key_show_type_", 100);
        paramPreference.putExtra("_key_title_", getString(R.l.gVy));
        paramPreference = new com.tencent.mm.hellhoundlib.b.a().cG(paramPreference);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramPreference.aYi(), "com/tencent/mm/plugin/shake/ui/ShakePersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramPreference.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/shake/ui/ShakePersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramPreference = com.tencent.mm.plugin.shake.a.PyM;
        com.tencent.mm.plugin.shake.a.a(57, null);
      }
      if ("shake_msg_list".equals(paramf))
      {
        paramf = new Intent(this, ShakeMsgListUI.class);
        paramf.putExtra("shake_msg_from", 2);
        paramf.putExtra("shake_msg_list_title", getString(R.l.gVT));
        paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/shake/ui/ShakePersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/shake/ui/ShakePersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramf = com.tencent.mm.plugin.shake.a.PyM;
        com.tencent.mm.plugin.shake.a.a(58, null);
      }
      AppMethodBeat.o(28443);
      return false;
      bh.bCz();
      if (!Util.nullAsTrue((Boolean)c.ban().d(4110, null)))
      {
        paramPreference = new com.tencent.mm.ui.widget.a.f(getContext(), 1, true);
        paramPreference.af(af.mU(getContext()).inflate(R.i.gnY, null), false);
        paramPreference.ageZ = true;
        paramPreference.Vtg = new ShakePersonalInfoUI..ExternalSyntheticLambda1(this);
        paramPreference.GAC = new ShakePersonalInfoUI..ExternalSyntheticLambda2(this);
        paramPreference.dDn();
        break;
      }
      t.d(this, 1, null);
      overridePendingTransition(R.a.push_up_in, R.a.anim_not_change);
      paramPreference = com.tencent.mm.plugin.shake.a.PyM;
      com.tencent.mm.plugin.shake.a.a(53, null);
      break;
      bool1 = false;
      break label182;
    }
  }
  
  public void onResume()
  {
    boolean bool = false;
    AppMethodBeat.i(28441);
    super.onResume();
    if (bh.baz()) {
      b.pFo.aDx();
    }
    if (this.screen.bAi("shake_item_shake_tv_list") == null)
    {
      Log.e("MicroMsg.mmui.MMPreference", "shake_tv_list preference is null");
      AppMethodBeat.o(28441);
      return;
    }
    if (Util.getInt(i.aRD().at("ShowConfig", "showShakeTV"), 0) == 1) {
      bool = true;
    }
    Log.d("MicroMsg.ConfigListDecoder", "isShowShakeTV : ".concat(String.valueOf(bool)));
    if ((!bool) && (!z.pCd)) {
      this.screen.eh("shake_item_shake_tv_list", true);
    }
    AppMethodBeat.o(28441);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakePersonalInfoUI
 * JD-Core Version:    0.7.0.1
 */