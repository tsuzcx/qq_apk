import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.phone.GuideBindPhoneActivity;

class aauu
  implements afxz
{
  aauu(aaur paramaaur) {}
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      bbmy.a(this.a.a.getApplicationContext(), 1, ajjy.a(2131639105), 0).a();
      return;
    }
    paramContext = new Intent(this.a.a, GuideBindPhoneActivity.class);
    paramContext.putExtra("fromKeyForContactBind", 5);
    paramContext.putExtra("key_contact_name", this.a.a.a.a.k);
    paramContext.putExtra("key_contact_phone", this.a.a.a.a.a);
    this.a.a.startActivity(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aauu
 * JD-Core Version:    0.7.0.1
 */