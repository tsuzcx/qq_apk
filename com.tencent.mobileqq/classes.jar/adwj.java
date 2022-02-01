import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adwj
  implements View.OnClickListener
{
  public adwj(EditInfoActivity paramEditInfoActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(true);
    this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847907);
    this.a.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(anvx.a(2131703111));
    this.a.jdField_a_of_type_Boolean = false;
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adwj
 * JD-Core Version:    0.7.0.1
 */