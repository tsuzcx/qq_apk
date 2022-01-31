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

class abub
  implements View.OnClickListener
{
  abub(abtx paramabtx, andu paramandu, SharedPreferences paramSharedPreferences, String paramString) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_Andu.e;
    paramView = this.jdField_a_of_type_Andu.f;
    if ((((String)localObject).equals("TMTWAPI")) || (((String)localObject).equals("WAPI")))
    {
      paramView = amov.a(paramView, 0, null);
      localObject = new Intent(this.jdField_a_of_type_Abtx.a, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_Abtx.a.app.getCurrentAccountUin());
      this.jdField_a_of_type_Abtx.a.startActivity(((Intent)localObject).putExtra("url", paramView));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean(this.jdField_a_of_type_JavaLangString, true).commit();
      this.jdField_a_of_type_Abtx.a.a.sendEmptyMessageDelayed(1010, 1000L);
      return;
      if ((((String)localObject).equals("TMTWAP")) || (((String)localObject).equals("WAP")))
      {
        localObject = new Intent(this.jdField_a_of_type_Abtx.a, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_Abtx.a.app.getCurrentAccountUin());
        this.jdField_a_of_type_Abtx.a.startActivity(((Intent)localObject).putExtra("url", paramView));
      }
      else if (((String)localObject).equals("LOCAL"))
      {
        if ("CARD".equalsIgnoreCase(paramView))
        {
          paramView = this.jdField_a_of_type_Andu.g.split(",")[0];
          if (("".equals(paramView)) || (this.jdField_a_of_type_Abtx.a.app.getCurrentAccountUin().equals(paramView))) {}
          for (paramView = new ProfileActivity.AllInOne(this.jdField_a_of_type_Abtx.a.app.getCurrentAccountUin(), 0);; paramView = new ProfileActivity.AllInOne(paramView, 19))
          {
            ProfileActivity.b(this.jdField_a_of_type_Abtx.a, paramView);
            break;
          }
        }
        if ("CHAT".equalsIgnoreCase(paramView))
        {
          paramView = this.jdField_a_of_type_Andu.g.split(",")[0];
          if (!"".equals(paramView)) {
            if (((ajxn)this.jdField_a_of_type_Abtx.a.app.getManager(51)).b(paramView)) {
              this.jdField_a_of_type_Abtx.a(paramView, 0, bbcl.i(this.jdField_a_of_type_Abtx.a.app, paramView));
            } else {
              this.jdField_a_of_type_Abtx.a(paramView, 1001, bbcl.i(this.jdField_a_of_type_Abtx.a.app, paramView));
            }
          }
        }
        else if ("NEARBY".equalsIgnoreCase(paramView))
        {
          this.jdField_a_of_type_Abtx.a.startActivity(new Intent(this.jdField_a_of_type_Abtx.a, NearbyActivity.class));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abub
 * JD-Core Version:    0.7.0.1
 */