import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopMemberListActivity;

public class acak
  implements View.OnClickListener
{
  public acak(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_d_of_type_Boolean = true;
    this.a.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    this.a.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.a.findViewById(2131302806));
    this.a.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    this.a.jdField_d_of_type_AndroidWidgetTextView.setText(ajjy.a(2131649846));
    this.a.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new acal(this));
    TroopMemberListActivity.a(this.a);
    if (this.a.a != null) {
      this.a.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acak
 * JD-Core Version:    0.7.0.1
 */