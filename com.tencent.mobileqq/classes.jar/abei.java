import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAiInfo;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.IGetAppPathByActionCallback;
import com.tencent.mobileqq.ark.ArkRecommendController;
import com.tencent.mobileqq.ark.ArkRecommendController.ReferencCount;
import com.tencent.mobileqq.data.RecommendCommonMessage;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkContextInfo;
import java.util.ArrayList;
import java.util.Iterator;

public class abei
  implements Runnable
{
  public abei(ArkRecommendController paramArkRecommendController, RecommendCommonMessage paramRecommendCommonMessage, RecommendCommonMessage.ArkContextInfo paramArkContextInfo, ArkAiInfo paramArkAiInfo, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mContextList.add(this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkContextInfo);
    this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mEchoType = this.jdField_a_of_type_ComTencentMobileqqArkArkAiInfo.a;
    this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mContextMatchType = this.jdField_a_of_type_ComTencentMobileqqArkArkAiInfo.b;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (localQQAppInterface == null) {}
    for (;;)
    {
      return;
      ArkRecommendController.ReferencCount localReferencCount = new ArkRecommendController.ReferencCount();
      localReferencCount.a = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mContextList.size();
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mContextList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (RecommendCommonMessage.ArkContextInfo)localIterator.next();
        String[] arrayOfString = ((RecommendCommonMessage.ArkContextInfo)localObject).context.split("\\.");
        if (arrayOfString.length != 2)
        {
          localReferencCount.a -= 1;
        }
        else
        {
          ArkAppCenter localArkAppCenter = (ArkAppCenter)localQQAppInterface.getManager(120);
          localObject = new abej(this, (RecommendCommonMessage.ArkContextInfo)localObject);
          localArkAppCenter.a().a(arrayOfString[0], arrayOfString[1], 1, null, null, localReferencCount, (ArkLocalAppMgr.IGetAppPathByActionCallback)localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abei
 * JD-Core Version:    0.7.0.1
 */