import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.activity.phone.NewStyleCountryActivity;
import com.tencent.mobileqq.widget.IndexView;

public class akpb
  implements DialogInterface.OnDismissListener
{
  public akpb(NewStyleCountryActivity paramNewStyleCountryActivity, int paramInt, TranslateAnimation paramTranslateAnimation) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneNewStyleCountryActivity.b.offsetTopAndBottom(-this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneNewStyleCountryActivity.jdField_a_of_type_AndroidViewView.setVisibility(0);
    NewStyleCountryActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneNewStyleCountryActivity).setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneNewStyleCountryActivity.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneNewStyleCountryActivity.b.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akpb
 * JD-Core Version:    0.7.0.1
 */