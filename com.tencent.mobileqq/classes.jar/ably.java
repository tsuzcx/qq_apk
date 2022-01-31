import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.armap.config.ARMapConfig.WealthGodConfig;

public final class ably
  implements Parcelable.Creator
{
  public ARMapConfig.WealthGodConfig a(Parcel paramParcel)
  {
    return new ARMapConfig.WealthGodConfig(paramParcel);
  }
  
  public ARMapConfig.WealthGodConfig[] a(int paramInt)
  {
    return new ARMapConfig.WealthGodConfig[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ably
 * JD-Core Version:    0.7.0.1
 */