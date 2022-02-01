package com.tencent.mm.plugin.multitask.ui.a;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.plugin.multitask.ui.e.c;
import com.tencent.mm.plugin.multitask.ui.e.d;
import com.tencent.mm.plugin.multitask.ui.e.f;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/accessibility/MultiTaskAccessibilityConfig;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "getType", "", "multiTaskType", "", "initConfig", "", "Companion", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends MMBaseAccessibilityConfig
{
  public static final a.a LEy;
  
  static
  {
    AppMethodBeat.i(304191);
    LEy = new a.a((byte)0);
    AppMethodBeat.o(304191);
  }
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(304184);
    AppMethodBeat.o(304184);
  }
  
  public final String getType(int paramInt)
  {
    AppMethodBeat.i(304203);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(304203);
      return "";
    case 5: 
      str = getString(e.f.LEu);
      AppMethodBeat.o(304203);
      return str;
    case 2: 
      str = getString(e.f.LEu);
      AppMethodBeat.o(304203);
      return str;
    case 1: 
      str = getString(e.f.LEp);
      AppMethodBeat.o(304203);
      return str;
    case 4: 
      str = getString(e.f.LEq);
      AppMethodBeat.o(304203);
      return str;
    case 3: 
      str = getString(e.f.LEr);
      AppMethodBeat.o(304203);
      return str;
    case 22: 
      str = getString(e.f.LEt);
      AppMethodBeat.o(304203);
      return str;
    }
    String str = getString(e.f.LEs);
    AppMethodBeat.o(304203);
    return str;
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(304197);
    root(e.d.LEm).view(e.c.LEh).desc(e.f.LEx);
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(e.d.LEl);
    localConfigHelper.view(e.c.LDI).desc((b)new b(this));
    localConfigHelper.view(e.c.LDT).desc((b)new c(this));
    AppMethodBeat.o(304197);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<View, String>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<View, String>
  {
    c(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.a.a
 * JD-Core Version:    0.7.0.1
 */