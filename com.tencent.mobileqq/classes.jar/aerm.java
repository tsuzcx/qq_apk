import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.TroopTransferActivity;

public class aerm
  implements DialogInterface.OnDismissListener
{
  public aerm(TroopTransferActivity paramTroopTransferActivity, int paramInt, TranslateAnimation paramTranslateAnimation) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.jdField_a_of_type_AndroidWidgetLinearLayout.offsetTopAndBottom(-this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
      paramDialogInterface = (InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.getSystemService("input_method");
      if (paramDialogInterface != null) {
        paramDialogInterface.hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.getWindow().peekDecorView().getWindowToken(), 0);
      }
      return;
    }
    catch (Exception paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aerm
 * JD-Core Version:    0.7.0.1
 */