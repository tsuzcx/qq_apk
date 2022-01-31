import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.olympic.OlyimpicConfig;

public final class afqn
  implements Parcelable.Creator
{
  public OlyimpicConfig a(Parcel paramParcel)
  {
    return new OlyimpicConfig(paramParcel);
  }
  
  public OlyimpicConfig[] a(int paramInt)
  {
    return new OlyimpicConfig[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afqn
 * JD-Core Version:    0.7.0.1
 */