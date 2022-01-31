import com.tencent.mobileqq.activity.LikeSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;

public class ablk
  extends atbf
{
  public ablk(LikeSettingActivity paramLikeSettingActivity) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LikeSettingActivity", 2, "onGetNotifyOnLikeSwitch.isSuccess=" + paramBoolean1 + ",open=" + paramBoolean2);
    }
    if (paramBoolean1) {
      LikeSettingActivity.a(this.a, this.a.a.a(), paramBoolean2);
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LikeSettingActivity", 2, "onSetNotifyOnLikeSwitch.isSuccess=" + paramBoolean1 + ",open=" + paramBoolean2);
    }
    if (!paramBoolean1)
    {
      bcql.a(this.a, 1, 2131719386, 0).b(this.a.getTitleBarHeight());
      paramBoolean1 = ((asza)this.a.app.getManager(161)).a();
      LikeSettingActivity.a(this.a, this.a.a.a(), paramBoolean1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ablk
 * JD-Core Version:    0.7.0.1
 */