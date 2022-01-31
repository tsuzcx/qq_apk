import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.qphone.base.util.QLog;

public class aamk
  extends BroadcastReceiver
{
  public aamk(BaseChatPie paramBaseChatPie) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("tencent.av.v2q.StartVideoChat".equals(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "receive action_recv_video_request");
      }
      this.a.j(2);
    }
    do
    {
      return;
      if ("android.intent.action.PHONE_STATE".equals(paramContext))
      {
        paramContext = (TelephonyManager)this.a.jdField_a_of_type_AndroidContentContext.getSystemService("phone");
        if (paramContext.getCallState() == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "receive action_phone_state_changed|call_state_ringing");
          }
          this.a.j(2);
        }
        if (paramContext.getCallState() == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "receive action_phone_state_changed|call_state_ringing");
          }
          paramIntent = MediaPlayerManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (paramIntent.a()) {
            paramIntent.a(false);
          }
        }
        this.a.d(paramContext.getCallState());
        return;
      }
      if ((BaseChatPie.i() == 1) && ("vivo_smart_shot_enter".equals(paramContext)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("vivo", 2, "receive action_vivo_smart_shot_enter");
        }
        BaseChatPie.a(this.a, Boolean.valueOf(false));
        return;
      }
    } while (!"com.huawei.hwmultidisplay.action.WINDOW_CAST_MODE".equals(paramContext));
    boolean bool = paramIntent.getBooleanExtra("mode", false);
    QLog.d("WindowsCastReceiver", 1, "onReceive mode = " + bool);
    if (bool) {}
    for (int i = 1;; i = 0)
    {
      bbas.a = i;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aamk
 * JD-Core Version:    0.7.0.1
 */