import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPClientConnectListener;

class ahcf
  implements EIPClientConnectListener
{
  ahcf(ahcd paramahcd, long paramLong) {}
  
  public void connectFailed()
  {
    ahcd.a(this.jdField_a_of_type_Ahcd, false);
    ahcd.b(this.jdField_a_of_type_Ahcd, false);
    synchronized (ahcd.a(this.jdField_a_of_type_Ahcd))
    {
      ahcd.a(this.jdField_a_of_type_Ahcd).notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("QWalletIPCConnector", 2, "connectFailed:" + ahcd.a(this.jdField_a_of_type_Ahcd));
      }
      return;
    }
  }
  
  public void connectSuccess(EIPCConnection arg1)
  {
    long l = System.currentTimeMillis();
    if (??? != null) {
      ahcd.a(this.jdField_a_of_type_Ahcd, ???.procName);
    }
    ahcd.a(this.jdField_a_of_type_Ahcd, true);
    ahcd.b(this.jdField_a_of_type_Ahcd, false);
    synchronized (ahcd.a(this.jdField_a_of_type_Ahcd))
    {
      ahcd.a(this.jdField_a_of_type_Ahcd).notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("QWalletIPCConnector", 2, "connectSuccess:" + ahcd.a(this.jdField_a_of_type_Ahcd) + "|" + (l - this.jdField_a_of_type_Long));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahcf
 * JD-Core Version:    0.7.0.1
 */