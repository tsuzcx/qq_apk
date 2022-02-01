import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPClientConnectListener;

class akxp
  implements EIPClientConnectListener
{
  akxp(akxn paramakxn, long paramLong) {}
  
  public void connectFailed()
  {
    akxn.a(this.jdField_a_of_type_Akxn, false);
    akxn.b(this.jdField_a_of_type_Akxn, false);
    synchronized (akxn.a(this.jdField_a_of_type_Akxn))
    {
      akxn.a(this.jdField_a_of_type_Akxn).notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("QWalletIPCConnector", 2, "connectFailed:" + akxn.a(this.jdField_a_of_type_Akxn));
      }
      return;
    }
  }
  
  public void connectSuccess(EIPCConnection arg1)
  {
    long l = System.currentTimeMillis();
    if (??? != null) {
      akxn.a(this.jdField_a_of_type_Akxn, ???.procName);
    }
    akxn.a(this.jdField_a_of_type_Akxn, true);
    akxn.b(this.jdField_a_of_type_Akxn, false);
    synchronized (akxn.a(this.jdField_a_of_type_Akxn))
    {
      akxn.a(this.jdField_a_of_type_Akxn).notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("QWalletIPCConnector", 2, "connectSuccess:" + akxn.a(this.jdField_a_of_type_Akxn) + "|" + (l - this.jdField_a_of_type_Long));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akxp
 * JD-Core Version:    0.7.0.1
 */