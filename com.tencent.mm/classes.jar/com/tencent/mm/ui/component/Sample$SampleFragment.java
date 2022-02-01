package com.tencent.mm.ui.component;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.PluginReport;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/component/Sample$SampleFragment;", "Lcom/tencent/mm/ui/component/UIComponentFragment;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "libmmui_release"})
public final class Sample$SampleFragment
  extends UIComponentFragment
{
  private HashMap _$_findViewCache;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(204446);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(204446);
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(204437);
    Set localSet = ak.setOf(new Class[] { Sample.c.class, Sample.d.class, Sample.f.class, Sample.e.class });
    AppMethodBeat.o(204437);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(204442);
    super.onCreate(paramBundle);
    paramBundle = g.Xox;
    ((Sample.d)g.h((Fragment)this).i(Sample.d.class)).hashCode();
    paramBundle = g.Xox;
    paramBundle = requireContext();
    p.j(paramBundle, "requireContext()");
    ((Sample.f)g.lm(paramBundle).i(Sample.f.class)).hashCode();
    paramBundle = g.Xox;
    ((Sample.e)g.bD(PluginReport.class).i(Sample.e.class)).hashCode();
    AppMethodBeat.o(204442);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.component.Sample.SampleFragment
 * JD-Core Version:    0.7.0.1
 */