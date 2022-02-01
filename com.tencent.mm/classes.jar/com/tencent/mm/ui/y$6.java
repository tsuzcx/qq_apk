package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.b;

final class y$6
  implements DialogInterface.OnCancelListener
{
  y$6(String paramString, Activity paramActivity, Intent paramIntent) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(33442);
    g.yxI.idkeyStat(322L, 24L, 1L, true);
    g.yxI.f(11098, new Object[] { Integer.valueOf(4024), String.format("%b|%s", new Object[] { Boolean.valueOf(bu.isNullOrNil(this.val$url)), this.val$url }) });
    paramDialogInterface = this.val$activity;
    Object localObject = this.Jxb;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/MMErrorProcessor$7", "onCancel", "(Landroid/content/DialogInterface;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, "com/tencent/mm/ui/MMErrorProcessor$7", "onCancel", "(Landroid/content/DialogInterface;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    b.am(this.val$activity, this.Jxb);
    t.cX(this.val$activity);
    AppMethodBeat.o(33442);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.y.6
 * JD-Core Version:    0.7.0.1
 */