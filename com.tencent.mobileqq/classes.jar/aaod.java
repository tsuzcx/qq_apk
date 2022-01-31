import android.text.TextUtils;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.GetAppPathByActionResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class aaod
  implements Runnable
{
  static
  {
    if (!ArkLocalAppMgr.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public aaod(ArkLocalAppMgr paramArkLocalAppMgr, int paramInt, String paramString1, String paramString2, aaov paramaaov, String paramString3) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_Int;
    Object localObject3 = this.jdField_a_of_type_JavaLangString;
    ??? = this.b;
    ArrayList localArrayList = new ArrayList();
    if ((i == 0) && (!TextUtils.isEmpty((CharSequence)localObject3)))
    {
      ArkLocalAppMgr.a((String)localObject3, String.format("%s.%s", new Object[] { this.jdField_a_of_type_Aaov.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aaov.b }), this.jdField_a_of_type_Aaov.jdField_a_of_type_Int, localArrayList);
      if (!localArrayList.isEmpty()) {
        break label448;
      }
      ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("findAppViewMatchAction, not match, context=%s, action=%s, app-name=%s", new Object[] { this.jdField_a_of_type_Aaov.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aaov.b, this.c }));
      i = -1;
      ??? = "Action NOT Matched";
    }
    label448:
    for (;;)
    {
      if (localArrayList.isEmpty())
      {
        if ((!jdField_a_of_type_Boolean) && (i == 0))
        {
          throw new AssertionError();
          if (i == 0) {
            i = -1;
          }
        }
        else
        {
          localObject3 = new ArkLocalAppMgr.GetAppPathByActionResult();
          ((ArkLocalAppMgr.GetAppPathByActionResult)localObject3).b = this.c;
          ((ArkLocalAppMgr.GetAppPathByActionResult)localObject3).jdField_a_of_type_Int = i;
          ((ArkLocalAppMgr.GetAppPathByActionResult)localObject3).jdField_a_of_type_JavaLangString = ((String)???);
          ((ArkLocalAppMgr.GetAppPathByActionResult)localObject3).c = null;
          ((ArkLocalAppMgr.GetAppPathByActionResult)localObject3).d = null;
          ((ArkLocalAppMgr.GetAppPathByActionResult)localObject3).e = null;
          localArrayList.add(localObject3);
        }
      }
      else {
        synchronized (this.jdField_a_of_type_Aaov)
        {
          this.jdField_a_of_type_Aaov.c.addAll(localArrayList);
          this.jdField_a_of_type_Aaov.jdField_a_of_type_JavaUtilSet.remove(this.c);
          if (this.jdField_a_of_type_Aaov.jdField_a_of_type_JavaUtilSet.isEmpty())
          {
            this.jdField_a_of_type_Aaov.jdField_a_of_type_Boolean = true;
            ArkLocalAppMgr.a(this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr, this.jdField_a_of_type_Aaov);
            return;
            if ((!jdField_a_of_type_Boolean) && (i != 0)) {
              throw new AssertionError();
            }
            localObject3 = localArrayList.iterator();
            while (((Iterator)localObject3).hasNext())
            {
              ArkLocalAppMgr.GetAppPathByActionResult localGetAppPathByActionResult = (ArkLocalAppMgr.GetAppPathByActionResult)((Iterator)localObject3).next();
              localGetAppPathByActionResult.b = this.c;
              localGetAppPathByActionResult.jdField_a_of_type_Int = 0;
              localGetAppPathByActionResult.jdField_a_of_type_JavaLangString = ((String)???);
              localGetAppPathByActionResult.c = this.jdField_a_of_type_JavaLangString;
            }
          }
          ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("getAppByAction finished, action=%s.%s, app-count=%d, unfinished-count=%d", new Object[] { this.jdField_a_of_type_Aaov.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aaov.b, Integer.valueOf(this.jdField_a_of_type_Aaov.c.size()), Integer.valueOf(this.jdField_a_of_type_Aaov.jdField_a_of_type_JavaUtilSet.size()) }));
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaod
 * JD-Core Version:    0.7.0.1
 */