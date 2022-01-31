import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.api.GdtAd;
import com.tencent.gdtad.jsbridge.GdtCanvasFragmentForJS;
import com.tencent.gdtad.jsbridge.GdtVideoCeilingFragmentForJS;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet;

public abstract class aard
  extends PublicBaseFragment
{
  protected aane a;
  protected LinearLayout a;
  private GdtAppReceiver a;
  
  protected aard()
  {
    this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = new GdtAppReceiver();
    this.jdField_a_of_type_Aane = new aarg(this);
  }
  
  public static void a(Activity paramActivity, JSONObject paramJSONObject, Class<? extends aard> paramClass)
  {
    if ((paramActivity == null) || (paramJSONObject == null))
    {
      aase.b("GdtBaseBannerFragment", "start error");
      return;
    }
    aase.b("GdtBaseBannerFragment", "start");
    Bundle localBundle = new Bundle();
    localBundle.putString("params", paramJSONObject.toString());
    paramJSONObject = new Intent();
    paramJSONObject.putExtra("public_fragment_window_feature", 1);
    paramJSONObject.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
    paramJSONObject.putExtras(localBundle);
    adpn.a(paramActivity, paramJSONObject, PublicFragmentActivityForTool.class, paramClass);
  }
  
  protected abstract GdtAd a();
  
  protected abstract void a();
  
  protected abstract void a(String paramString, qq_ad_get.QQAdGet paramQQAdGet, GdtHandler.Params paramParams);
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity == null) {
      return;
    }
    paramActivity.getWindow().addFlags(1024);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = null;
    if (getArguments() == null) {
      return null;
    }
    paramViewGroup = getArguments().getString("params");
    try
    {
      Object localObject = new JSONObject(paramViewGroup);
      paramBundle = ((JSONObject)localObject).getJSONObject("requestParams");
      localObject = ((JSONObject)localObject).getJSONObject("clickParams");
      boolean bool1 = ((JSONObject)localObject).getBoolean("reportForClick");
      boolean bool2 = ((JSONObject)localObject).getBoolean("appAutoDownload");
      boolean bool3 = ((JSONObject)localObject).optBoolean("videoCeilingSupported", false);
      paramBundle = (qq_ad_get.QQAdGet)qq_ad_get.QQAdGet.class.cast(aasd.a(new qq_ad_get.QQAdGet(), paramBundle));
      localObject = new GdtHandler.Params();
      ((GdtHandler.Params)localObject).c = 1;
      ((GdtHandler.Params)localObject).jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(getActivity());
      ((GdtHandler.Params)localObject).jdField_a_of_type_Boolean = bool1;
      ((GdtHandler.Params)localObject).jdField_b_of_type_Boolean = bool2;
      ((GdtHandler.Params)localObject).jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver);
      if (bool3) {
        paramLayoutInflater = GdtVideoCeilingFragmentForJS.class;
      }
      ((GdtHandler.Params)localObject).jdField_a_of_type_JavaLangClass = paramLayoutInflater;
      ((GdtHandler.Params)localObject).jdField_b_of_type_JavaLangClass = GdtCanvasFragmentForJS.class;
      a(paramViewGroup, paramBundle, (GdtHandler.Params)localObject);
    }
    catch (JSONException paramLayoutInflater)
    {
      for (;;)
      {
        aase.d("GdtBaseBannerFragment", "createParams error", paramLayoutInflater);
      }
    }
    paramLayoutInflater = new Button(getActivity());
    paramLayoutInflater.setText("load");
    paramLayoutInflater.setOnClickListener(new aare(this));
    paramViewGroup = new Button(getActivity());
    paramViewGroup.setText("show");
    paramViewGroup.setOnClickListener(new aarf(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(getActivity());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(Color.parseColor("#DBDBDB"));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramLayoutInflater);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramViewGroup);
    paramLayoutInflater = new ScrollView(getActivity());
    paramLayoutInflater.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver.register(getActivity());
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver.unregister(getActivity());
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aard
 * JD-Core Version:    0.7.0.1
 */