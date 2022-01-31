import android.widget.EditText;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import com.tencent.widget.ActionSheet;

public class aesx
  implements IphonePickerView.IphonePickListener
{
  public aesx(NearbyProfileEditPanel paramNearbyProfileEditPanel, IphonePickerView paramIphonePickerView, ActionSheet paramActionSheet) {}
  
  public void onConfirmBtClicked()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()))
    {
      NearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.b, false);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
  }
  
  public void onItemSelected(int paramInt1, int paramInt2)
  {
    paramInt1 = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(0);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.b.setTag(Byte.valueOf((byte)paramInt1));
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.b.setText(NearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel).getText(0, paramInt1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aesx
 * JD-Core Version:    0.7.0.1
 */