import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.dating.BaseMsgBoxActivity;

public class abpi
  extends FriendListObserver
{
  public abpi(BaseMsgBoxActivity paramBaseMsgBoxActivity) {}
  
  protected void onGetFriendDateNick(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (!this.a.a) {
      return;
    }
    this.a.runOnUiThread(new abpk(this, paramBoolean, paramString1, paramString2));
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (!this.a.a) {
      return;
    }
    this.a.runOnUiThread(new abpj(this, paramBoolean, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abpi
 * JD-Core Version:    0.7.0.1
 */