import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.phone.GuideBindPhoneActivity;
import com.tencent.mobileqq.widget.QQToast;

class aeal
  implements akig
{
  aeal(aeag paramaeag) {}
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QQToast.a(this.a.a.getApplicationContext(), 1, anvx.a(2131704369), 0).a();
      return;
    }
    paramContext = new Intent(this.a.a, GuideBindPhoneActivity.class);
    paramContext.putExtra("fromKeyForContactBind", 5);
    paramContext.putExtra("key_contact_name", this.a.a.a.a.k);
    paramContext.putExtra("key_contact_phone", this.a.a.a.a.a);
    this.a.a.startActivity(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeal
 * JD-Core Version:    0.7.0.1
 */