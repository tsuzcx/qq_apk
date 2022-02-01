import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.aio.AIOInputTypeHelper.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class afod
{
  public static volatile boolean a;
  public static boolean b;
  public static boolean c;
  private static boolean d;
  
  public static SharedPreferences a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences("sp_aio_input_helper_" + paramQQAppInterface.getAccount(), 0);
  }
  
  public static void a()
  {
    c = true;
    BaseApplication.getContext().getSharedPreferences("sp_upgrade", 0).edit().putBoolean("upgrade", true).commit();
  }
  
  /* Error */
  public static void a(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +11 -> 15
    //   7: getstatic 70	afod:d	Z
    //   10: istore_1
    //   11: iload_1
    //   12: ifeq +7 -> 19
    //   15: ldc 2
    //   17: monitorexit
    //   18: return
    //   19: aload_0
    //   20: invokestatic 72	afod:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Landroid/content/SharedPreferences;
    //   23: ldc 74
    //   25: iconst_1
    //   26: invokeinterface 78 3 0
    //   31: putstatic 80	afod:a	Z
    //   34: iconst_1
    //   35: putstatic 70	afod:d	Z
    //   38: goto -23 -> 15
    //   41: astore_0
    //   42: ldc 2
    //   44: monitorexit
    //   45: aload_0
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	paramQQAppInterface	QQAppInterface
    //   10	2	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   7	11	41	finally
    //   19	38	41	finally
  }
  
  @TargetApi(9)
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool1 = false;
    if (!d) {
      a(paramQQAppInterface);
    }
    if (a)
    {
      a = false;
      ThreadManager.getFileThreadHandler().post(new AIOInputTypeHelper.1(paramQQAppInterface));
      boolean bool2 = true;
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.aio.BaseChatPie", 2, "inputhelper : need guide");
        bool1 = bool2;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afod
 * JD-Core Version:    0.7.0.1
 */