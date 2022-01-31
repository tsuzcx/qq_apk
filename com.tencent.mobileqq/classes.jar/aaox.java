import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.IGetLocalAppPath;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public final class aaox
  implements Runnable
{
  public ArkLocalAppMgr.IGetLocalAppPath a;
  public String a;
  public WeakReference a;
  public String b;
  
  public aaox(ArkLocalAppMgr paramArkLocalAppMgr, String paramString1, String paramString2, ArkLocalAppMgr.IGetLocalAppPath paramIGetLocalAppPath)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramArkLocalAppMgr);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$IGetLocalAppPath = paramIGetLocalAppPath;
  }
  
  public void run()
  {
    Object localObject = (ArkLocalAppMgr)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkLocalAppMgr", 2, "ArkLocalAppMgr.GetAppPathTask.object.null");
      }
    }
    do
    {
      return;
      localObject = ((ArkLocalAppMgr)localObject).a(this.jdField_a_of_type_JavaLangString, this.b);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ArkApp.ArkLocalAppMgr", 2, "ArkLocalAppMgr.GetAppPathTask.path.null");
    return;
    ArkAppCenter.a().postToMainThread(new aaoy(this, (String)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaox
 * JD-Core Version:    0.7.0.1
 */