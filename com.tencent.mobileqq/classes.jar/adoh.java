import com.tencent.mobileqq.activity.ProfileCardMoreActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.qphone.base.util.QLog;

public class adoh
  extends anyt
{
  public adoh(ProfileCardMoreActivity paramProfileCardMoreActivity) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    super.a(paramBoolean, paramString);
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    super.a(paramBoolean, paramString, paramInt);
    if (paramBoolean)
    {
      BusinessCard localBusinessCard = ((anys)this.a.app.getManager(112)).a(paramString);
      QLog.i("BusinessCard_observer_ProfileCardMoreActivity", 4, "onGetCardInfo success : cardId = " + paramString);
      this.a.a(localBusinessCard);
      this.a.a = localBusinessCard;
      return;
    }
    QLog.e("BusinessCard_observer_ProfileCardMoreActivity", 4, "onGetCardInfo faild : cardId = " + paramString);
  }
  
  public void b(boolean paramBoolean, String paramString)
  {
    super.b(paramBoolean, paramString);
  }
  
  public void b(boolean paramBoolean, String paramString, int paramInt)
  {
    super.b(paramBoolean, paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adoh
 * JD-Core Version:    0.7.0.1
 */