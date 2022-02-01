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

public final class acme
{
  private static volatile acme jdField_a_of_type_Acme;
  private volatile long jdField_a_of_type_Long = -2147483648L;
  private volatile aclu jdField_a_of_type_Aclu;
  private aclw jdField_a_of_type_Aclw = new acmg(this);
  private AdIPCManager.Callback jdField_a_of_type_ComTencentAdTangramIpcAdIPCManager$Callback = new acmf(this);
  
  public static acme a()
  {
    if (jdField_a_of_type_Acme == null) {}
    try
    {
      if (jdField_a_of_type_Acme == null) {
        jdField_a_of_type_Acme = new acme();
      }
      return jdField_a_of_type_Acme;
    }
    finally {}
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Aclu != null) {
      return this.jdField_a_of_type_Aclu.a();
    }
    return -2147483648;
  }
  
  public void a()
  {
    acqy.b("GdtInterstitialPreDownloader", "preDownloadImpl");
    if (this.jdField_a_of_type_Aclu == null) {
      synchronized (jdField_a_of_type_Acme)
      {
        if (this.jdField_a_of_type_Aclu == null)
        {
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          this.jdField_a_of_type_Aclu = new aclu(new WeakReference(this.jdField_a_of_type_Aclw), acmb.a().a(), -2147483648L);
          acrl.a(BaseApplicationImpl.getApplication());
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
    acqy.b("GdtInterstitialPreDownloader", String.format("preDownload", new Object[0]));
    if (acmb.a().b(paramContext)) {}
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
 * Qualified Name:     acme
 * JD-Core Version:    0.7.0.1
 */