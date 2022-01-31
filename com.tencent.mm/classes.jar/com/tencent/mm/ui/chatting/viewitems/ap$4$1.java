package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.subapp.c.e;
import com.tencent.mm.protocal.protobuf.crf;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import java.util.LinkedList;

final class ap$4$1
  implements DialogInterface.OnClickListener
{
  ap$4$1(ap.4 param4) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(33388);
    aw.Rc().a(331, ap.a(this.zYd.zYa, new ap.4.1.1(this)));
    paramDialogInterface = new LinkedList();
    Object localObject = new crf();
    ((crf)localObject).wpU = this.zYd.zYc.sXn;
    paramDialogInterface.add(localObject);
    paramDialogInterface = new com.tencent.mm.plugin.subapp.c.a(paramDialogInterface, paramDialogInterface.size());
    aw.Rc().a(paramDialogInterface, 0);
    localObject = this.zYd.zYa;
    Activity localActivity = ap.a(this.zYd.zYa).zJz.getContext();
    ap.a(this.zYd.zYa).zJz.getMMResources().getString(2131297087);
    ap.a((ap)localObject, h.b(localActivity, ap.a(this.zYd.zYa).zJz.getMMResources().getString(2131298221), true, new ap.4.1.2(this, paramDialogInterface)));
    AppMethodBeat.o(33388);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ap.4.1
 * JD-Core Version:    0.7.0.1
 */