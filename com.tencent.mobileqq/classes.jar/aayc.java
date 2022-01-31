import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkMessageServerLogic.SearchArkBabyQInfo;
import com.tencent.mobileqq.ark.ArkRecommendLogic.SemanticAnalysisResult;
import java.lang.ref.WeakReference;

class aayc
  implements Runnable
{
  aayc(aayb paramaayb, ArkMessageServerLogic.SearchArkBabyQInfo paramSearchArkBabyQInfo, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Aayb.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      ArkAppCenter.b("ArkApp.ArkRecommendLogic", String.format("sendBabyQTextIntent, this is null, return", new Object[0]));
    }
    ArkRecommendLogic.SemanticAnalysisResult localSemanticAnalysisResult;
    do
    {
      return;
      localSemanticAnalysisResult = (ArkRecommendLogic.SemanticAnalysisResult)this.jdField_a_of_type_Aayb.b.get();
    } while (localSemanticAnalysisResult == null);
    localSemanticAnalysisResult.a(this.jdField_a_of_type_ComTencentMobileqqArkArkMessageServerLogic$SearchArkBabyQInfo, this.jdField_a_of_type_Aayb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aayc
 * JD-Core Version:    0.7.0.1
 */