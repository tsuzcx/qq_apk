package com.tencent.mm.ui.component;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/ui/component/Sample$MainUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "libmmui_release"})
public final class Sample$MainUIC
  extends UIComponent
{
  public Sample$MainUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(186581);
    AppMethodBeat.o(186581);
  }
  
  public Sample$MainUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(186580);
    AppMethodBeat.o(186580);
  }
  
  public final int getLayoutId()
  {
    AppMethodBeat.i(186577);
    int i = super.getLayoutId();
    AppMethodBeat.o(186577);
    return i;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(186578);
    super.onCreate(paramBundle);
    AppMethodBeat.o(186578);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(186579);
    super.onDestroy();
    AppMethodBeat.o(186579);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.component.Sample.MainUIC
 * JD-Core Version:    0.7.0.1
 */