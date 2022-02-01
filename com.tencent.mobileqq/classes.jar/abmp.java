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

public final class abmp
{
  private static volatile abmp jdField_a_of_type_Abmp;
  private volatile long jdField_a_of_type_Long = -2147483648L;
  private volatile abmf jdField_a_of_type_Abmf;
  private abmh jdField_a_of_type_Abmh = new abmr(this);
  private AdIPCManager.Callback jdField_a_of_type_ComTencentAdTangramIpcAdIPCManager$Callback = new abmq(this);
  
  public static abmp a()
  {
    if (jdField_a_of_type_Abmp == null) {}
    try
    {
      if (jdField_a_of_type_Abmp == null) {
        jdField_a_of_type_Abmp = new abmp();
      }
      return jdField_a_of_type_Abmp;
    }
    finally {}
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Abmf != null) {
      return this.jdField_a_of_type_Abmf.a();
    }
    return -2147483648;
  }
  
  public void a()
  {
    abrl.b("GdtInterstitialPreDownloader", "preDownloadImpl");
    if (this.jdField_a_of_type_Abmf == null) {
      synchronized (jdField_a_of_type_Abmp)
      {
        if (this.jdField_a_of_type_Abmf == null)
        {
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          this.jdField_a_of_type_Abmf = new abmf(new WeakReference(this.jdField_a_of_type_Abmh), abmm.a().a(), -2147483648L);
          absa.a(BaseApplicationImpl.getApplication());
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
    abrl.b("GdtInterstitialPreDownloader", String.format("preDownload", new Object[0]));
    paramContext = new Bundle();
    paramContext.putString("IPC_ACTION", "ipc_interstitial_predownload");
    paramContext.putString("IPC_TO_PROCESS_NAME", AdProcessManager.INSTANCE.getWebProcessName());
    AdIPCManager.INSTANCE.send(BaseApplicationImpl.getContext(), new AdIPCManager.Params(paramContext), new WeakReference(this.jdField_a_of_type_ComTencentAdTangramIpcAdIPCManager$Callback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abmp
 * JD-Core Version:    0.7.0.1
 */