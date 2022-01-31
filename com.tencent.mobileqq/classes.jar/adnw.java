import MQQ.PrivExtV2Rsp;
import MQQ.VipUserInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.QQSettingMe.29.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class adnw
  extends ambe
{
  public adnw(QQSettingMe paramQQSettingMe) {}
  
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
    if (paramInt == 1) {
      if (paramBoolean)
      {
        paramObject = ((PrivExtV2Rsp)paramObject).vipInfo;
        if ((paramObject != null) && (paramObject.bUpdate == 1))
        {
          paramObject = paramObject.sUri;
          if (paramObject != null)
          {
            QQSettingMe.b(this.a, paramObject);
            if (QLog.isColorLevel()) {
              QLog.d("QQSettingRedesign", 2, "vip url = " + paramObject);
            }
            paramObject = this.a.a.getApplication().getSharedPreferences(this.a.a.getCurrentAccountUin(), 4).edit().putString("VIPCenter_url_key", paramObject);
            if (Build.VERSION.SDK_INT >= 9) {
              break label170;
            }
            paramObject.commit();
          }
        }
        paramObject = this.a.a.getCurrentAccountUin();
        this.a.c(paramObject);
        this.a.b.post(new QQSettingMe.29.1(this));
      }
    }
    label170:
    do
    {
      return;
      paramObject.apply();
      break;
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
 * Qualified Name:     adnw
 * JD-Core Version:    0.7.0.1
 */