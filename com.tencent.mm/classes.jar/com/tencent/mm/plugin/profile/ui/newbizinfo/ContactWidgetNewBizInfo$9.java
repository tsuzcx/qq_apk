package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.event.EventCenter;

final class ContactWidgetNewBizInfo$9
  implements DialogInterface.OnCancelListener
{
  ContactWidgetNewBizInfo$9(ContactWidgetNewBizInfo paramContactWidgetNewBizInfo, q paramq) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(231946);
    bg.azz().b(536, this.Bjh);
    paramDialogInterface = new dr();
    paramDialogInterface.dGF.opType = 2;
    paramDialogInterface.dGF.dGJ = this.dAK;
    EventCenter.instance.publish(paramDialogInterface);
    AppMethodBeat.o(231946);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo.9
 * JD-Core Version:    0.7.0.1
 */