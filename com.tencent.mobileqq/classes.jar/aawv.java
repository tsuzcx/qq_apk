import android.text.TextUtils;
import com.tencent.mobileqq.ark.ArkAiInfo;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.IGetAppViewByIntentCallback;
import com.tencent.mobileqq.ark.ArkMessageServerLogic.ArkPassiveSearchInfo;
import com.tencent.mobileqq.ark.ArkMessageServerLogic.IPassiveSearchIntentByServerHandler;
import java.util.ArrayList;

class aawv
  implements ArkLocalAppMgr.IGetAppViewByIntentCallback
{
  aawv(aawu paramaawu, ArkAiInfo paramArkAiInfo, ArkMessageServerLogic.ArkPassiveSearchInfo paramArkPassiveSearchInfo, int paramInt1, int paramInt2) {}
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if ((!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString4)))
    {
      this.jdField_a_of_type_ComTencentMobileqqArkArkAiInfo.d = paramString3;
      this.jdField_a_of_type_ComTencentMobileqqArkArkAiInfo.b = paramString4;
      this.jdField_a_of_type_ComTencentMobileqqArkArkAiInfo.e = ArkAppCenter.b(paramString3);
      this.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$ArkPassiveSearchInfo.a.add(this.jdField_a_of_type_ComTencentMobileqqArkArkAiInfo);
    }
    if ((this.jdField_a_of_type_Int == this.b - 1) && (this.jdField_a_of_type_Aawu.a.a.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$IPassiveSearchIntentByServerHandler != null)) {
      this.jdField_a_of_type_Aawu.a.a.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$IPassiveSearchIntentByServerHandler.a(this.jdField_a_of_type_Aawu.a.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aawu.a.a.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$ArkPassiveSearchInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aawv
 * JD-Core Version:    0.7.0.1
 */