import com.tencent.mobileqq.activity.QQSettingSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;

public class abng
  extends ajfo
{
  public abng(QQSettingSettingActivity paramQQSettingSettingActivity) {}
  
  protected void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof Card)) && (this.a.app.getCurrentAccountUin().equals(((Card)paramObject).uin))) {
      QQSettingSettingActivity.a(this.a, (Card)paramObject);
    }
  }
  
  protected void onGetAllowSeeLoginDays(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      this.a.a(this.a.app.getCurrentAccountUin());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abng
 * JD-Core Version:    0.7.0.1
 */