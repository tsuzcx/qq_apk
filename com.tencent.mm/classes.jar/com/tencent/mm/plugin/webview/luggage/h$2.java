package com.tencent.mm.plugin.webview.luggage;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;

final class h$2
  implements DialogInterface.OnCancelListener
{
  h$2(h paramh) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(6121);
    if (this.uSc.iha != null)
    {
      paramDialogInterface = new Bundle();
      paramDialogInterface.putInt("type", 2);
      paramDialogInterface.putString("img_path", this.uSc.iha.uYi);
      f.a("com.tencent.mm", paramDialogInterface, h.c.class, null);
      this.uSc.iha.dcJ();
    }
    AppMethodBeat.o(6121);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.h.2
 * JD-Core Version:    0.7.0.1
 */