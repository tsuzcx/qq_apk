package com.tencent.mm.plugin.webview.luggage;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.webview.modeltools.h;

final class i$2
  implements DialogInterface.OnCancelListener
{
  i$2(i parami) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.rcq.gGt != null)
    {
      paramDialogInterface = new Bundle();
      paramDialogInterface.putInt("type", 2);
      paramDialogInterface.putString("img_path", this.rcq.gGt.riI);
      f.a("com.tencent.mm", paramDialogInterface, i.c.class, null);
      this.rcq.gGt.ccQ();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.i.2
 * JD-Core Version:    0.7.0.1
 */