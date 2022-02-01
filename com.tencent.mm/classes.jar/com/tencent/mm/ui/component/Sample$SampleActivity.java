package com.tencent.mm.ui.component;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/component/Sample$SampleActivity;", "Lcom/tencent/mm/ui/component/UIComponentActivity;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class Sample$SampleActivity
  extends UIComponentActivity
{
  public final void _$_clearFindViewByIdCache() {}
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(250357);
    Set localSet = ar.setOf(new Class[] { l.i(Sample.c.class, Sample.a.class), Sample.d.class, Sample.f.class, Sample.e.class });
    AppMethodBeat.o(250357);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(250366);
    super.onCreate(paramBundle);
    l.i(Sample.d.class, Sample.b.class);
    AppMethodBeat.o(250366);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(250373);
    super.onResume();
    k localk = k.aeZF;
    k.d((AppCompatActivity)this).cq(Sample.a.class);
    localk = k.aeZF;
    k.d((AppCompatActivity)this).cq(Sample.b.class);
    AppMethodBeat.o(250373);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.component.Sample.SampleActivity
 * JD-Core Version:    0.7.0.1
 */