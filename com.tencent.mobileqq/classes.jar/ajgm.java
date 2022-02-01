import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.5.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class ajgm
  extends ajfp
{
  public ajgm(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((!paramBoolean) || (paramObject == null)) {
      return;
    }
    ThreadManager.getUIHandler().post(new TroopNotifyAndRecommendView.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajgm
 * JD-Core Version:    0.7.0.1
 */