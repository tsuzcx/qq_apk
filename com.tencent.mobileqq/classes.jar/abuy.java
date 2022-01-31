import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.data.PrecoverConfig;

public final class abuy
  implements Parcelable.Creator
{
  public PrecoverConfig a(Parcel paramParcel)
  {
    return new PrecoverConfig(paramParcel);
  }
  
  public PrecoverConfig[] a(int paramInt)
  {
    return new PrecoverConfig[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abuy
 * JD-Core Version:    0.7.0.1
 */