import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.TroopAdmin;

public final class afpc
  implements Parcelable.Creator<ChatHistoryTroopMemberFragment.TroopAdmin>
{
  public ChatHistoryTroopMemberFragment.TroopAdmin a(Parcel paramParcel)
  {
    return new ChatHistoryTroopMemberFragment.TroopAdmin(paramParcel, null);
  }
  
  public ChatHistoryTroopMemberFragment.TroopAdmin[] a(int paramInt)
  {
    return new ChatHistoryTroopMemberFragment.TroopAdmin[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afpc
 * JD-Core Version:    0.7.0.1
 */