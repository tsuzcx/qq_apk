package com.tencent.mm.ui.component;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/component/Sample$MainUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "libmmui_release"})
public final class Sample$MainUIC
  extends UIComponent
{
  public Sample$MainUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(204805);
    AppMethodBeat.o(204805);
  }
  
  public Sample$MainUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(204804);
    AppMethodBeat.o(204804);
  }
  
  public final int getLayoutId()
  {
    AppMethodBeat.i(204801);
    int i = super.getLayoutId();
    AppMethodBeat.o(204801);
    return i;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(204802);
    super.onCreate(paramBundle);
    AppMethodBeat.o(204802);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(204803);
    super.onDestroy();
    AppMethodBeat.o(204803);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.component.Sample.MainUIC
 * JD-Core Version:    0.7.0.1
 */