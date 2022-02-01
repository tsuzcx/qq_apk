package com.tencent.mm.plugin.recordvideo.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.p;
import d.g.b.k;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/ui/MediaProgressDialog;", "", "()V", "loading", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mCancel", "Lkotlin/Function0;", "", "dismiss", "setCancelable", "enable", "", "setOnCancel", "onCancel", "show", "context", "Landroid/content/Context;", "cancelAble", "tip", "", "cancel", "plugin-recordvideo_release"})
public final class a
{
  private p pne;
  public d.g.a.a<y> wyD;
  
  public a()
  {
    AppMethodBeat.i(75872);
    this.wyD = ((d.g.a.a)a.a.wyE);
    AppMethodBeat.o(75872);
  }
  
  public final void a(Context paramContext, d.g.a.a<y> parama)
  {
    AppMethodBeat.i(75870);
    k.h(paramContext, "context");
    k.h(parama, "cancel");
    this.wyD = parama;
    if (this.pne == null) {
      this.pne = p.a(paramContext, (CharSequence)paramContext.getString(2131762543), false, 0, (DialogInterface.OnCancelListener)new b(this));
    }
    AppMethodBeat.o(75870);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(75871);
    p localp = this.pne;
    if (localp != null) {
      localp.dismiss();
    }
    this.pne = null;
    AppMethodBeat.o(75871);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class b
    implements DialogInterface.OnCancelListener
  {
    b(a parama) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(75869);
      this.wyF.wyD.invoke();
      AppMethodBeat.o(75869);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.a
 * JD-Core Version:    0.7.0.1
 */