import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.gdtad.aditem.GdtHandler.Options;

public final class acak
  implements Parcelable.Creator<GdtHandler.Options>
{
  public GdtHandler.Options a(Parcel paramParcel)
  {
    return new GdtHandler.Options(paramParcel);
  }
  
  public GdtHandler.Options[] a(int paramInt)
  {
    return new GdtHandler.Options[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acak
 * JD-Core Version:    0.7.0.1
 */