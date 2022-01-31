import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.richmedia.capture.data.FilterCategory;

public final class ahhs
  implements Parcelable.Creator
{
  public FilterCategory a(Parcel paramParcel)
  {
    return new FilterCategory(paramParcel);
  }
  
  public FilterCategory[] a(int paramInt)
  {
    return new FilterCategory[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahhs
 * JD-Core Version:    0.7.0.1
 */