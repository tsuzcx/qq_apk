package com.tencent.mm.plugin.webview.j;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;
import java.io.File;

public final class a
{
  private static void U(e parame)
  {
    AppMethodBeat.i(175882);
    if (parame == null)
    {
      AppMethodBeat.o(175882);
      return;
    }
    if (parame.isDirectory())
    {
      e[] arrayOfe = parame.fOM();
      int j = arrayOfe.length;
      int i = 0;
      while (i < j)
      {
        U(arrayOfe[i]);
        i += 1;
      }
    }
    ad.i("MicroMsg.ABI64WebViewCompat", "delete isSuccessDelete: %s fileName: %s", new Object[] { Boolean.valueOf(parame.delete()), q.B(parame.fOK()) });
    AppMethodBeat.o(175882);
  }
  
  public static boolean hc(Context paramContext)
  {
    AppMethodBeat.i(82364);
    try
    {
      U(new e(paramContext.getFilesDir().getParent() + "/app_webview/GPUCache"));
      U(new e(paramContext.getFilesDir().getParent() + "/app_x5webview/GPUCache"));
      paramContext.getSharedPreferences("WebViewChromiumPrefs", 0).edit().clear().apply();
      AppMethodBeat.o(82364);
      return true;
    }
    catch (Throwable paramContext)
    {
      ad.printErrStackTrace("MicroMsg.ABI64WebViewCompat", paramContext, "", new Object[0]);
      AppMethodBeat.o(82364);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.j.a
 * JD-Core Version:    0.7.0.1
 */