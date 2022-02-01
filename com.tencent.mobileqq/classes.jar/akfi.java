import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import friendlist.GetOnlineInfoResp;

class akfi
  extends anvi
{
  akfi(akfg paramakfg) {}
  
  protected void onGetOnlineInfoByUinOrMobile(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if (TextUtils.equals(paramString, this.a.a.curFriendUin)) {
      this.a.f();
    }
  }
  
  protected void onUpdateOnlineFriend(boolean paramBoolean, String[] paramArrayOfString)
  {
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akfi
 * JD-Core Version:    0.7.0.1
 */