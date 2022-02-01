package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.ui.MMActivity;

final class a$7
  implements Runnable
{
  a$7(TextView paramTextView, Context paramContext) {}
  
  public final void run()
  {
    AppMethodBeat.i(71460);
    if ((this.PeT) && (this.PeX != null) && (d.qV(28))) {
      this.PeX.requestFocus();
    }
    ((MMActivity)this.val$context).showVKB();
    AppMethodBeat.o(71460);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.a.7
 * JD-Core Version:    0.7.0.1
 */