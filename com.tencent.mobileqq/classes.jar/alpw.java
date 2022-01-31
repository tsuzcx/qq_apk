import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ark;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.API.ArkAppNotifyCenter;
import com.tencent.mobileqq.ark.API.ArkAppNotifyCenter.ArkClickListener;
import com.tencent.mobileqq.ark.API.ArkAppNotifyCenter.GdtNotify.1;
import com.tencent.mobileqq.ark.API.ArkAppNotifyCenter.GdtNotify.2;
import com.tencent.mobileqq.ark.API.ArkAppNotifyCenter.GdtNotify.3;
import com.tencent.mobileqq.ark.API.ArkAppNotifyCenter.GdtNotify.4;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public class alpw
  implements alpy
{
  public ysr a;
  
  public boolean a(String paramString1, String paramString2, String paramString3)
  {
    if (paramString2.equals("ad_query_mute"))
    {
      ArkAppNotifyCenter.access$100(paramString1);
      return true;
    }
    if (paramString3 == null) {
      return false;
    }
    QLog.d("ark.ArkAppNotifyCenter", 1, "appname : " + paramString1 + "eventName : " + paramString2 + " params : " + paramString3, null);
    if (ArkAppNotifyCenter.arkClickListener != null) {
      ArkAppNotifyCenter.arkClickListener.onArkClick(paramString1, paramString2, paramString3);
    }
    if (paramString2.equals("ad_c2s_report")) {
      try
      {
        paramString1 = new JSONObject(paramString3);
        yxy.a(paramString1.getInt("op"), 0, (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(yxr.a(new qq_ad_get.QQAdGetRsp.AdInfo(), paramString1.getJSONObject("adInfo"))));
        QLog.d("ark.ArkAppNotifyCenter", 1, "report c2s end", null);
        return true;
      }
      catch (JSONException paramString1)
      {
        QLog.d("ark.ArkAppNotifyCenter", 1, paramString1, new Object[0]);
        return false;
      }
    }
    if (BaseActivity.sTopActivity == null)
    {
      QLog.d("ark.ArkAppNotifyCenter", 1, "top activity is null");
      return false;
    }
    Object localObject = new JSONObject();
    if (paramString2.equals("ad_query_cell_rect"))
    {
      ThreadManagerV2.getUIHandlerV2().post(new ArkAppNotifyCenter.GdtNotify.1(this, (JSONObject)localObject, paramString3, paramString1));
      return true;
    }
    WeakReference localWeakReference1 = new WeakReference(BaseActivity.sTopActivity);
    WeakReference localWeakReference2 = new WeakReference(BaseActivity.sTopActivity);
    if (paramString2.equals("ad_click")) {
      if (localWeakReference1 != null)
      {
        localObject = (Activity)localWeakReference1.get();
        AdReporterForAnalysis.reportForARKReceiveNotification((Context)localObject, false, paramString2, paramString1, null);
        ArkAppCenter.a().postToMainThread(new ArkAppNotifyCenter.GdtNotify.2(this, paramString3, localWeakReference1, paramString1));
        ark.arkNotify(paramString1, "ad_click_callback", paramString3, "json");
        if (localWeakReference1 == null) {
          break label330;
        }
        paramString2 = (Activity)localWeakReference1.get();
        label313:
        AdReporterForAnalysis.reportForARKSendNotification(paramString2, false, "ad_click_callback", paramString1, null);
      }
    }
    for (;;)
    {
      return true;
      localObject = null;
      break;
      label330:
      paramString2 = null;
      break label313;
      if (paramString2.equals("ad_request"))
      {
        boolean bool;
        if (!"com.tencent.yundong".equals(paramString1))
        {
          bool = true;
          label356:
          if (localWeakReference1 == null) {
            break label412;
          }
        }
        label412:
        for (localObject = (Activity)localWeakReference1.get();; localObject = null)
        {
          AdReporterForAnalysis.reportForARKReceiveNotification((Context)localObject, bool, paramString2, paramString1, null);
          ArkAppCenter.a().postToMainThread(new ArkAppNotifyCenter.GdtNotify.3(this, paramString1, localWeakReference1, bool, paramString3, localWeakReference2));
          break;
          bool = false;
          break label356;
        }
      }
      if (paramString2.equals("get_device_info"))
      {
        QLog.d("ark.ArkAppNotifyCenter", 1, "ark get_device_info", null);
        ArkAppCenter.a().post(paramString1, new ArkAppNotifyCenter.GdtNotify.4(this, localWeakReference2, paramString3, paramString1));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alpw
 * JD-Core Version:    0.7.0.1
 */