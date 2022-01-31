import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;

public final class agpa
  implements Parcelable.Creator<PhotoSendParams>
{
  public PhotoSendParams a(Parcel paramParcel)
  {
    return new PhotoSendParams(paramParcel);
  }
  
  public PhotoSendParams[] a(int paramInt)
  {
    return new PhotoSendParams[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agpa
 * JD-Core Version:    0.7.0.1
 */