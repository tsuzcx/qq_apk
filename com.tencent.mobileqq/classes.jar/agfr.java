import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class agfr
  implements View.OnClickListener
{
  agfr(agfq paramagfq) {}
  
  public void onClick(View paramView)
  {
    agfq.a(this.a).dismissDialog(230);
    aaqo.a(agfq.a(this.a), agfq.a(this.a).curType, agfq.a(this.a).curFriendUin, agfq.a(this.a).getAccount());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agfr
 * JD-Core Version:    0.7.0.1
 */