import com.tencent.mobileqq.ark.ArkAiScrollBar;
import com.tencent.mobileqq.ark.ArkRecommendController;
import com.tencent.qphone.base.util.QLog;

public class aaxg
  implements Runnable
{
  public aaxg(ArkRecommendController paramArkRecommendController) {}
  
  public void run()
  {
    int j = 1;
    int i = j;
    if (ArkRecommendController.a(this.a) == null)
    {
      ArkRecommendController.a(this.a, new ArkAiScrollBar(this.a));
      i = j;
      if (!ArkRecommendController.a(this.a).a())
      {
        ArkRecommendController.a(this.a, null);
        if (QLog.isColorLevel()) {
          QLog.d("ArkRecommendController", 2, "showBabyQBubbleView.mScrollBar.init.false");
        }
        i = 0;
      }
    }
    if (i != 0)
    {
      ArkRecommendController.a(this.a).a(ArkRecommendController.a(this.a));
      ArkRecommendController.a(this.a).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaxg
 * JD-Core Version:    0.7.0.1
 */