import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPClientConnectListener;

class agps
  implements EIPClientConnectListener
{
  agps(agpq paramagpq, long paramLong) {}
  
  public void connectFailed()
  {
    agpq.a(this.jdField_a_of_type_Agpq, false);
    agpq.b(this.jdField_a_of_type_Agpq, false);
    synchronized (agpq.a(this.jdField_a_of_type_Agpq))
    {
      agpq.a(this.jdField_a_of_type_Agpq).notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("QWalletIPCConnector", 2, "connectFailed:" + agpq.a(this.jdField_a_of_type_Agpq));
      }
      return;
    }
  }
  
  public void connectSuccess(EIPCConnection arg1)
  {
    long l = System.currentTimeMillis();
    if (??? != null) {
      agpq.a(this.jdField_a_of_type_Agpq, ???.procName);
    }
    agpq.a(this.jdField_a_of_type_Agpq, true);
    agpq.b(this.jdField_a_of_type_Agpq, false);
    synchronized (agpq.a(this.jdField_a_of_type_Agpq))
    {
      agpq.a(this.jdField_a_of_type_Agpq).notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("QWalletIPCConnector", 2, "connectSuccess:" + agpq.a(this.jdField_a_of_type_Agpq) + "|" + (l - this.jdField_a_of_type_Long));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agps
 * JD-Core Version:    0.7.0.1
 */