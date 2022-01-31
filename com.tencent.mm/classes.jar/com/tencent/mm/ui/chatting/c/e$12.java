package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.roomsdk.a.b;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import java.util.LinkedList;

final class e$12
  implements DialogInterface.OnClickListener
{
  e$12(e parame, LinkedList paramLinkedList) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(31256);
    paramDialogInterface = b.aoI(this.zEC.caz.getTalkerUserName()).a(this.zEC.caz.getTalkerUserName(), this.zEo, this.fwD);
    paramDialogInterface.b(new e.12.1(this));
    paramDialogInterface.c(new e.12.2(this));
    Activity localActivity = this.zEC.caz.zJz.getContext();
    this.zEC.caz.zJz.getMMResources().getString(2131297087);
    paramDialogInterface.a(localActivity, this.zEC.caz.zJz.getMMResources().getString(2131302684), true, new e.12.3(this, paramDialogInterface));
    AppMethodBeat.o(31256);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.e.12
 * JD-Core Version:    0.7.0.1
 */