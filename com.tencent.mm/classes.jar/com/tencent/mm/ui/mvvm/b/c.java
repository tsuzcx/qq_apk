package com.tencent.mm.ui.mvvm.b;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mvvmbase.BaseMvvmActivity;
import com.tencent.mm.plugin.mvvmbase.a;
import com.tencent.mm.sdk.statecenter.IStateAction;
import com.tencent.mm.sdk.statecenter.UIStateCenter;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/mvvm/uic/SelectContactDataUIC;", "Lcom/tencent/mm/plugin/mvvmbase/BaseMvvmUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends a
{
  public c(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(250606);
    AppMethodBeat.o(250606);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(250614);
    paramBundle = gst();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getStateCenter();
      if (paramBundle != null) {
        paramBundle.process((q)getActivity(), (kotlin.g.a.b)c.a.afBB);
      }
    }
    AppMethodBeat.o(250614);
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(250618);
    paramBundle = gst();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getStateCenter();
      if (paramBundle != null) {
        paramBundle.dispatch((IStateAction)new com.tencent.mm.ui.mvvm.a.b());
      }
    }
    AppMethodBeat.o(250618);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.mvvm.b.c
 * JD-Core Version:    0.7.0.1
 */