package com.tencent.mm.plugin.webview.luggage.ipc;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;

public final class b
{
  public static <T extends c> void a(MMActivity paramMMActivity, Bundle paramBundle, Class<T> paramClass, a parama)
  {
    AppMethodBeat.i(78488);
    Intent localIntent = new Intent();
    localIntent.putExtra("task_class_name", paramClass.getName());
    localIntent.putExtra("input_data", paramBundle);
    localIntent.putExtra("orientation", -1);
    paramMMActivity.mmSetOnActivityResultCallback(new MMActivity.a()
    {
      public final void d(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(78487);
        if (paramAnonymousInt1 == 3456)
        {
          if ((paramAnonymousIntent == null) || (this.IVt == null))
          {
            AppMethodBeat.o(78487);
            return;
          }
          paramAnonymousIntent = paramAnonymousIntent.getBundleExtra("input_data");
          this.IVt.v(paramAnonymousIntent);
        }
        AppMethodBeat.o(78487);
      }
    });
    com.tencent.mm.br.c.b(paramMMActivity, "webview", ".luggage.ipc.IpcProxyUI", localIntent, 3456);
    AppMethodBeat.o(78488);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.ipc.b
 * JD-Core Version:    0.7.0.1
 */