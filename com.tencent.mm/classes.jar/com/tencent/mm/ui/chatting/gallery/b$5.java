package com.tencent.mm.ui.chatting.gallery;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.bl;

final class b$5
  implements Runnable
{
  b$5(Context paramContext, bl parambl, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(191547);
    b.d(this.val$context, this.gLQ, this.GAo);
    if (this.GAp != null) {
      this.GAp.run();
    }
    AppMethodBeat.o(191547);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.b.5
 * JD-Core Version:    0.7.0.1
 */