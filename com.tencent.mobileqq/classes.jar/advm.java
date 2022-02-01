import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.DiscussionMemberActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class advm
  implements View.OnClickListener
{
  public advm(DiscussionMemberActivity paramDiscussionMemberActivity, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidAppDialog.cancel();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     advm
 * JD-Core Version:    0.7.0.1
 */