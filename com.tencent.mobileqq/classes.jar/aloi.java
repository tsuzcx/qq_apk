import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.qphone.base.util.QLog;

class aloi
  extends BroadcastReceiver
{
  aloi(aloh paramaloh) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!TextUtils.isEmpty(aloh.a(this.a)))
    {
      int i = paramIntent.getIntExtra("result", -1);
      paramContext = "{ \"ret\": " + i + " }";
      if (QLog.isColorLevel()) {
        QLog.d("BabyQFriendStatusWebViewPlugin", 2, "babyqWeb js req method = setFriendStatus, return = " + paramContext);
      }
      if (i != 0) {
        break label176;
      }
      if (aloh.a(this.a) != null)
      {
        paramContext = new Intent(aloh.a(this.a), ChatActivity.class);
        paramContext.putExtra("uin", alof.aC);
        paramContext.putExtra("uintype", 0);
        paramContext.putExtra("uinname", "babyQ");
        paramContext.putExtra("selfSet_leftViewText", aloh.a(this.a).getString(2131690623));
        aloh.a(this.a).startActivity(paramContext);
        aloh.a(this.a).finish();
      }
    }
    return;
    label176:
    this.a.callJs(aloh.a(this.a) + "(" + paramContext + ");");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aloi
 * JD-Core Version:    0.7.0.1
 */