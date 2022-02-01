package com.tencent.mm.vfs;

import android.net.Uri;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FileSchemeResolver
  extends SingletonSchemeResolver
{
  public static final a CREATOR;
  
  static
  {
    AppMethodBeat.i(13101);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(13101);
  }
  
  static m hdX()
  {
    return a.Rbl;
  }
  
  public final Pair<FileSystem.b, String> a(k paramk, Uri paramUri)
  {
    AppMethodBeat.i(187651);
    String str = paramUri.getPath();
    paramUri = str;
    if (str == null) {
      paramUri = "";
    }
    paramk = paramk.boU(paramUri);
    AppMethodBeat.o(187651);
    return paramk;
  }
  
  static final class a
    implements Parcelable.Creator<FileSchemeResolver>
  {
    static final m Rbl;
    
    static
    {
      AppMethodBeat.i(13098);
      Rbl = new m(new FileSchemeResolver((byte)0));
      AppMethodBeat.o(13098);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.FileSchemeResolver
 * JD-Core Version:    0.7.0.1
 */