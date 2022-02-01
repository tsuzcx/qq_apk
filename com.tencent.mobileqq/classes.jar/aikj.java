import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.troop.NotificationView;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class aikj
  implements View.OnClickListener
{
  public aikj(TroopActivity paramTroopActivity) {}
  
  public void onClick(View paramView)
  {
    int i = bcsz.a().a(this.a.app);
    MqqHandler localMqqHandler1 = this.a.app.getHandler(NotificationView.class);
    MqqHandler localMqqHandler2 = this.a.app.getHandler(TroopNotifyAndRecommendView.class);
    if (localMqqHandler1 != null) {
      localMqqHandler1.sendEmptyMessage(1014);
    }
    if (localMqqHandler2 != null) {
      localMqqHandler2.sendEmptyMessage(1014);
    }
    this.a.app.getConversationFacade().d(AppConstants.TROOP_NOTIFICATION_UIN, 9000, -i);
    ((amzo)this.a.app.getManager(33)).a(AppConstants.TROOP_NOTIFICATION_UIN, 9000);
    localMqqHandler1 = this.a.app.getHandler(Conversation.class);
    if (localMqqHandler1 != null) {
      localMqqHandler1.sendMessage(localMqqHandler1.obtainMessage(1009));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aikj
 * JD-Core Version:    0.7.0.1
 */