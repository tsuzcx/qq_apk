package com.tencent.mm.plugin.websearch.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.i.c.a;
import com.tencent.mm.protocal.protobuf.akm;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.ako;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/websearch/ui/WebSearchExptSubSettingUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "getResourceId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "plugin-websearch_release"})
public final class WebSearchExptSubSettingUI
  extends MMPreference
{
  public final int getResourceId()
  {
    return 2132017312;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(201739);
    super.onCreate(paramBundle);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    String str = getIntent().getStringExtra("groupKey");
    paramBundle = com.tencent.mm.util.c.QYz;
    paramBundle = com.tencent.mm.util.c.hda().Ltx;
    p.g(paramBundle, "ExptSettingLogic.exptSettingConfig.groups");
    Object localObject1 = ((Iterable)paramBundle).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      paramBundle = ((Iterator)localObject1).next();
      if (p.j(((akn)paramBundle).key, str))
      {
        paramBundle = (akn)paramBundle;
        if (paramBundle == null) {
          break label364;
        }
        setMMTitle(paramBundle.title);
        paramBundle = paramBundle.iAd;
        p.g(paramBundle, "group.items");
        paramBundle = ((Iterable)paramBundle).iterator();
      }
    }
    for (;;)
    {
      if (!paramBundle.hasNext()) {
        break label358;
      }
      localObject1 = (ako)paramBundle.next();
      Object localObject2;
      Object localObject3;
      switch (((ako)localObject1).type)
      {
      default: 
        localObject2 = new CheckBoxPreference((Context)this);
        localObject3 = com.tencent.mm.util.c.QYz;
        p.g(str, "groupKey");
        localObject3 = ((ako)localObject1).key;
        p.g(localObject3, "item.key");
        ((CheckBoxPreference)localObject2).setKey(com.tencent.mm.util.c.np(str, (String)localObject3));
        ((CheckBoxPreference)localObject2).setTitle((CharSequence)((ako)localObject1).title);
        localObject1 = com.tencent.mm.util.c.QYz;
        localObject1 = ((CheckBoxPreference)localObject2).getKey();
        p.g(localObject1, "key");
        ((CheckBoxPreference)localObject2).setChecked(p.j("1", com.tencent.mm.util.c.axY((String)localObject1)));
        getPreferenceScreen().c((Preference)localObject2);
        continue;
        paramBundle = null;
        break;
      case 1: 
        localObject2 = new Preference((Context)this);
        localObject3 = com.tencent.mm.util.c.QYz;
        p.g(str, "groupKey");
        localObject3 = ((ako)localObject1).key;
        p.g(localObject3, "item.key");
        ((Preference)localObject2).setKey(com.tencent.mm.util.c.np(str, (String)localObject3));
        ((Preference)localObject2).setTitle((CharSequence)((ako)localObject1).title);
        getPreferenceScreen().c((Preference)localObject2);
      }
    }
    label358:
    AppMethodBeat.o(201739);
    return;
    label364:
    ((WebSearchExptSubSettingUI)this).finish();
    AppMethodBeat.o(201739);
  }
  
  public final boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(201740);
    if (paramPreference != null)
    {
      if (!(paramPreference instanceof CheckBoxPreference)) {
        break label85;
      }
      paramf = com.tencent.mm.util.c.QYz;
      String str = ((CheckBoxPreference)paramPreference).getKey();
      p.g(str, "it.key");
      if (!((CheckBoxPreference)paramPreference).isChecked()) {
        break label79;
      }
      paramf = "1";
      if ((com.tencent.mm.util.c.nq(str, paramf)) && (com.tencent.mm.pluginsdk.i.c.gnr() != null)) {
        com.tencent.mm.pluginsdk.i.c.gnr().bV(MMApplicationContext.getContext());
      }
    }
    for (;;)
    {
      AppMethodBeat.o(201740);
      return true;
      label79:
      paramf = "0";
      break;
      label85:
      paramf = new Intent((Context)this, WebSearchExptSubValueSettingUI.class);
      paramf.putExtra("valueKey", paramPreference.getKey());
      paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/plugin/websearch/ui/WebSearchExptSubSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/websearch/ui/WebSearchExptSubSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(WebSearchExptSubSettingUI paramWebSearchExptSubSettingUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(201738);
      this.IGE.finish();
      AppMethodBeat.o(201738);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.ui.WebSearchExptSubSettingUI
 * JD-Core Version:    0.7.0.1
 */