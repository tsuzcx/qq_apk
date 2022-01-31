import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkActionAppMgr;
import com.tencent.mobileqq.ark.ArkAppCGI.ActionAppUpdateInfo;
import com.tencent.mobileqq.ark.ArkAppCenter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

class aajx
  implements Runnable
{
  aajx(aajw paramaajw, ArrayList paramArrayList) {}
  
  public void run()
  {
    aakc localaakc2 = null;
    if ((ArkActionAppMgr)this.jdField_a_of_type_Aajw.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    aakc localaakc1 = null;
    ArkAppCGI.ActionAppUpdateInfo localActionAppUpdateInfo;
    while (localIterator.hasNext())
    {
      localActionAppUpdateInfo = (ArkAppCGI.ActionAppUpdateInfo)localIterator.next();
      ArkAppCenter.b("ArkApp.ActionAppMgr", String.format("_checkActionNeedUpdate, action=%s.%s, gray-appid=%d, appid=%d, need-update=%s", new Object[] { localActionAppUpdateInfo.jdField_a_of_type_JavaLangString, localActionAppUpdateInfo.jdField_b_of_type_JavaLangString, Long.valueOf(localActionAppUpdateInfo.jdField_b_of_type_Long), Long.valueOf(localActionAppUpdateInfo.jdField_a_of_type_Long), Boolean.toString(localActionAppUpdateInfo.jdField_a_of_type_Boolean) }));
      if (localActionAppUpdateInfo.jdField_a_of_type_Boolean)
      {
        ArkActionAppMgr.a(this.jdField_a_of_type_Aajw.jdField_a_of_type_ComTencentMobileqqArkArkActionAppMgr, localActionAppUpdateInfo.jdField_a_of_type_JavaLangString, localActionAppUpdateInfo.jdField_b_of_type_JavaLangString, localActionAppUpdateInfo.jdField_b_of_type_Long, localActionAppUpdateInfo.jdField_a_of_type_Long);
      }
      else
      {
        label151:
        if (localaakc1 != null) {
          break label269;
        }
        localaakc1 = new aakc();
        localaakc1.a(this.jdField_a_of_type_Aajw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), 2);
      }
    }
    label269:
    for (;;)
    {
      if (localaakc2 == null)
      {
        localaakc2 = new aakc();
        localaakc2.a(this.jdField_a_of_type_Aajw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), 1);
      }
      for (;;)
      {
        localaakc1.a(localActionAppUpdateInfo.jdField_a_of_type_JavaLangString, localActionAppUpdateInfo.jdField_b_of_type_JavaLangString);
        localaakc2.a(localActionAppUpdateInfo.jdField_a_of_type_JavaLangString, localActionAppUpdateInfo.jdField_b_of_type_JavaLangString);
        break label151;
        if (localaakc1 != null) {
          localaakc1.a();
        }
        if (localaakc2 == null) {
          break;
        }
        localaakc2.a();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aajx
 * JD-Core Version:    0.7.0.1
 */