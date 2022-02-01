import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.DiscussionMemberActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aeln
  implements View.OnClickListener
{
  public aeln(DiscussionMemberActivity paramDiscussionMemberActivity, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeln
 * JD-Core Version:    0.7.0.1
 */