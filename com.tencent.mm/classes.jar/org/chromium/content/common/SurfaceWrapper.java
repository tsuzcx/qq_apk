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
    AppMethodBeat.i(139547);
    CREATOR = new SurfaceWrapper.1();
    AppMethodBeat.o(139547);
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
    AppMethodBeat.i(139546);
    this.mSurface.writeToParcel(paramParcel, 0);
    AppMethodBeat.o(139546);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     org.chromium.content.common.SurfaceWrapper
 * JD-Core Version:    0.7.0.1
 */