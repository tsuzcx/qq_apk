import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.doutu.DoutuData;

public final class abxy
  implements Parcelable.Creator
{
  public DoutuData a(Parcel paramParcel)
  {
    return new DoutuData(paramParcel);
  }
  
  public DoutuData[] a(int paramInt)
  {
    return new DoutuData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abxy
 * JD-Core Version:    0.7.0.1
 */