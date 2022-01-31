package com.tencent.mm.plugin.offline.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.ui.base.h;

final class c$9
  implements DialogInterface.OnClickListener
{
  c$9(c paramc) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(43479);
    paramDialogInterface.dismiss();
    a.bZH();
    h.bO(this.pmw.mActivity, this.pmw.mActivity.getResources().getString(2131305738));
    c.a(this.pmw);
    AppMethodBeat.o(43479);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.c.9
 * JD-Core Version:    0.7.0.1
 */