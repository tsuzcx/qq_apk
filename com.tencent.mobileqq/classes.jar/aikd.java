import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aikd
  implements View.OnClickListener
{
  aikd(aikc paramaikc) {}
  
  public void onClick(View paramView)
  {
    aikc.a(this.a).a();
    ChatActivityUtils.a(aikc.a(this.a), aikc.a(this.a), aikc.a(this.a).curType, aikc.a(this.a).curFriendUin, true, true, null, null);
    bdla.b(aikc.a(this.a), "CliOper", "", "", "0X8003F00", "0X8003F00", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aikd
 * JD-Core Version:    0.7.0.1
 */