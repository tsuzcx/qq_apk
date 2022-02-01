package com.tencent.mm.plugin.recordvideo.plugin.cropvideo;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.a.d;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
final class a$f
  implements DialogInterface.OnClickListener
{
  a$f(a parama, boolean paramBoolean) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(75688);
    if (this.xCC)
    {
      paramDialogInterface = c.xHa;
      c.u("KEY_WESEE_DIALOG_OPERATION", Integer.valueOf(2));
    }
    for (;;)
    {
      ad.i("MicroMsg.EditCropVideoPlugin", "dialog cancel");
      if (a.b(this.xCB) == null) {
        break label120;
      }
      paramDialogInterface = a.b(this.xCB);
      if (paramDialogInterface != null) {
        break;
      }
      paramDialogInterface = new v("null cannot be cast to non-null type android.app.Dialog");
      AppMethodBeat.o(75688);
      throw paramDialogInterface;
      paramDialogInterface = c.xHa;
      c.u("KEY_WESEE_DIALOG_OPERATION", Integer.valueOf(4));
    }
    if (((Dialog)paramDialogInterface).isShowing())
    {
      paramDialogInterface = a.b(this.xCB);
      if (paramDialogInterface != null) {
        paramDialogInterface.dismiss();
      }
      ad.i("MicroMsg.EditCropVideoPlugin", "click no dismiss dialog");
    }
    label120:
    AppMethodBeat.o(75688);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a.f
 * JD-Core Version:    0.7.0.1
 */