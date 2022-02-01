package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.content.FileProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;
import java.io.File;

public final class o
{
  public static Uri a(Context paramContext, k paramk)
  {
    AppMethodBeat.i(156179);
    paramk = com.tencent.mm.vfs.o.k(w.B(paramk.mUri), false);
    if (paramk == null) {
      paramContext = null;
    }
    for (;;)
    {
      AppMethodBeat.o(156179);
      return paramContext;
      if (Build.VERSION.SDK_INT >= 24) {
        paramContext = FileProvider.getUriForFile(paramContext, paramContext.getPackageName() + ".external.fileprovider", new File(paramk));
      } else {
        paramContext = Uri.fromFile(new File(paramk));
      }
    }
  }
  
  public static void a(Context paramContext, Intent paramIntent, Uri paramUri, String paramString)
  {
    AppMethodBeat.i(156178);
    String str = paramUri.getScheme();
    if ((str == null) || (str.isEmpty()) || (str.equals("file")) || (str.equals("wcf")))
    {
      a(paramContext, paramIntent, new k(paramUri.getPath()), paramString);
      AppMethodBeat.o(156178);
      return;
    }
    paramIntent.setDataAndType(paramUri, paramString);
    paramIntent.addFlags(1);
    AppMethodBeat.o(156178);
  }
  
  public static void a(Context paramContext, Intent paramIntent, k paramk, String paramString)
  {
    AppMethodBeat.i(156177);
    String str = com.tencent.mm.vfs.o.k(w.B(paramk.mUri), false);
    if (str == null) {
      paramContext = null;
    }
    while ((j.IS_FLAVOR_RED) && (paramContext == null))
    {
      paramContext = new IllegalArgumentException("Path cannot be exported via provider: ".concat(String.valueOf(paramk)));
      AppMethodBeat.o(156177);
      throw paramContext;
      if (Build.VERSION.SDK_INT >= 24) {
        paramContext = FileProvider.getUriForFile(paramContext, paramContext.getPackageName() + ".external.fileprovider", new File(str));
      } else {
        paramContext = Uri.fromFile(new File(str));
      }
    }
    paramIntent.setDataAndType(paramContext, paramString).addFlags(1);
    AppMethodBeat.o(156177);
  }
  
  public static Uri d(Context paramContext, File paramFile)
  {
    AppMethodBeat.i(211739);
    try
    {
      if (Build.VERSION.SDK_INT >= 24) {}
      for (paramContext = FileProvider.getUriForFile(paramContext, paramContext.getPackageName() + ".external.fileprovider", paramFile);; paramContext = Uri.fromFile(paramFile))
      {
        AppMethodBeat.o(211739);
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.FileProviderHelper", paramContext, "[-] Fail to call getUriForFileWithoutVFSRemap", new Object[0]);
        paramContext = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.o
 * JD-Core Version:    0.7.0.1
 */