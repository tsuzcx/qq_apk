package com.tencent.mm.ui.component;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/component/Sample;", "", "()V", "ABizUIC", "BBizUIC", "CBizUIC", "MainUIC", "SampleActivity", "SampleFragment", "libmmui_release"})
public final class Sample
{
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/component/Sample$SampleActivity;", "Lcom/tencent/mm/ui/component/UIComponentActivity;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "libmmui_release"})
  public static final class SampleActivity
    extends UIComponentActivity
  {
    private HashMap _$_findViewCache;
    
    public final void _$_clearFindViewByIdCache()
    {
      AppMethodBeat.i(204808);
      if (this._$_findViewCache != null) {
        this._$_findViewCache.clear();
      }
      AppMethodBeat.o(204808);
    }
    
    public final View _$_findCachedViewById(int paramInt)
    {
      AppMethodBeat.i(204807);
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
      AppMethodBeat.o(204807);
      return localView1;
    }
    
    public final Set<Class<? extends UIComponent>> importUIComponents()
    {
      AppMethodBeat.i(204806);
      Set localSet = ak.setOf(new Class[] { Sample.MainUIC.class, Sample.ABizUIC.class, Sample.BBizUIC.class, Sample.CBizUIC.class });
      AppMethodBeat.o(204806);
      return localSet;
    }
    
    public void onWindowFocusChanged(boolean paramBoolean)
    {
      super.onWindowFocusChanged(paramBoolean);
      AppMethodBeat.at(this, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.component.Sample
 * JD-Core Version:    0.7.0.1
 */