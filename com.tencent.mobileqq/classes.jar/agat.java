import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper;
import mqq.os.MqqHandler;

class agat
  implements Runnable
{
  agat(agas paramagas) {}
  
  public void run()
  {
    String str = ShareHelper.a(this.a.a);
    ThreadManager.getUIHandler().post(new agau(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agat
 * JD-Core Version:    0.7.0.1
 */