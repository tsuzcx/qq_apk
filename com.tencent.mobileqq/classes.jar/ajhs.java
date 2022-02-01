import com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment;
import mqq.os.MqqHandler;

public class ajhs
  extends aofu
{
  public ajhs(TroopWithCommonFriendsFragment paramTroopWithCommonFriendsFragment) {}
  
  protected void onTroopManagerFailed(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 8) {
      this.a.a.sendEmptyMessage(1018);
    }
  }
  
  protected void onTroopManagerSuccess(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 8) {
      this.a.a.sendEmptyMessage(1016);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajhs
 * JD-Core Version:    0.7.0.1
 */