import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPClientConnectListener;

class aiwj
  implements EIPClientConnectListener
{
  aiwj(aiwh paramaiwh, long paramLong) {}
  
  public void connectFailed()
  {
    aiwh.a(this.jdField_a_of_type_Aiwh, false);
    aiwh.b(this.jdField_a_of_type_Aiwh, false);
    synchronized (aiwh.a(this.jdField_a_of_type_Aiwh))
    {
      aiwh.a(this.jdField_a_of_type_Aiwh).notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("QWalletIPCConnector", 2, "connectFailed:" + aiwh.a(this.jdField_a_of_type_Aiwh));
      }
      return;
    }
  }
  
  public void connectSuccess(EIPCConnection arg1)
  {
    long l = System.currentTimeMillis();
    if (??? != null) {
      aiwh.a(this.jdField_a_of_type_Aiwh, ???.procName);
    }
    aiwh.a(this.jdField_a_of_type_Aiwh, true);
    aiwh.b(this.jdField_a_of_type_Aiwh, false);
    synchronized (aiwh.a(this.jdField_a_of_type_Aiwh))
    {
      aiwh.a(this.jdField_a_of_type_Aiwh).notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("QWalletIPCConnector", 2, "connectSuccess:" + aiwh.a(this.jdField_a_of_type_Aiwh) + "|" + (l - this.jdField_a_of_type_Long));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiwj
 * JD-Core Version:    0.7.0.1
 */