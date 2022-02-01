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
  
  static r<SchemeResolver, SchemeResolver.a> jKt()
  {
    return a.agwt;
  }
  
  public final Pair<FileSystem.b, String> a(o paramo, Uri paramUri)
  {
    AppMethodBeat.i(238211);
    String str = paramUri.getPath();
    paramUri = str;
    if (str == null) {
      paramUri = "";
    }
    paramo = paramo.bEi(paramUri);
    AppMethodBeat.o(238211);
    return paramo;
  }
  
  static class a
    implements Parcelable.Creator<FileSchemeResolver>
  {
    static final r<SchemeResolver, SchemeResolver.a> agwt;
    
    static
    {
      AppMethodBeat.i(13098);
      agwt = new r(new FileSchemeResolver((byte)0));
      AppMethodBeat.o(13098);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.FileSchemeResolver
 * JD-Core Version:    0.7.0.1
 */