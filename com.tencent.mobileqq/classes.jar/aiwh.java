import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;

public class aiwh
{
  private static volatile aiwh jdField_a_of_type_Aiwh;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public static aiwh a()
  {
    if (jdField_a_of_type_Aiwh == null) {}
    try
    {
      if (jdField_a_of_type_Aiwh == null) {
        jdField_a_of_type_Aiwh = new aiwh();
      }
      return jdField_a_of_type_Aiwh;
    }
    finally {}
  }
  
  private void b()
  {
    this.b = true;
    if (QLog.isColorLevel()) {
      QLog.d("QWalletIPCConnector", 2, "begin connect:");
    }
    QIPCClientHelper.getInstance().getClient().addListener(new aiwi(this));
    long l = System.currentTimeMillis();
    QIPCClientHelper.getInstance().getClient().connect(new aiwj(this, l));
  }
  
  public void a()
  {
    if ((!this.jdField_a_of_type_Boolean) && (!this.b)) {
      b();
    }
    if (!this.jdField_a_of_type_Boolean) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        boolean bool = this.jdField_a_of_type_Boolean;
        if (!bool) {}
        try
        {
          this.jdField_a_of_type_JavaLangObject.wait(500L);
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiwh
 * JD-Core Version:    0.7.0.1
 */