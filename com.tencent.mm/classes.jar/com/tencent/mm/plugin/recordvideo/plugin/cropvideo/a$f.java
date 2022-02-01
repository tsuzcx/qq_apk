package com.tencent.mm.plugin.recordvideo.plugin.cropvideo;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.d;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
final class a$f
  implements DialogInterface.OnClickListener
{
  a$f(a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(237356);
    Log.i("MicroMsg.EditCropVideoPlugin", "dialog cancel");
    if (a.j(this.BSH) != null)
    {
      paramDialogInterface = a.j(this.BSH);
      if (paramDialogInterface == null)
      {
        paramDialogInterface = new t("null cannot be cast to non-null type android.app.Dialog");
        AppMethodBeat.o(237356);
        throw paramDialogInterface;
      }
      if (((Dialog)paramDialogInterface).isShowing())
      {
        paramDialogInterface = a.j(this.BSH);
        if (paramDialogInterface != null) {
          paramDialogInterface.dismiss();
        }
        Log.i("MicroMsg.EditCropVideoPlugin", "click no dismiss dialog");
      }
    }
    AppMethodBeat.o(237356);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a.f
 * JD-Core Version:    0.7.0.1
 */