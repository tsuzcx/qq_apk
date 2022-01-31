import android.widget.EditText;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import com.tencent.widget.ActionSheet;

public class afhf
  implements IphonePickerView.IphonePickListener
{
  public afhf(NearbyProfileEditPanel paramNearbyProfileEditPanel, IphonePickerView paramIphonePickerView, ActionSheet paramActionSheet) {}
  
  public void onConfirmBtClicked()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()))
    {
      NearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.h, false);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
  }
  
  public void onItemSelected(int paramInt1, int paramInt2)
  {
    paramInt1 = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(0);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.h.setTag(Byte.valueOf((byte)(paramInt1 + 1)));
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.h.setText(NearbyProfileEditPanel.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel).getText(0, paramInt1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afhf
 * JD-Core Version:    0.7.0.1
 */