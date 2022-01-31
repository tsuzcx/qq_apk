import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.EditInfoActivity;

public class acrl
  implements View.OnClickListener
{
  public acrl(EditInfoActivity paramEditInfoActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a;
    if (!this.a.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.jdField_a_of_type_Boolean = bool;
      if (!this.a.jdField_a_of_type_Boolean) {
        break;
      }
      this.a.e();
      if (this.a.getIntent().getBooleanExtra("key_need_hide_couser_when_emoj", false)) {
        this.a.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
      }
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837978);
      this.a.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(alpo.a(2131704014));
      if ((!this.a.b) && (this.a.jdField_a_of_type_AndroidWidgetLinearLayout != null)) {
        this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
      return;
    }
    this.a.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(true);
    if (this.a.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847355);
    this.a.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(alpo.a(2131704004));
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acrl
 * JD-Core Version:    0.7.0.1
 */