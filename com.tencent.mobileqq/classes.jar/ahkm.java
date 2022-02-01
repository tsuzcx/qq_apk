import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahkm
  implements View.OnClickListener
{
  ahkm(ahiu paramahiu) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.tag, 2, "mQidianClickListener ... mQidianKefu = " + this.a.x);
    }
    this.a.a(2131694821);
    this.a.a.a(this.a.mActivity, this.a.sessionInfo.curFriendUin, this.a.f, this.a.g, this.a.h, new ahkn(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahkm
 * JD-Core Version:    0.7.0.1
 */