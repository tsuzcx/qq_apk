import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPClientConnectListener;

class akbw
  implements EIPClientConnectListener
{
  akbw(akbu paramakbu, long paramLong) {}
  
  public void connectFailed()
  {
    akbu.a(this.jdField_a_of_type_Akbu, false);
    akbu.b(this.jdField_a_of_type_Akbu, false);
    synchronized (akbu.a(this.jdField_a_of_type_Akbu))
    {
      akbu.a(this.jdField_a_of_type_Akbu).notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("QWalletIPCConnector", 2, "connectFailed:" + akbu.a(this.jdField_a_of_type_Akbu));
      }
      return;
    }
  }
  
  public void connectSuccess(EIPCConnection arg1)
  {
    long l = System.currentTimeMillis();
    if (??? != null) {
      akbu.a(this.jdField_a_of_type_Akbu, ???.procName);
    }
    akbu.a(this.jdField_a_of_type_Akbu, true);
    akbu.b(this.jdField_a_of_type_Akbu, false);
    synchronized (akbu.a(this.jdField_a_of_type_Akbu))
    {
      akbu.a(this.jdField_a_of_type_Akbu).notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("QWalletIPCConnector", 2, "connectSuccess:" + akbu.a(this.jdField_a_of_type_Akbu) + "|" + (l - this.jdField_a_of_type_Long));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akbw
 * JD-Core Version:    0.7.0.1
 */