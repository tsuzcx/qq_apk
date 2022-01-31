import com.tencent.mobileqq.ark.ArkAiScrollBar;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkRecommendController;

public class aaqg
  implements Runnable
{
  public aaqg(ArkRecommendController paramArkRecommendController) {}
  
  public void run()
  {
    if (ArkRecommendController.a(this.a) != null)
    {
      ArkAppCenter.b("ArkRecommendController", "mArkBabyqDisappearBubbleTask, destroy scroll bar");
      ArkRecommendController.a(this.a).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaqg
 * JD-Core Version:    0.7.0.1
 */