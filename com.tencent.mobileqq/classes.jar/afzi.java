import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;

public class afzi
  implements View.OnClickListener
{
  public afzi(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.f = false;
    this.a.u = "";
    this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (this.a.d != 22) {
      this.a.b.setVisibility(0);
    }
    if (this.a.jdField_a_of_type_Agau != null) {
      this.a.jdField_a_of_type_Agau.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afzi
 * JD-Core Version:    0.7.0.1
 */