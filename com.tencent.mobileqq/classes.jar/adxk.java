import android.app.Activity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import mqq.os.MqqHandler;

public class adxk
  implements Runnable
{
  public adxk(UiApiPlugin paramUiApiPlugin, Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public void run()
  {
    boolean bool = UiApiPlugin.a(this.jdField_a_of_type_AndroidAppActivity, UiApiPlugin.a(this.jdField_a_of_type_AndroidAppActivity, null, this.jdField_a_of_type_JavaLangString, "qqbrowser_float_shortcut"), this.b, this.c);
    ThreadManager.getUIHandler().post(new adxl(this, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adxk
 * JD-Core Version:    0.7.0.1
 */