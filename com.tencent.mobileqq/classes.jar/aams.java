import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.gdtad.aditem.GdtAd;

public final class aams
  implements Parcelable.Creator<GdtAd>
{
  public GdtAd a(Parcel paramParcel)
  {
    return new GdtAd(paramParcel);
  }
  
  public GdtAd[] a(int paramInt)
  {
    return new GdtAd[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aams
 * JD-Core Version:    0.7.0.1
 */