package com.tencent.mm.ui.component;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/component/Sample$MainUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/ui/component/Sample$ApiMainUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "getLayoutId", "", "main", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class Sample$c
  extends UIComponent
  implements Sample.a
{
  public Sample$c(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(250269);
    AppMethodBeat.o(250269);
  }
  
  public Sample$c(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(250274);
    AppMethodBeat.o(250274);
  }
  
  public final int getLayoutId()
  {
    AppMethodBeat.i(250280);
    int i = super.getLayoutId();
    AppMethodBeat.o(250280);
    return i;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(250290);
    super.onCreate(paramBundle);
    AppMethodBeat.o(250290);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(250295);
    super.onDestroy();
    AppMethodBeat.o(250295);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.component.Sample.c
 * JD-Core Version:    0.7.0.1
 */