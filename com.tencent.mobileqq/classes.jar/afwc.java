import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afwc
  implements View.OnClickListener
{
  public afwc(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_d_of_type_Boolean = true;
    this.a.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    this.a.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.a.findViewById(2131369044));
    this.a.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    this.a.jdField_d_of_type_AndroidWidgetTextView.setText(anzj.a(2131714422));
    this.a.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new afwd(this));
    TroopMemberListActivity.a(this.a);
    if (this.a.a != null) {
      this.a.a.a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afwc
 * JD-Core Version:    0.7.0.1
 */