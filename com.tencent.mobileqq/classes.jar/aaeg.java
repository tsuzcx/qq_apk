import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.ar.ARRecognition;

public final class aaeg
  implements Parcelable.Creator
{
  public ARRecognition a(Parcel paramParcel)
  {
    return new ARRecognition(paramParcel);
  }
  
  public ARRecognition[] a(int paramInt)
  {
    return new ARRecognition[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaeg
 * JD-Core Version:    0.7.0.1
 */