import android.content.res.Resources;
import com.tencent.mobileqq.activity.ShieldFriendsListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.BaseApplication;

public class acbz
  extends ajxl
{
  public acbz(ShieldFriendsListActivity paramShieldFriendsListActivity) {}
  
  protected void onUpdateFriendShieldFlag(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    super.onUpdateFriendShieldFlag(paramLong, paramBoolean1, paramBoolean2, paramBoolean3, paramString);
    if (!paramBoolean2)
    {
      paramString = this.a;
      if (!paramBoolean1)
      {
        paramBoolean1 = true;
        if (ShieldFriendsListActivity.a(paramString, paramLong, paramBoolean1)) {
          bcpw.a(BaseApplication.getContext(), ajyc.a(2131713993), 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131298865));
        }
      }
    }
    do
    {
      return;
      paramBoolean1 = false;
      break;
      if (ShieldFriendsListActivity.a(this.a).a(String.valueOf(paramLong)))
      {
        ShieldFriendsListActivity.a(this.a, paramLong, paramBoolean1);
        return;
      }
      paramString = ((ajxn)this.a.app.getManager(51)).e(String.valueOf(paramLong));
    } while ((paramString == null) || (paramString.isShield()));
    ShieldFriendsListActivity.a(this.a).a(paramString);
    ShieldFriendsListActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acbz
 * JD-Core Version:    0.7.0.1
 */