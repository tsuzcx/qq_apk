package com.tencent.mm.plugin.mvvmbase;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.sdk.statecenter.BaseState;
import com.tencent.mm.sdk.statecenter.UIStateCenter;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mvvmbase/BaseMvvmUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "getLifecycleScope", "Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "getMvvmActivity", "Lcom/tencent/mm/plugin/mvvmbase/BaseMvvmActivity;", "getStateCenter", "Lcom/tencent/mm/sdk/statecenter/UIStateCenter;", "State", "Lcom/tencent/mm/sdk/statecenter/BaseState;", "hideVKB", "", "showVKB", "plugin-mvvmbase_release"}, k=1, mv={1, 5, 1}, xi=48)
public class a
  extends UIComponent
{
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(261005);
    AppMethodBeat.o(261005);
  }
  
  public final LifecycleScope getLifecycleScope()
  {
    AppMethodBeat.i(261011);
    Object localObject = gst();
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = ((com.tencent.mm.plugin.mvvmbase.a.a)k.d((AppCompatActivity)localObject).q(com.tencent.mm.plugin.mvvmbase.a.a.class)).gsu())
    {
      AppMethodBeat.o(261011);
      return null;
      k localk = k.aeZF;
    }
    AppMethodBeat.o(261011);
    return localObject;
  }
  
  public final <State extends BaseState> UIStateCenter<State> getStateCenter()
  {
    AppMethodBeat.i(261020);
    Object localObject = gst();
    if (localObject == null)
    {
      AppMethodBeat.o(261020);
      return null;
    }
    localObject = ((BaseMvvmActivity)localObject).getStateCenter();
    AppMethodBeat.o(261020);
    return localObject;
  }
  
  public final BaseMvvmActivity gst()
  {
    AppMethodBeat.i(261017);
    Object localObject = getActivity();
    if ((localObject instanceof BaseMvvmActivity))
    {
      localObject = (BaseMvvmActivity)localObject;
      AppMethodBeat.o(261017);
      return localObject;
    }
    AppMethodBeat.o(261017);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mvvmbase.a
 * JD-Core Version:    0.7.0.1
 */