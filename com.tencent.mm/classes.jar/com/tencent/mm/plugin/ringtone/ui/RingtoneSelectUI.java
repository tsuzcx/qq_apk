package com.tencent.mm.plugin.ringtone.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.ringtone.b.a;
import com.tencent.mm.plugin.ringtone.b.d;
import com.tencent.mm.plugin.ringtone.b.f;
import com.tencent.mm.plugin.ringtone.uic.BaseRingtoneUI;
import com.tencent.mm.plugin.ringtone.uic.a;
import com.tencent.mm.plugin.ringtone.uic.b;
import com.tencent.mm.plugin.ringtone.uic.h;
import com.tencent.mm.plugin.ringtone.uic.k;
import com.tencent.mm.plugin.ringtone.uic.l;
import com.tencent.mm.plugin.ringtone.uic.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/ui/RingtoneSelectUI;", "Lcom/tencent/mm/plugin/ringtone/uic/BaseRingtoneUI;", "()V", "getLayoutId", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onBack", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RingtoneSelectUI
  extends BaseRingtoneUI
{
  public static final RingtoneSelectUI.a OEz;
  
  static
  {
    AppMethodBeat.i(273056);
    OEz = new RingtoneSelectUI.a((byte)0);
    AppMethodBeat.o(273056);
  }
  
  private static final boolean a(RingtoneSelectUI paramRingtoneSelectUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(273050);
    s.u(paramRingtoneSelectUI, "this$0");
    Log.i("MicroMsg.RingtoneSelectUI", "backBtn");
    paramRingtoneSelectUI.setResult(-2);
    paramRingtoneSelectUI.finish();
    AppMethodBeat.o(273050);
    return false;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return b.d.ringtone_select_ui;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(273067);
    Set localSet = super.importUIComponents();
    if (localSet == null)
    {
      AppMethodBeat.o(273067);
      return null;
    }
    localSet = ar.b(localSet, (Iterable)ar.setOf(new Class[] { h.class, b.class, l.class, k.class, a.class, m.class }));
    AppMethodBeat.o(273067);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(273075);
    super.onCreate(paramBundle);
    if (getIntent().getIntExtra("ringtone_caller", 1) == 1) {
      setMMTitle(b.f.ringtone_select_title);
    }
    for (;;)
    {
      setBackBtn(new RingtoneSelectUI..ExternalSyntheticLambda0(this));
      setActionbarColor(getContext().getResources().getColor(b.a.BG_2));
      AppMethodBeat.o(273075);
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
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.ui.RingtoneSelectUI
 * JD-Core Version:    0.7.0.1
 */