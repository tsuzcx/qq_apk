import android.content.Context;
import android.os.Bundle;
import com.tencent.ad.tangram.ipc.AdIPCManager;
import com.tencent.ad.tangram.ipc.AdIPCManager.Callback;
import com.tencent.ad.tangram.ipc.AdIPCManager.Params;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.api.interstitial.GdtInterstitialPreDownloader.1;
import java.lang.ref.WeakReference;

public final class acqg
{
  private static volatile acqg jdField_a_of_type_Acqg;
  private volatile long jdField_a_of_type_Long = -2147483648L;
  private volatile acpw jdField_a_of_type_Acpw;
  private acpy jdField_a_of_type_Acpy = new acqi(this);
  private AdIPCManager.Callback jdField_a_of_type_ComTencentAdTangramIpcAdIPCManager$Callback = new acqh(this);
  
  public static acqg a()
  {
    if (jdField_a_of_type_Acqg == null) {}
    try
    {
      if (jdField_a_of_type_Acqg == null) {
        jdField_a_of_type_Acqg = new acqg();
      }
      return jdField_a_of_type_Acqg;
    }
    finally {}
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Acpw != null) {
      return this.jdField_a_of_type_Acpw.a();
    }
    return -2147483648;
  }
  
  public void a()
  {
    acvc.b("GdtInterstitialPreDownloader", "preDownloadImpl");
    if (this.jdField_a_of_type_Acpw == null) {
      synchronized (jdField_a_of_type_Acqg)
      {
        if (this.jdField_a_of_type_Acpw == null)
        {
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          this.jdField_a_of_type_Acpw = new acpw(new WeakReference(this.jdField_a_of_type_Acpy), acqd.a().a(), -2147483648L);
          acvp.a(BaseApplicationImpl.getApplication());
        }
        return;
      }
    }
  }
  
  public void a(Context paramContext)
  {
    paramContext = new WeakReference(paramContext);
    AdThreadManager.INSTANCE.postDelayed(new GdtInterstitialPreDownloader.1(this, paramContext), 4, 300000L);
  }
  
  public void b(Context paramContext)
  {
    acvc.b("GdtInterstitialPreDownloader", String.format("preDownload", new Object[0]));
    if (acqd.a().b(paramContext)) {}
    for (paramContext = AdProcessManager.INSTANCE.getMainProcessName();; paramContext = AdProcessManager.INSTANCE.getWebProcessName())
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("IPC_ACTION", "ipc_interstitial_predownload");
      localBundle.putString("IPC_TO_PROCESS_NAME", paramContext);
      AdIPCManager.INSTANCE.send(BaseApplicationImpl.getContext(), new AdIPCManager.Params(localBundle), new WeakReference(this.jdField_a_of_type_ComTencentAdTangramIpcAdIPCManager$Callback));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acqg
 * JD-Core Version:    0.7.0.1
 */