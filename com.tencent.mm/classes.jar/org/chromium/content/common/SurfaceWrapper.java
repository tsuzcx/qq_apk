package org.chromium.content.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SurfaceWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<SurfaceWrapper> CREATOR;
  private final Surface mSurface;
  
  static
  {
    AppMethodBeat.i(53751);
    CREATOR = new Parcelable.Creator()
    {
      public final SurfaceWrapper createFromParcel(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(53755);
        paramAnonymousParcel = new SurfaceWrapper((Surface)Surface.CREATOR.createFromParcel(paramAnonymousParcel));
        AppMethodBeat.o(53755);
        return paramAnonymousParcel;
      }
      
      public final SurfaceWrapper[] newArray(int paramAnonymousInt)
      {
        return new SurfaceWrapper[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(53751);
  }
  
  public SurfaceWrapper(Surface paramSurface)
  {
    this.mSurface = paramSurface;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Surface getSurface()
  {
    return this.mSurface;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(53750);
    this.mSurface.writeToParcel(paramParcel, 0);
    AppMethodBeat.o(53750);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.chromium.content.common.SurfaceWrapper
 * JD-Core Version:    0.7.0.1
 */