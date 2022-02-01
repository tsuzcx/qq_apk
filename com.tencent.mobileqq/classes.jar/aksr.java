import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPClientConnectListener;

class aksr
  implements EIPClientConnectListener
{
  aksr(aksp paramaksp, long paramLong) {}
  
  public void connectFailed()
  {
    aksp.a(this.jdField_a_of_type_Aksp, false);
    aksp.b(this.jdField_a_of_type_Aksp, false);
    synchronized (aksp.a(this.jdField_a_of_type_Aksp))
    {
      aksp.a(this.jdField_a_of_type_Aksp).notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("QWalletIPCConnector", 2, "connectFailed:" + aksp.a(this.jdField_a_of_type_Aksp));
      }
      return;
    }
  }
  
  public void connectSuccess(EIPCConnection arg1)
  {
    long l = System.currentTimeMillis();
    if (??? != null) {
      aksp.a(this.jdField_a_of_type_Aksp, ???.procName);
    }
    aksp.a(this.jdField_a_of_type_Aksp, true);
    aksp.b(this.jdField_a_of_type_Aksp, false);
    synchronized (aksp.a(this.jdField_a_of_type_Aksp))
    {
      aksp.a(this.jdField_a_of_type_Aksp).notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("QWalletIPCConnector", 2, "connectSuccess:" + aksp.a(this.jdField_a_of_type_Aksp) + "|" + (l - this.jdField_a_of_type_Long));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aksr
 * JD-Core Version:    0.7.0.1
 */