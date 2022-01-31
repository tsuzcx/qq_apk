import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper;
import mqq.os.MqqHandler;

class agox
  implements Runnable
{
  agox(agou paramagou) {}
  
  public void run()
  {
    String str = ShareHelper.a(this.a.a);
    ThreadManager.getUIHandler().post(new agoy(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agox
 * JD-Core Version:    0.7.0.1
 */