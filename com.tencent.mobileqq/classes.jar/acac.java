import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.operation.QQOperateManager;
import com.tencent.qphone.base.util.QLog;

public class acac
  implements Runnable
{
  public acac(QQOperateManager paramQQOperateManager, int paramInt) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(QQOperateManager.a())) {
      PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit().putInt(QQOperateManager.a() + "QQOperationVoIPRequestCount", this.jdField_a_of_type_Int).commit();
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("QQOperateVoIP", 4, "onDestroy.......");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     acac
 * JD-Core Version:    0.7.0.1
 */