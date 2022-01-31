import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.ad.tangram.ark.AdArkAdapter;
import com.tencent.ad.tangram.ark.AdArkAdapter.ArkNotifyCallback;
import com.tencent.ad.tangram.ark.AdArkAdapter.Callback;
import com.tencent.ad.tangram.ark.AdArkAdapter.DataParams;
import com.tencent.ad.tangram.ark.AdArkAdapter.Params;
import com.tencent.gdtad.adapter.GdtArkViewAdapter.4;
import com.tencent.gdtad.adapter.GdtArkViewAdapter.5;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.ark.API.ArkAppNotifyCenter;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.ark_form_data.ArkFormData;
import tencent.gdt.ark_form_data.ArkFormData.FormInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DestInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

public class aahe
  implements ango, AdArkAdapter
{
  private View jdField_a_of_type_AndroidViewView;
  private AdArkAdapter.ArkNotifyCallback jdField_a_of_type_ComTencentAdTangramArkAdArkAdapter$ArkNotifyCallback;
  
  private afdt a(ArkAppView paramArkAppView, bdfk parambdfk)
  {
    afdt localafdt = new afdt();
    parambdfk.jdField_a_of_type_Afdt = localafdt;
    int i = paramArkAppView.getWidth();
    int j = paramArkAppView.getHeight();
    localafdt.a(parambdfk.jdField_a_of_type_JavaLangString, parambdfk.b, parambdfk.c, parambdfk.d, parambdfk.jdField_a_of_type_Float, parambdfk.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    localafdt.setFixSize(i, j);
    localafdt.setMaxSize(i, j);
    localafdt.setMinSize(i, j);
    return localafdt;
  }
  
  @SuppressLint({"NewApi"})
  private JSONObject a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    paramString1 = new JSONObject(paramString1);
    JSONArray localJSONArray1 = paramString1.getJSONObject("content").getJSONArray("modules");
    JSONArray localJSONArray2 = new JSONArray();
    int i = 0;
    for (;;)
    {
      if (i < localJSONArray1.length())
      {
        if (((JSONObject)localJSONArray1.get(i)).getString("id").equals(paramString2)) {
          localJSONArray2.put(localJSONArray1.get(i));
        }
      }
      else
      {
        do
        {
          localJSONArray1.remove(0);
        } while (localJSONArray1.length() > 0);
        localJSONArray1.put(localJSONArray2.get(0));
        return paramString1;
      }
      i += 1;
    }
  }
  
  private void a(ArkAppView paramArkAppView, AdArkAdapter.Params paramParams)
  {
    if ((paramParams == null) || (!paramParams.isValid())) {
      return;
    }
    float f = 0.0F;
    if (((Context)paramParams.context.get()).getResources().getDisplayMetrics() != null) {
      f = ((Context)paramParams.context.get()).getResources().getDisplayMetrics().scaledDensity;
    }
    String str1 = "com.tencent.xijing.form";
    String str2 = "form";
    if (!TextUtils.isEmpty(paramParams.appName)) {
      str1 = paramParams.appName;
    }
    if (!TextUtils.isEmpty(paramParams.viewName)) {
      str2 = paramParams.viewName;
    }
    paramArkAppView.initArkView(a(paramArkAppView, new bdfk(bdfk.a(str1, str2, "0.0.0.1", paramParams.metaData, f, null, null))), false);
    paramArkAppView.setVisibility(0);
  }
  
  private void a(ArkAppView paramArkAppView, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    float f2 = 0.0F;
    float f1 = f2;
    if (paramArkAppView.getContext() != null)
    {
      f1 = f2;
      if (paramArkAppView.getContext().getResources() != null)
      {
        f1 = f2;
        if (paramArkAppView.getContext().getResources().getDisplayMetrics() != null) {
          f1 = paramArkAppView.getContext().getResources().getDisplayMetrics().scaledDensity;
        }
      }
    }
    paramArkAppView.initArkView(a(paramArkAppView, new bdfk(bdfk.a(paramString1, paramString2, "0.0.0.1", paramString4, f1, null, null))), false);
    paramArkAppView.setVisibility(0);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3)
  {
    if (this.jdField_a_of_type_ComTencentAdTangramArkAdArkAdapter$ArkNotifyCallback != null) {
      return this.jdField_a_of_type_ComTencentAdTangramArkAdArkAdapter$ArkNotifyCallback.notify(paramString1, paramString2, paramString3);
    }
    return false;
  }
  
  public View buildArkView(AdArkAdapter.Params paramParams)
  {
    if ((paramParams != null) && (paramParams.isValid()))
    {
      AdArkAdapter.Callback localCallback = (AdArkAdapter.Callback)paramParams.callback.get();
      ArkAppView localArkAppView = new ArkAppView((Context)paramParams.context.get(), null);
      localArkAppView.setBorderType(0);
      localArkAppView.setCallback(new aahf(this, localCallback));
      localArkAppView.setOnTouchListener(localArkAppView);
      if ((paramParams.context.get() instanceof Activity))
      {
        FrameLayout localFrameLayout = (FrameLayout)((Activity)paramParams.context.get()).findViewById(16908290);
        if (localFrameLayout != null)
        {
          this.jdField_a_of_type_AndroidViewView = localFrameLayout.getChildAt(0);
          if (this.jdField_a_of_type_AndroidViewView != null) {
            this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new aahg(this, localCallback));
          }
        }
      }
      localArkAppView.setInputCallback(new aahh(this, localCallback));
      localArkAppView.post(new GdtArkViewAdapter.4(this, localArkAppView, paramParams));
      return localArkAppView;
    }
    return null;
  }
  
  public View buildSelectWindowArkView(AdArkAdapter.Params paramParams)
  {
    if (paramParams != null)
    {
      ArkAppView localArkAppView = new ArkAppView((Context)paramParams.context.get(), null);
      localArkAppView.setBorderType(0);
      localArkAppView.setOnTouchListener(localArkAppView);
      localArkAppView.post(new GdtArkViewAdapter.5(this, localArkAppView, paramParams));
      localArkAppView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      return localArkAppView;
    }
    return null;
  }
  
  public String getArkFormData(AdArkAdapter.DataParams paramDataParams)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject3;
    try
    {
      Object localObject4 = new ark_form_data.ArkFormData();
      localObject1 = localObject3;
      ((ark_form_data.ArkFormData)localObject4).ad_info.product_type.set(paramDataParams.product_type);
      localObject1 = localObject3;
      ((ark_form_data.ArkFormData)localObject4).ad_info.display_info.advertiser_info.advertiser_id.set(paramDataParams.advertiser_id);
      localObject1 = localObject3;
      ((ark_form_data.ArkFormData)localObject4).ad_info.report_info.landing_page_report_url.set(paramDataParams.landing_page_report_url);
      localObject1 = localObject3;
      ((ark_form_data.ArkFormData)localObject4).ad_info.report_info.trace_info.traceid.set(paramDataParams.traceid);
      localObject1 = localObject3;
      JSONObject localJSONObject = a(paramDataParams.canvas_json, paramDataParams.form_module_id);
      if (localJSONObject == null) {
        return null;
      }
      localObject1 = localObject3;
      ((ark_form_data.ArkFormData)localObject4).ad_info.dest_info.canvas_json.set(localJSONObject.toString());
      localObject1 = localObject3;
      ((ark_form_data.ArkFormData)localObject4).ad_info.dest_info.dest_type.set(paramDataParams.dest_type);
      localObject1 = localObject3;
      ((ark_form_data.ArkFormData)localObject4).form_info.form_module_id.set(paramDataParams.form_module_id);
      localObject1 = localObject3;
      ((ark_form_data.ArkFormData)localObject4).form_info.index.set(paramDataParams.index);
      localObject1 = localObject3;
      localObject4 = aano.a((PBField)localObject4);
      paramDataParams = (AdArkAdapter.DataParams)localObject2;
      if (localObject4 != null)
      {
        paramDataParams = (AdArkAdapter.DataParams)localObject2;
        localObject1 = localObject3;
        if ((localObject4 instanceof JSONObject))
        {
          localObject1 = localObject3;
          paramDataParams = localObject4.toString();
        }
      }
      localObject1 = paramDataParams;
      localObject2 = paramDataParams;
      if (!TextUtils.isEmpty(paramDataParams))
      {
        localObject1 = paramDataParams;
        localObject2 = new JSONObject();
        localObject1 = paramDataParams;
        ((JSONObject)localObject2).put("gdt", localObject4);
        localObject1 = paramDataParams;
        paramDataParams = ((JSONObject)localObject2).toString();
        return paramDataParams;
      }
    }
    catch (JSONException paramDataParams)
    {
      paramDataParams.printStackTrace();
      localObject2 = localObject1;
    }
    return localObject2;
  }
  
  public Rect getArkInputRect(View paramView)
  {
    if ((paramView != null) && ((paramView instanceof ArkAppView))) {
      return ((ArkAppView)paramView).getInputRect();
    }
    return null;
  }
  
  public void setNotify(WeakReference<AdArkAdapter.ArkNotifyCallback> paramWeakReference)
  {
    if ((paramWeakReference != null) && (paramWeakReference.get() != null))
    {
      this.jdField_a_of_type_ComTencentAdTangramArkAdArkAdapter$ArkNotifyCallback = ((AdArkAdapter.ArkNotifyCallback)paramWeakReference.get());
      ArkAppNotifyCenter.setNotify("com.tencent.xijing.form", new WeakReference(this));
      return;
    }
    this.jdField_a_of_type_ComTencentAdTangramArkAdArkAdapter$ArkNotifyCallback = null;
    ArkAppNotifyCenter.setNotify("com.tencent.xijing.form", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aahe
 * JD-Core Version:    0.7.0.1
 */