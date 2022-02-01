package com.tencent.mm.vfs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class NullFileSystem
  extends m
  implements FileSystem
{
  public static final a CREATOR;
  
  static
  {
    AppMethodBeat.i(238246);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(238246);
  }
  
  public static FileSystem.b jKG()
  {
    return (FileSystem.b)a.agwt.agzC;
  }
  
  static r<FileSystem, FileSystem.b> jKt()
  {
    return a.agwt;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final FileSystem jKa()
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
    static final r<FileSystem, FileSystem.b> agwt;
    
    static
    {
      AppMethodBeat.i(238466);
      agwt = new r(new NullFileSystem((byte)0));
      AppMethodBeat.o(238466);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.NullFileSystem
 * JD-Core Version:    0.7.0.1
 */