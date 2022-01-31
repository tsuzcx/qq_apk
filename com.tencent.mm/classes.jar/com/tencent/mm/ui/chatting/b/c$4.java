package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.protocal.c.iq;
import com.tencent.mm.protocal.c.ir;
import java.util.LinkedList;

final class c$4
  implements DialogInterface.OnClickListener
{
  c$4(c paramc, LinkedList paramLinkedList) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new ir();
    paramInt = 0;
    while (paramInt < this.voM.size())
    {
      iq localiq = new iq();
      localiq.sCP = ((String)this.voM.get(paramInt));
      paramDialogInterface.sCQ.add(localiq);
      paramInt += 1;
    }
    c.a(this.voK, paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.c.4
 * JD-Core Version:    0.7.0.1
 */