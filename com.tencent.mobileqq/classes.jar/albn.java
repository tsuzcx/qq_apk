import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.tencent.mobileqq.ar.ArConfigService;
import com.tencent.qphone.base.util.QLog;

public class albn
  implements alcm
{
  public albn(ArConfigService paramArConfigService) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (ArConfigService.b(this.a) != null) {
      try
      {
        int j = ArConfigService.b(this.a).beginBroadcast();
        int i = 0;
        for (;;)
        {
          if (i >= j) {
            break label106;
          }
          try
          {
            ((alee)ArConfigService.b(this.a).getBroadcastItem(i)).a(paramInt1, paramInt2);
            i += 1;
          }
          catch (RemoteException localRemoteException)
          {
            for (;;)
            {
              localRemoteException.printStackTrace();
            }
          }
        }
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArConfig_ArConfigService", 2, "FaceScanDownloadManager notify onProgress error:" + localException.getMessage());
        }
      }
    }
    label106:
    ArConfigService.b(this.a).finishBroadcast();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (ArConfigService.b(this.a) != null) {}
    for (;;)
    {
      int i;
      try
      {
        int j = ArConfigService.b(this.a).beginBroadcast();
        i = 0;
        if (i >= j) {
          break label129;
        }
        if (paramBoolean) {}
        try
        {
          ((alee)ArConfigService.b(this.a).getBroadcastItem(i)).a(paramInt);
        }
        catch (RemoteException localRemoteException)
        {
          localRemoteException.printStackTrace();
        }
        ((alee)ArConfigService.b(this.a).getBroadcastItem(i)).b(paramInt, 0);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArConfig_ArConfigService", 2, "FaceScanDownloadManager notify onFinish error:" + localException.getMessage());
        }
      }
      return;
      label129:
      ArConfigService.b(this.a).finishBroadcast();
      return;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     albn
 * JD-Core Version:    0.7.0.1
 */