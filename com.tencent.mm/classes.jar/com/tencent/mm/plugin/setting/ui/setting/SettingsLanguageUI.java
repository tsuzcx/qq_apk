package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.ui.LanguagePreference;
import com.tencent.mm.plugin.account.ui.LanguagePreference.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.q.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SettingsLanguageUI
  extends MMPreference
{
  private static final String[] qIy = z.qIy;
  private String gIR;
  private boolean qIA = false;
  private List<LanguagePreference.a> qIz;
  private f screen;
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void initView()
  {
    int i = 0;
    AppMethodBeat.i(127243);
    setMMTitle(2131303286);
    setBackBtn(new SettingsLanguageUI.1(this));
    addTextOptionMenu(0, getString(2131303285), new SettingsLanguageUI.2(this), null, q.b.zby);
    this.qIA = getIntent().getBooleanExtra("not_auth_setting", false);
    this.screen.removeAll();
    Object localObject1 = getResources().getStringArray(2131755024);
    this.gIR = aa.g(getSharedPreferences(ah.dsP(), 0));
    this.qIz = new ArrayList();
    Object localObject2;
    while (i < qIy.length)
    {
      localObject2 = qIy[i];
      this.qIz.add(new LanguagePreference.a(localObject1[i], "", (String)localObject2, this.gIR.equalsIgnoreCase((String)localObject2)));
      i += 1;
    }
    localObject1 = this.qIz.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (LanguagePreference.a)((Iterator)localObject1).next();
      LanguagePreference localLanguagePreference = new LanguagePreference(this);
      localLanguagePreference.a((LanguagePreference.a)localObject2);
      this.screen.b(localLanguagePreference);
    }
    localObject1 = new PreferenceCategory(this);
    this.screen.b((Preference)localObject1);
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(127243);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127240);
    super.onCreate(paramBundle);
    this.screen = getPreferenceScreen();
    initView();
    AppMethodBeat.o(127240);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(127241);
    super.onDestroy();
    AppMethodBeat.o(127241);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(127244);
    if ((paramPreference instanceof LanguagePreference))
    {
      paramPreference = ((LanguagePreference)paramPreference).gDC;
      if (paramPreference == null)
      {
        AppMethodBeat.o(127244);
        return false;
      }
      this.gIR = paramPreference.gDF;
      Iterator localIterator = this.qIz.iterator();
      while (localIterator.hasNext()) {
        ((LanguagePreference.a)localIterator.next()).gDG = false;
      }
      paramPreference.gDG = true;
      paramf.notifyDataSetChanged();
      AppMethodBeat.o(127244);
      return true;
    }
    AppMethodBeat.o(127244);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsLanguageUI
 * JD-Core Version:    0.7.0.1
 */