import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.businessCard.data.CardOCRInfo;

public final class abvj
  implements Parcelable.Creator
{
  public CardOCRInfo a(Parcel paramParcel)
  {
    return new CardOCRInfo(paramParcel);
  }
  
  public CardOCRInfo[] a(int paramInt)
  {
    return new CardOCRInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abvj
 * JD-Core Version:    0.7.0.1
 */