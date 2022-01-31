import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.widget.ButtonInfo;
import com.tencent.mobileqq.nearby.widget.NearbyCustomDialog;
import com.tencent.mobileqq.nearby.widget.NearbyCustomDialog.OnClickListener;

public class afmq
  implements View.OnClickListener
{
  public afmq(NearbyCustomDialog paramNearbyCustomDialog, ButtonInfo paramButtonInfo) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetNearbyCustomDialog.dismiss();
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetButtonInfo.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetButtonInfo.a.a(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afmq
 * JD-Core Version:    0.7.0.1
 */