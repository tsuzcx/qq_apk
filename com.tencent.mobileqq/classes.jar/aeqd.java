import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;

public class aeqd
  implements Runnable
{
  public aeqd(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public void run()
  {
    Object localObject = (FriendsManager)this.a.a.app.getManager(50);
    if (localObject == null) {}
    for (localObject = null;; localObject = ((FriendsManager)localObject).a(this.a.a.getCurrentAccountUin()))
    {
      this.a.a.runOnUiThread(new aeqe(this, (Card)localObject));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeqd
 * JD-Core Version:    0.7.0.1
 */