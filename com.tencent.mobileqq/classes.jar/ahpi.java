import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahpi
  implements View.OnClickListener
{
  ahpi(ahph paramahph) {}
  
  public void onClick(View paramView)
  {
    ahph.a(this.a).a();
    ChatActivityUtils.a(ahph.a(this.a), ahph.a(this.a), ahph.a(this.a).curType, ahph.a(this.a).curFriendUin, true, true, null, null);
    bcef.b(ahph.a(this.a), "CliOper", "", "", "0X8003F00", "0X8003F00", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahpi
 * JD-Core Version:    0.7.0.1
 */