import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.widget.TroopPickerViewHelper;
import com.tencent.mobileqq.troop.widget.TroopPickerViewHelper.OnConfirmListener;
import com.tencent.widget.ActionSheet;
import java.util.Calendar;

public class akbv
  implements View.OnClickListener
{
  public akbv(TroopPickerViewHelper paramTroopPickerViewHelper, TroopPickerViewHelper.OnConfirmListener paramOnConfirmListener) {}
  
  public void onClick(View paramView)
  {
    if ((TroopPickerViewHelper.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopPickerViewHelper) != null) && (TroopPickerViewHelper.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopPickerViewHelper).isShowing())) {
      TroopPickerViewHelper.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopPickerViewHelper).dismiss();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopPickerViewHelper$OnConfirmListener != null) && (TroopPickerViewHelper.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopPickerViewHelper) != null)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopPickerViewHelper$OnConfirmListener.a(TroopPickerViewHelper.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopPickerViewHelper).getTimeInMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akbv
 * JD-Core Version:    0.7.0.1
 */