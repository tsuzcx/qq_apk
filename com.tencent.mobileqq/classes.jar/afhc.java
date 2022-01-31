import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;

public class afhc
  implements Runnable
{
  public afhc(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void run()
  {
    if ((this.a.a.a != null) && (this.a.a.a.equals(this.a.app.getCurrentAccountUin()))) {
      ((LocalRedTouchManager)this.a.app.getManager(159)).a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afhc
 * JD-Core Version:    0.7.0.1
 */