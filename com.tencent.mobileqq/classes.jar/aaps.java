import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppSSO;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.mobileqq.ark.ArkMessageServerLogic;
import com.tencent.mobileqq.ark.ArkMessageServerLogic.IPassiveSearchIntentByServerHandler;

class aaps
  implements Runnable
{
  aaps(aapr paramaapr, aapx paramaapx, String paramString, double paramDouble1, double paramDouble2) {}
  
  public void run()
  {
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (localObject1 == null) {
      ArkAppCenter.b("ArkApp.ArkMessageServerLogic", "sendPassiveSearchTextIntent, qq app is null");
    }
    for (;;)
    {
      ArkAppCenter.b("ArkApp.ArkMessageServerLogic", "sendPassiveSearchTextIntent, fail");
      if (this.jdField_a_of_type_Aapx.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$IPassiveSearchIntentByServerHandler != null) {
        this.jdField_a_of_type_Aapx.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$IPassiveSearchIntentByServerHandler.a(this.jdField_a_of_type_Aapx.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aapx.jdField_a_of_type_JavaLangObject, null);
      }
      Object localObject2;
      String str;
      do
      {
        return;
        localObject2 = (ArkAppCenter)((QQAppInterface)localObject1).getManager(120);
        if (localObject2 == null)
        {
          ArkAppCenter.b("ArkApp.ArkMessageServerLogic", "sendPassiveSearchTextIntent, ark center is null");
          break;
        }
        localObject1 = ((ArkAppCenter)localObject2).a();
        localObject2 = ((ArkAppCenter)localObject2).a();
        if (localObject2 == null)
        {
          ArkAppCenter.b("ArkApp.ArkMessageServerLogic", "sendPassiveSearchTextIntent, ark sso is null");
          break;
        }
        str = ArkMessageServerLogic.a(this.jdField_a_of_type_Aapx, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Double, this.b);
        if (TextUtils.isEmpty(str))
        {
          ArkAppCenter.b("ArkApp.ArkMessageServerLogic", "sendPassiveSearchTextIntent, req json is null");
          break;
        }
      } while (((ArkAppSSO)localObject2).a("ArkSearchService.PassiveSearch", str, 10000, 0, new aapt(this, (ArkLocalAppMgr)localObject1)));
      ArkAppCenter.b("ArkApp.ArkMessageServerLogic", "sendPassiveSearchTextIntent, fail send sso request");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaps
 * JD-Core Version:    0.7.0.1
 */