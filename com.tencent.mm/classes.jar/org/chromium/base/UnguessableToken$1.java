package org.chromium.base;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class UnguessableToken$1
  implements Parcelable.Creator<UnguessableToken>
{
  public final UnguessableToken createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(139527);
    long l1 = paramParcel.readLong();
    long l2 = paramParcel.readLong();
    if ((l1 == 0L) || (l2 == 0L))
    {
      AppMethodBeat.o(139527);
      return null;
    }
    paramParcel = new UnguessableToken(l1, l2, null);
    AppMethodBeat.o(139527);
    return paramParcel;
  }
  
  public final UnguessableToken[] newArray(int paramInt)
  {
    return new UnguessableToken[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     org.chromium.base.UnguessableToken.1
 * JD-Core Version:    0.7.0.1
 */