import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class acfw
  extends VasWebviewJsPlugin
{
  private GdtAppReceiver a;
  
  public acfw()
  {
    this.mPluginNameSpace = "qq_gdt_ad";
    if (a() != null) {}
    for (Object localObject = a();; localObject = BaseApplicationImpl.getApplication())
    {
      acim.a().a((Context)localObject, new acin());
      return;
    }
  }
  
  private void a()
  {
    if ((this.a != null) || (this.mRuntime == null)) {
      return;
    }
    acho.b("GdtAdWebPlugin", "registerReceiverForApp");
    this.a = new GdtAppReceiver();
    this.a.register(a());
  }
  
  private void b()
  {
    if ((this.a == null) || (this.mRuntime == null)) {
      return;
    }
    acho.b("GdtAdWebPlugin", "unregisterReceiverForApp");
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
    if (QLog.isColorLevel()) {
      QLog.i("GdtAdWebPlugin", 2, "method:" + paramString3);
    }
    try
    {
      paramString1 = new JSONObject(paramVarArgs[0]).optString("callback");
      if ("loadAdDemo".equals(paramString3))
      {
        paramJsBridgeListener = acfv.a().a(5);
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
        acho.d("GdtAdWebPlugin", "GdtAdWebPlugin handleJsCallRequest error ", paramString1);
        paramString1 = null;
        continue;
        if ("getLocation".equals(paramString3))
        {
          paramJsBridgeListener = acfv.a().a(4);
        }
        else if ("getDeviceId".equals(paramString3))
        {
          paramJsBridgeListener = acfv.a().a(7);
        }
        else if ("getCarrier".equals(paramString3))
        {
          paramJsBridgeListener = acfv.a().a(9);
        }
        else if ("getNetType".equals(paramString3))
        {
          paramJsBridgeListener = acfv.a().a(10);
        }
        else if ("getOSVersion".equals(paramString3))
        {
          paramJsBridgeListener = acfv.a().a(11);
        }
        else if ("handleClick".equals(paramString3))
        {
          a();
          paramJsBridgeListener = acfv.a().a(12);
        }
        else if ("showBanner".equals(paramString3))
        {
          paramJsBridgeListener = acfv.a().a(13);
        }
        else if ("showInterstitial".equals(paramString3))
        {
          paramJsBridgeListener = acfv.a().a(19);
        }
        else if ("showInterstitialForJS".equals(paramString3))
        {
          paramJsBridgeListener = acfv.a().a(20);
        }
        else if ("getDeviceInfo".equals(paramString3))
        {
          paramJsBridgeListener = acfv.a().a(14);
        }
        else if ("c2sReport".equals(paramString3))
        {
          paramJsBridgeListener = acfv.a().a(15);
        }
        else if ("openMotiveVideoAd".equals(paramString3))
        {
          paramJsBridgeListener = acfv.a().a(16);
        }
        else if ("getUserInfo".equals(paramString3))
        {
          paramJsBridgeListener = acfv.a().a(17);
        }
        else if ("preLoadAfterAdLoaded".equals(paramString3))
        {
          paramJsBridgeListener = acfv.a().a(18);
        }
        else if ("getCanvasJson".equals(paramString3))
        {
          paramJsBridgeListener = acfv.a().a(21);
        }
        else if ("getAdInfo".equals(paramString3))
        {
          paramJsBridgeListener = acfv.a().a(22);
        }
        else if ("handleRewardVideoClick".equals(paramString3))
        {
          paramJsBridgeListener = acfv.a().a(23);
        }
        else if ("launchAppWithDeeplink".equals(paramString3))
        {
          paramJsBridgeListener = acfv.a().a(24);
        }
        else if ("onVideoClose".equals(paramString3))
        {
          paramJsBridgeListener = acfv.a().a(25);
        }
        else if ("onVideoMute".equals(paramString3))
        {
          paramJsBridgeListener = acfv.a().a(26);
        }
        else if ("reportServerAnti".equals(paramString3))
        {
          paramJsBridgeListener = acfv.a().a(27);
        }
        else if ("showDeviceDemo".equals(paramString3))
        {
          paramJsBridgeListener = acfv.a().a(28);
        }
      }
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    acho.b("GdtAdWebPlugin", String.format("onActivityResult requestCode:%d resultCode:%d", new Object[] { Byte.valueOf(paramByte), Integer.valueOf(paramInt) }));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acfw
 * JD-Core Version:    0.7.0.1
 */