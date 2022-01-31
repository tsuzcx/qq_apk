package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.ui.base.b;

final class v$6
  implements DialogInterface.OnClickListener
{
  v$6(Intent paramIntent, Activity paramActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(29600);
    if (this.zbT != null)
    {
      this.gjR.finish();
      this.gjR.startActivity(this.zbT);
      b.K(this.gjR, this.zbT);
      w.ct(this.gjR);
    }
    AppMethodBeat.o(29600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.v.6
 * JD-Core Version:    0.7.0.1
 */