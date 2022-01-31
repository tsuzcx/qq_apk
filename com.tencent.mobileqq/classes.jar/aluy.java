import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.HotchatSCHelper.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

public class aluy
  implements alvd, Handler.Callback
{
  aluz a;
  public alva a;
  public Handler a;
  public QQAppInterface a;
  public String a;
  public boolean a;
  public boolean b;
  
  public aluy(QQAppInterface paramQQAppInterface, aluz paramaluz, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Alva = ((alva)paramQQAppInterface.getManager(123));
    this.jdField_a_of_type_Aluz = paramaluz;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidOsHandler = new bhtd(Looper.getMainLooper(), this);
    if (QLog.isDevelopLevel()) {
      auwz.a("HotchatSCMng", "HotchatSCHelper", new Object[] { paramString, this.jdField_a_of_type_Aluz });
    }
  }
  
  public static long a()
  {
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    if (QLog.isColorLevel())
    {
      long l2 = System.currentTimeMillis();
      auwz.a("HotchatSCMng", new Object[] { "getCurTime", Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(Math.abs(l2 - l1)) });
    }
    return l1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Alva.b(this);
    if (alva.jdField_a_of_type_Boolean) {
      auwz.a("HotchatSCMng", "stopCheck", new Object[0]);
    }
  }
  
  public void a(long paramLong)
  {
    if (alva.jdField_a_of_type_Boolean) {
      auwz.a("HotchatSCMng", "startCheckDelay", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Long.valueOf(paramLong), Boolean.valueOf(this.jdField_a_of_type_Alva.b) });
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, paramLong);
  }
  
  public void b()
  {
    a();
    this.jdField_a_of_type_Aluz = null;
    if (alva.jdField_a_of_type_Boolean) {
      auwz.a("HotchatSCMng", "destroy", new Object[0]);
    }
  }
  
  public void b(long paramLong)
  {
    if (alva.jdField_a_of_type_Boolean) {
      auwz.a("HotchatSCMng", "startCheck", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Long.valueOf(paramLong), Boolean.valueOf(this.jdField_a_of_type_Alva.b) });
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Alva.b)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, paramLong);
    }
    for (;;)
    {
      this.jdField_a_of_type_Alva.a(this);
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
      paramMessage = this.jdField_a_of_type_Alva.a(this.jdField_a_of_type_JavaLangString, 0, l2);
      if (alva.jdField_a_of_type_Boolean) {
        auwz.a("HotchatSCMng", "MSG_GET_NOTE_TOSHOW", new Object[] { "cur", paramMessage });
      }
      if (this.jdField_a_of_type_Aluz != null) {
        if (paramMessage != null)
        {
          paramMessage.jdField_a_of_type_Boolean = this.jdField_a_of_type_Aluz.a(paramMessage);
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
        this.jdField_a_of_type_Aluz.a(null);
        break label87;
        if (!alva.jdField_a_of_type_Boolean) {
          break label87;
        }
        auwz.a("HotchatSCMng", "MSG_GET_NOTE_TOSHOW", new Object[] { "listener is null" });
        break label87;
      }
      paramMessage = this.jdField_a_of_type_Alva.a(this.jdField_a_of_type_JavaLangString, 2, l2);
      if (alva.jdField_a_of_type_Boolean) {
        auwz.a("HotchatSCMng", "MSG_GET_NOTE_TOSHOW", new Object[] { "next", paramMessage });
      }
      if (paramMessage != null)
      {
        l1 = Math.max(60000L, paramMessage.jdField_a_of_type_Long - l2);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, l1);
        return true;
      }
      this.jdField_a_of_type_Boolean = false;
      if (!alva.jdField_a_of_type_Boolean) {
        break;
      }
      auwz.a("HotchatSCMng", "MSG_GET_NOTE_TOSHOW", new Object[] { "stop check" });
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
 * Qualified Name:     aluy
 * JD-Core Version:    0.7.0.1
 */