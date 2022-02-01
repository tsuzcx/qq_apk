package com.tencent.mm.ui.chatting.gallery;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.bl;

final class b$3
  implements Runnable
{
  b$3(Context paramContext, bl parambl) {}
  
  public final void run()
  {
    AppMethodBeat.i(191545);
    b.b(this.val$context, this.gLQ, this.GAo);
    if (this.GAp != null) {
      this.GAp.run();
    }
    AppMethodBeat.o(191545);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.b.3
 * JD-Core Version:    0.7.0.1
 */