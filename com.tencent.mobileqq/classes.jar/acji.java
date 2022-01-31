import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopMemberListActivity;

public class acji
  implements View.OnClickListener
{
  public acji(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.c = false;
    this.a.t = "";
    this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (this.a.d != 22) {
      this.a.b.setVisibility(0);
    }
    if (this.a.jdField_a_of_type_Ackw != null) {
      this.a.jdField_a_of_type_Ackw.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acji
 * JD-Core Version:    0.7.0.1
 */