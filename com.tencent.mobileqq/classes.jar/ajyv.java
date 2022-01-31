import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.HotchatSCHelper.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

public class ajyv
  implements ajza, Handler.Callback
{
  ajyw a;
  public ajyx a;
  public Handler a;
  public QQAppInterface a;
  public String a;
  public boolean a;
  public boolean b;
  
  public ajyv(QQAppInterface paramQQAppInterface, ajyw paramajyw, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Ajyx = ((ajyx)paramQQAppInterface.getManager(123));
    this.jdField_a_of_type_Ajyw = paramajyw;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidOsHandler = new bfob(Looper.getMainLooper(), this);
    if (QLog.isDevelopLevel()) {
      atbr.a("HotchatSCMng", "HotchatSCHelper", new Object[] { paramString, this.jdField_a_of_type_Ajyw });
    }
  }
  
  public static long a()
  {
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    if (QLog.isColorLevel())
    {
      long l2 = System.currentTimeMillis();
      atbr.a("HotchatSCMng", new Object[] { "getCurTime", Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(Math.abs(l2 - l1)) });
    }
    return l1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Ajyx.b(this);
    if (ajyx.jdField_a_of_type_Boolean) {
      atbr.a("HotchatSCMng", "stopCheck", new Object[0]);
    }
  }
  
  public void a(long paramLong)
  {
    if (ajyx.jdField_a_of_type_Boolean) {
      atbr.a("HotchatSCMng", "startCheckDelay", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Long.valueOf(paramLong), Boolean.valueOf(this.jdField_a_of_type_Ajyx.b) });
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, paramLong);
  }
  
  public void b()
  {
    a();
    this.jdField_a_of_type_Ajyw = null;
    if (ajyx.jdField_a_of_type_Boolean) {
      atbr.a("HotchatSCMng", "destroy", new Object[0]);
    }
  }
  
  public void b(long paramLong)
  {
    if (ajyx.jdField_a_of_type_Boolean) {
      atbr.a("HotchatSCMng", "startCheck", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Long.valueOf(paramLong), Boolean.valueOf(this.jdField_a_of_type_Ajyx.b) });
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Ajyx.b)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, paramLong);
    }
    for (;;)
    {
      this.jdField_a_of_type_Ajyx.a(this);
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
      paramMessage = this.jdField_a_of_type_Ajyx.a(this.jdField_a_of_type_JavaLangString, 0, l2);
      if (ajyx.jdField_a_of_type_Boolean) {
        atbr.a("HotchatSCMng", "MSG_GET_NOTE_TOSHOW", new Object[] { "cur", paramMessage });
      }
      if (this.jdField_a_of_type_Ajyw != null) {
        if (paramMessage != null)
        {
          paramMessage.jdField_a_of_type_Boolean = this.jdField_a_of_type_Ajyw.a(paramMessage);
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
        this.jdField_a_of_type_Ajyw.a(null);
        break label87;
        if (!ajyx.jdField_a_of_type_Boolean) {
          break label87;
        }
        atbr.a("HotchatSCMng", "MSG_GET_NOTE_TOSHOW", new Object[] { "listener is null" });
        break label87;
      }
      paramMessage = this.jdField_a_of_type_Ajyx.a(this.jdField_a_of_type_JavaLangString, 2, l2);
      if (ajyx.jdField_a_of_type_Boolean) {
        atbr.a("HotchatSCMng", "MSG_GET_NOTE_TOSHOW", new Object[] { "next", paramMessage });
      }
      if (paramMessage != null)
      {
        l1 = Math.max(60000L, paramMessage.jdField_a_of_type_Long - l2);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, l1);
        return true;
      }
      this.jdField_a_of_type_Boolean = false;
      if (!ajyx.jdField_a_of_type_Boolean) {
        break;
      }
      atbr.a("HotchatSCMng", "MSG_GET_NOTE_TOSHOW", new Object[] { "stop check" });
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
 * Qualified Name:     ajyv
 * JD-Core Version:    0.7.0.1
 */