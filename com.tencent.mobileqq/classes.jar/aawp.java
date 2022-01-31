import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppSSO;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.mobileqq.ark.ArkMessageServerLogic;
import com.tencent.mobileqq.ark.ArkMessageServerLogic.IAnalyzeArkBabyQReplyByServerHandler;

class aawp
  implements Runnable
{
  aawp(aawo paramaawo, aawy paramaawy, String paramString, double paramDouble1, double paramDouble2) {}
  
  public void run()
  {
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (localObject1 == null) {
      ArkAppCenter.b("ArkApp.ArkMessageServerLogic", "sendBabyQTextIntent, qq app is null");
    }
    for (;;)
    {
      ArkAppCenter.b("ArkApp.ArkMessageServerLogic", "sendBabyQTextIntent, fail");
      if (this.jdField_a_of_type_Aawy.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$IAnalyzeArkBabyQReplyByServerHandler != null) {
        this.jdField_a_of_type_Aawy.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$IAnalyzeArkBabyQReplyByServerHandler.a(this.jdField_a_of_type_Aawy.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aawy.jdField_a_of_type_JavaLangObject, null, true);
      }
      Object localObject2;
      String str;
      do
      {
        return;
        localObject2 = (ArkAppCenter)((QQAppInterface)localObject1).getManager(120);
        if (localObject2 == null)
        {
          ArkAppCenter.b("ArkApp.ArkMessageServerLogic", "sendBabyQTextIntent, ark center is null");
          break;
        }
        localObject1 = ((ArkAppCenter)localObject2).a();
        localObject2 = ((ArkAppCenter)localObject2).a();
        if (localObject2 == null)
        {
          ArkAppCenter.b("ArkApp.ArkMessageServerLogic", "sendBabyQTextIntent, ark sso is null");
          break;
        }
        str = ArkMessageServerLogic.a(this.jdField_a_of_type_Aawy, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Double, this.b);
        if (TextUtils.isEmpty(str))
        {
          ArkAppCenter.b("ArkApp.ArkMessageServerLogic", "sendBabyQTextIntent, req json is null");
          break;
        }
      } while (((ArkAppSSO)localObject2).a("ArkSearchService.ActiveSearch", str, 10000, 0, new aawq(this, (ArkLocalAppMgr)localObject1)));
      ArkAppCenter.b("ArkApp.ArkMessageServerLogic", "sendBabyQTextIntent, fail send sso request");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aawp
 * JD-Core Version:    0.7.0.1
 */