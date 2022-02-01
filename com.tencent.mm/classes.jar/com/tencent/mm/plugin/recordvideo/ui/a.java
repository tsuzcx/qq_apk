package com.tencent.mm.plugin.recordvideo.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/MediaProgressDialog;", "", "()V", "loading", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mCancel", "Lkotlin/Function0;", "", "dismiss", "isShowing", "", "setCancelable", "enable", "setOnCancel", "onCancel", "show", "context", "Landroid/content/Context;", "cancelAble", "tip", "", "cancel", "plugin-recordvideo_release"})
public final class a
{
  public kotlin.g.a.a<x> BYB;
  public com.tencent.mm.ui.base.q qVq;
  
  public a()
  {
    AppMethodBeat.i(75872);
    this.BYB = ((kotlin.g.a.a)a.BYC);
    AppMethodBeat.o(75872);
  }
  
  public final void b(Context paramContext, kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(75870);
    p.h(paramContext, "context");
    p.h(parama, "cancel");
    this.BYB = parama;
    if (this.qVq == null) {
      this.qVq = com.tencent.mm.ui.base.q.a(paramContext, (CharSequence)paramContext.getString(2131764610), false, 0, (DialogInterface.OnCancelListener)new b(this));
    }
    AppMethodBeat.o(75870);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public static final a BYC;
    
    static
    {
      AppMethodBeat.i(75868);
      BYC = new a();
      AppMethodBeat.o(75868);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class b
    implements DialogInterface.OnCancelListener
  {
    b(a parama) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(75869);
      this.BYD.BYB.invoke();
      AppMethodBeat.o(75869);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.a
 * JD-Core Version:    0.7.0.1
 */