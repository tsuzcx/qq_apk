import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.armap.wealthgod.WealthGodInfo;

public final class abja
  implements Parcelable.Creator
{
  public WealthGodInfo a(Parcel paramParcel)
  {
    return new WealthGodInfo(paramParcel);
  }
  
  public WealthGodInfo[] a(int paramInt)
  {
    return new WealthGodInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abja
 * JD-Core Version:    0.7.0.1
 */