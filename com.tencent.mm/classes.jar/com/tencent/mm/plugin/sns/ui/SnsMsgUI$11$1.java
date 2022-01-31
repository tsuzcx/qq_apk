package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.k;

final class SnsMsgUI$11$1
  implements DialogInterface.OnClickListener
{
  SnsMsgUI$11$1(SnsMsgUI.11 param11) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(39076);
    SnsMsgUI.c(this.rSX.rSU).setVisibility(8);
    SnsMsgUI.d(this.rSX.rSU).setVisibility(0);
    ag.cpk().fnw.execSQL("SnsComment", "delete from SnsComment");
    this.rSX.rSU.enableOptionMenu(false);
    AppMethodBeat.o(39076);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.11.1
 * JD-Core Version:    0.7.0.1
 */