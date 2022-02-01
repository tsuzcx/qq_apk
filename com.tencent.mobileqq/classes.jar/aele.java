import android.app.Dialog;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

public class aele
  implements bixa
{
  public aele(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  public void a(Dialog paramDialog, View paramView, boolean paramBoolean)
  {
    this.a.app.a().a(DiscussionInfoCardActivity.a(this.a), 3000);
    this.a.app.a().e(DiscussionInfoCardActivity.a(this.a), 3000);
    anfz.a(this.a.app, "chat_history_confirm_del_msg");
    paramDialog = this.a.app.getHandler(Conversation.class);
    paramView = paramDialog.obtainMessage(1017);
    paramView.obj = DiscussionInfoCardActivity.a(this.a);
    paramView.arg1 = 3000;
    paramDialog.sendMessage(paramView);
    QQToast.a(this.a, 2, this.a.getString(2131690718), 0).a();
    if (this.a.a != null) {
      ((TextView)this.a.a.findViewById(2131378936)).setTextColor(Color.parseColor("#cccccc"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aele
 * JD-Core Version:    0.7.0.1
 */