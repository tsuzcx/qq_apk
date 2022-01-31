import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPClientConnectListener;

class ahch
  implements EIPClientConnectListener
{
  ahch(ahcf paramahcf, long paramLong) {}
  
  public void connectFailed()
  {
    ahcf.a(this.jdField_a_of_type_Ahcf, false);
    ahcf.b(this.jdField_a_of_type_Ahcf, false);
    synchronized (ahcf.a(this.jdField_a_of_type_Ahcf))
    {
      ahcf.a(this.jdField_a_of_type_Ahcf).notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("QWalletIPCConnector", 2, "connectFailed:" + ahcf.a(this.jdField_a_of_type_Ahcf));
      }
      return;
    }
  }
  
  public void connectSuccess(EIPCConnection arg1)
  {
    long l = System.currentTimeMillis();
    if (??? != null) {
      ahcf.a(this.jdField_a_of_type_Ahcf, ???.procName);
    }
    ahcf.a(this.jdField_a_of_type_Ahcf, true);
    ahcf.b(this.jdField_a_of_type_Ahcf, false);
    synchronized (ahcf.a(this.jdField_a_of_type_Ahcf))
    {
      ahcf.a(this.jdField_a_of_type_Ahcf).notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("QWalletIPCConnector", 2, "connectSuccess:" + ahcf.a(this.jdField_a_of_type_Ahcf) + "|" + (l - this.jdField_a_of_type_Long));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahch
 * JD-Core Version:    0.7.0.1
 */