import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketInfoBase;

public final class agqp
  implements Parcelable.Creator<RedPacketInfoBase>
{
  public RedPacketInfoBase a(Parcel paramParcel)
  {
    return new RedPacketInfoBase(paramParcel);
  }
  
  public RedPacketInfoBase[] a(int paramInt)
  {
    return new RedPacketInfoBase[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agqp
 * JD-Core Version:    0.7.0.1
 */