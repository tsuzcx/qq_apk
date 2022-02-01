package com.tencent.mm.ui.component;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/component/Sample$MainUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/ui/component/Sample$ApiMainUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "getLayoutId", "", "main", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "libmmui_release"})
public final class Sample$c
  extends UIComponent
  implements Sample.b
{
  public Sample$c(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(193437);
    AppMethodBeat.o(193437);
  }
  
  public Sample$c(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(193440);
    AppMethodBeat.o(193440);
  }
  
  public final int getLayoutId()
  {
    AppMethodBeat.i(193429);
    int i = super.getLayoutId();
    AppMethodBeat.o(193429);
    return i;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(193432);
    super.onCreate(paramBundle);
    AppMethodBeat.o(193432);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(193434);
    super.onDestroy();
    AppMethodBeat.o(193434);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.component.Sample.c
 * JD-Core Version:    0.7.0.1
 */