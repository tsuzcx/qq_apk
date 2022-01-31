package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.aek;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
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
  private HashMap<Integer, Integer> guf;
  private long kRf;
  private int qHP;
  private f screen;
  private int status;
  
  public SettingsAddMeUI()
  {
    AppMethodBeat.i(127169);
    this.guf = new HashMap();
    AppMethodBeat.o(127169);
  }
  
  private boolean BF(int paramInt)
  {
    return (this.status & paramInt) != 0;
  }
  
  private void f(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(127174);
    ab.d("MicroMsg.SettingsAddMeUI", "switch change : open = " + paramBoolean + " item value = " + paramInt1 + " functionId = " + paramInt2);
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
      this.guf.put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
      AppMethodBeat.o(127174);
      return;
      this.status &= (paramInt1 ^ 0xFFFFFFFF);
      break;
    }
  }
  
  private void g(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(127175);
    ab.d("MicroMsg.SettingsAddMeUI", "switch ext change : open = " + paramBoolean + " item value = " + paramInt1 + " functionId = " + paramInt2);
    if (paramBoolean)
    {
      this.kRf |= paramInt1;
      if (!paramBoolean) {
        break label103;
      }
    }
    label103:
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      this.guf.put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
      AppMethodBeat.o(127175);
      return;
      this.kRf &= (paramInt1 ^ 0xFFFFFFFF);
      break;
    }
  }
  
  public h createAdapter(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(127170);
    paramSharedPreferences = new com.tencent.mm.ui.base.preference.a(this, getListView(), paramSharedPreferences);
    AppMethodBeat.o(127170);
    return paramSharedPreferences;
  }
  
  public int getResourceId()
  {
    return 2131165273;
  }
  
  public void initView()
  {
    AppMethodBeat.i(127176);
    setMMTitle(2131303204);
    setBackBtn(new SettingsAddMeUI.1(this));
    ab.d("MicroMsg.SettingsAddMeUI", "plug:" + this.qHP + ",status:" + this.status + ",extstatus:" + this.kRf);
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(getResourceId());
    Object localObject1 = (Integer)g.RL().Ru().get(9, null);
    Object localObject2 = (CheckBoxPreference)this.screen.atx("settings_find_me_by_QQ");
    ((Preference)localObject2).zsk = false;
    boolean bool;
    if ((localObject1 != null) && (((Integer)localObject1).intValue() != 0)) {
      if ((!BF(8)) || (!BF(16)))
      {
        bool = true;
        ((CheckBoxPreference)localObject2).vxW = bool;
        label165:
        localObject1 = (String)g.RL().Ru().get(6, null);
        localObject2 = (CheckBoxPreference)this.screen.atx("settings_find_me_by_mobile");
        ((Preference)localObject2).zsk = false;
        if ((localObject1 == null) || (((String)localObject1).length() <= 0)) {
          break label493;
        }
        if (BF(512)) {
          break label488;
        }
        bool = true;
        label224:
        ((CheckBoxPreference)localObject2).vxW = bool;
        label229:
        localObject1 = (CheckBoxPreference)this.screen.atx("settings_find_me_by_weixin");
        ((Preference)localObject1).zsk = false;
        if ((this.qHP & 0x200) == 0) {
          break label507;
        }
        ((CheckBoxPreference)localObject1).vxW = false;
        label265:
        localObject1 = (CheckBoxPreference)this.screen.atx("settings_find_me_by_google");
        if (BF(524288)) {
          break label515;
        }
        bool = true;
        label291:
        ((CheckBoxPreference)localObject1).vxW = bool;
        ((Preference)localObject1).zsk = false;
        localObject2 = (String)g.RL().Ru().get(208903, null);
        if ((!bo.hl(this)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
          this.screen.d((Preference)localObject1);
        }
        localObject1 = (CheckBoxPreference)this.screen.atx("settings_add_me_by_chatroom");
        ((Preference)localObject1).zsk = false;
        if ((this.kRf & 1L) == 0L) {
          break label520;
        }
        ((CheckBoxPreference)localObject1).vxW = false;
        label378:
        localObject1 = (CheckBoxPreference)this.screen.atx("settings_add_me_by_qrcode");
        ((Preference)localObject1).zsk = false;
        if ((this.kRf & 0x2) == 0L) {
          break label528;
        }
        ((CheckBoxPreference)localObject1).vxW = false;
        label416:
        localObject1 = (CheckBoxPreference)this.screen.atx("settings_add_me_by_namecard");
        ((Preference)localObject1).zsk = false;
        if ((this.kRf & 0x4) == 0L) {
          break label536;
        }
      }
    }
    label515:
    label520:
    label528:
    label536:
    for (((CheckBoxPreference)localObject1).vxW = false;; ((CheckBoxPreference)localObject1).vxW = true)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(127176);
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
      ((CheckBoxPreference)localObject1).vxW = true;
      break label265;
      bool = false;
      break label291;
      ((CheckBoxPreference)localObject1).vxW = true;
      break label378;
      ((CheckBoxPreference)localObject1).vxW = true;
      break label416;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127171);
    super.onCreate(paramBundle);
    this.screen = getPreferenceScreen();
    this.qHP = r.Zt();
    this.status = r.Zr();
    this.kRf = r.Zs();
    initView();
    AppMethodBeat.o(127171);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(127172);
    super.onPause();
    ab.d("MicroMsg.SettingsAddMeUI", "plug:" + this.qHP + ",status:" + this.status + ",extstatus:" + this.kRf);
    g.RL().Ru().set(7, Integer.valueOf(this.status));
    g.RL().Ru().set(40, Integer.valueOf(this.qHP));
    g.RL().Ru().set(147457, Long.valueOf(this.kRf));
    Iterator localIterator = this.guf.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      int i = ((Integer)((Map.Entry)localObject).getKey()).intValue();
      int j = ((Integer)((Map.Entry)localObject).getValue()).intValue();
      localObject = new aek();
      ((aek)localObject).wXn = i;
      ((aek)localObject).pKC = j;
      ((j)g.E(j.class)).Yz().c(new j.a(23, (com.tencent.mm.bv.a)localObject));
      ab.d("MicroMsg.SettingsAddMeUI", "switch  " + i + " " + j);
    }
    this.guf.clear();
    AppMethodBeat.o(127172);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool1 = false;
    AppMethodBeat.i(127173);
    paramPreference = paramPreference.mKey;
    ab.i("MicroMsg.SettingsAddMeUI", paramPreference + " item has been clicked!");
    if (paramPreference.equals("settings_find_me_by_QQ"))
    {
      if (!((CheckBoxPreference)paramf.atx("settings_find_me_by_QQ")).isChecked()) {}
      for (bool1 = true;; bool1 = false)
      {
        f(bool1, 8, 2);
        f(bool1, 16, 3);
        AppMethodBeat.o(127173);
        return true;
      }
    }
    if (paramPreference.equals("settings_find_me_by_weixin"))
    {
      if (!((CheckBoxPreference)paramf.atx("settings_find_me_by_weixin")).isChecked()) {
        bool1 = true;
      }
      ab.d("MicroMsg.SettingsAddMeUI", "switch plug change : open = " + bool1 + " item value = 512 functionId = 25");
      if (bool1)
      {
        this.qHP |= 0x200;
        if (!bool1) {
          break label237;
        }
      }
      label237:
      for (int i = 1;; i = 2)
      {
        this.guf.put(Integer.valueOf(25), Integer.valueOf(i));
        AppMethodBeat.o(127173);
        return true;
        this.qHP &= 0xFFFFFDFF;
        break;
      }
    }
    if (paramPreference.equals("settings_find_me_by_mobile"))
    {
      bool1 = bool2;
      if (!((CheckBoxPreference)paramf.atx("settings_find_me_by_mobile")).isChecked()) {
        bool1 = true;
      }
      f(bool1, 512, 8);
      AppMethodBeat.o(127173);
      return true;
    }
    if (paramPreference.equals("settings_find_me_by_google"))
    {
      bool1 = bool3;
      if (!((CheckBoxPreference)paramf.atx("settings_find_me_by_google")).isChecked()) {
        bool1 = true;
      }
      f(bool1, 524288, 30);
      AppMethodBeat.o(127173);
      return true;
    }
    if (paramPreference.equals("settings_add_me_by_chatroom"))
    {
      bool1 = bool4;
      if (!((CheckBoxPreference)paramf.atx("settings_add_me_by_chatroom")).isChecked()) {
        bool1 = true;
      }
      g(bool1, 1, 38);
      AppMethodBeat.o(127173);
      return true;
    }
    if (paramPreference.equals("settings_add_me_by_qrcode"))
    {
      bool1 = bool5;
      if (!((CheckBoxPreference)paramf.atx("settings_add_me_by_qrcode")).isChecked()) {
        bool1 = true;
      }
      g(bool1, 2, 39);
      AppMethodBeat.o(127173);
      return true;
    }
    if (paramPreference.equals("settings_add_me_by_namecard"))
    {
      bool1 = bool6;
      if (!((CheckBoxPreference)paramf.atx("settings_add_me_by_namecard")).isChecked()) {
        bool1 = true;
      }
      g(bool1, 4, 40);
      AppMethodBeat.o(127173);
      return true;
    }
    AppMethodBeat.o(127173);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAddMeUI
 * JD-Core Version:    0.7.0.1
 */