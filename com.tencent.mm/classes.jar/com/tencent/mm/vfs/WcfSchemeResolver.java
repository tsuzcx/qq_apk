package com.tencent.mm.vfs;

import android.net.Uri;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class WcfSchemeResolver
  extends SingletonSchemeResolver
{
  public static final a CREATOR;
  
  static
  {
    AppMethodBeat.i(13337);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(13337);
  }
  
  static n iff()
  {
    return a.YBF;
  }
  
  public final Pair<FileSystem.b, String> a(l paraml, Uri paramUri)
  {
    AppMethodBeat.i(237000);
    FileSystem.b localb = ((m)paraml).bBL(paramUri.getAuthority());
    paraml = paramUri.getPath();
    if (paraml == null) {}
    for (paraml = "";; paraml = ad.r(paraml, true, true))
    {
      paraml = new Pair(localb, paraml);
      AppMethodBeat.o(237000);
      return paraml;
    }
  }
  
  static class a
    implements Parcelable.Creator<WcfSchemeResolver>
  {
    static final n YBF;
    
    static
    {
      AppMethodBeat.i(13335);
      YBF = new n(new WcfSchemeResolver((byte)0));
      AppMethodBeat.o(13335);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.WcfSchemeResolver
 * JD-Core Version:    0.7.0.1
 */