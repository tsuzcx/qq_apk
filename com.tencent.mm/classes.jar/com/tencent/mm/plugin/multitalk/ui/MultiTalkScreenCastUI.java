package com.tencent.mm.plugin.multitalk.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.f;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/MultiTalkScreenCastUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "decorView", "Landroid/view/View;", "getDecorView", "()Landroid/view/View;", "decorView$delegate", "Lkotlin/Lazy;", "sendScreen", "", "getLayoutId", "", "initButton", "", "noActionBar", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "persistentState", "Landroid/os/PersistableBundle;", "startCapture", "plugin-multitalk_release"})
public final class MultiTalkScreenCastUI
  extends MMActivity
{
  private final f FvB;
  private HashMap _$_findViewCache;
  
  public MultiTalkScreenCastUI()
  {
    AppMethodBeat.i(200553);
    this.FvB = g.ar((a)new a(this));
    AppMethodBeat.o(200553);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(200559);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(200559);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(200556);
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
    AppMethodBeat.o(200556);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return a.f.multi_talk_screen_cast_ui;
  }
  
  public final boolean noActionBar()
  {
    return true;
  }
  
  public final void onCreate(Bundle paramBundle, PersistableBundle paramPersistableBundle)
  {
    AppMethodBeat.i(200552);
    super.onCreate(paramBundle, paramPersistableBundle);
    ((Button)_$_findCachedViewById(a.e.button_pause)).setOnClickListener((View.OnClickListener)MultiTalkScreenCastUI.b.FvD);
    ((Button)_$_findCachedViewById(a.e.button_quit)).setOnClickListener((View.OnClickListener)MultiTalkScreenCastUI.c.FvE);
    ((Button)_$_findCachedViewById(a.e.button_back)).setOnClickListener((View.OnClickListener)new MultiTalkScreenCastUI.d(this));
    AppMethodBeat.o(200552);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.MultiTalkScreenCastUI
 * JD-Core Version:    0.7.0.1
 */