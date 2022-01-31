package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

final class a$7
  implements Runnable
{
  a$7(Context paramContext) {}
  
  public final void run()
  {
    AppMethodBeat.i(47860);
    ((MMActivity)this.val$context).showVKB();
    AppMethodBeat.o(47860);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.a.7
 * JD-Core Version:    0.7.0.1
 */