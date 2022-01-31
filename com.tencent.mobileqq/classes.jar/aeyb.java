import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.now.send.PublishManager;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.DeleteFeedCallback;
import mqq.os.MqqHandler;

public class aeyb
  implements Runnable
{
  public aeyb(NearbyMomentManager paramNearbyMomentManager, String paramString, NearbyMomentManager.DeleteFeedCallback paramDeleteFeedCallback) {}
  
  public void run()
  {
    boolean bool = PublishManager.a(this.jdField_a_of_type_JavaLangString);
    ThreadManager.getUIHandler().post(new aeyc(this, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeyb
 * JD-Core Version:    0.7.0.1
 */