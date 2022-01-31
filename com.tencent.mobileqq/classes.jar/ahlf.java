import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mobileqq.richmedia.ICallBack;
import com.tencent.mobileqq.richmedia.LOG;
import com.tencent.mobileqq.richmedia.RichmediaService;

public final class ahlf
  implements Runnable
{
  public ahlf(int paramInt, Bundle paramBundle) {}
  
  public void run()
  {
    if (RichmediaService.jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService != null)
    {
      ICallBack localICallBack = RichmediaService.jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService.jdField_a_of_type_ComTencentMobileqqRichmediaICallBack;
      if (localICallBack != null) {
        try
        {
          LOG.a("RichmediaService", "sendICallBackRequest cb.sendRequest start . ");
          localICallBack.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidOsBundle);
          LOG.a("RichmediaService", "sendICallBackRequest cb.sendRequest finish. ");
          return;
        }
        catch (RemoteException localRemoteException)
        {
          LOG.a("RichmediaService", "sendICallBackRequest cb.sendRequest ipc fail, RemoteException : " + localRemoteException.getMessage());
          return;
        }
      }
      LOG.a("RichmediaService", "sendICallBackRequest service.mClientCallBack is null");
      return;
    }
    LOG.a("RichmediaService", "sendICallBackRequest Richmedia Service is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahlf
 * JD-Core Version:    0.7.0.1
 */