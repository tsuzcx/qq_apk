import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPClientConnectListener;

class ajay
  implements EIPClientConnectListener
{
  ajay(ajaw paramajaw, long paramLong) {}
  
  public void connectFailed()
  {
    ajaw.a(this.jdField_a_of_type_Ajaw, false);
    ajaw.b(this.jdField_a_of_type_Ajaw, false);
    synchronized (ajaw.a(this.jdField_a_of_type_Ajaw))
    {
      ajaw.a(this.jdField_a_of_type_Ajaw).notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("QWalletIPCConnector", 2, "connectFailed:" + ajaw.a(this.jdField_a_of_type_Ajaw));
      }
      return;
    }
  }
  
  public void connectSuccess(EIPCConnection arg1)
  {
    long l = System.currentTimeMillis();
    if (??? != null) {
      ajaw.a(this.jdField_a_of_type_Ajaw, ???.procName);
    }
    ajaw.a(this.jdField_a_of_type_Ajaw, true);
    ajaw.b(this.jdField_a_of_type_Ajaw, false);
    synchronized (ajaw.a(this.jdField_a_of_type_Ajaw))
    {
      ajaw.a(this.jdField_a_of_type_Ajaw).notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("QWalletIPCConnector", 2, "connectSuccess:" + ajaw.a(this.jdField_a_of_type_Ajaw) + "|" + (l - this.jdField_a_of_type_Long));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajay
 * JD-Core Version:    0.7.0.1
 */