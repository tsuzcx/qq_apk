package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.MenuItem;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.b.j;
import java.util.Iterator;
import java.util.List;

final class n$4$9
  implements DialogInterface.OnClickListener
{
  n$4$9(n.4 param4, MenuItem paramMenuItem) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.vjB.vjn;
    if ((paramDialogInterface == null) || (paramDialogInterface.isEmpty()))
    {
      y.w("MicroMsg.ChattingEditModeLogic", "check contain only invalid send to brand service error, select item empty");
      break label69;
      label28:
      paramInt = 1;
      label30:
      if (paramInt == 0) {
        break label172;
      }
      y.w("MicroMsg.ChattingEditModeSendToBrand", "only contain invalid msg, exit long click mode");
      if (this.vjB.vjA != null) {
        this.vjB.vjA.cEf();
      }
    }
    label69:
    do
    {
      return;
      paramDialogInterface = paramDialogInterface.iterator();
      if (!paramDialogInterface.hasNext()) {
        break label28;
      }
      bi localbi = (bi)paramDialogInterface.next();
      if (k.at(localbi)) {
        break label28;
      }
      if ((localbi.ctA()) || (k.ao(localbi)) || (localbi.cvn()) || (k.aq(localbi)) || (k.ar(localbi)) || (localbi.getType() == -1879048186) || (k.ay(localbi)) || (k.as(localbi)) || (k.ax(localbi)) || (k.aB(localbi))) {
        break;
      }
      paramInt = 0;
      break label30;
      paramDialogInterface = this.vjB.val$context;
      this.vjB.val$context.getString(R.l.app_tip);
      n.a(h.b(paramDialogInterface, this.vjB.val$context.getString(R.l.sending_message), false, null));
      j.vpo.c(new n.b(this.vjB.vjy, this.vjB.val$context, this.vjC.getTitle(), -1L, n.cCB()));
    } while (this.vjB.vjA == null);
    label172:
    this.vjB.vjA.cEf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.n.4.9
 * JD-Core Version:    0.7.0.1
 */