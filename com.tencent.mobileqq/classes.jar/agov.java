import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper;
import mqq.os.MqqHandler;

class agov
  implements Runnable
{
  agov(agou paramagou) {}
  
  public void run()
  {
    String str = ShareHelper.a(this.a.a);
    ThreadManager.getUIHandler().post(new agow(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agov
 * JD-Core Version:    0.7.0.1
 */