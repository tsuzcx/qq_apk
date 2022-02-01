package com.tencent.mm.ui.chatting.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.nl;
import com.tencent.mm.protocal.protobuf.nm;
import java.util.LinkedList;

final class c$5
  implements DialogInterface.OnClickListener
{
  c$5(c paramc, LinkedList paramLinkedList) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(35088);
    paramDialogInterface = new nm();
    paramInt = 0;
    while (paramInt < this.WHj.size())
    {
      nl localnl = new nl();
      localnl.RUq = ((String)this.WHj.get(paramInt));
      paramDialogInterface.RUr.add(localnl);
      paramInt += 1;
    }
    c.a(this.WHh, paramDialogInterface);
    AppMethodBeat.o(35088);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.c.5
 * JD-Core Version:    0.7.0.1
 */