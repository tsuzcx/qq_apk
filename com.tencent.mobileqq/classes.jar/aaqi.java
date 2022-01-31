import com.tencent.mobileqq.ark.ArkRecommendController;
import com.tencent.mobileqq.ark.ArkRecommendLogic;
import com.tencent.mobileqq.data.RecommendCommonMessage;

public class aaqi
  implements Runnable
{
  public aaqi(ArkRecommendController paramArkRecommendController, RecommendCommonMessage paramRecommendCommonMessage) {}
  
  public void run()
  {
    if (ArkRecommendController.a(this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController) == null) {
      return;
    }
    ArkRecommendController.a(this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController).a(this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage, this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaqi
 * JD-Core Version:    0.7.0.1
 */