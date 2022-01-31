import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.troop.activity.PublicCommentWindow;
import com.tencent.qphone.base.util.QLog;

public class aigm
  extends BroadcastReceiver
{
  public aigm(PublicCommentWindow paramPublicCommentWindow) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramIntent.getAction())) && ("CommentSendSuccess".equals(paramIntent.getStringExtra("event"))))
    {
      this.a.a = true;
      this.a.dismiss();
      if (QLog.isColorLevel()) {
        QLog.d("PublicCommentPopupWindow", 2, "web call finish----------------");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aigm
 * JD-Core Version:    0.7.0.1
 */