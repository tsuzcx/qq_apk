import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class afon
  implements View.OnClickListener
{
  afon(afom paramafom) {}
  
  public void onClick(View paramView)
  {
    afom.a(this.a).dismissDialog(230);
    aabc.a(afom.a(this.a), afom.a(this.a).curType, afom.a(this.a).curFriendUin, afom.a(this.a).getAccount());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afon
 * JD-Core Version:    0.7.0.1
 */