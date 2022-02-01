package com.tencent.mm.vfs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class NullFileSystem
  extends j
  implements FileSystem
{
  public static final a CREATOR;
  
  static
  {
    AppMethodBeat.i(236412);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(236412);
  }
  
  public static FileSystem.b ifq()
  {
    return (FileSystem.b)a.YDk.YCm;
  }
  
  static g ifr()
  {
    return a.YDk;
  }
  
  public final FileSystem.b cp(Map<String, String> paramMap)
  {
    return this;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final FileSystem ieX()
  {
    return this;
  }
  
  public final String toString()
  {
    return "NullFS";
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {}
  
  static class a
    implements Parcelable.Creator<NullFileSystem>
  {
    static final g YDk;
    
    static
    {
      AppMethodBeat.i(236407);
      YDk = new g(new NullFileSystem((byte)0));
      AppMethodBeat.o(236407);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.NullFileSystem
 * JD-Core Version:    0.7.0.1
 */