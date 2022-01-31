import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.lightReply.LightReplyMenuManager;
import com.tencent.mobileqq.utils.FileUtils;
import mqq.os.MqqHandler;

public class aecb
  implements Runnable
{
  public aecb(LightReplyMenuManager paramLightReplyMenuManager, String paramString1, String paramString2) {}
  
  public void run()
  {
    synchronized ()
    {
      boolean bool = FileUtils.a(this.jdField_a_of_type_JavaLangString, this.b);
      if (!bool) {
        ThreadManager.getUIHandler().post(new aecc(this));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aecb
 * JD-Core Version:    0.7.0.1
 */