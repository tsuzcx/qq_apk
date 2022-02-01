package com.tencent.mm.vfs;

import android.net.Uri;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class FileSchemeResolver
  extends SchemeResolver.Base
{
  public static final a CREATOR;
  
  static
  {
    AppMethodBeat.i(13101);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(13101);
  }
  
  private static String aSk(String paramString)
  {
    AppMethodBeat.i(13100);
    paramString = new File(paramString);
    try
    {
      String str = paramString.getCanonicalPath();
      AppMethodBeat.o(13100);
      return str;
    }
    catch (IOException localIOException)
    {
      paramString = paramString.getAbsolutePath();
      AppMethodBeat.o(13100);
    }
    return paramString;
  }
  
  public static FileSchemeResolver fxF()
  {
    return a.Jsd;
  }
  
  public final Pair<FileSystem, String> a(SchemeResolver.a parama, Uri paramUri)
  {
    AppMethodBeat.i(13099);
    Object localObject = ((c)parama).Jto;
    paramUri = paramUri.getPath();
    if ((paramUri == null) || (paramUri.isEmpty())) {
      paramUri = null;
    }
    String str;
    int i;
    label98:
    c.a locala;
    for (;;)
    {
      if (paramUri == null)
      {
        AppMethodBeat.o(13099);
        return null;
        str = aSk(paramUri);
        i = Collections.binarySearch((List)localObject, str);
        if (i >= 0)
        {
          localObject = (c.a)((List)localObject).get(i);
          paramUri = "";
          paramUri = new Pair(localObject, paramUri);
        }
        else
        {
          i = -i - 2;
          if (i < 0) {
            locala = null;
          }
        }
      }
    }
    label281:
    for (;;)
    {
      if (i >= 0)
      {
        paramUri = str.substring(locala.basePath.length() + 1);
        localObject = locala;
        break;
        locala = (c.a)((List)localObject).get(i);
        if ((str.startsWith(locala.basePath)) && (str.charAt(locala.basePath.length()) == '/')) {
          break label281;
        }
        i = locala.Jtu;
        break label98;
      }
      paramUri = str;
      localObject = locala;
      if (str.isEmpty()) {
        break;
      }
      paramUri = str;
      localObject = locala;
      if (str.charAt(0) != '/') {
        break;
      }
      paramUri = str.substring(1);
      localObject = locala;
      break;
      if (paramUri.first == null) {}
      for (parama = parama.fxR();; parama = ((c.a)paramUri.first).Jsh)
      {
        parama = new Pair(parama, paramUri.second);
        AppMethodBeat.o(13099);
        return parama;
      }
    }
  }
  
  static final class a
    implements Parcelable.Creator<FileSchemeResolver>
  {
    static final FileSchemeResolver Jsd;
    
    static
    {
      AppMethodBeat.i(13098);
      Jsd = new FileSchemeResolver((byte)0);
      AppMethodBeat.o(13098);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.FileSchemeResolver
 * JD-Core Version:    0.7.0.1
 */