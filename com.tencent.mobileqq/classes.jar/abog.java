import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.businessCard.data.BusinessCard;

public final class abog
  implements Parcelable.Creator
{
  public BusinessCard a(Parcel paramParcel)
  {
    return new BusinessCard(paramParcel);
  }
  
  public BusinessCard[] a(int paramInt)
  {
    return new BusinessCard[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abog
 * JD-Core Version:    0.7.0.1
 */