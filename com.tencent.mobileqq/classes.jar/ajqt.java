import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.7.1;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class ajqt
  implements ThreadExcutor.IThreadListener
{
  public ajqt(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    ThreadManager.getUIHandler().post(new TroopNotifyAndRecommendView.7.1(this));
  }
  
  public void onPreRun() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajqt
 * JD-Core Version:    0.7.0.1
 */