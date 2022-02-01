package com.tencent.mm.plugin.websearch.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aia;
import com.tencent.mm.protocal.protobuf.aib;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.util.c;
import d.g.b.p;
import d.l;
import java.util.Iterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/websearch/ui/WebSearchExptSettingUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "getResourceId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "plugin-websearch_release"})
public final class WebSearchExptSettingUI
  extends MMPreference
{
  public final int getResourceId()
  {
    return 2131951766;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(116565);
    super.onCreate(paramBundle);
    setMMTitle(2131758652);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    paramBundle = c.LDf;
    paramBundle = c.fSc().GxO;
    p.g(paramBundle, "ExptSettingLogic.exptSettingConfig.groups");
    paramBundle = ((Iterable)paramBundle).iterator();
    while (paramBundle.hasNext())
    {
      aib localaib = (aib)paramBundle.next();
      Preference localPreference = new Preference((Context)this);
      localPreference.setKey(localaib.key);
      localPreference.setTitle((CharSequence)localaib.title);
      getPreferenceScreen().b(localPreference);
    }
    AppMethodBeat.o(116565);
  }
  
  public final boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(116566);
    if (paramPreference != null)
    {
      paramf = new Intent((Context)this, WebSearchExptSubSettingUI.class);
      paramf.putExtra("groupKey", paramPreference.getKey());
      paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/plugin/websearch/ui/WebSearchExptSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/websearch/ui/WebSearchExptSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(116566);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(WebSearchExptSettingUI paramWebSearchExptSettingUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(209746);
      this.DVi.finish();
      AppMethodBeat.o(209746);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.ui.WebSearchExptSettingUI
 * JD-Core Version:    0.7.0.1
 */