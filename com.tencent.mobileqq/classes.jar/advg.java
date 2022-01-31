import android.content.Intent;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.intervideo.now.ShareToQQActivity;

public class advg
  extends FriendListObserver
{
  public advg(ShareToQQActivity paramShareToQQActivity) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     advg
 * JD-Core Version:    0.7.0.1
 */