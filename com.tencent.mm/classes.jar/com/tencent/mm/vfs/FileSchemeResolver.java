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
  
  static i fSO()
  {
    return a.LFU;
  }
  
  public final Pair<FileSystem.b, String> a(g paramg, Uri paramUri)
  {
    AppMethodBeat.i(193370);
    paramg = paramg.aZP(paramUri.getPath());
    AppMethodBeat.o(193370);
    return paramg;
  }
  
  static final class a
    implements Parcelable.Creator<FileSchemeResolver>
  {
    static final i LFU;
    
    static
    {
      AppMethodBeat.i(13098);
      LFU = new i(new FileSchemeResolver((byte)0));
      AppMethodBeat.o(13098);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.FileSchemeResolver
 * JD-Core Version:    0.7.0.1
 */