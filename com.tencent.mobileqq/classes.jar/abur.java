import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.businessCard.activity.BusinessCardListActivity;
import com.tencent.mobileqq.businessCard.activity.FlowCameraPhotoActivity;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class abur
  implements ActionSheet.OnButtonClickListener
{
  public abur(BusinessCardListActivity paramBusinessCardListActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardListActivity, FlowCameraPhotoActivity.class);
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardListActivity.startActivity(paramView);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardListActivity.app, "CliOper", "", "", "0X80064DA", "0X80064DA", 0, 0, "", "", "", "");
      continue;
      BusinessCardUtils.a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardListActivity.app, this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardListActivity);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardListActivity.app, "CliOper", "", "", "0X80064DB", "0X80064DB", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abur
 * JD-Core Version:    0.7.0.1
 */