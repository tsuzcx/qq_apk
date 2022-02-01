package com.tencent.mm.ui.component;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/component/Sample$OneBizUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/ui/component/Sample$ApiOneBizUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "test", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class Sample$d
  extends UIComponent
  implements Sample.b
{
  public Sample$d(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(250267);
    AppMethodBeat.o(250267);
  }
  
  public Sample$d(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(250273);
    AppMethodBeat.o(250273);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(250276);
    super.onCreate(paramBundle);
    AppMethodBeat.o(250276);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(250282);
    super.onDestroy();
    AppMethodBeat.o(250282);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.component.Sample.d
 * JD-Core Version:    0.7.0.1
 */