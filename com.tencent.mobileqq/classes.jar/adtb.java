import com.tencent.mobileqq.activity.QQSettingSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

public class adtb
  extends alpq
{
  public adtb(QQSettingSettingActivity paramQQSettingSettingActivity) {}
  
  protected void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof Card)) && (this.a.app.getCurrentAccountUin().equals(((Card)paramObject).uin))) {
      QQSettingSettingActivity.a(this.a, (Card)paramObject);
    }
  }
  
  protected void onGetAllowSeeLoginDays(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if ((paramString != null) && (paramString.equals(this.a.app.getCurrentAccountUin())))
    {
      if (paramBoolean1) {
        this.a.a(this.a.app.getCurrentAccountUin());
      }
      return;
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    QLog.e("QQSetting2Activity", 2, "onGetAllowSeeLoginDays isSuccess " + paramBoolean1 + "isAllow:" + paramBoolean2 + "uin " + str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adtb
 * JD-Core Version:    0.7.0.1
 */