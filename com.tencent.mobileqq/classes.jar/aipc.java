import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.troop.data.TroopBarPOI;

public final class aipc
  implements Parcelable.Creator
{
  public TroopBarPOI a(Parcel paramParcel)
  {
    return new TroopBarPOI(paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readInt(), paramParcel.readString(), paramParcel.readInt(), paramParcel.readString());
  }
  
  public TroopBarPOI[] a(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aipc
 * JD-Core Version:    0.7.0.1
 */