import android.text.TextUtils;
import com.tencent.mobileqq.ark.ArkAiInfo;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.IGetAppViewByIntentCallback;
import com.tencent.mobileqq.ark.ArkMessageServerLogic.IAnalyzeArkBabyQReplyByServerHandler;
import com.tencent.mobileqq.ark.ArkMessageServerLogic.SearchArkBabyQInfo;
import java.util.ArrayList;

class aapq
  implements ArkLocalAppMgr.IGetAppViewByIntentCallback
{
  aapq(aapp paramaapp, ArkAiInfo paramArkAiInfo, ArkMessageServerLogic.SearchArkBabyQInfo paramSearchArkBabyQInfo, int paramInt1, int paramInt2) {}
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if ((!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString4)))
    {
      this.jdField_a_of_type_ComTencentMobileqqArkArkAiInfo.d = paramString3;
      this.jdField_a_of_type_ComTencentMobileqqArkArkAiInfo.b = paramString4;
      this.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$SearchArkBabyQInfo.a.add(this.jdField_a_of_type_ComTencentMobileqqArkArkAiInfo);
    }
    if ((this.jdField_a_of_type_Int == this.b - 1) && (this.jdField_a_of_type_Aapp.a.a.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$IAnalyzeArkBabyQReplyByServerHandler != null)) {
      this.jdField_a_of_type_Aapp.a.a.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$IAnalyzeArkBabyQReplyByServerHandler.a(this.jdField_a_of_type_Aapp.a.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aapp.a.a.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$SearchArkBabyQInfo, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aapq
 * JD-Core Version:    0.7.0.1
 */