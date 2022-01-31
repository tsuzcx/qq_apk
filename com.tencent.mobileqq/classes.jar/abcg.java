import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCGI;
import com.tencent.mobileqq.ark.ArkAppCGI.AppNameVersion;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppInfo.AppDesc;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.AppPathInfo;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.UpdateAppByNameTask;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class abcg
  implements Runnable
{
  public abcg(ArkLocalAppMgr paramArkLocalAppMgr, ArrayList paramArrayList, Object paramObject, abcy paramabcy, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    String str;
    if (localIterator.hasNext()) {
      str = (String)localIterator.next();
    }
    for (;;)
    {
      synchronized (ArkLocalAppMgr.a(this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr))
      {
        ??? = ArkLocalAppMgr.a(this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr).iterator();
        if (!((Iterator)???).hasNext()) {
          break label366;
        }
        localUpdateAppByNameTask = (ArkLocalAppMgr.UpdateAppByNameTask)((Iterator)???).next();
        if (!localUpdateAppByNameTask.jdField_b_of_type_JavaLangString.equalsIgnoreCase(str)) {
          continue;
        }
        localUpdateAppByNameTask.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_JavaLangObject);
        localUpdateAppByNameTask.jdField_b_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_Abcy);
        i = 1;
        if (i != 0) {
          ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("updateAppByNameBatch, request merged, appname=%s", new Object[] { str }));
        }
      }
      ??? = ArkLocalAppMgr.a(str);
      ArkLocalAppMgr.UpdateAppByNameTask localUpdateAppByNameTask = new ArkLocalAppMgr.UpdateAppByNameTask(null);
      localUpdateAppByNameTask.jdField_b_of_type_JavaLangString = str;
      localUpdateAppByNameTask.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo = ((ArkLocalAppMgr.AppPathInfo)???);
      localUpdateAppByNameTask.jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo = null;
      localUpdateAppByNameTask.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_JavaLangObject);
      localUpdateAppByNameTask.jdField_b_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_Abcy);
      for (;;)
      {
        synchronized (ArkLocalAppMgr.a(this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr))
        {
          ArkLocalAppMgr.a(this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr).add(localUpdateAppByNameTask);
          localObject1.put(str, localUpdateAppByNameTask);
          ??? = new ArkAppCGI.AppNameVersion();
          ((ArkAppCGI.AppNameVersion)???).a = str;
          if ((??? != null) && (((ArkLocalAppMgr.AppPathInfo)???).a != null))
          {
            ((ArkAppCGI.AppNameVersion)???).jdField_b_of_type_JavaLangString = ((ArkLocalAppMgr.AppPathInfo)???).a.jdField_b_of_type_JavaLangString;
            localArrayList.add(???);
          }
        }
        ((ArkAppCGI.AppNameVersion)???).jdField_b_of_type_JavaLangString = "0.0.0.0";
      }
      ((ArkAppCenter)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(120)).a().a(localArrayList, localObject2, new abch(this));
      return;
      label366:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abcg
 * JD-Core Version:    0.7.0.1
 */