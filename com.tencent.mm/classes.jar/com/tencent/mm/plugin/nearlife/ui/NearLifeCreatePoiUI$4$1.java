package com.tencent.mm.plugin.nearlife.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;

final class NearLifeCreatePoiUI$4$1
  implements DialogInterface.OnCancelListener
{
  NearLifeCreatePoiUI$4$1(NearLifeCreatePoiUI.4 param4) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(22974);
    aw.Rc().a(NearLifeCreatePoiUI.c(this.pfM.pfL));
    AppMethodBeat.o(22974);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.NearLifeCreatePoiUI.4.1
 * JD-Core Version:    0.7.0.1
 */