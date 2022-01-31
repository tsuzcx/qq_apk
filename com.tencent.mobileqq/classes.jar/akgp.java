import android.content.Context;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;

public class akgp
  implements INetEventHandler
{
  private Context jdField_a_of_type_AndroidContentContext;
  
  public akgp(akgo paramakgo)
  {
    this.jdField_a_of_type_AndroidContentContext = akgo.a(paramakgo);
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 23	akgp:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   6: aload_0
    //   7: invokestatic 32	com/tencent/mobileqq/msf/sdk/AppNetConnInfo:registerNetChangeReceiver	(Landroid/content/Context;Lcom/tencent/mobileqq/msf/sdk/handler/INetEventHandler;)V
    //   10: invokestatic 36	com/tencent/mobileqq/msf/sdk/AppNetConnInfo:isWifiConn	()Z
    //   13: ifeq +15 -> 28
    //   16: aload_0
    //   17: getfield 13	akgp:jdField_a_of_type_Akgo	Lakgo;
    //   20: iconst_1
    //   21: iconst_0
    //   22: invokevirtual 40	akgo:b	(ZI)V
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   31: ifeq -6 -> 25
    //   34: ldc 47
    //   36: iconst_2
    //   37: ldc 49
    //   39: invokestatic 53	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: goto -17 -> 25
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    //   50: astore_1
    //   51: goto -41 -> 10
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	akgp
    //   45	4	1	localObject	Object
    //   50	1	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	10	45	finally
    //   10	25	45	finally
    //   28	42	45	finally
    //   2	10	50	java/lang/Exception
  }
  
  public void b()
  {
    try
    {
      AppNetConnInfo.unregisterNetEventHandler(this);
      label7:
      this.jdField_a_of_type_Akgo.c();
      return;
    }
    catch (Exception localException)
    {
      break label7;
    }
    finally {}
  }
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    int i = badq.b(this.jdField_a_of_type_AndroidContentContext);
    if (i == 0) {
      if (akgo.a(this.jdField_a_of_type_Akgo)) {
        this.jdField_a_of_type_Akgo.e();
      }
    }
    do
    {
      return;
      if (i == 1)
      {
        if (!akgo.a(this.jdField_a_of_type_Akgo))
        {
          this.jdField_a_of_type_Akgo.b(true, 0);
          return;
        }
        this.jdField_a_of_type_Akgo.d();
        return;
      }
    } while ((i != 0) || (!akgo.a(this.jdField_a_of_type_Akgo)));
    this.jdField_a_of_type_Akgo.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akgp
 * JD-Core Version:    0.7.0.1
 */