import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel;
import com.tencent.widget.ActionSheet;

public class aevh
  implements IphonePickerView.IphonePickListener
{
  public aevh(NearbyProfileEditTribePanel paramNearbyProfileEditTribePanel, IphonePickerView paramIphonePickerView, ActionSheet paramActionSheet) {}
  
  public void onConfirmBtClicked()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()))
    {
      NearbyProfileEditTribePanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditTribePanel, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditTribePanel.c, false);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
  }
  
  public void onItemSelected(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView != null)
      {
        if ((paramInt1 == 0) || (paramInt1 == 1)) {
          this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(2);
        }
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditTribePanel.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(0), this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(1), this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(2));
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditTribePanel.e = paramInt2;
      continue;
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditTribePanel.f = paramInt2;
      continue;
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditTribePanel.g = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aevh
 * JD-Core Version:    0.7.0.1
 */