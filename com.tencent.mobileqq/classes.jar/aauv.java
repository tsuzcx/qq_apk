import android.text.TextUtils;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppInfo.AppDesc;
import com.tencent.mobileqq.ark.ArkAppInfo.AppDownloadInfo;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.AppPathInfo;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.UpdateAppByNameTask;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.UpdateAppByNameTask.Result;
import java.util.HashMap;
import java.util.Locale;

public class aauv
  implements aawd
{
  public aauv(ArkLocalAppMgr paramArkLocalAppMgr) {}
  
  public void a(ArkLocalAppMgr.UpdateAppByNameTask paramUpdateAppByNameTask, Object arg2)
  {
    for (;;)
    {
      synchronized (ArkLocalAppMgr.a(this.a))
      {
        ArkLocalAppMgr.a(this.a).remove(paramUpdateAppByNameTask.jdField_b_of_type_JavaLangString);
        if ((paramUpdateAppByNameTask.jdField_a_of_type_Int == 1) || (paramUpdateAppByNameTask.jdField_a_of_type_Int == 2))
        {
          String str = "";
          ??? = str;
          if (paramUpdateAppByNameTask.jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo != null)
          {
            ??? = str;
            if (paramUpdateAppByNameTask.jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo.a != null)
            {
              ??? = str;
              if (!TextUtils.isEmpty(paramUpdateAppByNameTask.jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo.a.jdField_b_of_type_JavaLangString)) {
                ??? = paramUpdateAppByNameTask.jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo.a.jdField_b_of_type_JavaLangString;
              }
            }
          }
          if (paramUpdateAppByNameTask.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDownloadInfo == null) {
            break label198;
          }
          i = paramUpdateAppByNameTask.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDownloadInfo.jdField_a_of_type_Int;
          ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format(Locale.CHINA, "runUpdateLocalAppTask, updateAppByName success, result=%s, app-name=%s, app-version=%s, update-period=%d", new Object[] { ArkLocalAppMgr.UpdateAppByNameTask.Result.a(paramUpdateAppByNameTask.jdField_a_of_type_Int), paramUpdateAppByNameTask.jdField_b_of_type_JavaLangString, ???, Integer.valueOf(i) }));
          return;
        }
      }
      ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("runUpdateLocalAppTask, updateAppByName fail, result=%s, app-name=%s", new Object[] { ArkLocalAppMgr.UpdateAppByNameTask.Result.a(paramUpdateAppByNameTask.jdField_a_of_type_Int), paramUpdateAppByNameTask.jdField_b_of_type_JavaLangString }));
      return;
      label198:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aauv
 * JD-Core Version:    0.7.0.1
 */