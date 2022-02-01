package com.tencent.mm.plugin.ringtone.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ringtone.PluginRingtone;
import com.tencent.mm.plugin.ringtone.PluginRingtone.a;
import com.tencent.mm.plugin.ringtone.b.a;
import com.tencent.mm.plugin.ringtone.b.d;
import com.tencent.mm.plugin.ringtone.b.f;
import com.tencent.mm.plugin.ringtone.b.a.a;
import com.tencent.mm.plugin.ringtone.uic.BaseRingtoneUI;
import com.tencent.mm.plugin.ringtone.uic.b;
import com.tencent.mm.plugin.ringtone.uic.c;
import com.tencent.mm.plugin.ringtone.uic.d;
import com.tencent.mm.plugin.ringtone.uic.e;
import com.tencent.mm.plugin.ringtone.uic.f;
import com.tencent.mm.plugin.ringtone.uic.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.a.j;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/ui/RingtoneSettingsUI;", "Lcom/tencent/mm/plugin/ringtone/uic/BaseRingtoneUI;", "()V", "finish", "", "getLayoutId", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBack", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RingtoneSettingsUI
  extends BaseRingtoneUI
{
  public static final RingtoneSettingsUI.a OEA;
  
  static
  {
    AppMethodBeat.i(273082);
    OEA = new RingtoneSettingsUI.a((byte)0);
    AppMethodBeat.o(273082);
  }
  
  private static final boolean a(RingtoneSettingsUI paramRingtoneSettingsUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(273069);
    s.u(paramRingtoneSettingsUI, "this$0");
    Log.i("MicroMsg.SettingsNewRingtoneUI", "backBtn");
    paramRingtoneSettingsUI.finish();
    AppMethodBeat.o(273069);
    return false;
  }
  
  private static final void j(j paramj)
  {
    AppMethodBeat.i(273076);
    s.u(paramj, "$dialog");
    paramj.cyW();
    paramj = com.tencent.mm.plugin.ringtone.b.a.OBW;
    a.a.aBP().putBoolean("ringtone_exclusive_has_been_educated", true);
    AppMethodBeat.o(273076);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void finish()
  {
    AppMethodBeat.i(273122);
    super.finish();
    AppMethodBeat.o(273122);
  }
  
  public final int getLayoutId()
  {
    return b.d.settings_new_ringtone_ui;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(273098);
    Set localSet = super.importUIComponents();
    if (localSet == null)
    {
      AppMethodBeat.o(273098);
      return null;
    }
    localSet = ar.b(localSet, (Iterable)ar.setOf(new Class[] { h.class, b.class, d.class, c.class, e.class, f.class }));
    AppMethodBeat.o(273098);
    return localSet;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    AppMethodBeat.i(273116);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(273116);
      return;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        paramIntent = paramIntent.getStringExtra("Select_Contact");
        Object localObject = (CharSequence)paramIntent;
        if (localObject != null)
        {
          paramInt1 = i;
          if (((CharSequence)localObject).length() != 0) {}
        }
        else
        {
          paramInt1 = 1;
        }
        if (paramInt1 != 0)
        {
          Log.w("MicroMsg.SettingsNewRingtoneUI", s.X("empty or null contact: ", paramIntent));
          AppMethodBeat.o(273116);
          return;
        }
        localObject = k.aeZF;
        paramInt1 = ((b)k.d((AppCompatActivity)this).q(b.class)).OEE;
        localObject = PluginRingtone.OBl;
        PluginRingtone.a.enterRingtoneSelectUI((Activity)this, 2, paramIntent, paramInt1);
        AppMethodBeat.o(273116);
        return;
        if (paramInt2 != 6)
        {
          AppMethodBeat.o(273116);
          return;
        }
        if (paramIntent == null)
        {
          paramIntent = null;
          paramIntent = (CharSequence)paramIntent;
          if ((paramIntent != null) && (paramIntent.length() != 0)) {
            break label220;
          }
        }
        label220:
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 == 0) {
            break label225;
          }
          AppMethodBeat.o(273116);
          return;
          paramIntent = paramIntent.getStringExtra("exclusvie_name");
          break;
        }
        label225:
        paramIntent = com.tencent.mm.plugin.ringtone.b.a.OBW;
        if (!a.a.aBP().getBoolean("ringtone_exclusive_has_been_educated", false))
        {
          paramIntent = new j((Context)this, 2, 3, false);
          paramIntent.au(getResources().getText(b.f.ringtone_educate_ok));
          paramIntent.aFf(b.d.ringtone_education_page);
          paramIntent.agfR = new RingtoneSettingsUI..ExternalSyntheticLambda1(paramIntent);
          paramIntent.dDn();
        }
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(273104);
    super.onCreate(paramBundle);
    setMMTitle(b.f.settings_ringtone);
    setBackBtn(new RingtoneSettingsUI..ExternalSyntheticLambda0(this));
    setBackGroundColorResource(b.a.BG_3);
    setActionbarColor(androidx.core.content.a.w((Context)getContext(), b.a.BG_3));
    AppMethodBeat.o(273104);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(273124);
    super.onDestroy();
    AppMethodBeat.o(273124);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.ui.RingtoneSettingsUI
 * JD-Core Version:    0.7.0.1
 */