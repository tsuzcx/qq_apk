import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.URLUtil;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;

class agzf
  implements View.OnClickListener
{
  agzf(agxq paramagxq, ajoe paramajoe) {}
  
  public void onClick(View paramView)
  {
    awqx.b(agxq.a(this.jdField_a_of_type_Agxq).app, "CliOper", "", "", "0X8005B73", "0X8005B73", 0, 0, "", "", "", "");
    paramView = BaseActivity.sTopActivity;
    Intent localIntent;
    if (paramView != null)
    {
      if (!URLUtil.isValidUrl(this.jdField_a_of_type_Ajoe.a)) {
        break label144;
      }
      localIntent = new Intent(paramView, QQBrowserActivity.class);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("url", this.jdField_a_of_type_Ajoe.a);
      localIntent.putExtra("hideRightButton", true);
      paramView.startActivity(localIntent);
    }
    for (;;)
    {
      this.jdField_a_of_type_Agxq.a(6, 0);
      awqx.a(agxq.a(this.jdField_a_of_type_Agxq).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 5, 0, "", "", "", "");
      return;
      label144:
      localIntent = new Intent(paramView, PhoneUnityBindInfoActivity.class);
      localIntent.putExtra("kSrouce", 0);
      paramView.startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agzf
 * JD-Core Version:    0.7.0.1
 */