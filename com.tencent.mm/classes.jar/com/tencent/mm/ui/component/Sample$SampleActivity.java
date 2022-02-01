package com.tencent.mm.ui.component;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/component/Sample$SampleActivity;", "Lcom/tencent/mm/ui/component/UIComponentActivity;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "libmmui_release"})
public final class Sample$SampleActivity
  extends UIComponentActivity
{
  private HashMap _$_findViewCache;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(195315);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(195315);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(195312);
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
    AppMethodBeat.o(195312);
    return localView1;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(195301);
    Set localSet = ak.setOf(new Class[] { h.h(Sample.c.class, Sample.b.class), Sample.d.class, Sample.f.class, Sample.e.class });
    AppMethodBeat.o(195301);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(195306);
    super.onCreate(paramBundle);
    paramBundle = g.Xox;
    g.b((AppCompatActivity)this);
    p.k(Sample.a.class, "api");
    p.k(Sample.d.class, "impl");
    if (!Sample.a.class.isAssignableFrom(Sample.d.class))
    {
      paramBundle = (Throwable)new RuntimeException(Sample.d.class + " is not a subType of " + Sample.a.class);
      AppMethodBeat.o(195306);
      throw paramBundle;
    }
    h.h(Sample.d.class, Sample.a.class);
    AppMethodBeat.o(195306);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(195308);
    super.onResume();
    g localg = g.Xox;
    g.b((AppCompatActivity)this).bE(Sample.b.class);
    localg = g.Xox;
    g.b((AppCompatActivity)this).bE(Sample.a.class);
    AppMethodBeat.o(195308);
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