package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.ui.base.k;

final class h$2
  implements Runnable
{
  h$2(Context paramContext) {}
  
  public final void run()
  {
    AppMethodBeat.i(151680);
    k.cZ(this.val$context, this.val$context.getString(c.h.chatting_send_app_not_installed));
    AppMethodBeat.o(151680);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.h.2
 * JD-Core Version:    0.7.0.1
 */