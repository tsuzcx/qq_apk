package com.tencent.mm.plugin.subapp.ui.voicereminder;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.an;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.subapp.b;
import com.tencent.mm.plugin.subapp.c.d;
import com.tencent.mm.pluginsdk.n;

final class RemindDialog$2
  implements DialogInterface.OnClickListener
{
  RemindDialog$2(RemindDialog paramRemindDialog) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(25560);
    paramDialogInterface = d.cGS();
    if (paramDialogInterface != null) {
      paramDialogInterface.pn(RemindDialog.c(this.sZX));
    }
    if (t.or(aw.getNotification().IF()))
    {
      this.sZX.finish();
      AppMethodBeat.o(25560);
      return;
    }
    b.gmO.d(new Intent().putExtra("Chat_User", RemindDialog.c(this.sZX)), this.sZX);
    this.sZX.finish();
    AppMethodBeat.o(25560);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicereminder.RemindDialog.2
 * JD-Core Version:    0.7.0.1
 */