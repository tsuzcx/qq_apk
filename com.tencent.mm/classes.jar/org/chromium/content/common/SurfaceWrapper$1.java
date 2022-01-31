package org.chromium.content.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SurfaceWrapper$1
  implements Parcelable.Creator<SurfaceWrapper>
{
  public final SurfaceWrapper createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(139543);
    paramParcel = new SurfaceWrapper((Surface)Surface.CREATOR.createFromParcel(paramParcel));
    AppMethodBeat.o(139543);
    return paramParcel;
  }
  
  public final SurfaceWrapper[] newArray(int paramInt)
  {
    return new SurfaceWrapper[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     org.chromium.content.common.SurfaceWrapper.1
 * JD-Core Version:    0.7.0.1
 */