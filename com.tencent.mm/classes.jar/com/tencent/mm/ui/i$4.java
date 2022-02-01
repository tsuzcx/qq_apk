package com.tencent.mm.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.pluginsdk.model.app.h;

final class i$4
  implements Runnable
{
  i$4(Context paramContext, Intent paramIntent) {}
  
  public final void run()
  {
    AppMethodBeat.i(33023);
    try
    {
      h.b(this.val$context, this.val$intent, this.val$context.getString(R.l.enterprise_wework_apk));
      return;
    }
    finally
    {
      AppMethodBeat.o(33023);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.i.4
 * JD-Core Version:    0.7.0.1
 */