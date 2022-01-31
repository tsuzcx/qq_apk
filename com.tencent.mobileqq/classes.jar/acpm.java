import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;

public class acpm
  extends CardObserver
{
  public acpm(ExtendFriendManager paramExtendFriendManager) {}
  
  protected void a(boolean paramBoolean, int paramInt, Card paramCard)
  {
    if ((paramBoolean) && (paramInt == 0)) {
      ExtendFriendManager.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acpm
 * JD-Core Version:    0.7.0.1
 */