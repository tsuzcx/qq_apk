package com.tencent.mm.plugin.webview.j;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;
import java.io.File;

public final class a
{
  private static void U(k paramk)
  {
    AppMethodBeat.i(175882);
    if (paramk == null)
    {
      AppMethodBeat.o(175882);
      return;
    }
    if (paramk.isDirectory())
    {
      k[] arrayOfk = paramk.fTj();
      int j = arrayOfk.length;
      int i = 0;
      while (i < j)
      {
        U(arrayOfk[i]);
        i += 1;
      }
    }
    ae.i("MicroMsg.ABI64WebViewCompat", "delete isSuccessDelete: %s fileName: %s", new Object[] { Boolean.valueOf(paramk.delete()), w.B(paramk.fTh()) });
    AppMethodBeat.o(175882);
  }
  
  public static boolean hi(Context paramContext)
  {
    AppMethodBeat.i(82364);
    try
    {
      U(new k(paramContext.getFilesDir().getParent() + "/app_webview/GPUCache"));
      U(new k(paramContext.getFilesDir().getParent() + "/app_x5webview/GPUCache"));
      paramContext.getSharedPreferences("WebViewChromiumPrefs", 0).edit().clear().apply();
      AppMethodBeat.o(82364);
      return true;
    }
    catch (Throwable paramContext)
    {
      ae.printErrStackTrace("MicroMsg.ABI64WebViewCompat", paramContext, "", new Object[0]);
      AppMethodBeat.o(82364);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.j.a
 * JD-Core Version:    0.7.0.1
 */