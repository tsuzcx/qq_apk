import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.mobileqq.richmedia.ICallBack;
import com.tencent.mobileqq.richmedia.LOG;
import com.tencent.mobileqq.richmedia.RichmediaClient;
import com.tencent.util.BinderWarpper;

public class agsj
  implements ServiceConnection
{
  public agsj(RichmediaClient paramRichmediaClient) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    LOG.a("PTV.RichmediaClient", "onServiceConnected");
    this.a.b = new Messenger(paramIBinder);
    paramComponentName = Message.obtain(null, 1);
    paramComponentName.replyTo = this.a.jdField_a_of_type_AndroidOsMessenger;
    paramIBinder = new BinderWarpper(this.a.jdField_a_of_type_ComTencentMobileqqRichmediaICallBack.asBinder());
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("ICallBack_BinderWrapper", paramIBinder);
    paramComponentName.setData(localBundle);
    try
    {
      this.a.b.send(paramComponentName);
      return;
    }
    catch (RemoteException paramComponentName)
    {
      LOG.b("PTV.RichmediaClient", "MSG_C2S_REGISTER_CLIENT send failed. e = " + paramComponentName);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.a.b = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agsj
 * JD-Core Version:    0.7.0.1
 */