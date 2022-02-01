package com.tencent.mm.ui.l.b;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class a$1
  implements Runnable
{
  a$1(String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(234453);
    Toast.makeText(MMApplicationContext.getContext(), "debug me err msg: " + this.val$msg, 0).show();
    AppMethodBeat.o(234453);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.l.b.a.1
 * JD-Core Version:    0.7.0.1
 */