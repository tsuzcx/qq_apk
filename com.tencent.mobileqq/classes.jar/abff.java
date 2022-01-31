import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.armap.ArMapHandler;
import com.tencent.mobileqq.armap.ArMapUtil;
import com.tencent.mobileqq.armap.config.ARMapConfig;
import com.tencent.mobileqq.armap.config.ARMapConfig.WealthGodActTime;
import com.tencent.mobileqq.armap.config.ARMapConfig.WealthGodConfig;
import com.tencent.mobileqq.armap.config.ARMapConfigManager;
import com.tencent.mobileqq.armap.config.ARMapConfigManager.ARMapShower;
import com.tencent.mobileqq.armap.wealthgod.WealthGodInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

public class abff
  implements Handler.Callback
{
  public abff(ARMapConfigManager paramARMapConfigManager) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapConfigManager", 2, "mCallback ,msg.what = " + paramMessage.what);
    }
    long l1;
    long l3;
    long l2;
    switch (paramMessage.what)
    {
    default: 
    case 0: 
    case 5: 
      do
      {
        do
        {
          for (;;)
          {
            return true;
            ArMapUtil.a("start check armap config...");
            if ((!ARMapConfigManager.a(this.a)) || (ARMapConfigManager.a(this.a) == null))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ARMapConfigManager", 2, "start checkWealthGodConfig getARMapConfig not ready,isGetARMapConfig = " + ARMapConfigManager.a(this.a) + ",mShower = " + ARMapConfigManager.a(this.a));
              }
              return true;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ARMapConfigManager", 2, "start checkWealthGodConfig... mARMapConfig:" + ARMapConfigManager.a(this.a));
            }
            ARMapConfigManager.b(this.a);
            paramMessage = ARMapConfigManager.a(this.a);
            l1 = MessageCache.a() * 1000L;
            if ((paramMessage != null) && (paramMessage.isWealthGodEnterOpen()))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ARMapConfigManager", 2, "start checkWealthGodConfig...  in openGap");
              }
              ARMapConfigManager.b(this.a, 0L);
              if (!this.a.h)
              {
                this.a.h = true;
                if (this.a.b()) {
                  this.a.a("daily_pendant_breath", false, 0L);
                }
                String str = ArMapUtil.a(ARMapConfigManager.a(this.a)).getString("key_cur_pendant_breath_key", "");
                if (QLog.isColorLevel()) {
                  QLog.d("ARMapConfigManager", 2, "start checkWealthGodConfig...  in openGap,actKey = " + str);
                }
                if (str.equals("daily_pendant_breath")) {
                  this.a.a(str);
                }
              }
              this.a.b();
              ARMapConfigManager.c(this.a, paramMessage.wealthGodConfig.enterCloseTime - l1);
              ARMapConfigManager.a(this.a).obtainMessage(5, paramMessage).sendToTarget();
            }
            else
            {
              if (QLog.isColorLevel()) {
                QLog.d("ARMapConfigManager", 2, "start checkWealthGodConfig... out of openGap ");
              }
              if (ARMapConfigManager.a(this.a) != null)
              {
                ARMapConfigManager.a(this.a).removeMessages(5);
                ARMapConfigManager.a(this.a).sendEmptyMessage(5);
              }
              if ((paramMessage != null) && (paramMessage.wealthGodConfig != null) && (l1 < paramMessage.wealthGodConfig.enterOpenTime)) {
                ARMapConfigManager.d(this.a, paramMessage.wealthGodConfig.enterOpenTime - l1 + 1000L);
              }
            }
          }
        } while (!(paramMessage.obj instanceof ARMapConfig));
        l3 = MessageCache.a() * 1000L;
        paramMessage = ((ARMapConfig)paramMessage.obj).getRecentActTime();
        if (QLog.isColorLevel()) {
          QLog.d("ARMapConfigManager", 2, "MSG_CHECK_RECENT_ACT recentActTime:" + paramMessage);
        }
        if (paramMessage == null) {
          break;
        }
      } while (paramMessage.getStatus() == 0);
      ARMapConfigManager.d(this.a, paramMessage.endTime - l3 + 1000L);
      if ((ARMapConfigManager.a(this.a) > 0L) && (ARMapConfigManager.b(this.a) > ARMapConfigManager.a(this.a)))
      {
        l1 = ARMapConfigManager.b(this.a);
        l2 = ARMapConfigManager.a(this.a);
        if (l3 < paramMessage.beginTime - ARMapConfigManager.b(this.a))
        {
          double d1 = paramMessage.beginTime - ARMapConfigManager.a(this.a);
          double d2 = Math.random();
          l1 = (d1 - (l1 - l2) * d2);
        }
      }
      break;
    }
    for (;;)
    {
      label692:
      l2 = 0L;
      if (l1 > 0L) {
        if (l3 <= l1) {
          break label823;
        }
      }
      label823:
      for (l2 = 0L;; l2 = l1 - l3)
      {
        ARMapConfigManager.a(this.a).removeMessages(6);
        ARMapConfigManager.a(this.a).sendEmptyMessageDelayed(6, l2);
        if (!QLog.isColorLevel()) {
          break;
        }
        paramMessage = ArMapUtil.a(l1, "yyyy-MM-dd HH:mm:ss");
        QLog.d("ARMapConfigManager", 2, "MSG_CHECK_RECENT_ACT sendFirstLocateMsg firstLocateTime:" + l1 + "|" + paramMessage + ",delayMills:" + l2);
        break;
        if (QLog.isColorLevel()) {
          QLog.d("ARMapConfigManager", 2, "MSG_CHECK_RECENT_ACT already in Gap");
        }
        l1 = l3;
        break label692;
      }
      QLog.d("ARMapConfigManager", 1, "MSG_CHECK_RECENT_ACT checkWealthGodConfig recentActTime is null!");
      break;
      ArMapUtil.a("start first locate...");
      SosoInterface.a(this.a.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
      ARMapConfigManager.a(this.a).removeMessages(2);
      ARMapConfigManager.a(this.a).sendEmptyMessageDelayed(2, ARMapConfigManager.c(this.a));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ARMapConfigManager", 2, "MSG_START_FIRST_LOCATE ,mLocateFreq = " + ARMapConfigManager.c(this.a));
      break;
      if (QLog.isColorLevel()) {
        QLog.d("ARMapConfigManager", 2, "MSG_STOP_CHECK ");
      }
      ARMapConfigManager.b(this.a);
      break;
      l1 = NetConnInfoCenter.getServerTimeMillis();
      boolean bool = false;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo != null) && (l1 > this.a.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.d))
      {
        bool = true;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ARMapConfigManager", 2, "MSG_LOCATE_CHECK...freq:" + ARMapConfigManager.c(this.a) + ",needReSetLocateTimer:" + ARMapConfigManager.b(this.a) + ",recheck = " + bool + ",mShower = " + ARMapConfigManager.a(this.a));
        break;
      }
      if (ARMapConfigManager.a(this.a) != null)
      {
        if (!ARMapConfigManager.a(this.a).c()) {
          break label1193;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ARMapConfigManager", 2, "sendLocatCheckMsg...freq:" + ARMapConfigManager.c(this.a));
        }
        ArMapUtil.a("locate check...");
        ARMapConfigManager.a(this.a, false);
        SosoInterface.a(ARMapConfigManager.a(this.a));
      }
      for (;;)
      {
        ARMapConfigManager.a(this.a).removeMessages(2);
        ARMapConfigManager.a(this.a).sendEmptyMessageDelayed(2, ARMapConfigManager.c(this.a));
        break;
        label1193:
        ARMapConfigManager.a(this.a, true);
      }
      l1 = NetConnInfoCenter.getServerTimeMillis();
      bool = false;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo != null) && (l1 > this.a.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.d))
      {
        bool = true;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ARMapConfigManager", 2, "MSG_QUERY_COUNT ,mAdcode = " + this.a.e + ",mQueryInterval = " + this.a.f + ",needReSetWealthTimer = " + ARMapConfigManager.c(this.a) + ",recheck = " + bool + ",mShower = " + ARMapConfigManager.a(this.a));
        break;
      }
      if (ARMapConfigManager.a(this.a) != null)
      {
        if (!ARMapConfigManager.a(this.a).c()) {
          break label1447;
        }
        l1 = this.a.e;
        ARMapConfigManager.b(this.a, false);
        if ((ARMapConfigManager.a(this.a) != null) && (l1 > 0L)) {
          ARMapConfigManager.a(this.a).a(l1, false, 1, null);
        }
      }
      for (;;)
      {
        ARMapConfigManager.a(this.a).removeMessages(3);
        ARMapConfigManager.a(this.a).sendEmptyMessageDelayed(3, this.a.f);
        break;
        label1447:
        ARMapConfigManager.b(this.a, true);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ARMapConfigManager", 2, "MSG_ENTER_CLOSE ");
      }
      ARMapConfigManager.b(this.a);
      ARMapConfigManager.a(this.a).removeMessages(5);
      ARMapConfigManager.a(this.a).sendEmptyMessage(5);
      break;
      l1 = -1L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abff
 * JD-Core Version:    0.7.0.1
 */