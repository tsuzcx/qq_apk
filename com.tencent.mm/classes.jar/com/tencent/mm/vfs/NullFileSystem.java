package com.tencent.mm.vfs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public class NullFileSystem
  extends i
  implements FileSystem
{
  public static final a CREATOR;
  
  static
  {
    AppMethodBeat.i(187710);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(187710);
  }
  
  static f heh()
  {
    return a.RcH;
  }
  
  public final FileSystem.b cj(Map<String, String> paramMap)
  {
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final FileSystem hdQ()
  {
    return this;
  }
  
  public String toString()
  {
    return "NullFS";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
  
  static final class a
    implements Parcelable.Creator<NullFileSystem>
  {
    static final f RcH;
    
    static
    {
      AppMethodBeat.i(187709);
      RcH = new f(new NullFileSystem((byte)0));
      AppMethodBeat.o(187709);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.NullFileSystem
 * JD-Core Version:    0.7.0.1
 */