package com.tencent.mm.plugin.webview.k;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.q;
import java.io.File;

public final class a
{
  private static void Y(q paramq)
  {
    AppMethodBeat.i(175882);
    if (paramq == null)
    {
      AppMethodBeat.o(175882);
      return;
    }
    if (paramq.isDirectory())
    {
      q[] arrayOfq = paramq.ifJ();
      int j = arrayOfq.length;
      int i = 0;
      while (i < j)
      {
        Y(arrayOfq[i]);
        i += 1;
      }
    }
    Log.i("MicroMsg.ABI64WebViewCompat", "delete isSuccessDelete: %s fileName: %s", new Object[] { Boolean.valueOf(paramq.cFq()), paramq.bOF() });
    AppMethodBeat.o(175882);
  }
  
  public static boolean je(Context paramContext)
  {
    AppMethodBeat.i(82364);
    try
    {
      Y(new q(paramContext.getFilesDir().getParent() + "/app_webview/GPUCache"));
      Y(new q(paramContext.getFilesDir().getParent() + "/app_x5webview/GPUCache"));
      paramContext.getSharedPreferences("WebViewChromiumPrefs", 0).edit().clear().apply();
      AppMethodBeat.o(82364);
      return true;
    }
    catch (Throwable paramContext)
    {
      Log.printErrStackTrace("MicroMsg.ABI64WebViewCompat", paramContext, "", new Object[0]);
      AppMethodBeat.o(82364);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.a
 * JD-Core Version:    0.7.0.1
 */