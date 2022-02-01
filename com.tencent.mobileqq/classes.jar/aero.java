import MQQ.PayRuleCfg;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.TicketManager;

public class aero
  extends Handler
{
  public aero(QQSettingMe paramQQSettingMe, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      this.a.i();
      return;
    case 1: 
      QQSettingMe.a(this.a);
      return;
    case 2: 
      this.a.t();
      return;
    }
    int i = ((Bundle)paramMessage.obj).getInt("type");
    QLog.e("QQSettingRedesign", 1, "VipInfoHandler paySuccess " + i);
    if ((QQSettingMe.a(this.a) != null) && (QQSettingMe.a(this.a).payHide == 1))
    {
      QQSettingMe.a(this.a).enable = 0;
      QLog.e("QQSettingRedesign", 1, "VipInfoHandler paySuccess clear bubble");
      aogw.a(this.a.a.getCurrentUin(), QQSettingMe.a(this.a));
      sendEmptyMessage(2);
    }
    bhzf.a(this.a.a, "last_pull_pay_rule", 0L);
    paramMessage = ((TicketManager)this.a.a.getManager(2)).getSkey(this.a.a.getCurrentAccountUin());
    ((aogw)this.a.a.getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER)).a(paramMessage, this.a.a.getCurrentUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aero
 * JD-Core Version:    0.7.0.1
 */