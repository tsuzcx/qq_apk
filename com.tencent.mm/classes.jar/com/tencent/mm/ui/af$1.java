package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bi.b;
import com.tencent.mm.bi.d;
import com.tencent.mm.g.a.fo;
import com.tencent.mm.g.a.xq;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.ui.contact.VoipAddressUI;

final class af$1
  implements DialogInterface.OnClickListener
{
  af$1(af paramaf) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(33686);
    Object localObject = new xq();
    ((xq)localObject).edR.edU = true;
    EventCenter.instance.publish((IEvent)localObject);
    localObject = new fo();
    ((fo)localObject).dIN.username = d.jpB.bgL();
    EventCenter.instance.publish((IEvent)localObject);
    VoipAddressUI.kp(af.b(this.OKm));
    paramDialogInterface.dismiss();
    AppMethodBeat.o(33686);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.af.1
 * JD-Core Version:    0.7.0.1
 */