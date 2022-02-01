import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import org.json.JSONObject;

public class acts
  extends VasWebviewJsPlugin
{
  private GdtAppReceiver a;
  
  public acts()
  {
    this.mPluginNameSpace = "qq_gdt_ad";
    if (a() != null) {}
    for (Object localObject = a();; localObject = BaseApplicationImpl.getApplication())
    {
      acwf.a().a((Context)localObject, new acwg());
      return;
    }
  }
  
  private void a()
  {
    if ((this.a != null) || (this.mRuntime == null)) {
      return;
    }
    acvc.b("GdtAdWebPlugin", "registerReceiverForApp");
    this.a = new GdtAppReceiver();
    this.a.register(a());
  }
  
  private void b()
  {
    if ((this.a == null) || (this.mRuntime == null)) {
      return;
    }
    acvc.b("GdtAdWebPlugin", "unregisterReceiverForApp");
    this.a.unregister(a());
    this.a = null;
  }
  
  public Activity a()
  {
    if (this.mRuntime != null) {}
    for (Activity localActivity1 = this.mRuntime.a();; localActivity1 = null)
    {
      Activity localActivity2 = localActivity1;
      if ((localActivity1 instanceof BasePluginActivity)) {
        localActivity2 = ((BasePluginActivity)BasePluginActivity.class.cast(localActivity1)).getOutActivity();
      }
      return localActivity2;
    }
  }
  
  public GdtAppReceiver a()
  {
    return this.a;
  }
  
  public String a()
  {
    Activity localActivity = a();
    if (localActivity == null) {}
    while (!(localActivity instanceof QQBrowserActivity)) {
      return null;
    }
    return ((QQBrowserActivity)QQBrowserActivity.class.cast(localActivity)).getCurrentUrl();
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    paramJsBridgeListener = null;
    try
    {
      paramString1 = new JSONObject(paramVarArgs[0]).optString("callback");
      if ("loadAdDemo".equals(paramString3))
      {
        paramJsBridgeListener = actr.a().a(5);
        if (paramJsBridgeListener != null) {
          paramJsBridgeListener.a(this, paramString1, paramVarArgs);
        }
        return true;
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        acvc.d("GdtAdWebPlugin", "GdtAdWebPlugin handleJsCallRequest error ", paramString1);
        paramString1 = null;
        continue;
        if ("getLocation".equals(paramString3))
        {
          paramJsBridgeListener = actr.a().a(4);
        }
        else if ("getDeviceId".equals(paramString3))
        {
          paramJsBridgeListener = actr.a().a(7);
        }
        else if ("getMacAddress".equals(paramString3))
        {
          paramJsBridgeListener = actr.a().a(8);
        }
        else if ("getCarrier".equals(paramString3))
        {
          paramJsBridgeListener = actr.a().a(9);
        }
        else if ("getNetType".equals(paramString3))
        {
          paramJsBridgeListener = actr.a().a(10);
        }
        else if ("getOSVersion".equals(paramString3))
        {
          paramJsBridgeListener = actr.a().a(11);
        }
        else if ("handleClick".equals(paramString3))
        {
          a();
          paramJsBridgeListener = actr.a().a(12);
        }
        else if ("showBanner".equals(paramString3))
        {
          paramJsBridgeListener = actr.a().a(13);
        }
        else if ("showInterstitial".equals(paramString3))
        {
          paramJsBridgeListener = actr.a().a(19);
        }
        else if ("showInterstitialForJS".equals(paramString3))
        {
          paramJsBridgeListener = actr.a().a(20);
        }
        else if ("getDeviceInfo".equals(paramString3))
        {
          paramJsBridgeListener = actr.a().a(14);
        }
        else if ("c2sReport".equals(paramString3))
        {
          paramJsBridgeListener = actr.a().a(15);
        }
        else if ("openMotiveVideoAd".equals(paramString3))
        {
          paramJsBridgeListener = actr.a().a(16);
        }
        else if ("getUserInfo".equals(paramString3))
        {
          paramJsBridgeListener = actr.a().a(17);
        }
        else if ("preLoadAfterAdLoaded".equals(paramString3))
        {
          paramJsBridgeListener = actr.a().a(18);
        }
        else if ("getCanvasJson".equals(paramString3))
        {
          paramJsBridgeListener = actr.a().a(21);
        }
        else if ("getAdInfo".equals(paramString3))
        {
          paramJsBridgeListener = actr.a().a(22);
        }
        else if ("handleRewardVideoClick".equals(paramString3))
        {
          paramJsBridgeListener = actr.a().a(23);
        }
        else if ("launchAppWithDeeplink".equals(paramString3))
        {
          paramJsBridgeListener = actr.a().a(24);
        }
      }
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    acvc.b("GdtAdWebPlugin", String.format("onActivityResult requestCode:%d resultCode:%d", new Object[] { Byte.valueOf(paramByte), Integer.valueOf(paramInt) }));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acts
 * JD-Core Version:    0.7.0.1
 */