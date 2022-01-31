package com.tencent.mm.ui.chatting.h;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.h.a.cj.a;
import com.tencent.mm.protocal.c.yj;
import java.util.LinkedList;
import java.util.List;

final class e$4
  implements DialogInterface.OnClickListener
{
  e$4(e parame, cj paramcj, List paramList) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.vpx.bIw.type == 14) && (this.vpx.bIw.bIy.sXc.size() == 0)) {
      return;
    }
    e.a(this.vyV, this.vpx);
    e.eh(this.gFL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.e.4
 * JD-Core Version:    0.7.0.1
 */