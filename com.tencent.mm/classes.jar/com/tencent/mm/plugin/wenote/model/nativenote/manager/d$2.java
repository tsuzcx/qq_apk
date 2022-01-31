package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$2
  implements Runnable
{
  d$2(d paramd, Context paramContext, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(26755);
    Toast.makeText(this.val$context, this.val$tips, 0).show();
    AppMethodBeat.o(26755);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.d.2
 * JD-Core Version:    0.7.0.1
 */