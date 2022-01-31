import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.armap.config.ARMapConfig.ResInfo;

public final class aaxu
  implements Parcelable.Creator
{
  public ARMapConfig.ResInfo a(Parcel paramParcel)
  {
    return new ARMapConfig.ResInfo(paramParcel);
  }
  
  public ARMapConfig.ResInfo[] a(int paramInt)
  {
    return new ARMapConfig.ResInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaxu
 * JD-Core Version:    0.7.0.1
 */