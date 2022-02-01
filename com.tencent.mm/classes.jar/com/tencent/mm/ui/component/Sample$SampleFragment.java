package com.tencent.mm.ui.component;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.PluginReport;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/component/Sample$SampleFragment;", "Lcom/tencent/mm/ui/component/UIComponentFragment;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "libmmui_release"})
public final class Sample$SampleFragment
  extends UIComponentFragment
{
  private HashMap _$_findViewCache;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(204811);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(204811);
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(204809);
    Set localSet = ak.setOf(new Class[] { Sample.MainUIC.class, Sample.ABizUIC.class, Sample.BBizUIC.class, Sample.CBizUIC.class });
    AppMethodBeat.o(204809);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(204810);
    super.onCreate(paramBundle);
    paramBundle = a.PRN;
    ((Sample.ABizUIC)a.of((Fragment)this).get(Sample.ABizUIC.class)).hashCode();
    paramBundle = a.PRN;
    paramBundle = requireContext();
    p.g(paramBundle, "requireContext()");
    ((Sample.BBizUIC)a.ko(paramBundle).get(Sample.BBizUIC.class)).hashCode();
    paramBundle = a.PRN;
    ((Sample.CBizUIC)a.bi(PluginReport.class).get(Sample.CBizUIC.class)).hashCode();
    AppMethodBeat.o(204810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.component.Sample.SampleFragment
 * JD-Core Version:    0.7.0.1
 */