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
  
  static i fSO()
  {
    return a.LFU;
  }
  
  public final Pair<FileSystem.b, String> a(g paramg, Uri paramUri)
  {
    AppMethodBeat.i(193454);
    FileSystem.b localb = ((h)paramg).aZO(paramUri.getAuthority());
    paramg = paramUri.getPath();
    if (paramg == null) {}
    for (paramg = "";; paramg = w.o(paramg, true, true))
    {
      paramg = new Pair(localb, paramg);
      AppMethodBeat.o(193454);
      return paramg;
    }
  }
  
  static final class a
    implements Parcelable.Creator<WcfSchemeResolver>
  {
    static final i LFU;
    
    static
    {
      AppMethodBeat.i(13335);
      LFU = new i(new WcfSchemeResolver((byte)0));
      AppMethodBeat.o(13335);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.WcfSchemeResolver
 * JD-Core Version:    0.7.0.1
 */