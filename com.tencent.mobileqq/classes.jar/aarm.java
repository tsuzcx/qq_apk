import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.ar.model.ArAwardInfo;

public final class aarm
  implements Parcelable.Creator
{
  public ArAwardInfo a(Parcel paramParcel)
  {
    return new ArAwardInfo(paramParcel);
  }
  
  public ArAwardInfo[] a(int paramInt)
  {
    return new ArAwardInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aarm
 * JD-Core Version:    0.7.0.1
 */