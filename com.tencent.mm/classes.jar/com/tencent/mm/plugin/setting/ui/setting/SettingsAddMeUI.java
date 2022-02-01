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
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.ao;
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
  private int Dbj;
  private HashMap<Integer, Integer> kbt;
  private long qAb;
  private f screen;
  private int status;
  
  public SettingsAddMeUI()
  {
    AppMethodBeat.i(74099);
    this.kbt = new HashMap();
    AppMethodBeat.o(74099);
  }
  
  private boolean UM(int paramInt)
  {
    return (this.status & paramInt) != 0;
  }
  
  private void i(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(74104);
    Log.d("MicroMsg.SettingsAddMeUI", "switch change : open = " + paramBoolean + " item value = " + paramInt1 + " functionId = " + paramInt2);
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
      this.kbt.put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
      AppMethodBeat.o(74104);
      return;
      this.status &= (paramInt1 ^ 0xFFFFFFFF);
      break;
    }
  }
  
  private void k(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(74105);
    Log.d("MicroMsg.SettingsAddMeUI", "switch ext change : open = " + paramBoolean + " item value = " + paramInt1 + " functionId = " + paramInt2);
    if (paramBoolean)
    {
      this.qAb |= paramInt1;
      if (!paramBoolean) {
        break label103;
      }
    }
    label103:
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      this.kbt.put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
      AppMethodBeat.o(74105);
      return;
      this.qAb &= (paramInt1 ^ 0xFFFFFFFF);
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
    return 2132017262;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74106);
    setMMTitle(2131765339);
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
    Log.d("MicroMsg.SettingsAddMeUI", "plug:" + this.Dbj + ",status:" + this.status + ",extstatus:" + this.qAb);
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(getResourceId());
    Object localObject1 = (Integer)g.aAh().azQ().get(9, null);
    Object localObject2 = (CheckBoxPreference)this.screen.bmg("settings_find_me_by_QQ");
    ((Preference)localObject2).OZw = false;
    boolean bool;
    if ((!WeChatBrands.Business.Entries.MeSetPrivacyAddByQQ.banned()) && (localObject1 != null) && (((Integer)localObject1).intValue() != 0)) {
      if ((!UM(8)) || (!UM(16)))
      {
        bool = true;
        ((CheckBoxPreference)localObject2).setChecked(bool);
        label174:
        localObject1 = (String)g.aAh().azQ().get(6, null);
        localObject2 = (CheckBoxPreference)this.screen.bmg("settings_find_me_by_mobile");
        ((Preference)localObject2).OZw = false;
        if ((localObject1 == null) || (((String)localObject1).length() <= 0)) {
          break label502;
        }
        if (UM(512)) {
          break label497;
        }
        bool = true;
        label233:
        ((CheckBoxPreference)localObject2).setChecked(bool);
        label238:
        localObject1 = (CheckBoxPreference)this.screen.bmg("settings_find_me_by_weixin");
        ((Preference)localObject1).OZw = false;
        if ((this.Dbj & 0x200) == 0) {
          break label516;
        }
        ((CheckBoxPreference)localObject1).setChecked(false);
        label274:
        localObject1 = (CheckBoxPreference)this.screen.bmg("settings_find_me_by_google");
        if (UM(524288)) {
          break label524;
        }
        bool = true;
        label300:
        ((CheckBoxPreference)localObject1).setChecked(bool);
        ((Preference)localObject1).OZw = false;
        localObject2 = (String)g.aAh().azQ().get(208903, null);
        if ((!Util.isOverseasUser(this)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
          this.screen.e((Preference)localObject1);
        }
        localObject1 = (CheckBoxPreference)this.screen.bmg("settings_add_me_by_chatroom");
        ((Preference)localObject1).OZw = false;
        if ((this.qAb & 1L) == 0L) {
          break label529;
        }
        ((CheckBoxPreference)localObject1).setChecked(false);
        label387:
        localObject1 = (CheckBoxPreference)this.screen.bmg("settings_add_me_by_qrcode");
        ((Preference)localObject1).OZw = false;
        if ((this.qAb & 0x2) == 0L) {
          break label537;
        }
        ((CheckBoxPreference)localObject1).setChecked(false);
        label425:
        localObject1 = (CheckBoxPreference)this.screen.bmg("settings_add_me_by_namecard");
        ((Preference)localObject1).OZw = false;
        if ((this.qAb & 0x4) == 0L) {
          break label545;
        }
        ((CheckBoxPreference)localObject1).setChecked(false);
      }
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(74106);
      return;
      bool = false;
      break;
      this.screen.e((Preference)localObject2);
      break label174;
      label497:
      bool = false;
      break label233;
      label502:
      this.screen.e((Preference)localObject2);
      break label238;
      label516:
      ((CheckBoxPreference)localObject1).setChecked(true);
      break label274;
      label524:
      bool = false;
      break label300;
      label529:
      ((CheckBoxPreference)localObject1).setChecked(true);
      break label387;
      label537:
      ((CheckBoxPreference)localObject1).setChecked(true);
      break label425;
      label545:
      ((CheckBoxPreference)localObject1).setChecked(true);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74101);
    super.onCreate(paramBundle);
    this.screen = getPreferenceScreen();
    this.Dbj = z.aUe();
    this.status = z.aUc();
    this.qAb = z.aUd();
    initView();
    AppMethodBeat.o(74101);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(74102);
    super.onPause();
    Log.d("MicroMsg.SettingsAddMeUI", "plug:" + this.Dbj + ",status:" + this.status + ",extstatus:" + this.qAb);
    g.aAh().azQ().set(7, Integer.valueOf(this.status));
    g.aAh().azQ().set(40, Integer.valueOf(this.Dbj));
    g.aAh().azQ().set(147457, Long.valueOf(this.qAb));
    Iterator localIterator = this.kbt.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      int i = ((Integer)((Map.Entry)localObject).getKey()).intValue();
      int j = ((Integer)((Map.Entry)localObject).getValue()).intValue();
      localObject = new bfx();
      ((bfx)localObject).LPB = i;
      ((bfx)localObject).BsD = j;
      ((l)g.af(l.class)).aSM().d(new k.a(23, (com.tencent.mm.bw.a)localObject));
      Log.d("MicroMsg.SettingsAddMeUI", "switch  " + i + " " + j);
    }
    this.kbt.clear();
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
    Log.i("MicroMsg.SettingsAddMeUI", paramPreference + " item has been clicked!");
    if (paramPreference.equals("settings_find_me_by_QQ"))
    {
      if (!((CheckBoxPreference)paramf.bmg("settings_find_me_by_QQ")).isChecked()) {}
      for (bool1 = true;; bool1 = false)
      {
        i(bool1, 8, 2);
        i(bool1, 16, 3);
        AppMethodBeat.o(74103);
        return true;
      }
    }
    if (paramPreference.equals("settings_find_me_by_weixin"))
    {
      if (!((CheckBoxPreference)paramf.bmg("settings_find_me_by_weixin")).isChecked()) {
        bool1 = true;
      }
      Log.d("MicroMsg.SettingsAddMeUI", "switch plug change : open = " + bool1 + " item value = 512 functionId = 25");
      if (bool1)
      {
        this.Dbj |= 0x200;
        if (!bool1) {
          break label237;
        }
      }
      label237:
      for (int i = 1;; i = 2)
      {
        this.kbt.put(Integer.valueOf(25), Integer.valueOf(i));
        AppMethodBeat.o(74103);
        return true;
        this.Dbj &= 0xFFFFFDFF;
        break;
      }
    }
    if (paramPreference.equals("settings_find_me_by_mobile"))
    {
      bool1 = bool2;
      if (!((CheckBoxPreference)paramf.bmg("settings_find_me_by_mobile")).isChecked()) {
        bool1 = true;
      }
      i(bool1, 512, 8);
      AppMethodBeat.o(74103);
      return true;
    }
    if (paramPreference.equals("settings_find_me_by_google"))
    {
      bool1 = bool3;
      if (!((CheckBoxPreference)paramf.bmg("settings_find_me_by_google")).isChecked()) {
        bool1 = true;
      }
      i(bool1, 524288, 30);
      AppMethodBeat.o(74103);
      return true;
    }
    if (paramPreference.equals("settings_add_me_by_chatroom"))
    {
      bool1 = bool4;
      if (!((CheckBoxPreference)paramf.bmg("settings_add_me_by_chatroom")).isChecked()) {
        bool1 = true;
      }
      k(bool1, 1, 38);
      AppMethodBeat.o(74103);
      return true;
    }
    if (paramPreference.equals("settings_add_me_by_qrcode"))
    {
      bool1 = bool5;
      if (!((CheckBoxPreference)paramf.bmg("settings_add_me_by_qrcode")).isChecked()) {
        bool1 = true;
      }
      k(bool1, 2, 39);
      AppMethodBeat.o(74103);
      return true;
    }
    if (paramPreference.equals("settings_add_me_by_namecard"))
    {
      bool1 = bool6;
      if (!((CheckBoxPreference)paramf.bmg("settings_add_me_by_namecard")).isChecked()) {
        bool1 = true;
      }
      k(bool1, 4, 40);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAddMeUI
 * JD-Core Version:    0.7.0.1
 */