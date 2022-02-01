import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBroadcastActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class adxy
  implements View.OnClickListener
{
  adxy(adxu paramadxu, aqmc paramaqmc, SharedPreferences paramSharedPreferences, String paramString) {}
  
  public void onClick(View paramView)
  {
    Object localObject2 = this.jdField_a_of_type_Aqmc.e;
    Object localObject1 = this.jdField_a_of_type_Aqmc.f;
    if ((((String)localObject2).equals("TMTWAPI")) || (((String)localObject2).equals("WAPI")))
    {
      localObject1 = apth.a((String)localObject1, 0, null);
      localObject2 = new Intent(this.jdField_a_of_type_Adxu.a, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_Adxu.a.app.getCurrentAccountUin());
      this.jdField_a_of_type_Adxu.a.startActivity(((Intent)localObject2).putExtra("url", (String)localObject1));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean(this.jdField_a_of_type_JavaLangString, true).commit();
      this.jdField_a_of_type_Adxu.a.a.sendEmptyMessageDelayed(1010, 1000L);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((((String)localObject2).equals("TMTWAP")) || (((String)localObject2).equals("WAP")))
      {
        localObject2 = new Intent(this.jdField_a_of_type_Adxu.a, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_Adxu.a.app.getCurrentAccountUin());
        this.jdField_a_of_type_Adxu.a.startActivity(((Intent)localObject2).putExtra("url", (String)localObject1));
      }
      else if (((String)localObject2).equals("LOCAL"))
      {
        if ("CARD".equalsIgnoreCase((String)localObject1))
        {
          localObject1 = this.jdField_a_of_type_Aqmc.g.split(",")[0];
          if (("".equals(localObject1)) || (this.jdField_a_of_type_Adxu.a.app.getCurrentAccountUin().equals(localObject1))) {}
          for (localObject1 = new ProfileActivity.AllInOne(this.jdField_a_of_type_Adxu.a.app.getCurrentAccountUin(), 0);; localObject1 = new ProfileActivity.AllInOne((String)localObject1, 19))
          {
            ProfileActivity.b(this.jdField_a_of_type_Adxu.a, (ProfileActivity.AllInOne)localObject1);
            break;
          }
        }
        if ("CHAT".equalsIgnoreCase((String)localObject1))
        {
          localObject1 = this.jdField_a_of_type_Aqmc.g.split(",")[0];
          if (!"".equals(localObject1)) {
            if (((amsw)this.jdField_a_of_type_Adxu.a.app.getManager(51)).b((String)localObject1)) {
              this.jdField_a_of_type_Adxu.a((String)localObject1, 0, ContactUtils.getFriendNickName(this.jdField_a_of_type_Adxu.a.app, (String)localObject1));
            } else {
              this.jdField_a_of_type_Adxu.a((String)localObject1, 1001, ContactUtils.getFriendNickName(this.jdField_a_of_type_Adxu.a.app, (String)localObject1));
            }
          }
        }
        else if ("NEARBY".equalsIgnoreCase((String)localObject1))
        {
          this.jdField_a_of_type_Adxu.a.startActivity(new Intent(this.jdField_a_of_type_Adxu.a, NearbyActivity.class));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adxy
 * JD-Core Version:    0.7.0.1
 */