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
    AppMethodBeat.i(139533);
    CREATOR = new UnguessableToken.1();
    AppMethodBeat.o(139533);
  }
  
  private UnguessableToken(long paramLong1, long paramLong2)
  {
    this.mHigh = paramLong1;
    this.mLow = paramLong2;
  }
  
  private static UnguessableToken create(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(139530);
    UnguessableToken localUnguessableToken = new UnguessableToken(paramLong1, paramLong2);
    AppMethodBeat.o(139530);
    return localUnguessableToken;
  }
  
  private UnguessableToken parcelAndUnparcelForTesting()
  {
    AppMethodBeat.i(139532);
    Parcel localParcel = Parcel.obtain();
    writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    UnguessableToken localUnguessableToken = (UnguessableToken)CREATOR.createFromParcel(localParcel);
    localParcel.recycle();
    AppMethodBeat.o(139532);
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
    AppMethodBeat.i(139531);
    paramParcel.writeLong(this.mHigh);
    paramParcel.writeLong(this.mLow);
    AppMethodBeat.o(139531);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     org.chromium.base.UnguessableToken
 * JD-Core Version:    0.7.0.1
 */