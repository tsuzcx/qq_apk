import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.dating.BaseMsgBoxActivity;

public class abwj
  extends FriendListObserver
{
  public abwj(BaseMsgBoxActivity paramBaseMsgBoxActivity) {}
  
  protected void onGetFriendDateNick(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (!this.a.a) {
      return;
    }
    this.a.runOnUiThread(new abwl(this, paramBoolean, paramString1, paramString2));
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (!this.a.a) {
      return;
    }
    this.a.runOnUiThread(new abwk(this, paramBoolean, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abwj
 * JD-Core Version:    0.7.0.1
 */