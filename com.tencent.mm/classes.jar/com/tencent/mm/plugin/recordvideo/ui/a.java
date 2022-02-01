package com.tencent.mm.plugin.recordvideo.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.s;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/MediaProgressDialog;", "", "()V", "loading", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mCancel", "Lkotlin/Function0;", "", "dismiss", "isShowing", "", "setCancelable", "enable", "setOnCancel", "onCancel", "show", "context", "Landroid/content/Context;", "cancelAble", "tip", "", "cancel", "plugin-recordvideo_release"})
public final class a
{
  public kotlin.g.a.a<x> HVq;
  private s uya;
  
  public a()
  {
    AppMethodBeat.i(75872);
    this.HVq = ((kotlin.g.a.a)a.HVr);
    AppMethodBeat.o(75872);
  }
  
  public final void a(Context paramContext, int paramInt, kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(216795);
    p.k(paramContext, "context");
    p.k(parama, "cancel");
    this.HVq = parama;
    if (this.uya == null) {
      this.uya = s.a(paramContext, (CharSequence)paramContext.getString(paramInt), false, 0, (DialogInterface.OnCancelListener)new b(this));
    }
    AppMethodBeat.o(216795);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(75871);
    s locals = this.uya;
    if (locals != null) {
      locals.dismiss();
    }
    this.uya = null;
    AppMethodBeat.o(75871);
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(216796);
    s locals = this.uya;
    if (locals != null)
    {
      boolean bool = locals.isShowing();
      AppMethodBeat.o(216796);
      return bool;
    }
    AppMethodBeat.o(216796);
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final a HVr;
    
    static
    {
      AppMethodBeat.i(75868);
      HVr = new a();
      AppMethodBeat.o(75868);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class b
    implements DialogInterface.OnCancelListener
  {
    b(a parama) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(75869);
      this.HVs.HVq.invoke();
      AppMethodBeat.o(75869);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.a
 * JD-Core Version:    0.7.0.1
 */