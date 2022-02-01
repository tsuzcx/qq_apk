package com.tencent.mm.ui.chatting.gallery;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$4
  implements Runnable
{
  b$4(Context paramContext) {}
  
  public final void run()
  {
    AppMethodBeat.i(194132);
    if (this.JPy) {
      Toast.makeText(this.val$context, this.val$context.getString(2131764682), 1).show();
    }
    if (this.JPz != null) {
      this.JPz.run();
    }
    AppMethodBeat.o(194132);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.b.4
 * JD-Core Version:    0.7.0.1
 */