import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.ar.model.ArDefaultSetting;

public final class aakt
  implements Parcelable.Creator
{
  public ArDefaultSetting a(Parcel paramParcel)
  {
    return new ArDefaultSetting(paramParcel);
  }
  
  public ArDefaultSetting[] a(int paramInt)
  {
    return new ArDefaultSetting[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aakt
 * JD-Core Version:    0.7.0.1
 */