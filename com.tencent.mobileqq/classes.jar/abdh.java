import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppSSO;
import com.tencent.mobileqq.ark.ArkMessageServerLogic;
import com.tencent.mobileqq.ark.ArkMessageServerLogic.IAnalyzeTextIntentByServerHandler;

class abdh
  implements Runnable
{
  abdh(abdg paramabdg, abdt paramabdt, String paramString) {}
  
  public void run()
  {
    if (ArkMessageServerLogic.a(this.jdField_a_of_type_Abdt.jdField_a_of_type_JavaLangString)) {
      ArkAppCenter.b("ArkApp.ArkMessageServerLogic", "analyzeTextIntentByServer, skip text");
    }
    for (;;)
    {
      ArkAppCenter.b("ArkApp.ArkMessageServerLogic", "analyzeTextIntentByServer, fail");
      if (this.jdField_a_of_type_Abdt.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$IAnalyzeTextIntentByServerHandler != null) {
        this.jdField_a_of_type_Abdt.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$IAnalyzeTextIntentByServerHandler.a(this.jdField_a_of_type_Abdt.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Abdt.jdField_a_of_type_JavaLangObject, null);
      }
      Object localObject;
      String str;
      do
      {
        return;
        localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        if (localObject == null)
        {
          ArkAppCenter.b("ArkApp.ArkMessageServerLogic", "analyzeTextIntentByServer, qq app is null");
          break;
        }
        localObject = (ArkAppCenter)((QQAppInterface)localObject).getManager(120);
        if (localObject == null)
        {
          ArkAppCenter.b("ArkApp.ArkMessageServerLogic", "analyzeTextIntentByServer, ark center is null");
          break;
        }
        localObject = ((ArkAppCenter)localObject).a();
        if (localObject == null)
        {
          ArkAppCenter.b("ArkApp.ArkMessageServerLogic", "analyzeTextIntentByServer, ark sso is null");
          break;
        }
        str = ArkMessageServerLogic.a(this.jdField_a_of_type_Abdt, this.jdField_a_of_type_JavaLangString);
        if (TextUtils.isEmpty(str))
        {
          ArkAppCenter.b("ArkApp.ArkMessageServerLogic", "analyzeTextIntentByServer, req json is null");
          break;
        }
      } while (((ArkAppSSO)localObject).a("ArkTextSvc.AnalyzeTextIntent", str, 10000, 0, new abdi(this)));
      ArkAppCenter.b("ArkApp.ArkMessageServerLogic", "analyzeTextIntentByServer, fail send sso request");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abdh
 * JD-Core Version:    0.7.0.1
 */