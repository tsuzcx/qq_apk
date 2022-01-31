import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.nearby.now.model.MedalInfo;

public final class aegl
  implements Parcelable.Creator
{
  public MedalInfo a(Parcel paramParcel)
  {
    return new MedalInfo(paramParcel);
  }
  
  public MedalInfo[] a(int paramInt)
  {
    return new MedalInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aegl
 * JD-Core Version:    0.7.0.1
 */