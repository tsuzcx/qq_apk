import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adfe
  implements View.OnClickListener
{
  public adfe(EditInfoActivity paramEditInfoActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(true);
    this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847816);
    this.a.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(amtj.a(2131702760));
    this.a.jdField_a_of_type_Boolean = false;
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adfe
 * JD-Core Version:    0.7.0.1
 */