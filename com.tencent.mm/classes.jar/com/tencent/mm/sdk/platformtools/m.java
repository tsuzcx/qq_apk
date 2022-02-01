package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.content.FileProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.io.File;

public final class m
{
  public static Uri a(Context paramContext, e parame)
  {
    AppMethodBeat.i(156179);
    parame = i.k(q.B(parame.mUri), false);
    if (parame == null) {
      paramContext = null;
    }
    for (;;)
    {
      AppMethodBeat.o(156179);
      return paramContext;
      if (Build.VERSION.SDK_INT >= 24) {
        paramContext = FileProvider.getUriForFile(paramContext, paramContext.getPackageName() + ".external.fileprovider", new File(parame));
      } else {
        paramContext = Uri.fromFile(new File(parame));
      }
    }
  }
  
  public static void a(Context paramContext, Intent paramIntent, Uri paramUri, String paramString)
  {
    AppMethodBeat.i(156178);
    String str = paramUri.getScheme();
    if ((str == null) || (str.isEmpty()) || (str.equals("file")) || (str.equals("wcf")))
    {
      a(paramContext, paramIntent, new e(paramUri.getPath()), paramString);
      AppMethodBeat.o(156178);
      return;
    }
    paramIntent.setDataAndType(paramUri, paramString);
    paramIntent.addFlags(1);
    AppMethodBeat.o(156178);
  }
  
  public static void a(Context paramContext, Intent paramIntent, e parame, String paramString)
  {
    AppMethodBeat.i(156177);
    String str = i.k(q.B(parame.mUri), false);
    if (str == null) {
      paramContext = null;
    }
    while ((h.IS_FLAVOR_RED) && (paramContext == null))
    {
      paramContext = new IllegalArgumentException("Path cannot be exported via provider: ".concat(String.valueOf(parame)));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.m
 * JD-Core Version:    0.7.0.1
 */