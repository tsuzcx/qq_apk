import com.tencent.mobileqq.ark.ArkRecommendController;
import com.tencent.mobileqq.ark.ArkRecommendLogic;
import com.tencent.mobileqq.data.RecommendCommonMessage;
import java.util.ArrayList;
import java.util.Iterator;

public class abed
  implements Runnable
{
  public abed(ArkRecommendController paramArkRecommendController, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (ArkRecommendController.a(this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController) == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        RecommendCommonMessage localRecommendCommonMessage = (RecommendCommonMessage)localIterator.next();
        ArkRecommendController.a(this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController).a(localRecommendCommonMessage, this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abed
 * JD-Core Version:    0.7.0.1
 */