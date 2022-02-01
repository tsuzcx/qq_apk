package com.tencent.mm.ui.component;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/ui/component/Sample$MainUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "libmmui_release"})
public final class Sample$MainUIC
  extends UIComponent
{
  public Sample$MainUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(197264);
    AppMethodBeat.o(197264);
  }
  
  public Sample$MainUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(197263);
    AppMethodBeat.o(197263);
  }
  
  public final int getLayoutId()
  {
    AppMethodBeat.i(197260);
    int i = super.getLayoutId();
    AppMethodBeat.o(197260);
    return i;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(197261);
    super.onCreate(paramBundle);
    AppMethodBeat.o(197261);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(197262);
    super.onDestroy();
    AppMethodBeat.o(197262);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.component.Sample.MainUIC
 * JD-Core Version:    0.7.0.1
 */