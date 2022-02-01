package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.content.FileProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.File;

public class FileProviderHelper
{
  private static final String TAG = "MicroMsg.FileProviderHelper";
  
  public static Uri getUriForFile(Context paramContext, o paramo)
  {
    AppMethodBeat.i(156179);
    paramo = s.k(aa.z(paramo.mUri), false);
    if (paramo == null) {
      paramContext = null;
    }
    for (;;)
    {
      AppMethodBeat.o(156179);
      return paramContext;
      if (Build.VERSION.SDK_INT >= 24) {
        paramContext = FileProvider.getUriForFile(paramContext, paramContext.getPackageName() + ".external.fileprovider", new File(paramo));
      } else {
        paramContext = Uri.fromFile(new File(paramo));
      }
    }
  }
  
  public static Uri getUriForFileWithoutVFSRemap(Context paramContext, File paramFile)
  {
    AppMethodBeat.i(200845);
    try
    {
      if (Build.VERSION.SDK_INT >= 24) {}
      for (paramContext = FileProvider.getUriForFile(paramContext, paramContext.getPackageName() + ".external.fileprovider", paramFile);; paramContext = Uri.fromFile(paramFile))
      {
        AppMethodBeat.o(200845);
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.FileProviderHelper", paramContext, "[-] Fail to call getUriForFileWithoutVFSRemap", new Object[0]);
        paramContext = null;
      }
    }
  }
  
  public static void setIntentDataAndType(Context paramContext, Intent paramIntent, Uri paramUri, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(200844);
    String str = paramUri.getScheme();
    if ((str == null) || (str.isEmpty()) || (str.equals("file")) || (str.equals("wcf")))
    {
      setIntentDataAndType(paramContext, paramIntent, new o(paramUri.getPath()), paramString, paramBoolean);
      AppMethodBeat.o(200844);
      return;
    }
    paramIntent.setDataAndType(paramUri, paramString);
    paramIntent.addFlags(1);
    if (paramBoolean) {
      paramIntent.addFlags(2);
    }
    AppMethodBeat.o(200844);
  }
  
  public static void setIntentDataAndType(Context paramContext, Intent paramIntent, o paramo, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(200843);
    String str = s.k(aa.z(paramo.mUri), false);
    if (str == null) {
      paramContext = null;
    }
    while ((BuildInfo.IS_FLAVOR_RED) && (paramContext == null))
    {
      paramContext = new IllegalArgumentException("Path cannot be exported via provider: ".concat(String.valueOf(paramo)));
      AppMethodBeat.o(200843);
      throw paramContext;
      if (Build.VERSION.SDK_INT >= 24) {
        paramContext = FileProvider.getUriForFile(paramContext, paramContext.getPackageName() + ".external.fileprovider", new File(str));
      } else {
        paramContext = Uri.fromFile(new File(str));
      }
    }
    int i = 1;
    if (paramBoolean) {
      i = 3;
    }
    paramIntent.setDataAndType(paramContext, paramString).addFlags(i);
    AppMethodBeat.o(200843);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.FileProviderHelper
 * JD-Core Version:    0.7.0.1
 */