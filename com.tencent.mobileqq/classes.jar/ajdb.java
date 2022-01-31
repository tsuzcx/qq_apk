import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.URLUtil;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;

class ajdb
  implements View.OnClickListener
{
  ajdb(ajbm paramajbm, aluc paramaluc) {}
  
  public void onClick(View paramView)
  {
    azmj.b(ajbm.a(this.jdField_a_of_type_Ajbm).app, "CliOper", "", "", "0X8005B73", "0X8005B73", 0, 0, "", "", "", "");
    paramView = BaseActivity.sTopActivity;
    Intent localIntent;
    if (paramView != null)
    {
      if (!URLUtil.isValidUrl(this.jdField_a_of_type_Aluc.a)) {
        break label144;
      }
      localIntent = new Intent(paramView, QQBrowserActivity.class);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("url", this.jdField_a_of_type_Aluc.a);
      localIntent.putExtra("hideRightButton", true);
      paramView.startActivity(localIntent);
    }
    for (;;)
    {
      this.jdField_a_of_type_Ajbm.a(6, 0);
      azmj.a(ajbm.a(this.jdField_a_of_type_Ajbm).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 5, 0, "", "", "", "");
      return;
      label144:
      localIntent = new Intent(paramView, PhoneUnityBindInfoActivity.class);
      localIntent.putExtra("kSrouce", 0);
      paramView.startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajdb
 * JD-Core Version:    0.7.0.1
 */