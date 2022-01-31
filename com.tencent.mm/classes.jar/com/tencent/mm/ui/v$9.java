package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.y;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.base.b;

final class v$9
  implements DialogInterface.OnClickListener
{
  v$9(Intent paramIntent, Activity paramActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(29603);
    if (this.zbT != null)
    {
      if (!(this.gjR instanceof LauncherUI)) {
        this.gjR.finish();
      }
      this.gjR.startActivity(this.zbT);
      b.K(this.gjR, this.zbT);
      w.ct(this.gjR);
      paramDialogInterface = new y();
      paramDialogInterface.cne.cnf = true;
      a.ymk.l(paramDialogInterface);
    }
    AppMethodBeat.o(29603);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.v.9
 * JD-Core Version:    0.7.0.1
 */