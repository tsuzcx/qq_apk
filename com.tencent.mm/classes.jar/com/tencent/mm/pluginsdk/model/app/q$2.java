package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class q$2
  implements Runnable
{
  q$2(Context paramContext) {}
  
  public final void run()
  {
    AppMethodBeat.i(162008);
    Toast.makeText(this.val$context, this.val$context.getString(2131761810), 1).show();
    AppMethodBeat.o(162008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.q.2
 * JD-Core Version:    0.7.0.1
 */