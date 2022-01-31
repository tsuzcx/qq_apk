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

class abkb
  implements View.OnClickListener
{
  abkb(abjx paramabjx, amnn paramamnn, SharedPreferences paramSharedPreferences, String paramString) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_Amnn.e;
    paramView = this.jdField_a_of_type_Amnn.f;
    if ((((String)localObject).equals("TMTWAPI")) || (((String)localObject).equals("WAPI")))
    {
      paramView = alzf.a(paramView, 0, null);
      localObject = new Intent(this.jdField_a_of_type_Abjx.a, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_Abjx.a.app.getCurrentAccountUin());
      this.jdField_a_of_type_Abjx.a.startActivity(((Intent)localObject).putExtra("url", paramView));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean(this.jdField_a_of_type_JavaLangString, true).commit();
      this.jdField_a_of_type_Abjx.a.a.sendEmptyMessageDelayed(1010, 1000L);
      return;
      if ((((String)localObject).equals("TMTWAP")) || (((String)localObject).equals("WAP")))
      {
        localObject = new Intent(this.jdField_a_of_type_Abjx.a, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_Abjx.a.app.getCurrentAccountUin());
        this.jdField_a_of_type_Abjx.a.startActivity(((Intent)localObject).putExtra("url", paramView));
      }
      else if (((String)localObject).equals("LOCAL"))
      {
        if ("CARD".equalsIgnoreCase(paramView))
        {
          paramView = this.jdField_a_of_type_Amnn.g.split(",")[0];
          if (("".equals(paramView)) || (this.jdField_a_of_type_Abjx.a.app.getCurrentAccountUin().equals(paramView))) {}
          for (paramView = new ProfileActivity.AllInOne(this.jdField_a_of_type_Abjx.a.app.getCurrentAccountUin(), 0);; paramView = new ProfileActivity.AllInOne(paramView, 19))
          {
            ProfileActivity.b(this.jdField_a_of_type_Abjx.a, paramView);
            break;
          }
        }
        if ("CHAT".equalsIgnoreCase(paramView))
        {
          paramView = this.jdField_a_of_type_Amnn.g.split(",")[0];
          if (!"".equals(paramView)) {
            if (((ajjj)this.jdField_a_of_type_Abjx.a.app.getManager(51)).b(paramView)) {
              this.jdField_a_of_type_Abjx.a(paramView, 0, babh.i(this.jdField_a_of_type_Abjx.a.app, paramView));
            } else {
              this.jdField_a_of_type_Abjx.a(paramView, 1001, babh.i(this.jdField_a_of_type_Abjx.a.app, paramView));
            }
          }
        }
        else if ("NEARBY".equalsIgnoreCase(paramView))
        {
          this.jdField_a_of_type_Abjx.a.startActivity(new Intent(this.jdField_a_of_type_Abjx.a, NearbyActivity.class));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abkb
 * JD-Core Version:    0.7.0.1
 */