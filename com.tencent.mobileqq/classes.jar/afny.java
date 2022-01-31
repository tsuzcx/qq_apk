import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;

class afny
  implements View.OnClickListener
{
  afny(afnx paramafnx) {}
  
  public void onClick(View paramView)
  {
    this.a.a.g = false;
    this.a.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (this.a.a.jdField_d_of_type_Int != 22) {
      this.a.a.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    this.a.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.a.a.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    this.a.a.jdField_d_of_type_AndroidWidgetTextView = ((TextView)ChatHistoryTroopMemberFragment.a(this.a.a, 2131302804));
    this.a.a.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    this.a.a.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.a.a.jdField_b_of_type_AndroidViewView$OnClickListener);
    if (this.a.a.jdField_a_of_type_Afow != null) {
      this.a.a.jdField_a_of_type_Afow.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afny
 * JD-Core Version:    0.7.0.1
 */