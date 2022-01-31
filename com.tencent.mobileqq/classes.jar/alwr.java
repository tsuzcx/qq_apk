import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qappcenter.remote.RecvMsg;

public final class alwr
  implements Parcelable.Creator
{
  public RecvMsg a(Parcel paramParcel)
  {
    return new RecvMsg(paramParcel);
  }
  
  public RecvMsg[] a(int paramInt)
  {
    return new RecvMsg[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alwr
 * JD-Core Version:    0.7.0.1
 */