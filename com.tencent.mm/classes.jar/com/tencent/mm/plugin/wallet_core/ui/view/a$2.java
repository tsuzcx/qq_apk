package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.ui.MMActivity;

final class a$2
  implements Runnable
{
  a$2(boolean paramBoolean, EditText paramEditText, Context paramContext) {}
  
  public final void run()
  {
    AppMethodBeat.i(71454);
    if ((this.PeT) && (this.PeR != null) && (d.qV(28))) {
      this.PeR.requestFocus();
    }
    ((MMActivity)this.val$context).showVKB();
    AppMethodBeat.o(71454);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.a.2
 * JD-Core Version:    0.7.0.1
 */