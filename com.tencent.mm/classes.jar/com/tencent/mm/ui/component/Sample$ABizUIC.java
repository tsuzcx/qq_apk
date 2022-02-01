package com.tencent.mm.ui.component;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/component/Sample$ABizUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "libmmui_release"})
public final class Sample$ABizUIC
  extends UIComponent
{
  public Sample$ABizUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(204796);
    AppMethodBeat.o(204796);
  }
  
  public Sample$ABizUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(204795);
    AppMethodBeat.o(204795);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(204793);
    super.onCreate(paramBundle);
    AppMethodBeat.o(204793);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(204794);
    super.onDestroy();
    AppMethodBeat.o(204794);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.component.Sample.ABizUIC
 * JD-Core Version:    0.7.0.1
 */