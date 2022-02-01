package com.tencent.mm.plugin.repairer.ui.uic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.component.o;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/uic/Test1UIC;", "Lcom/tencent/mm/ui/component/UIComponentWithState;", "Lcom/tencent/mm/plugin/repairer/ui/uic/Test1State;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "uicState", "getUicState", "()Lcom/tencent/mm/plugin/repairer/ui/uic/Test1State;", "onCleared", "", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends o<f>
{
  final f OyT;
  
  public g(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(278026);
    this.OyT = new f();
    AppMethodBeat.o(278026);
  }
  
  public g(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(278032);
    this.OyT = new f();
    AppMethodBeat.o(278032);
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(278035);
    super.onCleared();
    this.OyT.jxQ();
    AppMethodBeat.o(278035);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.uic.g
 * JD-Core Version:    0.7.0.1
 */