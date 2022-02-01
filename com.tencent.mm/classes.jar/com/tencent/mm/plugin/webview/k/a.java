package com.tencent.mm.plugin.webview.k;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import java.io.File;

public final class a
{
  private static void aa(u paramu)
  {
    AppMethodBeat.i(175882);
    if (paramu == null)
    {
      AppMethodBeat.o(175882);
      return;
    }
    if (paramu.isDirectory())
    {
      u[] arrayOfu = paramu.jKX();
      int j = arrayOfu.length;
      int i = 0;
      while (i < j)
      {
        aa(arrayOfu[i]);
        i += 1;
      }
    }
    Log.i("MicroMsg.ABI64WebViewCompat", "delete isSuccessDelete: %s fileName: %s", new Object[] { Boolean.valueOf(paramu.diJ()), ah.v(paramu.jKT()) });
    AppMethodBeat.o(175882);
  }
  
  public static boolean le(Context paramContext)
  {
    AppMethodBeat.i(82364);
    try
    {
      aa(new u(paramContext.getFilesDir().getParent() + "/app_webview/GPUCache"));
      aa(new u(paramContext.getFilesDir().getParent() + "/app_x5webview/GPUCache"));
      paramContext.getSharedPreferences("WebViewChromiumPrefs", 0).edit().clear().apply();
      AppMethodBeat.o(82364);
      return true;
    }
    finally
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