import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.troop.homework.arithmetic.data.HWGuideItem;

public final class ajfy
  implements Parcelable.Creator
{
  public HWGuideItem a(Parcel paramParcel)
  {
    return new HWGuideItem(paramParcel);
  }
  
  public HWGuideItem[] a(int paramInt)
  {
    return new HWGuideItem[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajfy
 * JD-Core Version:    0.7.0.1
 */