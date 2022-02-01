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
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/uic/KeyboardProviderUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "observerList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "addObserver", "", "observer", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onKeyboardHeightChanged", "height", "", "isResized", "", "onPause", "onResume", "removeObserver", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends UIComponent
  implements h
{
  public final ArrayList<h> Mdq;
  public i lKz;
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(287898);
    this.Mdq = new ArrayList();
    AppMethodBeat.o(287898);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(287911);
    super.onCreate(paramBundle);
    this.lKz = new i((Activity)getActivity());
    paramBundle = this.lKz;
    if (paramBundle != null) {
      paramBundle.afIL = ((h)this);
    }
    AppMethodBeat.o(287911);
  }
  
  public final void onKeyboardHeightChanged(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(287942);
    Iterator localIterator = ((Iterable)new ArrayList((Collection)this.Mdq)).iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).onKeyboardHeightChanged(paramInt, paramBoolean);
    }
    AppMethodBeat.o(287942);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(287929);
    super.onPause();
    i locali = this.lKz;
    if (locali != null) {
      locali.close();
    }
    AppMethodBeat.o(287929);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(287921);
    super.onResume();
    i locali = this.lKz;
    if (locali != null) {
      locali.start();
    }
    AppMethodBeat.o(287921);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.a
 * JD-Core Version:    0.7.0.1
 */