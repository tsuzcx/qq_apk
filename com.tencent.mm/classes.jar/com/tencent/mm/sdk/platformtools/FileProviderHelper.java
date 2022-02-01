package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import androidx.core.content.FileProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.File;

public class FileProviderHelper
{
  private static final String TAG = "MicroMsg.FileProviderHelper";
  
  public static Uri getUriForFile(Context paramContext, u paramu)
  {
    AppMethodBeat.i(156179);
    paramu = y.n(ah.v(paramu.mUri), false);
    if (paramu == null) {
      paramContext = null;
    }
    for (;;)
    {
      AppMethodBeat.o(156179);
      return paramContext;
      if (Build.VERSION.SDK_INT >= 24) {
        paramContext = FileProvider.getUriForFile(paramContext, paramContext.getPackageName() + ".external.fileprovider", new File(paramu));
      } else {
        paramContext = Uri.fromFile(new File(paramu));
      }
    }
  }
  
  public static Uri getUriForFileWithoutVFSRemap(Context paramContext, File paramFile)
  {
    AppMethodBeat.i(243561);
    try
    {
      if (Build.VERSION.SDK_INT >= 24) {}
      for (paramContext = FileProvider.getUriForFile(paramContext, paramContext.getPackageName() + ".external.fileprovider", paramFile);; paramContext = Uri.fromFile(paramFile))
      {
        AppMethodBeat.o(243561);
        return paramContext;
      }
    }
    finally
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
    AppMethodBeat.i(243549);
    String str = paramUri.getScheme();
    if ((str == null) || (str.isEmpty()) || (str.equals("file")) || (str.equals("wcf")))
    {
      setIntentDataAndType(paramContext, paramIntent, new u(paramUri.getPath()), paramString, paramBoolean);
      AppMethodBeat.o(243549);
      return;
    }
    paramIntent.setDataAndType(paramUri, paramString);
    paramIntent.addFlags(1);
    if (paramBoolean) {
      paramIntent.addFlags(2);
    }
    AppMethodBeat.o(243549);
  }
  
  public static void setIntentDataAndType(Context paramContext, Intent paramIntent, u paramu, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(243540);
    String str = y.n(ah.v(paramu.mUri), false);
    Log.i("MicroMsg.FileProviderHelper", "setIntentDataAndType: realPath:".concat(String.valueOf(str)));
    if (str == null) {
      paramContext = null;
    }
    while ((BuildInfo.IS_FLAVOR_RED) && (paramContext == null))
    {
      paramContext = new IllegalArgumentException("Path cannot be exported via provider: ".concat(String.valueOf(paramu)));
      AppMethodBeat.o(243540);
      throw paramContext;
      if (((str.startsWith("/data/data")) && (Build.VERSION.SDK_INT >= 21)) || (Build.VERSION.SDK_INT >= 24)) {
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
    AppMethodBeat.o(243540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.FileProviderHelper
 * JD-Core Version:    0.7.0.1
 */