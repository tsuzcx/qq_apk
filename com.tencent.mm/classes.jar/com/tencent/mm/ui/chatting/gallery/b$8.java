package com.tencent.mm.ui.chatting.gallery;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$8
  implements Runnable
{
  b$8(boolean paramBoolean, Context paramContext) {}
  
  public final void run()
  {
    AppMethodBeat.i(187473);
    if (this.KkL) {
      Toast.makeText(this.val$context, this.val$context.getString(2131762779), 1).show();
    }
    if (this.KkM != null) {
      this.KkM.run();
    }
    AppMethodBeat.o(187473);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.b.8
 * JD-Core Version:    0.7.0.1
 */