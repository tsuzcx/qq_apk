import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.activity.QQSettingSettingActivity;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForGrayTips.HightlightClickableSpan;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class afhv
  implements Manager
{
  private QQAppInterface a;
  
  public afhv(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PaiYiPaiManager", 2, "updateModified() called");
    }
    String str = this.a.getCurrentAccountUin();
    BaseApplicationImpl.getApplication().getSharedPreferences("pai_yi_pai_profile_info_" + str, 0).edit().putBoolean("modified", true).apply();
  }
  
  public void a(MessageForGrayTips.HightlightClickableSpan paramHightlightClickableSpan)
  {
    int i = 1;
    Context localContext = paramHightlightClickableSpan.getContext();
    if ((localContext instanceof ChatHistoryActivity))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PaiYiPaiManager", 2, "onClickDoubleTapTips() no action for " + localContext);
      }
      return;
    }
    localContext.startActivity(new Intent(localContext, QQSettingSettingActivity.class));
    localContext.startActivity(new Intent(localContext, NotifyPushSettingActivity.class));
    paramHightlightClickableSpan.clickWebMsg("https://zb.vip.qq.com/v2/pages/nudgeMall?_wv=2");
    if (paramHightlightClickableSpan.getMessage().istroop == 0) {}
    for (;;)
    {
      bcef.b(null, "dc00898", "", "", "0X800B3A4", "0X800B3A4", i, 0, "", "", "", "");
      return;
      if (paramHightlightClickableSpan.getMessage().istroop == 1) {
        i = 2;
      } else {
        i = 10;
      }
    }
  }
  
  public void a(short paramShort)
  {
    Object localObject = this.a.getCurrentAccountUin();
    localObject = BaseApplicationImpl.getApplication().getSharedPreferences("pai_yi_pai_profile_info_" + (String)localObject, 0);
    short s = ((SharedPreferences)localObject).getInt("switch", 0);
    if (QLog.isColorLevel()) {
      QLog.d("PaiYiPaiManager", 2, "onUpdateSwitch() called with: isClosed = [" + paramShort + "], currentSwitch = [" + s + "]");
    }
    if (s != paramShort)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt("switch", paramShort);
      ((SharedPreferences.Editor)localObject).apply();
    }
  }
  
  public boolean a()
  {
    String str = this.a.getCurrentAccountUin();
    boolean bool = BaseApplicationImpl.getApplication().getSharedPreferences("pai_yi_pai_profile_info_" + str, 0).getBoolean("modified", false);
    if (QLog.isColorLevel()) {
      QLog.d("PaiYiPaiManager", 2, "isModified() isModified = [" + bool + "]");
    }
    return bool;
  }
  
  public void b(short paramShort)
  {
    Object localObject = this.a.getCurrentAccountUin();
    localObject = BaseApplicationImpl.getApplication().getSharedPreferences("pai_yi_pai_profile_info_" + (String)localObject, 0);
    short s = ((SharedPreferences)localObject).getInt("action", 0);
    if (QLog.isColorLevel()) {
      QLog.d("PaiYiPaiManager", 2, "onUpdateAction() called with: action = [" + paramShort + "], currentAction = [" + s + "]");
    }
    if (s != paramShort)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt("action", paramShort);
      ((SharedPreferences.Editor)localObject).apply();
    }
    if ((paramShort != 0) || (s != 0)) {
      a();
    }
  }
  
  public void c(short paramShort)
  {
    Object localObject = this.a.getCurrentAccountUin();
    localObject = BaseApplicationImpl.getApplication().getSharedPreferences("pai_yi_pai_profile_info_" + (String)localObject, 0);
    short s = ((SharedPreferences)localObject).getInt("effect", 0);
    if (QLog.isColorLevel()) {
      QLog.d("PaiYiPaiManager", 2, "onUpdateEffect() called with: effect = [" + paramShort + "], currentEffect = [" + s + "]");
    }
    if (s != paramShort)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt("effect", paramShort);
      ((SharedPreferences.Editor)localObject).apply();
    }
    if ((paramShort != 0) || (s != 0)) {
      a();
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afhv
 * JD-Core Version:    0.7.0.1
 */