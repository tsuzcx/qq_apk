import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPClientConnectListener;

class aled
  implements EIPClientConnectListener
{
  aled(aleb paramaleb, long paramLong) {}
  
  public void connectFailed()
  {
    aleb.a(this.jdField_a_of_type_Aleb, false);
    aleb.b(this.jdField_a_of_type_Aleb, false);
    synchronized (aleb.a(this.jdField_a_of_type_Aleb))
    {
      aleb.a(this.jdField_a_of_type_Aleb).notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("QWalletIPCConnector", 2, "connectFailed:" + aleb.a(this.jdField_a_of_type_Aleb));
      }
      return;
    }
  }
  
  public void connectSuccess(EIPCConnection arg1)
  {
    long l = System.currentTimeMillis();
    if (??? != null) {
      aleb.a(this.jdField_a_of_type_Aleb, ???.procName);
    }
    aleb.a(this.jdField_a_of_type_Aleb, true);
    aleb.b(this.jdField_a_of_type_Aleb, false);
    synchronized (aleb.a(this.jdField_a_of_type_Aleb))
    {
      aleb.a(this.jdField_a_of_type_Aleb).notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("QWalletIPCConnector", 2, "connectSuccess:" + aleb.a(this.jdField_a_of_type_Aleb) + "|" + (l - this.jdField_a_of_type_Long));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aled
 * JD-Core Version:    0.7.0.1
 */