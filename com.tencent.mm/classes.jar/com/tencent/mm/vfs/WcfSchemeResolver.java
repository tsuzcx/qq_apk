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
  
  static r<SchemeResolver, SchemeResolver.a> jKt()
  {
    return a.agwt;
  }
  
  public final Pair<FileSystem.b, String> a(o paramo, Uri paramUri)
  {
    AppMethodBeat.i(238228);
    FileSystem.b localb = ((q)paramo).bEh(paramUri.getAuthority());
    paramo = paramUri.getPath();
    if (paramo == null) {}
    for (paramo = "";; paramo = ah.v(paramo, true, true))
    {
      paramo = new Pair(localb, paramo);
      AppMethodBeat.o(238228);
      return paramo;
    }
  }
  
  static class a
    implements Parcelable.Creator<WcfSchemeResolver>
  {
    static final r<SchemeResolver, SchemeResolver.a> agwt;
    
    static
    {
      AppMethodBeat.i(13335);
      agwt = new r(new WcfSchemeResolver((byte)0));
      AppMethodBeat.o(13335);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.WcfSchemeResolver
 * JD-Core Version:    0.7.0.1
 */