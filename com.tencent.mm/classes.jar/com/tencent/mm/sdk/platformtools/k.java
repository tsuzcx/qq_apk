package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.FileProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public final class k
{
  public static void a(Context paramContext, Intent paramIntent, Uri paramUri, String paramString)
  {
    AppMethodBeat.i(93388);
    if (paramUri.getScheme().equals("file"))
    {
      a(paramContext, paramIntent, new File(paramUri.getPath()), paramString);
      AppMethodBeat.o(93388);
      return;
    }
    if (d.fv(24))
    {
      paramIntent.setDataAndType(paramUri, paramString);
      paramIntent.addFlags(1);
    }
    AppMethodBeat.o(93388);
  }
  
  public static void a(Context paramContext, Intent paramIntent, File paramFile, String paramString)
  {
    AppMethodBeat.i(93389);
    if (d.fv(24))
    {
      paramIntent.setDataAndType(d(paramContext, paramFile), paramString);
      paramIntent.addFlags(1);
      AppMethodBeat.o(93389);
      return;
    }
    paramIntent.setDataAndType(Uri.fromFile(paramFile), paramString);
    AppMethodBeat.o(93389);
  }
  
  public static Uri d(Context paramContext, File paramFile)
  {
    AppMethodBeat.i(93391);
    if (d.fv(24)) {}
    for (paramContext = e(paramContext, paramFile);; paramContext = Uri.fromFile(paramFile))
    {
      AppMethodBeat.o(93391);
      return paramContext;
    }
  }
  
  private static Uri e(Context paramContext, File paramFile)
  {
    AppMethodBeat.i(93392);
    paramContext = FileProvider.getUriForFile(paramContext, paramContext.getPackageName() + ".external.fileprovider", paramFile);
    AppMethodBeat.o(93392);
    return paramContext;
  }
  
  public static ArrayList<Uri> e(Context paramContext, ArrayList<Uri> paramArrayList)
  {
    AppMethodBeat.i(93390);
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.add(d(paramContext, new File(((Uri)paramArrayList.next()).getPath())));
    }
    AppMethodBeat.o(93390);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.k
 * JD-Core Version:    0.7.0.1
 */