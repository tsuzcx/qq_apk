package com.tencent.mm.ui.chatting.gallery;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$6
  implements Runnable
{
  b$6(boolean paramBoolean, Context paramContext) {}
  
  public final void run()
  {
    AppMethodBeat.i(194134);
    if (this.JPy) {
      Toast.makeText(this.val$context, this.val$context.getString(2131762779), 1).show();
    }
    if (this.JPz != null) {
      this.JPz.run();
    }
    AppMethodBeat.o(194134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.b.6
 * JD-Core Version:    0.7.0.1
 */