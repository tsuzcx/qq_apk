import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class alwl
{
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private HashMap<String, alwm> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public alwl(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  public alwm a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ArkApp.ArkMessagePreprocessorMgr", 2, "AAShare.getPreprocessor in valid param");
      }
      return null;
    }
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      paramString = (alwm)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      return paramString;
    }
  }
  
  public void a(String paramString, alwm paramalwm)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramalwm == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ArkApp.ArkMessagePreprocessorMgr", 2, "AAShare.setPreprocessor in valid param");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("ArkApp.ArkMessagePreprocessorMgr", 2, new Object[] { "AAShare.setPreprocessor app=", paramString });
    }
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramalwm);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alwl
 * JD-Core Version:    0.7.0.1
 */