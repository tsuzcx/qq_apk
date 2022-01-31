package com.tencent.mm.ui.chatting.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.kr;
import com.tencent.mm.protocal.protobuf.ks;
import java.util.LinkedList;

final class c$4
  implements DialogInterface.OnClickListener
{
  c$4(c paramc, LinkedList paramLinkedList) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(31196);
    paramDialogInterface = new ks();
    paramInt = 0;
    while (paramInt < this.zEo.size())
    {
      kr localkr = new kr();
      localkr.wyi = ((String)this.zEo.get(paramInt));
      paramDialogInterface.wyj.add(localkr);
      paramInt += 1;
    }
    c.a(this.zEm, paramDialogInterface);
    AppMethodBeat.o(31196);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.c.4
 * JD-Core Version:    0.7.0.1
 */