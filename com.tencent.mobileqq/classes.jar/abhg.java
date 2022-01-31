import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.armap.POIInfo;
import com.tencent.mobileqq.armap.map.ARMapPOIStarDialog;
import com.tencent.mobileqq.statistics.ReportController;

public class abhg
  implements View.OnClickListener
{
  public abhg(ARMapPOIStarDialog paramARMapPOIStarDialog, POIInfo paramPOIInfo, int paramInt) {}
  
  public void onClick(View paramView)
  {
    paramView = "" + this.jdField_a_of_type_ComTencentMobileqqArmapMapARMapPOIStarDialog.jdField_a_of_type_Long;
    String str1 = "" + this.jdField_a_of_type_ComTencentMobileqqArmapPOIInfo.jdField_a_of_type_Long;
    String str2 = "" + this.jdField_a_of_type_ComTencentMobileqqArmapPOIInfo.b;
    StringBuilder localStringBuilder = new StringBuilder().append("");
    if (this.jdField_a_of_type_Int == 0) {}
    for (int i = 1;; i = 0)
    {
      ReportController.b(null, "dc01440", "", "", "0X8007AB2", "0X8007AB2", 0, 0, paramView, str1, str2, i);
      ThreadManager.postImmediately(new abhh(this), null, false);
      this.jdField_a_of_type_ComTencentMobileqqArmapMapARMapPOIStarDialog.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
      this.jdField_a_of_type_ComTencentMobileqqArmapMapARMapPOIStarDialog.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130842265);
      this.jdField_a_of_type_ComTencentMobileqqArmapMapARMapPOIStarDialog.b.postDelayed(new abhi(this), 500L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abhg
 * JD-Core Version:    0.7.0.1
 */