package com.tencent.mm.plugin.websearch.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.i.f.a;
import com.tencent.mm.protocal.protobuf.ahq;
import com.tencent.mm.protocal.protobuf.ahr;
import com.tencent.mm.protocal.protobuf.ahs;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.util.c;
import d.g.b.p;
import d.l;
import d.n.n;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/websearch/ui/WebSearchExptSubSettingUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "getResourceId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "plugin-websearch_release"})
public final class WebSearchExptSubSettingUI
  extends MMPreference
{
  public final int getResourceId()
  {
    return 2131951766;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(220005);
    super.onCreate(paramBundle);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    String str = getIntent().getStringExtra("groupKey");
    paramBundle = c.LgD;
    paramBundle = c.fNH().Gfg;
    p.g(paramBundle, "ExptSettingLogic.exptSettingConfig.groups");
    Object localObject1 = ((Iterable)paramBundle).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      paramBundle = ((Iterator)localObject1).next();
      if (p.i(((ahr)paramBundle).key, str))
      {
        paramBundle = (ahr)paramBundle;
        if (paramBundle == null) {
          break label283;
        }
        setMMTitle(paramBundle.title);
        paramBundle = paramBundle.hDb;
        p.g(paramBundle, "group.items");
        paramBundle = ((Iterable)paramBundle).iterator();
        label133:
        if (!paramBundle.hasNext()) {
          break label277;
        }
        Object localObject2 = (ahs)paramBundle.next();
        localObject1 = new CheckBoxPreference((Context)this);
        Object localObject3 = c.LgD;
        p.g(str, "groupKey");
        localObject3 = ((ahs)localObject2).key;
        p.g(localObject3, "item.key");
        ((CheckBoxPreference)localObject1).setKey(c.ms(str, (String)localObject3));
        ((CheckBoxPreference)localObject1).setTitle((CharSequence)((ahs)localObject2).title);
        localObject2 = c.LgD;
        localObject2 = ((CheckBoxPreference)localObject1).getKey();
        p.g(localObject2, "key");
        if (c.aXU((String)localObject2) <= 0) {
          break label272;
        }
      }
    }
    label272:
    for (boolean bool = true;; bool = false)
    {
      ((CheckBoxPreference)localObject1).setChecked(bool);
      getPreferenceScreen().b((Preference)localObject1);
      break label133;
      paramBundle = null;
      break;
    }
    label277:
    AppMethodBeat.o(220005);
    return;
    label283:
    ((WebSearchExptSubSettingUI)this).finish();
    AppMethodBeat.o(220005);
  }
  
  public final boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(220006);
    int i;
    if ((paramPreference != null) && ((paramPreference instanceof CheckBoxPreference)))
    {
      paramf = c.LgD;
      paramf = ((CheckBoxPreference)paramPreference).getKey();
      p.g(paramf, "it.key");
      boolean bool = ((CheckBoxPreference)paramPreference).isChecked();
      p.h(paramf, "key");
      if (!bool) {
        break label320;
      }
      ((Map)c.LgC).put(paramf, Integer.valueOf(1));
      c.fNI();
      p.h(paramf, "key");
      paramPreference = n.a((CharSequence)paramf, new String[] { "-" });
      if (paramPreference.size() != 2) {
        break label340;
      }
      i = 1;
      label109:
      if (i == 0) {
        break label345;
      }
      paramf = paramPreference;
      label115:
      if (paramf == null) {
        break label370;
      }
      paramf = c.LgB.Gfg;
      p.g(paramf, "exptSettingConfig.groups");
      Iterator localIterator = ((Iterable)paramf).iterator();
      while (localIterator.hasNext())
      {
        paramf = localIterator.next();
        if (p.i(((ahr)paramf).key, (String)paramPreference.get(0)))
        {
          label184:
          paramf = (ahr)paramf;
          if (paramf == null) {
            break label360;
          }
          paramf = paramf.hDb;
          if (paramf == null) {
            break label360;
          }
          localIterator = ((Iterable)paramf).iterator();
          while (localIterator.hasNext())
          {
            paramf = localIterator.next();
            if (p.i(((ahs)paramf).key, (String)paramPreference.get(1)))
            {
              label254:
              paramf = (ahs)paramf;
              if (paramf == null) {
                break label360;
              }
              i = paramf.Gfh;
              label268:
              if (i != 1) {
                break label365;
              }
              i = 1;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        paramf = g.ajC();
        p.g(paramf, "MMKernel.storage()");
        paramf.ajl().fqc();
        if (com.tencent.mm.pluginsdk.i.f.fat() != null) {
          com.tencent.mm.pluginsdk.i.f.fat().by(aj.getContext());
        }
      }
      AppMethodBeat.o(220006);
      return true;
      label320:
      ((Map)c.LgC).put(paramf, Integer.valueOf(0));
      break;
      label340:
      i = 0;
      break label109;
      label345:
      paramf = null;
      break label115;
      paramf = null;
      break label184;
      paramf = null;
      break label254;
      label360:
      i = 0;
      break label268;
      label365:
      i = 0;
      continue;
      label370:
      i = 0;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(WebSearchExptSubSettingUI paramWebSearchExptSubSettingUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(220004);
      this.DDl.finish();
      AppMethodBeat.o(220004);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.ui.WebSearchExptSubSettingUI
 * JD-Core Version:    0.7.0.1
 */