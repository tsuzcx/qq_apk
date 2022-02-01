package com.tencent.mm.ui.a;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.accessibility.type.ViewType;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/accessibility/ContactRemarkUIAccessibilityConfig;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends MMBaseAccessibilityConfig
{
  public static final e.a adLt;
  
  static
  {
    AppMethodBeat.i(250112);
    adLt = new e.a((byte)0);
    AppMethodBeat.o(250112);
  }
  
  public e(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(250107);
    AppMethodBeat.o(250107);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(250115);
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(R.h.fTh);
    localConfigHelper.view(R.h.fTg).type(ViewType.Button);
    localConfigHelper.view(R.h.fEA).type(ViewType.Button).clickAs(R.h.fEz).desc(R.l.gEg);
    root(R.h.fTf).view(R.h.fTg).type(ViewType.Button);
    localConfigHelper = root(R.i.giA);
    localConfigHelper.view(R.h.fUJ).desc(R.l.gXh).type(ViewType.Button);
    localConfigHelper.view(R.h.fUK).desc(R.l.gXi).type(ViewType.Button);
    AppMethodBeat.o(250115);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.a.e
 * JD-Core Version:    0.7.0.1
 */