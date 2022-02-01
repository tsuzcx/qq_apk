package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.amy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.preference.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class SettingsAddMeUI
  extends MMPreference
{
  private HashMap<Integer, Integer> ihg;
  private long nXu;
  private f screen;
  private int status;
  private int wgm;
  
  public SettingsAddMeUI()
  {
    AppMethodBeat.i(74099);
    this.ihg = new HashMap();
    AppMethodBeat.o(74099);
  }
  
  private boolean Js(int paramInt)
  {
    return (this.status & paramInt) != 0;
  }
  
  private void f(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(74104);
    ad.d("MicroMsg.SettingsAddMeUI", "switch change : open = " + paramBoolean + " item value = " + paramInt1 + " functionId = " + paramInt2);
    if (paramBoolean)
    {
      this.status |= paramInt1;
      if (!paramBoolean) {
        break label101;
      }
    }
    label101:
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      this.ihg.put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
      AppMethodBeat.o(74104);
      return;
      this.status &= (paramInt1 ^ 0xFFFFFFFF);
      break;
    }
  }
  
  private void h(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(74105);
    ad.d("MicroMsg.SettingsAddMeUI", "switch ext change : open = " + paramBoolean + " item value = " + paramInt1 + " functionId = " + paramInt2);
    if (paramBoolean)
    {
      this.nXu |= paramInt1;
      if (!paramBoolean) {
        break label103;
      }
    }
    label103:
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      this.ihg.put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
      AppMethodBeat.o(74105);
      return;
      this.nXu &= (paramInt1 ^ 0xFFFFFFFF);
      break;
    }
  }
  
  public h createAdapter(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(74100);
    paramSharedPreferences = new com.tencent.mm.ui.base.preference.a(this, getListView(), paramSharedPreferences);
    AppMethodBeat.o(74100);
    return paramSharedPreferences;
  }
  
  public int getResourceId()
  {
    return 2131951717;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74106);
    setMMTitle(2131763171);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(74098);
        SettingsAddMeUI.this.hideVKB();
        SettingsAddMeUI.this.finish();
        AppMethodBeat.o(74098);
        return true;
      }
    });
    ad.d("MicroMsg.SettingsAddMeUI", "plug:" + this.wgm + ",status:" + this.status + ",extstatus:" + this.nXu);
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(getResourceId());
    Object localObject1 = (Integer)g.afB().afk().get(9, null);
    Object localObject2 = (CheckBoxPreference)this.screen.aKk("settings_find_me_by_QQ");
    ((Preference)localObject2).GfV = false;
    boolean bool;
    if ((localObject1 != null) && (((Integer)localObject1).intValue() != 0)) {
      if ((!Js(8)) || (!Js(16)))
      {
        bool = true;
        ((CheckBoxPreference)localObject2).lG = bool;
        label165:
        localObject1 = (String)g.afB().afk().get(6, null);
        localObject2 = (CheckBoxPreference)this.screen.aKk("settings_find_me_by_mobile");
        ((Preference)localObject2).GfV = false;
        if ((localObject1 == null) || (((String)localObject1).length() <= 0)) {
          break label493;
        }
        if (Js(512)) {
          break label488;
        }
        bool = true;
        label224:
        ((CheckBoxPreference)localObject2).lG = bool;
        label229:
        localObject1 = (CheckBoxPreference)this.screen.aKk("settings_find_me_by_weixin");
        ((Preference)localObject1).GfV = false;
        if ((this.wgm & 0x200) == 0) {
          break label507;
        }
        ((CheckBoxPreference)localObject1).lG = false;
        label265:
        localObject1 = (CheckBoxPreference)this.screen.aKk("settings_find_me_by_google");
        if (Js(524288)) {
          break label515;
        }
        bool = true;
        label291:
        ((CheckBoxPreference)localObject1).lG = bool;
        ((Preference)localObject1).GfV = false;
        localObject2 = (String)g.afB().afk().get(208903, null);
        if ((!bt.iP(this)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
          this.screen.d((Preference)localObject1);
        }
        localObject1 = (CheckBoxPreference)this.screen.aKk("settings_add_me_by_chatroom");
        ((Preference)localObject1).GfV = false;
        if ((this.nXu & 1L) == 0L) {
          break label520;
        }
        ((CheckBoxPreference)localObject1).lG = false;
        label378:
        localObject1 = (CheckBoxPreference)this.screen.aKk("settings_add_me_by_qrcode");
        ((Preference)localObject1).GfV = false;
        if ((this.nXu & 0x2) == 0L) {
          break label528;
        }
        ((CheckBoxPreference)localObject1).lG = false;
        label416:
        localObject1 = (CheckBoxPreference)this.screen.aKk("settings_add_me_by_namecard");
        ((Preference)localObject1).GfV = false;
        if ((this.nXu & 0x4) == 0L) {
          break label536;
        }
      }
    }
    label515:
    label520:
    label528:
    label536:
    for (((CheckBoxPreference)localObject1).lG = false;; ((CheckBoxPreference)localObject1).lG = true)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(74106);
      return;
      bool = false;
      break;
      this.screen.d((Preference)localObject2);
      break label165;
      label488:
      bool = false;
      break label224;
      label493:
      this.screen.d((Preference)localObject2);
      break label229;
      label507:
      ((CheckBoxPreference)localObject1).lG = true;
      break label265;
      bool = false;
      break label291;
      ((CheckBoxPreference)localObject1).lG = true;
      break label378;
      ((CheckBoxPreference)localObject1).lG = true;
      break label416;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74101);
    super.onCreate(paramBundle);
    this.screen = getPreferenceScreen();
    this.wgm = u.aqM();
    this.status = u.aqK();
    this.nXu = u.aqL();
    initView();
    AppMethodBeat.o(74101);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(74102);
    super.onPause();
    ad.d("MicroMsg.SettingsAddMeUI", "plug:" + this.wgm + ",status:" + this.status + ",extstatus:" + this.nXu);
    g.afB().afk().set(7, Integer.valueOf(this.status));
    g.afB().afk().set(40, Integer.valueOf(this.wgm));
    g.afB().afk().set(147457, Long.valueOf(this.nXu));
    Iterator localIterator = this.ihg.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      int i = ((Integer)((Map.Entry)localObject).getKey()).intValue();
      int j = ((Integer)((Map.Entry)localObject).getValue()).intValue();
      localObject = new amy();
      ((amy)localObject).DnY = i;
      ((amy)localObject).uMR = j;
      ((k)g.ab(k.class)).apL().c(new j.a(23, (com.tencent.mm.bx.a)localObject));
      ad.d("MicroMsg.SettingsAddMeUI", "switch  " + i + " " + j);
    }
    this.ihg.clear();
    AppMethodBeat.o(74102);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool1 = false;
    AppMethodBeat.i(74103);
    paramPreference = paramPreference.mKey;
    ad.i("MicroMsg.SettingsAddMeUI", paramPreference + " item has been clicked!");
    if (paramPreference.equals("settings_find_me_by_QQ"))
    {
      if (!((CheckBoxPreference)paramf.aKk("settings_find_me_by_QQ")).isChecked()) {}
      for (bool1 = true;; bool1 = false)
      {
        f(bool1, 8, 2);
        f(bool1, 16, 3);
        AppMethodBeat.o(74103);
        return true;
      }
    }
    if (paramPreference.equals("settings_find_me_by_weixin"))
    {
      if (!((CheckBoxPreference)paramf.aKk("settings_find_me_by_weixin")).isChecked()) {
        bool1 = true;
      }
      ad.d("MicroMsg.SettingsAddMeUI", "switch plug change : open = " + bool1 + " item value = 512 functionId = 25");
      if (bool1)
      {
        this.wgm |= 0x200;
        if (!bool1) {
          break label237;
        }
      }
      label237:
      for (int i = 1;; i = 2)
      {
        this.ihg.put(Integer.valueOf(25), Integer.valueOf(i));
        AppMethodBeat.o(74103);
        return true;
        this.wgm &= 0xFFFFFDFF;
        break;
      }
    }
    if (paramPreference.equals("settings_find_me_by_mobile"))
    {
      bool1 = bool2;
      if (!((CheckBoxPreference)paramf.aKk("settings_find_me_by_mobile")).isChecked()) {
        bool1 = true;
      }
      f(bool1, 512, 8);
      AppMethodBeat.o(74103);
      return true;
    }
    if (paramPreference.equals("settings_find_me_by_google"))
    {
      bool1 = bool3;
      if (!((CheckBoxPreference)paramf.aKk("settings_find_me_by_google")).isChecked()) {
        bool1 = true;
      }
      f(bool1, 524288, 30);
      AppMethodBeat.o(74103);
      return true;
    }
    if (paramPreference.equals("settings_add_me_by_chatroom"))
    {
      bool1 = bool4;
      if (!((CheckBoxPreference)paramf.aKk("settings_add_me_by_chatroom")).isChecked()) {
        bool1 = true;
      }
      h(bool1, 1, 38);
      AppMethodBeat.o(74103);
      return true;
    }
    if (paramPreference.equals("settings_add_me_by_qrcode"))
    {
      bool1 = bool5;
      if (!((CheckBoxPreference)paramf.aKk("settings_add_me_by_qrcode")).isChecked()) {
        bool1 = true;
      }
      h(bool1, 2, 39);
      AppMethodBeat.o(74103);
      return true;
    }
    if (paramPreference.equals("settings_add_me_by_namecard"))
    {
      bool1 = bool6;
      if (!((CheckBoxPreference)paramf.aKk("settings_add_me_by_namecard")).isChecked()) {
        bool1 = true;
      }
      h(bool1, 4, 40);
      AppMethodBeat.o(74103);
      return true;
    }
    AppMethodBeat.o(74103);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAddMeUI
 * JD-Core Version:    0.7.0.1
 */