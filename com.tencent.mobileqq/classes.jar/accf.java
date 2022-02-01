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

public final class accf
{
  private static volatile accf jdField_a_of_type_Accf;
  private volatile long jdField_a_of_type_Long = -2147483648L;
  private volatile acbv jdField_a_of_type_Acbv;
  private acbx jdField_a_of_type_Acbx = new acch(this);
  private AdIPCManager.Callback jdField_a_of_type_ComTencentAdTangramIpcAdIPCManager$Callback = new accg(this);
  
  public static accf a()
  {
    if (jdField_a_of_type_Accf == null) {}
    try
    {
      if (jdField_a_of_type_Accf == null) {
        jdField_a_of_type_Accf = new accf();
      }
      return jdField_a_of_type_Accf;
    }
    finally {}
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Acbv != null) {
      return this.jdField_a_of_type_Acbv.a();
    }
    return -2147483648;
  }
  
  public void a()
  {
    acho.b("GdtInterstitialPreDownloader", "preDownloadImpl");
    if (this.jdField_a_of_type_Acbv == null) {
      synchronized (jdField_a_of_type_Accf)
      {
        if (this.jdField_a_of_type_Acbv == null)
        {
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          this.jdField_a_of_type_Acbv = new acbv(new WeakReference(this.jdField_a_of_type_Acbx), accc.a().a(), -2147483648L);
          acid.a(BaseApplicationImpl.getApplication());
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
    acho.b("GdtInterstitialPreDownloader", String.format("preDownload", new Object[0]));
    paramContext = new Bundle();
    paramContext.putString("IPC_ACTION", "ipc_interstitial_predownload");
    paramContext.putString("IPC_TO_PROCESS_NAME", AdProcessManager.INSTANCE.getWebProcessName());
    AdIPCManager.INSTANCE.send(BaseApplicationImpl.getContext(), new AdIPCManager.Params(paramContext), new WeakReference(this.jdField_a_of_type_ComTencentAdTangramIpcAdIPCManager$Callback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     accf
 * JD-Core Version:    0.7.0.1
 */