package com.tencent.mm.pluginsdk.ui.applet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;

final class g$17
  implements DialogInterface.OnClickListener
{
  g$17(q.a parama, View paramView) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.sch != null) {
      this.sch.a(true, g.du(this.val$view), g.dv(this.val$view));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.g.17
 * JD-Core Version:    0.7.0.1
 */