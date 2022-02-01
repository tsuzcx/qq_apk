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
  
  static m hdX()
  {
    return a.Rbl;
  }
  
  public final Pair<FileSystem.b, String> a(k paramk, Uri paramUri)
  {
    AppMethodBeat.i(187768);
    FileSystem.b localb = ((l)paramk).boT(paramUri.getAuthority());
    paramk = paramUri.getPath();
    if (paramk == null) {}
    for (paramk = "";; paramk = aa.q(paramk, true, true))
    {
      paramk = new Pair(localb, paramk);
      AppMethodBeat.o(187768);
      return paramk;
    }
  }
  
  static final class a
    implements Parcelable.Creator<WcfSchemeResolver>
  {
    static final m Rbl;
    
    static
    {
      AppMethodBeat.i(13335);
      Rbl = new m(new WcfSchemeResolver((byte)0));
      AppMethodBeat.o(13335);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.WcfSchemeResolver
 * JD-Core Version:    0.7.0.1
 */