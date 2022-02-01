package com.tencent.mm.plugin.recordvideo.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.p;
import d.g.b.k;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/ui/MediaProgressDialog;", "", "()V", "loading", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mCancel", "Lkotlin/Function0;", "", "dismiss", "setCancelable", "enable", "", "setOnCancel", "onCancel", "show", "context", "Landroid/content/Context;", "cancelAble", "tip", "", "cancel", "plugin-recordvideo_release"})
public final class a
{
  private p oJG;
  public d.g.a.a<y> vpM;
  
  public a()
  {
    AppMethodBeat.i(75872);
    this.vpM = ((d.g.a.a)a.vpN);
    AppMethodBeat.o(75872);
  }
  
  public final void a(Context paramContext, d.g.a.a<y> parama)
  {
    AppMethodBeat.i(75870);
    k.h(paramContext, "context");
    k.h(parama, "cancel");
    this.vpM = parama;
    if (this.oJG == null) {
      this.oJG = p.a(paramContext, (CharSequence)paramContext.getString(2131762543), false, 0, (DialogInterface.OnCancelListener)new b(this));
    }
    AppMethodBeat.o(75870);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(75871);
    p localp = this.oJG;
    if (localp != null) {
      localp.dismiss();
    }
    this.oJG = null;
    AppMethodBeat.o(75871);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public static final a vpN;
    
    static
    {
      AppMethodBeat.i(75868);
      vpN = new a();
      AppMethodBeat.o(75868);
    }
    
    a()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class b
    implements DialogInterface.OnCancelListener
  {
    b(a parama) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(75869);
      this.vpO.vpM.invoke();
      AppMethodBeat.o(75869);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.a
 * JD-Core Version:    0.7.0.1
 */