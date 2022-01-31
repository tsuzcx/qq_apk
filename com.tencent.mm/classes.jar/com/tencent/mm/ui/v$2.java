package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.b;

final class v$2
  implements DialogInterface.OnCancelListener
{
  v$2(String paramString, Activity paramActivity, Intent paramIntent) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(29595);
    h.qsU.idkeyStat(322L, 24L, 1L, true);
    h.qsU.e(11098, new Object[] { Integer.valueOf(4024), String.format("%b|%s", new Object[] { Boolean.valueOf(bo.isNullOrNil(this.val$url)), this.val$url }) });
    this.val$activity.startActivity(this.zbT);
    b.K(this.val$activity, this.zbT);
    w.ct(this.val$activity);
    AppMethodBeat.o(29595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.v.2
 * JD-Core Version:    0.7.0.1
 */