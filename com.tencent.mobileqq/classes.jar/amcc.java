import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.specialcare.QQSpecialFriendSettingActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class amcc
  implements View.OnClickListener
{
  public amcc(QQSpecialFriendSettingActivity paramQQSpecialFriendSettingActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (QQToast.a() == 0)
    {
      localObject = new aorg(this.a, this.a.app, QQSpecialFriendSettingActivity.a(this.a));
      ((aorg)localObject).setOnDismissListener(new amcd(this, (aorg)localObject));
      ((aorg)localObject).show();
      bdla.b(null, "dc00898", "", "", "0X8009ACB", "0X8009ACB", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QQSpecialFriendSettingActivity", 2, "finish all setings");
      }
      if (NetworkUtil.isNetworkAvailable(this.a))
      {
        boolean bool1 = QQSpecialFriendSettingActivity.a(this.a).a();
        boolean bool2 = QQSpecialFriendSettingActivity.b(this.a).a();
        localObject = QQSpecialFriendSettingActivity.a(this.a);
        String str = QQSpecialFriendSettingActivity.a(this.a);
        int i = QQSpecialFriendSettingActivity.a(this.a);
        ((FriendListHandler)localObject).setSpecialCareSwitchesOfAPerson(str, new int[] { 2, 3 }, new boolean[] { bool1, bool2 }, new String[] { String.valueOf(i), null });
        localObject = this.a.a.obtainMessage(8193);
        ((Message)localObject).obj = this.a.getString(2131698887);
        this.a.a.sendMessage((Message)localObject);
        if ((bool1) && (bool2)) {}
        for (localObject = "0";; localObject = "1")
        {
          bdla.b(null, "CliOper", "", "", "0X80050E2", "0X80050E2", 0, 0, (String)localObject, "", "", "");
          break;
        }
      }
      localObject = this.a.a.obtainMessage(8195);
      ((Message)localObject).arg1 = 0;
      ((Message)localObject).arg2 = 2131692125;
      this.a.a.sendMessage((Message)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amcc
 * JD-Core Version:    0.7.0.1
 */