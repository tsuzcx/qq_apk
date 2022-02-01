package com.tencent.mm.vfs;

import android.net.Uri;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class WcfSchemeResolver
  extends SchemeResolver.Base
{
  public static final a CREATOR;
  
  static
  {
    AppMethodBeat.i(13337);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(13337);
  }
  
  public static WcfSchemeResolver fyA()
  {
    return a.JuC;
  }
  
  public final Pair<FileSystem, String> a(SchemeResolver.a parama, Uri paramUri)
  {
    AppMethodBeat.i(13336);
    FileSystem localFileSystem = (FileSystem)((c)parama).Jtm.get(paramUri.getAuthority());
    parama = paramUri.getPath();
    if (parama == null) {}
    for (parama = "";; parama = q.m(parama, true, true))
    {
      parama = new Pair(localFileSystem, parama);
      AppMethodBeat.o(13336);
      return parama;
    }
  }
  
  static final class a
    implements Parcelable.Creator<WcfSchemeResolver>
  {
    static final WcfSchemeResolver JuC;
    
    static
    {
      AppMethodBeat.i(13335);
      JuC = new WcfSchemeResolver((byte)0);
      AppMethodBeat.o(13335);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.WcfSchemeResolver
 * JD-Core Version:    0.7.0.1
 */