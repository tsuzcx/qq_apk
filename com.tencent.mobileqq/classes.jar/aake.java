import android.content.Context;
import android.os.Bundle;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.api.interstitial.GdtInterstitialPreDownloader.1;
import java.lang.ref.WeakReference;

public final class aake
{
  private static volatile aake jdField_a_of_type_Aake;
  private volatile long jdField_a_of_type_Long = -2147483648L;
  private volatile aaju jdField_a_of_type_Aaju;
  private aajw jdField_a_of_type_Aajw = new aakg(this);
  private aamd jdField_a_of_type_Aamd = new aakf(this);
  
  public static aake a()
  {
    if (jdField_a_of_type_Aake == null) {}
    try
    {
      if (jdField_a_of_type_Aake == null) {
        jdField_a_of_type_Aake = new aake();
      }
      return jdField_a_of_type_Aake;
    }
    finally {}
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Aaju != null) {
      return this.jdField_a_of_type_Aaju.a();
    }
    return -2147483648;
  }
  
  public void a()
  {
    aanp.b("GdtInterstitialPreDownloader", "preDownloadOnToolProcess");
    if (this.jdField_a_of_type_Aaju == null) {
      synchronized (jdField_a_of_type_Aake)
      {
        if (this.jdField_a_of_type_Aaju == null)
        {
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          this.jdField_a_of_type_Aaju = new aaju(new WeakReference(this.jdField_a_of_type_Aajw), aakb.a().a(), -2147483648L);
          aaoc.a(BaseApplicationImpl.getApplication());
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
    aanp.b("GdtInterstitialPreDownloader", String.format("preDownload", new Object[0]));
    paramContext = new Bundle();
    paramContext.putString("IPC_ACTION", "ipc_interstitial_predownload");
    paramContext.putString("IPC_TO_PROCESS_NAME", "com.tencent.mobileqq:tool");
    aama.a().a(BaseApplicationImpl.getContext(), new aamh(paramContext), new WeakReference(this.jdField_a_of_type_Aamd));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aake
 * JD-Core Version:    0.7.0.1
 */