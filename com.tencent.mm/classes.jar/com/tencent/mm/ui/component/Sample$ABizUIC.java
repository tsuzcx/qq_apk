package com.tencent.mm.ui.component;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/ui/component/Sample$ABizUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "libmmui_release"})
public final class Sample$ABizUIC
  extends UIComponent
{
  public Sample$ABizUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(186572);
    AppMethodBeat.o(186572);
  }
  
  public Sample$ABizUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(186571);
    AppMethodBeat.o(186571);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(186569);
    super.onCreate(paramBundle);
    AppMethodBeat.o(186569);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(186570);
    super.onDestroy();
    AppMethodBeat.o(186570);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.component.Sample.ABizUIC
 * JD-Core Version:    0.7.0.1
 */