package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bn.a;
import com.tencent.mm.network.c;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.account.ui.LanguagePreference;
import com.tencent.mm.plugin.account.ui.LanguagePreference.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ai;
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
  private static final String[] xsv = aa.xsv;
  private String languageCode;
  private f screen;
  private List<LanguagePreference.a> xsw;
  private boolean xsx = false;
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void initView()
  {
    int i = 0;
    AppMethodBeat.i(74180);
    setMMTitle(2131763255);
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
    addTextOptionMenu(0, getString(2131763254), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(74176);
        SettingsLanguageUI.a(SettingsLanguageUI.this, SettingsLanguageUI.a(SettingsLanguageUI.this), SettingsLanguageUI.b(SettingsLanguageUI.this));
        SettingsLanguageUI.this.finish();
        AppMethodBeat.o(74176);
        return true;
      }
    }, null, s.b.Hom);
    this.xsx = getIntent().getBooleanExtra("not_auth_setting", false);
    this.screen.removeAll();
    Object localObject1 = getResources().getStringArray(2130903056);
    this.languageCode = ab.g(getSharedPreferences(ai.eUX(), 0));
    this.xsw = new ArrayList();
    Object localObject2;
    while (i < xsv.length)
    {
      localObject2 = xsv[i];
      this.xsw.add(new LanguagePreference.a(localObject1[i], "", (String)localObject2, this.languageCode.equalsIgnoreCase((String)localObject2)));
      i += 1;
    }
    localObject1 = this.xsw.iterator();
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
      paramPreference = ((LanguagePreference)paramPreference).iRd;
      if (paramPreference == null)
      {
        AppMethodBeat.o(74181);
        return false;
      }
      this.languageCode = paramPreference.iRg;
      Iterator localIterator = this.xsw.iterator();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsLanguageUI
 * JD-Core Version:    0.7.0.1
 */