import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;

public class abod
  implements DialogInterface.OnClickListener
{
  public abod(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    axqy.a(this.a.app, "dc00898", "", NotificationActivity.d(this.a), "0X800AA30", "0X800AA30", 0, 0, "", "", "", NotificationActivity.a(this.a));
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = this.a.getIntent();
    paramDialogInterface = null;
    if (localObject != null) {
      paramDialogInterface = ((Intent)localObject).getStringExtra("errorUrl");
    }
    localObject = paramDialogInterface;
    if (TextUtils.isEmpty(paramDialogInterface)) {
      localObject = "https://aq.qq.com/007";
    }
    QLog.d("NotificationActivity", 1, "loginFailed, before operate jump url is : " + (String)localObject);
    localStringBuilder.append((String)localObject);
    if (!((String)localObject).contains("?")) {
      localStringBuilder.append("?");
    }
    if (!((String)localObject).endsWith("?")) {
      localStringBuilder.append("&");
    }
    for (;;)
    {
      localStringBuilder.append("from=andapp&account=").append(NotificationActivity.d(this.a));
      paramDialogInterface = localStringBuilder.toString();
      QLog.d("NotificationActivity", 1, "loginFailed, after operate jump url is : " + paramDialogInterface);
      localObject = new Intent(this.a.getActivity(), QQBrowserActivity.class);
      this.a.startActivity(((Intent)localObject).putExtra("url", paramDialogInterface));
      this.a.finish();
      return;
      if (((String)localObject).indexOf("?") != ((String)localObject).lastIndexOf("?")) {
        localStringBuilder.append("&");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     abod
 * JD-Core Version:    0.7.0.1
 */