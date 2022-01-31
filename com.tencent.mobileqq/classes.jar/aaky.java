import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.ar.model.ArWebInfo;

public final class aaky
  implements Parcelable.Creator
{
  public ArWebInfo a(Parcel paramParcel)
  {
    return new ArWebInfo(paramParcel);
  }
  
  public ArWebInfo[] a(int paramInt)
  {
    return new ArWebInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaky
 * JD-Core Version:    0.7.0.1
 */