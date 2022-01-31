import MQQ.PayRuleCfg;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;

public class abwj
  implements View.OnClickListener
{
  public abwj(QQSettingMe paramQQSettingMe) {}
  
  public void onClick(View paramView)
  {
    if (QQSettingMe.a(this.a) == null) {
      return;
    }
    if (QQSettingMe.a(this.a).clickHide == 1)
    {
      QQSettingMe.a(this.a).enable = 0;
      QLog.e("QQSettingRedesign", 1, "VipInfoHandler click clear enable");
      akjn.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), QQSettingMe.a(this.a));
    }
    axqy.b(null, "dc00898", "", "", "", "0X800A633", akjn.a(QQSettingMe.a(this.a)), 1, 0, "1", QQSettingMe.a(this.a).advId, "", "");
    akjn.a(102, QQSettingMe.a(this.a).advId);
    if (!TextUtils.isEmpty(QQSettingMe.a(this.a).iconJumpUrl))
    {
      QLog.e("QQSettingRedesign", 1, "VipInfoHandler click iconJumpUrl: " + QQSettingMe.a(this.a).iconJumpUrl);
      paramView = new Intent(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
      paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
      paramView.putExtra("url", QQSettingMe.a(this.a).iconJumpUrl);
      paramView.putExtra("isShowAd", false);
      this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
      return;
    }
    switch (QQSettingMe.a(this.a).clubType)
    {
    default: 
      QLog.e("QQSettingRedesign", 1, "VipInfoHandler unknown clubType=" + QQSettingMe.a(this.a).clubType);
      return;
    }
    for (int i = 11;; i = 12)
    {
      QLog.e("QQSettingRedesign", 1, "VipInfoHandler click type: " + QQSettingMe.a(this.a).clubType);
      paramView = URLEncoder.encode("jsbridge://vipclub/paySuccess?p={\"type\":" + i + "}");
      bbrk.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQSettingMe.a(this.a).aid, "CJCLUBT", 3, false, false, "", paramView, true, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abwj
 * JD-Core Version:    0.7.0.1
 */