import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.recent.BannerManager.39.1;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URLEncoder;
import mqq.os.MqqHandler;

public class akzq
  implements View.OnClickListener
{
  akzq(akyh paramakyh) {}
  
  public void onClick(View paramView)
  {
    if (!akyh.a(this.a)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      akyh.a(this.a, false);
      new Handler().postDelayed(new BannerManager.39.1(this), 1000L);
      QQAppInterface localQQAppInterface = (QQAppInterface)akyh.a(this.a).getAppRuntime();
      String str = localQQAppInterface.getCurrentAccountUin();
      Object localObject = new StringBuilder("https://aq.qq.com/cn2/change_psw/mobile/mobile_change_psw_reg_input_psw");
      ((StringBuilder)localObject).append("?");
      ((StringBuilder)localObject).append("uin=");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("&plat=1");
      ((StringBuilder)localObject).append("&app=1");
      ((StringBuilder)localObject).append("&version=8.4.1.4680");
      ((StringBuilder)localObject).append("&device=" + URLEncoder.encode(Build.DEVICE));
      ((StringBuilder)localObject).append("&system=" + Build.VERSION.RELEASE);
      ((StringBuilder)localObject).append("&systemInt=" + Integer.toString(Build.VERSION.SDK_INT));
      localObject = ((StringBuilder)localObject).toString();
      Intent localIntent = new Intent();
      localIntent.putExtra("portraitOnly", true);
      localIntent.putExtra("url", (String)localObject);
      localIntent.putExtra("uin", str);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("hide_more_button", true);
      VasWebviewUtil.openQQBrowserActivity(akyh.a(this.a), (String)localObject, 32768L, localIntent, false, -1);
      aywm.a().a(localQQAppInterface);
      akyh.a(this.a).sendEmptyMessageDelayed(4, 1000L);
      bcst.b(localQQAppInterface, "CliOper", "", "", "Mobile_signup", "Clk_blue_pw", 0, 0, "", "", "", "");
      bcst.a(akyh.a(this.a).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 18, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akzq
 * JD-Core Version:    0.7.0.1
 */