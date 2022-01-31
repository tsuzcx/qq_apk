import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.qphone.base.util.QLog;

class aljt
  extends BroadcastReceiver
{
  aljt(aljs paramaljs) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!TextUtils.isEmpty(aljs.a(this.a)))
    {
      int i = paramIntent.getIntExtra("result", -1);
      paramContext = "{ \"ret\": " + i + " }";
      if (QLog.isColorLevel()) {
        QLog.d("BabyQFriendStatusWebViewPlugin", 2, "babyqWeb js req method = setFriendStatus, return = " + paramContext);
      }
      if (i != 0) {
        break label176;
      }
      if (aljs.a(this.a) != null)
      {
        paramContext = new Intent(aljs.a(this.a), ChatActivity.class);
        paramContext.putExtra("uin", aljq.aC);
        paramContext.putExtra("uintype", 0);
        paramContext.putExtra("uinname", "babyQ");
        paramContext.putExtra("selfSet_leftViewText", aljs.a(this.a).getString(2131690623));
        aljs.a(this.a).startActivity(paramContext);
        aljs.a(this.a).finish();
      }
    }
    return;
    label176:
    this.a.callJs(aljs.a(this.a) + "(" + paramContext + ");");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aljt
 * JD-Core Version:    0.7.0.1
 */