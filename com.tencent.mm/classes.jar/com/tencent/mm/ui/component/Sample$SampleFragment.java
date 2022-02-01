package com.tencent.mm.ui.component;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.PluginReport;
import com.tencent.mm.ui.MMActivity;
import d.a.ak;
import d.l;
import d.v;
import java.util.HashMap;
import java.util.Set;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/component/Sample$SampleFragment;", "Lcom/tencent/mm/ui/component/UIComponentFragment;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "libmmui_release"})
public final class Sample$SampleFragment
  extends UIComponentFragment
{
  private HashMap _$_findViewCache;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(193844);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(193844);
  }
  
  public final Set<Class<? extends UIComponent>> cEg()
  {
    AppMethodBeat.i(193842);
    Set localSet = ak.setOf(new Class[] { Sample.MainUIC.class, Sample.ABizUIC.class, Sample.BBizUIC.class, Sample.CBizUIC.class });
    AppMethodBeat.o(193842);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(193843);
    super.onCreate(paramBundle);
    paramBundle = a.KEX;
    ((Sample.ABizUIC)a.of((Fragment)this).get(Sample.ABizUIC.class)).hashCode();
    paramBundle = a.KEX;
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(193843);
      throw paramBundle;
    }
    ((Sample.BBizUIC)a.s((MMActivity)paramBundle).get(Sample.BBizUIC.class)).hashCode();
    paramBundle = a.KEX;
    ((Sample.CBizUIC)a.bi(PluginReport.class).get(Sample.CBizUIC.class)).hashCode();
    AppMethodBeat.o(193843);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.component.Sample.SampleFragment
 * JD-Core Version:    0.7.0.1
 */