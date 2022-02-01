package com.tencent.mm.ui.component;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.PluginReport;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/component/Sample$SampleFragment;", "Lcom/tencent/mm/ui/component/UIComponentFragment;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class Sample$SampleFragment
  extends UIComponentFragment
{
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(250364);
    Set localSet = ar.setOf(new Class[] { Sample.c.class, Sample.d.class, Sample.f.class, Sample.e.class });
    AppMethodBeat.o(250364);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(250374);
    super.onCreate(paramBundle);
    paramBundle = k.aeZF;
    ((Sample.d)k.y((Fragment)this).q(Sample.d.class)).hashCode();
    paramBundle = k.aeZF;
    paramBundle = requireContext();
    s.s(paramBundle, "requireContext()");
    ((Sample.f)k.nq(paramBundle).q(Sample.f.class)).hashCode();
    paramBundle = k.aeZF;
    ((Sample.e)k.cn(PluginReport.class).q(Sample.e.class)).hashCode();
    AppMethodBeat.o(250374);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.component.Sample.SampleFragment
 * JD-Core Version:    0.7.0.1
 */