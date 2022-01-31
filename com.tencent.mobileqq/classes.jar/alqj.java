import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.HotchatSCHelper.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

public class alqj
  implements alqo, Handler.Callback
{
  alqk a;
  public alql a;
  public Handler a;
  public QQAppInterface a;
  public String a;
  public boolean a;
  public boolean b;
  
  public alqj(QQAppInterface paramQQAppInterface, alqk paramalqk, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Alql = ((alql)paramQQAppInterface.getManager(123));
    this.jdField_a_of_type_Alqk = paramalqk;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidOsHandler = new bhow(Looper.getMainLooper(), this);
    if (QLog.isDevelopLevel()) {
      ausq.a("HotchatSCMng", "HotchatSCHelper", new Object[] { paramString, this.jdField_a_of_type_Alqk });
    }
  }
  
  public static long a()
  {
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    if (QLog.isColorLevel())
    {
      long l2 = System.currentTimeMillis();
      ausq.a("HotchatSCMng", new Object[] { "getCurTime", Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(Math.abs(l2 - l1)) });
    }
    return l1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Alql.b(this);
    if (alql.jdField_a_of_type_Boolean) {
      ausq.a("HotchatSCMng", "stopCheck", new Object[0]);
    }
  }
  
  public void a(long paramLong)
  {
    if (alql.jdField_a_of_type_Boolean) {
      ausq.a("HotchatSCMng", "startCheckDelay", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Long.valueOf(paramLong), Boolean.valueOf(this.jdField_a_of_type_Alql.b) });
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, paramLong);
  }
  
  public void b()
  {
    a();
    this.jdField_a_of_type_Alqk = null;
    if (alql.jdField_a_of_type_Boolean) {
      ausq.a("HotchatSCMng", "destroy", new Object[0]);
    }
  }
  
  public void b(long paramLong)
  {
    if (alql.jdField_a_of_type_Boolean) {
      ausq.a("HotchatSCMng", "startCheck", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Long.valueOf(paramLong), Boolean.valueOf(this.jdField_a_of_type_Alql.b) });
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Alql.b)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, paramLong);
    }
    for (;;)
    {
      this.jdField_a_of_type_Alql.a(this);
      return;
      ThreadManager.post(new HotchatSCHelper.1(this, paramLong, System.currentTimeMillis()), 8, null, true);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return true;
    }
    long l2;
    if (paramMessage.what == 0)
    {
      l2 = a();
      paramMessage = this.jdField_a_of_type_Alql.a(this.jdField_a_of_type_JavaLangString, 0, l2);
      if (alql.jdField_a_of_type_Boolean) {
        ausq.a("HotchatSCMng", "MSG_GET_NOTE_TOSHOW", new Object[] { "cur", paramMessage });
      }
      if (this.jdField_a_of_type_Alqk != null) {
        if (paramMessage != null)
        {
          paramMessage.jdField_a_of_type_Boolean = this.jdField_a_of_type_Alqk.a(paramMessage);
          label87:
          if (paramMessage == null) {
            break label277;
          }
        }
      }
    }
    label277:
    for (long l1 = paramMessage.b - l2;; l1 = 0L)
    {
      if (l1 > 0L)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, l1 + 100L);
        return true;
        this.jdField_a_of_type_Alqk.a(null);
        break label87;
        if (!alql.jdField_a_of_type_Boolean) {
          break label87;
        }
        ausq.a("HotchatSCMng", "MSG_GET_NOTE_TOSHOW", new Object[] { "listener is null" });
        break label87;
      }
      paramMessage = this.jdField_a_of_type_Alql.a(this.jdField_a_of_type_JavaLangString, 2, l2);
      if (alql.jdField_a_of_type_Boolean) {
        ausq.a("HotchatSCMng", "MSG_GET_NOTE_TOSHOW", new Object[] { "next", paramMessage });
      }
      if (paramMessage != null)
      {
        l1 = Math.max(60000L, paramMessage.jdField_a_of_type_Long - l2);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, l1);
        return true;
      }
      this.jdField_a_of_type_Boolean = false;
      if (!alql.jdField_a_of_type_Boolean) {
        break;
      }
      ausq.a("HotchatSCMng", "MSG_GET_NOTE_TOSHOW", new Object[] { "stop check" });
      return true;
      if (paramMessage.what != 2) {
        break;
      }
      b(100L);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alqj
 * JD-Core Version:    0.7.0.1
 */