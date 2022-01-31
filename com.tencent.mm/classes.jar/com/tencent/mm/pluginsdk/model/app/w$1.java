package com.tencent.mm.pluginsdk.model.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.z.a;
import com.tencent.mm.sdk.platformtools.y;

public final class w$1
  implements DialogInterface.OnCancelListener
{
  public w$1(w paramw) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    y.w("MicroMsg.LoadAppInfoAfterLogin", "do init canceled");
    g.Dk().c(this.rUx.bJk);
    a.brq().b(7, this.rUx);
    if (this.rUx.rUw != null) {
      this.rUx.rUw.Yw();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.w.1
 * JD-Core Version:    0.7.0.1
 */