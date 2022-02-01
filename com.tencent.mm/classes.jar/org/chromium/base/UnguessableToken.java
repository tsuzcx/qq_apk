package org.chromium.base;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class UnguessableToken
  implements Parcelable
{
  public static final Parcelable.Creator<UnguessableToken> CREATOR;
  private final long mHigh;
  private final long mLow;
  
  static
  {
    AppMethodBeat.i(53749);
    CREATOR = new Parcelable.Creator()
    {
      public final UnguessableToken createFromParcel(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(53737);
        long l1 = paramAnonymousParcel.readLong();
        long l2 = paramAnonymousParcel.readLong();
        if ((l1 == 0L) || (l2 == 0L))
        {
          AppMethodBeat.o(53737);
          return null;
        }
        paramAnonymousParcel = new UnguessableToken(l1, l2, null);
        AppMethodBeat.o(53737);
        return paramAnonymousParcel;
      }
      
      public final UnguessableToken[] newArray(int paramAnonymousInt)
      {
        return new UnguessableToken[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(53749);
  }
  
  private UnguessableToken(long paramLong1, long paramLong2)
  {
    this.mHigh = paramLong1;
    this.mLow = paramLong2;
  }
  
  private static UnguessableToken create(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(53746);
    UnguessableToken localUnguessableToken = new UnguessableToken(paramLong1, paramLong2);
    AppMethodBeat.o(53746);
    return localUnguessableToken;
  }
  
  private UnguessableToken parcelAndUnparcelForTesting()
  {
    AppMethodBeat.i(53748);
    Parcel localParcel = Parcel.obtain();
    writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    UnguessableToken localUnguessableToken = (UnguessableToken)CREATOR.createFromParcel(localParcel);
    localParcel.recycle();
    AppMethodBeat.o(53748);
    return localUnguessableToken;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public long getHighForSerialization()
  {
    return this.mHigh;
  }
  
  public long getLowForSerialization()
  {
    return this.mLow;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(53747);
    paramParcel.writeLong(this.mHigh);
    paramParcel.writeLong(this.mLow);
    AppMethodBeat.o(53747);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     org.chromium.base.UnguessableToken
 * JD-Core Version:    0.7.0.1
 */