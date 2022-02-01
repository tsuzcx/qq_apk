import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.BannerManager.29.1;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_dc00307;
import cooperation.qzone.report.lp.LpReportManager;
import java.net.URLEncoder;
import mqq.os.MqqHandler;

public class alef
  implements View.OnClickListener
{
  alef(aldh paramaldh, String paramString, Long paramLong, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (!aldh.a(this.jdField_a_of_type_Aldh)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      aldh.a(this.jdField_a_of_type_Aldh, false);
      new Handler().postDelayed(new BannerManager.29.1(this), 1000L);
      Object localObject1 = (QQAppInterface)aldh.a(this.jdField_a_of_type_Aldh).getAppRuntime();
      String str = ((QQAppInterface)localObject1).getCurrentAccountUin();
      Object localObject2 = new StringBuilder(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject2).append("?");
      ((StringBuilder)localObject2).append("uin=");
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append("&plat=1");
      ((StringBuilder)localObject2).append("&app=1");
      ((StringBuilder)localObject2).append("&version=8.4.10.4875");
      ((StringBuilder)localObject2).append("&device=" + URLEncoder.encode(Build.DEVICE));
      ((StringBuilder)localObject2).append("&system=" + Build.VERSION.RELEASE);
      ((StringBuilder)localObject2).append("&systemInt=" + Integer.toString(Build.VERSION.SDK_INT));
      localObject2 = ((StringBuilder)localObject2).toString();
      Intent localIntent = new Intent();
      localIntent.putExtra("portraitOnly", true);
      localIntent.putExtra("url", (String)localObject2);
      localIntent.putExtra("uin", str);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("hide_more_button", true);
      VasWebviewUtil.openQQBrowserActivity(aldh.a(this.jdField_a_of_type_Aldh), (String)localObject2, 32768L, localIntent, false, -1);
      if (this.jdField_a_of_type_JavaLangLong.longValue() == 3L)
      {
        localObject1 = ((QQAppInterface)localObject1).getHandler(Conversation.class);
        if (localObject1 == null) {}
      }
      try
      {
        ((MqqHandler)localObject1).sendMessage(((MqqHandler)localObject1).obtainMessage(1134044));
        localObject1 = new LpReportInfo_dc00307(LpReportInfo_dc00307.ACTION_TYPE_RED_PACK, LpReportInfo_dc00307.SUB_ACTION_TYPE_RED_PACK_CLICK, this.jdField_a_of_type_Int);
        LpReportManager.getInstance().reportToDC00307((LpReportInfo_dc00307)localObject1, false, true);
        bdla.a(aldh.a(this.jdField_a_of_type_Aldh).app, "dc00898", "", "", "0X8009EE3", "0X8009EE3", 9, 0, "", "", "", "");
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.fillInStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alef
 * JD-Core Version:    0.7.0.1
 */