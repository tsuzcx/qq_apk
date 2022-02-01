package com.tencent.mm.plugin.profile;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bk.b;
import com.tencent.mm.bk.d;
import com.tencent.mm.f.a.fv;
import com.tencent.mm.f.a.yx;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.as;

final class a$3
  implements DialogInterface.OnClickListener
{
  a$3(a parama, as paramas) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(26822);
    Object localObject = new yx();
    ((yx)localObject).fYg.fYj = true;
    EventCenter.instance.publish((IEvent)localObject);
    localObject = new fv();
    ((fv)localObject).fBE.username = d.meW.bqa();
    EventCenter.instance.publish((IEvent)localObject);
    this.GWs.a(this.jkl, this.GWs.tmY);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(26822);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.3
 * JD-Core Version:    0.7.0.1
 */