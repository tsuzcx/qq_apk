import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.jsbridge.GdtBaseHalfScreenFragmentForJs;
import com.tencent.gdtad.jsbridge.GdtCanvasFragmentForJS;
import com.tencent.gdtad.jsbridge.GdtVideoCeilingFragmentForJS;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class acgp
  implements acgx
{
  public boolean a(acfw paramacfw, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    if (paramacfw != null) {}
    GdtHandler.Params localParams;
    for (Activity localActivity = paramacfw.a();; localActivity = null)
    {
      localParams = new GdtHandler.Params();
      boolean bool = GdtHandler.a(localParams, paramVarArgs[0]);
      if ((paramacfw != null) && (localActivity != null) && (bool)) {
        break;
      }
      acho.d("GdtHandleAdJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    for (;;)
    {
      try
      {
        acho.b("GdtHandleAdJsCallHandler", new JSONObject(paramVarArgs[0]).toString());
        localParams.jdField_c_of_type_Int = 7;
        localParams.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localActivity);
        localParams.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramacfw.a());
        localParams.jdField_a_of_type_JavaLangClass = GdtVideoCeilingFragmentForJS.class;
        localParams.jdField_b_of_type_JavaLangClass = GdtCanvasFragmentForJS.class;
        localParams.jdField_c_of_type_JavaLangClass = GdtBaseHalfScreenFragmentForJs.class;
        paramVarArgs = paramacfw.a().getIntent();
        if (TextUtils.isEmpty(paramVarArgs.getStringExtra("big_brother_ref_source_key")))
        {
          paramVarArgs = paramVarArgs.getStringExtra("big_brother_source_key");
          localParams.jdField_a_of_type_AndroidOsBundle = new Bundle();
          localParams.jdField_a_of_type_AndroidOsBundle.putString("big_brother_ref_source_key", paramVarArgs);
          GdtHandler.a(localParams);
          paramacfw.callJs(paramString, null);
          paramString = localObject;
          if (paramacfw != null) {
            paramString = paramacfw.a();
          }
          AdReporterForAnalysis.reportForJSBridgeInvoked(localActivity, false, "handleClick", paramString, localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd);
          return true;
        }
      }
      catch (Throwable paramacfw)
      {
        acho.d("GdtHandleAdJsCallHandler", "handleJsCallRequest error", paramacfw);
        return true;
      }
      paramVarArgs = paramVarArgs.getStringExtra("big_brother_ref_source_key");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acgp
 * JD-Core Version:    0.7.0.1
 */