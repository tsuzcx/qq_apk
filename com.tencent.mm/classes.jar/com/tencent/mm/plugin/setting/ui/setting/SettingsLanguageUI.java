package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.model.bu.a;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.account.ui.LanguagePreference;
import com.tencent.mm.plugin.account.ui.LanguagePreference.a;
import com.tencent.mm.sdk.platformtools.LocaleGen;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatSomeFeatureSwitch;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.t.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SettingsLanguageUI
  extends MMPreference
{
  private static final String[] LOCALES = LocaleGen.LOCALES;
  private List<LanguagePreference.a> Dcg;
  private boolean Dch = false;
  private String languageCode;
  private f screen;
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void initView()
  {
    int j = 0;
    AppMethodBeat.i(74180);
    setMMTitle(2131765425);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(74175);
        SettingsLanguageUI.this.hideVKB();
        SettingsLanguageUI.this.finish();
        AppMethodBeat.o(74175);
        return true;
      }
    });
    addTextOptionMenu(0, getString(2131765424), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(74176);
        SettingsLanguageUI.a(SettingsLanguageUI.this, SettingsLanguageUI.a(SettingsLanguageUI.this), SettingsLanguageUI.b(SettingsLanguageUI.this));
        SettingsLanguageUI.this.finish();
        AppMethodBeat.o(74176);
        return true;
      }
    }, null, t.b.OGU);
    this.Dch = getIntent().getBooleanExtra("not_auth_setting", false);
    this.screen.removeAll();
    if (WeChatSomeFeatureSwitch.temporaryBlockMinorLanguage()) {}
    Object localObject2;
    Object localObject3;
    for (Object localObject1 = getResources().getStringArray(2130903057);; localObject1 = getResources().getStringArray(2130903056))
    {
      this.languageCode = LocaleUtil.loadApplicationLanguageSettings(getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), this);
      this.Dcg = new ArrayList();
      localObject2 = LOCALES;
      int i = j;
      if (WeChatSomeFeatureSwitch.temporaryBlockMinorLanguage())
      {
        localObject2 = LocaleGen.LOCALES_BLOCK_MINOR_LANG;
        i = j;
      }
      while (i < localObject2.length)
      {
        localObject3 = localObject2[i];
        this.Dcg.add(new LanguagePreference.a(localObject1[i], "", (String)localObject3, this.languageCode.equalsIgnoreCase((String)localObject3)));
        i += 1;
      }
    }
    localObject1 = this.Dcg.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (LanguagePreference.a)((Iterator)localObject1).next();
      localObject3 = new LanguagePreference(this);
      ((LanguagePreference)localObject3).a((LanguagePreference.a)localObject2);
      this.screen.c((Preference)localObject3);
    }
    localObject1 = new PreferenceCategory(this);
    this.screen.c((Preference)localObject1);
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(74180);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74178);
    super.onCreate(paramBundle);
    this.screen = getPreferenceScreen();
    initView();
    AppMethodBeat.o(74178);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74179);
    super.onDestroy();
    AppMethodBeat.o(74179);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74181);
    if ((paramPreference instanceof LanguagePreference))
    {
      paramPreference = ((LanguagePreference)paramPreference).kln;
      if (paramPreference == null)
      {
        AppMethodBeat.o(74181);
        return false;
      }
      this.languageCode = paramPreference.klq;
      Iterator localIterator = this.Dcg.iterator();
      while (localIterator.hasNext()) {
        ((LanguagePreference.a)localIterator.next()).isSelected = false;
      }
      paramPreference.isSelected = true;
      paramf.notifyDataSetChanged();
      AppMethodBeat.o(74181);
      return true;
    }
    AppMethodBeat.o(74181);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsLanguageUI
 * JD-Core Version:    0.7.0.1
 */