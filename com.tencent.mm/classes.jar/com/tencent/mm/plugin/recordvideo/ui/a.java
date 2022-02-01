package com.tencent.mm.plugin.recordvideo.ui;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.w;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/MediaProgressDialog;", "", "()V", "loading", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mCancel", "Lkotlin/Function0;", "", "dismiss", "isShowing", "", "setCancelable", "enable", "setOnCancel", "onCancel", "show", "context", "Landroid/content/Context;", "cancelAble", "tip", "", "cancel", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public kotlin.g.a.a<ah> NSe;
  private w xEL;
  
  public a()
  {
    AppMethodBeat.i(75872);
    this.NSe = ((kotlin.g.a.a)a.a.NSf);
    AppMethodBeat.o(75872);
  }
  
  private static final void a(a parama, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(279760);
    s.u(parama, "this$0");
    parama.NSe.invoke();
    AppMethodBeat.o(279760);
  }
  
  public final void a(Context paramContext, int paramInt, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(279769);
    s.u(paramContext, "context");
    s.u(parama, "cancel");
    this.NSe = parama;
    if (this.xEL == null) {
      this.xEL = w.a(paramContext, (CharSequence)paramContext.getString(paramInt), false, 0, new a..ExternalSyntheticLambda0(this));
    }
    AppMethodBeat.o(279769);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(75871);
    w localw = this.xEL;
    if (localw != null) {
      localw.dismiss();
    }
    this.xEL = null;
    AppMethodBeat.o(75871);
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(279776);
    w localw = this.xEL;
    if (localw == null)
    {
      AppMethodBeat.o(279776);
      return false;
    }
    boolean bool = localw.isShowing();
    AppMethodBeat.o(279776);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.a
 * JD-Core Version:    0.7.0.1
 */