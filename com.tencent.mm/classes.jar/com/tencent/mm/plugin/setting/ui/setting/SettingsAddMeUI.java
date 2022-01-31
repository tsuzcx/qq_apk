package com.tencent.mm.plugin.setting.ui.setting;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.a.k;
import com.tencent.mm.protocal.c.zr;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class SettingsAddMeUI
  extends MMPreference
{
  private f dnn;
  private HashMap<Integer, Integer> fcv = new HashMap();
  private long iKA;
  private int nTP;
  private int status;
  
  private void b(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    y.d("MicroMsg.SettingsAddMeUI", "switch change : open = " + paramBoolean + " item value = " + paramInt1 + " functionId = " + paramInt2);
    if (paramBoolean)
    {
      this.status |= paramInt1;
      if (!paramBoolean) {
        break label91;
      }
    }
    label91:
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      this.fcv.put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
      return;
      this.status &= (paramInt1 ^ 0xFFFFFFFF);
      break;
    }
  }
  
  private void c(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    y.d("MicroMsg.SettingsAddMeUI", "switch ext change : open = " + paramBoolean + " item value = " + paramInt1 + " functionId = " + paramInt2);
    if (paramBoolean)
    {
      this.iKA |= paramInt1;
      if (!paramBoolean) {
        break label93;
      }
    }
    label93:
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      this.fcv.put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
      return;
      this.iKA &= (paramInt1 ^ 0xFFFFFFFF);
      break;
    }
  }
  
  private boolean wb(int paramInt)
  {
    return (this.status & paramInt) != 0;
  }
  
  public final com.tencent.mm.ui.base.preference.h a(SharedPreferences paramSharedPreferences)
  {
    return new com.tencent.mm.ui.base.preference.a(this, paramSharedPreferences);
  }
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool1 = false;
    paramPreference = paramPreference.mKey;
    y.i("MicroMsg.SettingsAddMeUI", paramPreference + " item has been clicked!");
    if (paramPreference.equals("settings_find_me_by_QQ"))
    {
      if (!((CheckBoxPreference)paramf.add("settings_find_me_by_QQ")).isChecked()) {}
      for (bool1 = true;; bool1 = false)
      {
        b(bool1, 8, 2);
        b(bool1, 16, 3);
        return true;
      }
    }
    if (paramPreference.equals("settings_find_me_by_weixin"))
    {
      if (!((CheckBoxPreference)paramf.add("settings_find_me_by_weixin")).isChecked()) {
        bool1 = true;
      }
      y.d("MicroMsg.SettingsAddMeUI", "switch plug change : open = " + bool1 + " item value = 512 functionId = 25");
      if (bool1)
      {
        this.nTP |= 0x200;
        if (!bool1) {
          break label216;
        }
      }
      label216:
      for (int i = 1;; i = 2)
      {
        this.fcv.put(Integer.valueOf(25), Integer.valueOf(i));
        return true;
        this.nTP &= 0xFFFFFDFF;
        break;
      }
    }
    if (paramPreference.equals("settings_find_me_by_mobile"))
    {
      bool1 = bool2;
      if (!((CheckBoxPreference)paramf.add("settings_find_me_by_mobile")).isChecked()) {
        bool1 = true;
      }
      b(bool1, 512, 8);
      return true;
    }
    if (paramPreference.equals("settings_find_me_by_google"))
    {
      bool1 = bool3;
      if (!((CheckBoxPreference)paramf.add("settings_find_me_by_google")).isChecked()) {
        bool1 = true;
      }
      b(bool1, 524288, 30);
      return true;
    }
    if (paramPreference.equals("settings_add_me_by_chatroom"))
    {
      bool1 = bool4;
      if (!((CheckBoxPreference)paramf.add("settings_add_me_by_chatroom")).isChecked()) {
        bool1 = true;
      }
      c(bool1, 1, 38);
      return true;
    }
    if (paramPreference.equals("settings_add_me_by_qrcode"))
    {
      bool1 = bool5;
      if (!((CheckBoxPreference)paramf.add("settings_add_me_by_qrcode")).isChecked()) {
        bool1 = true;
      }
      c(bool1, 2, 39);
      return true;
    }
    if (paramPreference.equals("settings_add_me_by_namecard"))
    {
      bool1 = bool6;
      if (!((CheckBoxPreference)paramf.add("settings_add_me_by_namecard")).isChecked()) {
        bool1 = true;
      }
      c(bool1, 4, 40);
      return true;
    }
    return false;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.settings_add_me_way);
    setBackBtn(new SettingsAddMeUI.1(this));
    y.d("MicroMsg.SettingsAddMeUI", "plug:" + this.nTP + ",status:" + this.status + ",extstatus:" + this.iKA);
    this.dnn.removeAll();
    this.dnn.addPreferencesFromResource(a.k.settings_add_me);
    Object localObject1 = (Integer)g.DP().Dz().get(9, null);
    Object localObject2 = (CheckBoxPreference)this.dnn.add("settings_find_me_by_QQ");
    ((Preference)localObject2).vdK = false;
    boolean bool;
    if ((localObject1 != null) && (((Integer)localObject1).intValue() != 0)) {
      if ((!wb(8)) || (!wb(16)))
      {
        bool = true;
        ((CheckBoxPreference)localObject2).rHo = bool;
        label160:
        localObject1 = (String)g.DP().Dz().get(6, null);
        localObject2 = (CheckBoxPreference)this.dnn.add("settings_find_me_by_mobile");
        ((Preference)localObject2).vdK = false;
        if ((localObject1 == null) || (((String)localObject1).length() <= 0)) {
          break label483;
        }
        if (wb(512)) {
          break label478;
        }
        bool = true;
        label219:
        ((CheckBoxPreference)localObject2).rHo = bool;
        label224:
        localObject1 = (CheckBoxPreference)this.dnn.add("settings_find_me_by_weixin");
        ((Preference)localObject1).vdK = false;
        if ((this.nTP & 0x200) == 0) {
          break label497;
        }
        ((CheckBoxPreference)localObject1).rHo = false;
        label260:
        localObject1 = (CheckBoxPreference)this.dnn.add("settings_find_me_by_google");
        if (wb(524288)) {
          break label505;
        }
        bool = true;
        label286:
        ((CheckBoxPreference)localObject1).rHo = bool;
        ((Preference)localObject1).vdK = false;
        localObject2 = (String)g.DP().Dz().get(208903, null);
        if ((!bk.fV(this)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
          this.dnn.c((Preference)localObject1);
        }
        localObject1 = (CheckBoxPreference)this.dnn.add("settings_add_me_by_chatroom");
        ((Preference)localObject1).vdK = false;
        if ((this.iKA & 1L) == 0L) {
          break label510;
        }
        ((CheckBoxPreference)localObject1).rHo = false;
        label373:
        localObject1 = (CheckBoxPreference)this.dnn.add("settings_add_me_by_qrcode");
        ((Preference)localObject1).vdK = false;
        if ((this.iKA & 0x2) == 0L) {
          break label518;
        }
        ((CheckBoxPreference)localObject1).rHo = false;
        label411:
        localObject1 = (CheckBoxPreference)this.dnn.add("settings_add_me_by_namecard");
        ((Preference)localObject1).vdK = false;
        if ((this.iKA & 0x4) == 0L) {
          break label526;
        }
      }
    }
    label518:
    label526:
    for (((CheckBoxPreference)localObject1).rHo = false;; ((CheckBoxPreference)localObject1).rHo = true)
    {
      this.dnn.notifyDataSetChanged();
      return;
      bool = false;
      break;
      this.dnn.c((Preference)localObject2);
      break label160;
      label478:
      bool = false;
      break label219;
      label483:
      this.dnn.c((Preference)localObject2);
      break label224;
      label497:
      ((CheckBoxPreference)localObject1).rHo = true;
      break label260;
      label505:
      bool = false;
      break label286;
      label510:
      ((CheckBoxPreference)localObject1).rHo = true;
      break label373;
      ((CheckBoxPreference)localObject1).rHo = true;
      break label411;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.dnn = this.vdd;
    this.nTP = q.Gp();
    this.status = q.Gn();
    this.iKA = q.Go();
    initView();
  }
  
  public void onPause()
  {
    super.onPause();
    y.d("MicroMsg.SettingsAddMeUI", "plug:" + this.nTP + ",status:" + this.status + ",extstatus:" + this.iKA);
    g.DP().Dz().o(7, Integer.valueOf(this.status));
    g.DP().Dz().o(40, Integer.valueOf(this.nTP));
    g.DP().Dz().o(147457, Long.valueOf(this.iKA));
    Iterator localIterator = this.fcv.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      int i = ((Integer)((Map.Entry)localObject).getKey()).intValue();
      int j = ((Integer)((Map.Entry)localObject).getValue()).intValue();
      localObject = new zr();
      ((zr)localObject).sYS = i;
      ((zr)localObject).nfn = j;
      ((j)g.r(j.class)).Fv().b(new i.a(23, (com.tencent.mm.bv.a)localObject));
      y.d("MicroMsg.SettingsAddMeUI", "switch  " + i + " " + j);
    }
    this.fcv.clear();
  }
  
  public final int xj()
  {
    return a.k.settings_add_me;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAddMeUI
 * JD-Core Version:    0.7.0.1
 */