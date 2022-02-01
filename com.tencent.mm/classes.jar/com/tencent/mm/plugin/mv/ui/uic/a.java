package com.tencent.mm.plugin.mv.ui.uic;

import android.app.Activity;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.ui.tools.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/uic/KeyboardProviderUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "observerList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "addObserver", "", "observer", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onKeyboardHeightChanged", "height", "", "isResized", "", "onPause", "onResume", "removeObserver", "plugin-mv_release"})
public final class a
  extends UIComponent
  implements h
{
  public final ArrayList<h> Gik;
  public i jij;
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(229422);
    this.Gik = new ArrayList();
    AppMethodBeat.o(229422);
  }
  
  public final void A(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(229418);
    Iterator localIterator = ((Iterable)new ArrayList((Collection)this.Gik)).iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).A(paramInt, paramBoolean);
    }
    AppMethodBeat.o(229418);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(229411);
    super.onCreate(paramBundle);
    this.jij = new i((Activity)getActivity());
    paramBundle = this.jij;
    if (paramBundle != null)
    {
      paramBundle.setKeyboardHeightObserver((h)this);
      AppMethodBeat.o(229411);
      return;
    }
    AppMethodBeat.o(229411);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(229414);
    super.onPause();
    i locali = this.jij;
    if (locali != null)
    {
      locali.close();
      AppMethodBeat.o(229414);
      return;
    }
    AppMethodBeat.o(229414);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(229412);
    super.onResume();
    i locali = this.jij;
    if (locali != null)
    {
      locali.start();
      AppMethodBeat.o(229412);
      return;
    }
    AppMethodBeat.o(229412);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.a
 * JD-Core Version:    0.7.0.1
 */