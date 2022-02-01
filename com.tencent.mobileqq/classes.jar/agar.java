import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie.6.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class agar
  implements View.OnClickListener
{
  agar(agab paramagab) {}
  
  public void onClick(View paramView)
  {
    if (this.a.freeTalkImg.getVisibility() == 0) {
      ThreadManager.post(new FriendChatPie.6.1(this), 5, null, false);
    }
    com.tencent.mobileqq.activity.aio.AIOUtils.isUserOperatedInAIO = true;
    bdla.b(this.a.app, "CliOper", "", "", "Two_call", "Clk_aio_right", 0, 0, String.valueOf(0), "", "", "");
    aftr.a(this.a.app, this.a.mActivity, this.a.sessionInfo, true, null, this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agar
 * JD-Core Version:    0.7.0.1
 */