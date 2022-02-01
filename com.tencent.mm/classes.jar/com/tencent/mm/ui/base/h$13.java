package com.tencent.mm.ui.base;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

final class h$13
  implements Runnable
{
  h$13(Context paramContext) {}
  
  public final void run()
  {
    AppMethodBeat.i(222817);
    ((MMActivity)this.val$context).showVKB();
    AppMethodBeat.o(222817);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.h.13
 * JD-Core Version:    0.7.0.1
 */