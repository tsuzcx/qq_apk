package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.e.a;
import com.tencent.mm.plugin.recordvideo.e.h;
import com.tencent.mm.plugin.recordvideo.e.i;

final class SnsTimeLineUI$61
  implements DialogInterface.OnClickListener
{
  SnsTimeLineUI$61(SnsTimeLineUI paramSnsTimeLineUI, boolean paramBoolean) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(99352);
    SnsTimeLineUI.c(this.Lao, true);
    if (this.KVA)
    {
      paramDialogInterface = i.Ifo;
      paramDialogInterface = h.Ifn;
      paramDialogInterface = i.fO("moments", h.fzB());
      localObject = i.Ifo;
      i.ax(this.Lao, paramDialogInterface);
      AppMethodBeat.o(99352);
      return;
    }
    paramDialogInterface = a.IeL;
    paramDialogInterface = this.Lao;
    Object localObject = new StringBuilder();
    h localh = h.Ifn;
    a.aK(paramDialogInterface, h.fzC() + "1101");
    AppMethodBeat.o(99352);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.61
 * JD-Core Version:    0.7.0.1
 */