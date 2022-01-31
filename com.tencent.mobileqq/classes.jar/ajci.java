import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.BannerManager.27.1;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import cooperation.qzone.report.lp.LpReportInfo_dc00307;
import cooperation.qzone.report.lp.LpReportManager;
import java.net.URLEncoder;
import mqq.os.MqqHandler;

public class ajci
  implements View.OnClickListener
{
  ajci(ajbm paramajbm, String paramString, Long paramLong, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (!ajbm.a(this.jdField_a_of_type_Ajbm)) {
      return;
    }
    ajbm.a(this.jdField_a_of_type_Ajbm, false);
    new Handler().postDelayed(new BannerManager.27.1(this), 1000L);
    paramView = (QQAppInterface)ajbm.a(this.jdField_a_of_type_Ajbm).getAppRuntime();
    String str = paramView.getCurrentAccountUin();
    Object localObject = new StringBuilder(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append("?");
    ((StringBuilder)localObject).append("uin=");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append("&plat=1");
    ((StringBuilder)localObject).append("&app=1");
    ((StringBuilder)localObject).append("&version=8.3.3.4515");
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
    VasWebviewUtil.openQQBrowserActivity(ajbm.a(this.jdField_a_of_type_Ajbm), (String)localObject, 32768L, localIntent, false, -1);
    if (this.jdField_a_of_type_JavaLangLong.longValue() == 3L)
    {
      paramView = paramView.getHandler(Conversation.class);
      if (paramView == null) {}
    }
    try
    {
      paramView.sendMessage(paramView.obtainMessage(1134044));
      paramView = new LpReportInfo_dc00307(LpReportInfo_dc00307.ACTION_TYPE_RED_PACK, LpReportInfo_dc00307.SUB_ACTION_TYPE_RED_PACK_CLICK, this.jdField_a_of_type_Int);
      LpReportManager.getInstance().reportToDC00307(paramView, false, true);
      azmj.a(ajbm.a(this.jdField_a_of_type_Ajbm).app, "dc00898", "", "", "0X8009EE3", "0X8009EE3", 9, 0, "", "", "", "");
      return;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        paramView.fillInStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajci
 * JD-Core Version:    0.7.0.1
 */