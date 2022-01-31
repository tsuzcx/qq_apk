import android.content.Context;
import android.os.Bundle;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.api.interstitial.GdtInterstitialPreDownloader.1;
import java.lang.ref.WeakReference;

public final class aaot
{
  private static volatile aaot jdField_a_of_type_Aaot;
  private volatile long jdField_a_of_type_Long = -2147483648L;
  private volatile aaoj jdField_a_of_type_Aaoj;
  private aaol jdField_a_of_type_Aaol = new aaov(this);
  private aaqs jdField_a_of_type_Aaqs = new aaou(this);
  
  public static aaot a()
  {
    if (jdField_a_of_type_Aaot == null) {}
    try
    {
      if (jdField_a_of_type_Aaot == null) {
        jdField_a_of_type_Aaot = new aaot();
      }
      return jdField_a_of_type_Aaot;
    }
    finally {}
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Aaoj != null) {
      return this.jdField_a_of_type_Aaoj.a();
    }
    return -2147483648;
  }
  
  public void a()
  {
    aase.b("GdtInterstitialPreDownloader", "preDownloadOnToolProcess");
    if (this.jdField_a_of_type_Aaoj == null) {
      synchronized (jdField_a_of_type_Aaot)
      {
        if (this.jdField_a_of_type_Aaoj == null)
        {
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          this.jdField_a_of_type_Aaoj = new aaoj(new WeakReference(this.jdField_a_of_type_Aaol), aaoq.a().a(), -2147483648L);
          aasr.a(BaseApplicationImpl.getApplication());
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
    aase.b("GdtInterstitialPreDownloader", String.format("preDownload", new Object[0]));
    paramContext = new Bundle();
    paramContext.putString("IPC_ACTION", "ipc_interstitial_predownload");
    paramContext.putString("IPC_TO_PROCESS_NAME", "com.tencent.mobileqq:tool");
    aaqp.a().a(BaseApplicationImpl.getContext(), new aaqw(paramContext), new WeakReference(this.jdField_a_of_type_Aaqs));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaot
 * JD-Core Version:    0.7.0.1
 */