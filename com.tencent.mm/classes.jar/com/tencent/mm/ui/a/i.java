package com.tencent.mm.ui.a;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/accessibility/MMPreferenceAccessibilityConfig;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends MMBaseAccessibilityConfig
{
  public i(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(250969);
    AppMethodBeat.o(250969);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(250974);
    root(a.h.mm_preference_header_catalog).disable(a.g.small_catalog);
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(a.h.mm_preference_summary_checkbox);
    localConfigHelper.view(a.g.title_one_line).clickAs(a.g.checkbox).desc((b)a.adLA).checkOn((b)b.adLB);
    localConfigHelper.view(a.g.checkbox).disable();
    localConfigHelper = root(a.h.mm_preference_summary_checkbox_sub);
    localConfigHelper.view(a.g.title_one_line).clickAs(a.g.checkbox).desc((b)c.adLC).checkOn((b)d.adLD);
    localConfigHelper.view(a.g.checkbox).disable();
    AppMethodBeat.o(250974);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<View, String>
  {
    public static final a adLA;
    
    static
    {
      AppMethodBeat.i(250122);
      adLA = new a();
      AppMethodBeat.o(250122);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<View, Boolean>
  {
    public static final b adLB;
    
    static
    {
      AppMethodBeat.i(250117);
      adLB = new b();
      AppMethodBeat.o(250117);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<View, String>
  {
    public static final c adLC;
    
    static
    {
      AppMethodBeat.i(250129);
      adLC = new c();
      AppMethodBeat.o(250129);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements b<View, Boolean>
  {
    public static final d adLD;
    
    static
    {
      AppMethodBeat.i(250121);
      adLD = new d();
      AppMethodBeat.o(250121);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.a.i
 * JD-Core Version:    0.7.0.1
 */