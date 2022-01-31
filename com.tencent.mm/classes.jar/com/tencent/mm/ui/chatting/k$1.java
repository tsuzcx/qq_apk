package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.t;
import com.tencent.mm.af.t.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import java.util.Iterator;
import java.util.List;

final class k$1
  implements DialogInterface.OnClickListener
{
  k$1(List paramList, t paramt, Context paramContext, boolean paramBoolean, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(30574);
    paramDialogInterface = this.zym;
    if ((paramDialogInterface == null) || (paramDialogInterface.isEmpty())) {
      ab.w("MicroMsg.ChattingEditModeLogic", "check contain only invalid send to friend msg error, select item empty");
    }
    label31:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0) {
        break label189;
      }
      ab.w("MicroMsg.ChattingEditModeRetransmitMsg", "only contain invalid msg, exit long click mode");
      if (this.zyn != null) {
        this.zyn.c(t.a.fke);
      }
      AppMethodBeat.o(30574);
      return;
      paramDialogInterface = paramDialogInterface.iterator();
      if (!paramDialogInterface.hasNext()) {
        break label31;
      }
      bi localbi = (bi)paramDialogInterface.next();
      if (j.aB(localbi)) {
        break label31;
      }
      if ((localbi.dvW()) || (j.aw(localbi)) || (j.ay(localbi)) || (j.aH(localbi)) || (j.az(localbi)) || (localbi.getType() == -1879048186) || (j.aG(localbi)) || (j.aA(localbi)) || (j.aF(localbi)) || (j.aB(localbi)) || (localbi.getType() == 318767153)) {
        break;
      }
    }
    label189:
    k.c(this.val$context, this.zym, this.zyo, this.zyp, this.zyn);
    AppMethodBeat.o(30574);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.1
 * JD-Core Version:    0.7.0.1
 */