import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.nearby.now.model.MedalItem;

public final class afbe
  implements Parcelable.Creator
{
  public MedalItem a(Parcel paramParcel)
  {
    return new MedalItem(paramParcel);
  }
  
  public MedalItem[] a(int paramInt)
  {
    return new MedalItem[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afbe
 * JD-Core Version:    0.7.0.1
 */