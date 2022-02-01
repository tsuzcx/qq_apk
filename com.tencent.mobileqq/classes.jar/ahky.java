import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahky
  implements View.OnClickListener
{
  ahky(ahkw paramahkw) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.hasDestory) {
      bezm.a(this.a.mContext, null, this.a.sessionInfo.curFriendUin);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahky
 * JD-Core Version:    0.7.0.1
 */