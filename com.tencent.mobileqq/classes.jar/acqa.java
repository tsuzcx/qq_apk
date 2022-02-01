import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.ad.tangram.ipc.AdIPCManager;
import com.tencent.ad.tangram.ipc.AdIPCManager.Callback;
import com.tencent.ad.tangram.ipc.AdIPCManager.Params;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.gdtad.api.interstitial.GdtInterstitialFragment;
import com.tencent.gdtad.api.interstitial.GdtInterstitialParams;
import com.tencent.gdtad.api.interstitial.GdtInterstitialStatus;
import java.lang.ref.WeakReference;

public final class acqa
{
  private AdIPCManager.Callback jdField_a_of_type_ComTencentAdTangramIpcAdIPCManager$Callback = new acqb(this);
  private GdtInterstitialParams jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public acqa(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams)
  {
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams = paramGdtInterstitialParams;
    acwf.a().a(paramContext, null);
    if (acqd.a().a(paramContext)) {
      acqg.a().b(paramContext);
    }
  }
  
  private GdtInterstitialParams a()
  {
    return this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams;
  }
  
  public void a(Activity paramActivity)
  {
    int i = 0;
    boolean bool;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      bool = false;
    }
    for (;;)
    {
      acvc.b("GdtInterstitialAd", String.format("close %b", new Object[] { Boolean.valueOf(bool) }));
      Object localObject = a();
      if (bool) {}
      for (;;)
      {
        acvp.b(paramActivity, (GdtInterstitialParams)localObject, i);
        return;
        if (!this.jdField_a_of_type_Boolean) {
          break label195;
        }
        if (this.b)
        {
          bool = false;
          break;
        }
        if (a() == null)
        {
          bool = false;
          break;
        }
        this.b = true;
        if (acqd.a().b(paramActivity)) {}
        for (localObject = AdProcessManager.INSTANCE.getMainProcessName();; localObject = AdProcessManager.INSTANCE.getWebProcessName())
        {
          Bundle localBundle = new Bundle();
          localBundle.putString("IPC_ACTION", "ipc_interstitial_close");
          localBundle.putString("IPC_TO_PROCESS_NAME", (String)localObject);
          localBundle.putString("TRACE_ID", a().a());
          AdIPCManager.INSTANCE.send(paramActivity, new AdIPCManager.Params(localBundle), new WeakReference(this.jdField_a_of_type_ComTencentAdTangramIpcAdIPCManager$Callback));
          bool = true;
          break;
        }
        i = 1;
      }
      label195:
      bool = false;
    }
  }
  
  public void a(Activity paramActivity, int paramInt, Intent paramIntent)
  {
    acvc.b("GdtInterstitialAd", "onClose");
    if (paramIntent == null) {}
    paramIntent = (GdtInterstitialStatus)paramIntent.getParcelableExtra("interstitialStatus");
    if (paramIntent == null) {}
    do
    {
      return;
      acvp.b(paramActivity, a(), paramIntent, paramInt);
    } while (this.c);
    try
    {
      if (this.c) {
        return;
      }
    }
    finally {}
    this.c = true;
    acvp.c(paramActivity, a(), paramIntent, paramInt);
  }
  
  public boolean a()
  {
    if ((!this.jdField_a_of_type_Boolean) && (a() != null)) {
      return a().b();
    }
    return false;
  }
  
  public boolean a(Activity paramActivity)
  {
    int i;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      i = 1;
    }
    for (;;)
    {
      acvc.b("GdtInterstitialAd", String.format("show %d", new Object[] { Integer.valueOf(i) }));
      acvp.a(paramActivity, a(), i);
      if (i != 0) {
        break;
      }
      return true;
      if (!a())
      {
        i = 1;
      }
      else
      {
        int j = GdtInterstitialFragment.a(paramActivity, a());
        i = j;
        if (j == 0)
        {
          this.jdField_a_of_type_Boolean = true;
          i = 0;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acqa
 * JD-Core Version:    0.7.0.1
 */