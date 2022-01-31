import com.tencent.mobileqq.activity.QQSettingSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class abxi
  extends ajxj
{
  public abxi(QQSettingSettingActivity paramQQSettingSettingActivity) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) || (paramString == null)) {
      return;
    }
    this.a.a(this.a.app.getCurrentAccountUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abxi
 * JD-Core Version:    0.7.0.1
 */