import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class alwm
{
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private HashMap<String, alwn> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public alwm(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  public alwn a(String paramString)
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
      paramString = (alwn)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      return paramString;
    }
  }
  
  public void a(String paramString, alwn paramalwn)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramalwn == null))
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
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramalwn);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alwm
 * JD-Core Version:    0.7.0.1
 */