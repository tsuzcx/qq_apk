import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

public class aebj
  extends aqjn
{
  public aebj(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (paramBoolean)
    {
      aqjm localaqjm = (aqjm)this.a.app.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER);
      this.a.a = localaqjm.a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aebj
 * JD-Core Version:    0.7.0.1
 */