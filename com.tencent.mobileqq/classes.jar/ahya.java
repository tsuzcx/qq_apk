import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.teamwork.ReSendCmd;

public final class ahya
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ahya
 * JD-Core Version:    0.7.0.1
 */