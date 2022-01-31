import com.tencent.mobileqq.activity.InterestSwitchEditActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

public class aazn
  extends ajfo
{
  public aazn(InterestSwitchEditActivity paramInterestSwitchEditActivity) {}
  
  protected void onGetDetailInfo(boolean paramBoolean, String paramString, Card paramCard)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetDetailInfo, isSuccess=" + paramBoolean);
      localStringBuilder.append("，" + paramString);
      if (paramCard != null)
      {
        localStringBuilder.append("，" + paramCard.switch_interest);
        localStringBuilder.append("，" + paramCard.switch_music);
        localStringBuilder.append("，" + paramCard.isShowCard);
        localStringBuilder.append("，" + paramCard.switch_disable_personality_label);
        localStringBuilder.append("，" + paramCard.switch_miniapp);
        localStringBuilder.append("，" + paramCard.switch_musicbox);
      }
      QLog.i("InterestSwitchEditActivity", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      if ((this.a.app.getCurrentAccountUin().equals(paramString)) && (paramCard != null) && (-1 != paramCard.switch_interest) && (-1 != paramCard.switch_music) && (-1 != paramCard.switch_present) && (-1 != paramCard.switch_miniapp) && (-1 != paramCard.switch_musicbox))
      {
        InterestSwitchEditActivity.a(this.a, paramCard);
        InterestSwitchEditActivity.a(this.a);
        InterestSwitchEditActivity.b(this.a);
      }
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.i("InterestSwitchEditActivity", 2, "suc but has invalidate value");
      return;
    }
    bbmy.a(this.a, ajjy.a(2131640011), 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aazn
 * JD-Core Version:    0.7.0.1
 */