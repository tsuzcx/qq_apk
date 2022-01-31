import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.troop.data.TroopBarMyBar;

public final class aipb
  implements Parcelable.Creator
{
  public TroopBarMyBar a(Parcel paramParcel)
  {
    return new TroopBarMyBar(paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readString(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readString(), paramParcel.readString(), paramParcel.readInt(), paramParcel.readString(), paramParcel.readInt(), paramParcel.readString());
  }
  
  public TroopBarMyBar[] a(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aipb
 * JD-Core Version:    0.7.0.1
 */