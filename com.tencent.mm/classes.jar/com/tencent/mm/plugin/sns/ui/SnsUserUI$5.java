package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.o;

final class SnsUserUI$5
  implements DialogInterface.OnClickListener
{
  SnsUserUI$5(SnsUserUI paramSnsUserUI, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(39789);
    ag.cpf().EA(this.riX);
    SnsUserUI.a(this.sce).ctD();
    AppMethodBeat.o(39789);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUserUI.5
 * JD-Core Version:    0.7.0.1
 */