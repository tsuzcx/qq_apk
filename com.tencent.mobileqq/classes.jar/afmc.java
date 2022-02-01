import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class afmc
  implements View.OnClickListener
{
  afmc(afmb paramafmb) {}
  
  public void onClick(View paramView)
  {
    this.a.a.jdField_d_of_type_Boolean = false;
    this.a.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (this.a.a.jdField_d_of_type_Int != 22) {
      this.a.a.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    this.a.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.a.a.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    this.a.a.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.a.a.findViewById(2131368947));
    this.a.a.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    this.a.a.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.a.a.jdField_b_of_type_AndroidViewView$OnClickListener);
    if (this.a.a.jdField_a_of_type_Afnc != null) {
      this.a.a.jdField_a_of_type_Afnc.a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afmc
 * JD-Core Version:    0.7.0.1
 */