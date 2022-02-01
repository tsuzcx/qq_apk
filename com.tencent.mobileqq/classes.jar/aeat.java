import MQQ.PrivExtV2Rsp;
import MQQ.VipMedalList;
import MQQ.VipUserInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.QQSettingMe.31.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class aeat
  extends aneh
{
  public aeat(QQSettingMe paramQQSettingMe) {}
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    if ((paramBoolean) && (paramInt >= 0) && (this.a.a != null))
    {
      Object localObject = this.a.a.getPreferences();
      if (localObject != null) {
        ((SharedPreferences)localObject).edit().putInt("key_selfvip_growthvalue", paramInt).commit();
      }
      localObject = this.a.a.getCurrentAccountUin();
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "updateLevelAndVip from mVipInfoObserver");
      }
      this.a.c((String)localObject);
    }
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    Object localObject;
    if (paramInt == 1) {
      if (paramBoolean)
      {
        paramObject = (PrivExtV2Rsp)paramObject;
        localObject = paramObject.vipInfo;
        if ((localObject != null) && (((VipUserInfo)localObject).bUpdate == 1))
        {
          localObject = ((VipUserInfo)localObject).sUri;
          if (localObject != null)
          {
            QQSettingMe.b(this.a, (String)localObject);
            if (QLog.isColorLevel()) {
              QLog.d("QQSettingRedesign", 2, "vip url = " + (String)localObject);
            }
            localObject = this.a.a.getApplication().getSharedPreferences(this.a.a.getCurrentAccountUin(), 4).edit().putString("VIPCenter_url_key", (String)localObject);
            if (Build.VERSION.SDK_INT >= 9) {
              break label216;
            }
            ((SharedPreferences.Editor)localObject).commit();
          }
        }
        localObject = this.a.a.getCurrentAccountUin();
        this.a.c((String)localObject);
        if (paramObject.medalInfoList != null) {
          bgff.a(paramObject.medalInfoList.lhNumFlag, paramObject.medalInfoList.lhLogoLv);
        }
        this.a.b.post(new QQSettingMe.31.1(this));
      }
      else
      {
        QQSettingMe.f(this.a);
      }
    }
    label216:
    do
    {
      return;
      ((SharedPreferences.Editor)localObject).apply();
      break;
      if ((paramBoolean) && (paramInt == 6))
      {
        QQSettingMe.f(this.a);
        return;
      }
      if (paramInt == 4)
      {
        this.a.b.sendEmptyMessage(2);
        return;
      }
    } while (paramInt != 5);
    this.a.b.sendMessage(this.a.b.obtainMessage(3, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeat
 * JD-Core Version:    0.7.0.1
 */