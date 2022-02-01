package com.tencent.mm.plugin.ringtone.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.ringtone.b.a;
import com.tencent.mm.plugin.ringtone.b.d;
import com.tencent.mm.plugin.ringtone.b.e;
import com.tencent.mm.plugin.ringtone.b.f;
import com.tencent.mm.plugin.ringtone.uic.BaseRingtoneUI;
import com.tencent.mm.plugin.ringtone.uic.a;
import com.tencent.mm.plugin.ringtone.uic.h;
import com.tencent.mm.plugin.ringtone.uic.i;
import com.tencent.mm.plugin.ringtone.uic.j;
import com.tencent.mm.plugin.ringtone.uic.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/ui/RingtoneSearchUI;", "Lcom/tencent/mm/plugin/ringtone/uic/BaseRingtoneUI;", "()V", "TAG", "", "getLayoutId", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onBack", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onPrepareOptionsMenu", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RingtoneSearchUI
  extends BaseRingtoneUI
{
  private final String TAG = "MicroMsg.RingtoneSearchUI";
  
  private static final void a(RingtoneSearchUI paramRingtoneSearchUI, Boolean paramBoolean)
  {
    AppMethodBeat.i(273057);
    s.u(paramRingtoneSearchUI, "this$0");
    paramRingtoneSearchUI.hideVKB();
    AppMethodBeat.o(273057);
  }
  
  private static final boolean a(RingtoneSearchUI paramRingtoneSearchUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(273052);
    s.u(paramRingtoneSearchUI, "this$0");
    Log.i(paramRingtoneSearchUI.TAG, "backBtn");
    paramRingtoneSearchUI.setResult(-2);
    paramRingtoneSearchUI.finish();
    AppMethodBeat.o(273052);
    return false;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return b.d.ringtone_search_list_ui;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(273073);
    Set localSet = super.importUIComponents();
    if (localSet == null)
    {
      AppMethodBeat.o(273073);
      return null;
    }
    localSet = ar.b(localSet, (Iterable)ar.setOf(new Class[] { h.class, com.tencent.mm.plugin.ringtone.uic.b.class, j.class, i.class, a.class, m.class }));
    AppMethodBeat.o(273073);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(273084);
    super.onCreate(paramBundle);
    if (getIntent().getIntExtra("ringtone_caller", 1) == 1) {
      setMMTitle(b.f.ringtone_select_title);
    }
    for (;;)
    {
      setBackBtn(new RingtoneSearchUI..ExternalSyntheticLambda0(this), b.e.arrow_left);
      setActionbarColor(getContext().getResources().getColor(b.a.BG_2));
      setBackGroundColorResource(b.a.BG_0);
      paramBundle = k.aeZF;
      ((com.tencent.mm.plugin.ringtone.uic.b)k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.ringtone.uic.b.class)).OEF.a((q)this, new RingtoneSearchUI..ExternalSyntheticLambda1(this));
      AppMethodBeat.o(273084);
      return;
      paramBundle = getIntent().getStringExtra("exclusvie_name");
      if (paramBundle != null) {
        if (ab.Jg(paramBundle).sex == 2) {
          setMMTitle(b.f.ringtone_select_title_excluesive_she);
        } else {
          setMMTitle(b.f.ringtone_select_title_excluesive);
        }
      }
    }
  }
  
  public final boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(273087);
    k localk = k.aeZF;
    ((j)k.d((AppCompatActivity)this).q(j.class)).vDu.a((FragmentActivity)this, paramMenu);
    AppMethodBeat.o(273087);
    return true;
  }
  
  public final boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(273093);
    k localk = k.aeZF;
    ((j)k.d((AppCompatActivity)this).q(j.class)).vDu.a((Activity)this, paramMenu);
    AppMethodBeat.o(273093);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.ui.RingtoneSearchUI
 * JD-Core Version:    0.7.0.1
 */