import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.teamwork.ReSendCmd;

public final class aiqy
  implements Parcelable.Creator
{
  public ReSendCmd a(Parcel paramParcel)
  {
    return new ReSendCmd(paramParcel);
  }
  
  public ReSendCmd[] a(int paramInt)
  {
    return new ReSendCmd[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiqy
 * JD-Core Version:    0.7.0.1
 */