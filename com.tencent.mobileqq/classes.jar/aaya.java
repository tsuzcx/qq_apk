import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkMessageServerLogic.ArkPassiveSearchInfo;
import com.tencent.mobileqq.ark.ArkRecommendLogic.SemanticAnalysisResult;
import java.lang.ref.WeakReference;

class aaya
  implements Runnable
{
  aaya(aaxz paramaaxz, ArkMessageServerLogic.ArkPassiveSearchInfo paramArkPassiveSearchInfo) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Aaxz.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      ArkAppCenter.b("ArkApp.ArkRecommendLogic", String.format("passiveSearchText, this is null, return", new Object[0]));
    }
    ArkRecommendLogic.SemanticAnalysisResult localSemanticAnalysisResult;
    do
    {
      return;
      localSemanticAnalysisResult = (ArkRecommendLogic.SemanticAnalysisResult)this.jdField_a_of_type_Aaxz.b.get();
    } while (localSemanticAnalysisResult == null);
    localSemanticAnalysisResult.a(this.jdField_a_of_type_Aaxz.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage, this.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$ArkPassiveSearchInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaya
 * JD-Core Version:    0.7.0.1
 */