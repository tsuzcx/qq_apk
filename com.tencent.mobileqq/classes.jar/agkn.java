import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.aio.SessionInfo;

public final class agkn
  implements Parcelable.Creator<SessionInfo>
{
  public SessionInfo a(Parcel paramParcel)
  {
    return new SessionInfo(paramParcel);
  }
  
  public SessionInfo[] a(int paramInt)
  {
    return new SessionInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agkn
 * JD-Core Version:    0.7.0.1
 */