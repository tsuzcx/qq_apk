package com.tencent.mm.plugin.multitalk.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ui/MultiTalkScreenCastUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "decorView", "Landroid/view/View;", "getDecorView", "()Landroid/view/View;", "decorView$delegate", "Lkotlin/Lazy;", "sendScreen", "", "getLayoutId", "", "initButton", "", "noActionBar", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "persistentState", "Landroid/os/PersistableBundle;", "startCapture", "plugin-multitalk_release"})
public final class MultiTalkScreenCastUI
  extends MMActivity
{
  private HashMap _$_findViewCache;
  private final f zPY;
  
  public MultiTalkScreenCastUI()
  {
    AppMethodBeat.i(239719);
    this.zPY = g.ah((a)new a(this));
    AppMethodBeat.o(239719);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(239721);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(239721);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(239720);
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
    AppMethodBeat.o(239720);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131495712;
  }
  
  public final boolean noActionBar()
  {
    return true;
  }
  
  public final void onCreate(Bundle paramBundle, PersistableBundle paramPersistableBundle)
  {
    AppMethodBeat.i(239718);
    super.onCreate(paramBundle, paramPersistableBundle);
    ((Button)_$_findCachedViewById(2131297927)).setOnClickListener((View.OnClickListener)MultiTalkScreenCastUI.b.zQa);
    ((Button)_$_findCachedViewById(2131297931)).setOnClickListener((View.OnClickListener)MultiTalkScreenCastUI.c.zQb);
    ((Button)_$_findCachedViewById(2131297903)).setOnClickListener((View.OnClickListener)new MultiTalkScreenCastUI.d(this));
    AppMethodBeat.o(239718);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "invoke"})
  static final class a
    extends q
    implements a<View>
  {
    a(MultiTalkScreenCastUI paramMultiTalkScreenCastUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.MultiTalkScreenCastUI
 * JD-Core Version:    0.7.0.1
 */