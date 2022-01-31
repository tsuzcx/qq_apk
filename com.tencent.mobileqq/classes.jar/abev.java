import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkMessageServerLogic.ArkPassiveSearchInfo;
import com.tencent.mobileqq.ark.ArkRecommendLogic.SemanticAnalysisResult;
import java.lang.ref.WeakReference;

class abev
  implements Runnable
{
  abev(abeu paramabeu, ArkMessageServerLogic.ArkPassiveSearchInfo paramArkPassiveSearchInfo) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Abeu.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      ArkAppCenter.b("ArkApp.ArkRecommendLogic", String.format("passiveSearchText, this is null, return", new Object[0]));
    }
    ArkRecommendLogic.SemanticAnalysisResult localSemanticAnalysisResult;
    do
    {
      return;
      localSemanticAnalysisResult = (ArkRecommendLogic.SemanticAnalysisResult)this.jdField_a_of_type_Abeu.b.get();
    } while (localSemanticAnalysisResult == null);
    localSemanticAnalysisResult.a(this.jdField_a_of_type_Abeu.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage, this.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$ArkPassiveSearchInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abev
 * JD-Core Version:    0.7.0.1
 */