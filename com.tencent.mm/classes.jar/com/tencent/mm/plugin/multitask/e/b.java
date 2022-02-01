package com.tencent.mm.plugin.multitask.e;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/tips/MultiTaskTipsHelper;", "", "()V", "MULTITASK_TIPS_CONFIG", "", "MULTITASK_TIPS_SHOW", "TAG", "showBottomSheet", "", "activity", "Landroid/app/Activity;", "callback", "Lcom/tencent/mm/plugin/multitask/tips/MultiTaskTipsHelper$MultiTaskTipCallback;", "showTips", "MultiTaskTipCallback", "plugin-multitask_release"})
public final class b
{
  public static final b Acc;
  
  static
  {
    AppMethodBeat.i(200642);
    Acc = new b();
    AppMethodBeat.o(200642);
  }
  
  public static void a(Activity paramActivity, final a parama)
  {
    AppMethodBeat.i(200641);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("multitask_tips_config");
    boolean bool = localMultiProcessMMKV.getBoolean("multitask_tips_show", false);
    Log.i("MicroMsg.MultiTaskTipsHelper", "showTips, flag: ".concat(String.valueOf(bool)));
    if (!bool)
    {
      localMultiProcessMMKV.putBoolean("multitask_tips_show", true);
      d.a(0L, (Runnable)new d(paramActivity, parama));
      AppMethodBeat.o(200641);
      return;
    }
    parama.erg();
    AppMethodBeat.o(200641);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/tips/MultiTaskTipsHelper$MultiTaskTipCallback;", "", "onTipCancel", "", "onTipHide", "onTipShow", "plugin-multitask_release"})
  public static abstract interface a
  {
    public abstract void erg();
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/multitask/tips/MultiTaskTipsHelper$showBottomSheet$1$1"})
  static final class b
    implements View.OnClickListener
  {
    b(a parama, b.a parama1) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(200638);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitask/tips/MultiTaskTipsHelper$showBottomSheet$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.Acd.bMo();
      paramView = this.Ace;
      if (paramView != null) {
        paramView.erg();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitask/tips/MultiTaskTipsHelper$showBottomSheet$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(200638);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onDismiss", "com/tencent/mm/plugin/multitask/tips/MultiTaskTipsHelper$showBottomSheet$1$2"})
  static final class c
    implements a.a
  {
    c(a parama, b.a parama1) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(200639);
      b.a locala = this.Ace;
      if (locala != null)
      {
        locala.erg();
        AppMethodBeat.o(200639);
        return;
      }
      AppMethodBeat.o(200639);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(Activity paramActivity, b.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(200640);
      b localb = b.Acc;
      b.b(this.msB, parama);
      AppMethodBeat.o(200640);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.e.b
 * JD-Core Version:    0.7.0.1
 */