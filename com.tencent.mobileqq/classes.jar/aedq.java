import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aedq
  implements View.OnClickListener
{
  public aedq(EditInfoActivity paramEditInfoActivity) {}
  
  public void onClick(View paramView)
  {
    EditInfoActivity localEditInfoActivity = this.a;
    boolean bool;
    if (!this.a.jdField_a_of_type_Boolean)
    {
      bool = true;
      localEditInfoActivity.jdField_a_of_type_Boolean = bool;
      if (!this.a.jdField_a_of_type_Boolean) {
        break label137;
      }
      this.a.e();
      if (this.a.getIntent().getBooleanExtra("key_need_hide_couser_when_emoj", false)) {
        this.a.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
      }
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838073);
      this.a.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(anni.a(2131702423));
      if ((!this.a.b) && (this.a.jdField_a_of_type_AndroidWidgetLinearLayout != null)) {
        this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bool = false;
      break;
      label137:
      this.a.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(true);
      if (this.a.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847887);
      this.a.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(anni.a(2131702413));
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aedq
 * JD-Core Version:    0.7.0.1
 */