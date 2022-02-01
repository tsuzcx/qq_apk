import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.contact.troop.NotificationView;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class ajpt
  implements View.OnClickListener
{
  public ajpt(TroopActivity paramTroopActivity) {}
  
  public void onClick(View paramView)
  {
    int i = bdzi.a().a(this.a.app);
    MqqHandler localMqqHandler1 = this.a.app.getHandler(NotificationView.class);
    MqqHandler localMqqHandler2 = this.a.app.getHandler(TroopNotifyAndRecommendView.class);
    if (localMqqHandler1 != null) {
      localMqqHandler1.sendEmptyMessage(1014);
    }
    if (localMqqHandler2 != null) {
      localMqqHandler2.sendEmptyMessage(1014);
    }
    this.a.app.a().d(antf.W, 9000, -i);
    ((aofz)this.a.app.getManager(33)).a(antf.W, 9000);
    localMqqHandler1 = this.a.app.getHandler(Conversation.class);
    if (localMqqHandler1 != null) {
      localMqqHandler1.sendMessage(localMqqHandler1.obtainMessage(1009));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajpt
 * JD-Core Version:    0.7.0.1
 */