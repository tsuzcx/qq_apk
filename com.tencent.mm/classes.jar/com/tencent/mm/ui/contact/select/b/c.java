package com.tencent.mm.ui.contact.select.b;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.statecenter.UIStateCenter;
import com.tencent.mm.ui.mvvm.a.i;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/contact/select/uic/SelectContactMenuUIC;", "Lcom/tencent/mm/ui/mvvm/uic/BaseSelectContactMenuUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.ui.mvvm.b.b
{
  public c(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(253137);
    AppMethodBeat.o(253137);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(253140);
    super.onCreate(paramBundle);
    paramBundle = getStateCenter();
    if (paramBundle != null) {
      paramBundle.observe((q)getActivity(), (kotlin.g.a.b)new a(this));
    }
    AppMethodBeat.o(253140);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "state", "Lcom/tencent/mm/ui/mvvm/state/SelectContactState;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<i, ah>
  {
    a(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.select.b.c
 * JD-Core Version:    0.7.0.1
 */