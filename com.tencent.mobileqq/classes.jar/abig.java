import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.armap.ArMapHandler.RespWealthGodInfo;
import com.tencent.mobileqq.armap.ArMapObserver;
import com.tencent.mobileqq.armap.config.ARMapConfigManager;
import com.tencent.mobileqq.armap.wealthgod.ARMapLoadingActivity;
import com.tencent.mobileqq.armap.wealthgod.ARMapSplashView;
import com.tencent.mobileqq.armap.wealthgod.WealthGodInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class abig
  extends ArMapObserver
{
  public abig(ARMapLoadingActivity paramARMapLoadingActivity) {}
  
  public void onGetWealthGodInfo(boolean paramBoolean, ArMapHandler.RespWealthGodInfo paramRespWealthGodInfo)
  {
    ARMapLoadingActivity.a(this.a).f = System.currentTimeMillis();
    List localList = paramRespWealthGodInfo.jdField_a_of_type_JavaUtilList;
    boolean bool = paramRespWealthGodInfo.jdField_a_of_type_Boolean;
    ARMapLoadingActivity.a(this.a).removeMessages(107);
    if (localList != null)
    {
      paramRespWealthGodInfo = localList.iterator();
      while (paramRespWealthGodInfo.hasNext())
      {
        localWealthGodInfo = (WealthGodInfo)paramRespWealthGodInfo.next();
        QLog.d("ARMapLoadingActivity", 2, "onGetWealthGodInfo info: " + localWealthGodInfo);
      }
    }
    WealthGodInfo localWealthGodInfo = null;
    paramRespWealthGodInfo = localWealthGodInfo;
    if (paramBoolean)
    {
      paramRespWealthGodInfo = localWealthGodInfo;
      if (localList != null) {
        paramRespWealthGodInfo = ARMapConfigManager.a(localList);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ARMapLoadingActivity", 2, String.format("onGetWealthGodInfo mRequestInfoTimeout=%s isSuc=%s recentInfo=%s", new Object[] { Boolean.valueOf(ARMapLoadingActivity.c(this.a)), Boolean.valueOf(paramBoolean), paramRespWealthGodInfo }));
    }
    if (!ARMapLoadingActivity.c(this.a))
    {
      ARMapLoadingActivity.a(this.a).removeObserver(ARMapLoadingActivity.a(this.a));
      ARMapLoadingActivity.a(this.a, paramRespWealthGodInfo);
      if (ARMapLoadingActivity.a(this.a) == null) {
        break label384;
      }
      ARMapLoadingActivity.a(this.a).jdField_a_of_type_Boolean = bool;
      ARMapLoadingActivity.b(this.a);
    }
    for (;;)
    {
      ARMapLoadingActivity.a(this.a).setWealthGodInfo(ARMapLoadingActivity.a(this.a), ARMapLoadingActivity.d(this.a));
      ARMapLoadingActivity.b(this.a, ARMapLoadingActivity.a(this.a).a());
      if ((ARMapLoadingActivity.a(this.a) != null) && (ARMapLoadingActivity.a(this.a) != null))
      {
        ARMapLoadingActivity.a(this.a).a(ARMapLoadingActivity.a(this.a));
        ARMapLoadingActivity.a(this.a).a(ARMapLoadingActivity.a(this.a), ARMapLoadingActivity.b(this.a));
      }
      if (ARMapLoadingActivity.b(this.a) == 5) {
        ARMapLoadingActivity.a(this.a).c();
      }
      ARMapLoadingActivity.a(this.a).removeMessages(102);
      ARMapLoadingActivity.a(this.a).sendEmptyMessageDelayed(102, 200L);
      return;
      label384:
      QLog.d("ARMapLoadingActivity", 1, "onGetWealthGodInfo get info fail! no activity?");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abig
 * JD-Core Version:    0.7.0.1
 */