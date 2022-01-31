import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.profilecard.InterestGuide;
import com.tencent.mobileqq.statistics.ReportController;

public class afgu
  implements Runnable
{
  public afgu(InterestGuide paramInterestGuide) {}
  
  public void run()
  {
    NearbySPUtil.a(this.a.jdField_a_of_type_JavaLangString, "interest_guide_key", Boolean.FALSE);
    Context localContext = this.a.jdField_a_of_type_AndroidViewView.getContext();
    if ((localContext instanceof BaseActivity)) {
      ReportController.b(((BaseActivity)localContext).app, "dc00898", "", "", "0X8006991", "0X8006991", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afgu
 * JD-Core Version:    0.7.0.1
 */