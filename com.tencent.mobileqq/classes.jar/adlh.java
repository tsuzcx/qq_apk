import android.content.Intent;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.intervideo.now.ShareToQQActivity;

public class adlh
  extends FriendListObserver
{
  public adlh(ShareToQQActivity paramShareToQQActivity) {}
  
  protected void onUpdateFriendShieldFlag(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    if ((paramLong != 0L) && (this.a.a != null) && (this.a.a.equals(paramLong + "")))
    {
      paramString = new Intent();
      paramString.putExtra("isSuccess", paramBoolean2);
      paramString.putExtra("isCancelShield", false);
      this.a.setResult(-1, paramString);
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adlh
 * JD-Core Version:    0.7.0.1
 */