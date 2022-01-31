import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.mobileqq.businessCard.activity.BusinessCardListActivity;
import com.tencent.mobileqq.businessCard.activity.FlowCameraPhotoActivity;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class abtu
  implements ActionSheet.OnButtonClickListener
{
  public abtu(BusinessCardEditActivity paramBusinessCardEditActivity, boolean paramBoolean, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.d();
      return;
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.getActivity(), FlowCameraPhotoActivity.class);
      paramView.putExtra("extra_return_result", true);
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.startActivityForResult(paramView, 10);
      if (this.jdField_a_of_type_Boolean) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.app, "CliOper", "", "", "0X80064EB", "0X80064EB", 0, 0, "", "", "", "");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.d != 0)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.app, "CliOper", "", "", "0X800774F", "0X800774F", 1, 0, this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.d + "", "", "", "");
        continue;
        BusinessCardUtils.a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.app, this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity);
        if (this.jdField_a_of_type_Boolean) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.app, "CliOper", "", "", "0X80064EC", "0X80064EC", 0, 0, "", "", "", "");
        }
        if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.d != 0)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.app, "CliOper", "", "", "0X800774F", "0X800774F", 2, 0, this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.d + "", "", "", "");
          continue;
          paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.getActivity(), BusinessCardListActivity.class);
          paramView.putExtra("Extra_Entrance", 2);
          this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.startActivityForResult(paramView, 12);
          if (this.jdField_a_of_type_Boolean) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.app, "CliOper", "", "", "0X80064ED", "0X80064ED", 0, 0, "", "", "", "");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abtu
 * JD-Core Version:    0.7.0.1
 */