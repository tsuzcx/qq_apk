package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.h.a.cj.a;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.storage.bi;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class j$6$7
  implements DialogInterface.OnClickListener
{
  j$6$7(j.6 param6, List paramList, cj paramcj) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.vjn.iterator();
    while (paramDialogInterface.hasNext())
    {
      bi localbi = (bi)paramDialogInterface.next();
      if ((!localbi.cvp()) && (!localbi.cvo()))
      {
        if ((this.vpx.bIw.type != 14) || (this.vpx.bIw.bIy.sXc.size() != 0)) {
          break label88;
        }
        this.vpw.vpr.cEf();
      }
    }
    return;
    label88:
    j.6.a(this.vpw, this.vpx);
    j.6.dX(j.c(this.vpw.vpr));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.j.6.7
 * JD-Core Version:    0.7.0.1
 */