import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.armap.ArMapUtil;
import com.tencent.mobileqq.armap.config.ARMapConfigManager;
import com.tencent.mobileqq.armap.config.ARMapConfigManager.ARMapShower;
import com.tencent.mobileqq.armap.wealthgod.WealthGodInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;

public class abfg
  implements Handler.Callback
{
  public abfg(ARMapConfigManager paramARMapConfigManager) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapConfigManager", 2, "mUICallback ,msg.what = " + paramMessage.what);
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (ARMapConfigManager.a(this.a) != null)
      {
        String str = (String)paramMessage.obj;
        boolean bool1;
        label120:
        boolean bool4;
        boolean bool3;
        boolean bool2;
        label159:
        int j;
        long l5;
        if (paramMessage.arg1 == 1)
        {
          bool1 = true;
          bool4 = str.equals("daily_pendant_breath");
          if (!bool4) {
            break label534;
          }
          bool3 = this.a.jdField_b_of_type_Boolean;
          bool2 = this.a.c;
          if (!bool1) {
            break label529;
          }
          i = 1;
          j = i;
          if (bool3) {
            ARMapConfigManager.a(this.a).a(true, j);
          }
          if (bool2)
          {
            ARMapConfigManager.a(this.a).a(true, false);
            this.a.g = false;
          }
          l5 = MessageCache.a() * 1000L;
          l3 = 0L;
          i = 0;
          if ((bool3) || (bool2))
          {
            if ((this.a.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo == null) || (this.a.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_d_of_type_Long >= this.a.jdField_b_of_type_Long + l5)) {
              break label569;
            }
            l2 = this.a.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_d_of_type_Long - l5;
            l1 = this.a.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_d_of_type_Long;
          }
        }
        for (int i = 1;; i = 4)
        {
          paramMessage = ArMapUtil.a(ARMapConfigManager.a(this.a));
          l4 = l1;
          l3 = l2;
          if (bool1) {}
          try
          {
            l4 = Long.decode(paramMessage.getString("pendant_breath_dismiss_timestamp", "")).longValue();
            l3 = l4 - l5;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            for (;;)
            {
              l4 = l1;
              l3 = l2;
            }
          }
          this.a.jdField_a_of_type_JavaLangString = str;
          paramMessage.edit().putString("key_cur_pendant_breath_key", str).commit();
          paramMessage.edit().putString("pendant_breath_dismiss_timestamp", String.valueOf(l4)).commit();
          this.a.a(str, i, l3);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ARMapConfigManager", 2, "UI_MSG_SHOW_PENDANT_BREATH isDailyPendantBreath:" + bool4 + ",canShowpendant:" + bool3 + ",canShowBreath:" + bool2 + ",actKey:" + str + ",delay:" + l3 + ",reason:" + i + ",isRecovery:" + bool1 + ",type:" + j + ",mCurShownPendantKey = " + this.a.jdField_a_of_type_JavaLangString);
          break;
          bool1 = false;
          break label120;
          label529:
          i = 0;
          break label159;
          label534:
          bool3 = this.a.jdField_d_of_type_Boolean;
          bool2 = this.a.e;
          if (bool1) {}
          for (i = 3;; i = 2)
          {
            j = i;
            break;
          }
          label569:
          l2 = this.a.jdField_b_of_type_Long;
          l1 = this.a.jdField_b_of_type_Long + l5;
        }
        if (ARMapConfigManager.a(this.a) != null)
        {
          if (ARMapConfigManager.a(this.a).b()) {
            ARMapConfigManager.a(this.a).a(false, 0);
          }
          if (ARMapConfigManager.a(this.a).a())
          {
            ARMapConfigManager.a(this.a).a(false, false);
            this.a.b();
          }
          str = (String)paramMessage.obj;
          this.a.jdField_a_of_type_JavaLangString = null;
          ArMapUtil.a(ARMapConfigManager.a(this.a)).edit().putString("key_cur_pendant_breath_key", null).commit();
          this.a.b(str);
          if (QLog.isColorLevel())
          {
            QLog.d("ARMapConfigManager", 2, "UI_MSG_HIDE_PENDANT_BREATH dismissReason:" + paramMessage.arg1 + ",actKey:" + str);
            continue;
            if ((ARMapConfigManager.a(this.a) != null) && (!ARMapConfigManager.a(this.a).a()))
            {
              ARMapConfigManager.a(this.a).a(true, true);
              this.a.g = true;
              l1 = NetConnInfoCenter.getServerTimeMillis();
              l2 = ArMapUtil.a(this.a.jdField_d_of_type_Long);
              if (l2 <= l1) {
                break label936;
              }
            }
            label936:
            for (l1 = l2 - l1;; l1 = 0L)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ARMapConfigManager", 2, "UI_MSG_TURN_PERMANENT_SPLASH_LIGHT send off msg ,delayMills = " + l1);
              }
              ARMapConfigManager.a(this.a).removeMessages(3);
              ARMapConfigManager.a(this.a).sendEmptyMessageDelayed(3, l1);
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("ARMapConfigManager", 2, "UI_MSG_TURN_PERMANENT_SPLASH_LIGHT mShower:" + ARMapConfigManager.a(this.a));
              break;
            }
            if ((ARMapConfigManager.a(this.a) != null) && (this.a.g) && (ARMapConfigManager.a(this.a).a()))
            {
              ARMapConfigManager.a(this.a).a(false, true);
              this.a.g = false;
            }
            if (QLog.isColorLevel())
            {
              QLog.d("ARMapConfigManager", 2, "UI_MSG_DOUSE_PERMANENT_SPLASH_LIGHT mShower:" + ARMapConfigManager.a(this.a) + ",isPermanentLedShowing：" + this.a.g);
              continue;
              if (ARMapConfigManager.a(this.a) != null) {
                ARMapConfigManager.a(this.a).a();
              }
              ARMapConfigManager.a(this.a).sendEmptyMessage(8);
              continue;
              if (ARMapConfigManager.a(this.a) != null)
              {
                if (ARMapConfigManager.a(this.a).b()) {
                  ARMapConfigManager.a(this.a).a(false, 0);
                }
                if (ARMapConfigManager.a(this.a).a()) {
                  ARMapConfigManager.a(this.a).a(false, false);
                }
                ARMapConfigManager.a(this.a).a("RESET");
              }
              if (QLog.isColorLevel())
              {
                QLog.d("ARMapConfigManager", 2, "mUICallback ,UI_MSG_CLOSE_ENTER mShower = " + ARMapConfigManager.a(this.a));
                continue;
                paramMessage = (ARMapConfigManager.ARMapShower)paramMessage.obj;
                ARMapConfigManager.a(this.a, paramMessage);
                if (QLog.isColorLevel()) {
                  QLog.d("ARMapConfigManager", 2, "mUICallback ,UI_MSG_ADD_SHOWER shower = " + paramMessage);
                }
                ARMapConfigManager.d(this.a, 0L);
                continue;
                ARMapConfigManager.a(this.a, null);
                if (QLog.isColorLevel())
                {
                  QLog.d("ARMapConfigManager", 2, "mUICallback ,UI_MSG_REMOVE_SHOWER ");
                  continue;
                  if (QLog.isColorLevel()) {
                    QLog.d("ARMapConfigManager", 2, "UI_MSG_HEART_BEAT ,mUIHandler = " + ARMapConfigManager.a(this.a) + ",mHandler = " + ARMapConfigManager.a(this.a));
                  }
                  ARMapConfigManager.a(this.a).removeMessages(8);
                  ARMapConfigManager.a(this.a).sendEmptyMessageDelayed(8, 10000L);
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abfg
 * JD-Core Version:    0.7.0.1
 */