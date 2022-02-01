package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.util.b;
import com.tencent.mm.plugin.recordvideo.util.k;
import com.tencent.mm.plugin.recordvideo.util.l;

final class SnsTimeLineUI$66
  implements DialogInterface.OnClickListener
{
  SnsTimeLineUI$66(boolean paramBoolean, Activity paramActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(99356);
    SnsTimeLineUI.cb(this.Rvx, true);
    if (this.Rvx)
    {
      paramDialogInterface = l.ObI;
      paramDialogInterface = k.ObH;
      paramDialogInterface = l.gH("moments", k.gLn());
      localObject = l.ObI;
      l.aG(this.val$activity, paramDialogInterface);
      AppMethodBeat.o(99356);
      return;
    }
    paramDialogInterface = b.Obj;
    paramDialogInterface = this.val$activity;
    Object localObject = new StringBuilder();
    k localk = k.ObH;
    b.aL(paramDialogInterface, k.gLo() + "1101");
    AppMethodBeat.o(99356);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.66
 * JD-Core Version:    0.7.0.1
 */