package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.h;
import java.util.Iterator;
import java.util.List;

final class m$4$9
  implements DialogInterface.OnClickListener
{
  m$4$9(m.4 param4, MenuItem paramMenuItem) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(30602);
    paramDialogInterface = this.zyA.zym;
    if ((paramDialogInterface == null) || (paramDialogInterface.isEmpty())) {
      ab.w("MicroMsg.ChattingEditModeLogic", "check contain only invalid send to brand service error, select item empty");
    }
    label34:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0) {
        break label184;
      }
      ab.w("MicroMsg.ChattingEditModeSendToBrand", "only contain invalid msg, exit long click mode");
      if (this.zyA.zyz != null) {
        this.zyA.zyz.dHU();
      }
      AppMethodBeat.o(30602);
      return;
      paramDialogInterface = paramDialogInterface.iterator();
      if (!paramDialogInterface.hasNext()) {
        break label34;
      }
      bi localbi = (bi)paramDialogInterface.next();
      if (j.aB(localbi)) {
        break label34;
      }
      if ((localbi.dvW()) || (j.aw(localbi)) || (localbi.dxR()) || (j.ay(localbi)) || (j.az(localbi)) || (localbi.getType() == -1879048186) || (j.aG(localbi)) || (j.aA(localbi)) || (j.aF(localbi)) || (j.aJ(localbi))) {
        break;
      }
    }
    label184:
    paramDialogInterface = this.zyA.val$context;
    this.zyA.val$context.getString(2131297087);
    m.a(h.b(paramDialogInterface, this.zyA.val$context.getString(2131303124), false, null));
    com.tencent.mm.ui.chatting.c.j.zEQ.e(new m.b(this.zyA.zyx, this.zyA.val$context, this.zyB.getTitle(), -1L, m.dGo()));
    if (this.zyA.zyz != null) {
      this.zyA.zyz.dHU();
    }
    AppMethodBeat.o(30602);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m.4.9
 * JD-Core Version:    0.7.0.1
 */