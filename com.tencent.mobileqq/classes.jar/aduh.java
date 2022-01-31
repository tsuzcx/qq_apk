import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.MessageForVIPDonate;
import com.tencent.mobileqq.data.VIPDonateMsg;
import com.tencent.qphone.base.util.QLog;

class aduh
  implements View.OnClickListener
{
  aduh(adug paramadug) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a()) {
      return;
    }
    paramView = (MessageForVIPDonate)((adui)aciy.a(paramView)).a;
    Object localObject = paramView.donateMsg;
    if ((localObject != null) && (!TextUtils.isEmpty(((VIPDonateMsg)localObject).jumpUrl)))
    {
      paramView = paramView.donateMsg.jumpUrl;
      localObject = new Intent(adug.a(this.a), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramView);
      adug.a(this.a).startActivity((Intent)localObject);
      return;
    }
    QLog.e("VIPDonateMsgItemBuilder", 1, "donatemsg jumpurl empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aduh
 * JD-Core Version:    0.7.0.1
 */