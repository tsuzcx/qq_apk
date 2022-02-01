package com.tencent.mm.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.h;

final class h$4
  implements Runnable
{
  h$4(Context paramContext, Intent paramIntent) {}
  
  public final void run()
  {
    AppMethodBeat.i(33023);
    try
    {
      h.b(this.val$context, this.val$intent, this.val$context.getString(2131758749));
      AppMethodBeat.o(33023);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(33023);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.h.4
 * JD-Core Version:    0.7.0.1
 */