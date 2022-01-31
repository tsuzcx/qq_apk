import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.ArkAppRootLayout.ArkSearchReportCallback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAdapterItemForTextMsg;
import com.tencent.mobileqq.ark.ArkAppHandler;
import com.tencent.mobileqq.data.RecommendCommonMessage;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkMsgAppInfo;

public class aarj
  implements ArkAppRootLayout.ArkSearchReportCallback
{
  public aarj(ArkAdapterItemForTextMsg paramArkAdapterItemForTextMsg) {}
  
  public void a()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    int i;
    String str1;
    String str2;
    String str3;
    String str4;
    String str5;
    if (localObject != null)
    {
      localObject = (ArkAppHandler)((QQAppInterface)localObject).a(95);
      if (!this.a.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.isFromArkServer) {
        break label142;
      }
      i = 2;
      str1 = this.a.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.arkServerExtraInfo;
      str2 = this.a.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.arkServerMsgId;
      str3 = this.a.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appName;
      str4 = this.a.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appView;
      str5 = this.a.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.msg;
      if (!"1".equals(this.a.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.getExtInfoFromExtStr("ark_text_analysis_flag"))) {
        break label148;
      }
    }
    label142:
    label148:
    for (int j = 1;; j = 0)
    {
      ((ArkAppHandler)localObject).a(i, 4, 2, str1, str2, str3, str4, str5, j, 0);
      return;
      i = 100;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aarj
 * JD-Core Version:    0.7.0.1
 */