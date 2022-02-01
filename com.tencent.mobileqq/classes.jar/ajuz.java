import android.app.Dialog;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajuz
  implements View.OnClickListener
{
  public ajuz(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_d_of_type_Int == 11) {
      bdla.b(this.a.getActivity().app, "CliOper", "", "", "0X8006216", "0X8006216", 0, 0, "", "", "", "");
    }
    this.a.jdField_d_of_type_AndroidAppDialog.cancel();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajuz
 * JD-Core Version:    0.7.0.1
 */