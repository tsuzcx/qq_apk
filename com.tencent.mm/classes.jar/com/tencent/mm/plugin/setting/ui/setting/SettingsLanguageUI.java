package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.mm.plugin.account.ui.LanguagePreference;
import com.tencent.mm.plugin.account.ui.LanguagePreference.a;
import com.tencent.mm.plugin.setting.a.b;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.s.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SettingsLanguageUI
  extends MMPreference
{
  private static final String[] nUs = w.nUs;
  private f dnn;
  private String frp;
  private List<LanguagePreference.a> nUt;
  private boolean nUu = false;
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    if ((paramPreference instanceof LanguagePreference))
    {
      paramPreference = ((LanguagePreference)paramPreference).fmi;
      if (paramPreference == null) {
        return false;
      }
      this.frp = paramPreference.fml;
      Iterator localIterator = this.nUt.iterator();
      while (localIterator.hasNext()) {
        ((LanguagePreference.a)localIterator.next()).fmm = false;
      }
      paramPreference.fmm = true;
      paramf.notifyDataSetChanged();
      return true;
    }
    return false;
  }
  
  protected final void initView()
  {
    int i = 0;
    setMMTitle(a.i.settings_language_title);
    setBackBtn(new SettingsLanguageUI.1(this));
    a(0, getString(a.i.settings_language_save), new SettingsLanguageUI.2(this), s.b.uNx);
    this.nUu = getIntent().getBooleanExtra("not_auth_setting", false);
    this.dnn.removeAll();
    Object localObject1 = getResources().getStringArray(a.b.language_setting);
    this.frp = x.e(getSharedPreferences(ae.cqR(), 0));
    this.nUt = new ArrayList();
    Object localObject2;
    while (i < nUs.length)
    {
      localObject2 = nUs[i];
      this.nUt.add(new LanguagePreference.a(localObject1[i], "", (String)localObject2, this.frp.equalsIgnoreCase((String)localObject2)));
      i += 1;
    }
    localObject1 = this.nUt.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (LanguagePreference.a)((Iterator)localObject1).next();
      LanguagePreference localLanguagePreference = new LanguagePreference(this);
      localLanguagePreference.a((LanguagePreference.a)localObject2);
      this.dnn.a(localLanguagePreference);
    }
    localObject1 = new PreferenceCategory(this);
    this.dnn.a((Preference)localObject1);
    this.dnn.notifyDataSetChanged();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.dnn = this.vdd;
    initView();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  public final int xj()
  {
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsLanguageUI
 * JD-Core Version:    0.7.0.1
 */