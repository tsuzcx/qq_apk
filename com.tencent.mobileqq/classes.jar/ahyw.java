import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.richmedia.subtitles.PacmanParcelItem;

public final class ahyw
  implements Parcelable.Creator<PacmanParcelItem>
{
  public PacmanParcelItem a(Parcel paramParcel)
  {
    return new PacmanParcelItem(paramParcel);
  }
  
  public PacmanParcelItem[] a(int paramInt)
  {
    return new PacmanParcelItem[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahyw
 * JD-Core Version:    0.7.0.1
 */