import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkActionAppMgr;
import com.tencent.mobileqq.ark.ArkAppCGI.ActionAppUpdateInfo;
import com.tencent.mobileqq.ark.ArkAppCenter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

class aaqy
  implements Runnable
{
  aaqy(aaqx paramaaqx, ArrayList paramArrayList) {}
  
  public void run()
  {
    aard localaard2 = null;
    if ((ArkActionAppMgr)this.jdField_a_of_type_Aaqx.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    aard localaard1 = null;
    ArkAppCGI.ActionAppUpdateInfo localActionAppUpdateInfo;
    while (localIterator.hasNext())
    {
      localActionAppUpdateInfo = (ArkAppCGI.ActionAppUpdateInfo)localIterator.next();
      ArkAppCenter.b("ArkApp.ActionAppMgr", String.format("_checkActionNeedUpdate, action=%s.%s, gray-appid=%d, appid=%d, need-update=%s", new Object[] { localActionAppUpdateInfo.jdField_a_of_type_JavaLangString, localActionAppUpdateInfo.jdField_b_of_type_JavaLangString, Long.valueOf(localActionAppUpdateInfo.jdField_b_of_type_Long), Long.valueOf(localActionAppUpdateInfo.jdField_a_of_type_Long), Boolean.toString(localActionAppUpdateInfo.jdField_a_of_type_Boolean) }));
      if (localActionAppUpdateInfo.jdField_a_of_type_Boolean)
      {
        ArkActionAppMgr.a(this.jdField_a_of_type_Aaqx.jdField_a_of_type_ComTencentMobileqqArkArkActionAppMgr, localActionAppUpdateInfo.jdField_a_of_type_JavaLangString, localActionAppUpdateInfo.jdField_b_of_type_JavaLangString, localActionAppUpdateInfo.jdField_b_of_type_Long, localActionAppUpdateInfo.jdField_a_of_type_Long);
      }
      else
      {
        label151:
        if (localaard1 != null) {
          break label269;
        }
        localaard1 = new aard();
        localaard1.a(this.jdField_a_of_type_Aaqx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), 2);
      }
    }
    label269:
    for (;;)
    {
      if (localaard2 == null)
      {
        localaard2 = new aard();
        localaard2.a(this.jdField_a_of_type_Aaqx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), 1);
      }
      for (;;)
      {
        localaard1.a(localActionAppUpdateInfo.jdField_a_of_type_JavaLangString, localActionAppUpdateInfo.jdField_b_of_type_JavaLangString);
        localaard2.a(localActionAppUpdateInfo.jdField_a_of_type_JavaLangString, localActionAppUpdateInfo.jdField_b_of_type_JavaLangString);
        break label151;
        if (localaard1 != null) {
          localaard1.a();
        }
        if (localaard2 == null) {
          break;
        }
        localaard2.a();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaqy
 * JD-Core Version:    0.7.0.1
 */