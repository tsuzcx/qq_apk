import android.content.Intent;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class acvn
  implements bdri
{
  public acvn(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "ZanDoubleDialog: onLeftClick: ");
    }
    if (this.a.getIntent().hasExtra("troopUin")) {}
    for (Object localObject = "1";; localObject = "0")
    {
      VasWebviewUtil.reportCommercialDrainage(this.a.app.getCurrentAccountUin(), "thumbup", "click_getit", "", 1, 0, 0, "", (String)localObject, "");
      localObject = new Intent(this.a, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("fragmentStyle", 3);
      ((Intent)localObject).putExtra("url", "https://m.vip.qq.com/freedom/dbzan.html?_nav_alpha=0");
      ((Intent)localObject).putExtra("isTransparentTitle", true);
      ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
      this.a.startActivity((Intent)localObject);
      return;
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "ZanDoubleDialog: onRightClick: ");
    }
    if (this.a.getIntent().hasExtra("troopUin")) {}
    for (String str = "1";; str = "0")
    {
      VasWebviewUtil.reportCommercialDrainage(this.a.app.getCurrentAccountUin(), "thumbup", "click_pay", "", 1, 0, 0, "", str, "");
      bdqe.a(this.a, "mvip.n.a.dbzan_dbzan", "CJCLUBT", 3, false, true);
      FriendProfileCardActivity.a(this.a).set(true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acvn
 * JD-Core Version:    0.7.0.1
 */