import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.specialcare.QQSpecialFriendSettingActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class alxr
  implements View.OnClickListener
{
  public alxr(QQSpecialFriendSettingActivity paramQQSpecialFriendSettingActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (QQToast.a() == 0)
    {
      localObject = new aohz(this.a, this.a.app, QQSpecialFriendSettingActivity.a(this.a));
      ((aohz)localObject).setOnDismissListener(new alxs(this, (aohz)localObject));
      ((aohz)localObject).show();
      bcst.b(null, "dc00898", "", "", "0X8009ACB", "0X8009ACB", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QQSpecialFriendSettingActivity", 2, "finish all setings");
      }
      if (bgnt.g(this.a))
      {
        boolean bool1 = QQSpecialFriendSettingActivity.a(this.a).a();
        boolean bool2 = QQSpecialFriendSettingActivity.b(this.a).a();
        localObject = QQSpecialFriendSettingActivity.a(this.a);
        String str = QQSpecialFriendSettingActivity.a(this.a);
        int i = QQSpecialFriendSettingActivity.a(this.a);
        ((FriendListHandler)localObject).a(str, new int[] { 2, 3 }, new boolean[] { bool1, bool2 }, new String[] { String.valueOf(i), null });
        localObject = this.a.a.obtainMessage(8193);
        ((Message)localObject).obj = this.a.getString(2131698319);
        this.a.a.sendMessage((Message)localObject);
        if ((bool1) && (bool2)) {}
        for (localObject = "0";; localObject = "1")
        {
          bcst.b(null, "CliOper", "", "", "0X80050E2", "0X80050E2", 0, 0, (String)localObject, "", "", "");
          break;
        }
      }
      localObject = this.a.a.obtainMessage(8195);
      ((Message)localObject).arg1 = 0;
      ((Message)localObject).arg2 = 2131691985;
      this.a.a.sendMessage((Message)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alxr
 * JD-Core Version:    0.7.0.1
 */