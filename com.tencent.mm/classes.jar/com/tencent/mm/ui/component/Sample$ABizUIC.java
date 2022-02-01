package com.tencent.mm.ui.component;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/ui/component/Sample$ABizUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "libmmui_release"})
public final class Sample$ABizUIC
  extends UIComponent
{
  public Sample$ABizUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(197255);
    AppMethodBeat.o(197255);
  }
  
  public Sample$ABizUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(197254);
    AppMethodBeat.o(197254);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(197252);
    super.onCreate(paramBundle);
    AppMethodBeat.o(197252);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(197253);
    super.onDestroy();
    AppMethodBeat.o(197253);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.component.Sample.ABizUIC
 * JD-Core Version:    0.7.0.1
 */