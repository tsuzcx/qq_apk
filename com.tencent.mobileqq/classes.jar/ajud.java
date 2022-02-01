import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ajud
  implements View.OnClickListener
{
  ajud(ajuc paramajuc) {}
  
  public void onClick(View paramView)
  {
    this.a.a.g = false;
    this.a.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131691815);
    this.a.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.a.a.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.a.a.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.a.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
    this.a.a.d.setVisibility(8);
    this.a.a.d = ((TextView)ChatHistoryTroopMemberFragment.a(this.a.a, 2131369231));
    this.a.a.d.setVisibility(0);
    this.a.a.d.setOnClickListener(this.a.a.b);
    if (this.a.a.jdField_a_of_type_Ajvt != null) {
      this.a.a.jdField_a_of_type_Ajvt.a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajud
 * JD-Core Version:    0.7.0.1
 */