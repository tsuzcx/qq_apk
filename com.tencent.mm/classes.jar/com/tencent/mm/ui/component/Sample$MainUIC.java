package com.tencent.mm.ui.component;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/component/Sample$MainUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "libmmui_release"})
public final class Sample$MainUIC
  extends UIComponent
{
  public Sample$MainUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(193839);
    AppMethodBeat.o(193839);
  }
  
  public Sample$MainUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(193838);
    AppMethodBeat.o(193838);
  }
  
  public final int getLayoutId()
  {
    AppMethodBeat.i(193835);
    int i = super.getLayoutId();
    AppMethodBeat.o(193835);
    return i;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(193836);
    super.onCreate(paramBundle);
    AppMethodBeat.o(193836);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(193837);
    super.onDestroy();
    AppMethodBeat.o(193837);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.component.Sample.MainUIC
 * JD-Core Version:    0.7.0.1
 */