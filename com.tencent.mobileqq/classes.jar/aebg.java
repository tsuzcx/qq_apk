import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopMemberListActivity;

class aebg
  implements View.OnClickListener
{
  aebg(aebf paramaebf) {}
  
  public void onClick(View paramView)
  {
    this.a.a.jdField_d_of_type_Boolean = false;
    this.a.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (this.a.a.jdField_d_of_type_Int != 22) {
      this.a.a.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    this.a.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.a.a.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    this.a.a.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.a.a.findViewById(2131368613));
    this.a.a.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    this.a.a.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.a.a.jdField_b_of_type_AndroidViewView$OnClickListener);
    if (this.a.a.jdField_a_of_type_Aecg != null) {
      this.a.a.jdField_a_of_type_Aecg.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aebg
 * JD-Core Version:    0.7.0.1
 */