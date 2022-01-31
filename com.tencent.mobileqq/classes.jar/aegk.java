import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.nearby.now.model.LocationInfo;

public final class aegk
  implements Parcelable.Creator
{
  public LocationInfo a(Parcel paramParcel)
  {
    return new LocationInfo(paramParcel);
  }
  
  public LocationInfo[] a(int paramInt)
  {
    return new LocationInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aegk
 * JD-Core Version:    0.7.0.1
 */