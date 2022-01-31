import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.URLUtil;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;

class ahlu
  implements View.OnClickListener
{
  ahlu(ahkf paramahkf, akco paramakco) {}
  
  public void onClick(View paramView)
  {
    axqw.b(ahkf.a(this.jdField_a_of_type_Ahkf).app, "CliOper", "", "", "0X8005B73", "0X8005B73", 0, 0, "", "", "", "");
    paramView = BaseActivity.sTopActivity;
    Intent localIntent;
    if (paramView != null)
    {
      if (!URLUtil.isValidUrl(this.jdField_a_of_type_Akco.a)) {
        break label144;
      }
      localIntent = new Intent(paramView, QQBrowserActivity.class);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("url", this.jdField_a_of_type_Akco.a);
      localIntent.putExtra("hideRightButton", true);
      paramView.startActivity(localIntent);
    }
    for (;;)
    {
      this.jdField_a_of_type_Ahkf.a(6, 0);
      axqw.a(ahkf.a(this.jdField_a_of_type_Ahkf).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 5, 0, "", "", "", "");
      return;
      label144:
      localIntent = new Intent(paramView, PhoneUnityBindInfoActivity.class);
      localIntent.putExtra("kSrouce", 0);
      paramView.startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahlu
 * JD-Core Version:    0.7.0.1
 */