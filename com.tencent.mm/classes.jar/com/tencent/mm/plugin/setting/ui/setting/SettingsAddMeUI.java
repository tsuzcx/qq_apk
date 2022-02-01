package com.tencent.mm.plugin.setting.ui.setting;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.b.k;
import com.tencent.mm.protocal.protobuf.cas;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class SettingsAddMeUI
  extends MMPreference
{
  private int PrC;
  private HashMap<Integer, Integer> pPy;
  private com.tencent.mm.ui.base.preference.f screen;
  private int status;
  private long xct;
  
  public SettingsAddMeUI()
  {
    AppMethodBeat.i(74099);
    this.pPy = new HashMap();
    AppMethodBeat.o(74099);
  }
  
  private boolean afN(int paramInt)
  {
    return (this.status & paramInt) != 0;
  }
  
  private void p(boolean paramBoolean, int paramInt1, int paramInt2)
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
      this.pPy.put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
      AppMethodBeat.o(74104);
      return;
      this.status &= (paramInt1 ^ 0xFFFFFFFF);
      break;
    }
  }
  
  private void r(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(74105);
    Log.d("MicroMsg.SettingsAddMeUI", "switch ext change : open = " + paramBoolean + " item value = " + paramInt1 + " functionId = " + paramInt2);
    if (paramBoolean)
    {
      this.xct |= paramInt1;
      if (!paramBoolean) {
        break label103;
      }
    }
    label103:
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      this.pPy.put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
      AppMethodBeat.o(74105);
      return;
      this.xct &= (paramInt1 ^ 0xFFFFFFFF);
      break;
    }
  }
  
  public com.tencent.mm.ui.base.preference.h createAdapter(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(74100);
    paramSharedPreferences = new com.tencent.mm.ui.base.preference.a(this, getListView(), paramSharedPreferences);
    AppMethodBeat.o(74100);
    return paramSharedPreferences;
  }
  
  public int getResourceId()
  {
    return b.k.settings_add_me;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74106);
    setMMTitle(b.i.settings_add_me_way);
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
    Log.d("MicroMsg.SettingsAddMeUI", "plug:" + this.PrC + ",status:" + this.status + ",extstatus:" + this.xct);
    this.screen.removeAll();
    this.screen.aBe(getResourceId());
    Object localObject1 = (Integer)com.tencent.mm.kernel.h.baE().ban().d(9, null);
    Object localObject2 = (CheckBoxPreference)this.screen.bAi("settings_find_me_by_QQ");
    ((Preference)localObject2).adZV = false;
    boolean bool;
    if ((!WeChatBrands.Business.Entries.MeSetPrivacyAddByQQ.banned()) && (localObject1 != null) && (((Integer)localObject1).intValue() != 0)) {
      if ((!afN(8)) || (!afN(16)))
      {
        bool = true;
        ((CheckBoxPreference)localObject2).setChecked(bool);
        label175:
        localObject1 = (String)com.tencent.mm.kernel.h.baE().ban().d(6, null);
        localObject2 = (CheckBoxPreference)this.screen.bAi("settings_find_me_by_mobile");
        ((Preference)localObject2).adZV = false;
        if ((localObject1 == null) || (((String)localObject1).length() <= 0)) {
          break label503;
        }
        if (afN(512)) {
          break label498;
        }
        bool = true;
        label234:
        ((CheckBoxPreference)localObject2).setChecked(bool);
        label239:
        localObject1 = (CheckBoxPreference)this.screen.bAi("settings_find_me_by_weixin");
        ((Preference)localObject1).adZV = false;
        if ((this.PrC & 0x200) == 0) {
          break label517;
        }
        ((CheckBoxPreference)localObject1).setChecked(false);
        label275:
        localObject1 = (CheckBoxPreference)this.screen.bAi("settings_find_me_by_google");
        if (afN(524288)) {
          break label525;
        }
        bool = true;
        label301:
        ((CheckBoxPreference)localObject1).setChecked(bool);
        ((Preference)localObject1).adZV = false;
        localObject2 = (String)com.tencent.mm.kernel.h.baE().ban().d(208903, null);
        if ((!Util.isOverseasUser(this)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
          this.screen.e((Preference)localObject1);
        }
        localObject1 = (CheckBoxPreference)this.screen.bAi("settings_add_me_by_chatroom");
        ((Preference)localObject1).adZV = false;
        if ((this.xct & 1L) == 0L) {
          break label530;
        }
        ((CheckBoxPreference)localObject1).setChecked(false);
        label388:
        localObject1 = (CheckBoxPreference)this.screen.bAi("settings_add_me_by_qrcode");
        ((Preference)localObject1).adZV = false;
        if ((this.xct & 0x2) == 0L) {
          break label538;
        }
        ((CheckBoxPreference)localObject1).setChecked(false);
        label426:
        localObject1 = (CheckBoxPreference)this.screen.bAi("settings_add_me_by_namecard");
        ((Preference)localObject1).adZV = false;
        if ((this.xct & 0x4) == 0L) {
          break label546;
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
      break label175;
      label498:
      bool = false;
      break label234;
      label503:
      this.screen.e((Preference)localObject2);
      break label239;
      label517:
      ((CheckBoxPreference)localObject1).setChecked(true);
      break label275;
      label525:
      bool = false;
      break label301;
      label530:
      ((CheckBoxPreference)localObject1).setChecked(true);
      break label388;
      label538:
      ((CheckBoxPreference)localObject1).setChecked(true);
      break label426;
      label546:
      ((CheckBoxPreference)localObject1).setChecked(true);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74101);
    super.onCreate(paramBundle);
    this.screen = getPreferenceScreen();
    this.PrC = z.bAU();
    this.status = z.bAQ();
    this.xct = z.bAR();
    initView();
    AppMethodBeat.o(74101);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(74102);
    super.onPause();
    Log.d("MicroMsg.SettingsAddMeUI", "plug:" + this.PrC + ",status:" + this.status + ",extstatus:" + this.xct);
    com.tencent.mm.kernel.h.baE().ban().B(7, Integer.valueOf(this.status));
    com.tencent.mm.kernel.h.baE().ban().B(40, Integer.valueOf(this.PrC));
    com.tencent.mm.kernel.h.baE().ban().B(147457, Long.valueOf(this.xct));
    Iterator localIterator = this.pPy.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      int i = ((Integer)((Map.Entry)localObject).getKey()).intValue();
      int j = ((Integer)((Map.Entry)localObject).getValue()).intValue();
      localObject = new cas();
      ((cas)localObject).aajJ = i;
      ((cas)localObject).NkL = j;
      ((n)com.tencent.mm.kernel.h.ax(n.class)).bzz().d(new k.a(23, (com.tencent.mm.bx.a)localObject));
      Log.d("MicroMsg.SettingsAddMeUI", "switch  " + i + " " + j);
    }
    this.pPy.clear();
    AppMethodBeat.o(74102);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
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
      if (!((CheckBoxPreference)paramf.bAi("settings_find_me_by_QQ")).isChecked()) {}
      for (bool1 = true;; bool1 = false)
      {
        p(bool1, 8, 2);
        p(bool1, 16, 3);
        AppMethodBeat.o(74103);
        return true;
      }
    }
    if (paramPreference.equals("settings_find_me_by_weixin"))
    {
      if (!((CheckBoxPreference)paramf.bAi("settings_find_me_by_weixin")).isChecked()) {
        bool1 = true;
      }
      Log.d("MicroMsg.SettingsAddMeUI", "switch plug change : open = " + bool1 + " item value = 512 functionId = 25");
      if (bool1)
      {
        this.PrC |= 0x200;
        if (!bool1) {
          break label237;
        }
      }
      label237:
      for (int i = 1;; i = 2)
      {
        this.pPy.put(Integer.valueOf(25), Integer.valueOf(i));
        AppMethodBeat.o(74103);
        return true;
        this.PrC &= 0xFFFFFDFF;
        break;
      }
    }
    if (paramPreference.equals("settings_find_me_by_mobile"))
    {
      bool1 = bool2;
      if (!((CheckBoxPreference)paramf.bAi("settings_find_me_by_mobile")).isChecked()) {
        bool1 = true;
      }
      p(bool1, 512, 8);
      AppMethodBeat.o(74103);
      return true;
    }
    if (paramPreference.equals("settings_find_me_by_google"))
    {
      bool1 = bool3;
      if (!((CheckBoxPreference)paramf.bAi("settings_find_me_by_google")).isChecked()) {
        bool1 = true;
      }
      p(bool1, 524288, 30);
      AppMethodBeat.o(74103);
      return true;
    }
    if (paramPreference.equals("settings_add_me_by_chatroom"))
    {
      bool1 = bool4;
      if (!((CheckBoxPreference)paramf.bAi("settings_add_me_by_chatroom")).isChecked()) {
        bool1 = true;
      }
      r(bool1, 1, 38);
      AppMethodBeat.o(74103);
      return true;
    }
    if (paramPreference.equals("settings_add_me_by_qrcode"))
    {
      bool1 = bool5;
      if (!((CheckBoxPreference)paramf.bAi("settings_add_me_by_qrcode")).isChecked()) {
        bool1 = true;
      }
      r(bool1, 2, 39);
      AppMethodBeat.o(74103);
      return true;
    }
    if (paramPreference.equals("settings_add_me_by_namecard"))
    {
      bool1 = bool6;
      if (!((CheckBoxPreference)paramf.bAi("settings_add_me_by_namecard")).isChecked()) {
        bool1 = true;
      }
      r(bool1, 4, 40);
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