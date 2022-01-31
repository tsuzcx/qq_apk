import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.armap.config.ARMapConfig.StarInfo;

public final class abew
  implements Parcelable.Creator
{
  public ARMapConfig.StarInfo a(Parcel paramParcel)
  {
    return new ARMapConfig.StarInfo(paramParcel);
  }
  
  public ARMapConfig.StarInfo[] a(int paramInt)
  {
    return new ARMapConfig.StarInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abew
 * JD-Core Version:    0.7.0.1
 */