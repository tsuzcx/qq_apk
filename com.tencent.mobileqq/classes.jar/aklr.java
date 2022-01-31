import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;

public class aklr
  implements Runnable
{
  public aklr(WebAccelerateHelper paramWebAccelerateHelper, String paramString) {}
  
  public void run()
  {
    Object localObject1 = CookieManager.getInstance().getCookie(this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("WebAccelerateHelper", 2, "cookie=" + Util.c((String)localObject1, new String[0]));
    }
    boolean bool3 = TextUtils.isEmpty((CharSequence)localObject1);
    boolean bool2;
    boolean bool1;
    if (!bool3)
    {
      Object localObject2 = MobileQQ.sMobileQQ.waitAppRuntime(null);
      if ((localObject2 != null) && (((AppRuntime)localObject2).isLogin()))
      {
        String str = ((AppRuntime)localObject2).getAccount();
        localObject2 = ((TicketManager)((AppRuntime)localObject2).getManager(2)).getSkey(str);
        if ((!((String)localObject1).contains("uin")) || (!((String)localObject1).contains(str)))
        {
          bool2 = true;
          if (!AuthorizeConfig.a().a(this.jdField_a_of_type_JavaLangString)) {
            break label272;
          }
          if ((((String)localObject1).contains("skey")) && (((String)localObject1).contains((CharSequence)localObject2))) {
            break label183;
          }
          bool1 = true;
        }
      }
    }
    for (;;)
    {
      if ((!bool3) && (!bool2) && (!bool1))
      {
        return;
        bool2 = false;
        break;
        label183:
        bool1 = false;
        continue;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(bool3).append('|');
      ((StringBuilder)localObject1).append(bool2).append('|');
      ((StringBuilder)localObject1).append(bool1).append('|');
      ((StringBuilder)localObject1).append(false);
      VipUtils.a(null, "webview_report", "0X8006117", "0X8006117", 2, 0, new String[] { this.jdField_a_of_type_JavaLangString, ((StringBuilder)localObject1).toString() });
      return;
      label272:
      bool1 = false;
      continue;
      bool1 = false;
      bool2 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aklr
 * JD-Core Version:    0.7.0.1
 */