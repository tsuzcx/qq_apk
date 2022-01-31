import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper;
import mqq.os.MqqHandler;

class agoz
  implements Runnable
{
  agoz(agou paramagou, long paramLong) {}
  
  public void run()
  {
    String str = ShareHelper.a(this.jdField_a_of_type_Agou.a);
    ThreadManager.getUIHandler().post(new agpa(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agoz
 * JD-Core Version:    0.7.0.1
 */