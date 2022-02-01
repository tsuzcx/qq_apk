package com.tencent.mm.ui.component;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ak;
import d.l;
import java.util.HashMap;
import java.util.Set;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/component/Sample$SampleActivity;", "Lcom/tencent/mm/ui/component/UIComponentActivity;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "libmmui_release"})
public final class Sample$SampleActivity
  extends UIComponentActivity
{
  private HashMap _$_findViewCache;
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(193841);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(193841);
    return localView1;
  }
  
  public final Set<Class<? extends UIComponent>> cEg()
  {
    AppMethodBeat.i(193840);
    Set localSet = ak.setOf(new Class[] { Sample.MainUIC.class, Sample.ABizUIC.class, Sample.BBizUIC.class, Sample.CBizUIC.class });
    AppMethodBeat.o(193840);
    return localSet;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.component.Sample.SampleActivity
 * JD-Core Version:    0.7.0.1
 */