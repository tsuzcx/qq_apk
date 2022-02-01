package com.tencent.mm.plugin.mv.ui.uic;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/uic/KeyboardProviderUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "observerList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "addObserver", "", "observer", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onKeyboardHeightChanged", "height", "", "isResized", "", "onPause", "onResume", "removeObserver", "plugin-mv_release"})
public final class KeyboardProviderUIC
  extends UIComponent
  implements g
{
  public final ArrayList<g> AsQ;
  public h gyh;
  
  public KeyboardProviderUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(257085);
    this.AsQ = new ArrayList();
    AppMethodBeat.o(257085);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(257081);
    super.onCreate(paramBundle);
    this.gyh = new h((Activity)getActivity());
    paramBundle = this.gyh;
    if (paramBundle != null)
    {
      paramBundle.setKeyboardHeightObserver((g)this);
      AppMethodBeat.o(257081);
      return;
    }
    AppMethodBeat.o(257081);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(257083);
    super.onPause();
    h localh = this.gyh;
    if (localh != null)
    {
      localh.close();
      AppMethodBeat.o(257083);
      return;
    }
    AppMethodBeat.o(257083);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(257082);
    super.onResume();
    h localh = this.gyh;
    if (localh != null)
    {
      localh.start();
      AppMethodBeat.o(257082);
      return;
    }
    AppMethodBeat.o(257082);
  }
  
  public final void y(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(257084);
    Iterator localIterator = ((Iterable)new ArrayList((Collection)this.AsQ)).iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).y(paramInt, paramBoolean);
    }
    AppMethodBeat.o(257084);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.KeyboardProviderUIC
 * JD-Core Version:    0.7.0.1
 */