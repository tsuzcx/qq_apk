package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import androidx.core.content.FileProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.io.File;

public class FileProviderHelper
{
  private static final String TAG = "MicroMsg.FileProviderHelper";
  
  public static Uri getUriForFile(Context paramContext, q paramq)
  {
    AppMethodBeat.i(156179);
    paramq = u.n(paramq.getPath(), false);
    if (paramq == null) {
      paramContext = null;
    }
    for (;;)
    {
      AppMethodBeat.o(156179);
      return paramContext;
      if (Build.VERSION.SDK_INT >= 24) {
        paramContext = FileProvider.getUriForFile(paramContext, paramContext.getPackageName() + ".external.fileprovider", new File(paramq));
      } else {
        paramContext = Uri.fromFile(new File(paramq));
      }
    }
  }
  
  public static Uri getUriForFileWithoutVFSRemap(Context paramContext, File paramFile)
  {
    AppMethodBeat.i(248704);
    try
    {
      if (Build.VERSION.SDK_INT >= 24) {}
      for (paramContext = FileProvider.getUriForFile(paramContext, paramContext.getPackageName() + ".external.fileprovider", paramFile);; paramContext = Uri.fromFile(paramFile))
      {
        AppMethodBeat.o(248704);
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
    AppMethodBeat.i(248700);
    String str = paramUri.getScheme();
    if ((str == null) || (str.isEmpty()) || (str.equals("file")) || (str.equals("wcf")))
    {
      setIntentDataAndType(paramContext, paramIntent, new q(paramUri.getPath()), paramString, paramBoolean);
      AppMethodBeat.o(248700);
      return;
    }
    paramIntent.setDataAndType(paramUri, paramString);
    paramIntent.addFlags(1);
    if (paramBoolean) {
      paramIntent.addFlags(2);
    }
    AppMethodBeat.o(248700);
  }
  
  public static void setIntentDataAndType(Context paramContext, Intent paramIntent, q paramq, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(248696);
    String str = u.n(paramq.getPath(), false);
    if (str == null) {
      paramContext = null;
    }
    while ((BuildInfo.IS_FLAVOR_RED) && (paramContext == null))
    {
      paramContext = new IllegalArgumentException("Path cannot be exported via provider: ".concat(String.valueOf(paramq)));
      AppMethodBeat.o(248696);
      throw paramContext;
      if (Build.VERSION.SDK_INT >= 21) {
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
    AppMethodBeat.o(248696);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.FileProviderHelper
 * JD-Core Version:    0.7.0.1
 */