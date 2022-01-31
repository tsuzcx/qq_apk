import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.troop.createNewTroop.ContactListAdapter;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopContactView;

public class ainf
  extends FriendListObserver
{
  public ainf(NewTroopContactView paramNewTroopContactView) {}
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ainf
 * JD-Core Version:    0.7.0.1
 */