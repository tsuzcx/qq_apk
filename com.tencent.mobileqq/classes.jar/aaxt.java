import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.armap.config.ARMapConfig;

public final class aaxt
  implements Parcelable.Creator
{
  public ARMapConfig a(Parcel paramParcel)
  {
    return new ARMapConfig(paramParcel);
  }
  
  public ARMapConfig[] a(int paramInt)
  {
    return new ARMapConfig[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaxt
 * JD-Core Version:    0.7.0.1
 */