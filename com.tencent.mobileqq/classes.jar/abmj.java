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
import org.json.JSONObject;

public final class abmj
{
  private AdIPCManager.Callback jdField_a_of_type_ComTencentAdTangramIpcAdIPCManager$Callback = new abmk(this);
  private GdtInterstitialParams jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public abmj(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams)
  {
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams = paramGdtInterstitialParams;
    absn.a().a(paramContext, null);
    abmp.a().b(paramContext);
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
      abrl.b("GdtInterstitialAd", String.format("close %b", new Object[] { Boolean.valueOf(bool) }));
      Object localObject = a();
      if (bool) {}
      for (;;)
      {
        absa.b(paramActivity, (GdtInterstitialParams)localObject, i);
        return;
        if (!this.jdField_a_of_type_Boolean) {
          break label170;
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
        localObject = new Bundle();
        ((Bundle)localObject).putString("IPC_ACTION", "ipc_interstitial_close");
        ((Bundle)localObject).putString("IPC_TO_PROCESS_NAME", AdProcessManager.INSTANCE.getWebProcessName());
        ((Bundle)localObject).putString("TRACE_ID", a().a());
        AdIPCManager.INSTANCE.send(paramActivity, new AdIPCManager.Params((Bundle)localObject), new WeakReference(this.jdField_a_of_type_ComTencentAdTangramIpcAdIPCManager$Callback));
        bool = true;
        break;
        i = 1;
      }
      label170:
      bool = false;
    }
  }
  
  public void a(Activity paramActivity, int paramInt, Intent paramIntent)
  {
    abrl.b("GdtInterstitialAd", "onClose");
    if (paramIntent == null) {}
    do
    {
      do
      {
        return;
        paramIntent = (GdtInterstitialStatus)paramIntent.getParcelableExtra("interstitialStatus");
      } while (paramIntent == null);
      absa.b(paramActivity, a(), paramIntent, paramInt);
    } while (this.c);
    try
    {
      if (this.c) {
        return;
      }
    }
    finally {}
    this.c = true;
    absa.c(paramActivity, a(), paramIntent, paramInt);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams != null) {
      this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.a = paramJSONObject;
    }
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
      abrl.b("GdtInterstitialAd", String.format("show %d", new Object[] { Integer.valueOf(i) }));
      absa.a(paramActivity, a(), i);
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
 * Qualified Name:     abmj
 * JD-Core Version:    0.7.0.1
 */