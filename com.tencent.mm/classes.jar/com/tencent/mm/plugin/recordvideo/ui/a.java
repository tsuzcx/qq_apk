package com.tencent.mm.plugin.recordvideo.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/MediaProgressDialog;", "", "()V", "loading", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mCancel", "Lkotlin/Function0;", "", "dismiss", "setCancelable", "enable", "", "setOnCancel", "onCancel", "show", "context", "Landroid/content/Context;", "cancelAble", "tip", "", "cancel", "plugin-recordvideo_release"})
public final class a
{
  private com.tencent.mm.ui.base.p pXj;
  public d.g.a.a<z> xXJ;
  
  public a()
  {
    AppMethodBeat.i(75872);
    this.xXJ = ((d.g.a.a)a.a.xXK);
    AppMethodBeat.o(75872);
  }
  
  public final void a(Context paramContext, d.g.a.a<z> parama)
  {
    AppMethodBeat.i(75870);
    d.g.b.p.h(paramContext, "context");
    d.g.b.p.h(parama, "cancel");
    this.xXJ = parama;
    if (this.pXj == null) {
      this.pXj = com.tencent.mm.ui.base.p.a(paramContext, (CharSequence)paramContext.getString(2131762543), false, 0, (DialogInterface.OnCancelListener)new b(this));
    }
    AppMethodBeat.o(75870);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(75871);
    com.tencent.mm.ui.base.p localp = this.pXj;
    if (localp != null) {
      localp.dismiss();
    }
    this.pXj = null;
    AppMethodBeat.o(75871);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class b
    implements DialogInterface.OnCancelListener
  {
    b(a parama) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(75869);
      this.xXL.xXJ.invoke();
      AppMethodBeat.o(75869);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.a
 * JD-Core Version:    0.7.0.1
 */