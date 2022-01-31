import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.qphone.base.util.QLog;

public class aait
  implements Runnable
{
  public aait(ArkAppModuleReg.ModuleQQ paramModuleQQ, String paramString) {}
  
  public void run()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((localBaseActivity instanceof FragmentActivity))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("forward_text", this.jdField_a_of_type_JavaLangString);
      Intent localIntent = new Intent();
      localIntent.putExtras(localBundle);
      localIntent.putExtra("direct_send_if_dataline_forward", true);
      ForwardBaseOption.a(localBaseActivity, localIntent, 21);
      if (QLog.isColorLevel()) {
        QLog.i("ArkApp", 1, "QQ.SendMessage text success.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aait
 * JD-Core Version:    0.7.0.1
 */