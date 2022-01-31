import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.app.addfriendverifi.data.AddFriendBlockedInfo;

public final class akkf
  implements Parcelable.Creator<AddFriendBlockedInfo>
{
  public AddFriendBlockedInfo a(Parcel paramParcel)
  {
    return new AddFriendBlockedInfo(paramParcel);
  }
  
  public AddFriendBlockedInfo[] a(int paramInt)
  {
    return new AddFriendBlockedInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akkf
 * JD-Core Version:    0.7.0.1
 */