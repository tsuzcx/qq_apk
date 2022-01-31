import android.app.Dialog;
import android.view.View;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class aemp
  implements ActionSheet.OnButtonClickListener
{
  public aemp(PlayOperationViewModel paramPlayOperationViewModel, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
      return;
      if (PlayOperationViewModel.e(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel))
      {
        PlayOperationViewModel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel, DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel.jdField_a_of_type_AndroidViewView.getContext(), 230, "确定删除该动态？", null, "取消", "删除", new aemq(this), new aems(this)));
        PlayOperationViewModel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel).show();
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel.b != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
      {
        String str2 = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.b);
        String str1 = str2;
        if (StringUtil.a(str2)) {
          str1 = "0";
        }
        PlayOperationViewModel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel, paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.a, str1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aemp
 * JD-Core Version:    0.7.0.1
 */