package com.tencent.mm.ui.component;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/component/Sample$ABizUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "libmmui_release"})
public final class Sample$ABizUIC
  extends UIComponent
{
  public Sample$ABizUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(193830);
    AppMethodBeat.o(193830);
  }
  
  public Sample$ABizUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(193829);
    AppMethodBeat.o(193829);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(193827);
    super.onCreate(paramBundle);
    AppMethodBeat.o(193827);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(193828);
    super.onDestroy();
    AppMethodBeat.o(193828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.component.Sample.ABizUIC
 * JD-Core Version:    0.7.0.1
 */