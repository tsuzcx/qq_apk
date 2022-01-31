import android.text.TextUtils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.GetAppPathByActionResult;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.IGetAppPathByActionCallback;
import com.tencent.mobileqq.ark.ArkRecommendController;
import com.tencent.mobileqq.ark.ArkRecommendController.ReferencCount;
import com.tencent.mobileqq.data.RecommendCommonMessage;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkContextInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wordsegment.ContextAnalyze;
import java.util.ArrayList;
import java.util.Iterator;

class aaqn
  implements ArkLocalAppMgr.IGetAppPathByActionCallback
{
  aaqn(aaqm paramaaqm, RecommendCommonMessage.ArkContextInfo paramArkContextInfo) {}
  
  public void a(Object paramObject, ArrayList paramArrayList)
  {
    ArrayList localArrayList1 = this.jdField_a_of_type_Aaqm.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.a(this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkContextInfo.semantic);
    ArrayList localArrayList2 = this.jdField_a_of_type_Aaqm.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.a(this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkContextInfo.rawSemantic);
    paramArrayList = paramArrayList.iterator();
    int i = 0;
    for (;;)
    {
      int k;
      if (paramArrayList.hasNext())
      {
        Object localObject = (ArkLocalAppMgr.GetAppPathByActionResult)paramArrayList.next();
        k = i;
        if (((ArkLocalAppMgr.GetAppPathByActionResult)localObject).a != 0) {
          break label342;
        }
        k = i;
        if (((ArkLocalAppMgr.GetAppPathByActionResult)localObject).c == null) {
          break label342;
        }
        if (TextUtils.isEmpty(((ArkLocalAppMgr.GetAppPathByActionResult)localObject).e)) {
          continue;
        }
        String str = ContextAnalyze.descParser(((ArkLocalAppMgr.GetAppPathByActionResult)localObject).e, localArrayList1);
        localObject = ContextAnalyze.descParser(((ArkLocalAppMgr.GetAppPathByActionResult)localObject).e, localArrayList2);
        if (!TextUtils.isEmpty(str)) {
          this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkContextInfo.keyword = str;
        }
        if (this.jdField_a_of_type_Aaqm.jdField_a_of_type_JavaLangString.contains(this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkContextInfo.keyword)) {
          break label336;
        }
        j = i;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          j = i;
          if (this.jdField_a_of_type_Aaqm.jdField_a_of_type_JavaLangString.contains((CharSequence)localObject)) {
            this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkContextInfo.keyword = ((String)localObject);
          }
        }
      }
      label336:
      for (int j = 1;; j = 1)
      {
        k = j;
        if (j == 0) {
          break;
        }
        paramObject = (ArkRecommendController.ReferencCount)paramObject;
        i = paramObject.a - 1;
        paramObject.a = i;
        if (i == 0)
        {
          this.jdField_a_of_type_Aaqm.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.saveRecommendMsg(this.jdField_a_of_type_Aaqm.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.a, this.jdField_a_of_type_Aaqm.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.h, false);
          if (QLog.isColorLevel()) {
            QLog.d("ArkRecommendController", 2, "onFinishedAnalysis msg hasAiData=" + this.jdField_a_of_type_Aaqm.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.hasAiData());
          }
          if (ArkRecommendController.a(this.jdField_a_of_type_Aaqm.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController) != null) {
            ArkRecommendController.a(this.jdField_a_of_type_Aaqm.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController).a(this.jdField_a_of_type_Aaqm.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage, 0);
          }
        }
        return;
      }
      label342:
      i = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaqn
 * JD-Core Version:    0.7.0.1
 */