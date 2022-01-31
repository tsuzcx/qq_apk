package com.tencent.mm.plugin.webview.luggage.ipc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.ui.MMActivity;

public final class b
{
  public static <T extends c> void a(Context paramContext, Bundle paramBundle, Class<T> paramClass)
  {
    AppMethodBeat.i(6247);
    Intent localIntent = new Intent();
    localIntent.putExtra("task_class_name", paramClass.getName());
    localIntent.putExtra("input_data", paramBundle);
    localIntent.putExtra("orientation", -1);
    d.b(paramContext, "webview", ".luggage.ipc.IpcProxyUI", localIntent);
    AppMethodBeat.o(6247);
  }
  
  public static <T extends c> void a(MMActivity paramMMActivity, Bundle paramBundle, Class<T> paramClass, a parama)
  {
    AppMethodBeat.i(6248);
    Intent localIntent = new Intent();
    localIntent.putExtra("task_class_name", paramClass.getName());
    localIntent.putExtra("input_data", paramBundle);
    localIntent.putExtra("orientation", -1);
    paramMMActivity.mmSetOnActivityResultCallback(new b.1(parama));
    d.b(paramMMActivity, "webview", ".luggage.ipc.IpcProxyUI", localIntent, 3456);
    AppMethodBeat.o(6248);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.ipc.b
 * JD-Core Version:    0.7.0.1
 */