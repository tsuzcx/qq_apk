import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.ExtendFriendObserver;

public class acpn
  extends ExtendFriendObserver
{
  public acpn(ExtendFriendManager paramExtendFriendManager) {}
  
  protected void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      ExtendFriendManager.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acpn
 * JD-Core Version:    0.7.0.1
 */