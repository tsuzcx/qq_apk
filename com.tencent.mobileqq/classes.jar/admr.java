import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class admr
  implements View.OnClickListener
{
  public admr(PermisionPrivacyActivity paramPermisionPrivacyActivity, SharedPreferences paramSharedPreferences, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    paramView = bdtg.a("gameIconSetupH5Url");
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityPermisionPrivacyActivity.app.getApp(), QQBrowserActivity.class);
    localIntent.setFlags(268435456);
    localIntent.putExtra("vasUsePreWebview", true);
    VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_ComTencentMobileqqActivityPermisionPrivacyActivity.app.getApp(), paramView, -1L, localIntent, false, -1);
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqActivityPermisionPrivacyActivity.app, "CliOper", "", "", "Setting_tab", "0X8009C07", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     admr
 * JD-Core Version:    0.7.0.1
 */