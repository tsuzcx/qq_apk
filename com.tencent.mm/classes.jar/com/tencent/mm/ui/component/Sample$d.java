package com.tencent.mm.ui.component;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/component/Sample$OneBizUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/ui/component/Sample$ApiBizUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "test", "libmmui_release"})
public final class Sample$d
  extends UIComponent
  implements Sample.a
{
  public Sample$d(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(195271);
    AppMethodBeat.o(195271);
  }
  
  public Sample$d(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(195274);
    AppMethodBeat.o(195274);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(195267);
    super.onCreate(paramBundle);
    AppMethodBeat.o(195267);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(195269);
    super.onDestroy();
    AppMethodBeat.o(195269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.component.Sample.d
 * JD-Core Version:    0.7.0.1
 */