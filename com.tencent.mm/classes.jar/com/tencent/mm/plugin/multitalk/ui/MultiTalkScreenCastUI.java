package com.tencent.mm.plugin.multitalk.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.multitalk.model.o;
import com.tencent.mm.plugin.multitalk.model.r;
import com.tencent.mm.plugin.multitalk.model.z;
import com.tencent.mm.ui.MMActivity;
import d.f;
import d.g;
import d.g.b.p;
import d.g.b.q;
import d.l;
import java.util.HashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/multitalk/ui/MultiTalkScreenCastUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "decorView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getDecorView", "()Landroid/view/View;", "decorView$delegate", "Lkotlin/Lazy;", "sendScreen", "", "getLayoutId", "", "initButton", "", "noActionBar", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "persistentState", "Landroid/os/PersistableBundle;", "startCapture", "plugin-multitalk_release"})
public final class MultiTalkScreenCastUI
  extends MMActivity
{
  private HashMap _$_findViewCache;
  private final f wtC;
  
  public MultiTalkScreenCastUI()
  {
    AppMethodBeat.i(191005);
    this.wtC = g.O((d.g.a.a)new a(this));
    AppMethodBeat.o(191005);
  }
  
  private View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(191006);
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
    AppMethodBeat.o(191006);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131496413;
  }
  
  public final boolean noActionBar()
  {
    return true;
  }
  
  public final void onCreate(Bundle paramBundle, PersistableBundle paramPersistableBundle)
  {
    AppMethodBeat.i(191004);
    super.onCreate(paramBundle, paramPersistableBundle);
    ((Button)_$_findCachedViewById(2131301498)).setOnClickListener((View.OnClickListener)b.wtE);
    ((Button)_$_findCachedViewById(2131302573)).setOnClickListener((View.OnClickListener)c.wtF);
    ((Button)_$_findCachedViewById(2131301237)).setOnClickListener((View.OnClickListener)new d(this));
    AppMethodBeat.o(191004);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<View>
  {
    a(MultiTalkScreenCastUI paramMultiTalkScreenCastUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    public static final b wtE;
    
    static
    {
      AppMethodBeat.i(191000);
      wtE = new b();
      AppMethodBeat.o(191000);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(190999);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/MultiTalkScreenCastUI$initButton$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = z.dtK();
      p.g(paramView, "SubCoreMultiTalk.getMultiTalkManager()");
      paramView.dtb();
      r.Ll(102);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/MultiTalkScreenCastUI$initButton$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(190999);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    public static final c wtF;
    
    static
    {
      AppMethodBeat.i(191002);
      wtF = new c();
      AppMethodBeat.o(191002);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(191001);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/MultiTalkScreenCastUI$initButton$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = z.dtK();
      p.g(paramView, "SubCoreMultiTalk.getMultiTalkManager()");
      paramView.dtb();
      r.Ll(103);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/MultiTalkScreenCastUI$initButton$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(191001);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(MultiTalkScreenCastUI paramMultiTalkScreenCastUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(191003);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/MultiTalkScreenCastUI$initButton$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = z.dtK();
      p.g(paramView, "SubCoreMultiTalk.getMultiTalkManager()");
      paramView.dtb();
      r.Ll(102);
      this.wtD.finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/MultiTalkScreenCastUI$initButton$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(191003);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.MultiTalkScreenCastUI
 * JD-Core Version:    0.7.0.1
 */