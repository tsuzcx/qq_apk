import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ajsf
  implements View.OnClickListener
{
  ajsf(ajse paramajse) {}
  
  public void onClick(View paramView)
  {
    this.a.a.g = false;
    this.a.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131691679);
    this.a.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.a.a.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.a.a.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.a.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
    this.a.a.d.setVisibility(8);
    this.a.a.d = ((TextView)ChatHistoryTroopMemberFragment.a(this.a.a, 2131368947));
    this.a.a.d.setVisibility(0);
    this.a.a.d.setOnClickListener(this.a.a.b);
    if (this.a.a.jdField_a_of_type_Ajtv != null) {
      this.a.a.jdField_a_of_type_Ajtv.a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajsf
 * JD-Core Version:    0.7.0.1
 */