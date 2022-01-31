import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.AddAccountActivity;
import com.tencent.mobileqq.mqsafeedit.libsafeedit;
import com.tencent.mobileqq.widget.CustomSafeEditText;

public class aagm
  implements View.OnClickListener
{
  public aagm(AddAccountActivity paramAddAccountActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.jdField_a_of_type_AndroidWidgetImageView != null) && (this.a.jdField_a_of_type_AndroidWidgetImageView.isShown())) {
      this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText("");
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setText("");
    libsafeedit.clearPassBuffer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aagm
 * JD-Core Version:    0.7.0.1
 */