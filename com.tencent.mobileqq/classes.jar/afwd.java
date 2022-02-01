import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class afwd
  implements View.OnClickListener
{
  afwd(afwc paramafwc) {}
  
  public void onClick(View paramView)
  {
    this.a.a.jdField_d_of_type_Boolean = false;
    this.a.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131691682);
    this.a.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.a.a.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.a.a.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.a.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
    this.a.a.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    this.a.a.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.a.a.findViewById(2131369042));
    this.a.a.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    this.a.a.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.a.a.b);
    if (this.a.a.jdField_a_of_type_Afwg != null) {
      this.a.a.jdField_a_of_type_Afwg.a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afwd
 * JD-Core Version:    0.7.0.1
 */