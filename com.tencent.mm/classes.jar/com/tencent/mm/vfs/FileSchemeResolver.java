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
  
  static n iff()
  {
    return a.YBF;
  }
  
  public final Pair<FileSystem.b, String> a(l paraml, Uri paramUri)
  {
    AppMethodBeat.i(236134);
    String str = paramUri.getPath();
    paramUri = str;
    if (str == null) {
      paramUri = "";
    }
    paraml = paraml.bBM(paramUri);
    AppMethodBeat.o(236134);
    return paraml;
  }
  
  static class a
    implements Parcelable.Creator<FileSchemeResolver>
  {
    static final n YBF;
    
    static
    {
      AppMethodBeat.i(13098);
      YBF = new n(new FileSchemeResolver((byte)0));
      AppMethodBeat.o(13098);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.FileSchemeResolver
 * JD-Core Version:    0.7.0.1
 */