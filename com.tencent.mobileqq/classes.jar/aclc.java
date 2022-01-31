import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.TroopMemberListActivity.TroopAdmin;

public final class aclc
  implements Parcelable.Creator<TroopMemberListActivity.TroopAdmin>
{
  public TroopMemberListActivity.TroopAdmin a(Parcel paramParcel)
  {
    return new TroopMemberListActivity.TroopAdmin(paramParcel, null);
  }
  
  public TroopMemberListActivity.TroopAdmin[] a(int paramInt)
  {
    return new TroopMemberListActivity.TroopAdmin[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aclc
 * JD-Core Version:    0.7.0.1
 */