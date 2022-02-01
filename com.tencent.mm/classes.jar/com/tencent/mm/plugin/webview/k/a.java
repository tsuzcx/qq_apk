package com.tencent.mm.plugin.webview.k;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.io.File;

public final class a
{
  private static void Y(o paramo)
  {
    AppMethodBeat.i(175882);
    if (paramo == null)
    {
      AppMethodBeat.o(175882);
      return;
    }
    if (paramo.isDirectory())
    {
      o[] arrayOfo = paramo.het();
      int j = arrayOfo.length;
      int i = 0;
      while (i < j)
      {
        Y(arrayOfo[i]);
        i += 1;
      }
    }
    Log.i("MicroMsg.ABI64WebViewCompat", "delete isSuccessDelete: %s fileName: %s", new Object[] { Boolean.valueOf(paramo.delete()), aa.z(paramo.her()) });
    AppMethodBeat.o(175882);
  }
  
  public static boolean ic(Context paramContext)
  {
    AppMethodBeat.i(82364);
    try
    {
      Y(new o(paramContext.getFilesDir().getParent() + "/app_webview/GPUCache"));
      Y(new o(paramContext.getFilesDir().getParent() + "/app_x5webview/GPUCache"));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.a
 * JD-Core Version:    0.7.0.1
 */